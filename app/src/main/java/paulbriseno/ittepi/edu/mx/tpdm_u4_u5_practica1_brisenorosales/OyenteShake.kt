package paulbriseno.ittepi.edu.mx.tpdm_u4_u5_practica1_brisenorosales

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteShake (p:MainActivity): SensorEventListener {
    var puntero = p
    var lastUpdate: Long = 0

    var x = 0f
    var y = 0f
    var z = 0f
    var last_x = 0f
    var last_y = 0f
    var last_z = 0f

    var cont = 0
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var curTime: Long = System.currentTimeMillis()
        //solo permite una actualización cada 100 ms.
        if ((curTime - lastUpdate) > 100) {
            var diffTime = (curTime - lastUpdate)
            lastUpdate = curTime;

            x = event!!.values[0]
            y = event!!.values[1]
            z = event!!.values[2]

            var speed: Float = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > 800) {
                puntero.countShake++
                if (puntero.countShake == 4) puntero.countShake = 0
            }
            last_x = x
            last_y = y
            last_z = z
        }
    }
}

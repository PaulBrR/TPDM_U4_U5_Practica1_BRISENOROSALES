package paulbriseno.ittepi.edu.mx.tpdm_u4_u5_practica1_brisenorosales

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteAcelerometro (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
    override fun onSensorChanged(event: SensorEvent?) {
        puntero.x = event!!.values[0]
    }
}
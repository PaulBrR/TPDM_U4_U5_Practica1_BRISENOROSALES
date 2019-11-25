package paulbriseno.ittepi.edu.mx.tpdm_u4_u5_practica1_brisenorosales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager

class MainActivity : AppCompatActivity() {
                                                // Iconos divertidos
    var sensorManager: SensorManager?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteAcelerometro : OyenteAcelerometro ?= null
    var oyenteShake : OyenteShake ?= null

    var x = 0f

    var countShake = 0

    var distancia = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        oyenteProximidad = OyenteProximidad(this)
        oyenteAcelerometro = OyenteAcelerometro(this)

        oyenteShake = OyenteShake(this)

        sensorManager?.registerListener(oyenteProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_UI)

        sensorManager?.registerListener(oyenteAcelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager?.registerListener(oyenteShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME)


    }
}

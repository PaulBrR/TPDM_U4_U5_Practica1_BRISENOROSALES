package paulbriseno.ittepi.edu.mx.tpdm_u4_u5_practica1_brisenorosales

import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList

class Lienzo(p:MainActivity): View(p) {
    var puntero = p
//Antiguos
    var ico1_ant = Imagen(this,-20f,650f,R.drawable.iconfinder_instagram)
    var ico2_ant = Imagen(this,200f,250f,R.drawable.iconfinder_twitter)
    var ico3_ant = Imagen(this,360f,650f,R.drawable.iconfinder_whatsapp)
    var ico4_ant = Imagen(this,600f,250f,R.drawable.iconfinder_youtube)
    var ico5_ant = Imagen(this,720f,650f,R.drawable.iconfinder_facebook)
//Normales
    var ico1 = Imagen(this,-20f,650f,R.drawable.icono1)
    var ico2 = Imagen(this,200f,250f,R.drawable.icono2)
    var ico3 = Imagen(this,360f,650f,R.drawable.icono3)
    var ico4 = Imagen(this,600f,250f,R.drawable.icono4)
    var ico5 = Imagen(this,720f,650f,R.drawable.icono5)
//Blanco&Negro
    var ico1_bn = Imagen(this,-20f,650f,R.drawable.bn_icono1)
    var ico2_bn = Imagen(this,200f,250f,R.drawable.bn_icono2)
    var ico3_bn = Imagen(this,360f,650f,R.drawable.bn_icono3)
    var ico4_bn = Imagen(this,600f,250f,R.drawable.bn_icono4)
    var ico5_bn = Imagen(this,720f,650f,R.drawable.bn_icono5)
//Vintage
    var ico1_vintage = Imagen(this,-20f,650f,R.drawable.vicono1)
    var ico2_vintage = Imagen(this,200f,250f,R.drawable.vicono2)
    var ico3_vintage = Imagen(this,360f,650f,R.drawable.vicono3)
    var ico4_vintage = Imagen(this,600f,250f,R.drawable.vicono4)
    var ico5_vintage = Imagen(this,720f,650f,R.drawable.vicono5)

    var arrayImg_ant = arrayListOf<Imagen>(ico1_ant,ico2_ant,ico3_ant,ico4_ant,ico5_ant)
    var arrayImg2 = arrayListOf<Imagen>(ico1,ico2,ico3,ico4,ico5)
    var arrayImg3_bn = arrayListOf<Imagen>(ico1_bn,ico2_bn,ico3_bn,ico4_bn,ico5_bn)
    var arrayImg4_vintage = arrayListOf<Imagen>(ico1_vintage,ico2_vintage,ico3_vintage,ico4_vintage,ico5_vintage)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"Oculto", Toast.LENGTH_SHORT).show()
        }
        else{
            when (puntero.countShake) {
                0 -> {
                    drawImgs(arrayImg_ant, c)
                    moverImagenes(arrayImg_ant, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2, c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3_bn, c)
                    moverImagenes(arrayImg3_bn, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4_vintage, c)
                    moverImagenes(arrayImg4_vintage, puntero.x)
                }
            }

        }

    }//DRAW

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(ico1_ant.estaEnArea(e.getX(),e.getY())||
                    ico1.estaEnArea(e.getX(),e.getY())||
                    ico1_bn.estaEnArea(e.getX(),e.getY())||
                    ico1_vintage.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero," Icono Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = ico1_ant

                }
                if(ico2_ant.estaEnArea(e.getX(),e.getY())||
                    ico2.estaEnArea(e.getX(),e.getY())||
                    ico2_bn.estaEnArea(e.getX(),e.getY())||
                    ico2_vintage.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Icono Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = ico2_ant
                }
                if(ico3_ant.estaEnArea(e.getX(),e.getY())||
                    ico3.estaEnArea(e.getX(),e.getY())||
                    ico3_bn.estaEnArea(e.getX(),e.getY())||
                    ico3_vintage.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Icono WhatsApp", Toast.LENGTH_SHORT)
                        .show()
                    picono = ico3_ant
                }
                if(ico4_ant.estaEnArea(e.getX(),e.getY())||
                    ico4.estaEnArea(e.getX(),e.getY())||
                    ico4_bn.estaEnArea(e.getX(),e.getY())||
                    ico4_vintage.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Icono Youtube", Toast.LENGTH_SHORT)
                        .show()
                    picono = ico4_ant
                }
                if(ico5_ant.estaEnArea(e.getX(),e.getY())||
                    ico5.estaEnArea(e.getX(),e.getY())||
                    ico5_bn.estaEnArea(e.getX(),e.getY())||
                    ico5_vintage.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Icono Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = ico5_ant
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }//TOUCH

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>, x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }


    fun drawImgs(arrayImagenes: ArrayList<Imagen>, c: Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }

}
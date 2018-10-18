package com.tranvuongquyenphong

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Point
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.system.Os.bind
import android.view.Display
import android.view.View
import android.view.animation.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.wajahatkarim3.easyflipview.EasyFlipView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var imv: ImageView
    private lateinit var imgRocket : ImageView
    private lateinit var imvAvatar: ImageView
    private lateinit var aniRocket: Animation
    private lateinit var aniRocket2: Animation
    private lateinit var title_alpha: Animation
    private lateinit var title_scale: Animation
    private lateinit var success_send : Animation
    private lateinit var line_rocket :Animation
    private lateinit var aniTitle: Animation
    private lateinit var title : LinearLayout
    private lateinit var viewSendSucced: LinearLayout
    private lateinit var lineRocket: TextView
    private lateinit var textGoHome: TextView
    private lateinit var txtFireMoney: TextView
    private lateinit var easyFlipView: EasyFlipView
    private lateinit var springAnimation: SpringAnimation
    lateinit var springForce: SpringForce
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
            setContentView(R.layout.main_activity)
//        aniRocket = AnimationUtils.loadAnimation(this,R.anim.rocket_movetop)
        addControls()
        setAnimation()
//        val springAni = SpringAnimation()
        imgRocket = findViewById(R.id.imgRocket)



        val rotateAnimation = RotateAnimation(
                0f, 359f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f

        )
        rotateAnimation.duration = 300
        rotateAnimation.repeatCount = 2

        val translateTitle = TranslateAnimation(0f, 0f, 0f, -300f)
        translateTitle.duration = 3000
        translateTitle.fillAfter = true
        var anticipateOvershootInterpolator= AnticipateOvershootInterpolator(5f)
        val transAnimation = ObjectAnimator.ofFloat(imgRocket, "translationY", 0f, -2000f)
//        transAnimation.setInterpolator(anticipateOvershootInterpolator) //go down a litle
//        transAnimation.interpolator()
//        transAnimation.setRepeatCount(i);
        transAnimation.setDuration(1500)
        aniRocket = AnimationUtils.loadAnimation(this, R.anim.rocket_movetop)
        aniRocket.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {



            }

            override fun onAnimationStart(animation: Animation?) {
//                lineRocket.visibility = View.INVISIBLE
                Handler().postDelayed({
                    title.startAnimation(aniTitle)
                }, 300)
                Handler().postDelayed({
                    easyFlipView.flipTheView()
                    viewSendSucced.visibility = View.VISIBLE
                    viewSendSucced.startAnimation(success_send)
                    textGoHome.visibility = View.VISIBLE
                    txtFireMoney.visibility = View.INVISIBLE
                }, 400)
                Handler().postDelayed({
                    lineRocket.startAnimation(line_rocket)
                },100)
//                title.startAnimation(translateTitle)
//                title.startAnimation(title_alpha)
//                title.startAnimation(title_scale)
            }

        })
        aniRocket2.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })
        imgRocket.setOnClickListener{
            imgRocket.startAnimation(aniRocket)
//            imgRocket.startAnimation(aniRocket2)
//            val set: AnimationSet
//            set.
//            set.start()

            transAnimation.start()

//            springAnimation = SpringAnimation(imgRocket,DynamicAnimation.TRANSLATION_Y, -1000f)
//            springAnimation.spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
//            springAnimation.spring.setStiffness(SpringForce.STIFFNESS_VERY_LOW)
//            springAnimation.setStartVelocity(-200f)
//            springAnimation.start()

        }
        aniTitle = AnimationUtils.loadAnimation(this@MainActivity, R.anim.title_scale_movetop)
        imvAvatar = findViewById(R.id.imageAvatar)
        title = findViewById(R.id.viewTitle)


        addEvents()


    }

    private fun setAnimation() {
        title_alpha = AnimationUtils.loadAnimation(this@MainActivity, R.anim.title_alpha)
        title_scale =  AnimationUtils.loadAnimation(this@MainActivity, R.anim.title_scale_movetop)
        success_send = AnimationUtils.loadAnimation(this@MainActivity, R.anim.success_send)
        aniRocket2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.rocket_movetop2)
        line_rocket = AnimationUtils.loadAnimation(this@MainActivity, R.anim.line_rocket)

    }

    private fun addControls() {
        viewSendSucced = findViewById(R.id.viewSendSucced)
        lineRocket = findViewById(R.id.lineRockett)
        textGoHome = findViewById(R.id.textGoHome)
        txtFireMoney = findViewById(R.id.txtFireMoney)
        easyFlipView =findViewById(R.id.easyFlipView)
        imgRocket = findViewById(R.id.imgRocket)
        var display: Display = getWindowManager().getDefaultDisplay()
        var size : Point = Point()
        display.getSize(size)
        Toast.makeText(this,"width: "+size.x.toString(),Toast.LENGTH_LONG ).show()
        Toast.makeText(this,"Height: "+size.y.toString(),Toast.LENGTH_LONG ).show()
    }

    private fun addEvents() {
    }
}



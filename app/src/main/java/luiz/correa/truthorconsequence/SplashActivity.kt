package luiz.correa.truthorconsequence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.RotateAnimation
import luiz.correa.truthorconsequence.databinding.ActivityPieChartBinding
import luiz.correa.truthorconsequence.databinding.ActivitySplashBinding
import java.util.concurrent.ThreadLocalRandom

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()


        Handler(Looper.getMainLooper()).postDelayed({openMainActivity()}, 1500)
    }

    private fun openMainActivity() {
        startActivity(Intent(this, ListActivity::class.java))
        finish()
    }



}
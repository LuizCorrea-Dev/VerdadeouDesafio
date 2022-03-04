package luiz.correa.truthorconsequence

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ir.mahozad.android.PieChart
import luiz.correa.truthorconsequence.databinding.ActivityPieChartBinding
import java.util.concurrent.ThreadLocalRandom


class PieChartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPieChartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPieChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        game()
        Chart()
    }

    private fun game() {
        // pegando a garrafa e última direção
        val bottle = binding.ivBottle
        var lastDirection = 0

        bottle.setOnClickListener{

            // nova direção com número aleatório
            val newDirection  = ThreadLocalRandom.current().nextInt(3000)

            // pegando a posição X e Y da garrafa
            val orientationX = bottle.width / 2
            val orientationY = bottle.height / 2

            //configurações de animação de rotação
            val rotate  = RotateAnimation(
                lastDirection.toFloat(),
                newDirection.toFloat(),
                orientationX.toFloat(),
                orientationY.toFloat()
            )
            rotate.duration = 1800
            rotate.fillAfter = true

            // definindo a última direção com a direção atual
            lastDirection = newDirection

            //iniciando a animação
            bottle.startAnimation(rotate)

            Handler(Looper.getMainLooper()).postDelayed({
                Log.e("garrafa","parou?")
                binding.popup.isVisible = true
            }, 4000)

            binding.popup.setOnClickListener {
                binding.popup.isVisible = false
            }
        }
    }



    private fun Chart() {
        var items = 0
        val arrayList = intent.getStringArrayListExtra("arrayList")

        if (arrayList?.get(0).toString() != "") items++
        if (arrayList?.get(1).toString() != "") items++
        if (arrayList?.get(2).toString() != "") items++
        if (arrayList?.get(3).toString() != "") items++
        if (arrayList?.get(4).toString() != "") items++
        if (arrayList?.get(5).toString() != "") items++
        if (arrayList?.get(6).toString() != "") items++
        if (arrayList?.get(7).toString() != "") items++
        if (arrayList?.get(8).toString() != "") items++
        if (arrayList?.get(9).toString() != "") items++

        val fraction: Double = 1.0 / items
        val pieChart = findViewById<PieChart>(R.id.pieChart)

        pieChart.apply {
            slices = listOf(
                PieChart.Slice(fraction.toFloat(), Color.rgb(249,236,43),label = arrayList?.get(0).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(248,193,33), label = arrayList?.get(1).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(242,147,47),label = arrayList?.get(2).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(239,100,48),label = arrayList?.get(3).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(235,42,46),label = arrayList?.get(4).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(179,49,139), label = arrayList?.get(5).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(180,50,147),label = arrayList?.get(6).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(142,49,147),label = arrayList?.get(7).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(50,59,151),label = arrayList?.get(8).toString()),
                PieChart.Slice(fraction.toFloat(), Color.rgb(0,175,200), label = arrayList?.get(9).toString()),
            )
            labelIconsTint = Color.BLUE // cor do icone
            startAngle = -90
            isLegendEnabled = false
            labelType = PieChart.LabelType.INSIDE
            // labelIconsPlacement = PieChart.IconPlacement.TOP
            // gradientType = PieChart.GradientType.SWEEP
            holeRatio = 0f // preenchimento docentro do disco
            overlayRatio = 0.0f // sombra interna  do disco
        }
    }
}


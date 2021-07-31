package com.example.tipscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.mainActivityCalculateButton.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.mainActivityCostOfService.text.toString()
        val cost = stringInTextField.toDouble()

        val tipPercentage = when (binding.mainActivityTipOptions.checkedRadioButtonId) {
            R.id.mainActivity_option_eight_percent -> 0.08
            R.id.mainActivity_option_fifteen_percent -> 0.15
            else -> 0.20
        }
        var tip= tipPercentage * cost
        if(binding.mainActivityRoundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.mainActivityTipResult.text = getString(R.string.mainActivity_tip_amount, formattedTip)
    }


}

package com.example.calculatorkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorkotlin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        userClick()
        userOperators()

    }

    private fun userClick() {
        with(binding) {
            tvOne.setOnClickListener {
                evaluateOfExpression("1", clear = true)
            }

            tvTwo.setOnClickListener {
                evaluateOfExpression("2", clear = true)
            }

            tvThree.setOnClickListener {
                evaluateOfExpression("3", clear = true)
            }
            tvFour.setOnClickListener {
                evaluateOfExpression("4", clear = true)
            }

            tvFive.setOnClickListener {
                evaluateOfExpression("5", clear = true)
            }

            tvSix.setOnClickListener {
                evaluateOfExpression("6", clear = true)
            }

            tvSeven.setOnClickListener {
                evaluateOfExpression("7", clear = true)
            }

            tvEight.setOnClickListener {
                evaluateOfExpression("8", clear = true)
            }

            tvNine.setOnClickListener {
                evaluateOfExpression("9", clear = true)
            }

            tvZero.setOnClickListener {
                evaluateOfExpression("0", clear = true)
            }

        }
    }

    private fun userOperators() {
        with(binding) {
            tvPlus.setOnClickListener {
                evaluateOfExpression("+", clear = true)
            }

            tvMinus.setOnClickListener {
                evaluateOfExpression("-", clear = true)
            }

            tvMul.setOnClickListener {
                evaluateOfExpression("*", clear = true)
            }

            tvDivide.setOnClickListener {
                evaluateOfExpression("/", clear = true)
            }

            tvDot.setOnClickListener {
                evaluateOfExpression(".", clear = true)
            }

            tvClear.setOnClickListener {
                tvExpression.text = ""
                tvResult.text = ""
            }

            tvEquals.setOnClickListener {
                try {
                    val text = tvExpression.text.toString()
                    val expression = ExpressionBuilder(text).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        tvResult.text = longResult.toString()
                    } else {
                        tvResult.text = result.toString()

                    }
                } catch (e: Exception) {
                    Log.d("@@@", " message : " + e.message)

                }


            }
            tvBack.setOnClickListener {
                val text = tvExpression.text.toString()
                if (text.isNotEmpty()) {
                    tvExpression.text = text.drop(1)
                }
                tvResult.text = ""
            }
        }
    }

    private fun evaluateOfExpression(str: String, clear: Boolean) {
        with(binding) {
            if (clear) {
                tvResult.text = ""
                tvExpression.append(str)
            }else{
                tvExpression.append(tvResult.text)
                tvExpression.append(str)
                tvResult.text = ""
            }
        }


    }
}
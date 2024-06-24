package com.saulhervas.calculatorkidsapp.ui.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.saulhervas.calculatorkidsapp.R
import com.saulhervas.calculatorkidsapp.databinding.FragmentAdditionBinding
import kotlin.random.Random


class AdditionFragment : Fragment() {

    private lateinit var binding: FragmentAdditionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdditionBinding.inflate(inflater, container, false)

        generateNewNumbers()

        binding.btnCalculate.setOnClickListener {
            val num1 = binding.tvNum1.text.toString().toInt()
            val num2 = binding.tvNum2.text.toString().toInt()
            val result = addition(num1, num2)

            val userInput = binding.tvResult.text.toString()
            if (userInput.isNotEmpty()) {
                try {
                    val userResult = userInput.toInt()

                    if (result == userResult) {
                        findNavController().navigate(R.id.action_additionFragment_to_checkSplash)
                    } else {
                        findNavController().navigate(R.id.action_additionFragment_to_failSplash)
                    }
                    generateNewNumbers()
                    hideKeyboard()
                } catch (e: NumberFormatException) {
                    findNavController().navigate(R.id.action_additionFragment_to_failSplash)
                }
            } else {
                findNavController().navigate(R.id.action_additionFragment_to_failSplash)
            }
        }

        binding.imageButton.setOnClickListener {
            findNavController().navigate(R.id.action_additionFragment_to_mainFragment)
        }
        return binding.root
    }

    private fun generateNewNumbers() {
        val num1 = Random.nextInt(0, 20)
        val num2 = Random.nextInt(0, 10)
        binding.tvNum1.text = num1.toString()
        binding.tvNum2.text = num2.toString()

        binding.tvResult.text.clear()
    }

    fun addition(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    private fun hideKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }



}
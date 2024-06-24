package com.saulhervas.calculatorkidsapp.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.saulhervas.calculatorkidsapp.R


class CheckSplash : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(4000, 2000) {
            override fun onTick(millisUntilFinished: Long) = Unit

            override fun onFinish() {
                findNavController().popBackStack()
            }
        }.start()
    }


}
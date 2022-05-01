package com.example.leakexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment: Fragment() {

    private lateinit var counterTextView: TextView
    private var currentCounterValue = 0
    private val handler = Handler(Looper.getMainLooper())

    private val counterRunnable = object : Runnable {
        override fun run() {
            currentCounterValue+=1
            counterTextView.setText(currentCounterValue.toString())

            firstMethod("First method")
            secondMethod("Second method")
            fifthMethod("Fifth method")

            handler.postDelayed(this, 1000)
        }
    }

    private fun firstMethod(text: String) {
        Log.d("######", "Call first method")
    }

    private fun secondMethod(text: String) {
        Log.d("######", "Call second method")
    }

    private fun fifthMethod(text: String) {
        Log.d("######", "Fifth method called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.counter_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("#####", "Counter fragment created")

        counterTextView = view.findViewById(R.id.counter_text)
    }

    override fun onResume() {
        super.onResume()

        handler.post(counterRunnable)
    }
}
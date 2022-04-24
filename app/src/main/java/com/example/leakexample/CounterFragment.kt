package com.example.leakexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

            handler.postDelayed(this, 1000)
        }
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

        counterTextView = view.findViewById(R.id.counter_text)
    }

    override fun onResume() {
        super.onResume()

        handler.post(counterRunnable)
    }
}
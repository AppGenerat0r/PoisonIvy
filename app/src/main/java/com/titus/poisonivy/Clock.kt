package com.titus.poisonivy

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Clock : Fragment() {

    companion object {
        fun newInstance() = Clock()
    }

    private lateinit var viewModel: ClockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.clock_fragment, container, false)
    }
    fun StartClock(){

        val currentTime = Calendar.getInstance().time
        val endDateDay = "03/02/2090 21:00:00"
        val format1 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss",Locale.getDefault())
        val endDate = format1.parse(endDateDay)
        val different = endDate.time - currentTime.time;
        val countDownTimer =  object : CountDownTimer(different, 1000) {
            override fun onTick(p0: Long) {
                val TextClockTime = view?.findViewById<TextView>(R.id.TextClockTime);
                TextClockTime?.text = SimpleDateFormat("MM/dd hh:mm:ss").format(Date())
            }

            override fun onFinish() {

            }

        }
        countDownTimer.start();
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        StartClock()
        viewModel = ViewModelProvider(this).get(ClockViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.Weather.observe(viewLifecycleOwner) {
            val TextWeather = view?.findViewById<TextView>(R.id.WeatherText);
            TextWeather?.text = it.toString()
        }
    }

}
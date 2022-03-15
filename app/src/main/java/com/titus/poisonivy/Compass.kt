package com.titus.poisonivy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.titus.poisonivy.Compass_2.CompassListener


class Compass : Fragment() {

    companion object {
        fun newInstance() = Compass()
    }


    private var arrowView: ImageView? = null
    private var sotwLabel : TextView? = null

    private var currentAzimuth = 0f
    private lateinit var sotwFormatter: SOTWFormatter

    private lateinit var viewModel: CompassViewModel
    private lateinit var compass: Compass_2;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflated= inflater.inflate(R.layout.compass_fragment, container, false)
        arrowView = view?.findViewById(R.id.main_image_hands);
        sotwFormatter = SOTWFormatter(context);
        sotwLabel=view?.findViewById(R.id.sotw_label);
        compass = Compass_2(context)
        val cl: CompassListener = getCompassListener()
        compass.setListener(cl)


        return inflated;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CompassViewModel::class.java)
        // TODO: Use the ViewModel


    }

    override fun onStart() {
        super.onStart()

     //   compass.start();
    }

    override fun onResume() {
        super.onResume()
        compass.start();
    }

    override fun onStop() {
        super.onStop()
        compass.stop();
    }
    private fun adjustArrow(azimuth: Float) {

        val an: Animation = RotateAnimation(
            -currentAzimuth, -azimuth,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true
        arrowView!!.startAnimation(an)
    }

    private fun adjustSotwLabel(azimuth: Float) {
        sotwLabel!!.text = sotwFormatter.format(azimuth)
    }

    private fun getCompassListener(): CompassListener  {

            return CompassListener { azimuth: Float ->
                run {
                    adjustArrow(azimuth)
                    adjustSotwLabel(azimuth)
                }
            }

    }

}
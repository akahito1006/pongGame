package com.example.learntoplay.ui.main

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.view.Window.OnFrameMetricsAvailableListener
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.learntoplay.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    // set up the instance of binding on fragment
    private var _binding: FragmentMainBinding? = null
    // onCreateView - onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // viewBinding
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // window size
        val windowWidth = requireActivity().windowManager.currentWindowMetrics.bounds.right // 720

        view.setOnTouchListener { view, motionEvent ->
            // where you touch on screen
            val touchX = motionEvent.x
            val touchY = motionEvent.y
            // size of the white bar
            val playerCenterX = binding.player.width / 2
            val playerHeight = binding.player.height
            // set the position of the white bar
            val positionX = touchX - playerCenterX

            if (positionX >= 0 && positionX + binding.player.width <= windowWidth) {
                binding.player.x = positionX
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
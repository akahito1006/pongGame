package com.example.learntoplay.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
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

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnTouchListener { view, motionEvent ->
            // where you touch on screen
            val touchX = motionEvent.x
            val touchY = motionEvent.y
            // size of the white bar
            val playerCenterX = binding.player.width / 2
            val playerHeight = binding.player.height
            // set the position of the white bar
            binding.player.x = touchX - playerCenterX
            binding.player.y = touchY - playerHeight
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
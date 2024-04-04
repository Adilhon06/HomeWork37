package com.example.homework37

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework37.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            Log.d("count", it.getInt(COUNT).toString())
            count = it.getInt(COUNT)
            binding.tvNumber.text = count.toString()
        }
        binding.tvNumber.text = count.toString()
        setupCounter()
        minus()
    }

    private fun setupCounter() = with(binding) {
        btnPlus.setOnClickListener {
            if (count < 10) {
                count++
                tvNumber.text = count.toString()
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, RecyclerFragment())
                    .addToBackStack("HomeFragment")
                    .commit()
            }
        }
    }

    private fun minus() {
        binding.btnMinus.setOnClickListener {
            if (count > 0) binding.tvNumber.text = (--count).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT, count)
    }

    companion object {
        const val COUNT = "count"
    }
}
package com.example.sample03listadapterinactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sample03listadapterinactivity.databinding.ListFragmentBinding
import com.google.android.material.snackbar.Snackbar

class FragmentList : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding: ListFragmentBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ListFragmentBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = List(20) {
            "${it + 1} item ${it + 1}"
        }
        val adapter = SampleAdapter { pos ->
//            Toast.makeText(requireContext(), pos, Toast.LENGTH_SHORT).show()
            Snackbar.make(view, pos, Snackbar.LENGTH_SHORT).show()
        }

        with(binding) {

            button.setOnClickListener {
                adapter.submitList(items.shuffled())
            }

            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
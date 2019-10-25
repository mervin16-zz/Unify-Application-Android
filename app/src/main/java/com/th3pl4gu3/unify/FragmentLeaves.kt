package com.th3pl4gu3.unify


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.th3pl4gu3.unify.databinding.FragmentHomeBinding
import com.th3pl4gu3.unify.databinding.FragmentLeavesBinding

class FragmentLeaves : Fragment() {

    private lateinit var _binding: FragmentLeavesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_leaves, container, false)

        return _binding.root
    }

}

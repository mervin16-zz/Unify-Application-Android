package com.th3pl4gu3.unify.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.th3pl4gu3.unify.R
import com.th3pl4gu3.unify.databinding.FragmentBottomappbarDrawerBinding

class RoundedBottomDialogFragmentBottomAppBarDrawer : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    private lateinit var _binding: FragmentBottomappbarDrawerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottomappbar_drawer, container, false)

        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Navigation Component
        tieNavigationToBottomSheetDialog()
    }

    private fun tieNavigationToBottomSheetDialog(){
        val navController = Navigation.findNavController(requireActivity(), R.id.Container_fromMainActivity_BottomAppBarFragments)
        _binding.NavigationViewFromFragmentBottomAppBarDrawerDrawerNavigationView.setupWithNavController(navController)
    }
}


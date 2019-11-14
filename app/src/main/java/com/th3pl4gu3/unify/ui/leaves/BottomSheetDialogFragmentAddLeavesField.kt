package com.th3pl4gu3.unify.ui.leaves

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.th3pl4gu3.unify.R
import com.th3pl4gu3.unify.core.Absence
import com.th3pl4gu3.unify.databinding.FragmentBottomdialogLeavesAddBinding

class BottomSheetDialogFragmentAddLeavesField : BottomSheetDialogFragment() {

    //private lateinit var _database: DatabaseReference

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentBottomdialogLeavesAddBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bottomdialog_leaves_add, container, false)

        binding.ButtonLeavesAdd.setOnClickListener{

            val title = binding.TextBoxLeavesTitle.text.toString()
            val number = binding.TextBoxLeavesNumber.text.toString().toDouble()

            val absence = Absence(title, number)

            val database = Firebase.database
            database.getReference("leaves").push().setValue(absence)
        }


        return binding.root
    }
}
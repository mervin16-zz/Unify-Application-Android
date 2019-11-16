package com.th3pl4gu3.unify.ui.leaves


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.th3pl4gu3.unify.R
import com.th3pl4gu3.unify.core.Absence
import com.th3pl4gu3.unify.databinding.FragmentLeavesBinding

class FragmentLeaves : Fragment() {

    private lateinit var _binding: FragmentLeavesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_leaves, container, false)

        //Initiate the Absence Leaves Recyclerview and return the adapter
        initiateAbsencesList().submitList(generateDummyAbsences())

        return _binding.root
    }

    private fun initiateAbsencesList(): LeavesAdapter{
        _binding.LeavesList.layoutManager = GridLayoutManager(context, 2)
        val adapterLeaves = LeavesAdapter()

        _binding.LeavesList.adapter = adapterLeaves

        return adapterLeaves
    }

    //Need to delete after implementing database
    private fun generateDummyAbsences(): ArrayList<Absence>{
        val sick = Absence("Sick", 16.0)
        val al = Absence("AL", 25.0)
        val off = Absence("Off", 5.5)
        val unpaidAl = Absence("Unpaid AL", 0.0)
        val unpaidSick = Absence("Unpaid Sick", 0.0)

        val absences = ArrayList<Absence>()
        absences.add(sick)
        absences.add(al)
        absences.add(off)
        absences.add(unpaidAl)
        absences.add(unpaidSick)

        return absences
    }
}

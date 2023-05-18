package com.starthub.securityApp.ui.guard

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import com.starthub.securityApp.R
import com.starthub.securityApp.databinding.FragmentGuardBinding


class GuardFragment : Fragment() {

    private var _binding: FragmentGuardBinding? = null
    private lateinit var mySpinner: Spinner


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGuardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dropDownListView = arrayListOf("marriage", "church", "meeting", "school")
        fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_guard, container, false)
            mySpinner = view.findViewById(R.id.my_spinner)
            mySpinner.onItemClickListener = object : AdapterView.OnItemClickListener {
                fun onNothingSelected(parent: AdapterView<*>?) {


                }

                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    TODO("Not yet implemented")
                }

            }



            return view
        }

        fun DatePickerDialog(
            guardFragment: GuardFragment,
            onDateSetListener: DatePickerDialog.OnDateSetListener,
            year: Int,
            month: Int,
            day: Int
        ): DatePickerDialog {
            TODO("Not yet implemented")
        }

        fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val btnDatePicker = view.findViewById<Button>(R.id.btnDatePicker1)

            btnDatePicker.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Do something with the selected date
                        println(year)
                        println(month)
                        println(dayOfMonth)
                        println(day)
                    }, year, month, day).show()

            }

        }
    }

    }

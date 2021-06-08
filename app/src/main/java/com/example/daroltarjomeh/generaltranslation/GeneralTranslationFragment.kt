package com.example.daroltarjomeh.generaltranslation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import com.example.daroltarjomeh.R

class GeneralTranslationFragment : Fragment() {

    private var myContext: Activity ?= null

    companion object {
        private var instance: GeneralTranslationFragment? = null

        fun newInstance(): GeneralTranslationFragment {
            if (instance == null) {
                instance = GeneralTranslationFragment()
            }
            return GeneralTranslationFragment()        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        myContext = activity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_general_translation, container, false)
        return view
    }

    fun selectFilePDF() {
        val selectFilePDFIntent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/pdf"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                putExtra(DocumentsContract.EXTRA_INITIAL_URI, 1)
            }
        }
        myContext?.startActivityForResult(selectFilePDFIntent, 2)
    }

//    private fun storage(selectFromStorage: SelectFromStorage) {
//        when (selectFromStorage) {
//            SelectFromStorage.PDF -> selectFilePDF()
//            else -> {
//                return
//            }
//        }
//    }
}
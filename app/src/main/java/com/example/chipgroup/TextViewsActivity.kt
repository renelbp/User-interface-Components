package com.example.chipgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.activity_text_views.*

class TextViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_views)


//COMO USAR UN AUTOCOMPLETE TEXT CON UN RESOURCE ARRAY STRING
        var countries: Array<String> = resources.getStringArray(R.array.countries_array)
        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, countries)
        autoCompleteTv.setAdapter(adapter)

//USANDO MULTI AUTOCOMPLETE TEXT
        multiAutocompleteTv.setAdapter(adapter)
        multiAutocompleteTv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}
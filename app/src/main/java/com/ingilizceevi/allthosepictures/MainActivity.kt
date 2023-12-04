package com.ingilizceevi.allthosepictures

import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import androidx.fragment.app.FragmentContainerView
import com.ingilizceevi.chapterchoice.ChapterSelection
import com.ingilizceevi.conceptbuilder.ConceptLoader
import com.ingilizceevi.mylibrary.ImageFragment

class MainActivity : AppCompatActivity() {
    lateinit var chapter:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, ChapterSelection::class.java)
        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            chapter = data!!.getStringExtra("chapter").toString()
        }

    }
}
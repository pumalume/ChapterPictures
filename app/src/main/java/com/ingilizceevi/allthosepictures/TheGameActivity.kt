package com.ingilizceevi.allthosepictures

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import com.ingilizceevi.conceptbuilder.ConceptLoader
import com.ingilizceevi.mylibrary.ImageFragment

class TheGameActivity : AppCompatActivity() {
    lateinit var chapter:String
    lateinit var topPath:LinearLayout
    lateinit var bottomPath:LinearLayout
    lateinit var theSounds : MutableMap<String, Uri>
    lateinit var theImages : MutableMap<String, Drawable>
    private val gameBrain: GameBrain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chapter: String = intent.getStringExtra("chapter").toString()
        val conceptLoader = ConceptLoader(chapter)
        conceptLoader.loadAudio()
        theSounds = conceptLoader.theSounds
        theImages = conceptLoader.theImages
        conceptLoader.loadDrawables()
        topPath = findViewById(R.id.topPath)
        bottomPath = findViewById(R.id.bottomPath)
        gameBrain.theImages = conceptLoader.theImages
        gameBrain.theSounds = conceptLoader.theSounds
        setContentView(R.layout.activity_the_game)
    }

    fun containersAreLoaded() {

        for (i in 0 until 15) {
            val topContainer = FragmentContainerView(this)
            val bottomContainer = FragmentContainerView(this)
            topContainer.id = i + 1
            bottomContainer.id = 100 + i + 1
            topContainer.layoutParams = setupParams()
            bottomContainer.layoutParams = setupParams()
            topPath.addView(topContainer)
            bottomPath.addView(bottomContainer)
        }
    }
    fun containersAreFilledWithFragments(){
        for (i in 0 until 15) {
            val topTemp = topPath.getChildAt(i)
            val bottomTemp = bottomPath.getChildAt(i)
            supportFragmentManager.beginTransaction()
                .add(topTemp.id, ImageFragment(), "top" + i.toString())
                .add(bottomTemp.id, ImageFragment(), "bottom" + i.toString())
                .commit()
        }
    }
    fun fragmentsAreFilledWithPictures(){
        val fm = supportFragmentManager
        for(i in 0 until 15){
            val topTemp = fm.findFragmentByTag("top"+i.toString()) as ImageFragment
           // topTemp.imageIsSetWith(theSounds[0])
            
        }
    }
    fun setupParams(): LinearLayout.LayoutParams {
        val lp = LinearLayout.LayoutParams(
            250,
            LinearLayout.LayoutParams.MATCH_PARENT)
        return lp
    }
}
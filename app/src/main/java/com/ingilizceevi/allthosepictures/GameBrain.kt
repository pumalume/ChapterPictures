package com.ingilizceevi.allthosepictures

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.lifecycle.ViewModel

class GameBrain(): ViewModel() {
    var theSounds : MutableMap<String, Uri> = mutableMapOf()
    var theImages : MutableMap<String, Drawable> = mutableMapOf()

}
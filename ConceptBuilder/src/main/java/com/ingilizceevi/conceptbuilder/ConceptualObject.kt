package com.ingilizceevi.conceptbuilder

import android.graphics.drawable.Drawable
import android.net.Uri

class ConceptualObject(uri : Uri, string:String, d:Drawable) {

        val myString : String? = string
        val myUri : Uri = uri
        val myDrawable : Drawable = d

}
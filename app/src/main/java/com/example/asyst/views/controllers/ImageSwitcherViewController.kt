package com.example.asyst.views.controllers

import android.content.Context
import android.widget.ImageSwitcher
import android.widget.ImageView

class ImageSwitcherViewController constructor(context: Context, view: ImageSwitcher, images: Array<Int>, animationIn: Int? = null, animationOut: Int? = null) {
    private var imagePosition: Int = 0
    private var context: Context
    private var imageSwitcher: ImageSwitcher
    private var images: Array<Int>
    private var animationIn: Int?
    private var animationOut: Int?

    init {
        this.context = context
        this.imageSwitcher = view
        this.images = images
        this.animationIn = animationIn
        this.animationOut = animationOut

        initializeImageSwitcher()
        attachAnimation()
    }

    private fun initializeImageSwitcher() {
        this.imageSwitcher.setFactory {
            val imgView: ImageView = ImageView(context)
            imgView.setImageResource(images[imagePosition])
            imgView
        }
    }

    private fun attachAnimation() {
        if(this.animationIn != null) {
            this.imageSwitcher.setInAnimation(context, this.animationIn!!)
        }

        if(this.animationOut != null) {
            this.imageSwitcher.setOutAnimation(context, this.animationOut!!)
        }
    }

    fun next() {
        this.imagePosition++

        if(this.imagePosition >= this.images.size) {
            this.imagePosition = 0
        }

        this.imageSwitcher.setImageResource(this.images[this.imagePosition])
    }

    fun prev() {
        this.imagePosition--

        if(this.imagePosition < 0) {
            this.imagePosition = this.images.size - 1
        }

        this.imageSwitcher.setImageResource(this.images[this.imagePosition])
    }

    fun currentPosition(): Int {
        return this.imagePosition
    }
}
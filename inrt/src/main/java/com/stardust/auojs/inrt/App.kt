package com.stardust.auojs.inrt

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.stardust.app.GlobalAppContext
import com.stardust.auojs.inrt.autojs.AutoJs
import com.stardust.auojs.inrt.autojs.GlobalKeyObserver
import com.stardust.autojs.core.ui.inflater.ImageLoader
import com.stardust.autojs.core.ui.inflater.util.Drawables
import com.stardust.autojs.project.ProjectConfig
import com.stardust.autojs.project.ProjectConfig.configFileOfDir
import com.stardust.autojs.project.ProjectConfig.fromJson
import com.stardust.pio.PFiles
import java.io.File

/**
 * Created by Stardust on 2017/7/1.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalAppContext.set(this)
        AutoJs.initInstance(this)
        GlobalKeyObserver.init()
        getMainJs()
        Drawables.setDefaultImageLoader(object : ImageLoader {
            override fun loadInto(imageView: ImageView, uri: Uri) {
                Glide.with(this@App)
                        .load(uri)
                        .into(imageView)
            }

            override fun loadIntoBackground(view: View, uri: Uri) {
                Glide.with(this@App)
                        .load(uri)
                        .into(object : SimpleTarget<Drawable>() {
                            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>) {
                                view.background = resource
                            }
                        })
            }

            override fun load(view: View, uri: Uri): Drawable {
                throw UnsupportedOperationException()
            }

            override fun load(view: View, uri: Uri, drawableCallback: ImageLoader.DrawableCallback) {
                Glide.with(this@App)
                        .load(uri)
                        .into(object : SimpleTarget<Drawable>() {
                            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>) {
                                drawableCallback.onLoaded(resource)
                            }
                        })
            }

            override fun load(view: View, uri: Uri, bitmapCallback: ImageLoader.BitmapCallback) {
                Glide.with(this@App)
                        .asBitmap()
                        .load(uri)
                        .into(object : SimpleTarget<Bitmap>() {
                            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>) {
                                bitmapCallback.onLoaded(resource)
                            }
                        })
            }
        })
    }


    private fun getMainJs(){
       var projectConfig: ProjectConfig? = fromAssets(this,configFileOfDir("project"))
       Log.e("LLLLLLLLL","projectConfig?.toJson().toString()=${projectConfig?.toJson().toString()}")
    }

    private fun fromAssets(param1Context: Context?, param1String: String?): ProjectConfig? {
        if (param1Context != null) {
            if (param1String != null) return try {
                fromJson(PFiles.read(param1Context.assets.open(param1String)))
            } catch (exception: Exception) {
                null
            }
            return null
        }
        return null
    }

    fun join(paramString: String?, vararg paramVarArgs: String?): String? {
        var file = File(paramString)
        val j = paramVarArgs.size
        for (i in 0 until j) file = File(file, paramVarArgs[i])
        return file.path
    }

    fun a(paramString1: String, paramString2: String?): String? {
        val stringBuilder = StringBuilder()
        val k = paramString1.length
        for (j in 0 until k) {
            val c = paramString1[j]
            if (Character.isUpperCase(c) && stringBuilder.length != 0) stringBuilder.append(paramString2)
            stringBuilder.append(c)
        }
        return stringBuilder.toString()
    }

}

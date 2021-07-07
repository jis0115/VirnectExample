package jis.lonepine.virnectexample.presentation.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadUrlWithGlide")
fun ImageView.loadUrlWithGlide(url:String){
    Glide.with(context).load(url).placeholder(android.R.drawable.ic_menu_gallery).into(this)
}
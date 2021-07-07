package jis.lonepine.virnectexample.presentation.extension

import java.text.DecimalFormat


fun String.removeHtml():String {
    return this.replace("(?s)<(\\w+)\\b[^<>]*>.*?</\\1>".toRegex(), "")
}

fun String.addComma() = DecimalFormat("###,###,###").format(this.toDouble())
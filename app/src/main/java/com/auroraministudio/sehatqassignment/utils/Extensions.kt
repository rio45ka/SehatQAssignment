package com.auroraministudio.sehatqassignment.utils

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.Html
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import java.util.regex.Pattern

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun openWebPage(url: String, ctx: Context) {
    try {
        val webPage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        ctx.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            ctx,
            "Terjadi kesalahan saat membuka link, Install aplikasi browser!",
            Toast.LENGTH_SHORT
        ).show()
        e.printStackTrace()
    }
}

fun ruleEmailValid(email: String): Boolean {
    val isValid: Boolean
    val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(email)
    isValid = matcher.matches()
    return isValid
}

fun getTextFromInput(editText: AppCompatEditText) : String {
    return editText.text.toString().trim()
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}

fun Context.getColorCompat(color: Int) = ContextCompat.getColor(this, color)
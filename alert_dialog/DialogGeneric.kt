package com.fdananda.kotlinalertdialog

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class DialogGeneric {
    fun openDialog(
        activity: Activity, drawable: Drawable?, title: String?, text: String?,
        option1: String, activityOption1: Class<*>?, option2: String,
        activityOption2: Class<*>?, option3: String, color: Int
    ) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_generic)
        val imageView: ImageView = dialog.findViewById(R.id.imageViewDialog)
        imageView.setImageDrawable(drawable)
        val textViewTitle: TextView = dialog.findViewById(com.fdananda.kotlinalertdialog.R.id.textViewTitle)
        textViewTitle.text = title
        val textViewText: TextView = dialog.findViewById(com.fdananda.kotlinalertdialog.R.id.textViewText)
        textViewText.text = text
        val linearLayout: LinearLayout = dialog.findViewById(R.id.ll_dialog)
        linearLayout.setBackgroundColor(color)
        val buttonOption1: Button = dialog.findViewById(com.fdananda.kotlinalertdialog.R.id.buttonOption1)
        if (option1 != "") {
            buttonOption1.setText(option1)
            buttonOption1.setOnClickListener {
                val intent = Intent(activity, activityOption1)
                activity.startActivity(intent)
                activity.finish()
                dialog.dismiss()
            }
        } else {
            buttonOption1.setVisibility(View.GONE)
        }
        val buttonOption2: Button = dialog.findViewById(com.fdananda.kotlinalertdialog.R.id.buttonOption2)
        if (option2 != "") {
            buttonOption2.setText(option2)
            buttonOption2.setOnClickListener {
                    val intent = Intent(activity, activityOption2)
                    activity.startActivity(intent)
                    activity.finish()
                    dialog.dismiss()
            }
        } else {
            buttonOption2.setVisibility(View.GONE)
        }
        val buttonOption3: Button = dialog.findViewById(com.fdananda.kotlinalertdialog.R.id.buttonOption3)
        if (option3 != "") {
            buttonOption3.setText(option3)
            buttonOption3.setOnClickListener {
                    dialog.dismiss()
            }
        } else {
            buttonOption3.setVisibility(View.GONE)
        }
        dialog.show()
    }
}

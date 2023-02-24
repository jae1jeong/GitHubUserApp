package com.jae1jeong.github.utlis.decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView

class UserListDividerDecoration(private val lineThickness:Int,@ColorInt private val lineColor:Int?):RecyclerView.ItemDecoration() {


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val paint = Paint()
        paint.color = lineColor ?: Color.BLACK
        paint.strokeWidth = lineThickness.toFloat()

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val startX = child.left.toFloat()
            val startY = child.bottom.toFloat() + params.bottomMargin.toFloat()
            val endX = child.right.toFloat()
            val endY = startY
            c.drawLine(startX, startY, endX, endY, paint)
        }
    }
}
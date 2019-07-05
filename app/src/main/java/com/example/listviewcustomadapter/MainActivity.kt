package com.example.listviewcustomadapter

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.ActionBarContextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_color.view.*
import java.security.AccessControlContext

class MainActivity : AppCompatActivity() {

    val colors = arrayOf(
        "red", "green", "blue",
        "cyan", "magenta", "yellow",
        "black", "white", "gray",
        "maroon", "fuchsia", "navy",
        "olive", "teal"
    )

    val numList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..1000){
            numList.add(i)
        }

        lvColors.adapter = ColorAdapter(this, numList, colors)

    }

    class ColorAdapter(val context: Context, val nums:ArrayList<Int>, val cols: Array<String>): BaseAdapter(){

        override fun getView(position: Int, contextView: View?, parent: ViewGroup?): View {

            Log.d("LIST", "$position : ${contextView.toString()}")

            val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val itemView = contextView ?: li.inflate(R.layout.list_item_color, parent, false)
//          val itemView = li.inflate(R.layout.list_item_color, parent, false)          // always creates a new View Object and do not use previously created View object

            val id = nums[position]
            val colorName = cols[position % cols.size]
            val color = Color.parseColor(colorName)

            itemView.tvColor.setBackgroundColor(color)
            itemView.tvColorText.text = colorName
            itemView.tvId.text = id.toString()

            return itemView

        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return nums.size
        }


    }

}

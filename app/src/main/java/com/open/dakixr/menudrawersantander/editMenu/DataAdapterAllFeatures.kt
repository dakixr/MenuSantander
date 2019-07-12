package com.open.dakixr.menudrawersantander.editMenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import java.util.ArrayList

class DataAdapterAllFeatures(private val items: ArrayList<ItemMenu>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        lateinit var listAllFeatures: ArrayList<ItemMenu>
    }

    init {
        listAllFeatures = items
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_all_features, viewGroup, false)
        return ViewHolderItem(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        val item = items[i]

        (viewHolder as ViewHolderItem).itemName.text = item.itemName
        viewHolder.itemIcon.setImageResource(item.itemIcon)

        viewHolder.btnAdd.setOnClickListener {

            val positionOfItem = item.getPosItemAt(items)

            if (positionOfItem != null) {
                items.removeAt(positionOfItem)
                notifyItemRemoved(positionOfItem)

                val destinationPos = DataAdapterYourFeatures.listYourFeatures.size

                item.position = destinationPos

                DataAdapterYourFeatures.listYourFeatures.add(item)
                FragmentYourFeatures.adapterYourFeatures.notifyItemInserted(destinationPos)
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    internal inner class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {
        var itemName: TextView
        var itemIcon: ImageView
        var btnAdd: Button

        init {
            itemName = view.findViewById(R.id.name_item_all)
            itemIcon = view.findViewById(R.id.img_item_all)
            btnAdd = view.findViewById(R.id.button_add_feature)
        }

    }

}
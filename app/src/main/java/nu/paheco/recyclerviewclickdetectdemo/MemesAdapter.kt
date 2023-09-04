package nu.paheco.recyclerviewclickdetectdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

var people = mutableListOf<String>("Arne", "Bertil", "Ceasar", "David")
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val personName : TextView
        init {
            personName = view.findViewById(R.id.fornameTV)
        }
    }

    // Skapa rad
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("pia11debug", "Skapa rad")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }
    // Rita rad
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("pia11debug", "RITA RAD " + position.toString())
        holder.personName.text = people[position]
        holder.itemView.setOnClickListener {
            //val meme = getItem(position)
            val c = people[position]
            onClickListener.onClick(c)
        }
    }
    override fun getItemCount(): Int {
        return people.size
    }

class OnClickListener(val clickListener: (meme: String) -> Unit) {
    fun onClick(meme: String) = clickListener(meme)
}
}
package nu.paheco.recyclerviewclickdetectdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import nu.paheco.recyclerviewclickdetectdemo.databinding.RecyclerRowBinding

class PersonAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

var people = mutableListOf<String>("Arne", "Bertil", "Ceasar", "David")
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val personName : TextView
        init {
            personName = view.findViewById(R.id.fornameTV)
        }
    }
/*
class MemesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Meme, MemesAdapter.MyViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<Meme>() {
        override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem.id == newItem.id
        }
   }

 */
/*
    inner class MyViewHolder(private val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meme: Meme?) {
           /* Glide.with(binding.imageView)
                .load(meme?.url)
                .into(binding.imageView)

            binding.memeName.text = meme?.name

            */
        }
    }
 */
    // Skapa rad
    /*
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("pia11debug", "Skapa rad")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }
    /*
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meme = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(meme)
        }
        holder.bind(meme)
    }
     */
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
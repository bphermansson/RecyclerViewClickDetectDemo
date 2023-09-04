package nu.paheco.recyclerviewclickdetectdemo

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import nu.paheco.recyclerviewclickdetectdemo.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter
    //var personadapter = PersonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PersonAdapter(PersonAdapter.OnClickListener {
            it ->
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
        var people = mutableListOf<String>("Arne", "Bertil", "Ceasar", "David")


        //val list = meme.data?.memes
        //adapter.submitList(people)
        binding.recyclerView.adapter = adapter

    }
}


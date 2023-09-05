package nu.paheco.recyclerviewclickdetectdemo

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import nu.paheco.recyclerviewclickdetectdemo.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PersonAdapter(PersonAdapter.OnClickListener {
            name ->
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
        })

        adapter.people.add("Per Persson")
        binding.recyclerView.adapter = adapter
    }
}


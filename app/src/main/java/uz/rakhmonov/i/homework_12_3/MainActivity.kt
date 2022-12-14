package uz.rakhmonov.i.homework_12_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.rakhmonov.i.homework_12_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MySharedPreference.init(this)
        if (!MySharedPreference.cacheIsActivated) {
            MySharedPreference.cacheIsActivated = true
            loadData()
        }


        binding.btnAddTodo.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.btnList.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }

    private fun loadData() {
        val map = HashMap<String, ArrayList<Todo>>()
        val titleList = arrayListOf("Open", "Development", "Uploading", "Reject", "Closed")

        val list = ArrayList<Todo>()
        for (i in titleList) {
            map[i] = list
        }
        MySharedPreference.catchList = map
    }
}
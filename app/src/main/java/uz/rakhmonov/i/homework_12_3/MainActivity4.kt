package uz.rakhmonov.i.homework_12_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.view.SupportActionModeWrapper
import uz.rakhmonov.i.homework_12_3.databinding.ActivityMain4Binding
import uz.rakhmonov.i.homework_12_3.databinding.ChilditemBinding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPreference.init(this)
        val ListInfo = intent.getSerializableExtra("keyParent") as Todo
        val titleInfo = intent.getStringExtra("keyChild")
        Toast.makeText(this, ListInfo.toString(), Toast.LENGTH_SHORT).show()
        var process = ""
        var titleList = arrayListOf("Open", "Development", "Uploading", "Reject", "Closed")

        binding.radioGroup.findViewWithTag<RadioButton>(titleInfo).isChecked = true
        supportActionBar!!.title = ListInfo.name
        binding.description.text = ListInfo.descrip
        binding.priority.text = ListInfo.level
        binding.tvCreateDate.text = ListInfo.date
        binding.tvDeadline.text = ListInfo.dedline
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            process = findViewById<RadioButton>(checkedId).tag.toString()
            Toast.makeText(this, process, Toast.LENGTH_SHORT).show()
        }
        binding.btnSave.setOnClickListener {
            if (process.isNotEmpty()) {
                val list = MySharedPreference.catchList
                list[titleInfo]!!.remove(ListInfo)
                list[process]!!.add(ListInfo)
                MySharedPreference.catchList = list
                Toast.makeText(this, "O'zgarish saqlandi", Toast.LENGTH_SHORT).show()
                finish()
                Toast.makeText(this, "BO'PTIDAAA", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }


    }
}
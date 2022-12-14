package uz.rakhmonov.i.homework_12_3

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.rakhmonov.i.homework_12_3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()
        MySharedPreference.init(this)
        Data.addList()
        var degree = "Urgent"
        binding.edtSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                degree = binding.edtSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }

        binding.btnSave.setOnClickListener {
            val list = MySharedPreference.catchList
        if (binding.todoName.text.isNotEmpty()&&binding.todoDescrip.text.isNotEmpty()&&binding.todoDate.text.isNotEmpty()&&binding.todoDedline.text.isNotEmpty()) {
            list["Open"]!!.add(
                Todo(
                    binding.todoName.text.toString(),
                    binding.todoDescrip.text.toString(),
                    degree,
                    binding.todoDate.text.toString(),
                    binding.todoDedline.text.toString()
                )
            )

            MySharedPreference.catchList = list
            finish()
        }else{
            Toast.makeText(this, "Iltimos, barcha qatorlarni to'ldiring", Toast.LENGTH_SHORT).show()
        }
        }

    }
}
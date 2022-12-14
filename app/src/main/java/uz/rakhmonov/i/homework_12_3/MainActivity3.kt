package uz.rakhmonov.i.homework_12_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.rakhmonov.i.homework_12_3.databinding.ActivityMain3Binding
class MainActivity3 : AppCompatActivity() {
   private lateinit var myTodoAdapter: myTodoAdapter
    private lateinit var binding: ActivityMain3Binding
    private lateinit var titleList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPreference.init(this)
         titleList = arrayListOf("Open", "Development", "Uploading", "Reject", "Closed")

        myTodoAdapter= myTodoAdapter(titleList,MySharedPreference.catchList)
        binding.expendVW.setAdapter(myTodoAdapter)

        binding.expendVW.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val ListInfo=MySharedPreference.catchList[titleList[groupPosition]]!![childPosition]
            val intent=Intent(this, MainActivity4::class.java)
            intent.putExtra("keyParent",ListInfo)
            intent.putExtra("keyChild",titleList[groupPosition])
            startActivity(intent)
            true
        }
    }

    override fun onResume() {
        myTodoAdapter= myTodoAdapter(titleList,MySharedPreference.catchList)
        binding.expendVW.setAdapter(myTodoAdapter)

        super.onResume()
    }





}
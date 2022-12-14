package uz.rakhmonov.i.homework_12_3

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



object MySharedPreference {

    private const val NAME = "catche"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences


    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    var catchList:HashMap<String,ArrayList<Todo>>
    get() = jsondanArrayListga(preferences.getString("keyList", "[]")!!)
    set(value)= preferences.edit{
        if (value!=null){
            it.putString("keyList", arrayListdanjsonga(value))
        }
    }
    fun arrayListdanjsonga(list:HashMap<String,ArrayList<Todo>>):String{
        var gson= Gson()
        return gson.toJson(list)

    }
    fun jsondanArrayListga(str:String): HashMap<String, ArrayList<Todo>> {
        var gson=Gson()
        val type=object : TypeToken <HashMap<String,ArrayList<Todo>>>(){}.type
        return gson.fromJson<HashMap<String,ArrayList<Todo>>>(str, type)


    }
    var cacheIsActivated: Boolean
        get() = preferences.getBoolean("state", false)
        set(value) = preferences.edit {
            if (value != null) {
                it.putBoolean("state", value)
            }
        }


}
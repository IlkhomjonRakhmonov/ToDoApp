package uz.rakhmonov.i.homework_12_3

object Data {
    var toDolist =ArrayList<Todo>()
    var map=HashMap<Todo, ArrayList<Todo>>()

    fun addList(){
        toDolist.add(Todo("","","","",""))
    }

}
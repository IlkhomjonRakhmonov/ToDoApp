package uz.rakhmonov.i.homework_12_3

import android.annotation.SuppressLint
import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListAdapter
import uz.rakhmonov.i.homework_12_3.databinding.ChilditemBinding
import uz.rakhmonov.i.homework_12_3.databinding.MyTodoItemsBinding
import uz.rakhmonov.i.homework_12_3.databinding.ParentitemBinding

class myTodoAdapter( var titleList:ArrayList<String>, val map: HashMap<String,ArrayList<Todo>>):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return map[titleList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return map[titleList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val parentitemBinding=ParentitemBinding.inflate(LayoutInflater.from(p3?.context),p3,false)
        parentitemBinding.TVParent.text=titleList[p0]
        return parentitemBinding.root
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val childitemBinding=ChilditemBinding.inflate(LayoutInflater.from(p4?.context),p4,false)
        childitemBinding.TVChild.text=map[titleList[p0]]?.get(p1)?.name
        return childitemBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }


}
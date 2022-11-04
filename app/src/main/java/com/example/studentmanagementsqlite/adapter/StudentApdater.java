package com.example.studentmanagementsqlite.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentmanagementsqlite.R;
import com.example.studentmanagementsqlite.model.student;

import java.util.List;

public class StudentApdater extends BaseAdapter {
    private Context context;
    private int layout;
    private List<student> studentList;
    public StudentApdater(Context context, List<student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, null);
            viewHolder.student_id = view.findViewById(R.id.student_id);
            viewHolder.student_name = view.findViewById(R.id.student_name );
            viewHolder.student_address = view.findViewById(R.id.student_address);
            viewHolder.student_phone = view.findViewById(R.id.student_phone);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        student student = studentList.get(i);
        viewHolder.student_id.setText("ID: "+student.getId());
        viewHolder.student_name.setText("Name: "+student.getName());
        viewHolder.student_address.setText("Address: "+student.getAddress());
        viewHolder.student_phone.setText("Phone: "+student.getPhone());

        return view;
    }
    class ViewHolder {
        TextView student_name, student_id, student_address, student_phone;
    }
}



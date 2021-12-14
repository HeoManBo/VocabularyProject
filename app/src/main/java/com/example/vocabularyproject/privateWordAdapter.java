package com.example.vocabularyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

///dsadsa
public class privateWordAdapter extends BaseAdapter {
    private List<pW> arr; // textview를 채울 값

    public privateWordAdapter(List<pW> arr) {
        this.arr = arr;
    }

    File file = new File("/data/user/0/com.example.vocabularyproject/files", "add.txt");
    // SQL이 아닌, 내부 저장소 파일 읽고 쓰기를 사용하여 프로그램을 작성해보았다.

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // ListView 구현

        Context context = parent.getContext();
        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.private_word_list, parent, false);
            holder.word = (TextView) convertView.findViewById(R.id.private_word);
            holder.mean = (TextView) convertView.findViewById(R.id.private_mean);
            holder.pos = (TextView) convertView.findViewById((R.id.private_pos));
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        pW pw = arr.get(position);
        holder.word.setText(pw.getWord());
        holder.mean.setText(pw.getMean());
        holder.pos.setText(pw.getPos());

        ImageButton delete = (ImageButton)convertView.findViewById(R.id.delete); // 추가했던 개인단어를 삭제하는 버튼
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arr.remove(position); // 버튼을 누른 위치의 data를 소거.
                file.delete(); // 파일을 처음부터 다시 작성함.
                FileWriter writer;
                String word, mean, pos; // arr의 값이 저장될 변수

                for (int i = 0; i < arr.size(); i++) {
                    pW temp = arr.get(i); // arr의 처음부터 다시 file에 작성한다.
                    word = temp.getWord();
                    mean = temp.getMean();
                    pos = temp.getPos();
                    try {
                        writer = new FileWriter(file, true);
                        writer.write(word + ":" + pos + ":" + mean + "\n");
                        writer.flush();
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Toast.makeText(context, "단어가 제거되었습니다.", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged(); // listview를 최신화한다.
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView word;
        TextView pos;
        TextView mean;
    }

}
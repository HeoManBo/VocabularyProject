package com.example.vocabularyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class privateWordAdapter extends BaseAdapter {
    private List<pW> arr;

    public privateWordAdapter(List<pW> arr) {
        this.arr = arr;
    }


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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.private_word_list, parent, false);
            holder.word = (TextView) convertView.findViewById(R.id.word);
            holder.mean = (TextView) convertView.findViewById(R.id.mean);
            holder.ex = (TextView) convertView.findViewById(R.id.ex);
            holder.exMean = (TextView) convertView.findViewById(R.id.exMean);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        pW pw = arr.get(position);
        holder.word.setText(pw.getWord());
        holder.mean.setText(pw.getMean());
        holder.ex.setText(pw.getEx());
        holder.exMean.setText(pw.getExMean());
        Button delete = convertView.findViewById(R.id.delete);

        return convertView;
    }

    static class ViewHolder {
        TextView word;
        TextView mean;
        TextView ex;
        TextView exMean;
    }

}
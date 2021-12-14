package com.example.vocabularyproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Favority 데이터를 뿌릴 Adapter

public class FavorityListiewAdapter extends RecyclerView.Adapter<FavorityListiewAdapter.ViewHolder> implements ItemTouchHelperListener{

    ArrayList<FavorityClass> list = new ArrayList<>();

    public void addItem(FavorityClass Item){
        list.add(Item);
    }

    public void setItems(ArrayList<FavorityClass> items){ //데이터 베이스에 담긴 데이터 리스트로 초기화
        list = items;
    }

    public FavorityClass getItem(int index){
        return list.get(index);
    }

    public void setItems(int index,FavorityClass item){
        list.set(index,item);
    }

    //뷰에있는 아이템을 스와이프로 위치와 데이터를 삭제함. (스와이프로 삭제만 구현 )
    @Override
    public boolean onItemMove(int from_position, int to_position) {
        FavorityClass item = list.get(from_position);
        list.remove(from_position);
        list.add(to_position,item);
        notifyItemMoved(from_position, to_position);
        return true;
    }

    @Override
    public void onItemSwipe(int position) {
        myFavorityDB DB = new myFavorityDB(FavorityWord.mContext);
        DB.Delete(list.get(position).getWord());
        list.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public FavorityListiewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favority_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavorityListiewAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView wordText;
        private TextView meanText;
        private TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wordText = itemView.findViewById(R.id.favority_word);
            meanText = itemView.findViewById(R.id.favority_text);
            text = itemView.findViewById(R.id.favority_mean);
        }

        void onBind(FavorityClass data){
            wordText.setText(data.getWord());
            meanText.setText(data.getMean());
            text.setText(data.getSplit());
        }
    }
}


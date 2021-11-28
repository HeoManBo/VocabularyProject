package com.example.vocabularyproject;
//ListView ViewHolder 스와이프 및 삭제를 위한 인터페이스


public interface ItemTouchHelperListener {
    boolean onItemMove(int from_position,int to_position); //현재 위치를 받아 원하는 위치로 수정
    void onItemSwipe(int position); //해당 아이템을 스와이프할때의 로직
}

package com.example.recyclerviewwithdraganddropswipe

interface ItemTouchHelperListener {
    // 아이템의 현재 위치와 이동 위치를 입력받아 아이템 리스트의 위치를 수정하도록 구현
    fun onItemMove(from_position: Int, to_position: Int): Boolean
    // 아이템의 포지션값을 받아 해당 아이템을 Swipe할때 로직 구현
    fun onItemSwipe(position: Int)
}

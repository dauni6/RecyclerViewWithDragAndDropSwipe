package com.example.recyclerviewwithdraganddropswipe

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchHelperCallback : ItemTouchHelper.Callback() {

    private lateinit var listener: ItemTouchHelperListener

    fun setListener(_listener: ItemTouchHelperListener) {
        listener = _listener
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        // makeMovementFlags() 메서드로 drag 위치와 swipe 위치를 입력하여 현재 위치값을 int 로 반환
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // target은 선택된 아이템의 움직임을 감지
        // onItemMove 메서드는 아이템이 움직이고있는가를 판별하여 Boolean 으로 반환
        return listener.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
    }

    // 리사이클러뷰의 뷰홀더와 움직일 방향을 입력받는다
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
       listener.onItemSwipe(viewHolder.adapterPosition)
    }
    
    // true를 반환하도록 설정하면 롱클릭을 감지
    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

}
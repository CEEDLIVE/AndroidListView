package com.ceedlive.listview.recycler;

import android.support.v7.widget.RecyclerView;

/**
 * 사용자가 Drag 액션을 시작할 때 itemTouchHelper에 이벤트를 전달한다.
 */
public interface OnStartDragListener {

    /**
     * Called when a view is requesting a start of a drag.
     *
     * @param viewHolder The holder of the view to drag.
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}

package com.ceedlive.listview.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ceedlive.listview.R;
import com.ceedlive.listview.holder.ItemViewHolder;
import com.ceedlive.listview.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    private List<Item> mItems = new ArrayList<>();

    private Context mContext;
    private OnStartDragListener mDragStartListener;

    public RecyclerViewAdapter(Context context, OnStartDragListener startDragListener) {
        this.mContext = context;
        this.mDragStartListener = startDragListener;
    }

    // Custom

    public void add(Item item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    // Override

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * 뷰홀더를 어떻게 생성할 것인가
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_sample, viewGroup, false);
        return new ItemViewHolder(view);
    }

    /**
     * 뷰홀더를 데이터에 바인딩 시킬 때 어떻게 할 것인가
     * @param itemViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        Item item = mItems.get(position);
        itemViewHolder.textViewTitle.setText(item.getTitle());
        itemViewHolder.textViewDescription.setText(item.getDescription());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }
}

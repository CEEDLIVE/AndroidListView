package com.ceedlive.listview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ceedlive.listview.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewTitle;
    public TextView textViewDescription;

    public int position;

    public ItemViewHolder(View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.tv_title);
        textViewDescription = itemView.findViewById(R.id.tv_description);
    }

}

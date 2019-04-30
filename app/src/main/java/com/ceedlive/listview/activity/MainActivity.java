package com.ceedlive.listview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.ceedlive.listview.R;
import com.ceedlive.listview.recycler.RecyclerViewAdapter;
import com.ceedlive.listview.recycler.ItemTouchHelperAdapter;
import com.ceedlive.listview.recycler.OnStartDragListener;
import com.ceedlive.listview.recycler.ItemTouchHelperCallback;
import com.ceedlive.listview.model.Item;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private ItemTouchHelperAdapter mItemTouchHelperAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        // 리사이클러 뷰는 레이아웃 매니저가 필요함
        // 리사이클러 뷰 객체 생성 후 setLayoutManager 라는 메소드를 통해 세팅 필요

        mRecyclerView = findViewById(R.id.main_recycler_view);
        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mItemTouchHelperAdapter));

        mRecyclerViewAdapter = new RecyclerViewAdapter(this, new OnStartDragListener() {
            @Override
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
                mItemTouchHelper.startDrag(viewHolder);
            }
        });

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerViewAdapter);
        mItemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);

        setDummy(50);

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void setDummy(int limit) {
        int position;
        String title;
        String description;
        for (int i=0; i<limit; i++) {
            position = (i+1);
            title = position + "번째 제목입니다.";
            description = position + "번째 설명입니다.";

            Item item = new Item.Builder(title, description)
                    .index(i)
                    .build();

            mRecyclerViewAdapter.add(item);
        }
    }

}

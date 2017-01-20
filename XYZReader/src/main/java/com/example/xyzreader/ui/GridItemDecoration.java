package com.example.xyzreader.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * An {@link RecyclerView.ItemDecoration} that adds a given margin to a grid and avoids double spacing between elements
 *
 * @author Angelo Rüggeberg <s3xy4ngc@googlemail.com>
 */
class GridItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int margin;


    GridItemDecoration(int spanCount, int margin) {
        this.spanCount = spanCount;
        this.margin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        //we only want a top margin on the elements that are positioned in the first row
        if (position < spanCount) {
            outRect.top = margin;
        }

        outRect.left = margin / 2;
        outRect.right = margin / 2;

        outRect.bottom = margin;
    }
}

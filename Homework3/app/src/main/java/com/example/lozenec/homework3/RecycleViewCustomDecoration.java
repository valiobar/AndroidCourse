package com.example.lozenec.homework3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecycleViewCustomDecoration extends RecyclerView.ItemDecoration {

    Paint bluePaint, redPaint;
    int offset;

    public RecycleViewCustomDecoration() {
        offset = 10;

        bluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        redPaint.setColor(Color.RED);
        bluePaint.setColor(Color.BLUE);

        redPaint.setStyle(Paint.Style.FILL);
        bluePaint.setStyle(Paint.Style.FILL);

        redPaint.setStrokeWidth(1f);
        bluePaint.setStrokeWidth(1f);
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.set(offset, offset, offset, offset);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            c.drawRect(
                    layoutManager.getDecoratedLeft(child),
                    layoutManager.getDecoratedTop(child),
                    layoutManager.getDecoratedRight(child),
                    layoutManager.getDecoratedBottom(child),
                    bluePaint);
            c.drawRect(
                    layoutManager.getDecoratedLeft(child) + offset,
                    layoutManager.getDecoratedTop(child) + offset,
                    layoutManager.getDecoratedRight(child) - offset,
                    layoutManager.getDecoratedBottom(child) - offset,
                    redPaint);

        }

    }
}

package com.example.gridmanager;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class GridSpace extends RecyclerView.ItemDecoration {
    private final int edgespacing;
    private final int middlespacing;
    public GridSpace(int edgespacing, int middlespacing) {
        super();
        this.edgespacing = edgespacing;
        this.middlespacing = middlespacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        boolean isLTR = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_LTR;

        int position = parent.getChildAdapterPosition(view); // 获取view 在adapter中的位置。
        int column = ((GridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        Log.e("901336",  "position =" + position + ", column  =" + column + ", tag = " + view.getTag());
        ((CardView)view).setRadius(20 * column);
        Object tag = view.getTag();
        if (tag != null && "xxxxx".equals(tag)) {
            boolean isStartOnEdge = (isLTR && column==0) || (!isLTR && column !=0);
            int leftSpace = isStartOnEdge ? edgespacing : middlespacing;
            int rightSpace = isStartOnEdge ? middlespacing : edgespacing;
            outRect.left = leftSpace;
            outRect.right = rightSpace;
        }
    }
}

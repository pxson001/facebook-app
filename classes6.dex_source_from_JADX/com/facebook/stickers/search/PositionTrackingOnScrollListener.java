package com.facebook.stickers.search;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.stickers.search.StickerSearchContainer.AnimationFlag;
import com.facebook.stickers.search.StickerSearchContainer.C11863;

/* compiled from: edit_members */
public class PositionTrackingOnScrollListener implements OnScrollListener {
    private C11863 f16784a;
    private int f16785b;
    private boolean f16786c;
    private int f16787d;
    private int f16788e;

    public PositionTrackingOnScrollListener(C11863 c11863, int i, int i2) {
        this.f16784a = c11863;
        this.f16787d = i;
        this.f16788e = i2;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            C11863 c11863 = this.f16784a;
            int i2 = this.f16785b;
            int height = c11863.f16800a.f16854y.getHeight();
            if (c11863.f16800a.f16854y.getTranslationY() > ((float) ((-height) / 2)) || i2 < height) {
                StickerSearchContainer.m24585a(c11863.f16800a, 0.0f, AnimationFlag.SPRING_TO_VALUE);
            } else {
                StickerSearchContainer.m24585a(c11863.f16800a, (float) (-height), AnimationFlag.SPRING_TO_VALUE);
            }
            this.f16786c = false;
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (absListView.getChildCount() != 0) {
            View childAt = absListView.getChildAt(0);
            int height = ((((i + 1) / this.f16787d) * (this.f16788e + childAt.getHeight())) - childAt.getTop()) + absListView.getPaddingTop();
            if (this.f16786c) {
                this.f16784a.m24563a(height, height - this.f16785b);
            } else {
                this.f16784a.m24563a(height, 0);
            }
            this.f16786c = true;
            this.f16785b = height;
        }
    }
}

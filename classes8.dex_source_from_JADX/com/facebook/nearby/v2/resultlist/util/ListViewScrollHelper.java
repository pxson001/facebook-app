package com.facebook.nearby.v2.resultlist.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.BetterListView.OnInterceptTouchEventListener;
import java.lang.ref.WeakReference;

/* compiled from: decodePayload */
public class ListViewScrollHelper implements OnTouchListener, OnInterceptTouchEventListener {
    private WeakReference<BetterListView> f15865a;
    public OnScrollDirectionChangeListener f15866b;
    private int f15867c;
    private float f15868d;
    private float f15869e;
    private int f15870f;

    /* compiled from: decodePayload */
    public interface OnScrollDirectionChangeListener {
        void w_(int i);
    }

    public ListViewScrollHelper(BetterListView betterListView) {
        this.f15865a = new WeakReference(betterListView);
        if (betterListView != null) {
            this.f15867c = ViewConfiguration.get(betterListView.getContext()).getScaledTouchSlop();
            betterListView.setOnTouchListener(this);
            betterListView.z = this;
        }
    }

    public final boolean m18713a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float y = motionEvent.getY();
            this.f15869e = y;
            this.f15868d = y;
            this.f15870f = 0;
        }
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY();
            if (y != this.f15869e) {
                int i;
                int i2;
                if (y > this.f15869e) {
                    i2 = -1;
                    if (y <= this.f15868d) {
                        this.f15868d = this.f15869e;
                        i = -1;
                    }
                    i = i2;
                } else {
                    i2 = 1;
                    if (y >= this.f15868d) {
                        this.f15868d = this.f15869e;
                    }
                    i = i2;
                }
                int abs = (int) Math.abs(y - this.f15868d);
                BetterListView betterListView = (BetterListView) this.f15865a.get();
                int i3 = 0;
                if (betterListView != null) {
                    int childCount = betterListView.getChildCount();
                    if (childCount != 0) {
                        int firstVisiblePosition = betterListView.getFirstVisiblePosition();
                        if (i > 0) {
                            int bottom = betterListView.getChildAt(childCount - 1).getBottom();
                            if (childCount + firstVisiblePosition < betterListView.getCount() || bottom > betterListView.getHeight() - betterListView.getPaddingBottom()) {
                                i3 = 1;
                            }
                        } else {
                            childCount = betterListView.getChildAt(0).getTop();
                            if (firstVisiblePosition > 0 || childCount < betterListView.getPaddingTop()) {
                                i3 = 1;
                            }
                        }
                    }
                }
                if (!(i3 == 0 || abs <= this.f15867c || this.f15870f == i)) {
                    this.f15870f = i;
                    if (this.f15866b != null) {
                        this.f15866b.w_(this.f15870f);
                    }
                }
                this.f15869e = y;
            }
        }
        return false;
    }
}

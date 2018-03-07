package com.facebook.widget.listview;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.5;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnTouchDownListener;
import com.facebook.widget.listview.ScrollingViewProxy.RecyclerListener;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.Map;

@Deprecated
/* compiled from: event_count */
public class ListViewProxy implements ScrollingViewProxy {
    public final BetterListView f12747a;
    private final Map<OnScrollListener, AbsListView.OnScrollListener> f12748b = Maps.c();

    /* compiled from: event_count */
    public class DelegatingOnScrollListener implements AbsListView.OnScrollListener {
        private final OnScrollListener f12752a;
        private final ListViewProxy f12753b;

        public DelegatingOnScrollListener(OnScrollListener onScrollListener, ListViewProxy listViewProxy) {
            this.f12752a = onScrollListener;
            this.f12753b = listViewProxy;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f12752a.a(this.f12753b, i);
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.f12752a.a(this.f12753b, i, i2, i3);
        }
    }

    public ListViewProxy(BetterListView betterListView) {
        this.f12747a = betterListView;
        this.f12747a.setTag(2131558446, new WeakReference(this));
    }

    public final View ix_() {
        return this.f12747a;
    }

    public final ViewGroup m13579b() {
        return this.f12747a;
    }

    public final BetterListView m13593d() {
        return this.f12747a;
    }

    public final int m13597e() {
        return this.f12747a.getHeight();
    }

    public final void m13578a(int[] iArr) {
        this.f12747a.getLocationOnScreen(iArr);
    }

    public final void m13565a(View view) {
        this.f12747a.removeHeaderView(view);
    }

    public final void m13581b(View view) {
        this.f12747a.removeFooterView(view);
    }

    public final void m13560a(int i, int i2) {
        m13576a(new 1(this, i, i2));
    }

    public final int m13601f() {
        return this.f12747a.getPaddingBottom();
    }

    public final void m13576a(Runnable runnable) {
        this.f12747a.post(runnable);
    }

    public final int m13604g() {
        return this.f12747a.getPaddingTop();
    }

    public final void m13577a(boolean z) {
        this.f12747a.setClipToPadding(z);
    }

    public final void m13561a(int i, int i2, int i3, int i4) {
        this.f12747a.setPadding(i, i2, i3, i4);
    }

    public final int m13606h() {
        return this.f12747a.getPaddingLeft();
    }

    public final int m13608i() {
        return this.f12747a.getPaddingRight();
    }

    public final boolean m13610j() {
        return this.f12747a.getClipToPadding();
    }

    public final int m13587c(View view) {
        return this.f12747a.getPositionForView(view);
    }

    public final void m13562a(Drawable drawable) {
        this.f12747a.setSelector(drawable);
    }

    public final void m13586b(boolean z) {
        this.f12747a.setVerticalScrollBarEnabled(z);
    }

    public final void m13591c(boolean z) {
        this.f12747a.setStickyHeaderEnabled(z);
    }

    public final void m13571a(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f12747a.setOnItemClickListener(null);
        } else {
            this.f12747a.setOnItemClickListener(new 2(this, onItemClickListener));
        }
    }

    public final void m13572a(final ScrollingViewProxy$OnItemLongClickListener scrollingViewProxy$OnItemLongClickListener) {
        if (scrollingViewProxy$OnItemLongClickListener == null) {
            this.f12747a.setOnItemLongClickListener(null);
        } else {
            this.f12747a.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ ListViewProxy f12757b;

                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    return scrollingViewProxy$OnItemLongClickListener.mo926a(view, i);
                }
            });
        }
    }

    public final void m13559a(int i) {
        this.f12747a.setVisibility(i);
    }

    @TargetApi(11)
    public final void m13589c(int i, int i2) {
        this.f12747a.smoothScrollToPositionFromTop(i, i2);
    }

    public final void m13595d(View view) {
        this.f12747a.addHeaderView(view);
    }

    public final void m13611k() {
        this.f12747a.c();
    }

    public final boolean m13612l() {
        return this.f12747a.isAtBottom();
    }

    public final void m13575a(RecyclerListener recyclerListener) {
        this.f12747a.setRecyclerListener(new 4(this, recyclerListener));
    }

    public final void m13569a(OnDrawListener onDrawListener) {
        this.f12747a.setOnDrawListenerTo(onDrawListener);
    }

    public final void m13580b(int i) {
        this.f12747a.setDividerHeight(i);
    }

    public final void m13566a(View view, Object obj, boolean z) {
        this.f12747a.addHeaderView(view, obj, z);
    }

    public final void m13582b(View view, Object obj, boolean z) {
        this.f12747a.addFooterView(view, obj, z);
    }

    public final void m13573a(OnScrollListener onScrollListener) {
        this.f12747a.setOnScrollListener(onScrollListener != null ? new DelegatingOnScrollListener(onScrollListener, this) : null);
    }

    public final void m13613m() {
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0);
        this.f12747a.dispatchTouchEvent(obtain);
        obtain.recycle();
    }

    public final View m13588c(int i) {
        return this.f12747a.a(i);
    }

    public final <T extends View> T m13592d(int i) {
        return this.f12747a.findViewById(i);
    }

    public final boolean m13614n() {
        return this.f12747a.a();
    }

    public final void m13598e(int i) {
        this.f12747a.smoothScrollToPosition(i);
    }

    public final ListAdapter m13615o() {
        return this.f12747a.getAdapter();
    }

    public final int m13616p() {
        return this.f12747a.getChildCount();
    }

    public final View m13602f(int i) {
        return this.f12747a.getChildAt(i);
    }

    public final int m13617q() {
        return this.f12747a.getFirstVisiblePosition();
    }

    public final int m13618r() {
        return this.f12747a.getLastVisiblePosition();
    }

    public final int m13619s() {
        return this.f12747a.getAdapter().getCount();
    }

    public final boolean m13620t() {
        return this.f12747a.getAdapter().isEmpty();
    }

    public final Object m13605g(int i) {
        return this.f12747a.getItemAtPosition(i);
    }

    public final int m13621u() {
        return this.f12747a.getHeaderViewsCount();
    }

    public final int m13622v() {
        return this.f12747a.getFooterViewsCount();
    }

    public final void m13585b(OnScrollListener onScrollListener) {
        AbsListView.OnScrollListener delegatingOnScrollListener = new DelegatingOnScrollListener(onScrollListener, this);
        this.f12747a.a(delegatingOnScrollListener);
        this.f12748b.put(onScrollListener, delegatingOnScrollListener);
    }

    public final void m13583b(OnDrawListener onDrawListener) {
        this.f12747a.a(onDrawListener);
    }

    public final void m13599e(View view) {
        this.f12747a.addFooterView(view);
    }

    public final void m13603f(View view) {
        this.f12747a.setEmptyView(view);
    }

    public final void m13574a(OnTouchDownListener onTouchDownListener) {
        this.f12747a.y = new 5(this, onTouchDownListener);
    }

    public final void m13568a(5 5) {
        this.f12747a.z = new 6(this, 5);
    }

    public final void m13596d(boolean z) {
        this.f12747a.setBroadcastInteractionChanges(z);
    }

    public final void m13567a(ListAdapter listAdapter) {
        this.f12747a.setAdapter(listAdapter);
    }

    public final void m13607h(int i) {
        this.f12747a.setSelection(i);
    }

    public final void m13594d(int i, int i2) {
        if (!this.f12747a.getClipToPadding()) {
            i2 -= m13604g();
        }
        this.f12747a.setSelectionFromTop(i, i2);
    }

    public final void m13623w() {
        this.f12747a.setSelectionAfterHeaderView();
    }

    public final void m13590c(OnScrollListener onScrollListener) {
        this.f12747a.b((AbsListView.OnScrollListener) this.f12748b.remove(onScrollListener));
    }

    public final void m13624x() {
        this.f12747a.e();
    }

    public final void m13625y() {
        this.f12747a.destroyDrawingCache();
    }

    public final void m13570a(ListScrollStateSnapshot listScrollStateSnapshot) {
        this.f12747a.a(listScrollStateSnapshot);
    }

    public final void m13584b(ListScrollStateSnapshot listScrollStateSnapshot) {
        this.f12747a.b(listScrollStateSnapshot);
    }

    public final void m13564a(OnTouchListener onTouchListener) {
        this.f12747a.setOnTouchListener(onTouchListener);
    }

    public final int m13626z() {
        return 0;
    }

    public final void m13600e(boolean z) {
        this.f12747a.A = z;
    }

    public final ImmutableMap<Long, Integer> m13556A() {
        return this.f12747a.getOffsetsOfVisibleItems();
    }

    public final long m13609i(int i) {
        return this.f12747a.getItemIdAtPosition(i);
    }

    public final Parcelable m13557B() {
        return this.f12747a.onSaveInstanceState();
    }

    public final void m13563a(Parcelable parcelable) {
        this.f12747a.onRestoreInstanceState(parcelable);
    }

    public final boolean m13558C() {
        return this.f12747a.v;
    }
}

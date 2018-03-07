package com.facebook.widget.listview;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.5;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.collect.ImmutableMap;

/* compiled from: priority_changes */
public interface ScrollingViewProxy extends ScrollListenerHolder {

    /* compiled from: priority_changes */
    public interface OnScrollListener {
        void mo1262a(ScrollingViewProxy scrollingViewProxy, int i);

        @NoAllocation
        @PerformanceCritical
        void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3);
    }

    /* compiled from: priority_changes */
    public interface RecyclerListener {
        void mo2652a(View view);
    }

    /* compiled from: priority_changes */
    public interface OnTouchDownListener {
        void mo2672a(ScrollingViewProxy scrollingViewProxy);
    }

    ImmutableMap<Long, Integer> mo2341A();

    Parcelable mo2342B();

    boolean mo2343C();

    void mo2344a(int i);

    void mo2345a(int i, int i2);

    void mo2346a(int i, int i2, int i3, int i4);

    void mo2347a(Drawable drawable);

    void mo2348a(Parcelable parcelable);

    void mo2349a(OnTouchListener onTouchListener);

    void mo2350a(View view);

    void mo2351a(View view, Object obj, boolean z);

    void mo2339a(ListAdapter listAdapter);

    void mo2352a(5 5);

    void mo2353a(OnDrawListener onDrawListener);

    void mo2354a(ListScrollStateSnapshot listScrollStateSnapshot);

    void mo2355a(OnItemClickListener onItemClickListener);

    void mo2356a(OnItemLongClickListener onItemLongClickListener);

    void mo2357a(OnScrollListener onScrollListener);

    void mo2358a(OnTouchDownListener onTouchDownListener);

    void mo2359a(RecyclerListener recyclerListener);

    void mo2360a(Runnable runnable);

    void mo2361a(boolean z);

    void mo2362a(int[] iArr);

    ViewGroup mo2363b();

    void mo2364b(int i);

    void mo2365b(View view);

    void mo2366b(View view, Object obj, boolean z);

    void mo2367b(OnDrawListener onDrawListener);

    void mo2368b(ListScrollStateSnapshot listScrollStateSnapshot);

    void mo2369b(OnScrollListener onScrollListener);

    void mo2370b(boolean z);

    int mo2371c(View view);

    View mo2372c(int i);

    void mo2373c(int i, int i2);

    void mo2374c(OnScrollListener onScrollListener);

    void mo2375c(boolean z);

    <T extends View> T mo2376d(int i);

    @Deprecated
    BetterListView mo2377d();

    void mo2378d(int i, int i2);

    void mo2379d(View view);

    void mo2380d(boolean z);

    int mo2381e();

    void mo2382e(int i);

    void mo2383e(View view);

    void mo2384e(boolean z);

    int mo2385f();

    View mo2386f(int i);

    void mo2387f(View view);

    int mo2388g();

    Object mo2389g(int i);

    int mo2390h();

    void mo2391h(int i);

    int mo2392i();

    long mo2393i(int i);

    View ix_();

    boolean mo2395j();

    void mo2396k();

    boolean mo2397l();

    void mo2398m();

    boolean mo2399n();

    @Deprecated
    ListAdapter mo2400o();

    int mo2401p();

    int mo2402q();

    int mo2403r();

    int mo2404s();

    boolean mo2405t();

    int mo2406u();

    int mo2407v();

    void mo2408w();

    void mo2409x();

    void mo2410y();

    int mo2411z();
}

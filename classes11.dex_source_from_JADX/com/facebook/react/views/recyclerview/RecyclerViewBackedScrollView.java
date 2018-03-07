package com.facebook.react.views.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
/* compiled from: Region description is invalid */
public class RecyclerViewBackedScrollView extends RecyclerView {
    public boolean f11504h;

    /* compiled from: Region description is invalid */
    class ConcreteViewHolder extends ViewHolder {
        public ConcreteViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: Region description is invalid */
    class ReactListAdapter extends Adapter<ConcreteViewHolder> {
        public final List<View> f11496a = new ArrayList();
        public final ScrollOffsetTracker f11497b;
        private final RecyclerViewBackedScrollView f11498c;
        private int f11499d = 0;
        private final OnLayoutChangeListener f11500e = new C13881(this);

        /* compiled from: Region description is invalid */
        class C13881 implements OnLayoutChangeListener {
            final /* synthetic */ ReactListAdapter f11495a;

            C13881(ReactListAdapter reactListAdapter) {
                this.f11495a = reactListAdapter;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9 = i8 - i6;
                int i10 = i4 - i2;
                if (i9 != i10) {
                    ReactListAdapter.m11936h(this.f11495a, i10 - i9);
                    this.f11495a.f11497b.m11946a(this.f11495a.f11496a.indexOf(view), i9, i10);
                    if (view.getParent() != null && view.getParent().getParent() != null) {
                        View view2 = (View) view.getParent();
                        view2.forceLayout();
                        ((View) view2.getParent()).forceLayout();
                    }
                }
            }
        }

        public final void m11938a(ViewHolder viewHolder) {
            ConcreteViewHolder concreteViewHolder = (ConcreteViewHolder) viewHolder;
            super.a(concreteViewHolder);
            ((RecyclableWrapperViewGroup) concreteViewHolder.a).removeAllViews();
        }

        public final void m11939a(ViewHolder viewHolder, int i) {
            ViewParent viewParent = (RecyclableWrapperViewGroup) ((ConcreteViewHolder) viewHolder).a;
            View view = (View) this.f11496a.get(i);
            if (view.getParent() != viewParent) {
                viewParent.addView(view, 0);
            }
        }

        public ReactListAdapter(RecyclerViewBackedScrollView recyclerViewBackedScrollView) {
            this.f11498c = recyclerViewBackedScrollView;
            this.f11497b = new ScrollOffsetTracker(this);
            a(true);
        }

        public final void m11940a(View view, int i) {
            this.f11496a.add(i, view);
            m11936h(this, view.getMeasuredHeight());
            view.addOnLayoutChangeListener(this.f11500e);
            k_(i);
        }

        public final void m11942e(int i) {
            View view = (View) this.f11496a.get(i);
            if (view != null) {
                this.f11496a.remove(i);
                view.removeOnLayoutChangeListener(this.f11500e);
                m11936h(this, -view.getMeasuredHeight());
                l_(i);
            }
        }

        public static void m11936h(ReactListAdapter reactListAdapter, int i) {
            if (i != 0) {
                reactListAdapter.f11499d += i;
                RecyclerViewBackedScrollView.m11948h(reactListAdapter.f11498c, reactListAdapter.f11499d);
            }
        }

        public final ViewHolder m11937a(ViewGroup viewGroup, int i) {
            return new ConcreteViewHolder(new RecyclableWrapperViewGroup(viewGroup.getContext()));
        }

        public final int aZ_() {
            return this.f11496a.size();
        }

        public final long H_(int i) {
            return (long) ((View) this.f11496a.get(i)).getId();
        }

        public final View m11943f(int i) {
            return (View) this.f11496a.get(i);
        }

        public final int m11941d() {
            return this.f11499d;
        }

        public final int m11944g(int i) {
            return this.f11497b.m11945a(i);
        }
    }

    /* compiled from: Region description is invalid */
    class RecyclableWrapperViewGroup extends ViewGroup {
        public RecyclableWrapperViewGroup(Context context) {
            super(context);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        protected void onMeasure(int i, int i2) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                return;
            }
            Assertions.a("RecyclableWrapperView measured but no view attached");
        }
    }

    /* compiled from: Region description is invalid */
    class ScrollOffsetTracker {
        private final ReactListAdapter f11501a;
        private int f11502b;
        private int f11503c;

        public ScrollOffsetTracker(ReactListAdapter reactListAdapter) {
            this.f11501a = reactListAdapter;
        }

        public final void m11946a(int i, int i2, int i3) {
            if (i < this.f11502b) {
                this.f11503c = (this.f11503c - i2) + i3;
            }
        }

        public final int m11945a(int i) {
            int i2 = 0;
            if (this.f11502b != i) {
                int i3;
                int i4;
                if (this.f11502b < i) {
                    if (this.f11502b != -1) {
                        i3 = this.f11503c;
                        i2 = this.f11502b;
                    } else {
                        i3 = 0;
                    }
                    for (i4 = i2; i4 < i; i4++) {
                        i3 += ((View) this.f11501a.f11496a.get(i4)).getMeasuredHeight();
                    }
                    i2 = i3;
                } else if (i < this.f11502b - i) {
                    i3 = 0;
                    for (i4 = 0; i4 < i; i4++) {
                        i3 += ((View) this.f11501a.f11496a.get(i4)).getMeasuredHeight();
                    }
                    i2 = i3;
                } else {
                    i3 = this.f11503c;
                    for (i4 = this.f11502b - 1; i4 >= i; i4--) {
                        i3 -= ((View) this.f11501a.f11496a.get(i4)).getMeasuredHeight();
                    }
                    i2 = i3;
                }
                this.f11502b = i;
                this.f11503c = i2;
            }
            return this.f11503c;
        }
    }

    public void setSendContentSizeChangeEvents(boolean z) {
        this.f11504h = z;
    }

    private int m11949l() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        return ((ReactListAdapter) this.o).m11944g(a(childAt).d()) - childAt.getTop();
    }

    final void m11951b(int i, boolean z) {
        int l = i - m11949l();
        if (z) {
            a(0, l);
        } else {
            scrollBy(0, l);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ((UIManagerModule) ((ReactContext) getContext()).b(UIManagerModule.class)).r().a(ScrollEvent.a(getId(), SystemClock.b(), ScrollEventType.SCROLL, 0, m11949l(), getWidth(), ((ReactListAdapter) getAdapter()).m11941d(), getWidth(), getHeight()));
    }

    public static void m11948h(RecyclerViewBackedScrollView recyclerViewBackedScrollView, int i) {
        if (recyclerViewBackedScrollView.f11504h) {
            ((UIManagerModule) ((ReactContext) recyclerViewBackedScrollView.getContext()).b(UIManagerModule.class)).a.a(new ContentSizeChangeEvent(recyclerViewBackedScrollView.getId(), SystemClock.b(), recyclerViewBackedScrollView.getWidth(), i));
        }
    }

    public RecyclerViewBackedScrollView(Context context) {
        super(context);
        this.v = true;
        setItemAnimator(new NotAnimatedItemAnimator());
        setLayoutManager(new LinearLayoutManager(context));
        setAdapter(new ReactListAdapter(this));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        return true;
    }

    final void m11950a(View view, int i) {
        ((ReactListAdapter) this.o).m11940a(view, i);
    }

    final void m11952f(int i) {
        ((ReactListAdapter) this.o).m11942e(i);
    }

    final View m11953g(int i) {
        return ((ReactListAdapter) this.o).m11943f(i);
    }

    int getChildCountFromAdapter() {
        return this.o.aZ_();
    }
}

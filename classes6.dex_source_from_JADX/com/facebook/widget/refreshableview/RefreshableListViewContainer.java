package com.facebook.widget.refreshableview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.ScrollableView;
import com.facebook.widget.listview.ScrollingViewProxies;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: reactions_dock_select_5 */
public class RefreshableListViewContainer extends RefreshableViewContainer {
    public int f6184f;
    private Rect f6185g = new Rect();
    private Rect f6186h = new Rect();
    private ScrollingViewProxy f6187i;

    /* compiled from: reactions_dock_select_5 */
    class C03681 implements OnScrollListener {
        final /* synthetic */ RefreshableListViewContainer f6149a;

        C03681(RefreshableListViewContainer refreshableListViewContainer) {
            this.f6149a = refreshableListViewContainer;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f6149a.f6163e.b(absListView);
                    break;
                case 1:
                case 2:
                    this.f6149a.f6163e.a(absListView);
                    break;
            }
            this.f6149a.f6184f = i;
        }
    }

    /* compiled from: reactions_dock_select_5 */
    class C03692 extends RecyclerView.OnScrollListener {
        final /* synthetic */ RefreshableListViewContainer f6150a;

        C03692(RefreshableListViewContainer refreshableListViewContainer) {
            this.f6150a = refreshableListViewContainer;
        }

        public final void m8701a(RecyclerView recyclerView, int i) {
            switch (i) {
                case 0:
                    this.f6150a.f6163e.b(recyclerView);
                    break;
                case 1:
                case 2:
                    this.f6150a.f6163e.a(recyclerView);
                    break;
            }
            this.f6150a.f6184f = i;
        }
    }

    public RefreshableListViewContainer(Context context) {
        super(context);
    }

    public RefreshableListViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RefreshableListViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void mo446a(int i) {
        this.f6184f = i;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 882790187);
        m8734j();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1563020053, a);
    }

    private void m8734j() {
        View view = getView();
        if (view instanceof ScrollableView) {
            m8735k();
        } else if (view instanceof BetterRecyclerView) {
            m8736l();
        }
    }

    private void m8735k() {
        ((ScrollableView) getView()).a(new C03681(this));
    }

    private void m8736l() {
        ((BetterRecyclerView) getView()).a(new C03692(this));
    }

    public void setScrollingViewProxy(ScrollingViewProxy scrollingViewProxy) {
        this.f6187i = scrollingViewProxy;
    }

    protected final boolean mo448a(float f) {
        if (this.f6162d != 0.0f) {
            return true;
        }
        if (this.f6161c == 0) {
            if (!m8737m() || f <= 0.0f) {
                return false;
            }
            return true;
        } else if (this.f6161c != 1) {
            throw new IllegalStateException("Unknown direction: " + this.f6161c);
        } else if (!m8738n() || f >= 0.0f) {
            return false;
        } else {
            return true;
        }
    }

    protected final boolean mo447a() {
        return this.f6184f == 0;
    }

    protected final boolean mo449b() {
        return this.f6184f == 1;
    }

    private boolean m8737m() {
        if (this.f6162d > 0.0f) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (getFirstVisiblePosition() > 0) {
            return false;
        }
        View childAt = viewGroup.getChildAt(0);
        return childAt == null || childAt.getTop() >= getTopVisibilityThreshold();
    }

    private boolean m8738n() {
        if (this.f6162d < 0.0f) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (getLastVisiblePosition() != getCount() - 1) {
            return false;
        }
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        if (childAt == null) {
            return false;
        }
        viewGroup.getDrawingRect(this.f6186h);
        childAt.getHitRect(this.f6185g);
        return this.f6185g.bottom <= this.f6186h.bottom;
    }

    private int getTopVisibilityThreshold() {
        View view = getView();
        if (view == null) {
            return 0;
        }
        ScrollingViewProxy a = ScrollingViewProxies.m8635a(view);
        if (a == null || a.j()) {
            return 0;
        }
        return a.g();
    }

    private int getFirstVisiblePosition() {
        return getScrollingViewProxy() != null ? getScrollingViewProxy().q() : ((AbsListView) getView()).getFirstVisiblePosition();
    }

    private int getCount() {
        return getScrollingViewProxy() != null ? getScrollingViewProxy().s() : ((AbsListView) getView()).getCount();
    }

    private int getLastVisiblePosition() {
        return getScrollingViewProxy() != null ? getScrollingViewProxy().r() : ((AbsListView) getView()).getLastVisiblePosition();
    }

    private ScrollingViewProxy getScrollingViewProxy() {
        if (this.f6187i != null) {
            return this.f6187i;
        }
        this.f6187i = ScrollingViewProxies.m8635a(getView());
        return this.f6187i;
    }
}

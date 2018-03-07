package com.facebook.widget.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.events.invite.EventsExtendedInviteFriendsListAdapter;
import com.facebook.widget.CustomViewUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: reactions_like_down */
public class StickyHeaderItemDecorator<DATA, VIEW extends View> extends ItemDecoration {
    private final StickyHeaderAdapter<DATA, VIEW> f6141a;
    private final Map<DATA, VIEW> f6142b = new HashMap();
    private final LinkedHashMap<VIEW, Rect> f6143c = new LinkedHashMap();
    private final LinkedHashMap<VIEW, Rect> f6144d = new LinkedHashMap();
    private final Paint f6145e;
    private boolean f6146f;
    private int f6147g = 0;
    private boolean f6148h;

    public StickyHeaderItemDecorator(StickyHeaderAdapter<DATA, VIEW> stickyHeaderAdapter, boolean z) {
        this.f6141a = stickyHeaderAdapter;
        this.f6146f = z;
        this.f6145e = new Paint();
        this.f6145e.setStrokeWidth(1.0f);
        Paint paint = this.f6145e;
        EventsExtendedInviteFriendsListAdapter eventsExtendedInviteFriendsListAdapter = this.f6141a;
        paint.setColor(0);
    }

    public final void m8700b(Canvas canvas, RecyclerView recyclerView, State state) {
        super.b(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        if (childCount != 0) {
            Rect rect;
            Rect rect2;
            View view = null;
            this.f6143c.clear();
            int i = 1;
            int i2 = 0;
            while (i2 < childCount) {
                int i3;
                View view2;
                View childAt = recyclerView.getChildAt(i2);
                int e = recyclerView.a(childAt).e();
                if (e != -1) {
                    int measuredHeight;
                    View a = m8697a(recyclerView, e);
                    if (this.f6146f) {
                        measuredHeight = a.getMeasuredHeight();
                    } else {
                        measuredHeight = 0;
                    }
                    int measuredHeight2 = a.getMeasuredHeight();
                    if (view == null) {
                        this.f6143c.put(a, new Rect(0, 0, measuredHeight2, measuredHeight));
                        if (!m8698a(e, childAt, recyclerView)) {
                            i3 = 0;
                            view2 = a;
                        } else if (childAt.getTop() < a.getHeight()) {
                            i3 = 0;
                            view2 = a;
                        } else {
                            i3 = i;
                            view2 = a;
                        }
                    } else if (m8698a(e, childAt, recyclerView)) {
                        rect = (Rect) this.f6144d.get(a);
                        rect.set(0, childAt.getTop() - measuredHeight, measuredHeight2, childAt.getTop());
                        rect2 = (Rect) this.f6143c.get(view);
                        if (rect.intersect(rect2)) {
                            rect2.bottom = rect.top;
                            rect2.top = rect.top - view.getHeight();
                            measuredHeight = 0;
                        } else {
                            measuredHeight = i;
                        }
                        this.f6143c.put(a, rect);
                        i3 = measuredHeight;
                        view2 = view;
                    }
                    i2++;
                    view = view2;
                    i = i3;
                }
                i3 = i;
                view2 = view;
                i2++;
                view = view2;
                i = i3;
            }
            for (View view3 : this.f6143c.keySet()) {
                rect2 = (Rect) this.f6143c.get(view3);
                canvas.save();
                canvas.translate((float) rect2.left, (float) rect2.top);
                view3.draw(canvas);
                canvas.restore();
            }
            if (i == 0) {
                rect = (Rect) this.f6143c.get(view);
                canvas.drawLine((float) rect.left, (float) rect.bottom, (float) rect.right, (float) rect.bottom, this.f6145e);
            }
        }
    }

    public final void m8699a(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.a(rect, view, recyclerView, state);
        if (this.f6146f) {
            int e = recyclerView.a(view).e();
            if (m8698a(e, view, recyclerView)) {
                rect.top = m8697a(recyclerView, e).getHeight();
            }
        }
    }

    private VIEW m8697a(RecyclerView recyclerView, int i) {
        if (this.f6148h || recyclerView.getWidth() != this.f6147g) {
            this.f6147g = recyclerView.getWidth();
            this.f6142b.clear();
            this.f6144d.clear();
            this.f6148h = false;
        }
        Object a = this.f6141a.a(i);
        if (this.f6142b.containsKey(a)) {
            return (View) this.f6142b.get(a);
        }
        EventsExtendedInviteFriendsListAdapter eventsExtendedInviteFriendsListAdapter = this.f6141a;
        Context context = recyclerView.getContext();
        Resources resources = context.getResources();
        VIEW inflate = LayoutInflater.from(context).inflate(2130904498, recyclerView, false);
        CustomViewUtils.b(inflate, new ColorDrawable(resources.getColor(2131361920)));
        VIEW view = inflate;
        this.f6141a.a(view, a);
        view.measure(view.getLayoutParams().width == -1 ? MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.f6142b.put(a, view);
        if (!this.f6144d.containsKey(view)) {
            this.f6144d.put(view, new Rect());
        }
        return view;
    }

    private boolean m8698a(int i, View view, RecyclerView recyclerView) {
        if (i == -1) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int indexOfChild = recyclerView.indexOfChild(view) - gridLayoutManager.h.a(i, gridLayoutManager.c);
            if (indexOfChild == 0) {
                return true;
            }
            if (this.f6141a.a(indexOfChild) != this.f6141a.a(indexOfChild - 1)) {
                return true;
            }
        } else if ((layoutManager instanceof LinearLayoutManager) && this.f6141a.a(i) != this.f6141a.a(i - 1)) {
            return true;
        }
        return false;
    }
}

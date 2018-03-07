package com.facebook.fbui.popover;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

/* compiled from: You need to bind a  */
public class PopoverListViewWindow extends PopoverMenuWindow {
    private final OnItemClickListener f12176l = new C11231(this);
    public ListAdapter f12177m;
    public int f12178n = 0;
    public float f12179o = 0.0f;
    public OnItemClickListener f12180p;
    private OnScrollListener f12181q;

    /* compiled from: You need to bind a  */
    class C11231 implements OnItemClickListener {
        final /* synthetic */ PopoverListViewWindow f12167a;

        C11231(PopoverListViewWindow popoverListViewWindow) {
            this.f12167a = popoverListViewWindow;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f12167a.f12180p != null) {
                this.f12167a.f12180p.onItemClick(adapterView, view, i, j);
            }
            this.f12167a.l();
        }
    }

    public PopoverListViewWindow(Context context) {
        int i;
        super(context);
        c(false);
        b(0.0f);
        PopoverViewFlipper popoverViewFlipper = this.f;
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(2130772490, typedValue, true)) {
            i = typedValue.resourceId;
        } else {
            i = 2130840045;
        }
        popoverViewFlipper.setBackgroundResource(i);
        this.e = false;
        e(false);
    }

    protected final PopoverListView mo1221b() {
        if (this.f12177m == null || this.f12177m.isEmpty()) {
            return super.mo1221b();
        }
        final PopoverListView popoverListView = new PopoverListView(getContext());
        popoverListView.setAdapter(this.f12177m);
        popoverListView.setFocusable(true);
        popoverListView.setFocusableInTouchMode(true);
        popoverListView.setSelection(this.f12178n);
        popoverListView.post(new Runnable(this) {
            final /* synthetic */ PopoverListViewWindow f12169b;

            public void run() {
                popoverListView.smoothScrollToPosition(this.f12169b.f12178n == 0 ? 0 : this.f12169b.f12178n - 1);
            }
        });
        popoverListView.setShowFullWidth(this.e);
        popoverListView.setMaxWidth(this.c);
        popoverListView.setOnItemClickListener(this.f12176l);
        popoverListView.setOnScrollListener(this.f12181q);
        popoverListView.m20176a(this.f12170a);
        if (this.f12179o > 0.0f) {
            popoverListView.setMaxRows(this.f12179o);
        }
        View h = h();
        popoverListView.setMinimumWidth(h != null ? h.getWidth() : 0);
        return popoverListView;
    }
}

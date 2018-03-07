package com.facebook.timeline.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.viewdiagnostics.SupportsViewDiagnostics;
import com.facebook.widget.viewdiagnostics.ViewDiagnostics;

/* compiled from: friends_center_tab_selected */
public abstract class TimelineHeaderAbstractAdapter extends FbBaseAdapter implements FbListAdapter {
    protected final Context f11327a;
    public final QeAccessor f11328b;
    public final TimelineUserContext f11329c;
    public final TimelineHeaderUserData f11330d;
    private boolean[] f11331e;
    private int f11332f = -1;
    private Object[] f11333g;

    protected abstract int mo520a();

    protected abstract Object mo521a(int i);

    protected abstract void mo522a(boolean[] zArr);

    protected abstract boolean mo523a(View view, int i);

    public TimelineHeaderAbstractAdapter(Context context, QeAccessor qeAccessor, TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData) {
        this.f11327a = context;
        this.f11328b = qeAccessor;
        this.f11329c = timelineUserContext;
        this.f11330d = timelineHeaderUserData;
    }

    public void notifyDataSetChanged() {
        this.f11332f = -1;
        super.notifyDataSetChanged();
    }

    public final void m11415a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ViewDiagnostics viewDiagnostics;
        boolean z;
        if (viewGroup instanceof SupportsViewDiagnostics) {
            ViewDiagnostics viewDiagnostics2 = ((SupportsViewDiagnostics) viewGroup).getViewDiagnostics();
            if (viewDiagnostics2 == null || !(viewDiagnostics2.c() || viewDiagnostics2.b())) {
                viewDiagnostics = viewDiagnostics2;
                z = false;
            } else {
                TracerDetour.a("renderTimelineHeaderView", -1589522894);
                viewDiagnostics = viewDiagnostics2;
                z = true;
            }
        } else {
            viewDiagnostics = null;
            z = false;
        }
        try {
            boolean a = mo523a(view, i2);
            long j = 0;
            if (z) {
                j = TracerDetour.b(-812685537);
            }
            if (z && a) {
                viewDiagnostics.c(j);
                viewDiagnostics.a(view);
            } else if (viewDiagnostics != null) {
                viewDiagnostics.b(false);
            }
        } catch (Throwable th) {
            if (z) {
                TracerDetour.b(2137270266);
            }
            if (viewDiagnostics != null) {
                viewDiagnostics.b(false);
            }
        }
    }

    public final int getCount() {
        int i = 0;
        if (this.f11332f == -1) {
            int a = mo520a();
            if (this.f11331e == null || a != this.f11331e.length) {
                this.f11331e = new boolean[a];
            }
            mo522a(this.f11331e);
            this.f11332f = 0;
            for (boolean z : this.f11331e) {
                if (z) {
                    this.f11332f++;
                }
            }
            if (this.f11332f > 0) {
                if (this.f11333g == null) {
                    this.f11333g = new Object[this.f11331e.length];
                } else if (this.f11333g.length != this.f11331e.length) {
                    this.f11333g = new Object[this.f11331e.length];
                } else {
                    while (i < this.f11331e.length) {
                        this.f11333g[i] = null;
                        i++;
                    }
                }
            }
        }
        return this.f11332f;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public Object getItem(int i) {
        if (this.f11333g[i] == null) {
            int i2 = -1;
            int i3 = 0;
            while (i3 < this.f11331e.length) {
                if (this.f11331e[i3]) {
                    i2++;
                }
                if (i == i2) {
                    this.f11333g[i] = mo521a(i3);
                } else {
                    i3++;
                }
            }
            throw new IllegalArgumentException("invalid position " + i);
        }
        return this.f11333g[i];
    }

    protected static View m11411b(int i) {
        throw new IllegalArgumentException("Unknown item view type " + i);
    }

    protected static boolean m11412c(int i) {
        throw new IllegalArgumentException("unknown itemViewType " + i);
    }

    protected final boolean m11418d(int i) {
        return this.f11331e[i];
    }
}

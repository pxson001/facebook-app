package com.facebook.composer.minutiae;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;
import com.facebook.composer.minutiae.view.MinutiaeTaggableVerbViewController;
import com.facebook.composer.minutiae.view.MinutiaeTaggableVerbViewController.C01941;
import com.facebook.composer.minutiae.view.MinutiaeVerbRowView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.sectionedadapter.SectionedAdapterForListView.SectionAdapter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

/* compiled from: total_cap */
public class MinutiaeTaggableVerbAdapter extends SectionAdapter {
    @VisibleForTesting
    protected static final Object f1427a = new Object();
    private final Context f1428b;
    private final LayoutInflater f1429c;
    private final MinutiaeTaggableVerbFragment f1430d;
    private final MinutiaeTaggableVerbViewController f1431e = new MinutiaeTaggableVerbViewController();
    private ImmutableList<MinutiaeVerbModelEdge> f1432f;
    public boolean f1433g;

    @VisibleForTesting
    /* compiled from: total_cap */
    public enum ViewType {
        LISTENING,
        ACTIVITY
    }

    public MinutiaeTaggableVerbAdapter(Context context, LayoutInflater layoutInflater, MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment) {
        this.f1428b = context;
        this.f1430d = minutiaeTaggableVerbFragment;
        this.f1429c = layoutInflater;
    }

    public final void m1520a(ImmutableList<MinutiaeVerbModelEdge> immutableList) {
        this.f1432f = immutableList;
        AdapterDetour.a(this, 449684158);
    }

    public final View m1518a(int i, ViewGroup viewGroup) {
        switch (ViewType.values()[i]) {
            case LISTENING:
                return this.f1429c.inflate(2130903702, viewGroup, false);
            case ACTIVITY:
                return this.f1429c.inflate(2130903710, viewGroup, false);
            default:
                throw new IllegalStateException("Unknown viewType while creating in " + MinutiaeTaggableVerbAdapter.class.getSimpleName());
        }
    }

    public final void m1519a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (ViewType.values()[i2]) {
            case LISTENING:
                return;
            case ACTIVITY:
                MinutiaeTaggableVerbViewController minutiaeTaggableVerbViewController = this.f1431e;
                MinutiaeVerbRowView minutiaeVerbRowView = (MinutiaeVerbRowView) view;
                MinutiaeVerbModelEdge minutiaeVerbModelEdge = (MinutiaeVerbModelEdge) obj;
                MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment = this.f1430d;
                minutiaeVerbRowView.setText(minutiaeVerbModelEdge.f1703a.n());
                minutiaeVerbRowView.m1849a(Uri.parse(minutiaeVerbModelEdge.f1703a.A().a()));
                minutiaeVerbRowView.setOnClickListener(new C01941(minutiaeTaggableVerbViewController, minutiaeTaggableVerbFragment, minutiaeVerbModelEdge));
                return;
            default:
                throw new IllegalStateException("Unknown viewType while binding in " + MinutiaeTaggableVerbAdapter.class.getSimpleName());
        }
    }

    public int getCount() {
        int i = this.f1433g ? 1 : 0;
        if (this.f1432f != null) {
            return i + this.f1432f.size();
        }
        return i;
    }

    public Object getItem(int i) {
        if (m1517a(i)) {
            return f1427a;
        }
        return this.f1432f.get(i - (this.f1433g ? 1 : 0));
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (m1517a(i)) {
            return ViewType.LISTENING.ordinal();
        }
        return ViewType.ACTIVITY.ordinal();
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    private boolean m1517a(int i) {
        return this.f1433g && i == 0;
    }
}

package com.facebook.groups.feed.controller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.ui.adapters.MergingAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;

/* compiled from: faceweb_url_tap */
public class MergingStickyHeaderAdapter extends MergingAdapter implements StickyHeaderAdapter {
    private BaseAdapter f13978a;

    public MergingStickyHeaderAdapter(BaseAdapter baseAdapter, BaseAdapter baseAdapter2) {
        super(baseAdapter, baseAdapter2);
        this.f13978a = baseAdapter;
    }

    private StickyHeaderAdapter m15587a() {
        if (this.f13978a instanceof StickyHeaderAdapter) {
            return (StickyHeaderAdapter) this.f13978a;
        }
        return null;
    }

    public final View m15588b(int i, View view, ViewGroup viewGroup) {
        if (m15587a() != null) {
            return m15587a().b(i, view, viewGroup);
        }
        return null;
    }

    public final int o_(int i) {
        if (m15587a() != null) {
            return m15587a().o_(i);
        }
        return 0;
    }

    public final int m15590e(int i) {
        if (m15587a() != null) {
            return m15587a().e(i);
        }
        return 0;
    }

    public final int m15589d() {
        return 0;
    }

    public final boolean m15591f(int i) {
        return false;
    }
}

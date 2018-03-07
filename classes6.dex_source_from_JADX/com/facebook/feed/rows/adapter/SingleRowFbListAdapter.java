package com.facebook.feed.rows.adapter;

import android.content.res.Configuration;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.widget.listview.DelegatingFbListAdapter;
import com.facebook.widget.listview.FbListAdapter;

/* compiled from: message_threads */
public class SingleRowFbListAdapter extends DelegatingFbListAdapter implements MultiRowAdapter {
    public final FbListAdapter f10392a;

    /* compiled from: message_threads */
    class C06251 implements RowIdentifier {
        final /* synthetic */ SingleRowFbListAdapter f10389a;

        C06251(SingleRowFbListAdapter singleRowFbListAdapter) {
            this.f10389a = singleRowFbListAdapter;
        }

        public final RowKey m16553a(int i) {
            return null;
        }

        public final int m16552a() {
            return this.f10389a.f10392a.getCount();
        }
    }

    public SingleRowFbListAdapter(FbListAdapter fbListAdapter) {
        super(fbListAdapter);
        this.f10392a = fbListAdapter;
    }

    public final int m16558c(int i) {
        return 1;
    }

    public final int m16559d(int i) {
        return 1;
    }

    public final int s_(int i) {
        return i;
    }

    public final int t_(int i) {
        return i;
    }

    public final int m16562g(int i) {
        return i;
    }

    public final int m16560e() {
        return this.f10392a.getCount();
    }

    public final int m16563h(int i) {
        return 0;
    }

    public final RowIdentifier m16561f() {
        return new C06251(this);
    }

    public final void m16555a(Configuration configuration) {
    }

    public final void jc_() {
    }

    public final boolean ba_() {
        return false;
    }

    public final void m16556a(DumpsysContext dumpsysContext) {
    }

    public final Marker m16557b(final int i) {
        return new Marker(this) {
            final /* synthetic */ SingleRowFbListAdapter f10391b;

            public final int m16554a() {
                return i;
            }
        };
    }
}

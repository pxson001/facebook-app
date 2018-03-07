package com.facebook.feed.rows.adapter;

import android.content.res.Configuration;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: message_to_buy_tapped */
public class MultiRowMultiAdapter extends MultiAdapterListAdapter implements HasMultiRow {
    public final List<MultiRowAdapter> f10385a;
    private final RowIdentifier f10386b = m16538d();
    public int f10387c;
    public int f10388d;

    /* compiled from: message_to_buy_tapped */
    class C06241 implements RowIdentifier {
        final /* synthetic */ MultiRowMultiAdapter f10384a;

        C06241(MultiRowMultiAdapter multiRowMultiAdapter) {
            this.f10384a = multiRowMultiAdapter;
        }

        public final RowKey m16537a(int i) {
            FbListAdapter i2 = this.f10384a.m16551i(i);
            int a = i - this.f10384a.m8629a(i2);
            if (i2.f() == null) {
                return null;
            }
            return i2.f().a(a);
        }

        public final int m16536a() {
            return this.f10384a.f10388d;
        }
    }

    public final /* synthetic */ FbListAdapter mo1039a(int i) {
        return m16551i(i);
    }

    public MultiRowMultiAdapter(boolean z, List<MultiRowAdapter> list) {
        super(z, (List) list);
        this.f10385a = list;
    }

    public MultiRowMultiAdapter(boolean z, MultiRowAdapter... multiRowAdapterArr) {
        super(z, (FbListAdapter[]) multiRowAdapterArr);
        this.f10385a = Lists.a(multiRowAdapterArr);
    }

    public final int m16545c(int i) {
        MultiRowAdapter j = m16539j(i);
        return j.c(i - m16540a(j));
    }

    public final int m16546d(int i) {
        FbListAdapter i2 = m16551i(i);
        return i2.d(i - m8629a(i2));
    }

    public final int s_(int i) {
        MultiRowAdapter i2 = m16551i(i);
        int a = i - m8629a((FbListAdapter) i2);
        return i2.s_(a) + m16540a(i2);
    }

    public final int t_(int i) {
        FbListAdapter j = m16539j(i);
        int a = i - m16540a((MultiRowAdapter) j);
        return j.t_(a) + m8629a(j);
    }

    public final int m16549g(int i) {
        FbListAdapter j = m16539j(i);
        int a = i - m16540a((MultiRowAdapter) j);
        return j.g(a) + m8629a(j);
    }

    public final int m16547e() {
        return this.f10387c;
    }

    public final int m16550h(int i) {
        FbListAdapter i2 = m16551i(i);
        return i2.h(i - m8629a(i2));
    }

    public final RowIdentifier m16548f() {
        return this.f10386b;
    }

    private RowIdentifier m16538d() {
        return new C06241(this);
    }

    public final void m16542a(Configuration configuration) {
        for (MultiRowAdapter a : this.f10385a) {
            a.a(configuration);
        }
    }

    public final void m16543a(DumpsysContext dumpsysContext) {
        for (MultiRowAdapter a : this.f10385a) {
            a.a(dumpsysContext);
        }
    }

    public final Marker m16544b(int i) {
        FbListAdapter i2 = m16551i(i);
        return i2.b(i - m8629a(i2));
    }

    public final MultiRowAdapter m16551i(int i) {
        return (MultiRowAdapter) super.mo1039a(i);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        int i = 0;
        for (MultiRowAdapter multiRowAdapter : this.f10385a) {
            int a;
            if (multiRowAdapter.f() != null) {
                a = multiRowAdapter.f().a() + i;
            } else {
                a = i;
            }
            i = a;
        }
        this.f10388d = i;
        int i2 = 0;
        for (i = 0; i < this.f10385a.size(); i++) {
            i2 += ((MultiRowAdapter) this.f10385a.get(i)).e();
        }
        this.f10387c = i2;
    }

    private MultiRowAdapter m16539j(int i) {
        int i2 = i;
        for (MultiRowAdapter multiRowAdapter : this.f10385a) {
            int e = multiRowAdapter.e();
            if (i2 < e) {
                return multiRowAdapter;
            }
            i2 -= e;
        }
        throw new IllegalArgumentException("FeedEdgeIndex should be less than total feed edge count, feedEdgeIndex = " + i + " ,feedEdgeCount = " + m16547e());
    }

    public final int m16540a(MultiRowAdapter multiRowAdapter) {
        int i = 0;
        for (MultiRowAdapter multiRowAdapter2 : this.f10385a) {
            if (multiRowAdapter == multiRowAdapter2) {
                return i;
            }
            i = multiRowAdapter2.e() + i;
        }
        throw new IllegalArgumentException("Given MultiRowAdapter isn't part of list adapter.");
    }
}

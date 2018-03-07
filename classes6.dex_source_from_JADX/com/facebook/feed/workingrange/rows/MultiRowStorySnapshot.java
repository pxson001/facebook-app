package com.facebook.feed.workingrange.rows;

import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.workingrange.AdapterPrefixCounter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.workingrange.core.SnapshotWithVisiblity;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: media_upload_sequence */
public class MultiRowStorySnapshot<Adapter extends AdapterCompatibleWithListView & HasMultiRow> implements SnapshotWithVisiblity<FeedEdge> {
    private final Adapter f10450a;
    private int f10451b = Integer.MIN_VALUE;
    private int f10452c = Integer.MIN_VALUE;

    @Nullable
    public final Object mo1043a(int i) {
        if (!m16618c(i)) {
            return null;
        }
        int t_ = ((HasMultiRow) this.f10450a).t_(i);
        if (t_ == Integer.MIN_VALUE) {
            return null;
        }
        Object item = this.f10450a.getItem(t_);
        if (item instanceof BoundedAdapter) {
            return ((BoundedAdapter) item).d;
        }
        return null;
    }

    public MultiRowStorySnapshot(Adapter adapter) {
        this.f10450a = adapter;
    }

    public final int mo1042a() {
        return this.f10451b;
    }

    public final int mo1044b() {
        return this.f10452c;
    }

    public final void m16623a(int i, int i2, AdapterPrefixCounter adapterPrefixCounter) {
        m16616c(i, i2, adapterPrefixCounter);
    }

    public final void m16625b(int i, int i2, AdapterPrefixCounter adapterPrefixCounter) {
        m16616c(i, m16619c(i, i2) ? 0 : (i + i2) - 1, adapterPrefixCounter);
    }

    private void m16616c(int i, int i2, AdapterPrefixCounter adapterPrefixCounter) {
        if (m16614a(i, i2)) {
            m16620d();
            return;
        }
        int a = adapterPrefixCounter.a();
        int i3 = i - a;
        a = i2 - a;
        if (m16615b(i3, a)) {
            m16620d();
            return;
        }
        i3 = Math.max(i3, 0);
        int min = Math.min(a, this.f10450a.aZ_() - 1);
        try {
            this.f10451b = ((HasMultiRow) this.f10450a).s_(i3);
            this.f10452c = ((HasMultiRow) this.f10450a).s_(min);
            if (!m16617c()) {
                m16620d();
            }
        } catch (IndexOutOfBoundsException e) {
            m16620d();
        }
    }

    private boolean m16614a(int i, int i2) {
        return i < 0 || i2 < 0 || m16619c(i, i2) || this.f10450a.aZ_() == 0;
    }

    private static boolean m16615b(int i, int i2) {
        return i < 0 && i2 < 0;
    }

    private static boolean m16619c(int i, int i2) {
        return i == 0 && i2 == 0;
    }

    private boolean m16617c() {
        return this.f10451b <= this.f10452c && m16618c(this.f10451b) && m16618c(this.f10452c);
    }

    private void m16620d() {
        this.f10451b = Integer.MIN_VALUE;
        this.f10452c = Integer.MIN_VALUE;
    }

    private boolean m16618c(int i) {
        return i >= 0 && i < this.f10450a.aZ_();
    }
}

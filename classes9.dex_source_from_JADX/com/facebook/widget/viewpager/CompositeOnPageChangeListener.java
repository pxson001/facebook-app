package com.facebook.widget.viewpager;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: shareable_attachment */
public class CompositeOnPageChangeListener implements OnPageChangeListener {
    public final ArrayList<OnPageChangeListener> f3566a;

    public CompositeOnPageChangeListener() {
        this.f3566a = new ArrayList();
    }

    public CompositeOnPageChangeListener(ImmutableList<OnPageChangeListener> immutableList) {
        this();
        this.f3566a.addAll(immutableList);
    }

    public final void m3355a(int i, float f, int i2) {
        Iterator it = this.f3566a.iterator();
        while (it.hasNext()) {
            ((OnPageChangeListener) it.next()).a(i, f, i2);
        }
    }

    public final void e_(int i) {
        Iterator it = this.f3566a.iterator();
        while (it.hasNext()) {
            ((OnPageChangeListener) it.next()).e_(i);
        }
    }

    public final void m3356b(int i) {
        Iterator it = this.f3566a.iterator();
        while (it.hasNext()) {
            ((OnPageChangeListener) it.next()).b(i);
        }
    }
}

package com.facebook.widget.viewadapterpreallocator;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: method/messaging.attachmentRedirect */
public class ViewAdapterPreallocator<VH extends ViewHolder> {
    protected final PreallocatingAdapter<VH> f13590a;
    protected final HashMap<Integer, ViewAllocations<VH>> f13591b = Maps.m838c();
    public final WeakReference<ViewGroup> f13592c;
    private final ExecutorService f13593d;
    private final int f13594e;
    private final Runnable f13595f = new C05511(this);
    private AllocationTask f13596g;
    private int f13597h;
    private int f13598i;
    private boolean f13599j;
    public boolean f13600k;

    /* compiled from: method/messaging.attachmentRedirect */
    class C05511 implements Runnable {
        final /* synthetic */ ViewAdapterPreallocator f13601a;

        C05511(ViewAdapterPreallocator viewAdapterPreallocator) {
            this.f13601a = viewAdapterPreallocator;
        }

        public void run() {
            if (!this.f13601a.f13600k) {
                this.f13601a.m19992b();
            }
        }
    }

    @Inject
    public ViewAdapterPreallocator(@Assisted PreallocatingAdapter<VH> preallocatingAdapter, @Assisted ViewGroup viewGroup, @Assisted Integer num, IdleExecutor idleExecutor) {
        this.f13590a = preallocatingAdapter;
        this.f13592c = new WeakReference(viewGroup);
        this.f13594e = num.intValue();
        this.f13593d = idleExecutor;
    }

    public final void m19991a() {
        m19987i();
        this.f13600k = false;
        ExecutorDetour.a(this.f13593d, this.f13595f, 847387008);
    }

    protected final void m19992b() {
        m19998f();
        this.f13597h = Math.min(this.f13590a.aZ_() - 1, this.f13590a.mo2655b());
        this.f13598i = this.f13597h;
        m19995c();
    }

    protected void m19995c() {
        this.f13596g = new AllocationTask(this, this.f13593d);
        ExecutorDetour.a(this.f13593d, this.f13596g, -1534483689);
    }

    private void m19987i() {
        this.f13600k = true;
        if (this.f13596g != null) {
            this.f13596g.m19816a();
            this.f13596g = null;
        }
    }

    public final void m19996d() {
        m19987i();
        this.f13591b.clear();
    }

    public final VH m19990a(int i) {
        ViewAllocations c = m19994c(i);
        if (c.f19218d.isEmpty()) {
            c.m26921b();
        }
        return (ViewHolder) c.f19218d.pop();
    }

    protected final int m19997e() {
        return Math.min(this.f13590a.aZ_(), this.f13594e);
    }

    protected void m19998f() {
        int i;
        for (Integer intValue : this.f13591b.keySet()) {
            m19994c(intValue.intValue()).f19217c = 0;
        }
        int aZ_ = this.f13590a.aZ_();
        int e = m19997e();
        for (i = 0; i < e; i++) {
            m19993b(i);
        }
        int i2 = 1;
        for (i = m19997e(); i < aZ_; i++) {
            ViewAllocations c = m19994c(this.f13590a.getItemViewType(i2 - 1));
            c.f19217c--;
            m19993b(i);
            i2++;
        }
    }

    protected final void m19993b(int i) {
        ViewAllocations c = m19994c(this.f13590a.getItemViewType(i));
        c.f19217c++;
        c.f19216b = Math.max(c.f19216b, c.f19217c);
    }

    protected final ViewAllocations<VH> m19994c(final int i) {
        if (!this.f13591b.containsKey(Integer.valueOf(i))) {
            this.f13591b.put(Integer.valueOf(i), new ViewAllocations(new Callable<VH>(this) {
                final /* synthetic */ ViewAdapterPreallocator f19221b;

                @Nullable
                public Object call() {
                    ViewGroup viewGroup = (ViewGroup) this.f19221b.f13592c.get();
                    if (viewGroup == null) {
                        return null;
                    }
                    return this.f19221b.f13590a.a_(viewGroup, i);
                }
            }));
        }
        return (ViewAllocations) this.f13591b.get(Integer.valueOf(i));
    }

    protected final void m19999g() {
        Object obj = (this.f13599j || this.f13598i < 0) ? 1 : null;
        if ((obj == null || !m19989k()) && !m19988j()) {
            m19989k();
        }
    }

    private boolean m19988j() {
        boolean z = false;
        while (this.f13598i >= 0) {
            ViewAllocations d = m19986d(this.f13598i);
            this.f13598i--;
            if (m19985a(d)) {
                if (!this.f13599j) {
                    z = true;
                }
                this.f13599j = z;
                return true;
            }
        }
        return false;
    }

    private boolean m19989k() {
        boolean z = false;
        while (this.f13597h < this.f13590a.aZ_()) {
            ViewAllocations d = m19986d(this.f13597h);
            this.f13597h++;
            if (m19985a(d)) {
                if (!this.f13599j) {
                    z = true;
                }
                this.f13599j = z;
                return true;
            }
        }
        return false;
    }

    private ViewAllocations m19986d(int i) {
        return m19994c(this.f13590a.getItemViewType(i));
    }

    private static boolean m19985a(ViewAllocations viewAllocations) {
        if (viewAllocations.f19215a >= viewAllocations.f19216b) {
            return false;
        }
        viewAllocations.m26921b();
        return true;
    }

    protected final boolean m20000h() {
        return this.f13597h < this.f13590a.aZ_() || this.f13598i >= 0;
    }
}

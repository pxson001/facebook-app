package com.facebook.messaging.viewport;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: change_nonce_using_password */
public class MessageEventMonitor<T> extends OnScrollListener implements ScrollingViewProxy.OnScrollListener {
    private int f18348a = -1;
    private int f18349b = -1;
    public boolean f18350c = true;
    public boolean f18351d = true;
    private final Function<Object, T> f18352e;
    private final List<MessageEnterListener<T>> f18353f;
    private final List<Object<T>> f18354g;
    private final Set<T> f18355h;
    private final AbstractFbErrorReporter f18356i;

    @Inject
    public MessageEventMonitor(@Assisted Function<Object, T> function, FbErrorReporter fbErrorReporter) {
        this.f18352e = function;
        this.f18356i = fbErrorReporter;
        this.f18353f = new ArrayList();
        this.f18354g = new ArrayList();
        this.f18355h = new HashSet();
    }

    public final void m18359a(MessageEnterListener<T> messageEnterListener) {
        if (!this.f18353f.contains(messageEnterListener)) {
            this.f18353f.add(messageEnterListener);
        }
    }

    public final void m18361a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (!this.f18350c || !this.f18351d) {
        }
    }

    public final void m18356a() {
        this.f18355h.clear();
    }

    public final void m18362a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f18350c && this.f18351d && !m18353b(scrollingViewProxy)) {
            TracerDetour.a("MessageEventMonitor.onScroll", -744457114);
            try {
                int s = scrollingViewProxy.s();
                int i4 = this.f18348a;
                int i5 = this.f18349b;
                this.f18348a = i;
                this.f18349b = (i + i2) - 1;
                if (i4 != this.f18348a || i5 != this.f18349b) {
                    if (i4 == -1 || i5 == -1 || i4 >= s || i5 >= s) {
                        TracerDetour.a(-74162128);
                        return;
                    }
                    m18350b(scrollingViewProxy, i4);
                    m18345a(scrollingViewProxy, i5, s);
                    m18351b(scrollingViewProxy, i4, s);
                    m18354c(scrollingViewProxy, i5);
                    TracerDetour.a(1465445919);
                }
            } finally {
                TracerDetour.a(1422710503);
            }
        }
    }

    public final void m18358a(RecyclerView recyclerView, int i, int i2) {
        if ((recyclerView.getLayoutManager() instanceof LinearLayoutManager) && (recyclerView.getAdapter() instanceof AdapterCompatibleWithListView)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            AdapterCompatibleWithListView adapterCompatibleWithListView = (AdapterCompatibleWithListView) recyclerView.getAdapter();
            TracerDetour.a("MessageEventMonitor.onScroll", -1741821794);
            try {
                int aZ_ = recyclerView.getAdapter().aZ_();
                int i3 = this.f18348a;
                int i4 = this.f18349b;
                this.f18348a = linearLayoutManager.l();
                this.f18349b = linearLayoutManager.n();
                if (i3 != this.f18348a || i4 != this.f18349b) {
                    if (i3 >= aZ_ || i4 >= aZ_ || i3 == -1 || i4 == -1) {
                        TracerDetour.a(1906435081);
                        return;
                    }
                    m18343a(adapterCompatibleWithListView, i3);
                    m18344a(adapterCompatibleWithListView, i4, aZ_);
                    m18349b(adapterCompatibleWithListView, i3, aZ_);
                    m18348b(adapterCompatibleWithListView, i4);
                    TracerDetour.a(2626350);
                }
            } finally {
                TracerDetour.a(545569730);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final void m18357a(LinearLayoutManager linearLayoutManager, AdapterCompatibleWithListView adapterCompatibleWithListView) {
        if (this.f18350c && this.f18351d && linearLayoutManager != null && linearLayoutManager.v() != 0) {
            TracerDetour.a("MessageEventMonitor.onViewportChanged", 1082378695);
            try {
                Object apply;
                int aZ_ = adapterCompatibleWithListView.aZ_();
                List arrayList = new ArrayList(this.f18355h);
                this.f18348a = linearLayoutManager.l();
                this.f18349b = linearLayoutManager.n();
                int i = this.f18348a;
                while (i <= this.f18349b && i < aZ_) {
                    apply = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
                    if (m18346a(apply)) {
                        m18352b(apply);
                    }
                    arrayList.remove(apply);
                    i++;
                }
                aZ_ = arrayList.size();
                for (i = 0; i < aZ_; i++) {
                    apply = arrayList.get(i);
                    if (apply != null && this.f18355h.remove(apply)) {
                        m18355c(apply);
                    }
                }
            } finally {
                TracerDetour.a(11165573);
            }
        }
    }

    public final void m18360a(ScrollingViewProxy scrollingViewProxy) {
        if (this.f18350c && this.f18351d && !m18353b(scrollingViewProxy)) {
            TracerDetour.a("MessageEventMonitor.onViewportChanged", 395533293);
            try {
                Object apply;
                int s = scrollingViewProxy.s();
                List arrayList = new ArrayList(this.f18355h);
                this.f18348a = scrollingViewProxy.q();
                this.f18349b = scrollingViewProxy.r();
                int i = this.f18348a;
                while (i <= this.f18349b && i < s) {
                    apply = this.f18352e.apply(scrollingViewProxy.g(i));
                    if (m18346a(apply)) {
                        m18352b(apply);
                    }
                    arrayList.remove(apply);
                    i++;
                }
                s = arrayList.size();
                for (i = 0; i < s; i++) {
                    apply = arrayList.get(i);
                    if (apply != null && this.f18355h.remove(apply)) {
                        m18355c(apply);
                    }
                }
            } finally {
                TracerDetour.a(606821864);
            }
        }
    }

    private void m18350b(ScrollingViewProxy scrollingViewProxy, int i) {
        while (i >= this.f18348a && i >= 0) {
            Object apply = this.f18352e.apply(scrollingViewProxy.g(i));
            if (m18346a(apply)) {
                m18352b(apply);
            }
            i--;
        }
    }

    private void m18345a(ScrollingViewProxy scrollingViewProxy, int i, int i2) {
        while (i <= this.f18349b && i < i2) {
            Object apply = this.f18352e.apply(scrollingViewProxy.g(i));
            if (m18346a(apply)) {
                m18352b(apply);
            }
            i++;
        }
    }

    private void m18351b(ScrollingViewProxy scrollingViewProxy, int i, int i2) {
        Object apply = this.f18352e.apply(scrollingViewProxy.g(i));
        while (i <= this.f18348a && i < i2) {
            Object apply2 = this.f18352e.apply(scrollingViewProxy.g(i));
            if (m18347a(apply2, apply)) {
                m18355c(apply);
            }
            i++;
            apply = apply2;
        }
    }

    private void m18354c(ScrollingViewProxy scrollingViewProxy, int i) {
        Object apply = this.f18352e.apply(scrollingViewProxy.g(i));
        while (i >= this.f18349b && i >= 0) {
            Object apply2 = this.f18352e.apply(scrollingViewProxy.g(i));
            if (m18347a(apply2, apply)) {
                m18355c(apply);
            }
            i--;
            apply = apply2;
        }
    }

    private void m18343a(AdapterCompatibleWithListView adapterCompatibleWithListView, int i) {
        while (i >= this.f18348a && i >= 0) {
            Object apply = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
            if (m18346a(apply)) {
                m18352b(apply);
            }
            i--;
        }
    }

    private void m18344a(AdapterCompatibleWithListView adapterCompatibleWithListView, int i, int i2) {
        while (i <= this.f18349b && i < i2) {
            Object apply = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
            if (m18346a(apply)) {
                m18352b(apply);
            }
            i++;
        }
    }

    private void m18349b(AdapterCompatibleWithListView adapterCompatibleWithListView, int i, int i2) {
        Object apply = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
        while (i <= this.f18348a && i < i2) {
            Object apply2 = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
            if (m18347a(apply2, apply)) {
                m18355c(apply);
            }
            i++;
            apply = apply2;
        }
    }

    private void m18348b(AdapterCompatibleWithListView adapterCompatibleWithListView, int i) {
        Object apply = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
        while (i >= this.f18349b && i >= 0) {
            Object apply2 = this.f18352e.apply(adapterCompatibleWithListView.getItem(i));
            if (m18347a(apply2, apply)) {
                m18355c(apply);
            }
            i--;
            apply = apply2;
        }
    }

    private boolean m18346a(T t) {
        return t != null && this.f18355h.add(t);
    }

    private boolean m18347a(T t, T t2) {
        return (t2 == null || t2.equals(t) || !this.f18355h.remove(t2)) ? false : true;
    }

    @VisibleForTesting
    private void m18352b(T t) {
        int size = this.f18353f.size();
        for (int i = 0; i < size; i++) {
            ((MessageEnterListener) this.f18353f.get(i)).mo315a(t);
        }
    }

    @VisibleForTesting
    private void m18355c(T t) {
        int size = this.f18354g.size();
        for (int i = 0; i < size; i++) {
            this.f18354g.get(i);
        }
    }

    private static boolean m18353b(ScrollingViewProxy scrollingViewProxy) {
        if (scrollingViewProxy == null || scrollingViewProxy.t()) {
            return true;
        }
        return false;
    }
}

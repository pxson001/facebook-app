package com.facebook.accessibility;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: bd_profile_browser */
public abstract class UpdatableListAccessibilityDelegate<U> extends AccessibilityDelegateCompat {
    public static final ImmutableSet<Integer> f7994b = ImmutableSet.of(Integer.valueOf(2048), Integer.valueOf(4096));
    protected UpdateCollection<U> f7995c;
    public View f7996d;
    private ViewAccessibilityHelper f7997e;
    private ScheduledExecutorService f7998f;
    private ScheduledFuture f7999g;
    private final Runnable f8000h = new C09021(this);

    /* compiled from: bd_profile_browser */
    class C09021 implements Runnable {
        final /* synthetic */ UpdatableListAccessibilityDelegate f7993a;

        C09021(UpdatableListAccessibilityDelegate updatableListAccessibilityDelegate) {
            this.f7993a = updatableListAccessibilityDelegate;
        }

        public void run() {
            UpdatableListAccessibilityDelegate.m14127h(this.f7993a);
        }
    }

    /* compiled from: bd_profile_browser */
    public interface UpdateCollection<U> {
        void m14123a(U u);

        boolean m14124a();

        void m14125b();
    }

    protected abstract boolean m14134b(U u);

    protected abstract UpdateCollection<U> m14137e();

    protected abstract CharSequence m14138f();

    public UpdatableListAccessibilityDelegate(ViewAccessibilityHelper viewAccessibilityHelper, ScheduledExecutorService scheduledExecutorService) {
        this.f7997e = viewAccessibilityHelper;
        this.f7998f = scheduledExecutorService;
        this.f7995c = m14137e();
    }

    public final void m14136d(View view, AccessibilityEvent accessibilityEvent) {
        if (!m14131a(accessibilityEvent.getEventType())) {
            super.d(view, accessibilityEvent);
        }
    }

    public final void m14130a(List<U> list) {
        Object obj = null;
        for (Object next : list) {
            if (m14134b(next)) {
                obj = 1;
                this.f7995c.m14123a(next);
            }
        }
        if (obj != null) {
            m14126g();
        }
    }

    public void m14129a(U u) {
        if (m14134b((Object) u)) {
            this.f7995c.m14123a(u);
            m14126g();
        }
    }

    public final void m14132b() {
        if (this.f7999g != null) {
            this.f7999g.cancel(false);
        }
        m14128i();
        this.f7996d = null;
    }

    public final void m14133b(View view) {
        this.f7996d = view;
    }

    private void m14126g() {
        if (!this.f7995c.m14124a()) {
            if (this.f7999g != null) {
                this.f7999g.cancel(false);
            }
            this.f7999g = this.f7998f.schedule(this.f8000h, m14135d(), TimeUnit.MILLISECONDS);
        }
    }

    public static void m14127h(UpdatableListAccessibilityDelegate updatableListAccessibilityDelegate) {
        updatableListAccessibilityDelegate.f7999g.cancel(false);
        updatableListAccessibilityDelegate.f7997e.a(updatableListAccessibilityDelegate.f7996d, updatableListAccessibilityDelegate.m14138f());
        updatableListAccessibilityDelegate.m14128i();
    }

    private void m14128i() {
        this.f7995c.m14125b();
    }

    protected boolean m14131a(int i) {
        return f7994b.contains(Integer.valueOf(i)) && !this.f7995c.m14124a();
    }

    protected long m14135d() {
        return 1500;
    }
}

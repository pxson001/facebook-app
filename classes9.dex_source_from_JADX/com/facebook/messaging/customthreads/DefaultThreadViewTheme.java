package com.facebook.messaging.customthreads;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadSummary;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mediaResult */
public class DefaultThreadViewTheme {
    public final EphemeralGatingUtil f10268a;
    private final Provider<Boolean> f10269b;
    private final Provider<Boolean> f10270c;
    private final Resources f10271d;
    private final List<ThreadViewTheme$Listener> f10272e = new ArrayList();
    private final int f10273f;
    private final int f10274g;
    public ThreadCustomization f10275h;
    public boolean f10276i;
    public boolean f10277j;
    private int f10278k;
    private int f10279l;
    private int f10280m;
    private int f10281n;
    private int f10282o;
    private int f10283p;
    private int f10284q;

    public static DefaultThreadViewTheme m10881b(InjectorLike injectorLike) {
        return new DefaultThreadViewTheme(EphemeralGatingUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4144), IdBasedProvider.a(injectorLike, 4073), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public static DefaultThreadViewTheme m10879a(InjectorLike injectorLike) {
        return m10881b(injectorLike);
    }

    @Inject
    public DefaultThreadViewTheme(EphemeralGatingUtil ephemeralGatingUtil, Provider<Boolean> provider, Provider<Boolean> provider2, Resources resources) {
        this.f10268a = ephemeralGatingUtil;
        this.f10269b = provider;
        this.f10270c = provider2;
        this.f10271d = resources;
        this.f10273f = this.f10271d.getColor(2131362450);
        this.f10274g = -1;
    }

    public final void m10888a(ThreadCustomization threadCustomization) {
        this.f10275h = threadCustomization;
        m10882i();
        for (ThreadViewTheme$Listener a : this.f10272e) {
            a.mo320a();
        }
    }

    public final void m10889a(ThreadSummary threadSummary) {
        this.f10276i = this.f10268a.a(threadSummary);
        boolean z = threadSummary != null && ThreadKey.g(threadSummary.a);
        this.f10277j = z;
        m10888a(threadSummary.D);
    }

    public final void m10891b() {
        this.f10276i = false;
        this.f10277j = false;
        m10888a(new ThreadCustomization());
    }

    public final int m10885a(ThreadViewTheme$BubbleType threadViewTheme$BubbleType, ThreadViewTheme$SenderType threadViewTheme$SenderType) {
        int color = this.f10271d.getColor(threadViewTheme$SenderType == ThreadViewTheme$SenderType.ME ? 2131362437 : 2131362438);
        if (!((Boolean) this.f10269b.get()).booleanValue() || this.f10275h == null) {
            return color;
        }
        int color2;
        int color3;
        if (threadViewTheme$BubbleType == ThreadViewTheme$BubbleType.EPHEMERAL && !this.f10268a.a()) {
            color2 = this.f10271d.getColor(2131362453);
            color3 = this.f10271d.getColor(2131362456);
        } else if (threadViewTheme$BubbleType == ThreadViewTheme$BubbleType.TINCAN) {
            color2 = this.f10271d.getColor(2131362549);
            color3 = this.f10271d.getColor(2131362438);
        } else {
            color2 = this.f10275h.c;
            color3 = this.f10275h.d;
        }
        if (threadViewTheme$SenderType != ThreadViewTheme$SenderType.ME) {
            color2 = color3;
        }
        return m10878a(color2, color);
    }

    public final int m10890b(ThreadViewTheme$SenderType threadViewTheme$SenderType) {
        if (this.f10280m == 0) {
            m10882i();
        }
        return threadViewTheme$SenderType == ThreadViewTheme$SenderType.ME ? this.f10280m : this.f10281n;
    }

    public final int m10894c(ThreadViewTheme$SenderType threadViewTheme$SenderType) {
        if (this.f10278k == 0) {
            m10882i();
        }
        return threadViewTheme$SenderType == ThreadViewTheme$SenderType.ME ? this.f10278k : this.f10279l;
    }

    public final int m10893c() {
        if (this.f10282o == 0) {
            m10882i();
        }
        return this.f10282o;
    }

    public final int m10895d() {
        if (this.f10283p == 0) {
            m10882i();
        }
        return this.f10283p;
    }

    public final int m10896e() {
        if (this.f10284q == 0) {
            m10882i();
        }
        return this.f10284q;
    }

    private void m10882i() {
        this.f10278k = m10880b(ThreadViewTheme$BubbleType.NORMAL, ThreadViewTheme$SenderType.ME);
        this.f10279l = m10880b(ThreadViewTheme$BubbleType.NORMAL, ThreadViewTheme$SenderType.OTHER);
        this.f10280m = m10880b(ThreadViewTheme$BubbleType.EPHEMERAL, ThreadViewTheme$SenderType.ME);
        this.f10281n = m10880b(ThreadViewTheme$BubbleType.EPHEMERAL, ThreadViewTheme$SenderType.OTHER);
        int f = m10897f();
        if (f == m10883j()) {
            this.f10282o = -16777216;
            this.f10284q = m10885a(ThreadViewTheme$BubbleType.NORMAL, ThreadViewTheme$SenderType.ME);
            this.f10283p = this.f10271d.getColor(2131362311);
            return;
        }
        this.f10282o = m10877a(f);
        this.f10284q = this.f10282o;
        int i = this.f10284q;
        this.f10283p = Color.argb((int) (((float) Color.alpha(i)) * 0.6f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final int m10897f() {
        if (!((Boolean) this.f10269b.get()).booleanValue() || this.f10275h == null) {
            return m10883j();
        }
        return m10878a(this.f10275h.b == -1 ? 0 : this.f10275h.b, m10883j());
    }

    private int m10883j() {
        return ((Boolean) this.f10270c.get()).booleanValue() ? this.f10273f : this.f10274g;
    }

    public final String m10898g() {
        if (!((Boolean) this.f10269b.get()).booleanValue() || this.f10275h == null) {
            return null;
        }
        return this.f10275h.f;
    }

    public final int m10884a(ThreadViewTheme$BubbleType threadViewTheme$BubbleType) {
        return m10885a(threadViewTheme$BubbleType, ThreadViewTheme$SenderType.ME);
    }

    public final void m10887a(ThreadViewTheme$Listener threadViewTheme$Listener) {
        this.f10272e.add(threadViewTheme$Listener);
    }

    public final void m10892b(ThreadViewTheme$Listener threadViewTheme$Listener) {
        this.f10272e.remove(threadViewTheme$Listener);
    }

    public final int m10886a(ThreadViewTheme$SenderType threadViewTheme$SenderType) {
        ThreadViewTheme$BubbleType threadViewTheme$BubbleType = ThreadViewTheme$BubbleType.NORMAL;
        if (this.f10276i) {
            threadViewTheme$BubbleType = ThreadViewTheme$BubbleType.EPHEMERAL;
        } else if (this.f10277j) {
            threadViewTheme$BubbleType = ThreadViewTheme$BubbleType.TINCAN;
        }
        return m10885a(threadViewTheme$BubbleType, threadViewTheme$SenderType);
    }

    private int m10880b(ThreadViewTheme$BubbleType threadViewTheme$BubbleType, ThreadViewTheme$SenderType threadViewTheme$SenderType) {
        return m10877a(m10885a(threadViewTheme$BubbleType, threadViewTheme$SenderType));
    }

    private static int m10877a(int i) {
        Object obj = (i == 0 || ColorUtils.a(i) >= 0.7d) ? 1 : null;
        return obj != null ? -16777216 : -1;
    }

    private static int m10878a(int i, int i2) {
        return i != 0 ? i : i2;
    }
}

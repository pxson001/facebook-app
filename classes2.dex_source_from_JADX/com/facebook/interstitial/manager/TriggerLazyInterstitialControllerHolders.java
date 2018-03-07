package com.facebook.interstitial.manager;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: publish_photo */
public class TriggerLazyInterstitialControllerHolders {
    public final InterstitialTrigger f8661a;
    public volatile boolean f8662b = false;
    @GuardedBy("this")
    private final Map<String, RankedLazyInterstitialControllerHolder> f8663c = Maps.m838c();
    @GuardedBy("this")
    private final SortedSet<RankedLazyInterstitialControllerHolder> f8664d = Sets.m1329d();
    private final String f8665e;
    private final Throwable f8666f;

    public TriggerLazyInterstitialControllerHolders(InterstitialTrigger interstitialTrigger, String str) {
        this.f8661a = (InterstitialTrigger) Preconditions.checkNotNull(interstitialTrigger);
        this.f8665e = str;
        this.f8666f = new Throwable("Added Reason: " + str);
    }

    public final void m13473a() {
        Preconditions.checkArgument(this.f8662b, StringFormatUtil.formatStrLocaleSafe("Trigger %s is not know to be fully restored!", this.f8661a));
    }

    public final boolean m13477b() {
        return this.f8662b;
    }

    public final void m13480c() {
        this.f8662b = true;
    }

    public final synchronized boolean m13474a(LazyInterstitialControllerHolder lazyInterstitialControllerHolder, int i) {
        boolean b;
        Preconditions.checkNotNull(lazyInterstitialControllerHolder);
        if (((RankedLazyInterstitialControllerHolder) this.f8663c.get(lazyInterstitialControllerHolder.f8657a)) != null) {
            b = m13478b(lazyInterstitialControllerHolder, i);
        } else {
            b = m13470c(lazyInterstitialControllerHolder, i);
        }
        return b;
    }

    public final synchronized boolean m13478b(LazyInterstitialControllerHolder lazyInterstitialControllerHolder, int i) {
        boolean z;
        Preconditions.checkNotNull(lazyInterstitialControllerHolder);
        RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder = (RankedLazyInterstitialControllerHolder) this.f8663c.get(lazyInterstitialControllerHolder.f8657a);
        if (rankedLazyInterstitialControllerHolder == null) {
            z = false;
        } else if (rankedLazyInterstitialControllerHolder.f8667a == i) {
            z = false;
        } else {
            this.f8664d.remove(rankedLazyInterstitialControllerHolder);
            z = m13470c(lazyInterstitialControllerHolder, i);
        }
        return z;
    }

    private synchronized boolean m13470c(LazyInterstitialControllerHolder lazyInterstitialControllerHolder, int i) {
        Preconditions.checkNotNull(lazyInterstitialControllerHolder);
        String str = lazyInterstitialControllerHolder.f8657a;
        RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder = new RankedLazyInterstitialControllerHolder(i, lazyInterstitialControllerHolder);
        this.f8663c.put(str, rankedLazyInterstitialControllerHolder);
        this.f8664d.add(rankedLazyInterstitialControllerHolder);
        return true;
    }

    public final synchronized List<String> m13481d() {
        List<String> b;
        b = Lists.m1305b(this.f8664d.size());
        for (RankedLazyInterstitialControllerHolder a : this.f8664d) {
            b.add(a.m13485a());
        }
        return b;
    }

    public final synchronized List<LazyInterstitialControllerHolder> m13482e() {
        List<LazyInterstitialControllerHolder> b;
        b = Lists.m1305b(this.f8664d.size());
        for (RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder : this.f8664d) {
            b.add(rankedLazyInterstitialControllerHolder.f8668b);
        }
        return b;
    }

    public final synchronized boolean m13475a(String str) {
        Preconditions.checkArgument(this.f8662b, "Before checking contain trigger controllers must be known to be fully restored!");
        return this.f8663c.containsKey(str);
    }

    public final synchronized boolean m13476a(Collection<LazyInterstitialControllerHolder> collection) {
        boolean z;
        m13472h();
        z = false;
        for (LazyInterstitialControllerHolder lazyInterstitialControllerHolder : collection) {
            z = m13471c(lazyInterstitialControllerHolder.f8657a) | z;
        }
        return z;
    }

    public final synchronized boolean m13479b(String str) {
        m13472h();
        return m13471c(str);
    }

    private synchronized boolean m13471c(String str) {
        boolean z;
        RankedLazyInterstitialControllerHolder rankedLazyInterstitialControllerHolder = (RankedLazyInterstitialControllerHolder) this.f8663c.remove(str);
        if (rankedLazyInterstitialControllerHolder != null) {
            this.f8664d.remove(rankedLazyInterstitialControllerHolder);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private void m13472h() {
        Preconditions.checkArgument(this.f8662b, "Before removing all trigger controllers must be known to be fully restored!");
    }

    public synchronized String toString() {
        return Objects.toStringHelper((Object) this).add("KnowinglyFullyRestored", this.f8662b).add("Trigger", this.f8661a).add("RankedInterstitials", this.f8664d).toString();
    }

    public final synchronized String m13483f() {
        List arrayList;
        arrayList = new ArrayList();
        if (this.f8664d != null) {
            for (RankedLazyInterstitialControllerHolder a : this.f8664d) {
                arrayList.add(a.m13485a());
            }
        }
        return "[Debug cause: " + this.f8665e + ", currentInterstitials: " + arrayList + "]";
    }

    public final Throwable m13484g() {
        return this.f8666f;
    }
}

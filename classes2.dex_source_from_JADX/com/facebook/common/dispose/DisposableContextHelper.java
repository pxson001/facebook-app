package com.facebook.common.dispose;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: survey_unhide_feed_unit */
public class DisposableContextHelper {
    private final DefaultAndroidThreadUtil f3733a;
    @GuardedBy("this")
    private boolean f3734b;
    @GuardedBy("this while onDestroyEntered == false")
    private Set<ListenableDisposable> f3735c;

    public static DisposableContextHelper m6133b(InjectorLike injectorLike) {
        return new DisposableContextHelper(DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public DisposableContextHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f3733a = defaultAndroidThreadUtil;
    }

    public final synchronized void m6136a(AbstractListenableDisposable abstractListenableDisposable) {
        Preconditions.checkNotNull(abstractListenableDisposable);
        if (this.f3734b) {
            this.f3733a.m1656b(new 1(this, abstractListenableDisposable));
        } else {
            if (this.f3735c == null) {
                this.f3735c = Sets.m1313a();
            }
            this.f3735c.add(abstractListenableDisposable);
            abstractListenableDisposable.m6203a(new 2(this));
        }
    }

    public static synchronized void m6134b(DisposableContextHelper disposableContextHelper, AbstractListenableDisposable abstractListenableDisposable) {
        synchronized (disposableContextHelper) {
            if (!disposableContextHelper.f3734b) {
                disposableContextHelper.f3735c.remove(abstractListenableDisposable);
            }
        }
    }

    public final void m6135a() {
        synchronized (this) {
            this.f3734b = true;
        }
        if (this.f3735c != null) {
            for (AbstractListenableDisposable jc_ : this.f3735c) {
                jc_.jc_();
            }
            this.f3735c.clear();
        }
    }
}

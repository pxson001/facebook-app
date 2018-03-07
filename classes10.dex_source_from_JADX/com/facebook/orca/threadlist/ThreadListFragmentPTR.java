package com.facebook.orca.threadlist;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.config.application.Product;
import com.facebook.messaging.quickpromotion.QuickPromotionTriggers;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass14;
import com.facebook.orca.threadlist.ThreadListFragment.RefreshType;
import javax.annotation.Nullable;

/* compiled from: native_event_listener_keys */
public class ThreadListFragmentPTR {
    public final SwipeRefreshLayout f6662a;
    @Nullable
    public AnonymousClass14 f6663b;
    public boolean f6664c = true;

    /* compiled from: native_event_listener_keys */
    class C10081 implements OnRefreshListener {
        final /* synthetic */ ThreadListFragmentPTR f6661a;

        C10081(ThreadListFragmentPTR threadListFragmentPTR) {
            this.f6661a = threadListFragmentPTR;
        }

        public final void m6370a() {
            if (this.f6661a.f6663b != null) {
                AnonymousClass14 anonymousClass14 = this.f6661a.f6663b;
                if (null != null) {
                    return;
                }
            }
            boolean z = this.f6661a.f6664c;
            this.f6661a.f6664c = true;
            if (this.f6661a.f6663b != null) {
                AnonymousClass14 anonymousClass142 = this.f6661a.f6663b;
                if (z) {
                    if (!anonymousClass142.f6602a.f6657f.isMusicActive()) {
                        if (anonymousClass142.f6602a.aQ != Product.MESSENGER) {
                            ThreadListFragment.aD(anonymousClass142.f6602a);
                        } else {
                            anonymousClass142.f6602a.aJ.i();
                        }
                    }
                    if (!ThreadListFragment.bc(anonymousClass142.f6602a)) {
                        ThreadListFragment.m6327a(anonymousClass142.f6602a, QuickPromotionTriggers.f3782b);
                    }
                    ThreadListFragment.m6350c(anonymousClass142.f6602a, "pull to refresh");
                    AnalyticsLogger analyticsLogger = anonymousClass142.f6602a.f6655d;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("pull_to_refresh");
                    honeyClientEvent.c = ThreadListFragment.bb(anonymousClass142.f6602a);
                    analyticsLogger.a(honeyClientEvent);
                }
                ThreadListFragment.m6331a(anonymousClass142.f6602a, RefreshType.EXPLICIT_USER_REFRESH, "user refresh");
            }
        }
    }

    ThreadListFragmentPTR(SwipeRefreshLayout swipeRefreshLayout) {
        this.f6662a = swipeRefreshLayout;
        this.f6662a.setProgressBackgroundColorSchemeResource(2131361920);
        this.f6662a.setColorSchemeResources(new int[]{2131362241});
        this.f6662a.e = new C10081(this);
    }

    public final void m6371a(AnonymousClass14 anonymousClass14) {
        this.f6663b = anonymousClass14;
    }

    public final void m6372b() {
        this.f6662a.setRefreshing(false);
    }
}

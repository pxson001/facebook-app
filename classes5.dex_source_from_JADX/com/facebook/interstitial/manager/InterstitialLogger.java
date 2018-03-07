package com.facebook.interstitial.manager;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.logging.LogInterstitialMethod;
import com.facebook.interstitial.logging.LogInterstitialParams;
import com.facebook.interstitial.logging.LogInterstitialParams.ActionType;
import com.facebook.interstitial.logging.LogInterstitialParams.LogInterstitialEvent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* compiled from: TOPIC_EVENT */
public class InterstitialLogger {
    public static final CallerContext f13869a = CallerContext.a(InterstitialManager.class);
    private final InterstitialManager f13870b;
    private final DefaultProcessIdleExecutor f13871c;
    public final Lazy<SingleMethodRunner> f13872d;
    public final Lazy<LogInterstitialMethod> f13873e;

    InterstitialLogger(InterstitialManager interstitialManager, IdleExecutor idleExecutor, Lazy<SingleMethodRunner> lazy, Lazy<LogInterstitialMethod> lazy2) {
        this.f13870b = interstitialManager;
        this.f13871c = idleExecutor;
        this.f13872d = lazy;
        this.f13873e = lazy2;
    }

    private ListenableFuture<OperationResult> m23242a(String str, LogInterstitialEvent logInterstitialEvent) {
        return m23243a(str, logInterstitialEvent, null);
    }

    private ListenableFuture<OperationResult> m23243a(String str, LogInterstitialEvent logInterstitialEvent, @Nullable ActionType actionType) {
        ImmutableMap e;
        Preconditions.checkNotNull(str);
        InterstitialController a = this.f13870b.a(str);
        Preconditions.checkNotNull(a);
        if (a instanceof InterstitialControllerWithExtraLogData) {
            e = ((InterstitialControllerWithExtraLogData) a).e();
        } else {
            e = RegularImmutableBiMap.a;
        }
        if (actionType != null) {
            Builder builder = ImmutableMap.builder();
            builder.a(e);
            builder.b("action_type", actionType.name());
            e = builder.b();
        }
        final LogInterstitialParams logInterstitialParams = new LogInterstitialParams(str, logInterstitialEvent, e);
        return this.f13871c.a(new Callable<OperationResult>(this) {
            final /* synthetic */ InterstitialLogger f13868b;

            public Object call() {
                ((AbstractSingleMethodRunner) this.f13868b.f13872d.get()).a((ApiMethod) this.f13868b.f13873e.get(), logInterstitialParams, InterstitialLogger.f13869a);
                return OperationResult.a;
            }
        });
    }

    public final void m23244a(String str) {
        m23242a(str, LogInterstitialEvent.IMPRESSION);
    }

    public final void m23245b(String str) {
        m23243a(str, LogInterstitialEvent.ACTION, ActionType.PRIMARY);
    }

    public final void m23246c(String str) {
        m23243a(str, LogInterstitialEvent.ACTION, ActionType.SECONDARY);
    }

    public final void m23247d(String str) {
        m23242a(str, LogInterstitialEvent.DISMISSAL);
    }

    public final ListenableFuture<OperationResult> m23248e(String str) {
        return m23242a(str, LogInterstitialEvent.RESET_VIEW_STATE);
    }
}

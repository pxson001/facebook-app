package com.facebook.growth.sem;

import android.content.Context;
import android.provider.Settings.Secure;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserSemResTrackingInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.growth.sem.graphql.UserSemResTrackingMutations.UserSemResTrackingMutationString;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import javax.inject.Inject;

/* compiled from: ru_RU */
public class SemTrackingLogger {
    private final Context f6340a;
    public final GraphQLQueryExecutor f6341b;
    private final DefaultProcessIdleExecutor f6342c;
    private final AnalyticsLogger f6343d;
    private final GatekeeperStoreImpl f6344e;

    /* compiled from: ru_RU */
    class C02781 implements Runnable {
        final /* synthetic */ SemTrackingLogger f6345a;

        C02781(SemTrackingLogger semTrackingLogger) {
            this.f6345a = semTrackingLogger;
        }

        public void run() {
            SemTrackingLogger semTrackingLogger = this.f6345a;
            UserSemResTrackingInputData userSemResTrackingInputData = new UserSemResTrackingInputData();
            userSemResTrackingInputData.m11397a("advertising_id", semTrackingLogger.m10719a(true));
            GraphQlCallInput graphQlCallInput = userSemResTrackingInputData;
            TypedGraphQLMutationString userSemResTrackingMutationString = new UserSemResTrackingMutationString();
            userSemResTrackingMutationString.m11310a("input", graphQlCallInput);
            semTrackingLogger.f6341b.m10448a(GraphQLRequest.m11588a(userSemResTrackingMutationString));
        }
    }

    public static SemTrackingLogger m10718b(InjectorLike injectorLike) {
        return new SemTrackingLogger((Context) injectorLike.getInstance(Context.class, ForAppContext.class), GraphQLQueryExecutor.m10435a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injectorLike));
    }

    @Inject
    public SemTrackingLogger(@ForAppContext Context context, GraphQLQueryExecutor graphQLQueryExecutor, DefaultProcessIdleExecutor defaultProcessIdleExecutor, AnalyticsLogger analyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6340a = context;
        this.f6341b = graphQLQueryExecutor;
        this.f6342c = defaultProcessIdleExecutor;
        this.f6343d = analyticsLogger;
        this.f6344e = gatekeeperStoreImpl;
    }

    public final void m10720a() {
        ExecutorDetour.a(this.f6342c, new C02781(this), -2019064278);
    }

    public final void m10721a(String str, String str2) {
        HoneyClientEventFast a = this.f6343d.mo535a("install_referrer_with_campaign", true);
        if (a.m17388a()) {
            a.m17379a("growth");
            a.m17385a("campaign_id", str);
            a.m17385a("ad_click_time", str2);
            a.m17385a("advertising_id", m10719a(true));
            a.m17390b();
        }
        if (this.f6344e.m2189a(32, true)) {
            ExecutorDetour.a(this.f6342c, new 2(this, str, str2), 21562997);
        }
    }

    public final String m10719a(boolean z) {
        CharSequence charSequence = null;
        try {
            charSequence = AdvertisingIdClient.a(this.f6340a).a();
        } catch (Exception e) {
        }
        if (z && StringUtil.m3589a(charSequence)) {
            return Secure.getString(this.f6340a.getContentResolver(), "android_id");
        }
        return charSequence;
    }
}

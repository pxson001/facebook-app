package com.facebook.structuredsurvey;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.context.DebugContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SurveyContextDataInputSurveyContextData;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.api.ParcelableStringArrayList;
import com.facebook.structuredsurvey.api.PostSurveyAnswersParams;
import com.facebook.structuredsurvey.api.PostSurveyImpressionsParams;
import com.facebook.structuredsurvey.graphql.C0694x5f57d37f;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQuery$SurveyIntegrationPointQueryString;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.util.SurveyNotificationHelper;
import com.facebook.structuredsurvey.util.tokenparams.SurveyTokenParamFactory;
import com.facebook.structuredsurvey.util.tokenparams.SurveyTokenParamResolver;
import com.facebook.survey.graphql.C0707x489dfaf0;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels$StructuredSurveySessionFragmentModel.SurveyModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyFragmentModel;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: low_power_time */
public class StructuredSurveyController {
    private static volatile StructuredSurveyController f15884J;
    public static final PrefKey f15885a = ((PrefKey) SharedPrefKeys.f994h.m2011a("structured_survey/intern_dev_mode_enabled"));
    public static final PrefKey f15886b = ((PrefKey) SharedPrefKeys.f994h.m2011a("structured_survey/intern_dev_mode_recent_survey_ ids"));
    public static final PrefKey f15887c = ((PrefKey) SharedPrefKeys.f994h.m2011a("structured_survey/intern_dev_mode_recent_integration_point_ids"));
    public static final String f15888d = ("NaRF:" + StructuredSurveyController.class.getSimpleName());
    public static final PrefKey f15889e = ((PrefKey) SharedPrefKeys.f994h.m2011a("structured_survey/last_invitation_impression_ts"));
    public String f15890A;
    public String f15891B;
    public String f15892C;
    private List<SurveyItem> f15893D;
    public Context f15894E;
    public Resources f15895F;
    private ListenableFuture<GraphQLResult<C0694x5f57d37f>> f15896G;
    public ListenableFuture<GraphQLResult<StructuredSurveyFragmentModel>> f15897H;
    public final Toaster f15898I;
    public final Lazy<GraphQLQueryExecutor> f15899f;
    public final Lazy<SurveyNotificationHelper> f15900g;
    private final Lazy<AnalyticsLogger> f15901h;
    public final ExecutorService f15902i;
    private final ExecutorService f15903j;
    public final AbstractFbErrorReporter f15904k;
    private final Provider<BlueServiceOperationFactory> f15905l;
    public final FbSharedPreferences f15906m;
    public final Clock f15907n;
    private final List<SurveyContextDataInputSurveyContextData> f15908o = new ArrayList();
    private final Map<String, String> f15909p = new HashMap();
    public StructuredSurveyFlowController f15910q;
    public StructuredSurveyBuilder f15911r;
    public StructuredSurveyState f15912s;
    public SurveyTokenParamFactory f15913t = new SurveyTokenParamFactory();
    public SurveyTokenParamResolver f15914u = new SurveyTokenParamResolver(this.f15913t);
    public String f15915v;
    public String f15916w;
    private String f15917x;
    public boolean f15918y;
    public boolean f15919z;

    public static com.facebook.structuredsurvey.StructuredSurveyController m22626a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15884J;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.structuredsurvey.StructuredSurveyController.class;
        monitor-enter(r1);
        r0 = f15884J;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22630b(r0);	 Catch:{ all -> 0x0035 }
        f15884J = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15884J;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.structuredsurvey.StructuredSurveyController.a(com.facebook.inject.InjectorLike):com.facebook.structuredsurvey.StructuredSurveyController");
    }

    private static StructuredSurveyController m22630b(InjectorLike injectorLike) {
        return new StructuredSurveyController(FbErrorReporterImpl.m2317a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2164), IdBasedLazy.m1808a(injectorLike, 11046), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedProvider.m1811a(injectorLike, 1144), C0055x2995691a.m1881a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), Toaster.m6454b(injectorLike));
    }

    @Inject
    public StructuredSurveyController(FbErrorReporter fbErrorReporter, Lazy<GraphQLQueryExecutor> lazy, Lazy<SurveyNotificationHelper> lazy2, Lazy<AnalyticsLogger> lazy3, Provider<BlueServiceOperationFactory> provider, ExecutorService executorService, ExecutorService executorService2, Resources resources, FbSharedPreferences fbSharedPreferences, Clock clock, Toaster toaster) {
        this.f15904k = fbErrorReporter;
        this.f15899f = lazy;
        this.f15900g = lazy2;
        this.f15901h = lazy3;
        this.f15905l = provider;
        this.f15902i = executorService;
        this.f15903j = executorService2;
        this.f15895F = resources;
        this.f15906m = fbSharedPreferences;
        this.f15907n = clock;
        this.f15915v = null;
        this.f15918y = false;
        this.f15919z = false;
        this.f15898I = toaster;
    }

    public final void m22636a(String str) {
        m22638a(str, null);
    }

    public final void m22638a(String str, @Nullable Runnable runnable) {
        m22639a(str, runnable, false);
    }

    public final void m22639a(final String str, @Nullable final Runnable runnable, final boolean z) {
        if (!m22650m()) {
            this.f15896G = ((GraphQLQueryExecutor) this.f15899f.get()).m10446a(GraphQLRequest.m11587a((SurveyIntegrationPointQuery$SurveyIntegrationPointQueryString) new SurveyIntegrationPointQuery$SurveyIntegrationPointQueryString().m11315a("integration_point_id", str).m11316a("survey_context_data", ImmutableList.copyOf(this.f15908o))).m11594a(GraphQLCachePolicy.f7109a).m11590a(3600));
            this.f15908o.clear();
            Futures.m2458a(this.f15896G, new FutureCallback<GraphQLResult<C0694x5f57d37f>>(this) {
                final /* synthetic */ StructuredSurveyController f16117d;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    try {
                        if (StringUtil.m3589a(this.f16117d.f15915v)) {
                            C0694x5f57d37f c0694x5f57d37f = (C0694x5f57d37f) graphQLResult.m10400d();
                            if (c0694x5f57d37f == null || c0694x5f57d37f.m22873j() == null) {
                                StructuredSurveyController.m22632c(this.f16117d, this.f16117d.f15895F.getString(2131236127));
                                this.f16117d.m22649l();
                                return;
                            }
                            String j = c0694x5f57d37f.m22873j().m23600j();
                            CharSequence charSequence = null;
                            if (!j.equals("[]")) {
                                charSequence = new JSONObject(j).getString("notif_graphql_id");
                            }
                            if (StringUtil.m3589a(charSequence)) {
                                this.f16117d.m22635a(c0694x5f57d37f, str, runnable, z, false);
                                return;
                            }
                            ((SurveyNotificationHelper) this.f16117d.f15900g.get()).a(charSequence, c0694x5f57d37f, str, runnable, z);
                            return;
                        }
                        StructuredSurveyController.m22632c(this.f16117d, this.f16117d.f15895F.getString(2131236128));
                        this.f16117d.m22649l();
                    } catch (Throwable e) {
                        this.f16117d.f15904k.m2343a(StructuredSurveyController.f15888d, "NaRF:IntegrationPoint Model Init Failed", e);
                        this.f16117d.m22649l();
                    }
                }

                public void onFailure(Throwable th) {
                    StructuredSurveyController.m22632c(this.f16117d, this.f16117d.f15895F.getString(2131236129));
                }
            }, this.f15902i);
        }
    }

    public final boolean m22641a() {
        return StringUtil.m3589a(this.f15915v);
    }

    public final void m22640a(String str, String str2) {
        this.f15909p.put(str, str2);
        List list = this.f15908o;
        SurveyContextDataInputSurveyContextData surveyContextDataInputSurveyContextData = new SurveyContextDataInputSurveyContextData();
        surveyContextDataInputSurveyContextData.m11397a("context_key", str);
        GraphQlCallInput graphQlCallInput = surveyContextDataInputSurveyContextData;
        graphQlCallInput.m11397a("context_value", str2);
        list.add(graphQlCallInput);
    }

    public final void m22635a(C0694x5f57d37f c0694x5f57d37f, String str, @Nullable Runnable runnable, boolean z, boolean z2) {
        C0707x489dfaf0 j = c0694x5f57d37f.m22873j();
        SurveyModel l = j.m23602l();
        Preconditions.checkNotNull(l, "NULL IntegrationPoint SurveyModel");
        this.f15915v = l.j();
        this.f15916w = j.m23601k();
        this.f15912s = new StructuredSurveyState();
        this.f15910q = new StructuredSurveyFlowController(l.k(), this.f15912s);
        this.f15911r = new StructuredSurveyBuilder(this.f15895F, this.f15914u);
        this.f15918y = c0694x5f57d37f.m22873j().m23599a().n();
        if (!this.f15918y) {
            if (StringUtil.m3589a(c0694x5f57d37f.m22873j().m23599a().k())) {
                this.f15911r.a(this.f15895F.getString(2131236125));
            } else {
                this.f15911r.a(c0694x5f57d37f.m22873j().m23599a().k());
            }
            this.f15911r.b(this.f15895F.getString(2131236119));
        }
        if (StringUtil.m3589a(c0694x5f57d37f.m22873j().m23599a().m())) {
            this.f15911r.c(this.f15895F.getString(2131236120));
        } else {
            this.f15911r.c(c0694x5f57d37f.m22873j().m23599a().m());
        }
        this.f15911r.d = this.f15910q.b();
        this.f15919z = c0694x5f57d37f.m22873j().m23599a().j();
        this.f15890A = c0694x5f57d37f.m22873j().m23599a().l();
        this.f15891B = c0694x5f57d37f.m22873j().m23599a().o();
        this.f15892C = c0694x5f57d37f.m22873j().m23599a().p();
        if (z2) {
            this.f15911r.a(((SurveyNotificationHelper) this.f15900g.get()).g);
        }
        this.f15917x = str;
        if (runnable == null) {
            return;
        }
        if (z) {
            ExecutorDetour.a(this.f15903j, runnable, 1416957127);
        } else {
            runnable.run();
        }
    }

    public final SurveyListAdapter m22642b() {
        try {
            return m22629a(this.f15911r.a());
        } catch (Throwable e) {
            this.f15904k.m2343a(f15888d, "NaRF:Intro Toast Build Failed", e);
            m22649l();
            return null;
        }
    }

    public final SurveyListAdapter m22644c() {
        try {
            return m22629a(this.f15911r.b());
        } catch (Throwable e) {
            this.f15904k.m2343a(f15888d, "NaRF:Outro Toast Build Failed", e);
            m22649l();
            return null;
        }
    }

    public final SurveyListAdapter m22645d() {
        try {
            this.f15893D = this.f15911r.a(this.f15910q.a());
            return m22629a(this.f15893D);
        } catch (Exception e) {
            return null;
        }
    }

    private SurveyListAdapter m22629a(List<SurveyItem> list) {
        Preconditions.checkNotNull(list);
        return new SurveyListAdapter(this.f15894E, (ArrayList) list);
    }

    public final void m22633a(Context context) {
        this.f15894E = context;
    }

    public final void m22646f() {
        try {
            if (this.f15893D != null) {
                this.f15910q.a(this.f15893D);
            }
        } catch (Throwable e) {
            this.f15904k.m2343a(f15888d, "NaRF:Page Answer Record Failed", e);
        }
    }

    public final int m22647h() {
        return this.f15910q.a;
    }

    public final void m22634a(ImpressionType impressionType, @Nullable Map<String, String> map) {
        Map hashMap;
        if (impressionType == ImpressionType.INVITATION_IMPRESSION || (impressionType == ImpressionType.IMPRESSION && this.f15918y)) {
            this.f15906m.edit().mo1275a(f15889e, this.f15907n.mo211a()).commit();
        }
        if (map == null) {
            hashMap = new HashMap();
        }
        hashMap.putAll(this.f15909p);
        PostSurveyImpressionsParams postSurveyImpressionsParams = new PostSurveyImpressionsParams(this.f15915v, this.f15916w, impressionType.getImpressionEvent(), ImmutableMap.copyOf(hashMap));
        Bundle bundle = new Bundle();
        bundle.putParcelable("postSurveyImpressionsParams", postSurveyImpressionsParams);
        Futures.m2458a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f15905l.get(), "post_survey_impressions", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(StructuredSurveyController.class), 1805396381).mo3452a(), new 2(this, impressionType), this.f15902i);
    }

    public final void m22648k() {
        String str = this.f15915v;
        String str2 = this.f15916w;
        ImmutableMap a = this.f15912s.a();
        StructuredSurveyState structuredSurveyState = this.f15912s;
        Collection a2 = Lists.m1296a();
        for (ImmutableList immutableList : structuredSurveyState.b) {
            ParcelableStringArrayList parcelableStringArrayList = new ParcelableStringArrayList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                parcelableStringArrayList.add((String) immutableList.get(i));
            }
            a2.add(parcelableStringArrayList);
        }
        PostSurveyAnswersParams postSurveyAnswersParams = new PostSurveyAnswersParams(str, str2, true, a, ImmutableList.copyOf(a2), this.f15912s.c(), ImmutableMap.copyOf(this.f15909p));
        this.f15909p.clear();
        Bundle bundle = new Bundle();
        bundle.putParcelable("postSurveyAnswersParams", postSurveyAnswersParams);
        Futures.m2458a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f15905l.get(), "post_survey_answers", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(StructuredSurveyController.class), 1940907153).mo3452a(), new 3(this), this.f15902i);
    }

    public final void m22637a(String str, long j) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("survey_render");
        honeyClientEvent.m5084a("client_time", j).m5090b("render_state", str).m5090b("integration_point_id", this.f15917x).m5090b("survey_id", this.f15915v);
        ((AnalyticsLogger) this.f15901h.get()).mo526a(honeyClientEvent);
    }

    public final void m22649l() {
        this.f15915v = null;
        this.f15916w = null;
        this.f15912s = null;
        this.f15910q = null;
        this.f15911r = null;
        this.f15918y = false;
        this.f15919z = false;
        this.f15917x = null;
        this.f15893D = null;
        this.f15894E = null;
        this.f15909p.clear();
        this.f15908o.clear();
        this.f15913t.f16037a.clear();
    }

    public final boolean m22643b(String str) {
        return this.f15917x != null && this.f15917x.equals(str);
    }

    public final boolean m22650m() {
        if (this.f15906m.mo284a() && this.f15906m.mo286a(f15885a, false)) {
            return false;
        }
        long a = this.f15906m.mo277a(f15889e, 0);
        if (a == 0 || this.f15907n.mo211a() - a > 86400000) {
            return false;
        }
        return true;
    }

    public final List<SurveyItem> m22651n() {
        try {
            this.f15893D = this.f15911r.c(this.f15910q.a());
            return this.f15893D;
        } catch (Exception e) {
            return null;
        }
    }

    public final List<SurveyItem> m22652o() {
        try {
            this.f15893D = this.f15911r.b(this.f15910q.a());
            return this.f15893D;
        } catch (Exception e) {
            return null;
        }
    }

    public static void m22632c(StructuredSurveyController structuredSurveyController, String str) {
        if (structuredSurveyController.f15894E != null && (structuredSurveyController.f15894E instanceof Activity) && (structuredSurveyController.f15894E instanceof DebugContext)) {
            ((Activity) structuredSurveyController.f15894E).runOnUiThread(new 5(structuredSurveyController, str));
        }
    }
}

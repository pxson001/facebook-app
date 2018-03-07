package com.facebook.zero.service;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.HandlerListeningExecutorServiceImpl;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory$OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQL.FetchZeroTokenQueryString;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.FetchZeroTokenQueryModel;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.FetchZeroTokenQueryModel.ZeroTokenModel;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.FetchZeroTokenQueryModel.ZeroTokenModel.FeaturesModel;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.GraphQLRewriteRuleModel;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.RewriteRuleModel;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.request.FetchZeroIndicatorRequestParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityResult;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestParams;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestResult;
import com.facebook.zero.sdk.request.FetchZeroTokenRequestParams;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.request.ZeroOptinParams;
import com.facebook.zero.sdk.request.ZeroOptinResult;
import com.facebook.zero.sdk.request.ZeroOptoutParams;
import com.facebook.zero.sdk.request.ZeroOptoutResult;
import com.facebook.zero.sdk.request.ZeroRequestBaseParams;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.token.ZeroToken;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fonts/HelveticaNeue-Roman.ttf */
public class FbZeroRequestHandler implements ZeroRequestHandler {
    public Lazy<BlueServiceOperationFactory> f23524a;
    public final Lazy<ExecutorService> f23525b;
    private DefaultAndroidThreadUtil f23526c;
    public final GraphQLQueryExecutor f23527d;
    private final Provider<Boolean> f23528e;
    private final Provider<Boolean> f23529f;

    /* compiled from: fonts/HelveticaNeue-Roman.ttf */
    class C09663 implements Function<OperationResult, RESULT> {
        final /* synthetic */ FbZeroRequestHandler f23571a;

        C09663(FbZeroRequestHandler fbZeroRequestHandler) {
            this.f23571a = fbZeroRequestHandler;
        }

        public Object apply(Object obj) {
            return ((OperationResult) obj).m30130h();
        }
    }

    public static FbZeroRequestHandler m31839b(InjectorLike injectorLike) {
        return new FbZeroRequestHandler(IdBasedLazy.m1808a(injectorLike, 1144), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3834), DefaultAndroidThreadUtil.m1646b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4391), IdBasedProvider.m1811a(injectorLike, 4384));
    }

    @Inject
    public FbZeroRequestHandler(Lazy<BlueServiceOperationFactory> lazy, Lazy<ExecutorService> lazy2, AndroidThreadUtil androidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f23524a = lazy;
        this.f23525b = lazy2;
        this.f23526c = androidThreadUtil;
        this.f23527d = graphQLQueryExecutor;
        this.f23528e = provider;
        this.f23529f = provider2;
    }

    public final ListenableFuture<ZeroToken> mo3444a(FetchZeroTokenRequestParams fetchZeroTokenRequestParams, FutureCallback<ZeroToken> futureCallback) {
        if (((Boolean) this.f23528e.get()).booleanValue() || fetchZeroTokenRequestParams.f23533d == TokenRequestReason.GRAPHQL_VERIFICATION) {
            String str;
            boolean z = true;
            FetchZeroTokenQueryString fetchZeroTokenQueryString = new FetchZeroTokenQueryString();
            String str2 = "dialtone_enabled";
            if (fetchZeroTokenRequestParams.f23530a.getModeNumber() != (byte) 1) {
                z = false;
            }
            GraphQlQueryString a = fetchZeroTokenQueryString.m11312a(str2, Boolean.valueOf(z));
            str2 = "hash";
            if (fetchZeroTokenRequestParams.f23533d.equals(TokenRequestReason.GRAPHQL_VERIFICATION)) {
                str = "";
            } else {
                str = fetchZeroTokenRequestParams.f23532c;
            }
            ListenableFuture a2 = this.f23527d.m10446a(GraphQLRequest.m11587a((TypedGraphQlQueryString) new FetchZeroTokenQueryString()).m11595a(a.m11315a(str2, str).m11312a("needs_backup_rules", Boolean.valueOf(fetchZeroTokenRequestParams.f23531b)).f6529a));
            Executor executor = (Executor) this.f23525b.get();
            ListenableFuture<ZeroToken> a3 = Futures.m2450a(a2, new 1(this), executor);
            Futures.m2458a((ListenableFuture) a3, (FutureCallback) futureCallback, executor);
            return a3;
        } else if (((Boolean) this.f23529f.get()).booleanValue()) {
            String str3 = "fetch_zero_token_not_bootstrap";
            if (fetchZeroTokenRequestParams.f23533d == TokenRequestReason.TOKEN_FETCH_FAILED_RETRY) {
                str3 = "fetch_zero_token";
            }
            return m31838a(fetchZeroTokenRequestParams, str3, RequestPriority.NON_INTERACTIVE, futureCallback, false);
        } else {
            return m31838a(fetchZeroTokenRequestParams, "fetch_zero_token", RequestPriority.NON_INTERACTIVE, futureCallback, false);
        }
    }

    public final ListenableFuture<ZeroIndicatorData> mo3440a(FetchZeroIndicatorRequestParams fetchZeroIndicatorRequestParams, FutureCallback<ZeroIndicatorData> futureCallback) {
        return m31838a(fetchZeroIndicatorRequestParams, "fetch_zero_indicator", RequestPriority.INTERACTIVE, futureCallback, false);
    }

    public final ListenableFuture<FetchZeroOptinContentRequestResult> mo3443a(FetchZeroOptinContentRequestParams fetchZeroOptinContentRequestParams, FutureCallback<FetchZeroOptinContentRequestResult> futureCallback) {
        return m31838a(fetchZeroOptinContentRequestParams, "fetch_zero_optin_content_request", RequestPriority.INTERACTIVE, futureCallback, true);
    }

    public final ListenableFuture<ZeroOptinResult> mo3445a(ZeroOptinParams zeroOptinParams, FutureCallback<ZeroOptinResult> futureCallback) {
        return m31838a(zeroOptinParams, "zero_optin", RequestPriority.INTERACTIVE, futureCallback, true);
    }

    public final ListenableFuture<ZeroOptoutResult> mo3446a(ZeroOptoutParams zeroOptoutParams, FutureCallback<ZeroOptoutResult> futureCallback) {
        return m31838a(zeroOptoutParams, "zero_optout", RequestPriority.INTERACTIVE, futureCallback, true);
    }

    public final ListenableFuture<FetchZeroInterstitialEligibilityResult> mo3442a(FetchZeroInterstitialEligibilityParams fetchZeroInterstitialEligibilityParams, FutureCallback<FetchZeroInterstitialEligibilityResult> futureCallback) {
        return m31838a(fetchZeroInterstitialEligibilityParams, "fetch_zero_interstitial_eligibility", RequestPriority.NON_INTERACTIVE, futureCallback, false);
    }

    public final ListenableFuture<FetchZeroInterstitialContentResult> mo3441a(FetchZeroInterstitialContentParams fetchZeroInterstitialContentParams, FutureCallback<FetchZeroInterstitialContentResult> futureCallback) {
        return m31838a(fetchZeroInterstitialContentParams, "fetch_zero_interstitial_content", RequestPriority.INTERACTIVE, futureCallback, true);
    }

    private <PARAMS extends ZeroRequestBaseParams, RESULT> ListenableFuture<RESULT> m31838a(PARAMS params, String str, RequestPriority requestPriority, final FutureCallback<RESULT> futureCallback, boolean z) {
        Executor handlerListeningExecutorServiceImpl;
        FutureCallback c09642 = new FutureCallback<OperationResult>(this) {
            final /* synthetic */ FbZeroRequestHandler f23537b;

            public void onSuccess(@Nullable Object obj) {
                futureCallback.onSuccess(((OperationResult) obj).m30130h());
            }

            public void onFailure(Throwable th) {
                futureCallback.onFailure(th);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putParcelable(params.mo3447a(), params);
        BlueServiceOperationFactory$OperationFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f23524a.get(), str, bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.m9060a(FbZeroRequestHandler.class), 1225248238).mo3452a();
        a.mo2693a(requestPriority);
        ListenableFuture listenableFuture = a;
        if (z) {
            this.f23526c.m1651a(listenableFuture, c09642);
            handlerListeningExecutorServiceImpl = new HandlerListeningExecutorServiceImpl(new Handler());
        } else {
            handlerListeningExecutorServiceImpl = (Executor) this.f23525b.get();
            Futures.m2458a(listenableFuture, c09642, handlerListeningExecutorServiceImpl);
        }
        return Futures.m2450a(listenableFuture, new C09663(this), handlerListeningExecutorServiceImpl);
    }

    public static ZeroToken m31837a(GraphQLResult<FetchZeroTokenQueryModel> graphQLResult) {
        FetchZeroTokenQueryModel fetchZeroTokenQueryModel = (FetchZeroTokenQueryModel) graphQLResult.m10400d();
        ZeroTokenModel j = fetchZeroTokenQueryModel.j();
        if (j == null) {
            return ZeroToken.f23324a;
        }
        String a = j.a();
        String toLowerCase = String.valueOf(j.m()).toLowerCase(Locale.US);
        String k = fetchZeroTokenQueryModel.a().k();
        String a2 = fetchZeroTokenQueryModel.a().a();
        String k2 = j.k();
        String j2 = fetchZeroTokenQueryModel.a().j();
        ImmutableList l = j.l();
        int o = j.o();
        String n = j.n();
        Collection arrayList = new ArrayList();
        ImmutableList j3 = j.j();
        int size = j3.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(ZeroFeatureKey.fromString((String) j3.get(i)));
        }
        ImmutableSet copyOf = ImmutableSet.copyOf(arrayList);
        String toLowerCase2 = String.valueOf(j.p()).toLowerCase(Locale.US);
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        if (l != null && l.size() == 2) {
            int i2;
            RewriteRuleModel rewriteRuleModel;
            ImmutableList k3 = ((FeaturesModel) l.get(0)).k();
            int size2 = k3.size();
            for (i2 = 0; i2 < size2; i2++) {
                rewriteRuleModel = (RewriteRuleModel) k3.get(i2);
                arrayList2.add(new ZeroUrlRewriteRule(rewriteRuleModel.a(), rewriteRuleModel.j()));
            }
            k3 = ((FeaturesModel) l.get(0)).a();
            size2 = k3.size();
            for (i2 = 0; i2 < size2; i2++) {
                GraphQLRewriteRuleModel graphQLRewriteRuleModel = (GraphQLRewriteRuleModel) k3.get(i2);
                arrayList2.add(new ZeroUrlRewriteRule(graphQLRewriteRuleModel.a(), graphQLRewriteRuleModel.j()));
            }
            k3 = ((FeaturesModel) l.get(0)).j();
            size2 = k3.size();
            for (i2 = 0; i2 < size2; i2++) {
                rewriteRuleModel = (RewriteRuleModel) k3.get(i2);
                arrayList2.add(new ZeroUrlRewriteRule(rewriteRuleModel.a(), rewriteRuleModel.j()));
            }
            l = ((FeaturesModel) l.get(1)).k();
            int size3 = l.size();
            for (i2 = 0; i2 < size3; i2++) {
                rewriteRuleModel = (RewriteRuleModel) l.get(i2);
                arrayList3.add(new ZeroUrlRewriteRule(rewriteRuleModel.a(), rewriteRuleModel.j()));
            }
        }
        return new ZeroToken(a, toLowerCase, k, a2, j2, o, copyOf, ImmutableList.copyOf(arrayList2), toLowerCase2, ImmutableList.copyOf(arrayList3), n, 0, k2);
    }
}

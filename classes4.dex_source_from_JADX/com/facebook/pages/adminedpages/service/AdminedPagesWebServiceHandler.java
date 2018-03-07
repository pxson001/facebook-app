package com.facebook.pages.adminedpages.service;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Params;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Result;
import com.facebook.pages.adminedpages.protocol.FetchAllPagesMethod;
import com.facebook.pages.adminedpages.protocol.FetchAllPagesResult;
import com.facebook.pages.adminedpages.protocol.PagesAccessTokenPrefetchMethod;
import com.facebook.pages.adminedpages.protocol.PagesInfoFqlHelper;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: error deleting old assets files. */
public class AdminedPagesWebServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f12835a;
    public final FetchAllPagesMethod f12836b;
    public final AdminedPagesPrefetchMethod f12837c;
    public final PagesAccessTokenPrefetchMethod f12838d;
    public final ApiMethodRunnerImpl f12839e;

    public static AdminedPagesWebServiceHandler m13669b(InjectorLike injectorLike) {
        return new AdminedPagesWebServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new FetchAllPagesMethod(PagesInfoFqlHelper.m13677b(injectorLike), PagesManagerStartupSequencesHelper.m13680a(injectorLike)), new AdminedPagesPrefetchMethod(GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), new PagesAccessTokenPrefetchMethod(PagesInfoFqlHelper.m13677b(injectorLike)), ApiMethodRunnerImpl.a(injectorLike));
    }

    @Inject
    public AdminedPagesWebServiceHandler(Provider<SingleMethodRunner> provider, FetchAllPagesMethod fetchAllPagesMethod, AdminedPagesPrefetchMethod adminedPagesPrefetchMethod, PagesAccessTokenPrefetchMethod pagesAccessTokenPrefetchMethod, ApiMethodRunner apiMethodRunner) {
        this.f12835a = provider;
        this.f12836b = fetchAllPagesMethod;
        this.f12837c = adminedPagesPrefetchMethod;
        this.f12838d = pagesAccessTokenPrefetchMethod;
        this.f12839e = apiMethodRunner;
    }

    public final OperationResult m13670a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_all_pages".equals(str)) {
            return OperationResult.a((FetchAllPagesResult) ((AbstractSingleMethodRunner) this.f12835a.get()).a(this.f12836b, null));
        }
        if ("admined_pages_prefetch".equals(str)) {
            ApiMethodRunner$Batch a = this.f12839e.a();
            Builder a2 = BatchOperation.m12541a(this.f12837c, (Params) operationParams.c.getParcelable("adminedPagesPrefetchParams"));
            a2.f11927c = "prefetchAdminedPages";
            a.mo888a(a2.m12549a());
            a2 = BatchOperation.m12541a(this.f12838d, (PagesAccessTokenPrefetchMethod.Params) operationParams.c.getParcelable("pagesAccessTokenPrefetchParams"));
            a2.f11927c = "prefetchAccessToken";
            a.mo888a(a2.m12549a());
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            apiMethodRunnerParams.f = RequestPriority.CAN_WAIT;
            a.mo884a("fetchAdminedPagesInfo", CallerContext.a(getClass()), apiMethodRunnerParams);
            ArrayList a3 = Lists.a();
            a3.add((Result) a.mo887a("prefetchAdminedPages"));
            a3.add((PagesAccessTokenPrefetchMethod.Result) a.mo887a("prefetchAccessToken"));
            return OperationResult.a(a3);
        }
        throw new Exception("Unknown type");
    }
}

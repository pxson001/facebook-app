package com.facebook.megaphone.fetcher;

import android.content.res.Resources;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.megaphone.api.FetchMegaphoneLayoutMethod;
import com.facebook.megaphone.api.FetchMegaphoneLayoutResult;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.api.FetchMegaphoneParams;
import com.facebook.megaphone.api.FetchMegaphoneResult;
import com.facebook.megaphone.constants.MegaphoneConstants;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: peak_memory_heap_allocation */
public class MegaphoneFetcher {
    private final int f10305a;
    private final int f10306b;
    public final DefaultProcessIdleExecutor f10307c;
    private final FetchMegaphoneMethod f10308d;
    private final FetchMegaphoneLayoutMethod f10309e;
    private final ApiMethodRunnerImpl f10310f;

    /* compiled from: peak_memory_heap_allocation */
    public class C07241 implements Callable<MegaphoneWithLayout> {
        final /* synthetic */ GraphQLMegaphoneLocation f17909a;
        final /* synthetic */ CallerContext f17910b;
        final /* synthetic */ MegaphoneFetcher f17911c;

        public C07241(MegaphoneFetcher megaphoneFetcher, GraphQLMegaphoneLocation graphQLMegaphoneLocation, CallerContext callerContext) {
            this.f17911c = megaphoneFetcher;
            this.f17909a = graphQLMegaphoneLocation;
            this.f17910b = callerContext;
        }

        public Object call() {
            return MegaphoneFetcher.m15375b(this.f17911c, this.f17909a, this.f17910b);
        }
    }

    @Inject
    public MegaphoneFetcher(Resources resources, DefaultProcessIdleExecutor defaultProcessIdleExecutor, FetchMegaphoneMethod fetchMegaphoneMethod, FetchMegaphoneLayoutMethod fetchMegaphoneLayoutMethod, ApiMethodRunnerImpl apiMethodRunnerImpl) {
        int i;
        switch (resources.getDisplayMetrics().densityDpi) {
            case 120:
                i = MegaphoneConstants.f10355d;
                break;
            case 160:
                i = MegaphoneConstants.f10354c;
                break;
            case 240:
                i = MegaphoneConstants.f10353b;
                break;
            default:
                i = MegaphoneConstants.f10352a;
                break;
        }
        this.f10305a = i;
        this.f10306b = resources.getDimensionPixelSize(2131427501);
        this.f10307c = defaultProcessIdleExecutor;
        this.f10308d = fetchMegaphoneMethod;
        this.f10309e = fetchMegaphoneLayoutMethod;
        this.f10310f = apiMethodRunnerImpl;
    }

    public static MegaphoneWithLayout m15375b(MegaphoneFetcher megaphoneFetcher, GraphQLMegaphoneLocation graphQLMegaphoneLocation, CallerContext callerContext) {
        FetchMegaphoneParams fetchMegaphoneParams = new FetchMegaphoneParams(graphQLMegaphoneLocation, megaphoneFetcher.f10305a, megaphoneFetcher.f10306b);
        Batch a = megaphoneFetcher.f10310f.m15383a();
        Builder a2 = BatchOperation.a(megaphoneFetcher.f10308d, fetchMegaphoneParams);
        a2.c = "fetch_megaphone";
        a.a(a2.a());
        Builder a3 = BatchOperation.a(megaphoneFetcher.f10309e, fetchMegaphoneParams);
        a3.c = "fetch_megaphone_layout";
        a.a(a3.a());
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.f7561f = RequestPriority.NON_INTERACTIVE;
        String str = "fetchLayoutAndMegaphoneRequest";
        if (callerContext == null) {
            callerContext = CallerContext.m9060a(megaphoneFetcher.getClass());
        }
        a.a(str, callerContext, apiMethodRunnerParams);
        FetchMegaphoneResult fetchMegaphoneResult = (FetchMegaphoneResult) a.a("fetch_megaphone");
        FetchMegaphoneLayoutResult fetchMegaphoneLayoutResult = (FetchMegaphoneLayoutResult) a.a("fetch_megaphone_layout");
        if (fetchMegaphoneResult.a == null || fetchMegaphoneResult.a.k().equals(fetchMegaphoneLayoutResult.a)) {
            return new MegaphoneWithLayout(fetchMegaphoneLayoutResult.b, fetchMegaphoneResult.a);
        }
        return new MegaphoneWithLayout(null, fetchMegaphoneResult.a);
    }
}

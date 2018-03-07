package com.facebook.zero.upsell.service;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.model.ZeroPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.zero.upsell.methods.ZeroBuyPromoMethod;
import com.facebook.zero.upsell.methods.ZeroGetRecommendedPromoMethod;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: visit_more_tab */
public class UpsellPromoServiceHandler implements BlueServiceHandler {
    private static final CallerContext f300a = CallerContext.a(UpsellPromoServiceHandler.class);
    private final Provider<SingleMethodRunner> f301b;
    private final ZeroBuyPromoMethod f302c;
    private final ZeroGetRecommendedPromoMethod f303d;
    public final Provider<Boolean> f304e;

    public static UpsellPromoServiceHandler m340b(InjectorLike injectorLike) {
        return new UpsellPromoServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new ZeroBuyPromoMethod(), new ZeroGetRecommendedPromoMethod(ResourcesMethodAutoProvider.a(injectorLike)), IdBasedProvider.a(injectorLike, 4385));
    }

    @Inject
    public UpsellPromoServiceHandler(Provider<SingleMethodRunner> provider, ZeroBuyPromoMethod zeroBuyPromoMethod, ZeroGetRecommendedPromoMethod zeroGetRecommendedPromoMethod, Provider<Boolean> provider2) {
        this.f301b = provider;
        this.f302c = zeroBuyPromoMethod;
        this.f303d = zeroGetRecommendedPromoMethod;
        this.f304e = provider2;
    }

    public final OperationResult m342a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("zero_buy_promo".equals(str)) {
            return m339b(operationParams);
        }
        if ("zero_get_recommended_promo".equals(str)) {
            return m341c(operationParams);
        }
        throw new RuntimeException("Unknown type");
    }

    private OperationResult m339b(OperationParams operationParams) {
        return OperationResult.a((ZeroPromoResult) m338a(this.f302c, (ZeroPromoParams) operationParams.c.getParcelable("zeroBuyPromoParams")));
    }

    private OperationResult m341c(OperationParams operationParams) {
        return OperationResult.a((ZeroRecommendedPromoResult) m338a(this.f303d, (ZeroRecommendedPromoParams) operationParams.c.getParcelable("zeroBuyPromoParams")));
    }

    private <PARAMS, RESULT> RESULT m338a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params) {
        AbstractSingleMethodRunner abstractSingleMethodRunner = (AbstractSingleMethodRunner) this.f301b.get();
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        if (((Boolean) this.f304e.get()).booleanValue()) {
            apiMethodRunnerParams.a(HttpConfig.DEFAULT);
        } else {
            apiMethodRunnerParams.a(HttpConfig.BOOTSTRAP);
        }
        return abstractSingleMethodRunner.a(apiMethod, params, apiMethodRunnerParams, f300a);
    }
}

package com.facebook.zero.service;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLModels.FetchZeroOptinQueryModel;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

/* compiled from: width =  */
class ZeroInterstitialEligibilityManager$1 implements FutureCallback<GraphQLResult<FetchZeroOptinQueryModel>> {
    final /* synthetic */ ZeroInterstitialEligibilityManager f230a;

    ZeroInterstitialEligibilityManager$1(ZeroInterstitialEligibilityManager zeroInterstitialEligibilityManager) {
        this.f230a = zeroInterstitialEligibilityManager;
    }

    public void onSuccess(Object obj) {
        this.f230a.a((GraphQLResult) obj);
    }

    public void onFailure(Throwable th) {
        if (!(th instanceof CancellationException)) {
            ZeroInterstitialEligibilityManager.a(this.f230a, th);
        }
    }
}

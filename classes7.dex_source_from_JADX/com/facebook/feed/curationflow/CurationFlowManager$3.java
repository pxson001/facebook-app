package com.facebook.feed.curationflow;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: application/x-subrip */
class CurationFlowManager$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ String f19141a;
    final /* synthetic */ GraphQLNegativeFeedbackActionType f19142b;
    final /* synthetic */ FutureCallback f19143c;
    final /* synthetic */ FutureCallback f19144d;
    final /* synthetic */ CurationFlowManager f19145e;

    CurationFlowManager$3(CurationFlowManager curationFlowManager, String str, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, FutureCallback futureCallback, FutureCallback futureCallback2) {
        this.f19145e = curationFlowManager;
        this.f19141a = str;
        this.f19142b = graphQLNegativeFeedbackActionType;
        this.f19143c = futureCallback;
        this.f19144d = futureCallback2;
    }

    public void onSuccess(@Nullable Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        this.f19145e.a(this.f19141a, this.f19142b, this.f19143c);
        this.f19145e.a(this.f19141a, operationResult.c);
    }

    public void onFailure(Throwable th) {
        CurationFlowManager.d(this.f19145e, this.f19141a);
        if (this.f19144d != null) {
            this.f19144d.onFailure(th);
        }
    }
}

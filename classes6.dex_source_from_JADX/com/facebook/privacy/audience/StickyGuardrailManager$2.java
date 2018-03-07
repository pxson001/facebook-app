package com.facebook.privacy.audience;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLViewer;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: fetchImageParams */
class StickyGuardrailManager$2 implements FutureCallback<OperationResult> {
    final /* synthetic */ StickyGuardrailManager f15004a;

    StickyGuardrailManager$2(StickyGuardrailManager stickyGuardrailManager) {
        this.f15004a = stickyGuardrailManager;
    }

    public void onSuccess(Object obj) {
        this.f15004a.a((GraphQLViewer) ((OperationResult) obj).k());
    }

    public void onFailure(Throwable th) {
    }
}

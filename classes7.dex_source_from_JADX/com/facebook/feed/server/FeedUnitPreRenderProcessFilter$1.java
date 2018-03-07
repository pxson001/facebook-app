package com.facebook.feed.server;

import com.facebook.fbservice.service.BlueServiceChainedProgressCallback.ChainedProgressCallback;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: UI_360 */
class FeedUnitPreRenderProcessFilter$1 extends ChainedProgressCallback {
    final /* synthetic */ String f21605a;
    final /* synthetic */ OperationParams f21606b;
    final /* synthetic */ FeedUnitPreRenderProcessFilter f21607c;

    FeedUnitPreRenderProcessFilter$1(FeedUnitPreRenderProcessFilter feedUnitPreRenderProcessFilter, String str, OperationParams operationParams) {
        this.f21607c = feedUnitPreRenderProcessFilter;
        this.f21605a = str;
        this.f21606b = operationParams;
    }

    public final OperationResult m24214b(OperationResult operationResult) {
        FeedUnitPreRenderProcessFilter.a(this.f21607c, this.f21605a, this.f21606b, operationResult);
        return operationResult;
    }
}

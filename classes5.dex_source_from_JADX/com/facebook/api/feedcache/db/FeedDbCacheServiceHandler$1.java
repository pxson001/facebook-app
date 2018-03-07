package com.facebook.api.feedcache.db;

import com.facebook.fbservice.service.BlueServiceChainedProgressCallback.ChainedProgressCallback;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: arg_screenshot_bitmap_uri */
class FeedDbCacheServiceHandler$1 extends ChainedProgressCallback {
    final /* synthetic */ FeedDbCacheServiceHandler f8799a;

    FeedDbCacheServiceHandler$1(FeedDbCacheServiceHandler feedDbCacheServiceHandler) {
        this.f8799a = feedDbCacheServiceHandler;
    }

    public final OperationResult mo1093b(OperationResult operationResult) {
        FeedDbCacheServiceHandler feedDbCacheServiceHandler = this.f8799a;
        return FeedDbCacheServiceHandler.a(operationResult);
    }
}

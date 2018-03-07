package com.facebook.feed.data;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: processor_idle */
public class FeedDataLoaderHandler implements BlueServiceHandler$Filter {
    public final PreferredFeedTypeManager f4155a;
    public final Provider<FeedDataLoaderFactory> f4156b;
    public final DefaultAndroidThreadUtil f4157c;

    @Inject
    public FeedDataLoaderHandler(PreferredFeedTypeManager preferredFeedTypeManager, Provider<FeedDataLoaderFactory> provider, AndroidThreadUtil androidThreadUtil) {
        this.f4155a = preferredFeedTypeManager;
        this.f4156b = provider;
        this.f4157c = androidThreadUtil;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (!"feed_clear_cache".equals(operationParams.b)) {
            return blueServiceHandler.a(operationParams);
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        if (operationParams.c.getBoolean("clearCacheResetFeedLoader")) {
            this.f4157c.a(new 1(this));
        }
        return a;
    }
}

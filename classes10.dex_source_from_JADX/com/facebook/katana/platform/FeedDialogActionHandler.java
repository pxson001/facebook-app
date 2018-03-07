package com.facebook.katana.platform;

import android.app.Activity;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.activity.AbstractPlatformActivityActionHandler;
import com.facebook.platform.common.activity.PlatformActivityRequest;
import com.facebook.platform.feed.PlatformActivityFeedDialogRequest;
import javax.inject.Inject;

/* compiled from: typeahead_search_type */
public class FeedDialogActionHandler extends AbstractPlatformActivityActionHandler<FeedDialogActionExecutor, PlatformActivityFeedDialogRequest> {
    private final FeedDialogActionExecutorProvider f1080a;

    protected final AbstractPlatformActionExecutor m1113b(Activity activity, PlatformActivityRequest platformActivityRequest) {
        return this.f1080a.m1112a(activity, (PlatformActivityFeedDialogRequest) platformActivityRequest);
    }

    @Inject
    public FeedDialogActionHandler(FeedDialogActionExecutorProvider feedDialogActionExecutorProvider) {
        super(PlatformActivityFeedDialogRequest.class, "com.facebook.platform.action.request.FEED_DIALOG");
        this.f1080a = feedDialogActionExecutorProvider;
    }

    public final PlatformActivityRequest m1114b() {
        return new PlatformActivityFeedDialogRequest();
    }
}

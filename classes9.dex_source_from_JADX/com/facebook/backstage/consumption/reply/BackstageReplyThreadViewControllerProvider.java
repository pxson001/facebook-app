package com.facebook.backstage.consumption.reply;

import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: ride_info */
public class BackstageReplyThreadViewControllerProvider extends AbstractAssistedProvider<BackstageReplyThreadViewController> {
    public final BackstageReplyThreadViewController m4780a(BackstageReplyThreadView backstageReplyThreadView) {
        return new BackstageReplyThreadViewController(new BackstageReplyThreadRecyclerViewAdapter((ReplyThreadViewMediaItemHolderProvider) getOnDemandAssistedProviderForStaticDi(ReplyThreadViewMediaItemHolderProvider.class), ScreenUtil.m4547a(this), BackstageAnalyticsLogger.m4259a((InjectorLike) this)), ReplyDataProvider.m4801a((InjectorLike) this), backstageReplyThreadView);
    }
}

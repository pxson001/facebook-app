package com.facebook.messaging.business.subscription.instantarticle.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.business.subscription.common.analytics.BusinessSubscriptionAnalyticsLogger;
import com.facebook.messaging.business.subscription.instantarticle.view.BusinessIASubscribeBannerView;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.tiles.UserTileViewLogic;

/* compiled from: touchSelectorResourceId is already defined */
public class BusinessIASubscriptionBannerPresenterProvider extends AbstractAssistedProvider<BusinessIASubscriptionBannerPresenter> {
    public final BusinessIASubscriptionBannerPresenter m1672a(BusinessIASubscribeBannerView businessIASubscribeBannerView) {
        return new BusinessIASubscriptionBannerPresenter(SpringSystem.b(this), UserTileViewLogic.a(this), GQLUserConverter.a(this), BusinessSubscriptionAnalyticsLogger.m1591b(this), new BusinessIASubscriptionLoader((AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphQLQueryExecutor.a(this), TasksManager.b(this)), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), businessIASubscribeBannerView);
    }
}

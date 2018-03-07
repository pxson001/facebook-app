package com.facebook.feedplugins.goodwill;

import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.ui.FeedStoryPermalinkOnClickListenerProvider;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;

/* compiled from: goodfriends_placeholder_cta */
public class ThrowbackPromotedStorySeeOriginalPartDefinitionProvider extends AbstractAssistedProvider<ThrowbackPromotedStorySeeOriginalPartDefinition> {
    public final ThrowbackPromotedStorySeeOriginalPartDefinition m14392a(String str) {
        return new ThrowbackPromotedStorySeeOriginalPartDefinition(BackgroundPartDefinition.a(this), (FeedStoryPermalinkOnClickListenerProvider) getOnDemandAssistedProviderForStaticDi(FeedStoryPermalinkOnClickListenerProvider.class), ClickListenerPartDefinition.a(this), TextPartDefinition.a(this), GoodwillAnalyticsLogger.a(this), str);
    }
}

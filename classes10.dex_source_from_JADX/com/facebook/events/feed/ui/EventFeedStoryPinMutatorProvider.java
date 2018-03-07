package com.facebook.events.feed.ui;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.events.data.EventAdminStatusRecord;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ClickableToastBuilder;

/* compiled from: com.facebook.TokenCachingStrategy.ExpirationDate */
public class EventFeedStoryPinMutatorProvider extends AbstractAssistedProvider<EventFeedStoryPinMutator> {
    public final EventFeedStoryPinMutator m17793a(EventPermalinkFragment eventPermalinkFragment) {
        return new EventFeedStoryPinMutator(eventPermalinkFragment, ViewerContextManagerProvider.b(this), EventStoriesQueryParamHelper.m17800b(this), GraphQLQueryExecutor.a(this), DefaultAndroidThreadUtil.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ClickableToastBuilder.b(this), EventAdminStatusRecord.a(this), EventPermalinkStoriesExtractor.m17796b((InjectorLike) this));
    }
}

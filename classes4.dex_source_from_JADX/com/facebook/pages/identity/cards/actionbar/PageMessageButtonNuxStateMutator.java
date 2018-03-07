package com.facebook.pages.identity.cards.actionbar;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import javax.inject.Inject;

/* compiled from: reliable_core_count */
public class PageMessageButtonNuxStateMutator {
    public static final String f3494a = PageMessageButtonNuxStateMutator.class.getSimpleName();
    public final String f3495b;
    public final GraphQLQueryExecutor f3496c;
    public final AnalyticsLogger f3497d;

    @Inject
    public PageMessageButtonNuxStateMutator(String str, GraphQLQueryExecutor graphQLQueryExecutor, AnalyticsLogger analyticsLogger) {
        this.f3495b = str;
        this.f3496c = graphQLQueryExecutor;
        this.f3497d = analyticsLogger;
    }
}

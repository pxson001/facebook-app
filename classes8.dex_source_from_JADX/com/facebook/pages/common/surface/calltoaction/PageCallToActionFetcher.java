package com.facebook.pages.common.surface.calltoaction;

import android.content.Context;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: creation_cancelled */
public class PageCallToActionFetcher {
    public final GraphQLQueryExecutor f16645a;
    public final String f16646b;
    public final Context f16647c;

    @Inject
    public PageCallToActionFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Context context, @Assisted String str) {
        this.f16645a = graphQLQueryExecutor;
        this.f16647c = context;
        this.f16646b = str;
    }
}

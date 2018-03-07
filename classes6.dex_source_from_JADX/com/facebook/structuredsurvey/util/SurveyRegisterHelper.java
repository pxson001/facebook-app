package com.facebook.structuredsurvey.util;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: dismiss_back */
public class SurveyRegisterHelper {
    private final GraphQLQueryExecutor f17199a;

    private static SurveyRegisterHelper m24943b(InjectorLike injectorLike) {
        return new SurveyRegisterHelper(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public SurveyRegisterHelper(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f17199a = graphQLQueryExecutor;
    }
}

package com.facebook.translation;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: feedback_socialcontext_negative_count */
public class TranslationPreferencesModifier {
    public final GraphQLQueryExecutor f24370a;

    public static TranslationPreferencesModifier m32683b(InjectorLike injectorLike) {
        return new TranslationPreferencesModifier(GraphQLQueryExecutor.m10435a(injectorLike));
    }

    @Inject
    public TranslationPreferencesModifier(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f24370a = graphQLQueryExecutor;
    }
}

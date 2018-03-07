package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.protocol.FetchTranslationsGraphQL.TranslatedStoryMessageString;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: feedback_subscriber */
public class TranslationDataLoader {
    public static final Class<?> f24364a = TranslationDataLoader.class;
    private final GraphQLQueryExecutor f24365b;
    public final DefaultAndroidThreadUtil f24366c;
    public TranslationLoadedListener f24367d;

    public static TranslationDataLoader m32678b(InjectorLike injectorLike) {
        return new TranslationDataLoader(GraphQLQueryExecutor.m10435a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public TranslationDataLoader(GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f24365b = graphQLQueryExecutor;
        this.f24366c = defaultAndroidThreadUtil;
    }

    public final void m32679a(GraphQLStory graphQLStory, TranslatedTextPersistentState translatedTextPersistentState) {
        this.f24366c.m1651a(this.f24365b.m10446a(GraphQLRequest.m11587a((TranslatedStoryMessageString) new TranslatedStoryMessageString().m11315a("story_id", graphQLStory.m22350c()))), new 1(this, translatedTextPersistentState));
    }
}

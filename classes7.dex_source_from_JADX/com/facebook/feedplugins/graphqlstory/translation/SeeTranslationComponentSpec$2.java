package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.translation.TranslationRatingView.RatingListener;

/* compiled from: S_VOBSUB */
public class SeeTranslationComponentSpec$2 implements RatingListener {
    final /* synthetic */ FeedProps f23463a;
    final /* synthetic */ TranslatedTextPersistentState f23464b;
    final /* synthetic */ SeeTranslationComponentSpec f23465c;

    public SeeTranslationComponentSpec$2(SeeTranslationComponentSpec seeTranslationComponentSpec, FeedProps feedProps, TranslatedTextPersistentState translatedTextPersistentState) {
        this.f23465c = seeTranslationComponentSpec;
        this.f23463a = feedProps;
        this.f23464b = translatedTextPersistentState;
    }

    public final void m25748a(int i) {
        this.f23465c.c.a((GraphQLStory) this.f23463a.a, i, this.f23464b.a.a());
    }
}

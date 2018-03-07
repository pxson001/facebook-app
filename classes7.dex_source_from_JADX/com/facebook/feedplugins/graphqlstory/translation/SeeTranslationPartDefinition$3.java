package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.translation.TranslationRatingView.RatingListener;

/* compiled from: S_TEXT/UTF8 */
public class SeeTranslationPartDefinition$3 implements RatingListener {
    final /* synthetic */ GraphQLStory f23466a;
    final /* synthetic */ String f23467b;
    final /* synthetic */ SeeTranslationPartDefinition f23468c;

    public SeeTranslationPartDefinition$3(SeeTranslationPartDefinition seeTranslationPartDefinition, GraphQLStory graphQLStory, String str) {
        this.f23468c = seeTranslationPartDefinition;
        this.f23466a = graphQLStory;
        this.f23467b = str;
    }

    public final void m25749a(int i) {
        this.f23468c.g.a(this.f23466a, i, this.f23467b);
    }
}

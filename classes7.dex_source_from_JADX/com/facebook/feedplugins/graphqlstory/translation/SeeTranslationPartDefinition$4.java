package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: S_TEXT/UTF8 */
public class SeeTranslationPartDefinition$4 implements TranslationDataLoader$TranslationLoadedListener {
    final /* synthetic */ HasPositionInformation f23469a;
    final /* synthetic */ FeedProps f23470b;
    final /* synthetic */ SeeTranslationPartDefinition f23471c;

    public SeeTranslationPartDefinition$4(SeeTranslationPartDefinition seeTranslationPartDefinition, HasPositionInformation hasPositionInformation, FeedProps feedProps) {
        this.f23471c = seeTranslationPartDefinition;
        this.f23469a = hasPositionInformation;
        this.f23470b = feedProps;
    }

    public final void mo1588a() {
        ((HasInvalidate) this.f23469a).a(new FeedProps[]{this.f23470b});
    }
}

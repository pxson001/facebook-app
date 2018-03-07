package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: S_VOBSUB */
public class SeeTranslationComponentSpec$1 implements TranslationDataLoader$TranslationLoadedListener {
    final /* synthetic */ HasPositionInformation f23460a;
    final /* synthetic */ FeedProps f23461b;
    final /* synthetic */ SeeTranslationComponentSpec f23462c;

    public SeeTranslationComponentSpec$1(SeeTranslationComponentSpec seeTranslationComponentSpec, HasPositionInformation hasPositionInformation, FeedProps feedProps) {
        this.f23462c = seeTranslationComponentSpec;
        this.f23460a = hasPositionInformation;
        this.f23461b = feedProps;
    }

    public final void mo1588a() {
        ((HasInvalidate) this.f23460a).a(new FeedProps[]{this.f23461b});
    }
}

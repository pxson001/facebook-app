package com.facebook.feed.rows.sections.text;

import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.spannable.SpannableInTextLayoutPartDefinition;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: hostname */
public class ContentTextLayoutBasePartDefinitionProvider extends AbstractAssistedProvider<ContentTextLayoutBasePartDefinition> {
    public final <E extends HasContext & HasFeedListType & HasPersistentState & HasPositionInformation> ContentTextLayoutBasePartDefinition<E> m28578a(Boolean bool, TextLayoutBuilder textLayoutBuilder, PaddingStyle paddingStyle) {
        return new ContentTextLayoutBasePartDefinition(bool, textLayoutBuilder, paddingStyle, BackgroundPartDefinition.m19135a(this), CopyTextPartDefinition.m28618a((InjectorLike) this), FeedStoryUtil.m18578a((InjectorLike) this), SpannableInTextLayoutPartDefinition.m28627a(this), (ContentTextLayoutPersistentSpannableInputProvider) getOnDemandAssistedProviderForStaticDi(ContentTextLayoutPersistentSpannableInputProvider.class));
    }
}

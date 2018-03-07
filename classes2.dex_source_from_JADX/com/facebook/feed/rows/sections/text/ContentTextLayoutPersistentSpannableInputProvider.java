package com.facebook.feed.rows.sections.text;

import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.EmojiUtil;

/* compiled from: home_team_score */
public class ContentTextLayoutPersistentSpannableInputProvider extends AbstractAssistedProvider<ContentTextLayoutPersistentSpannableInput> {
    public final ContentTextLayoutPersistentSpannableInput m28632a(TextLayoutBuilder textLayoutBuilder, FeedProps<GraphQLStory> feedProps, int i, int i2, boolean z, FeedListType feedListType) {
        return new ContentTextLayoutPersistentSpannableInput(TextLayoutBuilderUtil.m28586a((InjectorLike) this), EmojiUtil.m27878a((InjectorLike) this), FeedHighlighter.m28184a((InjectorLike) this), DefaultFeedUnitRenderer.m26362a(this), textLayoutBuilder, feedProps, i, i2, z, feedListType);
    }
}

package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.ui.emoji.EmojiUtil;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UNKNOWN_SEEN_STATE */
public class ContentTextLayoutBuilder {
    public final Provider<DefaultFeedUnitRenderer> f21565a;
    public final TextLayoutBuilder f21566b;
    public final FeedHighlighter f21567c;
    private final AbstractFbErrorReporter f21568d;
    public final EmojiUtil f21569e;
    private final TextLayoutBuilderUtil f21570f;

    @Inject
    public ContentTextLayoutBuilder(@Assisted Context context, Provider<DefaultFeedUnitRenderer> provider, FeedHighlighter feedHighlighter, FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer, FbErrorReporter fbErrorReporter, EmojiUtil emojiUtil, TextLayoutBuilderUtil textLayoutBuilderUtil) {
        this.f21565a = provider;
        this.f21568d = fbErrorReporter;
        this.f21567c = feedHighlighter;
        this.f21569e = emojiUtil;
        this.f21570f = textLayoutBuilderUtil;
        this.f21566b = TextLayoutBuilderUtil.a(context, fbTextLayoutCacheWarmer);
    }

    public final Layout m24199a(FeedProps<GraphQLStory> feedProps, SpannableStringBuilder spannableStringBuilder) {
        this.f21570f.a(this.f21566b, feedProps);
        try {
            this.f21566b.a(spannableStringBuilder);
            return this.f21566b.d();
        } catch (Throwable e) {
            Throwable th = e;
            this.f21568d.a(SoftError.a("FlatContentTextLayoutPartDefinition_withZombie", StringLocaleUtil.a("JellyBean setText bug with zombie: %s", new Object[]{((GraphQLStory) feedProps.a()).S_()})).a(th).g());
            this.f21566b.a(spannableStringBuilder.toString());
            return this.f21566b.d();
        }
    }
}

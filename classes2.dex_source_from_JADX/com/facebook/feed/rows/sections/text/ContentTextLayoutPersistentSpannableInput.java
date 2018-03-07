package com.facebook.feed.rows.sections.text;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.PersistentSpannableInput;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.ui.emoji.EmojiUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friendlist/%s */
public class ContentTextLayoutPersistentSpannableInput implements PersistentSpannableInput {
    private final TextLayoutBuilder f23079a;
    private final TextLayoutBuilderUtil f23080b;
    public final EmojiUtil f23081c;
    public final FeedHighlighter f23082d;
    public final DefaultFeedUnitRenderer f23083e;
    public final FeedProps<GraphQLStory> f23084f;
    public final int f23085g;
    public final int f23086h;
    public final boolean f23087i;
    private final GraphQLTextWithEntities f23088j;
    private final ContextStateKey<String, PersistentSpannable> f23089k;

    /* compiled from: friendlist/%s */
    public class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        public final /* synthetic */ ContentTextLayoutPersistentSpannableInput f23090a;
        private final String f23091b;
        public final FeedListType f23092c;

        public final Object mo2130a() {
            GraphQLStory graphQLStory = (GraphQLStory) this.f23090a.f23084f.f13444a;
            if (StoryTextHelper.m31226a(graphQLStory).isEmpty()) {
                return new PersistentSpannable(new SpannableStringBuilder(""), false);
            }
            CharSequence b;
            if (this.f23092c.mo2419a() == FeedListName.SEARCH_DENSE_FEED || this.f23092c.mo2419a() == FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI) {
                b = this.f23090a.f23083e.m26376b(this.f23090a.f23084f, this.f23090a.f23086h, this.f23090a.f23087i);
            } else {
                b = this.f23090a.f23083e.m26373a(this.f23090a.f23084f, this.f23090a.f23086h, this.f23090a.f23087i);
            }
            Spannable spannableStringBuilder = new SpannableStringBuilder(StringUtil.m3595b(b));
            this.f23090a.f23081c.m27887a((Editable) spannableStringBuilder, this.f23090a.f23085g);
            this.f23090a.f23082d.m28188a(graphQLStory, spannableStringBuilder);
            return new PersistentSpannable(spannableStringBuilder, false);
        }

        public PersistentSpannableKey(ContentTextLayoutPersistentSpannableInput contentTextLayoutPersistentSpannableInput, GraphQLStory graphQLStory, boolean z, FeedListType feedListType) {
            this.f23090a = contentTextLayoutPersistentSpannableInput;
            this.f23091b = StoryContentPersistentStateId.m31224a(graphQLStory, z);
            this.f23092c = feedListType;
        }

        public final Object mo2131b() {
            return this.f23091b;
        }
    }

    @Inject
    public ContentTextLayoutPersistentSpannableInput(TextLayoutBuilderUtil textLayoutBuilderUtil, EmojiUtil emojiUtil, FeedHighlighter feedHighlighter, DefaultFeedUnitRenderer defaultFeedUnitRenderer, @Assisted TextLayoutBuilder textLayoutBuilder, @Assisted FeedProps<GraphQLStory> feedProps, @Assisted int i, @Assisted int i2, @Assisted boolean z, @Assisted FeedListType feedListType) {
        this.f23079a = textLayoutBuilder;
        this.f23080b = textLayoutBuilderUtil;
        this.f23081c = emojiUtil;
        this.f23082d = feedHighlighter;
        this.f23083e = defaultFeedUnitRenderer;
        this.f23084f = feedProps;
        this.f23085g = i;
        this.f23086h = i2;
        this.f23087i = z;
        this.f23088j = ((GraphQLStory) feedProps.m19804a()).aE();
        this.f23089k = new PersistentSpannableKey(this, (GraphQLStory) feedProps.m19804a(), z, feedListType);
    }

    public final ContextStateKey<String, PersistentSpannable> mo3193a() {
        return this.f23089k;
    }

    public final TextLayoutBuilder mo3196d() {
        return this.f23079a;
    }

    public final int mo3197e() {
        return this.f23080b.m28588a(this.f23084f);
    }

    @Nullable
    public final GraphQLTextWithEntities mo3194b() {
        return this.f23088j;
    }

    public final CacheableEntity mo3195c() {
        return (CacheableEntity) this.f23084f.f13444a;
    }

    public final int mo3192a(Spannable spannable) {
        if (this.f23088j == null || this.f23088j.m22619d() == null || this.f23088j.m22619d().isEmpty()) {
            return 0;
        }
        return spannable.length() - this.f23088j.mo2911a().length();
    }
}

package com.facebook.feed.rows.sections.header;

import android.text.Spannable;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.spannable.FeedSpannables;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitlePersistentStateId;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder;
import com.facebook.feedplugins.graphqlstory.header.HeaderTitleSpannableBuilder.Builder;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.feedplugins.spannable.PersistentSpannableInput;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import javax.annotation.Nullable;

/* compiled from: group/<p$1> */
public class HeaderTitlePersistentSpannableInputForTextLayout implements PersistentSpannableInput {
    private final BaseFeedStoryMenuHelper f21777a;
    private final TextLayoutBuilder f21778b;
    private final HeaderTextLayoutWidthResolver f21779c;
    private final FeedRenderUtils f21780d;
    public final FeedProps<GraphQLStory> f21781e;
    private final GraphQLTextWithEntities f21782f;
    public final FeedHighlighter f21783g;
    public final HeaderTitleSpannableBuilder f21784h;
    private final ContextStateKey<String, PersistentSpannable> f21785i;
    private final int f21786j;
    public final int f21787k;

    /* compiled from: group/<p$1> */
    class PersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
        final /* synthetic */ HeaderTitlePersistentSpannableInputForTextLayout f21791a;
        private final String f21792b;

        public PersistentSpannableKey(HeaderTitlePersistentSpannableInputForTextLayout headerTitlePersistentSpannableInputForTextLayout, GraphQLStory graphQLStory) {
            this.f21791a = headerTitlePersistentSpannableInputForTextLayout;
            this.f21792b = HeaderTitlePersistentStateId.m29525a(graphQLStory);
        }

        public final Object mo2130a() {
            CharSequence a;
            GraphQLStory graphQLStory = (GraphQLStory) this.f21791a.f21781e.f13444a;
            Builder b = this.f21791a.f21784h.m28273a(this.f21791a.f21781e).m29531a().m29532b();
            b.f21803f = this.f21791a.f21787k;
            CharSequence c = b.m29533c();
            if (FeedHighlighter.m28185a(graphQLStory)) {
                a = this.f21791a.f21783g.m28187a(graphQLStory, c);
            } else {
                a = c;
            }
            return new PersistentSpannable(FeedSpannables.m29597a(a), false);
        }

        public final Object mo2131b() {
            return this.f21792b;
        }
    }

    public HeaderTitlePersistentSpannableInputForTextLayout(TextLayoutBuilder textLayoutBuilder, FeedProps<GraphQLStory> feedProps, FeedMenuHelper feedMenuHelper, FeedHighlighter feedHighlighter, HeaderTextLayoutWidthResolver headerTextLayoutWidthResolver, FeedRenderUtils feedRenderUtils, HeaderTitleSpannableBuilder headerTitleSpannableBuilder, int i, int i2) {
        this.f21778b = textLayoutBuilder;
        this.f21777a = feedMenuHelper;
        this.f21779c = headerTextLayoutWidthResolver;
        this.f21780d = feedRenderUtils;
        this.f21781e = feedProps;
        this.f21786j = i;
        this.f21782f = ((GraphQLStory) feedProps.f13444a).aH();
        this.f21783g = feedHighlighter;
        this.f21784h = headerTitleSpannableBuilder;
        this.f21785i = new PersistentSpannableKey(this, (GraphQLStory) feedProps.f13444a);
        this.f21787k = i2;
    }

    public final ContextStateKey<String, PersistentSpannable> mo3193a() {
        return this.f21785i;
    }

    @Nullable
    public final GraphQLTextWithEntities mo3194b() {
        return this.f21782f;
    }

    public final CacheableEntity mo3195c() {
        return (GraphQLStory) this.f21781e.f13444a;
    }

    public final int mo3192a(Spannable spannable) {
        return 0;
    }

    public final TextLayoutBuilder mo3196d() {
        return this.f21778b;
    }

    public final int mo3197e() {
        if (this.f21779c == null) {
            return 0;
        }
        return this.f21779c.m28442a(this.f21781e, this.f21777a, this.f21780d.m14654a(), this.f21786j);
    }
}

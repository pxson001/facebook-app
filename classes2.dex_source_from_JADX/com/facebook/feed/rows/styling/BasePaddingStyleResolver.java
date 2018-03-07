package com.facebook.feed.rows.styling;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle.PaddingValues;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import javax.annotation.Nullable;

/* compiled from: namespace */
public abstract class BasePaddingStyleResolver {
    private final EnumMap<BaseStyle, PaddingValues> f13039a = mo2550a();
    private final GraphQLStoryUtil f13040b;

    /* compiled from: namespace */
    public enum BaseStyle {
        DEFAULT,
        DEFAULT_TEXT,
        ZERO,
        DEFAULT_HEADER,
        STORY_EDGE,
        LEGACY_DEFAULT,
        LEGACY_ZERO,
        DEFAULT_TEXT_HEADER,
        SUBSTORY_HEADER,
        ATTACHMENT_TOP,
        ATTACHMENT_BOTTOM,
        SHARED_ATTACHMENT;

        public final boolean isZero() {
            return this == ZERO || this == LEGACY_ZERO;
        }

        public final boolean isSharedStoryAttachmentPadding() {
            return this == SHARED_ATTACHMENT;
        }
    }

    public abstract PaddingValues mo2549a(PaddingStyle paddingStyle, BackgroundStyler$Position backgroundStyler$Position, int i);

    protected abstract EnumMap<BaseStyle, PaddingValues> mo2550a();

    public abstract PaddingValues mo2551b(PaddingStyle paddingStyle, BackgroundStyler$Position backgroundStyler$Position, int i);

    public BasePaddingStyleResolver(GraphQLStoryUtil graphQLStoryUtil) {
        this.f13040b = graphQLStoryUtil;
    }

    public final PaddingValues m19175a(PaddingStyle paddingStyle) {
        return mo2549a(paddingStyle, BackgroundStyler$Position.MIDDLE, 0);
    }

    public EnumMap<BaseStyle, PaddingValues> mo2552b() {
        return this.f13039a;
    }

    public final int m19174a(PaddingStyle paddingStyle, @Nullable FeedProps<GraphQLStory> feedProps, float f) {
        boolean z = false;
        if (paddingStyle.m19314d()) {
            return 0;
        }
        GraphQLStory graphQLStory;
        int max;
        if (feedProps != null) {
            graphQLStory = (GraphQLStory) feedProps.f13444a;
        } else {
            graphQLStory = null;
        }
        if (graphQLStory instanceof GraphQLStory) {
            max = Math.max(0, this.f13040b.m9600i(feedProps));
        } else {
            max = 0;
        }
        max = Math.max(0, Math.round(m19175a(paddingStyle).f13047d.mo2553a(max) * f));
        if (max >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return max;
    }
}

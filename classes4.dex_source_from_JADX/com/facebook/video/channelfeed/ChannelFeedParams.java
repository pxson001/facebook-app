package com.facebook.video.channelfeed;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: other_bubble_color */
public class ChannelFeedParams {
    @Nullable
    public final FeedProps<GraphQLStory> f5872a;
    @Nullable
    public final List<FeedProps<GraphQLStory>> f5873b;
    @Nullable
    public final List<String> f5874c;
    @Nullable
    public final EntryPointInputVideoChannelEntryPoint f5875d;
    public final int f5876e;
    public final int f5877f;
    @Nullable
    public final PlayerOrigin f5878g;
    @Nullable
    public final EventTriggerType f5879h;
    @Nullable
    public final InlineToChannelFeedTransitionManager f5880i;
    public final boolean f5881j;
    public final ChannelFeedHeaderParams f5882k;
    @Nullable
    public final ExternalLogType f5883l;
    @Nullable
    public final String f5884m;
    public final int f5885n;

    /* compiled from: other_bubble_color */
    public class Builder {
        public FeedProps<GraphQLStory> f5858a;
        public List<FeedProps<GraphQLStory>> f5859b;
        private List<String> f5860c;
        public EntryPointInputVideoChannelEntryPoint f5861d;
        public int f5862e;
        public int f5863f;
        public PlayerOrigin f5864g;
        public EventTriggerType f5865h;
        public InlineToChannelFeedTransitionManager f5866i;
        public boolean f5867j;
        public ChannelFeedHeaderParams f5868k;
        @Nullable
        public ExternalLogType f5869l;
        @Nullable
        public String f5870m;
        public int f5871n = -1;

        public static Builder m6345a(ChannelFeedParams channelFeedParams) {
            Builder builder = new Builder();
            if (channelFeedParams != null) {
                builder.f5858a = channelFeedParams.f5872a;
                builder.f5859b = channelFeedParams.f5873b;
                builder.m6348b(channelFeedParams.f5874c);
                builder.f5861d = channelFeedParams.f5875d;
                builder.f5862e = channelFeedParams.f5876e;
                builder.f5863f = channelFeedParams.f5877f;
                builder.f5864g = channelFeedParams.f5878g;
                builder.f5865h = channelFeedParams.f5879h;
                builder.f5866i = channelFeedParams.f5880i;
                builder.f5867j = channelFeedParams.f5881j;
                builder.f5868k = channelFeedParams.f5882k;
                builder.f5869l = channelFeedParams.f5883l;
                builder.f5870m = channelFeedParams.f5884m;
                builder.f5871n = channelFeedParams.f5885n;
            }
            return builder;
        }

        public final Builder m6348b(List<String> list) {
            Preconditions.checkState(this.f5860c == null, "videoChannelIds should not have been previously already set");
            this.f5860c = list;
            return this;
        }

        public final Builder m6346a(String str) {
            Preconditions.checkState(this.f5860c == null, "videoChannelIds should not have been previously already set");
            if (str != null) {
                this.f5860c = Arrays.asList(new String[]{str});
            }
            return this;
        }

        public final ChannelFeedParams m6347a() {
            return new ChannelFeedParams(this.f5858a, this.f5859b, this.f5860c, this.f5861d, this.f5862e, this.f5863f, this.f5864g, this.f5865h, this.f5866i, this.f5867j, this.f5868k, this.f5869l, this.f5870m, this.f5871n);
        }
    }

    private ChannelFeedParams(FeedProps<GraphQLStory> feedProps, List<FeedProps<GraphQLStory>> list, List<String> list2, EntryPointInputVideoChannelEntryPoint entryPointInputVideoChannelEntryPoint, int i, int i2, PlayerOrigin playerOrigin, EventTriggerType eventTriggerType, InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager, boolean z, ChannelFeedHeaderParams channelFeedHeaderParams, ExternalLogType externalLogType, String str, int i3) {
        this.f5872a = feedProps;
        this.f5873b = list;
        this.f5874c = list2;
        this.f5875d = entryPointInputVideoChannelEntryPoint;
        this.f5876e = i;
        this.f5877f = i2;
        this.f5878g = playerOrigin;
        this.f5879h = eventTriggerType;
        this.f5880i = inlineToChannelFeedTransitionManager;
        this.f5881j = z;
        this.f5882k = channelFeedHeaderParams;
        this.f5883l = externalLogType;
        this.f5884m = str;
        this.f5885n = i3;
    }

    public String toString() {
        return "ChannelFeedParams{story=" + (this.f5872a != null ? (GraphQLStory) this.f5872a.a : null) + ", prefilledStories=" + this.f5873b + ", videoChannelIds='" + this.f5874c + '\'' + ", entryPoint=" + this.f5875d + ", seekPositionMs=" + this.f5876e + ", lastStartPositionMs=" + this.f5877f + ", playerOrigin=" + this.f5878g + ", originalPlayReason=" + this.f5879h + ", transitionManager=" + this.f5880i + ", disableCache=" + this.f5881j + ", headerParams=" + this.f5882k + ", externalLogType=" + this.f5883l + ", externalLogId=" + this.f5884m + ", selectedProductItemIndex=" + this.f5885n + '}';
    }
}

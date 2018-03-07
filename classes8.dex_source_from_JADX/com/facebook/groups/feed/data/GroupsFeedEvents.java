package com.facebook.groups.feed.data;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
public class GroupsFeedEvents extends FeedEvent {

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public abstract class StoryApproveEventSubscriber extends FeedEventSubscriber<StoryApproveEvent> {
        public final Class<StoryApproveEvent> m15595a() {
            return StoryApproveEvent.class;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public class PendingPostCountEvent extends FeedEvent {
        public final int f14006a;

        public PendingPostCountEvent(int i) {
            this.f14006a = i;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public class ReportedPostCountEvent extends FeedEvent {
        public final int f14007a;

        public ReportedPostCountEvent(int i) {
            this.f14007a = i;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public class StoryApproveEvent extends FeedEvent {
        public final FeedProps<GraphQLStory> f14008a;
        public final boolean f14009b;
        public final boolean f14010c;

        public StoryApproveEvent(FeedProps<GraphQLStory> feedProps, boolean z, boolean z2) {
            this.f14008a = feedProps;
            this.f14009b = z;
            this.f14010c = z2;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public class StoryIgnoreReportEvent extends FeedEvent {
        public final FeedProps<GraphQLStory> f14011a;
        public final boolean f14012b;
        public final boolean f14013c;

        public StoryIgnoreReportEvent(FeedProps<GraphQLStory> feedProps, boolean z, boolean z2) {
            this.f14011a = feedProps;
            this.f14012b = z;
            this.f14013c = z2;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public abstract class StoryIgnoreReportEventSubscriber extends FeedEventSubscriber<StoryIgnoreReportEvent> {
        public final Class<StoryIgnoreReportEvent> m15609a() {
            return StoryIgnoreReportEvent.class;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public class StoryPinEvent extends FeedEvent {
        public final FeedProps<GraphQLStory> f14014a;
        public final PinState f14015b;
        public final boolean f14016c;

        public StoryPinEvent(FeedProps<GraphQLStory> feedProps, PinState pinState, boolean z) {
            this.f14014a = feedProps;
            this.f14015b = pinState;
            this.f14016c = z;
        }
    }

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=postreach */
    public abstract class StoryPinEventSubscriber extends FeedEventSubscriber<StoryPinEvent> {
        public final Class<StoryPinEvent> m15610a() {
            return StoryPinEvent.class;
        }
    }
}

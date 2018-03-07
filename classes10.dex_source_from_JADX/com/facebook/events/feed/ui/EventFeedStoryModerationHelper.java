package com.facebook.events.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: com.facebook.TokenCachingStrategy.LastRefreshDate */
public class EventFeedStoryModerationHelper {
    public final DefaultAndroidThreadUtil f17424a;
    public final FeedEventBus f17425b;
    public final Toaster f17426c;
    public final GraphPostService f17427d;

    /* compiled from: com.facebook.TokenCachingStrategy.LastRefreshDate */
    public class C24581 implements OnClickListener {
        final /* synthetic */ FeedProps f17420a;
        final /* synthetic */ EventFeedStoryModerationHelper f17421b;

        public C24581(EventFeedStoryModerationHelper eventFeedStoryModerationHelper, FeedProps feedProps) {
            this.f17421b = eventFeedStoryModerationHelper;
            this.f17420a = feedProps;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            EventFeedStoryModerationHelper eventFeedStoryModerationHelper = this.f17421b;
            FeedProps feedProps = this.f17420a;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            eventFeedStoryModerationHelper.f17425b.a(new StoryDeleteEvent(feedProps));
            eventFeedStoryModerationHelper.f17425b.a(new ChangeRendererEvent());
            eventFeedStoryModerationHelper.f17424a.a(eventFeedStoryModerationHelper.f17427d.a(graphQLStory), new C24592(eventFeedStoryModerationHelper, graphQLStory));
        }
    }

    /* compiled from: com.facebook.TokenCachingStrategy.LastRefreshDate */
    public class C24592 extends OperationResultFutureCallback {
        final /* synthetic */ GraphQLStory f17422a;
        final /* synthetic */ EventFeedStoryModerationHelper f17423b;

        public C24592(EventFeedStoryModerationHelper eventFeedStoryModerationHelper, GraphQLStory graphQLStory) {
            this.f17423b = eventFeedStoryModerationHelper;
            this.f17422a = graphQLStory;
        }

        protected final void m17786a(ServiceException serviceException) {
            this.f17423b.f17426c.b(new ToastBuilder(2131233451));
            this.f17423b.f17425b.a(new StoryVisibilityEvent(this.f17422a.g(), this.f17422a.ai(), null, StoryVisibility.VISIBLE, this.f17422a.p()));
            this.f17423b.f17425b.a(new ChangeRendererEvent());
        }
    }

    @Inject
    public EventFeedStoryModerationHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FeedEventBus feedEventBus, Toaster toaster, GraphPostService graphPostService) {
        this.f17424a = defaultAndroidThreadUtil;
        this.f17425b = feedEventBus;
        this.f17426c = toaster;
        this.f17427d = graphPostService;
    }
}

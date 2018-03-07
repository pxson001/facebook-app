package com.facebook.feed.rows.sections.attachments;

import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsMutations;
import com.facebook.events.graphql.EventsMutations.EventRsvpMutationString;
import com.facebook.events.graphql.EventsMutations.WatchEventMutationString;
import com.facebook.events.graphql.EventsMutationsModels.OptimisticRsvpEventModel.Builder;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents.FetchFollowUpUnitEvent;
import com.facebook.graphql.calls.EventRsvpInputData;
import com.facebook.graphql.calls.EventRsvpInputData.Context;
import com.facebook.graphql.calls.EventRsvpInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventRsvpInputData.GuestStatus;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData;
import com.facebook.graphql.calls.EventUpdateExtendedViewerWatchStatusInputData.WatchStatus;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: operator */
public class EventAttachmentActionListener implements EventsRsvpActionListener {
    public GraphQLStoryAttachment f6052a;
    public FeedProps<GraphQLStoryAttachment> f6053b;
    public GraphQLStory f6054c;
    public CurrentModuleHolder f6055d;
    public FeedEventBus f6056e;
    public FeedStoryMutator f6057f;
    public GraphQLQueryExecutor f6058g;
    private TasksManager<String> f6059h;
    public ControllerMutationGatekeepers f6060i;

    @Inject
    public EventAttachmentActionListener(@Assisted FeedProps<GraphQLStoryAttachment> feedProps, CurrentModuleHolder currentModuleHolder, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f6053b = feedProps;
        this.f6052a = (GraphQLStoryAttachment) feedProps.a;
        this.f6054c = AttachmentProps.c(feedProps);
        this.f6055d = currentModuleHolder;
        this.f6056e = feedEventBus;
        this.f6057f = feedStoryMutator;
        this.f6058g = graphQLQueryExecutor;
        this.f6059h = tasksManager;
        this.f6060i = controllerMutationGatekeepers;
    }

    public final void mo544a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        String str;
        GuestStatus guestStatus;
        if (this.f6060i.b()) {
            this.f6056e.a(new FeedUnitMutatedEvent(this.f6057f.a(this.f6054c, this.f6052a, graphQLEventGuestStatus2)));
        }
        EventActionHistory eventActionHistory = new EventActionHistory();
        if (this.f6055d.b() != null) {
            str = this.f6055d.b().toString();
        } else {
            str = "native_newsfeed".toString();
        }
        eventActionHistory.a(str);
        eventActionHistory.b(ActionMechanism.FEED_ATTACHMENT.toString());
        Context context = new Context();
        context.a(ImmutableList.of(eventActionHistory));
        Builder builder = new Builder();
        builder.e = this.f6052a.z().dp();
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.f = graphQLEventGuestStatus2;
        GraphQLVisitableModel a = builder.a();
        if (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.GOING) {
            guestStatus = GuestStatus.GOING;
        } else if (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.MAYBE) {
            guestStatus = GuestStatus.MAYBE;
        } else {
            guestStatus = GuestStatus.NOT_GOING;
        }
        EventRsvpInputData a2 = new EventRsvpInputData().a(context).b(this.f6052a.z().dp()).a(guestStatus);
        a2.a(ImmutableList.of(TrackableFeedProps.a(this.f6053b).toString()));
        EventRsvpMutationString e = EventsMutations.e();
        e.a("input", a2);
        this.f6059h.a(m6505a(this.f6052a.z().dp()), this.f6058g.a(GraphQLRequest.a(e).m12413a(a)), new 1(this, graphQLEventGuestStatus2, graphQLEventGuestStatus));
    }

    public final void mo545a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        WatchStatus watchStatus;
        if (this.f6060i.b()) {
            this.f6056e.a(new FeedUnitMutatedEvent(this.f6057f.a(this.f6054c, this.f6052a, graphQLEventWatchStatus2)));
        }
        EventUpdateExtendedViewerWatchStatusInputData.Context.EventActionHistory eventActionHistory = new EventUpdateExtendedViewerWatchStatusInputData.Context.EventActionHistory();
        String b = this.f6055d.b();
        if (b != null) {
            b = b.toString();
        } else {
            b = "native_newsfeed".toString();
        }
        eventActionHistory.a(b);
        eventActionHistory.b(ActionMechanism.FEED_ATTACHMENT.toString());
        EventUpdateExtendedViewerWatchStatusInputData.Context context = new EventUpdateExtendedViewerWatchStatusInputData.Context();
        context.a(ImmutableList.of(eventActionHistory));
        Builder builder = new Builder();
        builder.e = this.f6052a.z().dp();
        builder = builder;
        builder.g = false;
        builder = builder;
        builder.h = graphQLEventWatchStatus2;
        GraphQLVisitableModel a = builder.a();
        if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.GOING) {
            watchStatus = WatchStatus.GOING;
        } else if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.WATCHED) {
            watchStatus = WatchStatus.WATCHED;
        } else if (graphQLEventWatchStatus2 == GraphQLEventWatchStatus.DECLINED) {
            watchStatus = WatchStatus.DECLINED;
        } else {
            watchStatus = WatchStatus.UNWATCHED;
        }
        EventUpdateExtendedViewerWatchStatusInputData a2 = new EventUpdateExtendedViewerWatchStatusInputData().a(context).b(this.f6052a.z().dp()).a(watchStatus);
        a2.a(ImmutableList.of(TrackableFeedProps.a(this.f6053b).toString()));
        WatchEventMutationString d = EventsMutations.d();
        d.a("input", a2);
        this.f6059h.a(m6505a(this.f6052a.z().dp()), this.f6058g.a(GraphQLRequest.a(d).m12413a(a)), new 2(this, graphQLEventWatchStatus, graphQLEventWatchStatus2));
    }

    public static void m6506a(EventAttachmentActionListener eventAttachmentActionListener) {
        if (eventAttachmentActionListener.f6052a != null && eventAttachmentActionListener.f6054c != null && eventAttachmentActionListener.f6054c.g() != null) {
            eventAttachmentActionListener.f6056e.a(new FetchFollowUpUnitEvent(eventAttachmentActionListener.f6054c.g(), GraphQLFollowUpFeedUnitActionType.EVENT_JOIN));
        }
    }

    private static String m6505a(String str) {
        return "event-rsvp-" + str;
    }
}

package com.facebook.feed.rows.sections.attachments;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: ZeroUpsellRequest */
public class EventAttachmentActionListener$2 extends AbstractDisposableFutureCallback<GraphQLResult<WatchEventMutationModel>> {
    final /* synthetic */ GraphQLEventWatchStatus f20569a;
    final /* synthetic */ GraphQLEventWatchStatus f20570b;
    final /* synthetic */ EventAttachmentActionListener f20571c;

    public EventAttachmentActionListener$2(EventAttachmentActionListener eventAttachmentActionListener, GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        this.f20571c = eventAttachmentActionListener;
        this.f20569a = graphQLEventWatchStatus;
        this.f20570b = graphQLEventWatchStatus2;
    }

    protected final void m23621a(Object obj) {
        if (this.f20569a != GraphQLEventWatchStatus.GOING && this.f20569a != GraphQLEventWatchStatus.WATCHED) {
            if (this.f20570b == GraphQLEventWatchStatus.GOING || this.f20570b == GraphQLEventWatchStatus.WATCHED) {
                EventAttachmentActionListener.a(this.f20571c);
            }
        }
    }

    protected final void m23622a(Throwable th) {
        if (this.f20571c.i.b()) {
            this.f20571c.e.a(new FeedUnitMutatedEvent(this.f20571c.f.a(this.f20571c.c, this.f20571c.a, this.f20569a)));
        }
    }
}

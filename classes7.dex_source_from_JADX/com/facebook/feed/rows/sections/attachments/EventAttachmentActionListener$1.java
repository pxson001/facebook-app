package com.facebook.feed.rows.sections.attachments;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: ZeroUpsellRequest */
public class EventAttachmentActionListener$1 extends AbstractDisposableFutureCallback<GraphQLResult<EventRsvpMutationModel>> {
    final /* synthetic */ GraphQLEventGuestStatus f20566a;
    final /* synthetic */ GraphQLEventGuestStatus f20567b;
    final /* synthetic */ EventAttachmentActionListener f20568c;

    public EventAttachmentActionListener$1(EventAttachmentActionListener eventAttachmentActionListener, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        this.f20568c = eventAttachmentActionListener;
        this.f20566a = graphQLEventGuestStatus;
        this.f20567b = graphQLEventGuestStatus2;
    }

    protected final void m23619a(Object obj) {
        if (this.f20566a == GraphQLEventGuestStatus.GOING) {
            EventAttachmentActionListener.a(this.f20568c);
        }
    }

    protected final void m23620a(Throwable th) {
        if (this.f20568c.i.b()) {
            this.f20568c.e.a(new FeedUnitMutatedEvent(this.f20568c.f.a(this.f20568c.c, this.f20568c.a, this.f20567b)));
        }
    }
}

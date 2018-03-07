package com.facebook.pages.identity.cards.events;

import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.google.common.base.Preconditions;

/* compiled from: privacy_checkup_manager_composer_options_server_fetch_failed */
class PageIdentityEventGalleryItem$PageEvenEventsRsvpActionListener implements EventsRsvpActionListener {
    final /* synthetic */ PageIdentityEventGalleryItem f3472a;

    public PageIdentityEventGalleryItem$PageEvenEventsRsvpActionListener(PageIdentityEventGalleryItem pageIdentityEventGalleryItem) {
        this.f3472a = pageIdentityEventGalleryItem;
    }

    public final void m4540a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
        Preconditions.checkNotNull(this.f3472a.l);
        Preconditions.checkNotNull(graphQLEventGuestStatus2);
        String as = this.f3472a.l.as();
        this.f3472a.b.a(PagesAsyncTaskType.JOIN_EVENT, new PageIdentityEventGalleryItem$1(this.f3472a, as, graphQLEventGuestStatus2), new PageIdentityEventGalleryItem$2(this.f3472a, as, graphQLEventGuestStatus2));
    }

    public final void m4541a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
        Preconditions.checkNotNull(this.f3472a.l);
        Preconditions.checkNotNull(graphQLEventWatchStatus2);
        String as = this.f3472a.l.as();
        this.f3472a.b.a(PagesAsyncTaskType.JOIN_EVENT, new PageIdentityEventGalleryItem$3(this.f3472a, as, graphQLEventWatchStatus2), new PageIdentityEventGalleryItem$4(this.f3472a, as, graphQLEventWatchStatus2));
    }
}

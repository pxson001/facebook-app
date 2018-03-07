package com.facebook.pages.identity.cards.events;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: privacy_checkup_manager_composer_options_server_fetch_failed */
public class PageIdentityEventGalleryItem$1 implements Callable<ListenableFuture<GraphQLResult<EventRsvpMutationModel>>> {
    final /* synthetic */ String f3460a;
    final /* synthetic */ GraphQLEventGuestStatus f3461b;
    final /* synthetic */ PageIdentityEventGalleryItem f3462c;

    public PageIdentityEventGalleryItem$1(PageIdentityEventGalleryItem pageIdentityEventGalleryItem, String str, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        this.f3462c = pageIdentityEventGalleryItem;
        this.f3460a = str;
        this.f3461b = graphQLEventGuestStatus;
    }

    public Object call() {
        return this.f3462c.e.a(this.f3460a, this.f3461b, "unknown", "pages_identity", ActionMechanism.PAGE_UPCOMING_EVENTS_CARD, null);
    }
}

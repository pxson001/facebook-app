package com.facebook.pages.identity.cards.events;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsMutationsModels.EventRsvpMutationModel;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: privacy_checkup_manager_composer_options_server_fetch_failed */
public class PageIdentityEventGalleryItem$2 extends AbstractDisposableFutureCallback<GraphQLResult<EventRsvpMutationModel>> {
    final /* synthetic */ String f3463a;
    final /* synthetic */ GraphQLEventGuestStatus f3464b;
    final /* synthetic */ PageIdentityEventGalleryItem f3465c;

    public PageIdentityEventGalleryItem$2(PageIdentityEventGalleryItem pageIdentityEventGalleryItem, String str, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        this.f3465c = pageIdentityEventGalleryItem;
        this.f3463a = str;
        this.f3464b = graphQLEventGuestStatus;
    }

    protected final void m4536a(Object obj) {
        this.f3465c.d.a(this.f3465c.m, this.f3463a, this.f3464b.name(), true);
    }

    protected final void m4537a(Throwable th) {
        this.f3465c.d.a(this.f3465c.m, this.f3463a, this.f3464b.name(), false);
        this.f3465c.c.b(new ToastBuilder(2131235482));
    }
}

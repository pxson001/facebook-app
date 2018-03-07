package com.facebook.pages.identity.cards.events;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.toaster.ToastBuilder;

/* compiled from: privacy_checkup_manager_composer_options_server_fetch_failed */
public class PageIdentityEventGalleryItem$4 extends AbstractDisposableFutureCallback<GraphQLResult<WatchEventMutationModel>> {
    final /* synthetic */ String f3469a;
    final /* synthetic */ GraphQLEventWatchStatus f3470b;
    final /* synthetic */ PageIdentityEventGalleryItem f3471c;

    public PageIdentityEventGalleryItem$4(PageIdentityEventGalleryItem pageIdentityEventGalleryItem, String str, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        this.f3471c = pageIdentityEventGalleryItem;
        this.f3469a = str;
        this.f3470b = graphQLEventWatchStatus;
    }

    protected final void m4538a(Object obj) {
        this.f3471c.d.a(this.f3471c.m, this.f3469a, this.f3470b.name(), true);
    }

    protected final void m4539a(Throwable th) {
        this.f3471c.d.a(this.f3471c.m, this.f3469a, this.f3470b.name(), false);
        this.f3471c.c.b(new ToastBuilder(2131235482));
    }
}

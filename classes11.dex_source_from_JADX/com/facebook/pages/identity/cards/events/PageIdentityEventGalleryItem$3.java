package com.facebook.pages.identity.cards.events;

import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsMutationsModels.WatchEventMutationModel;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: privacy_checkup_manager_composer_options_server_fetch_failed */
public class PageIdentityEventGalleryItem$3 implements Callable<ListenableFuture<GraphQLResult<WatchEventMutationModel>>> {
    final /* synthetic */ String f3466a;
    final /* synthetic */ GraphQLEventWatchStatus f3467b;
    final /* synthetic */ PageIdentityEventGalleryItem f3468c;

    public PageIdentityEventGalleryItem$3(PageIdentityEventGalleryItem pageIdentityEventGalleryItem, String str, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        this.f3468c = pageIdentityEventGalleryItem;
        this.f3466a = str;
        this.f3467b = graphQLEventWatchStatus;
    }

    public Object call() {
        return this.f3468c.f.a(this.f3466a, this.f3467b, "unknown", "pages_identity", ActionMechanism.PAGE_UPCOMING_EVENTS_CARD);
    }
}

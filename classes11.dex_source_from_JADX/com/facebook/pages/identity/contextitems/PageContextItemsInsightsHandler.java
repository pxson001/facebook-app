package com.facebook.pages.identity.contextitems;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PagesInsightsContextItemClickEvent;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: photo_checkup_info */
public class PageContextItemsInsightsHandler {
    private final PageScopedEventBus f3838a;

    @Inject
    public PageContextItemsInsightsHandler(PageScopedEventBus pageScopedEventBus) {
        this.f3838a = pageScopedEventBus;
    }

    public final void m4776a(ContextItemFieldsModel contextItemFieldsModel, PageContextItemHandlingData pageContextItemHandlingData) {
        Preconditions.checkNotNull(pageContextItemHandlingData.j);
        this.f3838a.a(new PagesInsightsContextItemClickEvent(pageContextItemHandlingData.j, contextItemFieldsModel.d()));
    }
}

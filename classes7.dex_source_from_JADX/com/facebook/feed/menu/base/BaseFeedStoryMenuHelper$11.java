package com.facebook.feed.menu.base;

import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$11 extends OperationResultFutureCallback {
    final /* synthetic */ GraphQLStory f19370a;
    final /* synthetic */ BaseFeedStoryMenuHelper f19371b;

    BaseFeedStoryMenuHelper$11(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, GraphQLStory graphQLStory) {
        this.f19371b = baseFeedStoryMenuHelper;
        this.f19370a = graphQLStory;
    }

    protected final void m22809a(ServiceException serviceException) {
        ((Toaster) this.f19371b.d.get()).b(new ToastBuilder(2131233451));
        this.f19371b.c.a(new StoryVisibilityEvent(this.f19370a.g(), this.f19370a.ai(), null, StoryVisibility.VISIBLE, this.f19370a.p()));
        this.f19371b.c.a(new ChangeRendererEvent());
    }
}

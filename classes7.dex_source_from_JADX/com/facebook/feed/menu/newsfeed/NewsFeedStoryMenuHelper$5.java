package com.facebook.feed.menu.newsfeed;

import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteConfirmedEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$5 extends OperationResultFutureCallback {
    final /* synthetic */ GraphQLStory f19468a;
    final /* synthetic */ NewsFeedStoryMenuHelper f19469b;

    NewsFeedStoryMenuHelper$5(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, GraphQLStory graphQLStory) {
        this.f19469b = newsFeedStoryMenuHelper;
        this.f19468a = graphQLStory;
    }

    protected final void m22829a(ServiceException serviceException) {
        ((Toaster) this.f19469b.d.get()).b(new ToastBuilder(2131233451));
        this.f19469b.c.a(new StoryVisibilityEvent(this.f19468a.g(), this.f19468a.ai(), null, StoryVisibility.VISIBLE, this.f19468a.p()));
        this.f19469b.c.a(new ChangeRendererEvent());
    }

    protected final void m22830a(Object obj) {
        ((Toaster) this.f19469b.d.get()).b(new ToastBuilder(2131233458));
        this.f19469b.c.a(new StoryDeleteConfirmedEvent());
    }
}

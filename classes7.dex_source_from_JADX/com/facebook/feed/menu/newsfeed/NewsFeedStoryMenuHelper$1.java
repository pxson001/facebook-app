package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$1 extends OperationResultFutureCallback {
    final /* synthetic */ HoneyClientEvent f19457a;
    final /* synthetic */ HideableUnit f19458b;
    final /* synthetic */ View f19459c;
    final /* synthetic */ NewsFeedStoryMenuHelper f19460d;

    NewsFeedStoryMenuHelper$1(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, HoneyClientEvent honeyClientEvent, HideableUnit hideableUnit, View view) {
        this.f19460d = newsFeedStoryMenuHelper;
        this.f19457a = honeyClientEvent;
        this.f19458b = hideableUnit;
        this.f19459c = view;
    }

    public final void m22828a(Object obj) {
        this.f19460d.i.a(this.f19457a);
    }

    protected final void m22827a(ServiceException serviceException) {
        ((Toaster) this.f19460d.d.get()).b(new ToastBuilder(2131233434));
        this.f19460d.c.a(new StoryVisibilityEvent(this.f19458b.g(), null, null, StoryVisibility.VISIBLE, this.f19459c.getMeasuredHeight()));
        this.f19460d.c.a(new ChangeRendererEvent());
    }
}

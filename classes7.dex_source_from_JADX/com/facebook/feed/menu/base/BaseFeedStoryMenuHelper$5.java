package com.facebook.feed.menu.base;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$5 extends OperationResultFutureCallback {
    final /* synthetic */ NegativeFeedbackActionsUnit f19387a;
    final /* synthetic */ View f19388b;
    final /* synthetic */ HoneyClientEvent f19389c;
    final /* synthetic */ GraphQLNegativeFeedbackAction f19390d;
    final /* synthetic */ BaseFeedStoryMenuHelper f19391e;

    BaseFeedStoryMenuHelper$5(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, View view, HoneyClientEvent honeyClientEvent, GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction) {
        this.f19391e = baseFeedStoryMenuHelper;
        this.f19387a = negativeFeedbackActionsUnit;
        this.f19388b = view;
        this.f19389c = honeyClientEvent;
        this.f19390d = graphQLNegativeFeedbackAction;
    }

    protected final void m22812a(Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        this.f19391e.i.a(this.f19389c);
        this.f19391e.a(this.f19387a, this.f19390d, operationResult);
    }

    protected final void m22811a(ServiceException serviceException) {
        ((Toaster) this.f19391e.d.get()).b(new ToastBuilder(2131233434));
        NegativeFeedbackActionsUnit negativeFeedbackActionsUnit = (NegativeFeedbackActionsUnit) FeedUnitMutator.a(this.f19387a).a(null).a();
        BaseFeedStoryMenuHelper baseFeedStoryMenuHelper = this.f19391e;
        String str = null;
        baseFeedStoryMenuHelper.c.a(new StoryVisibilityEvent(negativeFeedbackActionsUnit.g(), null, str, StoryVisibility.VISIBLE, this.f19388b.getMeasuredHeight()));
        baseFeedStoryMenuHelper.c.a(new ChangeRendererEvent());
    }
}

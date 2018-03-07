package com.facebook.notifications.action;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.notifications.event.NotificationsEvents.NotificationsActionExecutedEvent;
import com.facebook.notifications.event.NotificationsEvents.NotificationsSubscriptionUpdatedEvent;
import com.facebook.notifications.protocol.NotifOptionRowsMutationModels.NotifOptionActionMutationModel;
import com.google.common.base.Strings;

/* compiled from: no_crop */
class NotificationsActionExecutor$NotificationsActionExecutedCallback extends AbstractDisposableFutureCallback<GraphQLResult<NotifOptionActionMutationModel>> {
    final /* synthetic */ NotificationsActionExecutor f8126a;
    private final NotificationsServerActionParams f8127b;

    public NotificationsActionExecutor$NotificationsActionExecutedCallback(NotificationsActionExecutor notificationsActionExecutor, NotificationsServerActionParams notificationsServerActionParams) {
        this.f8126a = notificationsActionExecutor;
        this.f8127b = notificationsServerActionParams;
    }

    protected final void m9774a(Object obj) {
        if (!(this.f8127b.f8146e == null || this.f8127b.f8147f == null)) {
            this.f8126a.f.a(new NotificationsSubscriptionUpdatedEvent(this.f8127b.f8146e.k(), this.f8127b.f8147f, this.f8127b.f8149h, this.f8127b.f8150i, this.f8127b.f8144c));
        }
        if (!Strings.isNullOrEmpty(this.f8127b.f8143b)) {
            this.f8126a.f.a(new NotificationsActionExecutedEvent(this.f8127b.f8143b));
        }
    }

    protected final void m9775a(Throwable th) {
    }
}

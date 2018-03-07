package com.facebook.notifications.widget;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: method/mobile.zeroBalanceDetection */
class NotificationsFragment$11 implements FutureCallback<GraphQLStory> {
    final /* synthetic */ int f9038a;
    final /* synthetic */ String f9039b;
    final /* synthetic */ NotificationsFragment f9040c;

    NotificationsFragment$11(NotificationsFragment notificationsFragment, int i, String str) {
        this.f9040c = notificationsFragment;
        this.f9038a = i;
        this.f9039b = str;
    }

    public void onSuccess(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        NotificationsFragment.a(this.f9040c, graphQLStory == null ? null : FeedProps.c(graphQLStory), this.f9038a, this.f9039b);
    }

    public void onFailure(Throwable th) {
        this.f9040c.az.f(655408, "NNF_PermalinkNotificationLoad");
        this.f9040c.aN.a();
    }
}

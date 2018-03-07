package com.facebook.feed.rows.sections.header;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.graphql.calls.ActorSubscribeInputData$SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData$SubscribeLocation;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: normalized_number */
final class FollowUserButtonPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLSubscribeStatus f7014a;
    final /* synthetic */ CanFollowUser f7015b;
    final /* synthetic */ String f7016c;
    final /* synthetic */ ActorUnsubscribeInputData$SubscribeLocation f7017d;
    final /* synthetic */ ActorSubscribeInputData$SubscribeLocation f7018e;

    FollowUserButtonPartDefinition$1(GraphQLSubscribeStatus graphQLSubscribeStatus, CanFollowUser canFollowUser, String str, ActorUnsubscribeInputData$SubscribeLocation actorUnsubscribeInputData$SubscribeLocation, ActorSubscribeInputData$SubscribeLocation actorSubscribeInputData$SubscribeLocation) {
        this.f7014a = graphQLSubscribeStatus;
        this.f7015b = canFollowUser;
        this.f7016c = str;
        this.f7017d = actorUnsubscribeInputData$SubscribeLocation;
        this.f7018e = actorSubscribeInputData$SubscribeLocation;
    }

    public final void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -558297482);
        if (this.f7014a == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            this.f7015b.b(this.f7016c, String.valueOf(this.f7017d));
        } else {
            this.f7015b.a(this.f7016c, String.valueOf(this.f7018e));
        }
        LogUtils.a(1003802311, a);
    }
}

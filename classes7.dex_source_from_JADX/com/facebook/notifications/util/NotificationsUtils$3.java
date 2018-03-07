package com.facebook.notifications.util;

import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;

/* compiled from: minf */
public class NotificationsUtils$3 implements Runnable {
    final /* synthetic */ String f8918a;
    final /* synthetic */ ReactionUnitFragment f8919b;
    final /* synthetic */ NotificationsUtils f8920c;

    public NotificationsUtils$3(NotificationsUtils notificationsUtils, String str, ReactionUnitFragment reactionUnitFragment) {
        this.f8920c = notificationsUtils;
        this.f8918a = str;
        this.f8919b = reactionUnitFragment;
    }

    public void run() {
        ((GraphQLNotificationsContentProviderHelper) this.f8920c.c.get()).c(this.f8918a, this.f8919b);
    }
}

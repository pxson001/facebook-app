package com.facebook.video.videohome.liveupdates;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.video.videohome.liveupdates.LiveVideoStatusNotifier.SubscriptionHandlersCallback;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.LiveVideoBroadcastStatusUpdateSubscriptionModel;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

/* compiled from: source_view_info */
public class SubscriptionHandlersCollection {
    private final Lock f2966a = new ReentrantLock();
    private final SubscriptionHandlersCallback f2967b;
    public final Map<String, GraphQLSubscriptionHandle<LiveVideoBroadcastStatusUpdateSubscriptionModel>> f2968c = new HashMap();
    @Nullable
    private CollectionUpdateTransaction f2969d;

    public SubscriptionHandlersCollection(SubscriptionHandlersCallback subscriptionHandlersCallback) {
        Preconditions.checkNotNull(subscriptionHandlersCallback);
        this.f2967b = subscriptionHandlersCallback;
    }

    public final void m2879a(String str) {
        this.f2966a.lock();
        try {
            if (this.f2969d != null) {
                throw new IllegalStateException("Collection update transaction exists, must call transaction methods only");
            }
            m2878b(str);
        } finally {
            this.f2966a.unlock();
        }
    }

    private void m2878b(String str) {
        GraphQLSubscriptionHandle graphQLSubscriptionHandle = (GraphQLSubscriptionHandle) this.f2968c.remove(str);
        if (graphQLSubscriptionHandle != null) {
            ((VideoHomeSubscriptionsGraphQLHelper) this.f2967b.f2955a.f2961e.get()).b(graphQLSubscriptionHandle);
            return;
        }
        BLog.a("SubscriptionHandlersCollection", "Failed to remove subscription handler: no handler for video with id=%s", new Object[]{str});
    }

    public final int m2880b() {
        return this.f2968c.size();
    }
}

package com.facebook.video.videohome.liveupdates;

import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.LiveVideoBroadcastStatusUpdateSubscriptionModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: spend_info */
public class BroadcastStatusUpdateManager$VideoTracker {
    final /* synthetic */ BroadcastStatusUpdateManager f2948a;
    public final String f2949b;
    public final ArrayList<WeakReference<BroadcastStatusUpdateListener>> f2950c = new ArrayList();
    public GraphQLSubscriptionHandle<LiveVideoBroadcastStatusUpdateSubscriptionModel> f2951d;
    public GraphQLVideoBroadcastStatus f2952e;

    public BroadcastStatusUpdateManager$VideoTracker(BroadcastStatusUpdateManager broadcastStatusUpdateManager, String str) {
        this.f2948a = broadcastStatusUpdateManager;
        this.f2949b = str;
    }

    public final synchronized void m2869a(BroadcastStatusUpdateListener broadcastStatusUpdateListener) {
        ArrayList c = m2866c();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            if (((WeakReference) c.get(i)).get() == broadcastStatusUpdateListener) {
                break;
            }
        }
        this.f2950c.add(new WeakReference(broadcastStatusUpdateListener));
    }

    public final synchronized void m2871b(BroadcastStatusUpdateListener broadcastStatusUpdateListener) {
        this.f2950c.remove(broadcastStatusUpdateListener);
        Iterator it = this.f2950c.iterator();
        while (it.hasNext()) {
            if (broadcastStatusUpdateListener == ((WeakReference) it.next()).get()) {
                it.remove();
            }
        }
    }

    public final synchronized void m2868a(@Nullable GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, @Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        ArrayList c = m2866c();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            BroadcastStatusUpdateListener broadcastStatusUpdateListener = (BroadcastStatusUpdateListener) ((WeakReference) c.get(i)).get();
            if (broadcastStatusUpdateListener != null) {
                if (graphQLVideoBroadcastStatus == null) {
                    broadcastStatusUpdateListener.mo79a(this.f2949b);
                } else {
                    broadcastStatusUpdateListener.mo80a(this.f2949b, graphQLVideoBroadcastStatus, videoBroadcastFragmentModel);
                }
            }
        }
    }

    private ArrayList<WeakReference<BroadcastStatusUpdateListener>> m2866c() {
        return (ArrayList) this.f2950c.clone();
    }

    public final void m2867a() {
        if (this.f2951d != null) {
            ((VideoHomeSubscriptionsGraphQLHelper) this.f2948a.c.get()).b(this.f2951d);
            this.f2951d = null;
        }
    }

    public final void m2870b() {
        if (this.f2951d == null) {
            this.f2951d = ((VideoHomeSubscriptionsGraphQLHelper) this.f2948a.c.get()).b(this.f2949b, new BroadcastStatusUpdateManager$2(this.f2948a, this.f2949b));
        }
    }
}

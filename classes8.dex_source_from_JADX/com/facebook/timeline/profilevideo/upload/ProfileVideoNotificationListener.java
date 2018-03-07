package com.facebook.timeline.profilevideo.upload;

import android.os.Handler;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.notifications.subscription.NotificationSubscriptionsManager;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: mIsPrefilled */
public class ProfileVideoNotificationListener {
    public static final String[] f9427a = new String[]{"video_processed", "video_failed"};
    public final String f9428b;
    public final NotificationSubscriptionsManager f9429c;
    public final OptimisticProfileVideoStore f9430d;
    public final ProfileMediaChangeBroadcaster f9431e;
    public final Handler f9432f;
    public final ProfileVideoNotificationTypeSubscriber f9433g = new ProfileVideoNotificationTypeSubscriber(this);
    public final Runnable f9434h = new C09841(this);

    /* compiled from: mIsPrefilled */
    class C09841 implements Runnable {
        final /* synthetic */ ProfileVideoNotificationListener f9425a;

        C09841(ProfileVideoNotificationListener profileVideoNotificationListener) {
            this.f9425a = profileVideoNotificationListener;
        }

        public void run() {
            ProfileVideoNotificationListener.m11187c(this.f9425a);
        }
    }

    /* compiled from: mIsPrefilled */
    public class ProfileVideoNotificationTypeSubscriber {
        final /* synthetic */ ProfileVideoNotificationListener f9426a;

        public ProfileVideoNotificationTypeSubscriber(ProfileVideoNotificationListener profileVideoNotificationListener) {
            this.f9426a = profileVideoNotificationListener;
        }

        public final void m11186a(GraphQLStory graphQLStory) {
            try {
                JSONObject jSONObject = new JSONObject(graphQLStory.k());
                if (jSONObject.has("context_id") && jSONObject.get("context_id").toString().equals(this.f9426a.f9428b)) {
                    this.f9426a.f9430d.m11185c(this.f9426a.f9428b);
                    this.f9426a.f9431e.m10948e();
                    this.f9426a.f9431e.m10945b();
                    ProfileVideoNotificationListener.m11187c(this.f9426a);
                }
            } catch (JSONException e) {
            }
        }
    }

    @Inject
    public ProfileVideoNotificationListener(@Assisted String str, NotificationSubscriptionsManager notificationSubscriptionsManager, OptimisticProfileVideoStore optimisticProfileVideoStore, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster, Handler handler) {
        this.f9428b = str;
        this.f9429c = notificationSubscriptionsManager;
        this.f9430d = optimisticProfileVideoStore;
        this.f9431e = profileMediaChangeBroadcaster;
        this.f9432f = handler;
    }

    public static void m11187c(ProfileVideoNotificationListener profileVideoNotificationListener) {
        profileVideoNotificationListener.f9429c.a(profileVideoNotificationListener.f9433g);
        HandlerDetour.a(profileVideoNotificationListener.f9432f, profileVideoNotificationListener.f9434h);
    }
}

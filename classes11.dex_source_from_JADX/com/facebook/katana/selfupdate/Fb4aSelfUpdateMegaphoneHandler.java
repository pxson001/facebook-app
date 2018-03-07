package com.facebook.katana.selfupdate;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.graphql.model.GraphQLMegaphone.Builder;
import com.facebook.graphql.model.GraphQLMegaphoneAction;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.selfupdate.SelfUpdateNotificationHandler;
import javax.inject.Inject;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: Unrecognized view type %s in createCollectionView */
public class Fb4aSelfUpdateMegaphoneHandler implements SelfUpdateNotificationHandler {
    private final Fb4aSelfUpdateNotificationHandler f10409a;
    private final MegaphoneStore f10410b;

    public static Fb4aSelfUpdateMegaphoneHandler m10816b(InjectorLike injectorLike) {
        return new Fb4aSelfUpdateMegaphoneHandler(new Fb4aSelfUpdateNotificationHandler((Context) injectorLike.getInstance(Context.class), SystemTrayNotificationManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4064), IdBasedProvider.a(injectorLike, 8699)), MegaphoneStore.a(injectorLike));
    }

    @Inject
    public Fb4aSelfUpdateMegaphoneHandler(Fb4aSelfUpdateNotificationHandler fb4aSelfUpdateNotificationHandler, MegaphoneStore megaphoneStore) {
        this.f10409a = fb4aSelfUpdateNotificationHandler;
        this.f10410b = megaphoneStore;
    }

    public final void m10818a(Intent intent) {
        String stringExtra = intent.getStringExtra("megaphone");
        if (stringExtra == null || this.f10410b.b(GraphQLMegaphoneLocation.NEWSFEED)) {
            this.f10409a.m10820a(intent);
            return;
        }
        try {
            this.f10410b.a(GraphQLMegaphoneLocation.NEWSFEED, new MegaphoneWithLayout(null, m10815a((JSONObject) new JSONTokener(stringExtra).nextValue(), intent)), 0);
        } catch (Throwable e) {
            BLog.b(Fb4aSelfUpdateMegaphoneHandler.class, "megaphone malformed json:", e);
        }
    }

    public final void m10817a() {
        this.f10409a.m10819a();
    }

    private static GraphQLMegaphone m10815a(JSONObject jSONObject, Intent intent) {
        GraphQLMegaphone graphQLMegaphone = null;
        String stringExtra = intent.getStringExtra("app_name");
        String stringExtra2 = intent.getStringExtra("release_notes");
        String stringExtra3 = intent.getStringExtra("local_uri");
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONArray("data").optJSONObject(0);
                if (optJSONObject != null) {
                    graphQLMegaphone = new Builder().a(optJSONObject.optString("id")).a(GraphQLMegaphoneLocation.NEWSFEED).b(optJSONObject.optString("title")).a(GraphQLHelper.a(optJSONObject.optJSONObject("content").optString("text"))).a(new GraphQLMegaphoneAction.Builder().a(optJSONObject.optJSONObject("action").optString("title")).b(FBLinks.a("install/?file=" + stringExtra3 + "&notes=" + stringExtra2 + "&appName=" + stringExtra)).a()).a(true).a();
                }
            } catch (Exception e) {
            }
        }
        return graphQLMegaphone;
    }
}

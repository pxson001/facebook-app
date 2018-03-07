package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.IntentResolver;
import com.facebook.location.ImmutableLocation;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: WearableListenerService */
public abstract class FriendsNearbyMapPingAction {
    abstract Optional<Intent> mo947a(ImmutableLocation immutableLocation, String str);

    abstract String mo948a();

    abstract String mo949b();

    FriendsNearbyMapPingAction() {
    }

    public final Optional<Intent> m21964a(Context context, ImmutableLocation immutableLocation, String str) {
        Optional<Intent> a = mo947a(immutableLocation, str);
        if (a.isPresent()) {
            Optional of;
            Intent intent = (Intent) a.get();
            if (IntentResolver.b(context, intent)) {
                of = Optional.of(intent);
            } else {
                of = Absent.INSTANCE;
            }
            if (of.isPresent()) {
                return a;
            }
        }
        return Absent.INSTANCE;
    }
}

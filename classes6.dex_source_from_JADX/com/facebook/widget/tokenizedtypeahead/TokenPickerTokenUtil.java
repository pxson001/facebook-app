package com.facebook.widget.tokenizedtypeahead;

import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;

/* compiled from: com.facebook.push.mqtt.ipc.SyncQueueTracker */
public class TokenPickerTokenUtil {
    public static TokenPickerTokenUtil m28700a(InjectorLike injectorLike) {
        return new TokenPickerTokenUtil();
    }

    public static User m28699a(User user) {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.g = user.e;
        userBuilder = userBuilder.a(user.b, user.a);
        userBuilder.n = user.x();
        return userBuilder.aa();
    }
}

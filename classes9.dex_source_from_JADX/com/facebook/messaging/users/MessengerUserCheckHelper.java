package com.facebook.messaging.users;

import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceState;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: chat_head_nux_message_go_home */
public class MessengerUserCheckHelper {
    private final DefaultPresenceManager f18319a;
    public final Provider<User> f18320b;
    public final UserCache f18321c;

    public static MessengerUserCheckHelper m18273b(InjectorLike injectorLike) {
        return new MessengerUserCheckHelper(DefaultPresenceManager.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), UserCache.a(injectorLike));
    }

    @Inject
    public MessengerUserCheckHelper(PresenceManager presenceManager, Provider<User> provider, UserCache userCache) {
        this.f18319a = presenceManager;
        this.f18320b = provider;
        this.f18321c = userCache;
    }

    public final boolean m18275a(UserKey userKey) {
        TriState triState;
        PresenceState c = this.f18319a.c(userKey);
        if (c != null) {
            triState = c.d;
        } else {
            triState = TriState.UNSET;
        }
        if (triState.isSet()) {
            return triState.asBoolean();
        }
        User a = this.f18321c.a(userKey);
        return a != null && (a.t || a.u);
    }

    public final boolean m18274a(User user) {
        TriState triState = this.f18319a.c(user.T).d;
        if (triState.isSet()) {
            return triState.asBoolean();
        }
        return user.t || user.u;
    }

    public final boolean m18276c(UserKey userKey) {
        User a = this.f18321c.a(userKey);
        if (a == null) {
            return false;
        }
        return a.E;
    }
}

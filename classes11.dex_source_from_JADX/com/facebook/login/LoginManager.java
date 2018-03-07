package com.facebook.login;

import com.facebook.internal.Validate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: video_fbid */
public class LoginManager {
    public static final Set<String> f237a = Collections.unmodifiableSet(new C00392());
    private LoginBehavior f238b = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience f239c = DefaultAudience.FRIENDS;

    /* compiled from: video_fbid */
    public final class C00392 extends HashSet<String> {
        public C00392() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    LoginManager() {
        Validate.a();
    }
}

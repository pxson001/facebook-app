package com.facebook.common.activitylistener.annotations;

/* compiled from: submit_item_for_checkout */
public final class AuthNotRequiredHelper {
    private AuthNotRequiredHelper() {
    }

    public static boolean m6539a(Object obj) {
        return IAuthNotRequired.class.isAssignableFrom(obj.getClass());
    }
}

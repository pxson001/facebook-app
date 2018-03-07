package com.facebook.user.model;

import com.facebook.user.model.User.Type;
import com.google.common.base.Function;

/* compiled from: editPrivacyFeedStoryParams */
final class UserKey$1 implements Function<String, UserKey> {
    UserKey$1() {
    }

    public final Object apply(Object obj) {
        return new UserKey(Type.FACEBOOK, (String) obj);
    }
}

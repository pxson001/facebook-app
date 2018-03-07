package com.facebook.common.userinteraction;

import com.facebook.common.userinteraction.DefaultUserInteractionController.ActivityListener;
import com.facebook.inject.AbstractProvider;

/* compiled from: whitelisted_uri_regexes */
public class ActivityListenerMethodAutoProvider extends AbstractProvider<ActivityListener> {
    public Object get() {
        return UserInteractionModule.a(DefaultUserInteractionController.a(this));
    }
}

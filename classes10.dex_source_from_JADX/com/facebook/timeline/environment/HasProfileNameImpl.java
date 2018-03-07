package com.facebook.timeline.environment;

import android.support.annotation.Nullable;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: gametime_internal_preferences */
public class HasProfileNameImpl implements HasProfileFirstName, HasProfileName {
    public String f10994a;
    public String f10995b;

    @Inject
    public HasProfileNameImpl(@Assisted String str) {
        this.f10994a = str;
    }

    @Nullable
    public final String mo519l() {
        return this.f10995b;
    }
}

package com.facebook.location;

import android.content.res.Resources;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: грн. */
public class LocationDisplayUtil {
    public static final ImmutableSet<String> f49a = ImmutableSet.of("US", "LR", "MM");
    public final Resources f50b;

    /* compiled from: грн. */
    public enum DistanceUnit {
        METRIC,
        IMPERIAL
    }

    @Inject
    public LocationDisplayUtil(Resources resources) {
        this.f50b = resources;
    }
}

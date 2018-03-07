package com.facebook.adinterfaces.ui.selector;

import com.google.common.base.Preconditions;

/* compiled from: Unknown connection quality type */
public final class TargetingSelectorFragmentFactory {

    /* compiled from: Unknown connection quality type */
    public enum SelectorType {
        LOCATION,
        INTEREST
    }

    private TargetingSelectorFragmentFactory() {
    }

    public static BaseTargetingSelectorFragment<?> m25225a(SelectorType selectorType) {
        Preconditions.checkNotNull(selectorType);
        switch (selectorType) {
            case LOCATION:
                return new LocationTargetingFragment();
            case INTEREST:
                return new InterestTargetingSelectorFragment();
            default:
                throw new AssertionError("Got an unknown SelectorType: " + selectorType.toString());
        }
    }
}

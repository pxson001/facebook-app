package com.facebook.video.player.plugins;

/* compiled from: commerce_view_product_details */
public enum VideoControlsBasePlugin$InitialChromeBehavior {
    AUTO_WITH_INITIALLY_VISIBLE,
    AUTO_WITH_INITIALLY_HIDDEN,
    ALWAYS_VISIBLE,
    ALWAYS_HIDDEN;

    final boolean isInitiallyVisible() {
        return this == ALWAYS_VISIBLE || this == AUTO_WITH_INITIALLY_VISIBLE;
    }

    final ChromeBehavior getBehavior() {
        if (this == ALWAYS_VISIBLE) {
            return ChromeBehavior.ALWAYS_VISIBLE;
        }
        if (this == ALWAYS_HIDDEN) {
            return ChromeBehavior.ALWAYS_HIDDEN;
        }
        return ChromeBehavior.AUTO;
    }
}

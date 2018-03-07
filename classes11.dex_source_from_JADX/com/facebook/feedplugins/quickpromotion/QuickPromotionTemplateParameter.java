package com.facebook.feedplugins.quickpromotion;

import java.util.Locale;

/* compiled from: carrier_manager?ref={%s} */
public class QuickPromotionTemplateParameter {

    /* compiled from: carrier_manager?ref={%s} */
    public enum BrandingStyle {
        BRANDING_BOTTOM_DIVIDER,
        UNKNOWN;

        public static BrandingStyle fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum FeedTapAction {
        USE_PRIMARY_ACTION,
        USE_SECONDARY_ACTION,
        UNKNOWN;

        public static FeedTapAction fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum ImageOverlay {
        CIRCLE_CROP,
        FACEBOOK_BADGE,
        MESSENGER_BADGE,
        UNKNOWN;

        public static ImageOverlay fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum LargeImageLocation {
        TOP,
        UNKNOWN;

        public static LargeImageLocation fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum LargeImageMarginOption {
        NONE,
        TOP_BOTTOM,
        BOTTOM,
        UNKNOWN;

        public static LargeImageMarginOption fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum LargeImageProfilePhotoOption {
        CENTERED,
        UNKNOWN;

        public static LargeImageProfilePhotoOption fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum PrimaryActionButtonGlyph {
        DISCLOSURE,
        SHARE,
        UNKNOWN;

        public static PrimaryActionButtonGlyph fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum PrimaryActionButtonStyle {
        PRIMARY,
        UNKNOWN;

        public static PrimaryActionButtonStyle fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum SecondaryActionButtonGlyph {
        DISCLOSURE,
        SHARE,
        UNKNOWN;

        public static SecondaryActionButtonGlyph fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum TitleSize {
        BIG,
        SMALL,
        UNKNOWN;

        public static TitleSize fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: carrier_manager?ref={%s} */
    public enum Type {
        IMAGE_OVERLAY,
        NEWSFEED_LARGE_IMAGE_LOCATION,
        PRIMARY_ACTION_BUTTON_GLYPH,
        FEED_TAP_ACTION,
        NEWSFEED_BRANDING_STYLE,
        SECONDARY_ACTION_BUTTON_GLYPH,
        TITLE_SIZE,
        PRIMARY_ACTION_BUTTON_STYLE,
        NEWSFEED_LARGE_IMAGE_MARGIN_OPTION,
        NEWSFEED_LARGE_IMAGE_PROFILE_PHOTO,
        UNKNOWN;

        public static Type fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }
}

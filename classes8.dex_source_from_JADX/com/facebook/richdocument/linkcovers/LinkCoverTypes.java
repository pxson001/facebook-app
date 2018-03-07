package com.facebook.richdocument.linkcovers;

import java.util.HashMap;
import java.util.Map;

/* compiled from: place_tips_hide_tap */
public class LinkCoverTypes {

    /* compiled from: place_tips_hide_tap */
    public enum DescriptionConstraint {
        BEFORE,
        AFTER,
        END,
        EXACT,
        MAX;
        
        private static final Map<String, DescriptionConstraint> sAfterMap = null;
        private static final Map<String, DescriptionConstraint> sBeforeMap = null;
        private static final Map<String, DescriptionConstraint> sEndMap = null;

        static {
            Map hashMap = new HashMap();
            sBeforeMap = hashMap;
            hashMap.put("before", BEFORE);
            sBeforeMap.put("above", BEFORE);
            sBeforeMap.put("left_of", BEFORE);
            hashMap = new HashMap();
            sAfterMap = hashMap;
            hashMap.put("after", AFTER);
            sAfterMap.put("below", AFTER);
            sAfterMap.put("right_of", AFTER);
            hashMap = new HashMap();
            sEndMap = hashMap;
            hashMap.put("end", END);
            sEndMap.put("bottom", END);
            sEndMap.put("right", END);
        }

        public static DescriptionConstraint fromString(String str) {
            if (str == null) {
                return BEFORE;
            }
            DescriptionConstraint descriptionConstraint = (DescriptionConstraint) sBeforeMap.get(str);
            if (descriptionConstraint != null) {
                return descriptionConstraint;
            }
            descriptionConstraint = (DescriptionConstraint) sAfterMap.get(str);
            if (descriptionConstraint != null) {
                return descriptionConstraint;
            }
            descriptionConstraint = (DescriptionConstraint) sEndMap.get(str);
            if (descriptionConstraint != null) {
                return descriptionConstraint;
            }
            if (str.equals("exact")) {
                return EXACT;
            }
            if (str.equals("max")) {
                return MAX;
            }
            return BEFORE;
        }

        public static boolean hasElementArgument(DescriptionConstraint descriptionConstraint) {
            return descriptionConstraint == BEFORE || descriptionConstraint == AFTER;
        }

        public static boolean hasDimensionArgument(DescriptionConstraint descriptionConstraint) {
            return descriptionConstraint == EXACT || descriptionConstraint == MAX;
        }
    }

    /* compiled from: place_tips_hide_tap */
    public class DimensionF {
        public float f5416a;
        public float f5417b;

        public DimensionF(float f, float f2) {
            this.f5416a = f;
            this.f5417b = f2;
        }
    }

    /* compiled from: place_tips_hide_tap */
    public enum ElementType {
        NONE("NONE"),
        COVER_IMAGE("coverImage"),
        COVER_VIDEO("coverVideo"),
        HEADLINE("headline"),
        DESCRIPTION("description"),
        BYLINE("byline"),
        BYLINE_AREA("bylineArea"),
        SOURCE_IMAGE("sourceImage"),
        BAR("bar"),
        OVERLAY("overlay");
        
        public final String value;

        private ElementType(String str) {
            this.value = str;
        }

        public static ElementType fromString(String str) {
            if (str == null) {
                return NONE;
            }
            for (ElementType elementType : values()) {
                if (str.equals(elementType.value)) {
                    return elementType;
                }
            }
            return NONE;
        }

        public static boolean isTextElement(ElementType elementType) {
            return elementType == HEADLINE || elementType == DESCRIPTION || elementType == BYLINE;
        }
    }

    /* compiled from: place_tips_hide_tap */
    public enum HorizontalPosition {
        LEFT,
        RIGHT,
        LEFT_FLUSH,
        CENTER,
        LEFT_OF,
        RIGHT_OF,
        CENTER_IN;
        
        private static final Map<String, HorizontalPosition> sTypeMap = null;

        static {
            Map hashMap = new HashMap();
            sTypeMap = hashMap;
            hashMap.put("left", LEFT);
            sTypeMap.put("right", RIGHT);
            sTypeMap.put("left_flush", LEFT_FLUSH);
            sTypeMap.put("left_of", LEFT_OF);
            sTypeMap.put("right_of", RIGHT_OF);
            sTypeMap.put("center", CENTER);
            sTypeMap.put("centered_in", CENTER_IN);
        }

        public static HorizontalPosition fromString(String str) {
            if (str == null) {
                return LEFT;
            }
            HorizontalPosition horizontalPosition = (HorizontalPosition) sTypeMap.get(str);
            return horizontalPosition == null ? LEFT : horizontalPosition;
        }

        public static boolean hasElementArgument(HorizontalPosition horizontalPosition) {
            return horizontalPosition == LEFT_OF || horizontalPosition == RIGHT_OF || horizontalPosition == CENTER_IN;
        }

        public static boolean hasGridArgument(HorizontalPosition horizontalPosition) {
            return false;
        }
    }

    /* compiled from: place_tips_hide_tap */
    public enum MinimorphTextAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* compiled from: place_tips_hide_tap */
    public enum OverlayImageType {
        OVERLAY_NONE("none"),
        OVERLAY_PLAY_BUTTON("playButton");
        
        private final String value;

        private OverlayImageType(String str) {
            this.value = str;
        }

        public static OverlayImageType fromString(String str) {
            if (str == null) {
                return OVERLAY_NONE;
            }
            for (OverlayImageType overlayImageType : values()) {
                if (str.equals(overlayImageType.value)) {
                    return overlayImageType;
                }
            }
            return OVERLAY_NONE;
        }
    }

    /* compiled from: place_tips_hide_tap */
    public enum VerticalPosition {
        TOP,
        BOTTOM,
        TOP_FLUSH,
        BOTTOM_FLUSH,
        ABOVE,
        BELOW,
        BASE_ON_GRID_LINE,
        CENTERED_IN_GRID_LINE,
        CENTERED_IN;
        
        private static final Map<String, VerticalPosition> sTypeMap = null;

        static {
            Map hashMap = new HashMap();
            sTypeMap = hashMap;
            hashMap.put("top", TOP);
            sTypeMap.put("bottom", BOTTOM);
            sTypeMap.put("top_flush", TOP_FLUSH);
            sTypeMap.put("bottom_flush", BOTTOM_FLUSH);
            sTypeMap.put("above", ABOVE);
            sTypeMap.put("below", BELOW);
            sTypeMap.put("base_on_gridline", BASE_ON_GRID_LINE);
            sTypeMap.put("centered_in_gridline", CENTERED_IN_GRID_LINE);
            sTypeMap.put("centered_in", CENTERED_IN);
        }

        public static VerticalPosition fromString(String str) {
            if (str == null) {
                return TOP;
            }
            VerticalPosition verticalPosition = (VerticalPosition) sTypeMap.get(str);
            return verticalPosition == null ? TOP : verticalPosition;
        }

        public static boolean hasElementArgument(VerticalPosition verticalPosition) {
            return verticalPosition == ABOVE || verticalPosition == BELOW || verticalPosition == CENTERED_IN;
        }

        public static boolean hasGridArgument(VerticalPosition verticalPosition) {
            return verticalPosition == BASE_ON_GRID_LINE || verticalPosition == CENTERED_IN_GRID_LINE;
        }
    }
}

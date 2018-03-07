package com.facebook.react.uimanager;

import java.util.Arrays;
import java.util.HashSet;

/* compiled from: foster */
public class ViewProps {
    public static final int[] f11881a = new int[]{8, 0, 2, 1, 3};
    public static final int[] f11882b = new int[]{8, 4, 5, 0, 2, 1, 3};
    private static final HashSet<String> f11883c = new HashSet(Arrays.asList(new String[]{"alignSelf", "alignItems", "bottom", "collapsable", "flex", "flexDirection", "flexWrap", "height", "justifyContent", "left", "position", "right", "top", "width", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom"}));

    public static boolean m14122a(String str) {
        return f11883c.contains(str);
    }
}

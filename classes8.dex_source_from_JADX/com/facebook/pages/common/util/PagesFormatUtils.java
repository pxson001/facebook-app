package com.facebook.pages.common.util;

import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: corrected_query_title */
public class PagesFormatUtils {
    public static String m20186a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!Strings.isNullOrEmpty(str)) {
            stringBuilder.append(str);
            if (!(Strings.isNullOrEmpty(str2) || Strings.isNullOrEmpty(str3))) {
                stringBuilder.append(str2);
            }
        }
        if (!Strings.isNullOrEmpty(str3)) {
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }
}

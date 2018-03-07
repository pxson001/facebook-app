package com.facebook.common.util;

import java.util.List;

/* compiled from: share_page_story */
public class ListUtil {
    public static <T> List<T> m3904a(List<T> list, int i, int i2) {
        return list.subList(Math.max(0, i), Math.min(list.size(), i2));
    }
}

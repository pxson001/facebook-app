package com.facebook.search.util;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: megaphone_visible */
public class TypeaheadTextMatcher {
    public static boolean m10674a(List<String> list, List<String> list2) {
        int size = list2.size();
        List arrayList = new ArrayList(list);
        for (int i = 0; i < size; i++) {
            String str = (String) list2.get(i);
            if (!Strings.isNullOrEmpty(str)) {
                Object obj;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!Strings.isNullOrEmpty(str2)) {
                        if (i != size - 1 || !str2.startsWith(str)) {
                            if (i < size - 1 && str2.equals(str)) {
                                it.remove();
                                int i2 = 1;
                                break;
                            }
                        }
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    return false;
                }
            }
        }
        return true;
    }
}

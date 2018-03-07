package com.facebook.entitycards.collect;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Preconditions;
import java.util.HashSet;

/* compiled from: include_end_credits */
public class OffsetArrayHelper {
    public static void m12846a(OffsetArray offsetArray) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < offsetArray.m12838b(); i++) {
            boolean z;
            Object b = offsetArray.m12839b(i);
            if (hashSet.contains(b)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, StringFormatUtil.a("Duplicate value %s detected in array!", new Object[]{b}));
            hashSet.add(b);
        }
    }
}

package com.facebook.messaging.model.threadkey;

import android.content.Context;
import android.support.v4.util.LongSparseArray;
import android_src.provider.Telephony.Threads;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: upgrade_click */
public class SmsThreadKeyUtil {
    private static final LongSparseArray<Set<String>> f2222a = new LongSparseArray();

    public static long m3485a(Context context, String str) {
        return m3486a(context, ImmutableSet.of(str));
    }

    public static long m3486a(Context context, Set<String> set) {
        long a = Threads.a(context, set);
        synchronized (f2222a) {
            f2222a.b(a, set);
        }
        return a;
    }

    @Nullable
    public static Set<String> m3487a(long j) {
        Set<String> set;
        synchronized (f2222a) {
            set = (Set) f2222a.a(j);
        }
        return set;
    }
}

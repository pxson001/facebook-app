package com.facebook.http.protocol;

import android.util.Pair;
import java.util.Comparator;

/* compiled from: tooltip_nux_max_imp */
final class SingleMethodRunnerImpl$4 implements Comparator<Pair<String, Integer>> {
    SingleMethodRunnerImpl$4() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((String) ((Pair) obj).first).compareToIgnoreCase((String) ((Pair) obj2).first);
    }
}

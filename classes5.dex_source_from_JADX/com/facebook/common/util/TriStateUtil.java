package com.facebook.common.util;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: settingsRowCoverPhoto */
public class TriStateUtil {
    public static Combiner<TriState> f2794a = new C01991();
    public static Combiner<TriState> f2795b = new C02002();

    /* compiled from: settingsRowCoverPhoto */
    final class C01991 implements Combiner<TriState> {
        C01991() {
        }

        public final Object mo578a(Object obj, Object obj2) {
            TriState triState = (TriState) obj;
            TriState triState2 = (TriState) obj2;
            if (triState.isSet() && triState2.isSet()) {
                return (triState.asBoolean() && triState2.asBoolean()) ? TriState.YES : TriState.NO;
            } else {
                if (triState.isSet()) {
                    return triState;
                }
                return triState2;
            }
        }
    }

    /* compiled from: settingsRowCoverPhoto */
    final class C02002 implements Combiner<TriState> {
        C02002() {
        }

        public final Object mo578a(Object obj, Object obj2) {
            TriState triState = (TriState) obj;
            TriState triState2 = (TriState) obj2;
            if (triState.isSet() && triState2.isSet()) {
                return (triState.asBoolean() || triState2.asBoolean()) ? TriState.YES : TriState.NO;
            } else {
                if (triState.isSet()) {
                    return triState;
                }
                return triState2;
            }
        }
    }

    public static TriState m3929a(List<TriState> list, Combiner<TriState> combiner, @Nullable TriState triState) {
        if (list.isEmpty()) {
            return TriState.UNSET;
        }
        Iterator it = list.iterator();
        TriState triState2 = (TriState) it.next();
        while (it.hasNext()) {
            triState2 = (TriState) combiner.mo578a(triState2, it.next());
            if (triState2 == triState) {
                return triState2;
            }
        }
        return triState2;
    }
}

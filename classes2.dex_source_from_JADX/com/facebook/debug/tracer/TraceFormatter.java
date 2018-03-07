package com.facebook.debug.tracer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.TraceEvent.Type;
import java.util.List;

/* compiled from: the Unsafe */
class TraceFormatter {
    private static final Class<?> f3067a = TraceFormatter.class;

    TraceFormatter() {
    }

    static void m5057a(int i, int i2, String str, List<TraceEvent> list, SparseArray<TraceEvent> sparseArray) {
        if (BLog.b(i2)) {
            String a = m5056a(i, (List) list, (SparseArray) sparseArray);
            if (!TextUtils.isEmpty(a)) {
                if (a.length() > 4000) {
                    String[] split = a.split("\n");
                    StringBuilder stringBuilder = new StringBuilder();
                    m5059a(stringBuilder, 0, null, null);
                    int length = stringBuilder.length();
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < split.length) {
                        String str2 = i4 != 0 ? split[i4 - 1] : null;
                        String str3 = split[i4];
                        if (length == 0 || str3.length() + length < 4000) {
                            stringBuilder.append(str3);
                            stringBuilder.append("\n");
                            length += str3.length() + 1;
                            i4++;
                        } else {
                            BLog.a(i2, str, stringBuilder.toString());
                            stringBuilder.setLength(0);
                            i3++;
                            m5059a(stringBuilder, i3, str2, str3);
                            length = stringBuilder.length();
                        }
                    }
                    if (length > 0) {
                        BLog.a(i2, str, stringBuilder.toString());
                        return;
                    }
                    return;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                m5058a(stringBuilder2);
                stringBuilder2.append(a);
                BLog.a(i2, str, stringBuilder2.toString());
            }
        }
    }

    private static String m5056a(int i, List<TraceEvent> list, SparseArray<TraceEvent> sparseArray) {
        StringBuilder stringBuilder = new StringBuilder();
        long a = TracerClock.m909a();
        long j = -1;
        int i2 = 0;
        long j2 = -1;
        int i3 = 0;
        Object obj = null;
        while (i3 < list.size()) {
            long j3;
            Object obj2;
            int i4;
            TraceEvent traceEvent = (TraceEvent) list.get(i3);
            if (traceEvent != null) {
                Object obj3;
                if (obj != null) {
                    obj3 = obj;
                } else if (traceEvent.m1042b() == i) {
                    j = traceEvent.m1046f();
                    obj3 = 1;
                }
                Type c = traceEvent.m1043c();
                if (c != Type.SPAWN) {
                    int i5;
                    if (c != Type.STOP && c != Type.STOP_ASYNC) {
                        i5 = i2;
                    } else if (i2 == 0) {
                        BLog.b(f3067a, "Trace contains a stop event without a corresponding start: " + list);
                        i5 = i2;
                    } else {
                        i5 = i2 - 1;
                    }
                    stringBuilder.append(" ");
                    traceEvent.m1041a(stringBuilder, j, j2, i5);
                    stringBuilder.append(" ");
                    j2 = traceEvent.m1046f();
                    stringBuilder.append("\n");
                    if (c == Type.START || c == Type.START_ASYNC) {
                        j3 = j2;
                        obj2 = obj3;
                        i4 = i5 + 1;
                    } else {
                        j3 = j2;
                        i4 = i5;
                        obj2 = obj3;
                    }
                } else {
                    int i6 = i2;
                    j3 = j2;
                    obj2 = obj3;
                    i4 = i6;
                }
                i3++;
                obj = obj2;
                j2 = j3;
                i2 = i4;
            }
            int i7 = i2;
            j3 = j2;
            obj2 = obj;
            i4 = i7;
            i3++;
            obj = obj2;
            j2 = j3;
            i2 = i4;
        }
        if (sparseArray.size() != 0) {
            stringBuilder.append(" Unstopped timers:\n");
            int size = sparseArray.size();
            for (int i8 = 0; i8 < size; i8++) {
                traceEvent = (TraceEvent) sparseArray.valueAt(i8);
                j2 = traceEvent.m1046f();
                stringBuilder.append("  ");
                stringBuilder.append(traceEvent);
                stringBuilder.append(" (");
                stringBuilder.append((a - j2) / 1000000);
                stringBuilder.append(" ms, started at ");
                stringBuilder.append(TraceEvent.m1038a(j2 / 1000000));
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static void m5058a(StringBuilder stringBuilder) {
        m5059a(stringBuilder, 0, null, null);
    }

    private static void m5059a(StringBuilder stringBuilder, int i, String str, String str2) {
        stringBuilder.append("Thread trace:(").append(i).append(")");
        if (i < 10) {
            stringBuilder.append("    ");
        } else if (i < 100) {
            stringBuilder.append("   ");
        } else if (i < 1000) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("                 ");
        m5060a(stringBuilder, str, str2);
        stringBuilder.append("\n");
        stringBuilder.append(" .                   TOTAL   THREAD  ");
        m5060a(stringBuilder, str, str2);
        stringBuilder.append("\n");
    }

    private static void m5060a(StringBuilder stringBuilder, String str, String str2) {
        if (str != null && str2 != null) {
            int max = Math.max(str.length(), str2.length());
            int i = 0;
            Object obj = null;
            Object obj2 = null;
            while (i < max) {
                char charAt;
                char charAt2;
                if (i < str.length()) {
                    charAt = str.charAt(i);
                } else {
                    charAt = '\u0000';
                }
                if (i < str2.length()) {
                    charAt2 = str2.charAt(i);
                } else {
                    charAt2 = '\u0000';
                }
                if (obj2 == null && charAt == '|') {
                    obj2 = 1;
                } else if (!(obj2 != 1 || Character.isWhitespace(charAt) || charAt == '|')) {
                    int i2 = 2;
                }
                if (obj == null && charAt2 == '|') {
                    obj = 1;
                } else if (!(obj != 1 || Character.isWhitespace(charAt2) || charAt2 == '|')) {
                    int i3 = 2;
                }
                if (obj2 != 2 || obj != 2) {
                    if (obj2 == 1) {
                        stringBuilder.append(charAt);
                    } else if (obj == 1) {
                        stringBuilder.append(charAt2);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}

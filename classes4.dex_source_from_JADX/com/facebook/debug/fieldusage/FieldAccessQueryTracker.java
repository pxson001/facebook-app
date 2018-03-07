package com.facebook.debug.fieldusage;

import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.fieldusage.FieldTrackable.AccessTracker;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/* compiled from: sms_anonymous_chathead_impression_count_today */
public final class FieldAccessQueryTracker {
    private static final ArrayList<String> f2125a = new ArrayList();
    public List<AccessTracker> f2126b = new ArrayList();
    public Stack<String> f2127c = new Stack();
    public final String f2128d;
    public final String f2129e;
    public final long f2130f;
    public final MonotonicClock f2131g;
    public boolean f2132h;

    public static JsonParser m2235a(JsonParser jsonParser, String str) {
        FieldAccessQueryTracker b = FieldAccessQueryContext.b(jsonParser);
        if (!(b == null || str == null)) {
            b.m2238b(str);
        }
        return jsonParser;
    }

    public static void m2236a(JsonParser jsonParser, Object obj, String str, FieldAccessTracker fieldAccessTracker, int i, boolean z) {
        FieldAccessQueryTracker b = FieldAccessQueryContext.b(jsonParser);
        if (b != null) {
            if (z) {
                if (!b.f2127c.isEmpty()) {
                    String str2 = (String) b.f2127c.pop();
                }
            }
            FieldAccessTracker a = FieldAccessQueryContext.a(obj, fieldAccessTracker, b);
            if (a != null) {
                int binarySearch = Collections.binarySearch(f2125a, str);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                    f2125a.add(binarySearch, str);
                }
                String str3 = (String) f2125a.get(binarySearch);
                if (i < 0 || i >= a.g) {
                    BLog.a("FieldUsageReporter", "Out of range index: %s %d", new Object[]{str3, Integer.valueOf(i)});
                } else {
                    a.f[i] = str3;
                }
                a.a(i >> 3, i & 7);
            }
        }
    }

    public FieldAccessQueryTracker(String str, String str2, MonotonicClock monotonicClock, boolean z) {
        this.f2128d = str;
        this.f2129e = str2;
        this.f2130f = monotonicClock.now();
        this.f2131g = monotonicClock;
        this.f2132h = z;
    }

    public final void m2237a(String str) {
        this.f2132h = true;
        this.f2126b.clear();
        this.f2127c.clear();
        if (str != null) {
            this.f2127c.push(str);
        }
    }

    public final void m2238b(String str) {
        if (this.f2127c.isEmpty() || !((String) this.f2127c.peek()).equals(str)) {
            this.f2127c.push(str);
        }
    }

    public final long m2239c() {
        return this.f2131g.now() - this.f2130f;
    }
}

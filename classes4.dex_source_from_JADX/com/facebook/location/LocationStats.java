package com.facebook.location;

import com.facebook.location.FbLocationManagerParams.Priority;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* compiled from: is_pending_download */
public class LocationStats {
    public static final LocationStats f9930a = new LocationStats();
    private final HashMap<String, LocationTime> f9931b = new HashMap();

    /* compiled from: is_pending_download */
    public class LocationTime {
        private long f9932a = 0;
        private long f9933b = 0;
        private long f9934c = 0;

        LocationTime() {
        }

        final void m10319a(long j) {
            this.f9932a += j;
        }

        final void m10321b(long j) {
            this.f9933b += j;
        }

        final void m10323c(long j) {
            this.f9934c += j;
        }

        public final long m10318a() {
            return this.f9932a;
        }

        public final long m10320b() {
            return this.f9933b;
        }

        public final long m10322c() {
            return this.f9934c;
        }
    }

    /* compiled from: is_pending_download */
    /* synthetic */ class C04511 {
        static final /* synthetic */ int[] f9935a = new int[Priority.values().length];

        static {
            try {
                f9935a[Priority.HIGH_ACCURACY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9935a[Priority.BALANCED_POWER_AND_ACCURACY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9935a[Priority.LOW_POWER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private LocationStats() {
    }

    public final synchronized void m10316a(String str, Priority priority, long j) {
        if (((LocationTime) this.f9931b.get(str)) == null) {
            this.f9931b.put(str, new LocationTime());
        }
        switch (C04511.f9935a[priority.ordinal()]) {
            case 1:
                ((LocationTime) this.f9931b.get(str)).m10323c(j);
                break;
            case 2:
                ((LocationTime) this.f9931b.get(str)).m10321b(j);
                break;
            case 3:
                ((LocationTime) this.f9931b.get(str)).m10319a(j);
                break;
        }
    }

    @VisibleForTesting
    public final synchronized Map<String, LocationTime> m10317b() {
        HashMap hashMap;
        hashMap = (HashMap) this.f9931b.clone();
        this.f9931b.clear();
        return hashMap;
    }
}

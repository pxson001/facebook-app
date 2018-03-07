package com.facebook.prefetch.feed.scheduler;

import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: no-cache */
public class NewsFeedPrefetchPrediction {
    private static final String f7093a = NewsFeedPrefetchPrediction.class.getSimpleName();
    private static final Integer[] f7094b = new Integer[]{Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(14), Integer.valueOf(19), Integer.valueOf(24), Integer.valueOf(33), Integer.valueOf(38), Integer.valueOf(43), Integer.valueOf(48), Integer.valueOf(57), Integer.valueOf(62), Integer.valueOf(67), Integer.valueOf(72), Integer.valueOf(81), Integer.valueOf(86), Integer.valueOf(91), Integer.valueOf(96), Integer.valueOf(105), Integer.valueOf(110), Integer.valueOf(115), Integer.valueOf(120), Integer.valueOf(129), Integer.valueOf(134), Integer.valueOf(139), Integer.valueOf(144), Integer.valueOf(153), Integer.valueOf(158), Integer.valueOf(163)};
    private static JSONObject f7095c = null;
    private Boolean f7096d = Boolean.valueOf(false);
    private ArrayList<Long> f7097e = null;
    private ArrayList<Long> f7098f = null;
    private Provider<GregorianCalendar> f7099g;
    private final Random f7100h;
    private final AsyncFeedXConfigReader f7101i;

    public static NewsFeedPrefetchPrediction m7422b(InjectorLike injectorLike) {
        return new NewsFeedPrefetchPrediction(IdBasedProvider.a(injectorLike, 4482), Random_InsecureRandomMethodAutoProvider.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike));
    }

    public static NewsFeedPrefetchPrediction m7419a(InjectorLike injectorLike) {
        return m7422b(injectorLike);
    }

    @Inject
    public NewsFeedPrefetchPrediction(Provider<GregorianCalendar> provider, Random random, AsyncFeedXConfigReader asyncFeedXConfigReader) {
        this.f7099g = provider;
        this.f7100h = random;
        this.f7101i = asyncFeedXConfigReader;
    }

    public static JSONObject m7420a() {
        if (f7095c == null) {
            try {
                f7095c = new JSONObject();
                JSONArray jSONArray = new JSONArray(Arrays.asList(f7094b));
                f7095c.put("localTZ", true);
                f7095c.put("hours", jSONArray);
            } catch (Throwable e) {
                BLog.b(f7093a, "JSONException in getDefaultSchedule.", e);
            }
        }
        return f7095c;
    }

    public final void m7427a(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            try {
                this.f7096d = Boolean.valueOf(jSONObject.getBoolean("localTZ"));
            } catch (JSONException e) {
                this.f7096d = Boolean.valueOf(false);
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("hours");
                this.f7097e = new ArrayList(jSONArray.length());
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f7097e.add(Long.valueOf(jSONArray.getLong(i2)));
                }
            } catch (JSONException e2) {
                this.f7097e = null;
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("numStories");
                this.f7098f = new ArrayList(jSONArray2.length());
                while (i < jSONArray2.length()) {
                    this.f7098f.add(Long.valueOf(jSONArray2.getLong(i)));
                    i++;
                }
            } catch (JSONException e3) {
                this.f7098f = null;
            }
        }
    }

    public final long m7428b() {
        GregorianCalendar e = m7426e();
        if (e == null || this.f7097e == null) {
            return 0;
        }
        long longValue;
        try {
            longValue = (((Long) this.f7097e.get(m7418a(e))).longValue() * 60) - m7424d(e);
            if (longValue < 0) {
                longValue += 10080;
            }
        } catch (Throwable e2) {
            BLog.b(f7093a, "IndexOutOfBoundsException in getNextDelayMins.", e2);
            longValue = 0;
        }
        return ((long) (this.f7100h.nextInt(21) - 10)) + longValue;
    }

    public final long m7429c() {
        m7427a(this.f7101i.a(m7420a()));
        if (this.f7098f == null || this.f7098f.isEmpty()) {
            return 0;
        }
        try {
            return ((Long) this.f7098f.get(m7421b(m7426e()))).longValue();
        } catch (Throwable e) {
            BLog.b(f7093a, "IndexOutOfBoundsException in getCurrentNumStories.", e);
            return 0;
        }
    }

    @VisibleForTesting
    private boolean m7425d() {
        return this.f7096d.booleanValue();
    }

    private GregorianCalendar m7426e() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) this.f7099g.get();
        if (gregorianCalendar != null) {
            gregorianCalendar.setFirstDayOfWeek(1);
            if (!m7425d()) {
                gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            }
        }
        return gregorianCalendar;
    }

    private int m7418a(GregorianCalendar gregorianCalendar) {
        if (gregorianCalendar == null || this.f7097e == null) {
            return 0;
        }
        long c = m7423c(gregorianCalendar);
        int i = 0;
        while (i < this.f7097e.size()) {
            try {
                if (((Long) this.f7097e.get(i)).longValue() > c) {
                    return i;
                }
                i++;
            } catch (Throwable e) {
                BLog.b(f7093a, "IndexOutOfBoundsException in getNextNumStories.", e);
                return 0;
            }
        }
        return 0;
    }

    private int m7421b(GregorianCalendar gregorianCalendar) {
        if (gregorianCalendar == null || this.f7097e == null) {
            return 0;
        }
        long c = m7423c(gregorianCalendar);
        int i = 0;
        int i2 = 0;
        while (i < this.f7097e.size() && ((Long) this.f7097e.get(i)).longValue() <= c) {
            try {
                i2 = i;
                i++;
            } catch (Throwable e) {
                BLog.b(f7093a, "IndexOutOfBoundsException in getNextNumStories.", e);
                return i2;
            }
        }
        return m7417a(i2, gregorianCalendar);
    }

    private int m7417a(int i, GregorianCalendar gregorianCalendar) {
        long j = Long.MAX_VALUE;
        if (i < 0 || i >= this.f7097e.size()) {
            return i;
        }
        long d = m7424d(gregorianCalendar);
        long abs = Math.abs((((Long) this.f7097e.get(i)).longValue() * 60) - d);
        long abs2 = i + -1 >= 0 ? Math.abs((((Long) this.f7097e.get(i - 1)).longValue() * 60) - d) : Long.MAX_VALUE;
        if (i + 1 < this.f7097e.size()) {
            j = Math.abs((((Long) this.f7097e.get(i + 1)).longValue() * 60) - d);
        }
        long min = Math.min(Math.min(abs, abs2), j);
        if (min == abs2) {
            return i - 1;
        }
        if (min == j) {
            return i + 1;
        }
        return i;
    }

    private static long m7423c(GregorianCalendar gregorianCalendar) {
        if (gregorianCalendar == null) {
            return 0;
        }
        return (((long) (gregorianCalendar.get(7) - 1)) * 24) + ((long) gregorianCalendar.get(11));
    }

    private static long m7424d(GregorianCalendar gregorianCalendar) {
        if (gregorianCalendar == null) {
            return 0;
        }
        return (m7423c(gregorianCalendar) * 60) + ((long) gregorianCalendar.get(12));
    }
}

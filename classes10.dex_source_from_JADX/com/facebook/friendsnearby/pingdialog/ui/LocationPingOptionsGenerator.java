package com.facebook.friendsnearby.pingdialog.ui;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.friendsnearby.pingdialog.LocationPingTime;
import com.facebook.friendsnearby.pingdialog.LocationPingTime.Type;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: [TV; */
public class LocationPingOptionsGenerator {
    private final Clock f20667a;
    private final TimeFormatUtil f20668b;
    private final Resources f20669c;

    public static LocationPingOptionsGenerator m21154b(InjectorLike injectorLike) {
        return new LocationPingOptionsGenerator((Clock) SystemClockMethodAutoProvider.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LocationPingOptionsGenerator(Clock clock, TimeFormatUtil timeFormatUtil, Resources resources) {
        this.f20667a = clock;
        this.f20668b = timeFormatUtil;
        this.f20669c = resources;
    }

    public final ImmutableList<LocationPingOption> m21158a(Optional<LocationPingTime> optional, String str) {
        ArrayList a = Lists.a();
        long a2 = this.f20667a.a();
        LocationPingOption a3 = m21146a(a2, str);
        if (!m21151a((Optional) optional, a3, 1800000)) {
            a.add(a3);
        }
        a3 = m21152b(a2, str);
        if (!m21151a((Optional) optional, a3, 1800000)) {
            a.add(a3);
        }
        LocationPingOption c = m21156c(a2, str);
        long longValue = ((Long) c.f20657a.f20626b.get()).longValue();
        if (longValue - a2 > 14400000 && !m21151a((Optional) optional, c, 3600000)) {
            a.add(c);
        }
        a3 = m21157d(a2, str);
        if (longValue - a2 < 72000000 && !m21151a((Optional) optional, a3, 14400000)) {
            a.add(a3);
        }
        if (!(optional.isPresent() && ((LocationPingTime) optional.get()).f20625a == Type.FOREVER)) {
            a.add(m21147a(LocationPingTime.m21042b(), str, "forever"));
        }
        if (!optional.isPresent()) {
            return ImmutableList.copyOf(a);
        }
        Builder builder = ImmutableList.builder();
        int size = a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            a3 = (LocationPingOption) a.get(i);
            if (obj == null && m21150a(a3, (LocationPingTime) optional.get())) {
                builder.c(m21153b((LocationPingTime) optional.get(), str, "existing"));
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            builder.c(a3);
            i++;
            obj = obj2;
        }
        if (obj == null) {
            builder.c(m21153b((LocationPingTime) optional.get(), str, "existing"));
        }
        return builder.b();
    }

    private LocationPingOption m21146a(long j, String str) {
        return m21147a(LocationPingTime.m21039a(m21145a(j, 10, 1)), str, "one_hour");
    }

    private LocationPingOption m21152b(long j, String str) {
        return m21147a(LocationPingTime.m21039a(m21145a(j, 10, 3)), str, "three_hours");
    }

    private LocationPingOption m21156c(long j, String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 8);
        instance.set(12, 0);
        if (instance.getTimeInMillis() < j) {
            instance.add(5, 1);
        }
        return m21147a(LocationPingTime.m21039a(instance.getTimeInMillis()), str, "next_eight_am");
    }

    private LocationPingOption m21157d(long j, String str) {
        return m21147a(LocationPingTime.m21039a(m21145a(j, 5, 1)), str, "one_day");
    }

    private static long m21145a(long j, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (instance.get(12) >= 30) {
            instance.add(11, 1);
        }
        instance.set(12, 0);
        instance.add(i, i2);
        return instance.getTimeInMillis();
    }

    private boolean m21151a(Optional<LocationPingTime> optional, LocationPingOption locationPingOption, long j) {
        if (optional.isPresent() && ((LocationPingTime) optional.get()).f20626b.isPresent()) {
            return m21149a(((Long) ((LocationPingTime) optional.get()).f20626b.get()).longValue(), ((Long) locationPingOption.f20657a.f20626b.get()).longValue(), j);
        }
        return false;
    }

    private boolean m21149a(long j, long j2, long j3) {
        Preconditions.checkArgument(j != -1);
        return m21155b(j, j2 - j3, j2 + j3);
    }

    private static boolean m21155b(long j, long j2, long j3) {
        boolean z;
        if (j2 <= j3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return j >= j2 && j <= j3;
    }

    private LocationPingOption m21147a(LocationPingTime locationPingTime, String str, String str2) {
        return new LocationPingOption(locationPingTime, this.f20669c.getString(2131242040, new Object[]{str}), m21148a(locationPingTime), str2);
    }

    private LocationPingOption m21153b(LocationPingTime locationPingTime, String str, String str2) {
        return new LocationPingOption(locationPingTime, this.f20669c.getString(2131242039, new Object[]{str}), m21148a(locationPingTime), str2);
    }

    private String m21148a(LocationPingTime locationPingTime) {
        switch (locationPingTime.f20625a) {
            case DURATION:
                return this.f20668b.a(TimeFormatStyle.EXACT_TIME_DATE_STYLE, ((Long) locationPingTime.f20626b.get()).longValue());
            case FOREVER:
                return this.f20669c.getString(2131242042);
            default:
                throw new IllegalArgumentException("Invalid ping type: " + locationPingTime.f20625a);
        }
    }

    private static boolean m21150a(LocationPingOption locationPingOption, LocationPingTime locationPingTime) {
        if (locationPingTime.f20625a == Type.FOREVER) {
            return false;
        }
        if (locationPingOption.f20657a.f20625a == Type.FOREVER) {
            return true;
        }
        return ((Long) locationPingOption.f20657a.f20626b.get()).longValue() > ((Long) locationPingTime.f20626b.get()).longValue();
    }
}

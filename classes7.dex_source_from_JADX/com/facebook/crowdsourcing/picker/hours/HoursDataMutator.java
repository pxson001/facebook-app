package com.facebook.crowdsourcing.picker.hours;

import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.crowdsourcing.helper.HoursData.HoursForSingleDay;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.mp4.FragmentedMp4Extractor */
public class HoursDataMutator {
    public final HoursDataHelper f17460a;

    @Inject
    public HoursDataMutator(HoursDataHelper hoursDataHelper) {
        this.f17460a = hoursDataHelper;
    }

    public final void m21368a(HoursData hoursData, int i) {
        int size = hoursData.m21322a(i).f17418a.size();
        hoursData.m21323a(i, m21364a(hoursData.m21322a(i), m21365c(hoursData, i, size), m21366d(hoursData, i, size)));
    }

    public static HoursForSingleDay m21363a(HoursForSingleDay hoursForSingleDay, int i, long j, long j2) {
        Builder builder = ImmutableList.builder();
        for (int i2 = 0; i2 < hoursForSingleDay.f17418a.size(); i2++) {
            if (i2 == i) {
                builder.c(new HoursInterval(j, j2));
            } else {
                builder.c(hoursForSingleDay.f17418a.get(i2));
            }
        }
        return new HoursForSingleDay(builder.b());
    }

    public static HoursForSingleDay m21364a(HoursForSingleDay hoursForSingleDay, long j, long j2) {
        Builder builder = ImmutableList.builder();
        builder.b(hoursForSingleDay.f17418a);
        builder.c(new HoursInterval(j, j2));
        return new HoursForSingleDay(builder.b());
    }

    private long m21365c(HoursData hoursData, int i, int i2) {
        return m21367e(hoursData, i, i2) ? ((HoursInterval) hoursData.m21322a(i).f17418a.get(i2 - 1)).f17421b + 3600 : this.f17460a.m21328a(i, 9, 0);
    }

    private long m21366d(HoursData hoursData, int i, int i2) {
        return m21367e(hoursData, i, i2) ? m21365c(hoursData, i, i2) + 3600 : this.f17460a.m21328a(i, 17, 0);
    }

    private static boolean m21367e(HoursData hoursData, int i, int i2) {
        return i2 > 0 && i2 - 1 < hoursData.m21322a(i).f17418a.size();
    }
}

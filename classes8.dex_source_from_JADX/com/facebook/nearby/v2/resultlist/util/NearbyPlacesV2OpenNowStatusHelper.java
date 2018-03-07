package com.facebook.nearby.v2.resultlist.util;

import com.facebook.common.util.StringUtil;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPagePlaceInfoFragment.Hours;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.HoursModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.HoursModel.Builder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* compiled from: date_modified */
public class NearbyPlacesV2OpenNowStatusHelper {
    public static final boolean m18718a(ImmutableList<Hours> immutableList, String str) {
        long a = m18714a(new Date().getTime());
        for (HoursModel hoursModel : m18721b((ImmutableList) immutableList, str)) {
            if (hoursModel != null && m18717a(a, hoursModel.m17848b(), hoursModel.m17845a())) {
                return true;
            }
        }
        return false;
    }

    private static long m18714a(long j) {
        return j / 1000;
    }

    private static final boolean m18717a(long j, long j2, long j3) {
        long b = m18719b(j);
        long b2 = m18719b(j2);
        long b3 = m18720b(b2, m18719b(j3));
        if (m18722c(b) && m18716a(b2, b3)) {
            b += 604800;
        }
        return b2 <= b && b <= b3;
    }

    private static final List<Hours> m18721b(ImmutableList<Hours> immutableList, String str) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        TimeZone timeZone = StringUtil.a(str) ? TimeZone.getDefault() : TimeZone.getTimeZone(str);
        List<Hours> arrayList = new ArrayList(immutableList.size());
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            HoursModel hoursModel = (HoursModel) immutableList.get(i);
            long a = m18715a(hoursModel.m17848b(), timeZone);
            long a2 = m18715a(hoursModel.m17845a(), timeZone);
            builder.f15339b = a;
            Builder builder2 = builder;
            builder2.f15338a = a2;
            arrayList.add(builder2.m17840a());
        }
        return arrayList;
    }

    private static final long m18715a(long j, TimeZone timeZone) {
        long offset;
        if (timeZone != null) {
            offset = (long) timeZone.getOffset(new Date().getTime());
        } else {
            offset = 0;
        }
        return m18714a(((long) TimeZone.getTimeZone("US/Pacific").getOffset(0)) - offset) + j;
    }

    private static final long m18719b(long j) {
        if (j >= 0 && j < 604800) {
            return j;
        }
        long j2;
        if (j < 0) {
            j2 = ((j % 604800) + 604800) % 604800;
        } else {
            j2 = j % 604800;
        }
        return j2;
    }

    private static final boolean m18716a(long j, long j2) {
        boolean z;
        long b = m18719b(j);
        long b2 = m18719b(j2);
        if (518400 > b || b > 604799) {
            z = false;
        } else {
            z = true;
        }
        boolean c = m18722c(b2);
        if (z && c) {
            return true;
        }
        return false;
    }

    private static final boolean m18722c(long j) {
        return 0 <= j && j <= 86399;
    }

    private static final long m18720b(long j, long j2) {
        if (j2 >= j) {
            return j2;
        }
        if (m18716a(j, j2)) {
            return j2 + 604800;
        }
        return j2 + 86400;
    }
}

package com.facebook.crowdsourcing.helper;

import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.crowdsourcing.helper.HoursData.HoursForSingleDay;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.FriModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.MonModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.SatModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.SunModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.ThuModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.TueModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedHoursModel.WedModel;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: com.facebook.photos.mediagallery.ui.MediaGalleryActivity */
public class HoursDataHelper {
    public static final TimeZone f17424a = TimeZone.getTimeZone("GMT-8");
    private final Locale f17425b;
    private final TimeFormatUtil f17426c;

    public static HoursDataHelper m21326b(InjectorLike injectorLike) {
        return new HoursDataHelper(LocaleMethodAutoProvider.b(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public HoursDataHelper(Locale locale, TimeFormatUtil timeFormatUtil) {
        this.f17425b = locale;
        this.f17426c = timeFormatUtil;
    }

    public final String m21329a(long j) {
        return this.f17426c.a(TimeFormatStyle.HOUR_MINUTE_STYLE, (1000 * j) + ((long) (f17424a.getOffset(0) - TimeZone.getDefault().getOffset(0))));
    }

    public final int m21330b(long j) {
        return m21327d(j).get(11);
    }

    public final int m21331c(long j) {
        return m21327d(j).get(12);
    }

    public final long m21328a(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance(f17424a, this.f17425b);
        instance.set(1970, 0, i >= 5 ? i - 4 : i + 3, i2, i3, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis() / 1000;
    }

    public static HoursForSingleDay m21324a(int i, CrowdsourcedHours crowdsourcedHours) {
        Builder builder = ImmutableList.builder();
        ImmutableList k;
        int size;
        int i2;
        switch (i) {
            case 1:
                if (crowdsourcedHours.mo102k() != null) {
                    k = crowdsourcedHours.mo102k();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        SunModel sunModel = (SunModel) k.get(i2);
                        m21325a(builder, sunModel.m2648b(), sunModel.m2645a());
                    }
                    break;
                }
                break;
            case 2:
                if (crowdsourcedHours.et_() != null) {
                    k = crowdsourcedHours.et_();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        MonModel monModel = (MonModel) k.get(i2);
                        m21325a(builder, monModel.m2625b(), monModel.m2622a());
                    }
                    break;
                }
                break;
            case 3:
                if (crowdsourcedHours.mo104n() != null) {
                    k = crowdsourcedHours.mo104n();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        TueModel tueModel = (TueModel) k.get(i2);
                        m21325a(builder, tueModel.m2670b(), tueModel.m2667a());
                    }
                    break;
                }
                break;
            case 4:
                if (crowdsourcedHours.mo105o() != null) {
                    k = crowdsourcedHours.mo105o();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        WedModel wedModel = (WedModel) k.get(i2);
                        m21325a(builder, wedModel.m2681b(), wedModel.m2678a());
                    }
                    break;
                }
                break;
            case 5:
                if (crowdsourcedHours.mo103m() != null) {
                    k = crowdsourcedHours.mo103m();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        ThuModel thuModel = (ThuModel) k.get(i2);
                        m21325a(builder, thuModel.m2659b(), thuModel.m2656a());
                    }
                    break;
                }
                break;
            case 6:
                if (crowdsourcedHours.mo99d() != null) {
                    k = crowdsourcedHours.mo99d();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        FriModel friModel = (FriModel) k.get(i2);
                        m21325a(builder, friModel.m2614b(), friModel.m2611a());
                    }
                    break;
                }
                break;
            case 7:
                if (crowdsourcedHours.eu_() != null) {
                    k = crowdsourcedHours.eu_();
                    size = k.size();
                    for (i2 = 0; i2 < size; i2++) {
                        SatModel satModel = (SatModel) k.get(i2);
                        m21325a(builder, satModel.m2636b(), satModel.m2633a());
                    }
                    break;
                }
                break;
        }
        return new HoursForSingleDay(builder.b());
    }

    private static void m21325a(Builder<HoursInterval> builder, long j, long j2) {
        if (j > 0 && j2 > 0) {
            builder.c(new HoursInterval(j, j2));
        }
    }

    private Calendar m21327d(long j) {
        Calendar instance = Calendar.getInstance(f17424a, this.f17425b);
        instance.setTimeInMillis(1000 * j);
        return instance;
    }
}

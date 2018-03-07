package com.facebook.pages.hours;

import android.content.res.Resources;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultTimeRangeFieldsModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.LocationModel;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: task_key_create_link_menu */
public class PageHoursRenderer {
    private static final TimeZone f1739a = TimeZone.getTimeZone("GMT-8");
    private final SimpleDateFormat f1740b = new SimpleDateFormat("h:mma");
    private DateFormatSymbols f1741c = new DateFormatSymbols(Locale.getDefault());

    public PageHoursRenderer() {
        this.f1740b.setCalendar(Calendar.getInstance(f1739a, Locale.getDefault()));
    }

    private String m1917a(long j) {
        return this.f1740b.format(new Date(1000 * j)).toLowerCase(Locale.getDefault());
    }

    public final ArrayList<PageDayHours> m1919a(PageHours pageHours, Resources resources) {
        boolean z = true;
        ArrayList<PageDayHours> arrayList = new ArrayList();
        int i = Calendar.getInstance().get(7);
        int i2 = 2;
        PageDayHourRanges pageDayHourRanges = null;
        int i3 = 2;
        int i4 = 2;
        while (i2 < 9) {
            int i5;
            int i6 = ((i2 - 1) % 7) + 1;
            PageDayHourRanges a = m1915a(pageHours, i6, resources);
            if (pageDayHourRanges == null || a.m1906a().equals(pageDayHourRanges.m1906a())) {
                i5 = i6;
                i6 = i4;
            } else {
                boolean z2;
                if (i4 > i || i3 < i) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                arrayList.add(new PageDayHours(m1916a(i4, i3, resources), pageDayHourRanges, z2));
                i5 = i6;
            }
            i2++;
            pageDayHourRanges = a;
            i3 = i5;
            i4 = i6;
        }
        if (i4 > i || i3 < i) {
            z = false;
        }
        arrayList.add(new PageDayHours(m1916a(i4, i3, resources), pageDayHourRanges, z));
        return arrayList;
    }

    private String m1916a(int i, int i2, Resources resources) {
        if (i == i2) {
            return this.f1741c.getWeekdays()[i];
        }
        return resources.getString(2131239248, new Object[]{this.f1741c.getShortWeekdays()[i], this.f1741c.getShortWeekdays()[i2]});
    }

    private PageDayHourRanges m1915a(PageHours pageHours, int i, Resources resources) {
        List<DefaultTimeRangeFieldsModel> a = pageHours.m1914a(i);
        String[] strArr = new String[a.size()];
        String str = null;
        int i2 = 0;
        for (DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel : a) {
            String substring;
            String a2 = m1917a(defaultTimeRangeFieldsModel.b());
            String a3 = m1917a(defaultTimeRangeFieldsModel.a());
            String string = resources.getString(2131239249, new Object[]{a2, a3});
            if (str == null) {
                int indexOf = string.indexOf(a2);
                if (indexOf != -1) {
                    int indexOf2 = string.indexOf(a3);
                    if (indexOf2 != -1) {
                        int length = a2.length();
                        if (indexOf > indexOf2) {
                            length = a3.length();
                        } else {
                            int i3 = indexOf2;
                            indexOf2 = indexOf;
                            indexOf = i3;
                        }
                        if (indexOf2 + length <= indexOf) {
                            substring = string.substring(length + indexOf2, indexOf);
                            strArr[i2] = string;
                            i2++;
                            str = substring;
                        }
                    }
                }
            }
            substring = str;
            strArr[i2] = string;
            i2++;
            str = substring;
        }
        return new PageDayHourRanges(strArr, str);
    }

    public static TimeZone m1918a(LocationModel locationModel) {
        if (locationModel.j() == null) {
            return null;
        }
        TimeZone timeZone = TimeZone.getTimeZone(locationModel.j());
        if (timeZone.getID().equals(locationModel.j())) {
            return timeZone;
        }
        return null;
    }
}

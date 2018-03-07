package com.facebook.pages.hours;

import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultTimeRangeFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultTimeRangeFieldsModel;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* compiled from: task_key_fetch_structured_menu */
public class PageHours {
    public static final Class<?> f1735a = PageHours.class;
    private final List<? extends DefaultTimeRangeFields> f1736b;
    public final TimeZone f1737c;
    public final Clock f1738d;

    /* compiled from: task_key_fetch_structured_menu */
    public class C01781 implements Comparator<DefaultTimeRangeFields> {
        final /* synthetic */ PageHours f1734a;

        public C01781(PageHours pageHours) {
            this.f1734a = pageHours;
        }

        public int compare(Object obj, Object obj2) {
            DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel = (DefaultTimeRangeFieldsModel) obj;
            DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel2 = (DefaultTimeRangeFieldsModel) obj2;
            if (defaultTimeRangeFieldsModel.b() == defaultTimeRangeFieldsModel2.b()) {
                if (defaultTimeRangeFieldsModel.a() > defaultTimeRangeFieldsModel2.a()) {
                    return 1;
                }
                return -1;
            } else if (defaultTimeRangeFieldsModel.b() <= defaultTimeRangeFieldsModel2.b()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    /* compiled from: task_key_fetch_structured_menu */
    public enum Status {
        OPEN,
        CLOSED,
        UNKNOWN
    }

    public PageHours(List<? extends DefaultTimeRangeFields> list, TimeZone timeZone, Clock clock) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() > 0);
        List<DefaultTimeRangeFieldsModel> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C01781(this));
        long j = -1;
        for (DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel : arrayList) {
            if (defaultTimeRangeFieldsModel.b() <= j || defaultTimeRangeFieldsModel.a() <= defaultTimeRangeFieldsModel.b()) {
                BLog.b(f1735a, "Got invalid hours struct! (" + defaultTimeRangeFieldsModel.b() + ", " + defaultTimeRangeFieldsModel.a() + ")");
            }
            j = defaultTimeRangeFieldsModel.a();
        }
        this.f1736b = arrayList;
        this.f1737c = (TimeZone) Preconditions.checkNotNull(timeZone);
        this.f1738d = (Clock) Preconditions.checkNotNull(clock);
    }

    public final Status m1913a() {
        long a = this.f1738d.a() / 1000;
        return m1910a(((((long) (this.f1737c.getOffset(1000 * a) / 1000)) + a) % 604800) + 28800);
    }

    public final List<? extends DefaultTimeRangeFields> m1914a(int i) {
        int i2 = ((((i - 5) + 7) % 7) * 86400) + 28800;
        List<? extends DefaultTimeRangeFields> arrayList = new ArrayList();
        for (DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel : this.f1736b) {
            Object obj;
            if ((((long) i2) - 28800) / 86400 == (defaultTimeRangeFieldsModel.b() - 28800) / 86400) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(defaultTimeRangeFieldsModel);
            }
        }
        return arrayList;
    }

    private Status m1910a(long j) {
        DefaultTimeRangeFieldsModel b = m1912b(j);
        if (b == null) {
            return Status.UNKNOWN;
        }
        if (m1911a(b.b(), b.a(), j)) {
            return Status.OPEN;
        }
        return Status.CLOSED;
    }

    @Nullable
    private DefaultTimeRangeFieldsModel m1912b(long j) {
        long a = ((DefaultTimeRangeFieldsModel) this.f1736b.get(this.f1736b.size() - 1)).a() + 1;
        for (DefaultTimeRangeFieldsModel defaultTimeRangeFieldsModel : this.f1736b) {
            if (m1911a(a, defaultTimeRangeFieldsModel.a(), j)) {
                return defaultTimeRangeFieldsModel;
            }
            a = defaultTimeRangeFieldsModel.a() + 1;
        }
        BLog.b(f1735a, "Timestamp didn't belong to any timerange!  This shouldn't be possible!");
        return null;
    }

    private static boolean m1911a(long j, long j2, long j3) {
        if (j < j2) {
            if (j3 < j || j3 > j2) {
                return false;
            }
            return true;
        } else if (j3 >= j || j3 <= j2) {
            return true;
        } else {
            return false;
        }
    }
}

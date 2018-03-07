package com.facebook.uicontrib.datepicker;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.text.NumberFormat;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: screenshot_url_list */
public class DatesAdapter extends ArrayAdapter<String> {
    public static List<String> f5261a;
    public int f5262b;
    public Integer f5263c;
    public Period f5264d;

    public DatesAdapter(Context context, int i, int i2, Integer num, Period period) {
        super(context, i);
        f5261a = Lists.a();
        NumberFormat instance = NumberFormat.getInstance(context.getResources().getConfiguration().locale);
        for (int i3 = 1; i3 <= 31; i3++) {
            f5261a.add(instance.format((long) i3));
        }
        this.f5262b = i2;
        this.f5263c = num;
        this.f5264d = period;
        m7960a(m7961b());
    }

    public final int m7966a(Integer num) {
        return getPosition(f5261a.get(num.intValue() - 1));
    }

    public final boolean m7968b(@Nullable Integer num) {
        if (num == null) {
            return true;
        }
        if (this.f5262b == 0 || this.f5263c == null) {
            return false;
        }
        if (m7962c() || m7963d()) {
            return false;
        }
        if (num.intValue() > m7959a(this.f5262b, this.f5263c.intValue())) {
            return false;
        }
        if (m7964e() && num.intValue() < this.f5264d.m7977e().intValue()) {
            return false;
        }
        if (!m7965f() || num.intValue() <= this.f5264d.m7978f().intValue()) {
            return true;
        }
        return false;
    }

    public final void m7967a() {
        clear();
        m7960a(m7961b());
        AdapterDetour.a(this, -917362612);
    }

    private List<String> m7961b() {
        if (this.f5262b == 0 || this.f5263c == null) {
            return Lists.a();
        }
        List a = Lists.a(f5261a);
        if (m7962c() || m7963d()) {
            return Lists.a();
        }
        List<String> subList = a.subList(0, m7959a(this.f5262b, this.f5263c.intValue()));
        if (m7965f()) {
            subList = subList.subList(0, this.f5264d.m7978f().intValue());
        }
        if (m7964e()) {
            return subList.subList(this.f5264d.m7977e().intValue() - 1, subList.size());
        }
        return subList;
    }

    private boolean m7962c() {
        return this.f5262b < this.f5264d.m7973a() || (this.f5262b == this.f5264d.m7973a() && this.f5263c.intValue() < this.f5264d.m7975c().intValue());
    }

    private boolean m7963d() {
        return this.f5262b > this.f5264d.m7974b() || (this.f5262b == this.f5264d.m7974b() && this.f5263c.intValue() > this.f5264d.m7976d().intValue());
    }

    private boolean m7964e() {
        return this.f5262b == this.f5264d.m7973a() && this.f5264d.m7975c().equals(this.f5263c);
    }

    private boolean m7965f() {
        return this.f5262b == this.f5264d.m7974b() && this.f5264d.m7976d().equals(this.f5263c);
    }

    private static int m7959a(int i, int i2) {
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return new GregorianCalendar().isLeapYear(i) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                throw new IllegalArgumentException("Not a valid month: " + i2);
        }
    }

    private void m7960a(List<String> list) {
        for (String add : list) {
            add(add);
        }
    }
}

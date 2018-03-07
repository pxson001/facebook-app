package com.facebook.uicontrib.datepicker;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.text.DateFormatSymbols;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: screenshot_current_position */
public class MonthsAdapter extends ArrayAdapter<String> {
    public static List<String> f5265a;
    public int f5266b;
    public Period f5267c;

    public MonthsAdapter(Context context, int i, int i2, Period period) {
        super(context, i);
        Collection a = Lists.a();
        f5265a = a;
        Collections.addAll(a, DateFormatSymbols.getInstance(context.getResources().getConfiguration().locale).getMonths());
        this.f5266b = i2;
        this.f5267c = period;
        m7969a(m7970b());
    }

    public final int m7971a(Integer num) {
        return getPosition(f5265a.get(num.intValue() - 1));
    }

    public final void m7972a() {
        clear();
        m7969a(m7970b());
        AdapterDetour.a(this, -1534880596);
    }

    private List<String> m7970b() {
        if (this.f5266b == 0) {
            return Lists.a();
        }
        List<String> a = Lists.a(f5265a);
        if (this.f5266b < this.f5267c.m7973a() || this.f5266b > this.f5267c.m7974b()) {
            return Lists.a();
        }
        if (this.f5266b == this.f5267c.m7974b()) {
            a = a.subList(0, this.f5267c.m7976d().intValue());
        }
        if (this.f5266b == this.f5267c.m7973a()) {
            return a.subList(this.f5267c.m7975c().intValue() - 1, a.size());
        }
        return a;
    }

    private void m7969a(List<String> list) {
        for (String add : list) {
            add(add);
        }
    }
}

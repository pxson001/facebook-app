package com.facebook.uicontrib.datepicker;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

/* compiled from: screenshot */
public class YearsAdapter extends ArrayAdapter<String> {
    public static NumberFormat f5272a;
    public Period f5273b;

    public YearsAdapter(Context context, int i, Period period) {
        super(context, i);
        NumberFormat instance = NumberFormat.getInstance(context.getResources().getConfiguration().locale);
        f5272a = instance;
        instance.setGroupingUsed(false);
        this.f5273b = period;
        m7980a(m7981b());
    }

    public static int m7979a(String str) {
        try {
            return f5272a.parse(str).intValue();
        } catch (ParseException e) {
            return 0;
        }
    }

    public final int m7982a(int i) {
        return getPosition(f5272a.format((long) i));
    }

    public final void m7983a() {
        clear();
        m7980a(m7981b());
        AdapterDetour.a(this, -271419153);
    }

    private List<String> m7981b() {
        List<String> a = Lists.a();
        for (int b = this.f5273b.m7974b(); b >= this.f5273b.m7973a(); b--) {
            a.add(f5272a.format((long) b));
        }
        return a;
    }

    private void m7980a(List<String> list) {
        for (String add : list) {
            add(add);
        }
    }
}

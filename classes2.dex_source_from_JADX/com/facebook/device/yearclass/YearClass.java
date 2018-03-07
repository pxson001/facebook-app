package com.facebook.device.yearclass;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: gms_interop_fix */
public class YearClass {
    private static volatile Integer f22213a;

    public static int m30095a(Context context) {
        if (f22213a == null) {
            synchronized (YearClass.class) {
                if (f22213a == null) {
                    f22213a = Integer.valueOf(m30097b(context));
                }
            }
        }
        return f22213a.intValue();
    }

    private static void m30096a(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    private static int m30097b(Context context) {
        ArrayList arrayList = new ArrayList();
        int a = DeviceInfo.m30098a();
        if (a <= 0) {
            a = -1;
        } else if (a == 1) {
            a = 2008;
        } else if (a <= 3) {
            a = 2011;
        } else {
            a = 2012;
        }
        m30096a(arrayList, a);
        long b = (long) DeviceInfo.m30102b();
        if (b == -1) {
            a = -1;
        } else if (b <= 528000) {
            a = 2008;
        } else if (b <= 620000) {
            a = 2009;
        } else if (b <= 1020000) {
            a = 2010;
        } else if (b <= 1220000) {
            a = 2011;
        } else if (b <= 1520000) {
            a = 2012;
        } else if (b <= 2020000) {
            a = 2013;
        } else {
            a = 2014;
        }
        m30096a(arrayList, a);
        b = DeviceInfo.m30101a(context);
        if (b <= 0) {
            a = -1;
        } else if (b <= 201326592) {
            a = 2008;
        } else if (b <= 304087040) {
            a = 2009;
        } else if (b <= 536870912) {
            a = 2010;
        } else if (b <= 1073741824) {
            a = 2011;
        } else if (b <= 1610612736) {
            a = 2012;
        } else if (b <= 2147483648L) {
            a = 2013;
        } else {
            a = 2014;
        }
        m30096a(arrayList, a);
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
        }
        int size = (arrayList.size() / 2) - 1;
        return ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2) + ((Integer) arrayList.get(size)).intValue();
    }
}

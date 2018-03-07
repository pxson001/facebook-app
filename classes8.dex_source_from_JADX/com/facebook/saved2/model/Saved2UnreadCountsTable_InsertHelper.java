package com.facebook.saved2.model;

import com.facebook.crudolib.dbinsert.InsertProvider;

/* compiled from: normalizedContactpoint */
public class Saved2UnreadCountsTable_InsertHelper implements InsertProvider {
    public static final String[] f7847a = new String[]{"section_name"};
    public static final String[] f7848b = new String[]{"section_name", "unread_count"};

    public final Object m8236a() {
        return Saved2UnreadCountsTable.class;
    }

    public final Object[] m8237b() {
        Object[] objArr = new Object[5];
        objArr[0] = "unread_count";
        objArr[1] = f7848b;
        objArr[2] = Integer.valueOf(5);
        objArr[3] = f7847a;
        objArr[4] = new int[]{0};
        return objArr;
    }
}

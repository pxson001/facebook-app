package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: acquaintances */
public final class SingleContextTable__JsonHelper {
    public static SingleContextTable m19738a(String str) {
        JsonParser a = JsonFactoryHolder.f7685a.a(str);
        a.c();
        SingleContextModelBase singleContextTable = new SingleContextTable();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            singleContextTable = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                String str2 = null;
                int i2;
                if ("output".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    singleContextTable.f11633a = str2;
                    i2 = 1;
                } else if ("table".equals(i)) {
                    List arrayList;
                    if (a.g() == JsonToken.START_ARRAY) {
                        arrayList = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            TableItem tableItem = new TableItem();
                            if (a.g() != JsonToken.START_OBJECT) {
                                a.f();
                                tableItem = null;
                            } else {
                                while (a.c() != JsonToken.END_OBJECT) {
                                    String i3 = a.i();
                                    a.c();
                                    String str3 = null;
                                    int i4;
                                    if ("bucket".equals(i3)) {
                                        if (a.g() != JsonToken.VALUE_NULL) {
                                            str3 = a.o();
                                        }
                                        tableItem.f11636a = str3;
                                        i4 = 1;
                                    } else if ("value".equals(i3)) {
                                        if (a.g() != JsonToken.VALUE_NULL) {
                                            str3 = a.o();
                                        }
                                        tableItem.f11637b = str3;
                                        i4 = 1;
                                    }
                                    a.f();
                                }
                            }
                            TableItem tableItem2 = tableItem;
                            if (tableItem2 != null) {
                                arrayList.add(tableItem2);
                            }
                        }
                    }
                    singleContextTable.f11634b = arrayList;
                    i2 = 1;
                } else if ("default".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    singleContextTable.f11635c = str2;
                    i2 = 1;
                } else {
                    boolean a2 = SingleContextModelBase__JsonHelper.m19737a(singleContextTable, i, a);
                }
                a.f();
            }
        }
        return singleContextTable;
    }
}

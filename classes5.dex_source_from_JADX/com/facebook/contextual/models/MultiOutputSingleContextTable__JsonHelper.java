package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: action_link_type */
public final class MultiOutputSingleContextTable__JsonHelper {
    public static MultiOutputSingleContextTable m19733a(String str) {
        JsonParser a = JsonFactoryHolder.f7685a.a(str);
        a.c();
        SingleContextModelBase multiOutputSingleContextTable = new MultiOutputSingleContextTable();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            multiOutputSingleContextTable = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                List list = null;
                int i2;
                if ("outputs".equals(i)) {
                    if (a.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            Output a2 = Output__JsonHelper.m19735a(a);
                            if (a2 != null) {
                                list.add(a2);
                            }
                        }
                    }
                    multiOutputSingleContextTable.f11620a = list;
                    i2 = 1;
                } else if ("table".equals(i)) {
                    if (a.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            MultiValueTableItem multiValueTableItem = new MultiValueTableItem();
                            if (a.g() != JsonToken.START_OBJECT) {
                                a.f();
                                multiValueTableItem = null;
                            } else {
                                while (a.c() != JsonToken.END_OBJECT) {
                                    String i3 = a.i();
                                    a.c();
                                    List list2 = null;
                                    int i4;
                                    if ("bucket".equals(i3)) {
                                        String o;
                                        if (a.g() != JsonToken.VALUE_NULL) {
                                            o = a.o();
                                        }
                                        multiValueTableItem.f11623a = o;
                                        i4 = 1;
                                    } else if ("values".equals(i3)) {
                                        if (a.g() == JsonToken.START_ARRAY) {
                                            list2 = new ArrayList();
                                            while (a.c() != JsonToken.END_ARRAY) {
                                                OutputValue a3 = OutputValue__JsonHelper.m19734a(a);
                                                if (a3 != null) {
                                                    list2.add(a3);
                                                }
                                            }
                                        }
                                        multiValueTableItem.f11624b = list2;
                                        i4 = 1;
                                    }
                                    a.f();
                                }
                            }
                            MultiValueTableItem multiValueTableItem2 = multiValueTableItem;
                            if (multiValueTableItem2 != null) {
                                list.add(multiValueTableItem2);
                            }
                        }
                    }
                    multiOutputSingleContextTable.f11621b = list;
                    i2 = 1;
                } else if ("default".equals(i)) {
                    if (a.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            OutputValue a4 = OutputValue__JsonHelper.m19734a(a);
                            if (a4 != null) {
                                list.add(a4);
                            }
                        }
                    }
                    multiOutputSingleContextTable.f11622c = list;
                    i2 = 1;
                } else {
                    boolean a5 = SingleContextModelBase__JsonHelper.m19737a(multiOutputSingleContextTable, i, a);
                }
                a.f();
            }
        }
        return multiOutputSingleContextTable;
    }
}

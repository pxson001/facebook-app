package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: mHeaderAppId */
public class ImmutableList<E> extends ArrayList<E> {
    private ImmutableList(List<E> list) {
        super(list);
    }

    public static <E> ImmutableList<E> m8975a(List<E> list) {
        return new ImmutableList(list);
    }
}

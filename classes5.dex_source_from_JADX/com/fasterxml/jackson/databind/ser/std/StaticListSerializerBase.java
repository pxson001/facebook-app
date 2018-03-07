package com.fasterxml.jackson.databind.ser.std;

import java.util.Collection;

/* compiled from: cancel */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> {
    public final boolean m11590a(Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, (byte) 0);
    }
}

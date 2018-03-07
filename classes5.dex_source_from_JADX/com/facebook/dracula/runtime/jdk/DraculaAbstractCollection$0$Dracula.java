package com.facebook.dracula.runtime.jdk;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: run */
public abstract class DraculaAbstractCollection$0$Dracula implements DraculaCollection$0$Dracula {
    public abstract DraculaIterator$0$Dracula mo589b();

    public abstract int mo596c();

    protected DraculaAbstractCollection$0$Dracula() {
    }

    public boolean mo588a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean mo598a() {
        return mo596c() == 0;
    }

    public DraculaArray mo587d() {
        DraculaAbstractCollection$0$Dracula draculaArrayList$0$Dracula = new DraculaArrayList$0$Dracula(mo596c());
        DraculaIterator$0$Dracula b = mo589b();
        while (b.mo585a()) {
            DraculaReturnValue b2 = b.mo586b();
            draculaArrayList$0$Dracula.mo588a(b2.f2924a, b2.f2925b, b2.f2926c);
        }
        return draculaArrayList$0$Dracula.mo587d();
    }

    public String toString() {
        if (mo598a()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(mo596c() * 16);
        stringBuilder.append('[');
        DraculaIterator$0$Dracula b = mo589b();
        while (b.mo585a()) {
            DraculaReturnValue b2 = b.mo586b();
            stringBuilder.append(DraculaRuntime.m4075a(b2.f2924a, b2.f2925b, b2.f2926c));
            if (b.mo585a()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

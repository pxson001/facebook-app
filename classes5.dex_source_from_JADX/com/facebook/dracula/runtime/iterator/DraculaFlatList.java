package com.facebook.dracula.runtime.iterator;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.jdk.DraculaAbstractList$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaList$0$Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: rhc */
public class DraculaFlatList extends DraculaAbstractList$0$Dracula implements DraculaList$0$Dracula {
    public static final DraculaFlatList f2955b = new DraculaFlatList();
    private final MutableFlatBuffer f2956c;
    private final int f2957d;
    private final boolean f2958e;
    private final int f2959f;
    private final int f2960g;

    public static DraculaFlatList m4134a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, int i3) {
        DraculaFlatList draculaFlatList;
        int l = mutableFlatBuffer.l(i, i2);
        if (l == 0) {
            draculaFlatList = f2955b;
        } else {
            draculaFlatList = new DraculaFlatList(mutableFlatBuffer, l, false, i3);
        }
        return draculaFlatList;
    }

    private DraculaFlatList() {
        this.f2956c = null;
        this.f2957d = 0;
        this.f2958e = false;
        this.f2959f = 0;
        this.f2960g = 0;
    }

    public DraculaFlatList(MutableFlatBuffer mutableFlatBuffer, int i, boolean z, int i2) {
        this.f2956c = mutableFlatBuffer;
        this.f2957d = i;
        this.f2958e = z;
        this.f2959f = i2;
        this.f2960g = mutableFlatBuffer.d(i);
    }

    public final DraculaReturnValue mo594a(int i) {
        if (i < 0 || i >= this.f2960g) {
            throw new IndexOutOfBoundsException();
        }
        int m = this.f2956c.m(this.f2957d, i);
        int i2 = this.f2959f;
        if (this.f2958e) {
            i2 = this.f2956c.i(m, 0);
            m = this.f2956c.g(m, 1);
        }
        return DraculaReturnValue.m4065a(this.f2956c, m, i2);
    }

    public final int mo596c() {
        return this.f2960g;
    }
}

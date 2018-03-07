package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.jdk.DraculaCollection$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaIterator$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaList$0$Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.util.RandomAccess;
import javax.annotation.Nullable;

/* compiled from: rotation_lock_changed_rotation */
public abstract class DraculaImmutableList$0$Dracula extends DraculaImmutableCollection$0$Dracula implements DraculaList$0$Dracula, RandomAccess {
    private static final DraculaImmutableList$0$Dracula f2939a = new DraculaRegularImmutableList$0$Dracula(DraculaObjectArrays.f2947b);

    public /* synthetic */ DraculaIterator$0$Dracula mo589b() {
        return mo592e();
    }

    public static DraculaImmutableList$0$Dracula m4104h() {
        return f2939a;
    }

    public static DraculaImmutableList$0$Dracula m4101a(DraculaCollection$0$Dracula draculaCollection$0$Dracula) {
        if (draculaCollection$0$Dracula instanceof DraculaImmutableCollection) {
            DraculaImmutableList$0$Dracula f = ((DraculaImmutableCollection$0$Dracula) draculaCollection$0$Dracula).mo593f();
            if (f.mo597g()) {
                return m4102b(f.mo587d());
            }
            return f;
        }
        DraculaArray d = draculaCollection$0$Dracula.mo587d();
        int i = d.f2931b;
        for (int i2 = 0; i2 < i; i2++) {
            DraculaReturnValue a = DraculaObjectArrays.m4115a(d.m4072b(i2), d.m4073c(i2), d.m4074d(i2), i2);
            MutableFlatBuffer mutableFlatBuffer = a.f2924a;
            int i3 = a.f2925b;
            int i4 = a.f2926c;
        }
        return m4102b(d);
    }

    public static DraculaImmutableList$0$Dracula m4102b(DraculaArray draculaArray) {
        return m4103b(draculaArray, draculaArray.f2931b);
    }

    private static DraculaImmutableList$0$Dracula m4103b(DraculaArray draculaArray, int i) {
        switch (i) {
            case 0:
                return m4104h();
            case 1:
                return new DraculaSingletonImmutableList$0$Dracula(draculaArray.m4072b(0), draculaArray.m4073c(0), draculaArray.m4074d(0));
            default:
                if (i < draculaArray.f2931b) {
                    DraculaArray a = DraculaArray.m4066a(i);
                    DraculaArray.m4067a(draculaArray, 0, a, 0, Math.min(draculaArray.f2931b, i));
                    draculaArray = a;
                }
                return new DraculaRegularImmutableList$0$Dracula(draculaArray);
        }
    }

    DraculaImmutableList$0$Dracula() {
    }

    public DraculaUnmodifiableIterator$0$Dracula mo592e() {
        return m4110i();
    }

    public final DraculaUnmodifiableListIterator$0$Dracula m4110i() {
        return mo595b(0);
    }

    public DraculaUnmodifiableListIterator$0$Dracula mo595b(int i) {
        return new DraculaAbstractIndexedListIterator$0$Dracula(this, mo596c(), i) {
            final /* synthetic */ DraculaImmutableList$0$Dracula f2938a;

            protected final DraculaReturnValue mo590a(int i) {
                DraculaReturnValue a = this.f2938a.mo594a(i);
                return DraculaReturnValue.m4065a(a.f2924a, a.f2925b, a.f2926c);
            }
        };
    }

    public final DraculaImmutableList$0$Dracula mo593f() {
        return this;
    }

    int mo591a(DraculaArray draculaArray, int i) {
        int c = mo596c();
        for (int i2 = 0; i2 < c; i2++) {
            DraculaReturnValue a = mo594a(i2);
            MutableFlatBuffer mutableFlatBuffer = a.f2924a;
            int i3 = a.f2925b;
            int i4 = a.f2926c;
            int i5 = i + i2;
            draculaArray.m4070a(i5, mutableFlatBuffer);
            draculaArray.m4068a(i5, i3);
            draculaArray.m4071b(i5, i4);
        }
        return i + c;
    }

    public boolean equals(@Nullable Object obj) {
        return DraculaLists.m4114a(this, obj);
    }

    public int hashCode() {
        int i = 1;
        int c = mo596c();
        for (int i2 = 0; i2 < c; i2++) {
            DraculaReturnValue a = mo594a(i2);
            MutableFlatBuffer mutableFlatBuffer = a.f2924a;
            int i3 = a.f2925b;
            int i4 = a.f2926c;
            i = (((i * 31) + ((mutableFlatBuffer.hashCode() * 31) + i3)) ^ -1) ^ -1;
        }
        return i;
    }
}

package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.jdk.DraculaAbstractCollection$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaIterator$0$Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: rule_breakers */
public abstract class DraculaImmutableCollection$0$Dracula extends DraculaAbstractCollection$0$Dracula {
    private transient DraculaImmutableList$0$Dracula f2937a;

    public abstract DraculaUnmodifiableIterator$0$Dracula mo592e();

    abstract boolean mo597g();

    public /* synthetic */ DraculaIterator$0$Dracula mo589b() {
        return mo592e();
    }

    DraculaImmutableCollection$0$Dracula() {
    }

    public final DraculaArray mo587d() {
        DraculaArray a = DraculaArray.m4066a(mo596c());
        mo591a(a, 0);
        return a;
    }

    @Deprecated
    public final boolean mo588a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public DraculaImmutableList$0$Dracula mo593f() {
        DraculaImmutableList$0$Dracula draculaImmutableList$0$Dracula = this.f2937a;
        if (draculaImmutableList$0$Dracula != null) {
            return draculaImmutableList$0$Dracula;
        }
        draculaImmutableList$0$Dracula = m4088h();
        this.f2937a = draculaImmutableList$0$Dracula;
        return draculaImmutableList$0$Dracula;
    }

    private DraculaImmutableList$0$Dracula m4088h() {
        switch (mo596c()) {
            case 0:
                return DraculaImmutableList$0$Dracula.m4104h();
            case 1:
                DraculaReturnValue b = mo592e().mo586b();
                return new DraculaSingletonImmutableList$0$Dracula(b.f2924a, b.f2925b, b.f2926c);
            default:
                return DraculaImmutableList$0$Dracula.m4101a(this);
        }
    }

    int mo591a(DraculaArray draculaArray, int i) {
        DraculaIterator$0$Dracula e = mo592e();
        while (e.mo585a()) {
            DraculaReturnValue b = e.mo586b();
            MutableFlatBuffer mutableFlatBuffer = b.f2924a;
            int i2 = b.f2925b;
            int i3 = b.f2926c;
            int i4 = i + 1;
            draculaArray.m4070a(i, mutableFlatBuffer);
            draculaArray.m4068a(i, i2);
            draculaArray.m4071b(i, i3);
            i = i4;
        }
        return i;
    }
}

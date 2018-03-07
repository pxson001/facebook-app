package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.dracula.runtime.guava.DraculaIterators.C02094;
import com.facebook.dracula.runtime.jdk.DraculaIterator$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaList;
import com.facebook.dracula.runtime.jdk.DraculaList$0$Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: rich_document_edge */
public final class DraculaSingletonImmutableList$0$Dracula extends DraculaImmutableList$0$Dracula {
    final transient MutableFlatBuffer f2951a;
    final transient int f2952b;
    final transient int f2953c;

    public final /* synthetic */ DraculaIterator$0$Dracula mo589b() {
        return mo592e();
    }

    public DraculaSingletonImmutableList$0$Dracula(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        DraculaReturnValue a = DraculaPreconditions.m4116a(mutableFlatBuffer, i, i2);
        MutableFlatBuffer mutableFlatBuffer2 = a.f2924a;
        int i3 = a.f2925b;
        int i4 = a.f2926c;
        this.f2951a = mutableFlatBuffer2;
        this.f2952b = i3;
        this.f2953c = i4;
    }

    public final DraculaReturnValue mo594a(int i) {
        Preconditions.checkElementIndex(i, 1);
        return DraculaReturnValue.m4065a(this.f2951a, this.f2952b, this.f2953c);
    }

    public final DraculaUnmodifiableIterator$0$Dracula mo592e() {
        return new C02094(this.f2951a, this.f2952b, this.f2953c);
    }

    public final int mo596c() {
        return 1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DraculaList)) {
            return false;
        }
        DraculaList$0$Dracula draculaList$0$Dracula = (DraculaList$0$Dracula) obj;
        if (draculaList$0$Dracula.mo596c() != 1) {
            return false;
        }
        DraculaReturnValue a = draculaList$0$Dracula.mo594a(0);
        MutableFlatBuffer mutableFlatBuffer = a.f2924a;
        int i = a.f2925b;
        int i2 = a.f2926c;
        return DraculaRuntime.m4076a(this.f2951a, this.f2952b, mutableFlatBuffer, i);
    }

    public final int hashCode() {
        return (this.f2952b + (this.f2951a.hashCode() * 31)) + 31;
    }

    public final String toString() {
        String a = DraculaRuntime.m4075a(this.f2951a, this.f2952b, this.f2953c);
        return new StringBuilder(a.length() + 2).append('[').append(a).append(']').toString();
    }

    public final boolean mo598a() {
        return false;
    }

    final boolean mo597g() {
        return false;
    }

    final int mo591a(DraculaArray draculaArray, int i) {
        draculaArray.m4070a(i, this.f2951a);
        draculaArray.m4068a(i, this.f2952b);
        draculaArray.m4071b(i, this.f2953c);
        return i + 1;
    }
}

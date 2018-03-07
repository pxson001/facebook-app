package com.facebook.dracula.runtime.jdk;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/* compiled from: rhc_tag */
public abstract class DraculaAbstractList$0$Dracula extends DraculaAbstractCollection$0$Dracula implements DraculaList$0$Dracula {
    protected transient int f2954a;

    /* compiled from: rhc_tag */
    class SimpleListIterator implements DraculaIterator$0$Dracula {
        int f2961a = -1;
        int f2962b;
        int f2963c = -1;
        final /* synthetic */ DraculaAbstractList$0$Dracula f2964d;

        SimpleListIterator(DraculaAbstractList$0$Dracula draculaAbstractList$0$Dracula) {
            this.f2964d = draculaAbstractList$0$Dracula;
            this.f2962b = draculaAbstractList$0$Dracula.f2954a;
        }

        public final boolean mo585a() {
            return this.f2961a + 1 < this.f2964d.mo596c();
        }

        public final DraculaReturnValue mo586b() {
            if (this.f2962b == this.f2964d.f2954a) {
                try {
                    DraculaReturnValue a = this.f2964d.mo594a(this.f2961a + 1);
                    MutableFlatBuffer mutableFlatBuffer = a.f2924a;
                    int i = a.f2925b;
                    int i2 = a.f2926c;
                    int i3 = this.f2961a + 1;
                    this.f2961a = i3;
                    this.f2963c = i3;
                    return DraculaReturnValue.m4065a(mutableFlatBuffer, i, i2);
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }
            throw new ConcurrentModificationException();
        }
    }

    public abstract DraculaReturnValue mo594a(int i);

    protected DraculaAbstractList$0$Dracula() {
    }

    public void mo602a(int i, MutableFlatBuffer mutableFlatBuffer, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    public boolean mo588a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        mo602a(mo596c(), mutableFlatBuffer, i, i2);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            DraculaList$0$Dracula draculaList$0$Dracula = (DraculaList$0$Dracula) obj;
            if (draculaList$0$Dracula.mo596c() != mo596c()) {
                return false;
            }
            DraculaIterator$0$Dracula b = mo589b();
            DraculaIterator$0$Dracula b2 = draculaList$0$Dracula.mo589b();
            while (b.mo585a()) {
                DraculaReturnValue b3 = b.mo586b();
                MutableFlatBuffer mutableFlatBuffer = b3.f2924a;
                int i = b3.f2925b;
                int i2 = b3.f2926c;
                b3 = b2.mo586b();
                MutableFlatBuffer mutableFlatBuffer2 = b3.f2924a;
                int i3 = b3.f2925b;
                i2 = b3.f2926c;
                if (DraculaRuntime.m4076a(mutableFlatBuffer, i, null, 0)) {
                    if (DraculaRuntime.m4076a(mutableFlatBuffer2, i3, null, 0)) {
                    }
                } else if (DraculaRuntime.m4076a(mutableFlatBuffer, i, mutableFlatBuffer2, i3)) {
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        int i = 1;
        DraculaIterator$0$Dracula b = mo589b();
        while (b.mo585a()) {
            DraculaReturnValue b2 = b.mo586b();
            MutableFlatBuffer mutableFlatBuffer = b2.f2924a;
            int i2 = b2.f2925b;
            int i3 = b2.f2926c;
            i = (DraculaRuntime.m4076a(mutableFlatBuffer, i2, null, 0) ? 0 : (mutableFlatBuffer.hashCode() * 31) + i2) + (i * 31);
        }
        return i;
    }

    public DraculaIterator$0$Dracula mo589b() {
        return new SimpleListIterator(this);
    }
}

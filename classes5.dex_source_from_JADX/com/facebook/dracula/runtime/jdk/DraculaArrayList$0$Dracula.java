package com.facebook.dracula.runtime.jdk;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: reviews_list */
public class DraculaArrayList$0$Dracula extends DraculaAbstractList$0$Dracula implements Cloneable, RandomAccess {
    int f2969b;
    transient DraculaArray f2970c;

    /* compiled from: reviews_list */
    class ArrayListIterator implements DraculaIterator$0$Dracula {
        final /* synthetic */ DraculaArrayList$0$Dracula f2965a;
        private int f2966b = this.f2965a.f2969b;
        private int f2967c = -1;
        private int f2968d = this.f2965a.f2954a;

        public ArrayListIterator(DraculaArrayList$0$Dracula draculaArrayList$0$Dracula) {
            this.f2965a = draculaArrayList$0$Dracula;
        }

        public final boolean mo585a() {
            return this.f2966b != 0;
        }

        public final DraculaReturnValue mo586b() {
            DraculaAbstractList$0$Dracula draculaAbstractList$0$Dracula = this.f2965a;
            int i = this.f2966b;
            if (draculaAbstractList$0$Dracula.f2954a != this.f2968d) {
                throw new ConcurrentModificationException();
            } else if (i == 0) {
                throw new NoSuchElementException();
            } else {
                this.f2966b = i - 1;
                i = draculaAbstractList$0$Dracula.f2969b - i;
                this.f2967c = i;
                DraculaArray draculaArray = draculaAbstractList$0$Dracula.f2970c;
                return DraculaReturnValue.m4065a(draculaArray.m4072b(i), draculaArray.m4073c(i), draculaArray.m4074d(i));
            }
        }
    }

    public DraculaArrayList$0$Dracula(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        this.f2970c = DraculaArray.m4066a(i);
    }

    public DraculaArrayList$0$Dracula() {
        this.f2970c = DraculaArray.m4066a(0);
    }

    public final boolean mo588a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        DraculaArray a;
        DraculaArray draculaArray = this.f2970c;
        int i3 = this.f2969b;
        if (i3 == draculaArray.f2931b) {
            a = DraculaArray.m4066a((i3 < 6 ? 12 : i3 >> 1) + i3);
            DraculaArray.m4067a(draculaArray, 0, a, 0, i3);
            this.f2970c = a;
        } else {
            a = draculaArray;
        }
        a.m4070a(i3, mutableFlatBuffer);
        a.m4068a(i3, i);
        a.m4071b(i3, i2);
        this.f2969b = i3 + 1;
        this.a = this.f2954a + 1;
        return true;
    }

    public final void mo602a(int i, MutableFlatBuffer mutableFlatBuffer, int i2, int i3) {
        DraculaArray draculaArray = this.f2970c;
        int i4 = this.f2969b;
        if (i > i4 || i < 0) {
            m4141a(i, i4);
        }
        if (i4 < draculaArray.f2931b) {
            DraculaArray.m4067a(draculaArray, i, draculaArray, i + 1, i4 - i);
        } else {
            DraculaArray a = DraculaArray.m4066a((i4 < 6 ? 12 : i4 >> 1) + i4);
            DraculaArray.m4067a(draculaArray, 0, a, 0, i);
            DraculaArray.m4067a(draculaArray, i, a, i + 1, i4 - i);
            this.f2970c = a;
            draculaArray = a;
        }
        draculaArray.m4070a(i, mutableFlatBuffer);
        draculaArray.m4068a(i, i2);
        draculaArray.m4071b(i, i3);
        this.f2969b = i4 + 1;
        this.a = this.f2954a + 1;
    }

    private static IndexOutOfBoundsException m4141a(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    public Object clone() {
        try {
            DraculaArrayList$0$Dracula draculaArrayList$0$Dracula = (DraculaArrayList$0$Dracula) super.clone();
            draculaArrayList$0$Dracula.f2970c = this.f2970c.m4069a();
            return draculaArrayList$0$Dracula;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public final DraculaReturnValue mo594a(int i) {
        if (i >= this.f2969b) {
            m4141a(i, this.f2969b);
        }
        DraculaArray draculaArray = this.f2970c;
        return DraculaReturnValue.m4065a(draculaArray.m4072b(i), draculaArray.m4073c(i), draculaArray.m4074d(i));
    }

    public final int mo596c() {
        return this.f2969b;
    }

    public final boolean mo598a() {
        return this.f2969b == 0;
    }

    public final DraculaArray mo587d() {
        int i = this.f2969b;
        DraculaArray a = DraculaArray.m4066a(i);
        DraculaArray.m4067a(this.f2970c, 0, a, 0, i);
        return a;
    }

    public final DraculaIterator$0$Dracula mo589b() {
        return new ArrayListIterator(this);
    }

    public int hashCode() {
        DraculaArray draculaArray = this.f2970c;
        int i = 1;
        int i2 = this.f2969b;
        int i3 = 0;
        while (i3 < i2) {
            MutableFlatBuffer b = draculaArray.m4072b(i3);
            int c = draculaArray.m4073c(i3);
            draculaArray.m4074d(i3);
            int i4 = i * 31;
            if (DraculaRuntime.m4076a(b, c, null, 0)) {
                i = 0;
            } else {
                i = (b.hashCode() * 31) + c;
            }
            i3++;
            i = i4 + i;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        try {
            DraculaList$0$Dracula draculaList$0$Dracula = (DraculaList$0$Dracula) obj;
            int i = this.f2969b;
            if (draculaList$0$Dracula.mo596c() != i) {
                return false;
            }
            DraculaArray draculaArray = this.f2970c;
            int i2;
            int i3;
            if (draculaList$0$Dracula instanceof RandomAccess) {
                i2 = 0;
                while (i2 < i) {
                    MutableFlatBuffer b = draculaArray.m4072b(i2);
                    int c = draculaArray.m4073c(i2);
                    draculaArray.m4074d(i2);
                    DraculaReturnValue a = draculaList$0$Dracula.mo594a(i2);
                    MutableFlatBuffer mutableFlatBuffer = a.f2924a;
                    int i4 = a.f2925b;
                    i3 = a.f2926c;
                    if (DraculaRuntime.m4076a(b, c, null, 0)) {
                        if (DraculaRuntime.m4076a(mutableFlatBuffer, i4, null, 0)) {
                            i2++;
                        }
                    } else if (DraculaRuntime.m4076a(b, c, mutableFlatBuffer, i4)) {
                        i2++;
                    }
                    return false;
                }
                return true;
            }
            DraculaIterator$0$Dracula b2 = draculaList$0$Dracula.mo589b();
            i2 = 0;
            while (i2 < i) {
                MutableFlatBuffer b3 = draculaArray.m4072b(i2);
                i3 = draculaArray.m4073c(i2);
                draculaArray.m4074d(i2);
                DraculaReturnValue b4 = b2.mo586b();
                MutableFlatBuffer mutableFlatBuffer2 = b4.f2924a;
                int i5 = b4.f2925b;
                int i6 = b4.f2926c;
                if (DraculaRuntime.m4076a(b3, i3, null, 0)) {
                    if (DraculaRuntime.m4076a(mutableFlatBuffer2, i5, null, 0)) {
                        i2++;
                    }
                } else if (DraculaRuntime.m4076a(b3, i3, mutableFlatBuffer2, i5)) {
                    i2++;
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}

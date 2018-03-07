package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

/* compiled from: runtime_linter_category */
abstract class DraculaAbstractIndexedListIterator$0$Dracula extends DraculaUnmodifiableListIterator$0$Dracula {
    private final int f2935a;
    private int f2936b;

    protected abstract DraculaReturnValue mo590a(int i);

    protected DraculaAbstractIndexedListIterator$0$Dracula(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.f2935a = i;
        this.f2936b = i2;
    }

    public final boolean mo585a() {
        return this.f2936b < this.f2935a;
    }

    public final DraculaReturnValue mo586b() {
        if (mo585a()) {
            int i = this.f2936b;
            this.f2936b = i + 1;
            DraculaReturnValue a = mo590a(i);
            return DraculaReturnValue.m4065a(a.f2924a, a.f2925b, a.f2926c);
        }
        throw new NoSuchElementException();
    }
}

package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.dracula.runtime.guava.DraculaIterators.C02082;
import com.google.common.base.Preconditions;

/* compiled from: ride_display_name */
class DraculaRegularImmutableList$0$Dracula extends DraculaImmutableList$0$Dracula {
    private final transient int f2948a;
    private final transient int f2949b;
    private final transient DraculaArray f2950c;

    private DraculaRegularImmutableList$0$Dracula(DraculaArray draculaArray, int i, int i2) {
        this.f2948a = i;
        this.f2949b = i2;
        this.f2950c = draculaArray;
    }

    DraculaRegularImmutableList$0$Dracula(DraculaArray draculaArray) {
        this(draculaArray, 0, draculaArray.f2931b);
    }

    public final int mo596c() {
        return this.f2949b;
    }

    final boolean mo597g() {
        return this.f2949b != this.f2950c.f2931b;
    }

    final int mo591a(DraculaArray draculaArray, int i) {
        DraculaArray.m4067a(this.f2950c, this.f2948a, draculaArray, i, this.f2949b);
        return this.f2949b + i;
    }

    public final DraculaReturnValue mo594a(int i) {
        Preconditions.checkElementIndex(i, this.f2949b);
        int i2 = this.f2948a + i;
        DraculaArray draculaArray = this.f2950c;
        return DraculaReturnValue.m4065a(draculaArray.m4072b(i2), draculaArray.m4073c(i2), draculaArray.m4074d(i2));
    }

    public final DraculaUnmodifiableListIterator$0$Dracula mo595b(int i) {
        DraculaUnmodifiableListIterator$0$Dracula i2;
        DraculaArray draculaArray = this.f2950c;
        int i3 = this.f2948a;
        int i4 = this.f2949b;
        Preconditions.checkArgument(i4 >= 0);
        Preconditions.checkPositionIndexes(i3, i3 + i4, draculaArray.f2931b);
        Preconditions.checkPositionIndex(i, i4);
        if (i4 == 0) {
            i2 = DraculaImmutableList$0$Dracula.m4104h().m4110i();
        } else {
            i2 = new C02082(i4, i, i3, draculaArray);
        }
        return i2;
    }
}

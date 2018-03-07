package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaArray;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.util.NoSuchElementException;

/* compiled from: root_share_story */
public final class DraculaIterators {

    /* compiled from: root_share_story */
    public final class C02082 extends DraculaAbstractIndexedListIterator$0$Dracula {
        final /* synthetic */ int f2940a;
        final /* synthetic */ DraculaArray f2941b;

        public C02082(int i, int i2, int i3, DraculaArray draculaArray) {
            this.f2940a = i3;
            this.f2941b = draculaArray;
            super(i, i2);
        }

        protected final DraculaReturnValue mo590a(int i) {
            int i2 = this.f2940a + i;
            DraculaArray draculaArray = this.f2941b;
            return DraculaReturnValue.m4065a(draculaArray.m4072b(i2), draculaArray.m4073c(i2), draculaArray.m4074d(i2));
        }
    }

    /* compiled from: root_share_story */
    public final class C02094 extends DraculaUnmodifiableIterator$0$Dracula {
        boolean f2942a;
        final /* synthetic */ MutableFlatBuffer f2943b;
        final /* synthetic */ int f2944c;
        final /* synthetic */ int f2945d;

        public C02094(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
            this.f2943b = mutableFlatBuffer;
            this.f2944c = i;
            this.f2945d = i2;
        }

        public final boolean mo585a() {
            return !this.f2942a;
        }

        public final DraculaReturnValue mo586b() {
            if (this.f2942a) {
                throw new NoSuchElementException();
            }
            this.f2942a = true;
            return DraculaReturnValue.m4065a(this.f2943b, this.f2944c, this.f2945d);
        }
    }

    private DraculaIterators() {
    }
}

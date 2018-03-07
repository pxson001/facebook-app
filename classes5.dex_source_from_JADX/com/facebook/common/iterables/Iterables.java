package com.facebook.common.iterables;

import com.facebook.common.iterables.Iterators.C10741;
import com.facebook.common.preconditions.Preconditions;
import java.util.Iterator;

/* compiled from: button_icon_image */
public class Iterables {

    /* compiled from: button_icon_image */
    public final class C10731 implements Iterable<T> {
        final /* synthetic */ Iterable[] f11091a;

        public C10731(Iterable[] iterableArr) {
            this.f11091a = iterableArr;
        }

        public final Iterator<T> iterator() {
            Iterable[] iterableArr = this.f11091a;
            Preconditions.b(iterableArr != null);
            return new C10741(iterableArr);
        }
    }
}

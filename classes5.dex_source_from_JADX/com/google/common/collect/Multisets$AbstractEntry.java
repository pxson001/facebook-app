package com.google.common.collect;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: cameraTargetLat */
public abstract class Multisets$AbstractEntry<E> {
    public abstract E mo889a();

    public abstract int mo890b();

    Multisets$AbstractEntry() {
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Multisets$AbstractEntry)) {
            return false;
        }
        Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) obj;
        if (mo890b() == multisets$AbstractEntry.mo890b() && Objects.equal(mo889a(), multisets$AbstractEntry.mo889a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object a = mo889a();
        return (a == null ? 0 : a.hashCode()) ^ mo890b();
    }

    public String toString() {
        String valueOf = String.valueOf(mo889a());
        int b = mo890b();
        return b == 1 ? valueOf : valueOf + " x " + b;
    }
}

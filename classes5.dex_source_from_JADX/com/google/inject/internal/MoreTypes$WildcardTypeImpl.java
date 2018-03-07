package com.google.inject.internal;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: bugReport_bs */
public class MoreTypes$WildcardTypeImpl implements MoreTypes$CompositeType, Serializable, WildcardType {
    private final Type lowerBound;
    private final Type upperBound;

    public MoreTypes$WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(typeArr2.length <= 1, "Must have at most one lower bound.");
        if (typeArr.length == 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Must have exactly one upper bound.");
        if (typeArr2.length == 1) {
            Preconditions.checkNotNull(typeArr2[0], "lowerBound");
            MoreTypes.b(typeArr2[0], "wildcard bounds");
            if (typeArr[0] != Object.class) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "bounded both ways");
            this.lowerBound = MoreTypes.a(typeArr2[0]);
            this.upperBound = Object.class;
            return;
        }
        Preconditions.checkNotNull(typeArr[0], "upperBound");
        MoreTypes.b(typeArr[0], "wildcard bounds");
        this.lowerBound = null;
        this.upperBound = MoreTypes.a(typeArr[0]);
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public Type[] getLowerBounds() {
        if (this.lowerBound == null) {
            return MoreTypes.a;
        }
        return new Type[]{this.lowerBound};
    }

    public final boolean mo1019a() {
        return MoreTypes.e(this.upperBound) && (this.lowerBound == null || MoreTypes.e(this.lowerBound));
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && MoreTypes.a(this, (WildcardType) obj);
    }

    public int hashCode() {
        return (this.lowerBound != null ? this.lowerBound.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
    }

    public String toString() {
        if (this.lowerBound != null) {
            return "? super " + MoreTypes.c(this.lowerBound);
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        return "? extends " + MoreTypes.c(this.upperBound);
    }
}

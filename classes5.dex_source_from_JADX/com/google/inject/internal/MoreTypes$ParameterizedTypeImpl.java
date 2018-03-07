package com.google.inject.internal;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: bugReport_bs */
public class MoreTypes$ParameterizedTypeImpl implements MoreTypes$CompositeType, Serializable, ParameterizedType {
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public MoreTypes$ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
        int i = 0;
        if (type2 instanceof Class) {
            boolean z;
            Class cls = (Class) type2;
            boolean z2 = type != null || cls.getEnclosingClass() == null;
            Preconditions.checkArgument(z2, "No owner type for enclosed %s", new Object[]{type2});
            if (type == null || cls.getEnclosingClass() != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Owner type for unenclosed %s", new Object[]{type2});
        }
        this.ownerType = type == null ? null : MoreTypes.a(type);
        this.rawType = MoreTypes.a(type2);
        this.typeArguments = (Type[]) typeArr.clone();
        while (i < this.typeArguments.length) {
            Preconditions.checkNotNull(this.typeArguments[i], "type parameter");
            MoreTypes.b(this.typeArguments[i], "type parameters");
            this.typeArguments[i] = MoreTypes.a(this.typeArguments[i]);
            i++;
        }
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    public Type getRawType() {
        return this.rawType;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public final boolean mo1019a() {
        if ((this.ownerType != null && !MoreTypes.e(this.ownerType)) || !MoreTypes.e(this.rawType)) {
            return false;
        }
        for (Type e : this.typeArguments) {
            if (!MoreTypes.e(e)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && MoreTypes.a(this, (ParameterizedType) obj);
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
        Type type = this.ownerType;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder((this.typeArguments.length + 1) * 30);
        stringBuilder.append(MoreTypes.c(this.rawType));
        if (this.typeArguments.length == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<").append(MoreTypes.c(this.typeArguments[0]));
        for (int i = 1; i < this.typeArguments.length; i++) {
            stringBuilder.append(", ").append(MoreTypes.c(this.typeArguments[i]));
        }
        return stringBuilder.append(">").toString();
    }
}

package com.fasterxml.jackson.annotation;

import java.io.Serializable;

/* compiled from: color */
public abstract class ObjectIdGenerator<T> implements Serializable {

    /* compiled from: color */
    public final class IdKey implements Serializable {
        private static final long serialVersionUID = 1;
        private final int hashCode;
        private final Object key;
        private final Class<?> scope;
        private final Class<?> type;

        public IdKey(Class<?> cls, Class<?> cls2, Object obj) {
            this.type = cls;
            this.scope = cls2;
            this.key = obj;
            int hashCode = obj.hashCode() + cls.getName().hashCode();
            if (cls2 != null) {
                hashCode ^= cls2.getName().hashCode();
            }
            this.hashCode = hashCode;
        }

        public final int hashCode() {
            return this.hashCode;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            IdKey idKey = (IdKey) obj;
            if (idKey.key.equals(this.key) && idKey.type == this.type && idKey.scope == this.scope) {
                return true;
            }
            return false;
        }
    }

    public abstract IdKey mo657a(Object obj);

    public abstract ObjectIdGenerator<T> mo658a(Class<?> cls);

    public abstract Class<?> mo634a();

    public abstract boolean mo635a(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> mo659b();

    public abstract T mo660b(Object obj);
}

package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: bug_timed_out_attachments */
final class Serialization {

    /* compiled from: bug_timed_out_attachments */
    final class FieldSetter<T> {
        private final Field f7539a;

        public FieldSetter(Field field) {
            this.f7539a = field;
            field.setAccessible(true);
        }

        final void m13645a(T t, Object obj) {
            try {
                this.f7539a.set(t, obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        final void m13644a(T t, int i) {
            try {
                this.f7539a.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    private Serialization() {
    }

    static int m13646a(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static <K, V> void m13655a(Map<K, V> map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    static <K, V> void m13653a(Map<K, V> map, ObjectInputStream objectInputStream) {
        m13654a((Map) map, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void m13654a(Map<K, V> map, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static <E> void m13652a(Multiset<E> multiset, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multiset.a().size());
        for (Multisets$AbstractEntry multisets$AbstractEntry : multiset.a()) {
            objectOutputStream.writeObject(multisets$AbstractEntry.mo889a());
            objectOutputStream.writeInt(multisets$AbstractEntry.mo890b());
        }
    }

    static <E> void m13650a(Multiset<E> multiset, ObjectInputStream objectInputStream) {
        m13651a((Multiset) multiset, objectInputStream, objectInputStream.readInt());
    }

    static <E> void m13651a(Multiset<E> multiset, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            multiset.a(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static <K, V> void m13649a(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multimap.b().size());
        for (Entry entry : multimap.b().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <K, V> void m13648a(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection c = multimap.c(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                c.add(objectInputStream.readObject());
            }
        }
    }

    static <T> FieldSetter<T> m13647a(Class<T> cls, String str) {
        try {
            return new FieldSetter(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }
}

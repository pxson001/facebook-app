package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: class_name */
public final class BeanPropertyMap implements Serializable, Iterable<SettableBeanProperty> {
    private static final long serialVersionUID = 1;
    private final Bucket[] _buckets;
    private final int _hashMask;
    private int _nextBucketIndex = 0;
    public final int _size;

    /* compiled from: class_name */
    final class Bucket implements Serializable {
        private static final long serialVersionUID = 1;
        public final int index;
        public final String key;
        public final Bucket next;
        public final SettableBeanProperty value;

        public Bucket(Bucket bucket, String str, SettableBeanProperty settableBeanProperty, int i) {
            this.next = bucket;
            this.key = str;
            this.value = settableBeanProperty;
            this.index = i;
        }
    }

    /* compiled from: class_name */
    final class IteratorImpl implements Iterator<SettableBeanProperty> {
        private final Bucket[] f6009a;
        private Bucket f6010b;
        private int f6011c;

        public IteratorImpl(Bucket[] bucketArr) {
            int i;
            this.f6009a = bucketArr;
            int i2 = 0;
            int length = this.f6009a.length;
            while (i2 < length) {
                i = i2 + 1;
                Bucket bucket = this.f6009a[i2];
                if (bucket != null) {
                    this.f6010b = bucket;
                    break;
                }
                i2 = i;
            }
            i = i2;
            this.f6011c = i;
        }

        public final boolean hasNext() {
            return this.f6010b != null;
        }

        public final Object next() {
            Bucket bucket = this.f6010b;
            if (bucket == null) {
                throw new NoSuchElementException();
            }
            Bucket bucket2 = bucket.next;
            while (bucket2 == null && this.f6011c < this.f6009a.length) {
                Bucket[] bucketArr = this.f6009a;
                int i = this.f6011c;
                this.f6011c = i + 1;
                bucket2 = bucketArr[i];
            }
            this.f6010b = bucket2;
            return bucket.value;
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public BeanPropertyMap(Collection<SettableBeanProperty> collection) {
        this._size = collection.size();
        int a = m11012a(this._size);
        this._hashMask = a - 1;
        Bucket[] bucketArr = new Bucket[a];
        for (SettableBeanProperty settableBeanProperty : collection) {
            String str = settableBeanProperty._propName;
            int hashCode = str.hashCode() & this._hashMask;
            Bucket bucket = bucketArr[hashCode];
            int i = this._nextBucketIndex;
            this._nextBucketIndex = i + 1;
            bucketArr[hashCode] = new Bucket(bucket, str, settableBeanProperty, i);
        }
        this._buckets = bucketArr;
    }

    private BeanPropertyMap(Bucket[] bucketArr, int i, int i2) {
        this._buckets = bucketArr;
        this._size = i;
        this._hashMask = bucketArr.length - 1;
        this._nextBucketIndex = i2;
    }

    public final BeanPropertyMap m11016a(SettableBeanProperty settableBeanProperty) {
        int length = this._buckets.length;
        Object obj = new Bucket[length];
        System.arraycopy(this._buckets, 0, obj, 0, length);
        String str = settableBeanProperty._propName;
        if (m11014a(settableBeanProperty._propName) == null) {
            length = str.hashCode() & this._hashMask;
            Bucket bucket = obj[length];
            int i = this._nextBucketIndex;
            this._nextBucketIndex = i + 1;
            obj[length] = new Bucket(bucket, str, settableBeanProperty, i);
            return new BeanPropertyMap(obj, this._size + 1, this._nextBucketIndex);
        }
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(obj, length, this._nextBucketIndex);
        beanPropertyMap.m11018b(settableBeanProperty);
        return beanPropertyMap;
    }

    public final BeanPropertyMap m11017a(NameTransformer nameTransformer) {
        if (nameTransformer == null || nameTransformer == NameTransformer.f6237a) {
            return this;
        }
        Iterator it = iterator();
        Collection arrayList = new ArrayList();
        while (it.hasNext()) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) it.next();
            Object a = settableBeanProperty.mo647a(nameTransformer.mo728a(settableBeanProperty._propName));
            JsonDeserializer l = a.m10943l();
            if (l != null) {
                JsonDeserializer a2 = l.a(nameTransformer);
                if (a2 != l) {
                    a = a.mo650b(a2);
                }
            }
            arrayList.add(a);
        }
        this(arrayList);
        return this;
    }

    public final BeanPropertyMap m11015a() {
        int i = 0;
        for (Bucket bucket : this._buckets) {
            Bucket bucket2;
            while (bucket2 != null) {
                int i2 = i + 1;
                bucket2.value.m10923a(i);
                bucket2 = bucket2.next;
                i = i2;
            }
        }
        return this;
    }

    private static final int m11012a(int i) {
        int i2 = 2;
        while (i2 < (i <= 32 ? i + i : (i >> 2) + i)) {
            i2 += i2;
        }
        return i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Properties=[");
        SettableBeanProperty[] b = m11019b();
        int length = b.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            SettableBeanProperty settableBeanProperty = b[i];
            if (settableBeanProperty != null) {
                i3 = i2 + 1;
                if (i2 > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(settableBeanProperty._propName);
                stringBuilder.append('(');
                stringBuilder.append(settableBeanProperty.m10920a());
                stringBuilder.append(')');
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final Iterator<SettableBeanProperty> iterator() {
        return new IteratorImpl(this._buckets);
    }

    public final SettableBeanProperty[] m11019b() {
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[this._nextBucketIndex];
        for (Bucket bucket : this._buckets) {
            for (Bucket bucket2 = r3[r1]; bucket2 != null; bucket2 = bucket2.next) {
                settableBeanPropertyArr[bucket2.index] = bucket2.value;
            }
        }
        return settableBeanPropertyArr;
    }

    public final int m11020c() {
        return this._size;
    }

    public final SettableBeanProperty m11014a(String str) {
        int hashCode = this._hashMask & str.hashCode();
        Bucket bucket = this._buckets[hashCode];
        if (bucket == null) {
            return null;
        }
        if (bucket.key == str) {
            return bucket.value;
        }
        do {
            bucket = bucket.next;
            if (bucket == null) {
                return m11013a(str, hashCode);
            }
        } while (bucket.key != str);
        return bucket.value;
    }

    public final void m11018b(SettableBeanProperty settableBeanProperty) {
        String str = settableBeanProperty._propName;
        int hashCode = str.hashCode() & (this._buckets.length - 1);
        Bucket bucket = this._buckets[hashCode];
        int i = -1;
        Bucket bucket2 = null;
        while (bucket != null) {
            if (i >= 0 || !bucket.key.equals(str)) {
                bucket2 = new Bucket(bucket2, bucket.key, bucket.value, bucket.index);
            } else {
                i = bucket.index;
            }
            bucket = bucket.next;
        }
        if (i < 0) {
            throw new NoSuchElementException("No entry '" + settableBeanProperty + "' found, can't replace");
        }
        this._buckets[hashCode] = new Bucket(bucket2, str, settableBeanProperty, i);
    }

    public final void m11021c(SettableBeanProperty settableBeanProperty) {
        String str = settableBeanProperty._propName;
        int hashCode = str.hashCode() & (this._buckets.length - 1);
        Bucket bucket = this._buckets[hashCode];
        Object obj = null;
        Bucket bucket2 = null;
        while (bucket != null) {
            if (obj == null && bucket.key.equals(str)) {
                obj = 1;
            } else {
                bucket2 = new Bucket(bucket2, bucket.key, bucket.value, bucket.index);
            }
            bucket = bucket.next;
        }
        if (obj == null) {
            throw new NoSuchElementException("No entry '" + settableBeanProperty + "' found, can't remove");
        }
        this._buckets[hashCode] = bucket2;
    }

    private SettableBeanProperty m11013a(String str, int i) {
        for (Bucket bucket = this._buckets[i]; bucket != null; bucket = bucket.next) {
            if (str.equals(bucket.key)) {
                return bucket.value;
            }
        }
        return null;
    }
}

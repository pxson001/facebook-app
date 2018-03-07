package com.facebook.thrift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: force_external_activity */
public class IntRangeSet implements Set<Integer> {
    public int[] f23491a;
    private Set<Integer> f23492b = new HashSet();

    public IntRangeSet(int... iArr) {
        Arrays.sort(iArr);
        List arrayList = new ArrayList();
        int i = iArr[0];
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            this.f23492b.add(Integer.valueOf(iArr[i3]));
            if (iArr[i3] == i2 + 1) {
                i2 = iArr[i3];
            } else {
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(i2));
                i = iArr[i3];
                i2 = iArr[i3];
            }
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(Integer.valueOf(i2));
        this.f23491a = new int[arrayList.size()];
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            this.f23491a[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        int intValue = ((Integer) obj).intValue();
        boolean z = false;
        int i = 0;
        while (i < this.f23491a.length / 2 && intValue >= this.f23491a[i * 2]) {
            if (intValue <= this.f23491a[(i * 2) + 1]) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f23492b.isEmpty();
    }

    public Iterator<Integer> iterator() {
        return this.f23492b.iterator();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f23492b.size();
    }

    public Object[] toArray() {
        return this.f23492b.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f23492b.toArray(tArr);
    }

    public String toString() {
        String str = "";
        int i = 0;
        while (i < this.f23491a.length / 2) {
            if (i != 0) {
                str = str + ", ";
            }
            String str2 = str + "[" + this.f23491a[i * 2] + "," + this.f23491a[(i * 2) + 1] + "]";
            i++;
            str = str2;
        }
        return str;
    }
}

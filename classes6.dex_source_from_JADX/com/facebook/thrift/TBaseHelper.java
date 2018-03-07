package com.facebook.thrift;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: selected_result_typeahead_type */
public final class TBaseHelper {
    private static final Comparator<Object> f5036a = new NestedStructureComparator();

    /* compiled from: selected_result_typeahead_type */
    class NestedStructureComparator implements Comparator<Object> {
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if ((obj instanceof List) && (obj2 instanceof List)) {
                return TBaseHelper.m7778a((List) obj, (List) obj2);
            }
            if ((obj instanceof Set) && (obj2 instanceof Set)) {
                return TBaseHelper.m7780a((Set) obj, (Set) obj2);
            }
            if ((obj instanceof Map) && (obj2 instanceof Map)) {
                return TBaseHelper.m7779a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return TBaseHelper.m7781a((byte[]) obj, (byte[]) obj2);
            }
            if ((obj instanceof Comparable) && (obj2 instanceof Comparable)) {
                return TBaseHelper.m7777a((Comparable) obj, (Comparable) obj2);
            }
            throw new IllegalArgumentException("cannot compare " + obj + " and " + obj2);
        }
    }

    private TBaseHelper() {
    }

    public static int m7777a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return m7777a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return m7778a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return m7780a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return m7779a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return m7781a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    private static int m7776a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i2 < i) {
            return 1;
        }
        return 0;
    }

    public static int m7781a(byte[] bArr, byte[] bArr2) {
        int a = m7776a(bArr.length, bArr2.length);
        if (a != 0) {
            return a;
        }
        for (a = 0; a < bArr.length; a++) {
            int i;
            byte b = bArr[a];
            byte b2 = bArr2[a];
            if (b < b2) {
                i = -1;
            } else if (b2 < b) {
                i = 1;
            } else {
                i = 0;
            }
            int i2 = i;
            if (i2 != 0) {
                return i2;
            }
        }
        return 0;
    }

    public static int m7778a(List<?> list, List<?> list2) {
        int a = m7776a(list.size(), list2.size());
        if (a != 0) {
            return a;
        }
        for (a = 0; a < list.size(); a++) {
            int compare = f5036a.compare(list.get(a), list2.get(a));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static <S, T> int m7780a(Set<S> set, Set<T> set2) {
        int a = m7776a(set.size(), set2.size());
        if (a != 0) {
            return a;
        }
        SortedSet treeSet = new TreeSet(f5036a);
        treeSet.addAll(set);
        SortedSet treeSet2 = new TreeSet(f5036a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            a = f5036a.compare(it.next(), it2.next());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static <S, T, U, V> int m7779a(Map<S, T> map, Map<U, V> map2) {
        int a = m7776a(map.size(), map2.size());
        if (a != 0) {
            return a;
        }
        SortedMap treeMap = new TreeMap(f5036a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        treeMap = new TreeMap(f5036a);
        treeMap.putAll(map2);
        Iterator it2 = treeMap.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            int compare = f5036a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            a = f5036a.compare(entry.getValue(), entry2.getValue());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    public static String m7782a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
        return stringBuilder.toString();
    }

    public static String m7784a(String str) {
        return str.length() > 1 ? str.substring(0, str.length() - 2) : "";
    }

    public static String m7783a(Object obj, int i, boolean z) {
        if (obj == null) {
            return "";
        }
        String a = z ? m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (obj instanceof Map) {
                stringBuilder.append("{");
                for (Entry entry : ((Map) obj).entrySet()) {
                    stringBuilder.append(str + a + m7783a(entry.getKey(), i + 2, z) + str2 + ":" + str2 + m7783a(entry.getValue(), i + 2, z));
                }
                stringBuilder.append(str + m7784a(a) + "}");
            } else if (obj instanceof Collection) {
                stringBuilder.append("[");
                for (Object a2 : (Collection) obj) {
                    stringBuilder.append(str + a + m7783a(a2, i + 2, z));
                }
                stringBuilder.append(str + m7784a(a) + "]");
            } else if (obj instanceof TBase) {
                stringBuilder.append(((TBase) obj).a(i, z));
            } else if (obj instanceof String) {
                if (z) {
                    stringBuilder.append("\"" + obj + "\"");
                } else {
                    stringBuilder.append(obj);
                }
            } else if (obj != null) {
                stringBuilder.append(obj.toString());
            }
        } catch (RuntimeException e) {
            stringBuilder.append("Exception occured :" + e.getClass() + e.getMessage());
        }
        return stringBuilder.toString();
    }
}

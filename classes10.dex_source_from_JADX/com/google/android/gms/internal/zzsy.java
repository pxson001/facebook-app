package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzsy {

    public class zza {
        public final zzsz f13105a;
        public final List<Asset> f13106b;

        public zza(zzsz com_google_android_gms_internal_zzsz, List<Asset> list) {
            this.f13105a = com_google_android_gms_internal_zzsz;
            this.f13106b = list;
        }
    }

    private static int m13203a(String str, com.google.android.gms.internal.zzsz.zza.zza[] com_google_android_gms_internal_zzsz_zza_zzaArr) {
        int i = 14;
        for (com.google.android.gms.internal.zzsz.zza.zza com_google_android_gms_internal_zzsz_zza_zza : com_google_android_gms_internal_zzsz_zza_zzaArr) {
            if (i == 14) {
                if (com_google_android_gms_internal_zzsz_zza_zza.f13122c == 9 || com_google_android_gms_internal_zzsz_zza_zza.f13122c == 2 || com_google_android_gms_internal_zzsz_zza_zza.f13122c == 6) {
                    i = com_google_android_gms_internal_zzsz_zza_zza.f13122c;
                } else if (com_google_android_gms_internal_zzsz_zza_zza.f13122c != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + com_google_android_gms_internal_zzsz_zza_zza.f13122c + " for key " + str);
                }
            } else if (com_google_android_gms_internal_zzsz_zza_zza.f13122c != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + com_google_android_gms_internal_zzsz_zza_zza.f13122c);
            }
        }
        return i;
    }

    public static zza m13204a(DataMap dataMap) {
        zzsz com_google_android_gms_internal_zzsz = new zzsz();
        List arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(dataMap.m13263b());
        com.google.android.gms.internal.zzsz.zza[] com_google_android_gms_internal_zzsz_zzaArr = new com.google.android.gms.internal.zzsz.zza[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object b = dataMap.m13262b(str);
            com_google_android_gms_internal_zzsz_zzaArr[i] = new com.google.android.gms.internal.zzsz.zza();
            com_google_android_gms_internal_zzsz_zzaArr[i].f13125c = str;
            com_google_android_gms_internal_zzsz_zzaArr[i].f13126d = m13205a(arrayList, b);
            i++;
        }
        com_google_android_gms_internal_zzsz.f13127c = com_google_android_gms_internal_zzsz_zzaArr;
        return new zza(com_google_android_gms_internal_zzsz, arrayList);
    }

    public static com.google.android.gms.internal.zzsz.zza.zza m13205a(List<Asset> list, Object obj) {
        com.google.android.gms.internal.zzsz.zza.zza com_google_android_gms_internal_zzsz_zza_zza = new com.google.android.gms.internal.zzsz.zza.zza();
        if (obj == null) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 14;
            return com_google_android_gms_internal_zzsz_zza_zza;
        }
        com_google_android_gms_internal_zzsz_zza_zza.f13123d = new com.google.android.gms.internal.zzsz.zza.zza.zza();
        if (obj instanceof String) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 2;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13108d = (String) obj;
        } else if (obj instanceof Integer) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 6;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13112h = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 5;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13111g = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 3;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13109e = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 4;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13110f = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 8;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13114j = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 7;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13113i = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 1;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13107c = (byte[]) obj;
        } else if (obj instanceof String[]) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 11;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13117m = (String[]) obj;
        } else if (obj instanceof long[]) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 12;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13118n = (long[]) obj;
        } else if (obj instanceof float[]) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 15;
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13119o = (float[]) obj;
        } else if (obj instanceof Asset) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 13;
            com.google.android.gms.internal.zzsz.zza.zza.zza com_google_android_gms_internal_zzsz_zza_zza_zza = com_google_android_gms_internal_zzsz_zza_zza.f13123d;
            list.add((Asset) obj);
            com_google_android_gms_internal_zzsz_zza_zza_zza.f13120p = (long) (list.size() - 1);
        } else if (obj instanceof DataMap) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.m13263b());
            com.google.android.gms.internal.zzsz.zza[] com_google_android_gms_internal_zzsz_zzaArr = new com.google.android.gms.internal.zzsz.zza[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                com_google_android_gms_internal_zzsz_zzaArr[r1] = new com.google.android.gms.internal.zzsz.zza();
                com_google_android_gms_internal_zzsz_zzaArr[r1].f13125c = str;
                com_google_android_gms_internal_zzsz_zzaArr[r1].f13126d = m13205a((List) list, dataMap.m13262b(str));
                r1++;
            }
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13115k = com_google_android_gms_internal_zzsz_zzaArr;
        } else if (obj instanceof ArrayList) {
            com_google_android_gms_internal_zzsz_zza_zza.f13122c = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.internal.zzsz.zza.zza[] com_google_android_gms_internal_zzsz_zza_zzaArr = new com.google.android.gms.internal.zzsz.zza.zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.internal.zzsz.zza.zza a = m13205a((List) list, obj3);
                if (a.f13122c == 14 || a.f13122c == 2 || a.f13122c == 6 || a.f13122c == 9) {
                    if (i2 == 14 && a.f13122c != 14) {
                        r1 = a.f13122c;
                    } else if (a.f13122c != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    com_google_android_gms_internal_zzsz_zza_zzaArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13116l = com_google_android_gms_internal_zzsz_zza_zzaArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return com_google_android_gms_internal_zzsz_zza_zza;
    }

    public static DataMap m13206a(zza com_google_android_gms_internal_zzsy_zza) {
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.zzsz.zza com_google_android_gms_internal_zzsz_zza : com_google_android_gms_internal_zzsy_zza.f13105a.f13127c) {
            m13208a(com_google_android_gms_internal_zzsy_zza.f13106b, dataMap, com_google_android_gms_internal_zzsz_zza.f13125c, com_google_android_gms_internal_zzsz_zza.f13126d);
        }
        return dataMap;
    }

    private static ArrayList m13207a(List<Asset> list, com.google.android.gms.internal.zzsz.zza.zza.zza com_google_android_gms_internal_zzsz_zza_zza_zza, int i) {
        ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzsz_zza_zza_zza.f13116l.length);
        for (com.google.android.gms.internal.zzsz.zza.zza com_google_android_gms_internal_zzsz_zza_zza : com_google_android_gms_internal_zzsz_zza_zza_zza.f13116l) {
            if (com_google_android_gms_internal_zzsz_zza_zza.f13122c == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.zzsz.zza com_google_android_gms_internal_zzsz_zza : com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13115k) {
                    m13208a(list, dataMap, com_google_android_gms_internal_zzsz_zza.f13125c, com_google_android_gms_internal_zzsz_zza.f13126d);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13108d);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzsz_zza_zza.f13123d.f13112h));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void m13208a(List<Asset> list, DataMap dataMap, String str, com.google.android.gms.internal.zzsz.zza.zza com_google_android_gms_internal_zzsz_zza_zza) {
        int i = com_google_android_gms_internal_zzsz_zza_zza.f13122c;
        if (i == 14) {
            dataMap.m13258a(str, null);
            return;
        }
        com.google.android.gms.internal.zzsz.zza.zza.zza com_google_android_gms_internal_zzsz_zza_zza_zza = com_google_android_gms_internal_zzsz_zza_zza.f13123d;
        if (i == 1) {
            dataMap.m13259a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13107c);
        } else if (i == 11) {
            dataMap.m13261a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13117m);
        } else if (i == 12) {
            dataMap.m13260a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13118n);
        } else if (i == 15) {
            dataMap.f13145a.put(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13119o);
        } else if (i == 2) {
            dataMap.m13258a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13108d);
        } else if (i == 3) {
            dataMap.f13145a.put(str, Double.valueOf(com_google_android_gms_internal_zzsz_zza_zza_zza.f13109e));
        } else if (i == 4) {
            dataMap.f13145a.put(str, Float.valueOf(com_google_android_gms_internal_zzsz_zza_zza_zza.f13110f));
        } else if (i == 5) {
            dataMap.m13256a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13111g);
        } else if (i == 6) {
            dataMap.m13255a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13112h);
        } else if (i == 7) {
            dataMap.f13145a.put(str, Byte.valueOf((byte) com_google_android_gms_internal_zzsz_zza_zza_zza.f13113i));
        } else if (i == 8) {
            dataMap.f13145a.put(str, Boolean.valueOf(com_google_android_gms_internal_zzsz_zza_zza_zza.f13114j));
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.m13257a(str, (Asset) list.get((int) com_google_android_gms_internal_zzsz_zza_zza_zza.f13120p));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.zzsz.zza com_google_android_gms_internal_zzsz_zza : com_google_android_gms_internal_zzsz_zza_zza_zza.f13115k) {
                m13208a(list, dataMap2, com_google_android_gms_internal_zzsz_zza.f13125c, com_google_android_gms_internal_zzsz_zza.f13126d);
            }
            dataMap.f13145a.put(str, dataMap2);
        } else if (i == 10) {
            i = m13203a(str, com_google_android_gms_internal_zzsz_zza_zza_zza.f13116l);
            ArrayList a = m13207a(list, com_google_android_gms_internal_zzsz_zza_zza_zza, i);
            if (i == 14) {
                dataMap.m13265c(str, a);
            } else if (i == 9) {
                dataMap.f13145a.put(str, a);
            } else if (i == 2) {
                dataMap.m13265c(str, a);
            } else if (i == 6) {
                dataMap.f13145a.put(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }
}

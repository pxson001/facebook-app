package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public static final PasswordSpecification f3621a = new zza().m3377a(12, 16).m3378a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").m3379a("abcdefghijkmnopqrstxyz", 1).m3379a("ABCDEFGHJKLMNPQRSTXY", 1).m3379a("3456789", 1).m3380a();
    public static final PasswordSpecification f3622b = new zza().m3377a(12, 16).m3378a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").m3379a("abcdefghijklmnopqrstuvwxyz", 1).m3379a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).m3379a("1234567890", 1).m3380a();
    public final int f3623c;
    public final String f3624d;
    public final List<String> f3625e;
    public final List<Integer> f3626f;
    public final int f3627g;
    public final int f3628h;
    private final int[] f3629i = m3381a();
    private final Random f3630j = new SecureRandom();

    public class zza {
        private final TreeSet<Character> f3616a = new TreeSet();
        private final List<String> f3617b = new ArrayList();
        private final List<Integer> f3618c = new ArrayList();
        private int f3619d = 12;
        private int f3620e = 16;

        private static TreeSet<Character> m3374a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                Object obj = (c < ' ' || c > '~') ? 1 : null;
                if (obj != null) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        private void m3375b() {
            int i = 0;
            for (Integer intValue : this.f3618c) {
                i = intValue.intValue() + i;
            }
            if (i > this.f3620e) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void m3376c() {
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.f3617b) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new zzb("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
        }

        public final zza m3377a(int i, int i2) {
            if (i <= 0) {
                throw new zzb("minimumSize must be at least 1");
            } else if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            } else {
                this.f3619d = i;
                this.f3620e = i2;
                return this;
            }
        }

        public final zza m3378a(String str) {
            this.f3616a.addAll(m3374a(str, "allowedChars"));
            return this;
        }

        public final zza m3379a(String str, int i) {
            if (i <= 0) {
                throw new zzb("count must be at least 1");
            }
            this.f3617b.add(PasswordSpecification.m3382b(m3374a(str, "requiredChars")));
            this.f3618c.add(Integer.valueOf(i));
            return this;
        }

        public final PasswordSpecification m3380a() {
            if (this.f3616a.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            m3375b();
            m3376c();
            return new PasswordSpecification(1, PasswordSpecification.m3382b(this.f3616a), this.f3617b, this.f3618c, this.f3619d, this.f3620e);
        }
    }

    public class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.f3623c = i;
        this.f3624d = str;
        this.f3625e = Collections.unmodifiableList(list);
        this.f3626f = Collections.unmodifiableList(list2);
        this.f3627g = i2;
        this.f3628h = i3;
    }

    private int[] m3381a() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.f3625e) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public static String m3382b(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, this.f3624d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1000, this.f3623c);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 2, this.f3625e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, this.f3626f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, this.f3627g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, this.f3628h);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, a);
    }
}

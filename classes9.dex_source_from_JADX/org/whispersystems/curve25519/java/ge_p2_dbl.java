package org.whispersystems.curve25519.java;

/* compiled from: add_pinned_thread */
public class ge_p2_dbl {
    public static void m21694a(ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1, ge_p2 org_whispersystems_curve25519_java_ge_p2) {
        int[] iArr = new int[10];
        fe_sq.m21682a(org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p2.f21229a);
        fe_sq.m21682a(org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p2.f21230b);
        fe_sq2.m21681a(org_whispersystems_curve25519_java_ge_p1p1.f21228d, org_whispersystems_curve25519_java_ge_p2.f21231c);
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p2.f21229a, org_whispersystems_curve25519_java_ge_p2.f21230b);
        fe_sq.m21682a(iArr, org_whispersystems_curve25519_java_ge_p1p1.f21226b);
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21225a);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21225a);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21225a, iArr, org_whispersystems_curve25519_java_ge_p1p1.f21226b);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21228d, org_whispersystems_curve25519_java_ge_p1p1.f21228d, org_whispersystems_curve25519_java_ge_p1p1.f21227c);
    }
}

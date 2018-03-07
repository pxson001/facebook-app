package org.whispersystems.curve25519.java;

/* compiled from: address_typeahead_drop */
public class ge_madd {
    public static void m21689a(ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1, ge_p3 org_whispersystems_curve25519_java_ge_p3, ge_precomp org_whispersystems_curve25519_java_ge_precomp) {
        int[] iArr = new int[10];
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_precomp.f21237a);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_precomp.f21238b);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p1p1.f21228d, org_whispersystems_curve25519_java_ge_precomp.f21239c, org_whispersystems_curve25519_java_ge_p3.f21235d);
        fe_add.m21666a(iArr, org_whispersystems_curve25519_java_ge_p3.f21234c, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21226b);
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21226b);
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_p1p1.f21227c, iArr, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_p1p1.f21228d, iArr, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
    }
}

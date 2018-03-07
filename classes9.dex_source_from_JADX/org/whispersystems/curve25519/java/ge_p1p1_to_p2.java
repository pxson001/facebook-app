package org.whispersystems.curve25519.java;

/* compiled from: address_country */
public class ge_p1p1_to_p2 {
    public static void m21691a(ge_p2 org_whispersystems_curve25519_java_ge_p2, ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1) {
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p2.f21229a, org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p2.f21230b, org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p1p1.f21227c);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p2.f21231c, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
    }
}

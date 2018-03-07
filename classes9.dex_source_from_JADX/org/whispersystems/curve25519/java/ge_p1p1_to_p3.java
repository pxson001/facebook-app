package org.whispersystems.curve25519.java;

/* compiled from: address_activity_state */
public class ge_p1p1_to_p3 {
    public static void m21692a(ge_p3 org_whispersystems_curve25519_java_ge_p3, ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1) {
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21232a, org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p1p1.f21226b, org_whispersystems_curve25519_java_ge_p1p1.f21227c);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21234c, org_whispersystems_curve25519_java_ge_p1p1.f21227c, org_whispersystems_curve25519_java_ge_p1p1.f21228d);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_p3.f21235d, org_whispersystems_curve25519_java_ge_p1p1.f21225a, org_whispersystems_curve25519_java_ge_p1p1.f21226b);
    }
}

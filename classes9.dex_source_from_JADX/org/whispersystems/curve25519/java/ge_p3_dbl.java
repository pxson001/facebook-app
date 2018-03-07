package org.whispersystems.curve25519.java;

/* compiled from: add_payment_method_tag */
public class ge_p3_dbl {
    public static void m21695a(ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1, ge_p3 org_whispersystems_curve25519_java_ge_p3) {
        ge_p2 org_whispersystems_curve25519_java_ge_p2 = new ge_p2();
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_p2.f21229a, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_p2.f21230b, org_whispersystems_curve25519_java_ge_p3.f21233b);
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_p2.f21231c, org_whispersystems_curve25519_java_ge_p3.f21234c);
        ge_p2_dbl.m21694a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p2);
    }
}

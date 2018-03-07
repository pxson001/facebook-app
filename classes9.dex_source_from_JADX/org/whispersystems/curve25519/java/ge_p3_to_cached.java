package org.whispersystems.curve25519.java;

/* compiled from: add_payment_card */
public class ge_p3_to_cached {
    static int[] f21236a = new int[]{-21827239, -5839606, -30745221, 13898782, 229458, 15978800, -12551817, -6495438, 29715968, 9444199};

    public static void m21696a(ge_cached org_whispersystems_curve25519_java_ge_cached, ge_p3 org_whispersystems_curve25519_java_ge_p3) {
        fe_add.m21666a(org_whispersystems_curve25519_java_ge_cached.f21218a, org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_sub.m21683a(org_whispersystems_curve25519_java_ge_cached.f21219b, org_whispersystems_curve25519_java_ge_p3.f21233b, org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_cached.f21220c, org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_mul.m21677a(org_whispersystems_curve25519_java_ge_cached.f21221d, org_whispersystems_curve25519_java_ge_p3.f21235d, f21236a);
    }
}

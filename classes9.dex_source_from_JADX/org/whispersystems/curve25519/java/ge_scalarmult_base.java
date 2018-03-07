package org.whispersystems.curve25519.java;

/* compiled from: add_admins_to_group */
public class ge_scalarmult_base {
    private static int m21699a(byte b, byte b2) {
        return ((b ^ b2) - 1) >>> 31;
    }

    private static int m21698a(byte b) {
        return (int) (((long) b) >>> 63);
    }

    private static void m21702a(ge_precomp org_whispersystems_curve25519_java_ge_precomp, ge_precomp org_whispersystems_curve25519_java_ge_precomp2, int i) {
        fe_cmov.m21667a(org_whispersystems_curve25519_java_ge_precomp.f21237a, org_whispersystems_curve25519_java_ge_precomp2.f21237a, i);
        fe_cmov.m21667a(org_whispersystems_curve25519_java_ge_precomp.f21238b, org_whispersystems_curve25519_java_ge_precomp2.f21238b, i);
        fe_cmov.m21667a(org_whispersystems_curve25519_java_ge_precomp.f21239c, org_whispersystems_curve25519_java_ge_precomp2.f21239c, i);
    }

    private static void m21701a(ge_precomp org_whispersystems_curve25519_java_ge_precomp, int i, byte b) {
        ge_precomp[][] org_whispersystems_curve25519_java_ge_precompArr = i <= 7 ? ge_precomp_base_0_7.f21240a : i <= 15 ? ge_precomp_base_8_15.f21243a : i <= 23 ? ge_precomp_base_16_23.f21241a : ge_precomp_base_24_31.f21242a;
        ge_precomp org_whispersystems_curve25519_java_ge_precomp2 = new ge_precomp();
        int a = m21698a(b);
        int i2 = b - (((-a) & b) << 1);
        fe_1.m21665a(org_whispersystems_curve25519_java_ge_precomp.f21237a);
        fe_1.m21665a(org_whispersystems_curve25519_java_ge_precomp.f21238b);
        fe_0.m21664a(org_whispersystems_curve25519_java_ge_precomp.f21239c);
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][0], m21699a((byte) i2, (byte) 1));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][1], m21699a((byte) i2, (byte) 2));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][2], m21699a((byte) i2, (byte) 3));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][3], m21699a((byte) i2, (byte) 4));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][4], m21699a((byte) i2, (byte) 5));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][5], m21699a((byte) i2, (byte) 6));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][6], m21699a((byte) i2, (byte) 7));
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precompArr[i][7], m21699a((byte) i2, (byte) 8));
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_precomp2.f21237a, org_whispersystems_curve25519_java_ge_precomp.f21238b);
        fe_copy.m21668a(org_whispersystems_curve25519_java_ge_precomp2.f21238b, org_whispersystems_curve25519_java_ge_precomp.f21237a);
        fe_neg.m21679a(org_whispersystems_curve25519_java_ge_precomp2.f21239c, org_whispersystems_curve25519_java_ge_precomp.f21239c);
        m21702a(org_whispersystems_curve25519_java_ge_precomp, org_whispersystems_curve25519_java_ge_precomp2, a);
    }

    public static void m21700a(ge_p3 org_whispersystems_curve25519_java_ge_p3, byte[] bArr) {
        int i;
        int i2 = 0;
        byte[] bArr2 = new byte[64];
        ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1 = new ge_p1p1();
        ge_p2 org_whispersystems_curve25519_java_ge_p2 = new ge_p2();
        ge_precomp org_whispersystems_curve25519_java_ge_precomp = new ge_precomp();
        for (i = 0; i < 32; i++) {
            bArr2[(i * 2) + 0] = (byte) ((bArr[i] >>> 0) & 15);
            bArr2[(i * 2) + 1] = (byte) ((bArr[i] >>> 4) & 15);
        }
        i = 0;
        for (int i3 = 0; i3 < 63; i3++) {
            bArr2[i3] = (byte) (i + bArr2[i3]);
            i = (byte) (((byte) (bArr2[i3] + 8)) >> 4);
            bArr2[i3] = (byte) (bArr2[i3] - (i << 4));
        }
        bArr2[63] = (byte) (i + bArr2[63]);
        fe_0.m21664a(org_whispersystems_curve25519_java_ge_p3.f21232a);
        fe_1.m21665a(org_whispersystems_curve25519_java_ge_p3.f21233b);
        fe_1.m21665a(org_whispersystems_curve25519_java_ge_p3.f21234c);
        fe_0.m21664a(org_whispersystems_curve25519_java_ge_p3.f21235d);
        for (i = 1; i < 64; i += 2) {
            m21701a(org_whispersystems_curve25519_java_ge_precomp, i / 2, bArr2[i]);
            ge_madd.m21689a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p3, org_whispersystems_curve25519_java_ge_precomp);
            ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p3, org_whispersystems_curve25519_java_ge_p1p1);
        }
        ge_p3_dbl.m21695a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p3);
        ge_p1p1_to_p2.m21691a(org_whispersystems_curve25519_java_ge_p2, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p2_dbl.m21694a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p2);
        ge_p1p1_to_p2.m21691a(org_whispersystems_curve25519_java_ge_p2, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p2_dbl.m21694a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p2);
        ge_p1p1_to_p2.m21691a(org_whispersystems_curve25519_java_ge_p2, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p2_dbl.m21694a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p2);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p3, org_whispersystems_curve25519_java_ge_p1p1);
        while (i2 < 64) {
            m21701a(org_whispersystems_curve25519_java_ge_precomp, i2 / 2, bArr2[i2]);
            ge_madd.m21689a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p3, org_whispersystems_curve25519_java_ge_precomp);
            ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p3, org_whispersystems_curve25519_java_ge_p1p1);
            i2 += 2;
        }
    }
}

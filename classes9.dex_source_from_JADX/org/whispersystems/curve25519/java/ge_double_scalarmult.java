package org.whispersystems.curve25519.java;

/* compiled from: adinterfaces_audience */
public class ge_double_scalarmult {
    static ge_precomp[] f21222a;

    private static void m21687a(byte[] bArr, byte[] bArr2) {
        int i;
        for (i = 0; i < 256; i++) {
            bArr[i] = (byte) ((bArr2[i >> 3] >>> (i & 7)) & 1);
        }
        int i2 = 0;
        while (i2 < 256) {
            if (bArr[i2] != (byte) 0) {
                int i3 = 1;
                while (i3 <= 6 && i2 + i3 < 256) {
                    if (bArr[i2 + i3] != (byte) 0) {
                        if (bArr[i2] + (bArr[i2 + i3] << i3) > 15) {
                            if (bArr[i2] - (bArr[i2 + i3] << i3) < -15) {
                                break;
                            }
                            bArr[i2] = (byte) (bArr[i2] - (bArr[i2 + i3] << i3));
                            i = i2 + i3;
                            while (i < 256) {
                                if (bArr[i] == (byte) 0) {
                                    bArr[i] = (byte) 1;
                                    break;
                                } else {
                                    bArr[i] = (byte) 0;
                                    i++;
                                }
                            }
                        } else {
                            bArr[i2] = (byte) (bArr[i2] + (bArr[i2 + i3] << i3));
                            bArr[i2 + i3] = (byte) 0;
                        }
                    }
                    i3++;
                }
            }
            i2++;
        }
    }

    static {
        r0 = new ge_precomp[8];
        f21222a = r0;
        r0[0] = new ge_precomp(new int[]{25967493, -14356035, 29566456, 3660896, -12694345, 4014787, 27544626, -11754271, -6079156, 2047605}, new int[]{-12545711, 934262, -2722910, 3049990, -727428, 9406986, 12720692, 5043384, 19500929, -15469378}, new int[]{-8738181, 4489570, 9688441, -14785194, 10184609, -12363380, 29287919, 11864899, -24514362, -4438546});
        f21222a[1] = new ge_precomp(new int[]{15636291, -9688557, 24204773, -7912398, 616977, -16685262, 27787600, -14772189, 28944400, -1550024}, new int[]{16568933, 4717097, -11556148, -1102322, 15682896, -11807043, 16354577, -11775962, 7689662, 11199574}, new int[]{30464156, -5976125, -11779434, -15670865, 23220365, 15915852, 7512774, 10017326, -17749093, -9920357});
        f21222a[2] = new ge_precomp(new int[]{10861363, 11473154, 27284546, 1981175, -30064349, 12577861, 32867885, 14515107, -15438304, 10819380}, new int[]{4708026, 6336745, 20377586, 9066809, -11272109, 6594696, -25653668, 12483688, -12668491, 5581306}, new int[]{19563160, 16186464, -29386857, 4097519, 10237984, -4348115, 28542350, 13850243, -23678021, -15815942});
        f21222a[3] = new ge_precomp(new int[]{5153746, 9909285, 1723747, -2777874, 30523605, 5516873, 19480852, 5230134, -23952439, -15175766}, new int[]{-30269007, -3463509, 7665486, 10083793, 28475525, 1649722, 20654025, 16520125, 30598449, 7715701}, new int[]{28881845, 14381568, 9657904, 3680757, -20181635, 7843316, -31400660, 1370708, 29794553, -1409300});
        f21222a[4] = new ge_precomp(new int[]{-22518993, -6692182, 14201702, -8745502, -23510406, 8844726, 18474211, -1361450, -13062696, 13821877}, new int[]{-6455177, -7839871, 3374702, -4740862, -27098617, -10571707, 31655028, -7212327, 18853322, -14220951}, new int[]{4566830, -12963868, -28974889, -12240689, -7602672, -2830569, -8514358, -10431137, 2207753, -3209784});
        f21222a[5] = new ge_precomp(new int[]{-25154831, -4185821, 29681144, 7868801, -6854661, -9423865, -12437364, -663000, -31111463, -16132436}, new int[]{25576264, -2703214, 7349804, -11814844, 16472782, 9300885, 3844789, 15725684, 171356, 6466918}, new int[]{23103977, 13316479, 9739013, -16149481, 817875, -15038942, 8965339, -14088058, -30714912, 16193877});
        f21222a[6] = new ge_precomp(new int[]{-33521811, 3180713, -2394130, 14003687, -16903474, -16270840, 17238398, 4729455, -18074513, 9256800}, new int[]{-25182317, -4174131, 32336398, 5036987, -21236817, 11360617, 22616405, 9761698, -19827198, 630305}, new int[]{-13720693, 2639453, -24237460, -7406481, 9494427, -5774029, -6554551, -15960994, -2449256, -14291300});
        f21222a[7] = new ge_precomp(new int[]{-3151181, -5046075, 9282714, 6866145, -31907062, -863023, -18940575, 15033784, 25105118, -7894876}, new int[]{-24326370, 15950226, -31801215, -14592823, -11662737, -5090925, 1573892, -2625887, 2198790, -15804619}, new int[]{-3099351, 10324967, -2241613, 7453183, -5446979, -2735503, -13812022, -16236442, -32461234, -12290683});
    }

    public static void m21686a(ge_p2 org_whispersystems_curve25519_java_ge_p2, byte[] bArr, ge_p3 org_whispersystems_curve25519_java_ge_p3, byte[] bArr2) {
        int i;
        byte[] bArr3 = new byte[256];
        byte[] bArr4 = new byte[256];
        ge_cached[] org_whispersystems_curve25519_java_ge_cachedArr = new ge_cached[8];
        for (i = 0; i < 8; i++) {
            org_whispersystems_curve25519_java_ge_cachedArr[i] = new ge_cached();
        }
        ge_p1p1 org_whispersystems_curve25519_java_ge_p1p1 = new ge_p1p1();
        ge_p3 org_whispersystems_curve25519_java_ge_p32 = new ge_p3();
        ge_p3 org_whispersystems_curve25519_java_ge_p33 = new ge_p3();
        m21687a(bArr3, bArr);
        m21687a(bArr4, bArr2);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[0], org_whispersystems_curve25519_java_ge_p3);
        ge_p3_dbl.m21695a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p3);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_p1p1);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[0]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[1], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[1]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[2], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[2]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[3], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[3]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[4], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[4]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[5], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[5]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[6], org_whispersystems_curve25519_java_ge_p32);
        ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p33, org_whispersystems_curve25519_java_ge_cachedArr[6]);
        ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
        ge_p3_to_cached.m21696a(org_whispersystems_curve25519_java_ge_cachedArr[7], org_whispersystems_curve25519_java_ge_p32);
        ge_p2_0.m21693a(org_whispersystems_curve25519_java_ge_p2);
        i = 255;
        while (i >= 0 && bArr3[i] == (byte) 0 && bArr4[i] == (byte) 0) {
            i--;
        }
        while (i >= 0) {
            ge_p2_dbl.m21694a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p2);
            if (bArr3[i] > (byte) 0) {
                ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
                ge_add.m21685a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_cachedArr[bArr3[i] / 2]);
            } else if (bArr3[i] < (byte) 0) {
                ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
                ge_sub.m21703a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_cachedArr[(-bArr3[i]) / 2]);
            }
            if (bArr4[i] > (byte) 0) {
                ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
                ge_madd.m21689a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p32, f21222a[bArr4[i] / 2]);
            } else if (bArr4[i] < (byte) 0) {
                ge_p1p1_to_p3.m21692a(org_whispersystems_curve25519_java_ge_p32, org_whispersystems_curve25519_java_ge_p1p1);
                ge_msub.m21690a(org_whispersystems_curve25519_java_ge_p1p1, org_whispersystems_curve25519_java_ge_p32, f21222a[(-bArr4[i]) / 2]);
            }
            ge_p1p1_to_p2.m21691a(org_whispersystems_curve25519_java_ge_p2, org_whispersystems_curve25519_java_ge_p1p1);
            i--;
        }
    }
}

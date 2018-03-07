package org.whispersystems.curve25519.java;

/* compiled from: admin_ids */
public class fe_pow22523 {
    public static void m21680a(int[] iArr, int[] iArr2) {
        int i;
        int i2 = 1;
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        fe_sq.m21682a(iArr3, iArr2);
        fe_sq.m21682a(iArr4, iArr3);
        for (i = 1; i < 2; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr4, iArr2, iArr4);
        fe_mul.m21677a(iArr3, iArr3, iArr4);
        fe_sq.m21682a(iArr3, iArr3);
        fe_mul.m21677a(iArr3, iArr4, iArr3);
        fe_sq.m21682a(iArr4, iArr3);
        for (i = 1; i < 5; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr3, iArr4, iArr3);
        fe_sq.m21682a(iArr4, iArr3);
        for (i = 1; i < 10; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr4, iArr4, iArr3);
        fe_sq.m21682a(iArr5, iArr4);
        for (i = 1; i < 20; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr4, iArr5, iArr4);
        fe_sq.m21682a(iArr4, iArr4);
        for (i = 1; i < 10; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr3, iArr4, iArr3);
        fe_sq.m21682a(iArr4, iArr3);
        for (i = 1; i < 50; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr4, iArr4, iArr3);
        fe_sq.m21682a(iArr5, iArr4);
        for (i = 1; i < 100; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr4, iArr5, iArr4);
        fe_sq.m21682a(iArr4, iArr4);
        for (i = 1; i < 50; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr3, iArr4, iArr3);
        fe_sq.m21682a(iArr3, iArr3);
        while (i2 < 2) {
            fe_sq.m21682a(iArr3, iArr3);
            i2++;
        }
        fe_mul.m21677a(iArr, iArr3, iArr2);
    }
}

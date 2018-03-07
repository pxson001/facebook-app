package org.whispersystems.curve25519.java;

/* compiled from: admin_text_nickname */
public class fe_invert {
    public static void m21673a(int[] iArr, int[] iArr2) {
        int i;
        int i2 = 1;
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        fe_sq.m21682a(iArr3, iArr2);
        fe_sq.m21682a(iArr4, iArr3);
        for (i = 1; i < 2; i++) {
            fe_sq.m21682a(iArr4, iArr4);
        }
        fe_mul.m21677a(iArr4, iArr2, iArr4);
        fe_mul.m21677a(iArr3, iArr3, iArr4);
        fe_sq.m21682a(iArr5, iArr3);
        fe_mul.m21677a(iArr4, iArr4, iArr5);
        fe_sq.m21682a(iArr5, iArr4);
        for (i = 1; i < 5; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr4, iArr5, iArr4);
        fe_sq.m21682a(iArr5, iArr4);
        for (i = 1; i < 10; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr5, iArr5, iArr4);
        fe_sq.m21682a(iArr6, iArr5);
        for (i = 1; i < 20; i++) {
            fe_sq.m21682a(iArr6, iArr6);
        }
        fe_mul.m21677a(iArr5, iArr6, iArr5);
        fe_sq.m21682a(iArr5, iArr5);
        for (i = 1; i < 10; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr4, iArr5, iArr4);
        fe_sq.m21682a(iArr5, iArr4);
        for (i = 1; i < 50; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr5, iArr5, iArr4);
        fe_sq.m21682a(iArr6, iArr5);
        for (i = 1; i < 100; i++) {
            fe_sq.m21682a(iArr6, iArr6);
        }
        fe_mul.m21677a(iArr5, iArr6, iArr5);
        fe_sq.m21682a(iArr5, iArr5);
        for (i = 1; i < 50; i++) {
            fe_sq.m21682a(iArr5, iArr5);
        }
        fe_mul.m21677a(iArr4, iArr5, iArr4);
        fe_sq.m21682a(iArr4, iArr4);
        while (i2 < 5) {
            fe_sq.m21682a(iArr4, iArr4);
            i2++;
        }
        fe_mul.m21677a(iArr, iArr4, iArr3);
    }
}

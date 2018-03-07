package com.facebook.debug.asserts;

import com.facebook.common.build.BuildConstants;

/* compiled from: sender_fbid */
public class Assert {
    public static void m9533a(int i, int i2) {
        if (m9536a()) {
            junit.framework.Assert.assertEquals(i, i2);
        }
    }

    public static boolean m9536a() {
        return BuildConstants.i;
    }

    public static void m9534a(Object obj) {
        if (m9536a()) {
            junit.framework.Assert.assertNotNull(obj);
        }
    }

    public static void m9537b(Object obj) {
        if (m9536a()) {
            junit.framework.Assert.assertNull(obj);
        }
    }

    public static void m9535a(boolean z) {
        if (m9536a()) {
            junit.framework.Assert.assertTrue(z);
        }
    }
}

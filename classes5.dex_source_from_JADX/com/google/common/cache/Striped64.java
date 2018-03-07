package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* compiled from: campaign */
public abstract class Striped64 extends Number {
    static final ThreadLocal<int[]> f7240a = new ThreadLocal();
    static final Random f7241b = new Random();
    static final int f7242c = Runtime.getRuntime().availableProcessors();
    private static final Unsafe f7243g;
    private static final long f7244h;
    private static final long f7245i;
    volatile transient Cell[] f7246d;
    volatile transient long f7247e;
    volatile transient int f7248f;

    /* compiled from: campaign */
    final class C08071 implements PrivilegedExceptionAction<Unsafe> {
        C08071() {
        }

        public final Object run() {
            Class cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (cls.isInstance(obj)) {
                    return (Unsafe) cls.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* compiled from: campaign */
    final class Cell {
        private static final Unsafe f7252b;
        private static final long f7253c;
        volatile long f7254a;

        Cell(long j) {
            this.f7254a = j;
        }

        final boolean m13188a(long j, long j2) {
            return f7252b.compareAndSwapLong(this, f7253c, j, j2);
        }

        static {
            try {
                f7252b = Striped64.m13180c();
                f7253c = f7252b.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    abstract long mo876a(long j, long j2);

    static {
        try {
            f7243g = m13180c();
            Class cls = Striped64.class;
            f7244h = f7243g.objectFieldOffset(cls.getDeclaredField("base"));
            f7245i = f7243g.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    final boolean m13183b(long j, long j2) {
        return f7243g.compareAndSwapLong(this, f7244h, j, j2);
    }

    private boolean mo874a() {
        return f7243g.compareAndSwapInt(this, f7245i, 0, 1);
    }

    final void m13182a(long j, int[] iArr, boolean z) {
        int nextInt;
        if (iArr == null) {
            iArr = new int[1];
            f7240a.set(iArr);
            nextInt = f7241b.nextInt();
            if (nextInt == 0) {
                nextInt = 1;
            }
            iArr[0] = nextInt;
        } else {
            nextInt = iArr[0];
        }
        Object obj = null;
        while (true) {
            Object obj2;
            Cell[] cellArr = this.f7246d;
            if (cellArr != null) {
                int length = cellArr.length;
                if (length > 0) {
                    Cell cell = cellArr[(length - 1) & nextInt];
                    Cell[] cellArr2;
                    if (cell == null) {
                        if (this.f7248f == 0) {
                            Cell cell2 = new Cell(j);
                            if (this.f7248f == 0 && mo874a()) {
                                obj2 = null;
                                try {
                                    cellArr2 = this.f7246d;
                                    if (cellArr2 != null) {
                                        int length2 = cellArr2.length;
                                        if (length2 > 0) {
                                            length2 = (length2 - 1) & nextInt;
                                            if (cellArr2[length2] == null) {
                                                cellArr2[length2] = cell2;
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    this.f7248f = 0;
                                    if (obj2 != null) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    this.f7248f = 0;
                                }
                            }
                        }
                        obj = null;
                    } else if (z) {
                        long j2 = cell.f7254a;
                        if (!cell.m13188a(j2, mo876a(j2, j))) {
                            if (length >= f7242c || this.f7246d != cellArr) {
                                obj = null;
                            } else if (obj == null) {
                                obj = 1;
                            } else if (this.f7248f == 0 && mo874a()) {
                                try {
                                    if (this.f7246d == cellArr) {
                                        cellArr2 = new Cell[(length << 1)];
                                        for (int i = 0; i < length; i++) {
                                            cellArr2[i] = cellArr[i];
                                        }
                                        this.f7246d = cellArr2;
                                    }
                                    this.f7248f = 0;
                                    obj = null;
                                } catch (Throwable th2) {
                                    this.f7248f = 0;
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        z = true;
                    }
                    nextInt ^= nextInt << 13;
                    nextInt ^= nextInt >>> 17;
                    nextInt ^= nextInt << 5;
                    iArr[0] = nextInt;
                }
            }
            if (this.f7248f == 0 && this.f7246d == cellArr && mo874a()) {
                obj2 = null;
                try {
                    if (this.f7246d == cellArr) {
                        Cell[] cellArr3 = new Cell[2];
                        cellArr3[nextInt & 1] = new Cell(j);
                        this.f7246d = cellArr3;
                        obj2 = 1;
                    }
                    this.f7248f = 0;
                    if (obj2 != null) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.f7248f = 0;
                }
            } else {
                long j3 = this.f7247e;
                if (m13183b(j3, mo876a(j3, j))) {
                    return;
                }
            }
        }
    }

    public static Unsafe m13180c() {
        Unsafe unsafe;
        try {
            unsafe = Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                unsafe = (Unsafe) AccessController.doPrivileged(new C08071());
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
        return unsafe;
    }
}

package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;

/* compiled from: bluetooth.at */
public class SerializedObserver<T> implements Observer<T> {
    private static final Object f7898e = new Object();
    private static final Object f7899f = new Object();
    private final Observer<? super T> f7900a;
    private boolean f7901b = false;
    private boolean f7902c = false;
    private FastList f7903d;

    /* compiled from: bluetooth.at */
    final class ErrorSentinel {
        final Throwable f7895a;

        ErrorSentinel(Throwable th) {
            this.f7895a = th;
        }
    }

    /* compiled from: bluetooth.at */
    final class FastList {
        Object[] f7896a;
        int f7897b;

        FastList() {
        }

        public final void m14042a(Object obj) {
            Object[] objArr;
            int i = this.f7897b;
            Object obj2 = this.f7896a;
            if (obj2 == null) {
                objArr = new Object[16];
                this.f7896a = objArr;
            } else if (i == obj2.length) {
                objArr = new Object[((i >> 2) + i)];
                System.arraycopy(obj2, 0, objArr, 0, i);
                this.f7896a = objArr;
            } else {
                Object obj3 = obj2;
            }
            objArr[i] = obj;
            this.f7897b = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.f7900a = observer;
    }

    public final void N_() {
        synchronized (this) {
            if (this.f7902c) {
                return;
            }
            this.f7902c = true;
            if (this.f7901b) {
                if (this.f7903d == null) {
                    this.f7903d = new FastList();
                }
                this.f7903d.m14042a(f7899f);
                return;
            }
            this.f7901b = true;
            FastList fastList = this.f7903d;
            this.f7903d = null;
            m14043a(fastList);
            this.f7900a.N_();
        }
    }

    public final void m14045a(Throwable th) {
        Exceptions.m13874b(th);
        synchronized (this) {
            if (this.f7902c) {
            } else if (this.f7901b) {
                if (this.f7903d == null) {
                    this.f7903d = new FastList();
                }
                this.f7903d.m14042a(new ErrorSentinel(th));
            } else {
                this.f7901b = true;
                FastList fastList = this.f7903d;
                this.f7903d = null;
                m14043a(fastList);
                this.f7900a.a(th);
                synchronized (this) {
                    this.f7901b = false;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m14044a(T r8) {
        /*
        r7 = this;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 1;
        r2 = 0;
        r0 = 0;
        monitor-enter(r7);
        r3 = r7.f7902c;	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
    L_0x000c:
        return;
    L_0x000d:
        r3 = r7.f7901b;	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x002b;
    L_0x0011:
        r0 = r7.f7903d;	 Catch:{ all -> 0x0025 }
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new rx.observers.SerializedObserver$FastList;	 Catch:{ all -> 0x0025 }
        r0.<init>();	 Catch:{ all -> 0x0025 }
        r7.f7903d = r0;	 Catch:{ all -> 0x0025 }
    L_0x001c:
        r0 = r7.f7903d;	 Catch:{ all -> 0x0025 }
        if (r8 == 0) goto L_0x0028;
    L_0x0020:
        r0.m14042a(r8);	 Catch:{ all -> 0x0025 }
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
        goto L_0x000c;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r8 = f7898e;	 Catch:{  }
        goto L_0x0020;
    L_0x002b:
        r3 = 1;
        r7.f7901b = r3;	 Catch:{  }
        r3 = r7.f7903d;	 Catch:{  }
        r4 = 0;
        r7.f7903d = r4;	 Catch:{  }
        monitor-exit(r7);	 Catch:{  }
        r4 = r5;
    L_0x0035:
        r7.m14043a(r3);	 Catch:{ all -> 0x0081 }
        if (r4 != r5) goto L_0x003f;
    L_0x003a:
        r6 = r7.f7900a;	 Catch:{ all -> 0x0081 }
        r6.a(r8);	 Catch:{ all -> 0x0081 }
    L_0x003f:
        r4 = r4 + -1;
        if (r4 <= 0) goto L_0x0062;
    L_0x0043:
        monitor-enter(r7);	 Catch:{ all -> 0x0081 }
        r3 = r7.f7903d;	 Catch:{ all -> 0x0083 }
        r6 = 0;
        r7.f7903d = r6;	 Catch:{ all -> 0x0083 }
        if (r3 != 0) goto L_0x0061;
    L_0x004b:
        r0 = 0;
        r7.f7901b = r0;	 Catch:{ all -> 0x0083 }
        monitor-exit(r7);	 Catch:{ all -> 0x0050 }
        goto L_0x000c;
    L_0x0050:
        r0 = move-exception;
    L_0x0051:
        monitor-exit(r7);	 Catch:{ all -> 0x0050 }
        throw r0;	 Catch:{ all -> 0x0053 }
    L_0x0053:
        r0 = move-exception;
        r2 = r1;
    L_0x0055:
        if (r2 != 0) goto L_0x0060;
    L_0x0057:
        monitor-enter(r7);
        r1 = r7.f7902c;	 Catch:{ all -> 0x007e }
        if (r1 == 0) goto L_0x007a;
    L_0x005c:
        r1 = 0;
        r7.f7903d = r1;	 Catch:{ all -> 0x007e }
    L_0x005f:
        monitor-exit(r7);	 Catch:{ all -> 0x007e }
    L_0x0060:
        throw r0;
    L_0x0061:
        monitor-exit(r7);	 Catch:{  }
    L_0x0062:
        if (r4 > 0) goto L_0x0035;
    L_0x0064:
        monitor-enter(r7);
        r1 = r7.f7902c;	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0073;
    L_0x0069:
        r0 = r7.f7903d;	 Catch:{ all -> 0x0077 }
        r1 = 0;
        r7.f7903d = r1;	 Catch:{ all -> 0x0077 }
    L_0x006e:
        monitor-exit(r7);	 Catch:{ all -> 0x0077 }
        r7.m14043a(r0);
        goto L_0x000c;
    L_0x0073:
        r1 = 0;
        r7.f7901b = r1;	 Catch:{  }
        goto L_0x006e;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{  }
        throw r0;
    L_0x007a:
        r1 = 0;
        r7.f7901b = r1;	 Catch:{  }
        goto L_0x005f;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{  }
        throw r0;
    L_0x0081:
        r0 = move-exception;
        goto L_0x0055;
    L_0x0083:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.observers.SerializedObserver.a(java.lang.Object):void");
    }

    private void m14043a(FastList fastList) {
        if (fastList != null && fastList.f7897b != 0) {
            Object[] objArr = fastList.f7896a;
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                if (obj != null) {
                    if (obj == f7898e) {
                        this.f7900a.a(null);
                    } else if (obj == f7899f) {
                        this.f7900a.N_();
                    } else if (obj.getClass() == ErrorSentinel.class) {
                        this.f7900a.a(((ErrorSentinel) obj).f7895a);
                    } else {
                        this.f7900a.a(obj);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}

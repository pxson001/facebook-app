package com.facebook.tigon.httpclientadapter;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: notWaiting */
public class TigonStateMachine {
    private static final String[] f4995a = new String[]{"start", "executing", "got_result", "got_exception", "done", "fail"};
    private static final String[] f4996b = new String[]{"start", "got_eom", "got_error", "done", "fail"};
    private static final String[] f4997c = new String[]{"handler_start", "got_result", "got_exception", "retry", "eom", "error", "none", "request_started", "handler_complete", "response", "body", "upload"};
    private static final byte[][] f4998d = new byte[][]{new byte[]{(byte) 1, (byte) 5, (byte) 5, (byte) -1, (byte) -1, (byte) 4}, new byte[]{(byte) 5, (byte) 2, (byte) 3, (byte) 0, (byte) -1, (byte) -1}, new byte[]{(byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4}, new byte[]{(byte) 5, (byte) 5, (byte) 5, (byte) 0, (byte) 4, (byte) 4}, new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1}, new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1}};
    private static final byte[][] f4999e = new byte[][]{new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 1, (byte) 2}, new byte[]{(byte) -1, (byte) 3, (byte) 3, (byte) 0, (byte) 4, (byte) 4}, new byte[]{(byte) -1, (byte) 3, (byte) 3, (byte) 0, (byte) 4, (byte) 4}, new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1}, new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1}};
    private TigonRequestState f5000f;
    private byte f5001g = (byte) 0;
    private byte f5002h = (byte) 0;
    private long f5003i;
    private byte f5004j;
    private ByteArrayOutputStream f5005k;
    private DataOutputStream f5006l;

    TigonStateMachine(TigonRequestState tigonRequestState) {
        this.f5000f = tigonRequestState;
        this.f5003i = System.nanoTime();
        this.f5005k = new ByteArrayOutputStream();
        this.f5006l = new DataOutputStream(this.f5005k);
        m6288a((byte) 6);
    }

    final synchronized boolean m6295a() {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            if (this.f5001g == (byte) 4 || this.f5002h == (byte) 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3;
            if (this.f5001g == (byte) 5 || this.f5002h == (byte) 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z2 || r2) {
                z = false;
            }
        }
        return z;
    }

    final synchronized long m6296b() {
        return this.f5003i;
    }

    final synchronized byte m6297c() {
        return this.f5001g;
    }

    final synchronized String m6298d() {
        return m6292e(this.f5001g);
    }

    final synchronized byte m6299e() {
        return this.f5002h;
    }

    final synchronized String m6300f() {
        return m6291d(this.f5002h);
    }

    final void m6301g() {
        m6289b((byte) 0);
    }

    final void m6302h() {
        m6289b((byte) 1);
    }

    final void m6303i() {
        m6289b((byte) 2);
    }

    final void m6304j() {
        m6289b((byte) 3);
    }

    final void m6305k() {
        m6289b((byte) 4);
    }

    final void m6306l() {
        m6289b((byte) 5);
    }

    final void m6307m() {
        m6288a((byte) 7);
    }

    final void m6308n() {
        m6288a((byte) 8);
    }

    final void m6309o() {
        m6288a((byte) 9);
    }

    final void m6310p() {
        m6288a((byte) 10);
    }

    public final void m6311q() {
        m6288a((byte) 11);
    }

    private synchronized void m6288a(byte b) {
        Object obj = (b == (byte) 10 || b == (byte) 11) ? 1 : null;
        if (b != this.f5004j || obj == null) {
            this.f5004j = b;
            m6290c(b);
            m6294s();
        }
    }

    private synchronized void m6289b(byte b) {
        boolean z = true;
        synchronized (this) {
            m6290c(b);
            this.f5004j = b;
            boolean z2 = this.f5001g >= (byte) 0 && this.f5001g < f4998d.length;
            Preconditions.checkState(z2);
            if (this.f5002h < (byte) 0 || this.f5002h >= f4999e.length) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkState(z2);
            if (b < (byte) 0 || b >= f4998d[this.f5001g].length) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkArgument(z2);
            if (b < (byte) 0 || b >= f4999e[this.f5002h].length) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkArgument(z2);
            byte b2 = this.f5001g;
            byte b3 = this.f5002h;
            byte b4 = f4998d[this.f5001g][b];
            byte b5 = f4999e[this.f5002h][b];
            if (b4 != (byte) -1) {
                this.f5001g = b4;
            }
            if (b5 != (byte) -1) {
                this.f5002h = b5;
            }
            m6294s();
            z2 = this.f5001g >= (byte) 0 && this.f5001g < f4998d.length;
            Preconditions.checkState(z2);
            if (this.f5002h < (byte) 0 || this.f5002h >= f4999e.length) {
                z = false;
            }
            Preconditions.checkState(z);
            this.f5000f.m6259a(b2, b3, this.f5001g, this.f5002h);
        }
    }

    private void m6290c(byte b) {
        try {
            this.f5006l.writeLong(System.nanoTime());
            this.f5006l.writeByte(b);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private void m6294s() {
        try {
            this.f5006l.writeByte(this.f5001g);
            this.f5006l.writeByte(this.f5002h);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    final synchronized String m6312r() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.f5005k.toByteArray()));
            while (dataInputStream.available() > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" |");
                }
                stringBuilder.append(' ').append(TimeUnit.NANOSECONDS.toMillis(dataInputStream.readLong() - this.f5003i));
                stringBuilder.append(' ').append(m6293f(dataInputStream.readByte()));
                stringBuilder.append(' ').append(m6292e(dataInputStream.readByte()));
                stringBuilder.append(' ').append(m6291d(dataInputStream.readByte()));
            }
        } catch (EOFException e) {
            stringBuilder.append(" ... unexpected EOF");
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
        return stringBuilder.toString();
    }

    private static String m6291d(byte b) {
        return m6287a(b, f4996b);
    }

    private static String m6292e(byte b) {
        return m6287a(b, f4995a);
    }

    @VisibleForTesting
    private static String m6293f(byte b) {
        return m6287a(b, f4997c);
    }

    private static String m6287a(byte b, String[] strArr) {
        Object obj = (b < (byte) 0 || b >= strArr.length) ? null : 1;
        return obj != null ? strArr[b] : "out of range (" + b + ")";
    }
}

package com.facebook.graphql.model;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.debug.log.BLog;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: TV_SHOWS */
public class OfflinePostProgressController {
    @VisibleForTesting
    static final Long f13483a = Long.valueOf(1000);
    private static final String f13484b = OfflinePostProgressController.class.getSimpleName();
    private static final ProgressFunction f13485l = new C12791();
    private static final ProgressFunction f13486m = new C12802();
    public Mode f13487c;
    private int f13488d;
    private int f13489e;
    private SetPoint f13490f;
    private long f13491g = 10000;
    private long f13492h = 10000;
    private long f13493i = 10000;
    private long f13494j;
    public boolean f13495k = false;

    /* compiled from: TV_SHOWS */
    abstract class ProgressFunction {
        protected abstract int mo1232a(long j, int i, long j2);

        public final int m22554a(long j, int i, long j2, SetPoint setPoint) {
            return mo1232a(j - setPoint.f13481a, i - setPoint.f13482b, j2) + setPoint.f13482b;
        }
    }

    /* compiled from: TV_SHOWS */
    final class C12791 extends ProgressFunction {
        C12791() {
        }

        protected final int mo1232a(long j, int i, long j2) {
            return j >= j2 ? i : Math.max(0, Math.min(i, (int) (((((long) (i * 2)) * j) / j2) - (((((long) i) * j) * j) / (j2 * j2)))));
        }
    }

    /* compiled from: TV_SHOWS */
    final class C12802 extends ProgressFunction {
        C12802() {
        }

        protected final int mo1232a(long j, int i, long j2) {
            return j >= j2 ? i : Math.max(0, Math.min(i, (int) (((((long) i) * j) * j) / (j2 * j2))));
        }
    }

    /* compiled from: TV_SHOWS */
    /* synthetic */ class C12813 {
        static final /* synthetic */ int[] f13480a = new int[Mode.values().length];

        static {
            try {
                f13480a[Mode.BEFORE_START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13480a[Mode.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13480a[Mode.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13480a[Mode.FINISHING_UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13480a[Mode.ALMOST_DONE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: TV_SHOWS */
    public enum Mode {
        BEFORE_START,
        RUNNING,
        FINISHING_UP,
        ALMOST_DONE,
        DONE
    }

    /* compiled from: TV_SHOWS */
    class SetPoint {
        public final long f13481a;
        public final int f13482b;

        public SetPoint(long j, int i) {
            boolean z;
            boolean z2 = true;
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            if (i < 0) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            this.f13481a = j;
            this.f13482b = i;
        }
    }

    public OfflinePostProgressController() {
        m22558a();
    }

    public final void m22560a(long j, long j2, long j3) {
        if (!m22562b()) {
            this.f13491g = j;
            this.f13493i = j2;
            this.f13492h = j3;
        }
    }

    public final void m22559a(long j, int i) {
        boolean z = true;
        Preconditions.checkState(!m22565e(), "Already started");
        if (i > 1000) {
            z = false;
        }
        Preconditions.checkArgument(z, "progressLimit is too high: " + i);
        this.f13488d = i;
        this.f13489e = -1;
        this.f13494j = -1;
        this.f13490f = new SetPoint(j, 0);
        this.f13487c = Mode.RUNNING;
    }

    public final void m22558a() {
        this.f13488d = 0;
        this.f13489e = -1;
        this.f13494j = -1;
        this.f13490f = new SetPoint(0, 0);
        this.f13487c = Mode.BEFORE_START;
    }

    public final boolean m22562b() {
        return this.f13487c == Mode.RUNNING || this.f13487c == Mode.FINISHING_UP || this.f13487c == Mode.ALMOST_DONE;
    }

    public final boolean m22564d() {
        return this.f13487c != Mode.BEFORE_START;
    }

    public final boolean m22565e() {
        return this.f13487c == Mode.RUNNING;
    }

    public final void m22563c(long j, int i) {
        Preconditions.checkState(m22565e(), "Not running");
        Preconditions.checkArgument(i <= 1000, "progressLimit is too high: " + i);
        if (i < this.f13488d) {
            BLog.b(f13484b, "Progress limit decreased! old=" + this.f13488d + ", new=" + i);
        } else if (i != this.f13488d) {
            this.f13490f = new SetPoint(j, m22561b(j));
            this.f13488d = i;
            if (this.f13494j > 0) {
                this.f13491g = Math.max(Math.min(j - this.f13494j, this.f13492h), this.f13493i);
            }
            this.f13494j = j;
        }
    }

    public final int m22561b(long j) {
        boolean z = false;
        switch (C12813.f13480a[this.f13487c.ordinal()]) {
            case 1:
                return 0;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return 1000;
            case 3:
                return m22557a(j, f13485l, this.f13491g);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (this.f13488d == 1000) {
                    z = true;
                }
                Preconditions.checkState(z);
                int a = m22557a(j, f13486m, f13483a.longValue());
                if (a != 1000) {
                    return a;
                }
                this.f13487c = Mode.ALMOST_DONE;
                return a;
            case 5:
                this.f13487c = Mode.DONE;
                return 1000;
            default:
                throw new IllegalStateException("Unknown mode: " + this.f13487c);
        }
    }

    private int m22557a(long j, ProgressFunction progressFunction, long j2) {
        int max = Math.max(this.f13489e, progressFunction.m22554a(j, this.f13488d, j2, this.f13490f));
        this.f13489e = max;
        return max;
    }
}

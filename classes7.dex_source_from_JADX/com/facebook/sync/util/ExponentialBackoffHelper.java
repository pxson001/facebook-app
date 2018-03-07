package com.facebook.sync.util;

import com.google.common.annotations.VisibleForTesting;
import java.util.Random;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: feedback_disable_commenting */
public class ExponentialBackoffHelper<RETURN_TYPE> {
    private final long f14561a;
    private final long f14562b;
    private final ExponentialBackoffOperation<RETURN_TYPE> f14563c;
    private final Random f14564d;

    /* compiled from: feedback_disable_commenting */
    public interface ExponentialBackoffOperation<RETURN_TYPE> {
        ExecutionResult<RETURN_TYPE> mo1146a();

        void mo1147a(long j);
    }

    @Immutable
    /* compiled from: feedback_disable_commenting */
    public class ExecutionResult<RETURN_TYPE> {
        public final boolean f14559a;
        @Nullable
        public final RETURN_TYPE f14560b;

        public ExecutionResult(boolean z, @Nullable RETURN_TYPE return_type) {
            this.f14559a = z;
            this.f14560b = return_type;
        }
    }

    @VisibleForTesting
    ExponentialBackoffHelper(long j, long j2, ExponentialBackoffOperation<RETURN_TYPE> exponentialBackoffOperation, Random random) {
        this.f14561a = j;
        this.f14562b = j2;
        this.f14563c = exponentialBackoffOperation;
        this.f14564d = random;
    }

    @Nullable
    public final RETURN_TYPE m18447a() {
        int i = 0;
        long j = 0;
        RETURN_TYPE return_type = null;
        while (i < 20) {
            if (j > 0) {
                Thread.sleep((long) ((int) ((0.5d + ((double) this.f14564d.nextFloat())) * ((double) j))));
            }
            ExecutionResult a = this.f14563c.mo1146a();
            if (!a.f14559a) {
                return a.f14560b;
            }
            long j2;
            RETURN_TYPE return_type2 = a.f14560b;
            if (j == 0) {
                j2 = this.f14562b;
            } else {
                j2 = Math.min(2 * j, this.f14561a);
            }
            this.f14563c.mo1147a(j2);
            i++;
            j = j2;
            return_type = return_type2;
        }
        return return_type;
    }
}

package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@GwtCompatible
@Beta
/* compiled from: zeroUpdateStatus */
public abstract class Ticker {
    public static final Ticker SYSTEM_TICKER = new C00251();

    /* compiled from: zeroUpdateStatus */
    final class C00251 extends Ticker {
        public final long read() {
            return System.nanoTime();
        }

        C00251() {
        }
    }

    public abstract long read();

    protected Ticker() {
    }

    @CheckReturnValue
    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }
}

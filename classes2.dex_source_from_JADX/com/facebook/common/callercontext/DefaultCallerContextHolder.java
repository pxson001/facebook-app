package com.facebook.common.callercontext;

import javax.annotation.Nullable;

/* compiled from: request_id_param_key */
public final class DefaultCallerContextHolder {
    public static final ThreadLocal<CallerContext> f7308a = new ThreadLocal();

    private DefaultCallerContextHolder() {
    }

    public static CallerContext m11833b(@Nullable CallerContext callerContext) {
        return callerContext != null ? callerContext : (CallerContext) f7308a.get();
    }
}

package com.google.common.util.concurrent;

/* compiled from: mid = ? */
final class AbstractFuture$Failure$1 extends Throwable {
    AbstractFuture$Failure$1(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}

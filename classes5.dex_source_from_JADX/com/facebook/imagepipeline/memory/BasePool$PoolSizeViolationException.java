package com.facebook.imagepipeline.memory;

/* compiled from: TOWING_SERVICE */
public class BasePool$PoolSizeViolationException extends RuntimeException {
    public BasePool$PoolSizeViolationException(int i, int i2, int i3, int i4) {
        super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
    }
}

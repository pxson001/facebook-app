package com.facebook.omnistore;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: mArguments= */
public class CollectionName extends Countable {

    @DoNotStrip
    /* compiled from: mArguments= */
    public class Builder extends Countable {
        private native void doAddDeviceId();

        private native void doAddSegment(String str);

        public native CollectionName build();

        @DoNotStrip
        private Builder() {
        }

        public Builder addDeviceId() {
            doAddDeviceId();
            return this;
        }

        public Builder addSegment(String str) {
            doAddSegment(str);
            return this;
        }
    }

    private static native boolean equalsNative(CollectionName collectionName, CollectionName collectionName2);

    public native String toString();

    static {
        Prerequisites.ensure();
    }

    @DoNotStrip
    private CollectionName() {
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof CollectionName) && (this == obj || equalsNative(this, (CollectionName) obj));
    }

    public int hashCode() {
        return toString().hashCode();
    }
}

package com.facebook.react.bridge;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: gif_picker_trending_gifs_displayed */
public class ReadableNativeMap extends NativeMap implements ReadableMap {

    @DoNotStrip
    /* compiled from: gif_picker_trending_gifs_displayed */
    class ReadableNativeMapKeySetIterator extends Countable implements ReadableMapKeySetIterator {
        private final ReadableNativeMap f11548a;

        private native void initialize(ReadableNativeMap readableNativeMap);

        public native boolean hasNextKey();

        public native String nextKey();

        public ReadableNativeMapKeySetIterator(ReadableNativeMap readableNativeMap) {
            this.f11548a = readableNativeMap;
            initialize(this.f11548a);
        }
    }

    public native ReadableNativeArray getArray(String str);

    public native boolean getBoolean(String str);

    public native double getDouble(String str);

    public native int getInt(String str);

    public native ReadableNativeMap getMap(String str);

    public native String getString(String str);

    public native ReadableType getType(String str);

    public native boolean hasKey(String str);

    public native boolean isNull(String str);

    public final /* synthetic */ ReadableArray mo678a(String str) {
        return getArray(str);
    }

    public final /* synthetic */ ReadableMap mo680b(String str) {
        return getMap(str);
    }

    static {
        SoLoader.a("reactnativejni");
    }

    public final ReadableMapKeySetIterator mo679a() {
        return new ReadableNativeMapKeySetIterator(this);
    }
}

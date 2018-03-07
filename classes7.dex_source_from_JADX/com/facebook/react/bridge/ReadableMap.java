package com.facebook.react.bridge;

/* compiled from: glShaderSource */
public interface ReadableMap {
    ReadableArray mo678a(String str);

    ReadableMapKeySetIterator mo679a();

    ReadableMap mo680b(String str);

    boolean getBoolean(String str);

    double getDouble(String str);

    int getInt(String str);

    String getString(String str);

    ReadableType getType(String str);

    boolean hasKey(String str);

    boolean isNull(String str);
}

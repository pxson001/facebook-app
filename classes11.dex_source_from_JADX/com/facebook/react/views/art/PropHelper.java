package com.facebook.react.views.art;

import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

/* compiled from: SEE_MORE_FOOTER */
class PropHelper {
    PropHelper() {
    }

    @Nullable
    static float[] m11802a(@Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        float[] fArr = new float[readableArray.size()];
        m11801a(readableArray, fArr);
        return fArr;
    }

    static int m11801a(ReadableArray readableArray, float[] fArr) {
        int length = readableArray.size() > fArr.length ? fArr.length : readableArray.size();
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        return readableArray.size();
    }
}

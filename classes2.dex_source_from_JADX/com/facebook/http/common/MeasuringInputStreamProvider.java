package com.facebook.http.common;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import java.io.InputStream;

/* compiled from: mGuessLock */
public class MeasuringInputStreamProvider extends AbstractAssistedProvider<MeasuringInputStream> {
    public final MeasuringInputStream m22193a(InputStream inputStream) {
        return new MeasuringInputStream(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this), inputStream);
    }
}

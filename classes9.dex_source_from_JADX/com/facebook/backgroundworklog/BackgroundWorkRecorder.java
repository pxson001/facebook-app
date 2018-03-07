package com.facebook.backgroundworklog;

import com.google.common.collect.Maps;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Singleton;

@Singleton
/* compiled from: select_payment_method */
public class BackgroundWorkRecorder {
    public final ConcurrentMap<String, BackgroundWorkAccumulator> f4233a = Maps.e();
    public final ChromeTraceWriter f4234b = new ChromeTraceWriter();
    private long f4235c = -1;
}

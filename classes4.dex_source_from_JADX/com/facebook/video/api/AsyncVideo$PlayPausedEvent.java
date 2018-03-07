package com.facebook.video.api;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.debug.log.BLog;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.BytesViewedLogger.Handler;

/* compiled from: percentile_75 */
public class AsyncVideo$PlayPausedEvent extends TypedEvent<Handler> {
    public final int f5291a;
    public final Reason f5292b;

    public final void m5793a(TypedHandler typedHandler) {
        Handler handler = (Handler) typedHandler;
        int i = this.f5291a;
        BytesViewedLogger bytesViewedLogger = handler.f5192a;
        if (bytesViewedLogger.f5188g == null || bytesViewedLogger.f5189h <= 0) {
            String str = BytesViewedLogger.f5182a;
            String str2 = "BytesViewedLogger not properly configured: has key: %s, has bitrate: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(bytesViewedLogger.f5188g != null);
            objArr[1] = Integer.valueOf(bytesViewedLogger.f5189h);
            BLog.a(str, str2, objArr);
        }
        if (handler.f5192a.f5190i >= 0 && handler.f5192a.f5190i < i) {
            BytesViewedLogger.m5629a(handler.f5192a, (long) handler.f5192a.f5190i, (long) i);
            handler.f5192a.f5190i = -1;
        }
    }

    public AsyncVideo$PlayPausedEvent(int i, Reason reason) {
        this.f5291a = i;
        this.f5292b = reason;
    }
}

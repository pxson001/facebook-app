package com.facebook.debug.fblog;

import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import javax.inject.Inject;

/* compiled from: video_channel_player */
public class LoggingModule$Initializer implements INeedInit {
    private final FbLogImpl f1233a;

    @Inject
    public LoggingModule$Initializer(FbLogImpl fbLogImpl) {
        this.f1233a = fbLogImpl;
    }

    public void init() {
        BLog.a(this.f1233a);
    }
}

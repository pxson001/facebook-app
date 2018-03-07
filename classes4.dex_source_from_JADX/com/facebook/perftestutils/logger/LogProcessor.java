package com.facebook.perftestutils.logger;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: push_id */
public interface LogProcessor {
    @DoNotStrip
    void processLogLine(Object[] objArr);
}

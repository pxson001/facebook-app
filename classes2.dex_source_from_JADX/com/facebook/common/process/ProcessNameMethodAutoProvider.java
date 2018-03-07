package com.facebook.common.process;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: video_channel */
public class ProcessNameMethodAutoProvider extends AbstractProvider<ProcessName> {
    public static ProcessName m2431b(InjectorLike injectorLike) {
        return ProcessModule.m2432a(DefaultProcessUtil.m2387a(injectorLike));
    }

    public Object get() {
        return ProcessModule.m2432a(DefaultProcessUtil.m2387a(this));
    }

    public static ProcessName m2430a(InjectorLike injectorLike) {
        return m2431b(injectorLike);
    }
}

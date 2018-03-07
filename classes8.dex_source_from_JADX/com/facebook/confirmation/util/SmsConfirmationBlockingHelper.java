package com.facebook.confirmation.util;

import android.os.Handler;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: inline_cancel_friend_request */
public class SmsConfirmationBlockingHelper {
    private boolean f10812a = false;
    private final DefaultAndroidThreadUtil f10813b;
    private final Clock f10814c;
    private final Handler f10815d;
    private final SmsConfirmationReaderExperimental f10816e;

    private static SmsConfirmationBlockingHelper m12752b(InjectorLike injectorLike) {
        return new SmsConfirmationBlockingHelper(DefaultAndroidThreadUtil.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), SmsConfirmationReaderExperimental.c(injectorLike));
    }

    @Inject
    public SmsConfirmationBlockingHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Clock clock, Handler handler, SmsConfirmationReaderExperimental smsConfirmationReaderExperimental) {
        this.f10813b = defaultAndroidThreadUtil;
        this.f10814c = clock;
        this.f10815d = handler;
        this.f10816e = smsConfirmationReaderExperimental;
    }
}

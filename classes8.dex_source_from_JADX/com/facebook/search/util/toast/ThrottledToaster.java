package com.facebook.search.util.toast;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: mediaset_type */
public class ThrottledToaster {
    public final Toaster f8966a;
    public final Clock f8967b;
    public long f8968c;
    public long f8969d = 0;

    public static ThrottledToaster m10693a(InjectorLike injectorLike) {
        return new ThrottledToaster(Toaster.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThrottledToaster(Toaster toaster, Clock clock) {
        this.f8966a = toaster;
        this.f8967b = clock;
    }
}

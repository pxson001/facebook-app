package com.facebook.friendsnearby.pingdialog.ui;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: [TT;[TT; */
public class NewPingOptionsGenerator {
    private final Clock f20670a;
    private final Resources f20671b;
    private Calendar f20672c = Calendar.getInstance();

    private static NewPingOptionsGenerator m21159b(InjectorLike injectorLike) {
        return new NewPingOptionsGenerator((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewPingOptionsGenerator(Clock clock, Resources resources) {
        this.f20670a = clock;
        this.f20671b = resources;
    }
}

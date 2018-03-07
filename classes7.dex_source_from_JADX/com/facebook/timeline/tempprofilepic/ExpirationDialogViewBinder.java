package com.facebook.timeline.tempprofilepic;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: facecast_copy_link */
public class ExpirationDialogViewBinder {
    public final Resources f14952a;
    public final Clock f14953b;

    public static ExpirationDialogViewBinder m18790b(InjectorLike injectorLike) {
        return new ExpirationDialogViewBinder(ResourcesMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ExpirationDialogViewBinder(Resources resources, Clock clock) {
        this.f14952a = resources;
        this.f14953b = clock;
    }
}

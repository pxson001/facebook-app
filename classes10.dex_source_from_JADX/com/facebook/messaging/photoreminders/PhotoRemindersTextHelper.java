package com.facebook.messaging.photoreminders;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: registration_step_view */
public class PhotoRemindersTextHelper {
    private final QeAccessor f3552a;
    private final Resources f3553b;

    private static PhotoRemindersTextHelper m3400b(InjectorLike injectorLike) {
        return new PhotoRemindersTextHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemindersTextHelper(QeAccessor qeAccessor, Resources resources) {
        this.f3552a = qeAccessor;
        this.f3553b = resources;
    }
}

package com.facebook.ufiservices.qe;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: currentPrivacyJson */
public class UfiFlyoutQuickExperimentController {
    public final Context f18249a;

    public static UfiFlyoutQuickExperimentController m26781b(InjectorLike injectorLike) {
        return new UfiFlyoutQuickExperimentController((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public UfiFlyoutQuickExperimentController(Context context) {
        this.f18249a = context;
    }

    public static UfiFlyoutQuickExperimentController m26780a(InjectorLike injectorLike) {
        return m26781b(injectorLike);
    }
}

package com.facebook.redspace.nux;

import android.os.Parcelable;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: outputOpen */
public class RedSpaceInterstitialController implements InterstitialController {
    private static final InterstitialTrigger f4557a = new InterstitialTrigger(Action.REDSPACE_OPENED);
    private final QeAccessor f4558b;
    private final AllCapsTransformationMethod f4559c;
    private final SecureContextHelper f4560d;
    private final UriIntentMapper f4561e;

    public static RedSpaceInterstitialController m5816b(InjectorLike injectorLike) {
        return new RedSpaceInterstitialController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AllCapsTransformationMethod.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public RedSpaceInterstitialController(QeAccessor qeAccessor, AllCapsTransformationMethod allCapsTransformationMethod, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f4558b = qeAccessor;
        this.f4559c = allCapsTransformationMethod;
        this.f4560d = secureContextHelper;
        this.f4561e = uriIntentMapper;
    }

    public final InterstitialControllerState m5817a(InterstitialTrigger interstitialTrigger) {
        return this.f4558b.a(ExperimentsForRedSpaceExperimentsModule.h, false) ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
    }

    public final String m5820b() {
        return "3949";
    }

    public final ImmutableList<InterstitialTrigger> m5821c() {
        return ImmutableList.of(f4557a);
    }

    public final void m5819a(@Nullable Parcelable parcelable) {
    }

    public final void m5818a(long j) {
    }

    public final long hI_() {
        return 86400000;
    }
}

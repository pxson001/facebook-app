package com.facebook.ipc.productionprompts.actionhandler;

import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.friendsharing.meme.activity.MemePickerAnalyticsLogger;
import com.facebook.friendsharing.suggestedcoverphotos.SuggestedCoverPhotoEditHelperProvider;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.productionprompts.actionhandlers.CoverPhotoPromptActionHandler;
import com.facebook.productionprompts.actionhandlers.FramePromptActionHandler;
import com.facebook.productionprompts.actionhandlers.MemePromptActionHandler;
import com.facebook.productionprompts.actionhandlers.ProfilePhotoOverlayPromptActionHandler;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0537xc87e0bdd implements MultiBindIndexedProvider<PromptActionHandler>, Provider<Set<PromptActionHandler>> {
    private final InjectorLike f13362a;

    public C0537xc87e0bdd(InjectorLike injectorLike) {
        this.f13362a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13362a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CoverPhotoPromptActionHandler(DefaultSecureContextHelper.m4636a((InjectorLike) injector), (SuggestedCoverPhotoEditHelperProvider) injector.getOnDemandAssistedProviderForStaticDi(SuggestedCoverPhotoEditHelperProvider.class), SuggestedCoverPhotosLogger.m19697b(injector), PromptImpressionLoggingSessionIdMap.m19701a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return FramePromptActionHandler.m19705b((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new MemePromptActionHandler(ComposerIntentLauncher.m19715b((InjectorLike) injector), JsonPluginConfigSerializer.m18629b(injector), MemePickerAnalyticsLogger.m19719b(injector));
            case 3:
                return new ProfilePhotoOverlayPromptActionHandler(IdBasedSingletonScopeProvider.m1809a(injector, 7160));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

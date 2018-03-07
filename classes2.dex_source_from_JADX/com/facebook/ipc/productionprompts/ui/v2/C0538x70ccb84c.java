package com.facebook.ipc.productionprompts.ui.v2;

import com.facebook.friendsharing.meme.prompt.MemePromptClickListenerProvider;
import com.facebook.friendsharing.meme.prompt.MemePromptViewController;
import com.facebook.friendsharing.suggestedcoverphotos.prompt.CoverPhotoPromptClickListenerProvider;
import com.facebook.friendsharing.suggestedcoverphotos.prompt.CoverPhotoPromptViewController;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.photos.creativeediting.swipeable.prompt.FramePromptClickListener;
import com.facebook.photos.creativeediting.swipeable.prompt.FramePromptProvider;
import com.facebook.photos.creativeediting.swipeable.prompt.FramePromptViewController;
import com.facebook.productionprompts.ClipboardPromptsPromptViewController;
import com.facebook.productionprompts.ClipboardV2PromptProvider;
import com.facebook.productionprompts.ProductionPromptV2PromptProvider;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0538x70ccb84c implements MultiBindIndexedProvider<PromptViewController>, Provider<Set<PromptViewController>> {
    private final InjectorLike f13388a;

    public C0538x70ccb84c(InjectorLike injectorLike) {
        this.f13388a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13388a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MemePromptViewController(QeInternalImplMethodAutoProvider.m3744a(injector), (MemePromptClickListenerProvider) injector.getOnDemandAssistedProviderForStaticDi(MemePromptClickListenerProvider.class));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new CoverPhotoPromptViewController((CoverPhotoPromptClickListenerProvider) injector.getOnDemandAssistedProviderForStaticDi(CoverPhotoPromptClickListenerProvider.class));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                FramePromptViewController framePromptViewController = new FramePromptViewController(FramePromptClickListener.m19771b(injector));
                FramePromptProvider framePromptProvider = (FramePromptProvider) injector.getOnDemandAssistedProviderForStaticDi(FramePromptProvider.class);
                framePromptViewController.f13401a = QeInternalImplMethodAutoProvider.m3744a(injector);
                framePromptViewController.f13402b = framePromptProvider;
                return framePromptViewController;
            case 3:
                return new ClipboardPromptsPromptViewController(InlineComposerPromptActionHandler.m19641b((InjectorLike) injector), PromptActionContextFactory.m19725b(injector), (ProductionPromptV2PromptProvider) injector.getOnDemandAssistedProviderForStaticDi(ProductionPromptV2PromptProvider.class), (ClipboardV2PromptProvider) injector.getOnDemandAssistedProviderForStaticDi(ClipboardV2PromptProvider.class));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

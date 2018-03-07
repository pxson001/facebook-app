package com.facebook.ipc.productionprompts.ui.v2;

import android.content.Context;
import com.facebook.feed.photoreminder.MediaReminderUtil;
import com.facebook.feed.photoreminder.PhotoReminderPromptViewController;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptViewController;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.productionprompts.EditorialPromptsPromptViewController;
import com.facebook.productionprompts.ProductionPromptV2PromptProvider;
import com.facebook.productionprompts.ProductionPromptsPromptViewController;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0535x865d8f2e implements MultiBindIndexedProvider<PromptViewController>, Provider<Set<PromptViewController>> {
    private final InjectorLike f13300a;

    public C0535x865d8f2e(InjectorLike injectorLike) {
        this.f13300a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13300a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PhotoReminderPromptViewController(MediaReminderUtil.m18699a((InjectorLike) injector), (Context) injector.getInstance(Context.class));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return SouvenirPromptViewController.m19594b((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new ProductionPromptsPromptViewController(new MultiBinderSet(injector.getScopeAwareInjector(), new C0538x70ccb84c(injector)), new EditorialPromptsPromptViewController(InlineComposerPromptActionHandler.m19641b((InjectorLike) injector), PromptActionContextFactory.m19725b(injector), (ProductionPromptV2PromptProvider) injector.getOnDemandAssistedProviderForStaticDi(ProductionPromptV2PromptProvider.class)));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

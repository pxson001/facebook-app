package com.facebook.pages.common.resulthandlers.interfaces;

import android.content.Context;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.CheckinHandler;
import com.facebook.pages.common.resulthandlers.EditCoverPhotoHandler;
import com.facebook.pages.common.resulthandlers.EditProfilePicHandler;
import com.facebook.pages.common.resulthandlers.EditReviewPrivacyHandler;
import com.facebook.pages.common.resulthandlers.PageRefreshOnlyHandler;
import com.facebook.pages.common.resulthandlers.PostReviewHandler;
import com.facebook.pages.common.resulthandlers.SharePageHandler;
import com.facebook.pages.common.resulthandlers.StructuredComposerHandler;
import com.facebook.pages.common.resulthandlers.SuggestEditsHandler;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.ui.toaster.Toaster;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: rsvp_event */
public final class STATICDI_MULTIBIND_PROVIDER$ActivityResultHandler implements MultiBindIndexedProvider<ActivityResultHandler>, Provider<Set<ActivityResultHandler>> {
    private final InjectorLike f2320a;

    public STATICDI_MULTIBIND_PROVIDER$ActivityResultHandler(InjectorLike injectorLike) {
        this.f2320a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2320a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 9;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CheckinHandler((Context) injector.getInstance(Context.class), Toaster.b(injector), ResourcesMethodAutoProvider.a(injector), PagesAnalytics.a(injector), ComposerPublishServiceHelper.b(injector), ViewerContextManagerProvider.b(injector));
            case 1:
                return EditCoverPhotoHandler.m3215b(injector);
            case 2:
                return EditProfilePicHandler.m3223b(injector);
            case 3:
                return new EditReviewPrivacyHandler(PagesAnalytics.a(injector), PrivacyOperationsClient.a(injector), PageEventBus.m2423a(injector));
            case 4:
                return new PageRefreshOnlyHandler();
            case 5:
                return PostReviewHandler.m3251b((InjectorLike) injector);
            case 6:
                return SharePageHandler.m3260b(injector);
            case 7:
                return StructuredComposerHandler.m3269b(injector);
            case 8:
                return new SuggestEditsHandler(Toaster.b(injector), PagesAnalytics.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

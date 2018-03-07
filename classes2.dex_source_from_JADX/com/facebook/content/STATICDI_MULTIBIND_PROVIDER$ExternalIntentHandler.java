package com.facebook.content;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.dialtone.DialtoneAwareExternalIntentHandler;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.instantarticles.InstantArticlesExternalIntentHandler;
import com.facebook.instantarticles.RichDocumentUriIntentBuilder;
import com.facebook.notes.NotesIntentHandler;
import com.facebook.notes.NotesUriIntentBuilder;
import com.facebook.notes.gk.NotesGatekeepers;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.richdocument.logging.RichDocumentLongClickTracker;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.si.LinkshimExternalIntentHandler;
import com.facebook.ui.browser.BrowserExternalIntentHandler;
import com.facebook.zero.ZeroAwareExternalIntentHandler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ExternalIntentHandler implements MultiBindIndexedProvider<ExternalIntentHandler>, Provider<Set<ExternalIntentHandler>> {
    private final InjectorLike f2448a;

    public STATICDI_MULTIBIND_PROVIDER$ExternalIntentHandler(InjectorLike injectorLike) {
        this.f2448a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2448a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DialtoneAwareExternalIntentHandler(DialtoneControllerImpl.m8272a((InjectorLike) injector), DefaultSecureContextHelper.m4636a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new InstantArticlesExternalIntentHandler(SequenceLoggerImpl.m3464a((InjectorLike) injector), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injector), RichDocumentLongClickTracker.a(injector), RichDocumentUriIntentBuilder.a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 3219), LinkshimExternalIntentHandler.b(injector), IdBasedSingletonScopeProvider.m1810b(injector, 2128));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new NotesIntentHandler(NotesGatekeepers.m26566b(injector), NotesUriIntentBuilder.b(injector));
            case 3:
                return LinkshimExternalIntentHandler.b(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return BrowserExternalIntentHandler.b(injector);
            case 5:
                return ZeroAwareExternalIntentHandler.b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

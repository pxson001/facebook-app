package com.facebook.timeline.publisher.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.inlinecomposer.logging.InlineComposerLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: failed to get if should show traveling NUX */
public class OpenPublisherListenerHelper {
    private static OpenPublisherListenerHelper f12454h;
    private static final Object f12455i = new Object();
    public final ProfileControllerDelegate f12456a;
    public final Provider<IFeedIntentBuilder> f12457b;
    public final InlineComposerLogger f12458c;
    private OnClickListener f12459d;
    private OnClickListener f12460e;
    private OnClickListener f12461f;
    private OnClickListener f12462g;

    /* compiled from: failed to get if should show traveling NUX */
    class C17561 implements OnClickListener {
        final /* synthetic */ OpenPublisherListenerHelper f12449a;

        C17561(OpenPublisherListenerHelper openPublisherListenerHelper) {
            this.f12449a = openPublisherListenerHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -744191548);
            this.f12449a.f12456a.mo485v().mo555a("tap_status_button");
            Logger.a(2, EntryType.UI_INPUT_END, 670839372, a);
        }
    }

    /* compiled from: failed to get if should show traveling NUX */
    class C17572 implements OnClickListener {
        final /* synthetic */ OpenPublisherListenerHelper f12450a;

        C17572(OpenPublisherListenerHelper openPublisherListenerHelper) {
            this.f12450a = openPublisherListenerHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 643145798);
            this.f12450a.f12456a.mo485v().mo556b("tap_photo_button");
            Logger.a(2, EntryType.UI_INPUT_END, -679183728, a);
        }
    }

    /* compiled from: failed to get if should show traveling NUX */
    class C17583 implements OnClickListener {
        final /* synthetic */ OpenPublisherListenerHelper f12451a;

        C17583(OpenPublisherListenerHelper openPublisherListenerHelper) {
            this.f12451a = openPublisherListenerHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1492197959);
            this.f12451a.f12456a.mo485v().mo557c("tap_moment_button");
            Logger.a(2, EntryType.UI_INPUT_END, -620289380, a);
        }
    }

    private static OpenPublisherListenerHelper m12487b(InjectorLike injectorLike) {
        return new OpenPublisherListenerHelper(ProfileControllerDelegate.m10751a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2347), InlineComposerLogger.a(injectorLike));
    }

    @Inject
    public OpenPublisherListenerHelper(ProfileControllerDelegate profileControllerDelegate, Provider<IFeedIntentBuilder> provider, InlineComposerLogger inlineComposerLogger) {
        this.f12456a = profileControllerDelegate;
        this.f12457b = provider;
        this.f12458c = inlineComposerLogger;
    }

    public final OnClickListener m12488a() {
        if (this.f12459d == null) {
            this.f12459d = new C17561(this);
        }
        return this.f12459d;
    }

    public final OnClickListener m12490b() {
        if (this.f12460e == null) {
            this.f12460e = new C17572(this);
        }
        return this.f12460e;
    }

    public static OpenPublisherListenerHelper m12486a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenPublisherListenerHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12455i) {
                OpenPublisherListenerHelper openPublisherListenerHelper;
                if (a2 != null) {
                    openPublisherListenerHelper = (OpenPublisherListenerHelper) a2.a(f12455i);
                } else {
                    openPublisherListenerHelper = f12454h;
                }
                if (openPublisherListenerHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12487b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12455i, b3);
                        } else {
                            f12454h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openPublisherListenerHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final OnClickListener m12491c() {
        if (this.f12461f == null) {
            this.f12461f = new C17583(this);
        }
        return this.f12461f;
    }

    public final OnClickListener m12489a(final String str) {
        if (this.f12462g == null) {
            this.f12462g = new OnClickListener(this) {
                final /* synthetic */ OpenPublisherListenerHelper f12453b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 669142717);
                    this.f12453b.f12458c.a("tap_composer_profile_photo_from_timeline");
                    ((IFeedIntentBuilder) this.f12453b.f12457b.get()).a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str));
                    Logger.a(2, EntryType.UI_INPUT_END, -667521266, a);
                }
            };
        }
        return this.f12462g;
    }
}

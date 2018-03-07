package com.facebook.timeline.delegate;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.ProfileController;
import com.facebook.timeline.actionbar.TimelineActionBarController;
import com.facebook.timeline.actionbar.TimelineActionBarControllerDummy;
import com.facebook.timeline.contextual.TimelineContextualInfoController;
import com.facebook.timeline.contextual.TimelineContextualInfoControllerDummy;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineHeaderPerfController;
import com.facebook.timeline.header.bio.TimelineHeaderPerfControllerDummy;
import com.facebook.timeline.header.controllers.TimelineCoverPhotoController;
import com.facebook.timeline.header.controllers.TimelineProfileImageController;
import com.facebook.timeline.header.controllers.dummy.TimelineCoverPhotoControllerDummy;
import com.facebook.timeline.header.controllers.dummy.TimelineProfileImageControllerDummy;
import com.facebook.timeline.navtiles.TimelineNavtileController;
import com.facebook.timeline.navtiles.TimelineNavtileControllerDummy;
import com.facebook.timeline.publisher.TimelinePublishController;
import com.facebook.timeline.publisher.TimelinePublishControllerDummy;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: granted */
public class ProfileControllerDelegate implements ProfileController {
    private static ProfileControllerDelegate f10708i;
    private static final Object f10709j = new Object();
    private final Provider<TimelineProfileImageControllerDummy> f10710a;
    private final Provider<TimelineActionBarControllerDummy> f10711b;
    private final Provider<TimelineContextualInfoControllerDummy> f10712c;
    private final Provider<TimelineNavtileControllerDummy> f10713d;
    private final Provider<TimelineCoverPhotoControllerDummy> f10714e;
    private final Provider<TimelineHeaderPerfControllerDummy> f10715f;
    private final Provider<TimelinePublishControllerDummy> f10716g;
    @Nullable
    private WeakReference<ProfileController> f10717h;

    private static ProfileControllerDelegate m10752b(InjectorLike injectorLike) {
        return new ProfileControllerDelegate(IdBasedSingletonScopeProvider.a(injectorLike, 11265), IdBasedSingletonScopeProvider.a(injectorLike, 11152), IdBasedSingletonScopeProvider.a(injectorLike, 11264), IdBasedSingletonScopeProvider.a(injectorLike, 11163), IdBasedSingletonScopeProvider.a(injectorLike, 11296), IdBasedSingletonScopeProvider.a(injectorLike, 11258), IdBasedSingletonScopeProvider.a(injectorLike, 11346));
    }

    @Inject
    public ProfileControllerDelegate(Provider<TimelineProfileImageControllerDummy> provider, Provider<TimelineActionBarControllerDummy> provider2, Provider<TimelineCoverPhotoControllerDummy> provider3, Provider<TimelineContextualInfoControllerDummy> provider4, Provider<TimelineNavtileControllerDummy> provider5, Provider<TimelineHeaderPerfControllerDummy> provider6, Provider<TimelinePublishControllerDummy> provider7) {
        this.f10710a = provider;
        this.f10711b = provider2;
        this.f10712c = provider4;
        this.f10713d = provider5;
        this.f10714e = provider3;
        this.f10715f = provider6;
        this.f10716g = provider7;
    }

    public static ProfileControllerDelegate m10751a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileControllerDelegate b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10709j) {
                ProfileControllerDelegate profileControllerDelegate;
                if (a2 != null) {
                    profileControllerDelegate = (ProfileControllerDelegate) a2.a(f10709j);
                } else {
                    profileControllerDelegate = f10708i;
                }
                if (profileControllerDelegate == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10752b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10709j, b3);
                        } else {
                            f10708i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileControllerDelegate;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    public final TimelineHeaderDataLogger mo471f() {
        ProfileController a = m10750a();
        if (a == null) {
            return null;
        }
        return a.mo471f();
    }

    public final TimelineProfileImageController mo473l() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineProfileImageController) this.f10710a.get();
        }
        return a.mo473l();
    }

    public final TimelineActionBarController mo474m() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineActionBarController) this.f10711b.get();
        }
        return a.mo474m();
    }

    public final TimelineContextualInfoController mo482r() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineContextualInfoController) this.f10712c.get();
        }
        return a.mo482r();
    }

    public final TimelineNavtileController mm_() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineNavtileController) this.f10713d.get();
        }
        return a.mm_();
    }

    public final TimelineCoverPhotoController mo483t() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineCoverPhotoController) this.f10714e.get();
        }
        return a.mo483t();
    }

    public final TimelineHeaderPerfController mo484u() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelineHeaderPerfController) this.f10715f.get();
        }
        return a.mo484u();
    }

    public final TimelinePublishController mo485v() {
        ProfileController a = m10750a();
        if (a == null) {
            return (TimelinePublishController) this.f10716g.get();
        }
        return a.mo485v();
    }

    public final void mn_() {
        ProfileController a = m10750a();
        if (a != null) {
            a.mn_();
        }
    }

    public final void mo470e() {
        ProfileController a = m10750a();
        if (a != null) {
            a.mo470e();
        }
    }

    public final void mo_() {
        ProfileController a = m10750a();
        if (a != null) {
            a.mo_();
        }
    }

    public final void mp_() {
        ProfileController a = m10750a();
        if (a != null) {
            a.mp_();
        }
    }

    public final void mq_() {
        ProfileController a = m10750a();
        if (a != null) {
            a.mq_();
        }
    }

    public final void m10753a(WeakReference<ProfileController> weakReference) {
        this.f10717h = weakReference;
    }

    private ProfileController m10750a() {
        if (this.f10717h == null) {
            return null;
        }
        return (ProfileController) this.f10717h.get();
    }
}

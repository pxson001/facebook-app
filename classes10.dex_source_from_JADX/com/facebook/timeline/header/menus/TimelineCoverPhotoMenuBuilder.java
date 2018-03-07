package com.facebook.timeline.header.menus;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_external_links */
public class TimelineCoverPhotoMenuBuilder {
    private static TimelineCoverPhotoMenuBuilder f11852b;
    private static final Object f11853c = new Object();
    public final ProfileControllerDelegate f11854a;

    /* compiled from: fetch_external_links */
    public class C16911 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineCoverPhotoMenuBuilder f11850a;

        public C16911(TimelineCoverPhotoMenuBuilder timelineCoverPhotoMenuBuilder) {
            this.f11850a = timelineCoverPhotoMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11850a.f11854a.mo483t().mo545b();
            return true;
        }
    }

    /* compiled from: fetch_external_links */
    public class C16922 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineCoverPhotoMenuBuilder f11851a;

        public C16922(TimelineCoverPhotoMenuBuilder timelineCoverPhotoMenuBuilder) {
            this.f11851a = timelineCoverPhotoMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11851a.f11854a.mo483t().mo544a();
            return true;
        }
    }

    private static TimelineCoverPhotoMenuBuilder m11944b(InjectorLike injectorLike) {
        return new TimelineCoverPhotoMenuBuilder(ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineCoverPhotoMenuBuilder(ProfileControllerDelegate profileControllerDelegate) {
        this.f11854a = profileControllerDelegate;
    }

    public static TimelineCoverPhotoMenuBuilder m11943a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineCoverPhotoMenuBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11853c) {
                TimelineCoverPhotoMenuBuilder timelineCoverPhotoMenuBuilder;
                if (a2 != null) {
                    timelineCoverPhotoMenuBuilder = (TimelineCoverPhotoMenuBuilder) a2.a(f11853c);
                } else {
                    timelineCoverPhotoMenuBuilder = f11852b;
                }
                if (timelineCoverPhotoMenuBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11944b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11853c, b3);
                        } else {
                            f11852b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineCoverPhotoMenuBuilder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

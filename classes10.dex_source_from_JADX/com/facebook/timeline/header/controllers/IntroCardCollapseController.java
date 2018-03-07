package com.facebook.timeline.header.controllers;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.TimelineIntroCardAdapter.CollapseState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: for_sale_profile_id */
public class IntroCardCollapseController {
    private static IntroCardCollapseController f11623c;
    private static final Object f11624d = new Object();
    private final TimelineHeaderViewController f11625a;
    public CollapseState f11626b = CollapseState.UNKNOWN;

    private static IntroCardCollapseController m11667b(InjectorLike injectorLike) {
        return new IntroCardCollapseController(TimelineHeaderViewController.m11687b(injectorLike));
    }

    @Inject
    public IntroCardCollapseController(TimelineHeaderViewController timelineHeaderViewController) {
        this.f11625a = timelineHeaderViewController;
    }

    public final CollapseState m11668a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, FeaturedContainersHeaderData featuredContainersHeaderData) {
        if (this.f11626b == CollapseState.UNKNOWN) {
            TimelineHeaderViewController timelineHeaderViewController = this.f11625a;
            CollapseState collapseState = timelineHeaderUserData.j() ? CollapseState.UNKNOWN : (timelineHeaderUserData.W() || timelineHeaderUserData.Y() || !TimelineHeaderViewController.m11688b(timelineContext, timelineHeaderUserData, featuredContainersHeaderData)) ? TimelineHeaderViewController.m11689b(timelineHeaderUserData) ? CollapseState.COLLAPSED : CollapseState.EXPANDED : CollapseState.EXPANDED;
            this.f11626b = collapseState;
        }
        return this.f11626b;
    }

    public static IntroCardCollapseController m11666a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            IntroCardCollapseController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11624d) {
                IntroCardCollapseController introCardCollapseController;
                if (a2 != null) {
                    introCardCollapseController = (IntroCardCollapseController) a2.a(f11624d);
                } else {
                    introCardCollapseController = f11623c;
                }
                if (introCardCollapseController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11667b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11624d, b3);
                        } else {
                            f11623c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = introCardCollapseController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

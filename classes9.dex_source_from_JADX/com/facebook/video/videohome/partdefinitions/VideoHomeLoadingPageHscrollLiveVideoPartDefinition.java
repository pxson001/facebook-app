package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.videohome.views.VideoHomeLiveVideoHScrollEmptyCardView;

@ContextScoped
/* compiled from: skip_attachment_hash_check */
public class VideoHomeLoadingPageHscrollLiveVideoPartDefinition extends MultiRowSinglePartDefinition<Object, Void, AnyEnvironment, View> {
    public static final ViewType<View> f3085a = new C02901();
    private static VideoHomeLoadingPageHscrollLiveVideoPartDefinition f3086b;
    private static final Object f3087c = new Object();

    /* compiled from: skip_attachment_hash_check */
    final class C02901 extends ViewType<View> {
        C02901() {
        }

        public final View m2960a(Context context) {
            return new VideoHomeLiveVideoHScrollEmptyCardView(context);
        }
    }

    private static VideoHomeLoadingPageHscrollLiveVideoPartDefinition m2962b() {
        return new VideoHomeLoadingPageHscrollLiveVideoPartDefinition();
    }

    public final ViewType m2963a() {
        return f3085a;
    }

    public final boolean m2964a(Object obj) {
        return true;
    }

    public static VideoHomeLoadingPageHscrollLiveVideoPartDefinition m2961a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeLoadingPageHscrollLiveVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3087c) {
                VideoHomeLoadingPageHscrollLiveVideoPartDefinition videoHomeLoadingPageHscrollLiveVideoPartDefinition;
                if (a2 != null) {
                    videoHomeLoadingPageHscrollLiveVideoPartDefinition = (VideoHomeLoadingPageHscrollLiveVideoPartDefinition) a2.a(f3087c);
                } else {
                    videoHomeLoadingPageHscrollLiveVideoPartDefinition = f3086b;
                }
                if (videoHomeLoadingPageHscrollLiveVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2962b();
                        if (a2 != null) {
                            a2.a(f3087c, b3);
                        } else {
                            f3086b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeLoadingPageHscrollLiveVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

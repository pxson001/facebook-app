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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition;
import com.facebook.video.channelfeed.VideoHomePublisherInfoPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms_logs */
public class VideoHomeClippedPublisherInfoPartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, View> {
    public static ViewType<View> f3034a = ViewType.a(2130907710);
    private static VideoHomeClippedPublisherInfoPartDefinition f3035c;
    private static final Object f3036d = new Object();
    private final VideoHomePublisherInfoPartDefinition f3037b;

    private static VideoHomeClippedPublisherInfoPartDefinition m2911b(InjectorLike injectorLike) {
        return new VideoHomeClippedPublisherInfoPartDefinition(VideoHomePublisherInfoPartDefinition.m2586a(injectorLike));
    }

    public final Object m2913a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f3037b, (Props) obj);
        return null;
    }

    public final boolean m2914a(Object obj) {
        return VideoHomePublisherInfoPartDefinition.m2587a((Props) obj);
    }

    @Inject
    public VideoHomeClippedPublisherInfoPartDefinition(VideoHomePublisherInfoPartDefinition videoHomePublisherInfoPartDefinition) {
        this.f3037b = videoHomePublisherInfoPartDefinition;
    }

    public final ViewType<View> m2912a() {
        return f3034a;
    }

    public static VideoHomeClippedPublisherInfoPartDefinition m2910a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeClippedPublisherInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3036d) {
                VideoHomeClippedPublisherInfoPartDefinition videoHomeClippedPublisherInfoPartDefinition;
                if (a2 != null) {
                    videoHomeClippedPublisherInfoPartDefinition = (VideoHomeClippedPublisherInfoPartDefinition) a2.a(f3036d);
                } else {
                    videoHomeClippedPublisherInfoPartDefinition = f3035c;
                }
                if (videoHomeClippedPublisherInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2911b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3036d, b3);
                        } else {
                            f3035c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeClippedPublisherInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

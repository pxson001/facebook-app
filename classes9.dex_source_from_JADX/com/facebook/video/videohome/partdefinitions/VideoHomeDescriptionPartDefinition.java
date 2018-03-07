package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.views.AccessibleTextLayoutView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ViewColorPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.video.channelfeed.ChannelFeedExpandingContentTextPartDefinition;
import com.facebook.video.channelfeed.ChannelFeedExpandingContentTextPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms/mms thread mark unread failed. # threads = %d */
public class VideoHomeDescriptionPartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, AccessibleTextLayoutView> {
    private static VideoHomeDescriptionPartDefinition f3049e;
    private static final Object f3050f = new Object();
    private final ChannelFeedExpandingContentTextPartDefinition f3051a;
    private final ViewPaddingPartDefinition f3052b;
    private final ViewColorPartDefinition f3053c;
    private final Resources f3054d;

    private static VideoHomeDescriptionPartDefinition m2922b(InjectorLike injectorLike) {
        return new VideoHomeDescriptionPartDefinition(ChannelFeedExpandingContentTextPartDefinition.m2157a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), ViewColorPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m2924a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f3051a, (Props) obj);
        int dimensionPixelSize = this.f3054d.getDimensionPixelSize(2131431508);
        subParts.a(this.f3052b, new PaddingData(dimensionPixelSize, 0, dimensionPixelSize, 0));
        subParts.a(this.f3053c, Integer.valueOf(2131362143));
        return null;
    }

    public final boolean m2925a(Object obj) {
        return ChannelFeedExpandingContentTextPartDefinition.m2160a((Props) obj);
    }

    @Inject
    public VideoHomeDescriptionPartDefinition(ChannelFeedExpandingContentTextPartDefinition channelFeedExpandingContentTextPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, ViewColorPartDefinition viewColorPartDefinition, Resources resources) {
        this.f3051a = channelFeedExpandingContentTextPartDefinition;
        this.f3052b = viewPaddingPartDefinition;
        this.f3053c = viewColorPartDefinition;
        this.f3054d = resources;
    }

    public final ViewType m2923a() {
        return ContentTextLayoutBasePartDefinition.a;
    }

    public static VideoHomeDescriptionPartDefinition m2921a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3050f) {
                VideoHomeDescriptionPartDefinition videoHomeDescriptionPartDefinition;
                if (a2 != null) {
                    videoHomeDescriptionPartDefinition = (VideoHomeDescriptionPartDefinition) a2.a(f3050f);
                } else {
                    videoHomeDescriptionPartDefinition = f3049e;
                }
                if (videoHomeDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3050f, b3);
                        } else {
                            f3049e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

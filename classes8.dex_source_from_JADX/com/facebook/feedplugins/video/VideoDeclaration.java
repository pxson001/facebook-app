package com.facebook.feedplugins.video;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: font_size */
public class VideoDeclaration implements FeedRowSupportDeclaration {
    private static VideoDeclaration f13106a;
    private static final Object f13107b = new Object();

    private static VideoDeclaration m14769a() {
        return new VideoDeclaration();
    }

    public final void m14771a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(FullscreenVideoAttachmentPartDefinition.a, Inline360VideoAttachmentPartDefinition.a, InlineVideoDirectResponseAttachmentPartDefinition.a, InlineVideoAttachmentPartDefinition.a, RichVideoDirectResponseAttachmentPartDefinition.a, RichVideoRowPartDefinition.a, VideoPartDefinition.a, FollowVideosPromptPartDefinition.a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }

    public static VideoDeclaration m14770a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f13107b) {
                VideoDeclaration videoDeclaration;
                if (a3 != null) {
                    videoDeclaration = (VideoDeclaration) a3.a(f13107b);
                } else {
                    videoDeclaration = f13106a;
                }
                if (videoDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14769a();
                        if (a3 != null) {
                            a3.a(f13107b, a2);
                        } else {
                            f13106a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = videoDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

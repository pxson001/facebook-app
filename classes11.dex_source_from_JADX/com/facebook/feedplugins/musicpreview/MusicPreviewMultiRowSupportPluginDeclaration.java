package com.facebook.feedplugins.musicpreview;

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
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_tapped_collapsed_inline_sprout_event */
public class MusicPreviewMultiRowSupportPluginDeclaration implements FeedRowSupportDeclaration {
    private static MusicPreviewMultiRowSupportPluginDeclaration f8058b;
    private static final Object f8059c = new Object();
    private final MusicPreviewUtils f8060a;

    private static MusicPreviewMultiRowSupportPluginDeclaration m9104b(InjectorLike injectorLike) {
        return new MusicPreviewMultiRowSupportPluginDeclaration(MusicPreviewUtils.m9127b(injectorLike));
    }

    @Inject
    public MusicPreviewMultiRowSupportPluginDeclaration(MusicPreviewUtils musicPreviewUtils) {
        this.f8060a = musicPreviewUtils;
    }

    public final void m9105a(ListItemRowController listItemRowController) {
        listItemRowController.a(MusicPreviewSquarePartDefinition.f8093a);
        listItemRowController.a(MusicPreviewWidePartDefinition.f8131a);
    }

    public static MusicPreviewMultiRowSupportPluginDeclaration m9103a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPreviewMultiRowSupportPluginDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8059c) {
                MusicPreviewMultiRowSupportPluginDeclaration musicPreviewMultiRowSupportPluginDeclaration;
                if (a2 != null) {
                    musicPreviewMultiRowSupportPluginDeclaration = (MusicPreviewMultiRowSupportPluginDeclaration) a2.a(f8059c);
                } else {
                    musicPreviewMultiRowSupportPluginDeclaration = f8058b;
                }
                if (musicPreviewMultiRowSupportPluginDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9104b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8059c, b3);
                        } else {
                            f8058b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPreviewMultiRowSupportPluginDeclaration;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

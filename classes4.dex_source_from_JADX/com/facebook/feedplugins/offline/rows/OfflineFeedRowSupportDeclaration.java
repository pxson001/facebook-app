package com.facebook.feedplugins.offline.rows;

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
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

@ContextScoped
/* compiled from: null passed to fromOptionEdges */
public class OfflineFeedRowSupportDeclaration implements FeedRowSupportDeclaration, RecyclableViewsDeclaration {
    private static OfflineFeedRowSupportDeclaration f6657a;
    private static final Object f6658b = new Object();

    private static OfflineFeedRowSupportDeclaration m7059a() {
        return new OfflineFeedRowSupportDeclaration();
    }

    public final void m7061a(ListItemRowController listItemRowController) {
        listItemRowController.a(OfflineSuccessPartDefinition.a);
        listItemRowController.a(OfflineFailedPartDefinition.a);
        listItemRowController.a(OfflineFailedV2PartDefinition.a);
        listItemRowController.a(OfflineProgressPartDefinition.a);
        listItemRowController.a(OfflineProgressV2PartDefinition.a);
        listItemRowController.a(OfflineRetryPartDefinition.a);
        listItemRowController.a(MediaUploadProgressPartDefinition.a);
        listItemRowController.a(MediaUploadProcessingPartDefinition.a);
    }

    public final void m7062a(RecyclableViewPoolManager recyclableViewPoolManager) {
    }

    public static OfflineFeedRowSupportDeclaration m7060a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFeedRowSupportDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6658b) {
                OfflineFeedRowSupportDeclaration offlineFeedRowSupportDeclaration;
                if (a3 != null) {
                    offlineFeedRowSupportDeclaration = (OfflineFeedRowSupportDeclaration) a3.a(f6658b);
                } else {
                    offlineFeedRowSupportDeclaration = f6657a;
                }
                if (offlineFeedRowSupportDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m7059a();
                        if (a3 != null) {
                            a3.a(f6658b, a2);
                        } else {
                            f6657a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = offlineFeedRowSupportDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

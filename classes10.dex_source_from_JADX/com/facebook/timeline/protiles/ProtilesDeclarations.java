package com.facebook.timeline.protiles;

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
import com.facebook.timeline.protiles.rows.ProtilesFooterPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesHeaderPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesListRowPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesLoadingIndicatorPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesPhotosMosaicPartDefinition;
import com.facebook.timeline.protiles.rows.ProtilesSingleRowPartDefinition;
import com.facebook.timeline.protiles.rows.TimelinePendingFriendRequestsPartDefinition;

@ContextScoped
/* compiled from: feed_filter_live */
public class ProtilesDeclarations implements FeedRowSupportDeclaration {
    private static ProtilesDeclarations f12095a;
    private static final Object f12096b = new Object();

    private static ProtilesDeclarations m12098a() {
        return new ProtilesDeclarations();
    }

    public final void m12100a(ListItemRowController listItemRowController) {
        listItemRowController.a(TimelinePendingFriendRequestsPartDefinition.f12351a);
        listItemRowController.a(ProtilesPhotosMosaicPartDefinition.f12318a);
        listItemRowController.a(ProtilesSingleRowPartDefinition.f12334a);
        listItemRowController.a(ProtilesListRowPartDefinition.f12276a);
        listItemRowController.a(ProtilesListRowPartDefinition.f12277b);
        listItemRowController.a(ProtilesLoadingIndicatorPartDefinition.f12290a);
        listItemRowController.a(ProtilesHeaderPartDefinition.f12251a);
        listItemRowController.a(ProtilesFooterPartDefinition.f12188a);
    }

    public static ProtilesDeclarations m12099a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesDeclarations a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f12096b) {
                ProtilesDeclarations protilesDeclarations;
                if (a3 != null) {
                    protilesDeclarations = (ProtilesDeclarations) a3.a(f12096b);
                } else {
                    protilesDeclarations = f12095a;
                }
                if (protilesDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m12098a();
                        if (a3 != null) {
                            a3.a(f12096b, a2);
                        } else {
                            f12095a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = protilesDeclarations;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feedplugins.saved.declarations;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feedplugins.saved.rows.SavedCollectionPartDefinition;
import com.facebook.feedplugins.saved.rows.ui.SavedCollectionItemView;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key_messenger */
public class SavedCollectionDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static SavedCollectionDeclarations f18467b;
    private static final Object f18468c = new Object();
    private final Lazy<SavedCollectionPartDefinition> f18469a;

    private static SavedCollectionDeclarations m25921b(InjectorLike injectorLike) {
        return new SavedCollectionDeclarations(IdBasedLazy.m1808a(injectorLike, 6547));
    }

    @Inject
    public SavedCollectionDeclarations(Lazy<SavedCollectionPartDefinition> lazy) {
        this.f18469a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLSavedCollectionFeedUnit.class, this.f18469a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, SavedCollectionItemView.a);
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(SavedCollectionItemView.a);
    }

    public static SavedCollectionDeclarations m25920a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18468c) {
                SavedCollectionDeclarations savedCollectionDeclarations;
                if (a2 != null) {
                    savedCollectionDeclarations = (SavedCollectionDeclarations) a2.mo818a(f18468c);
                } else {
                    savedCollectionDeclarations = f18467b;
                }
                if (savedCollectionDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25921b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18468c, b3);
                        } else {
                            f18467b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.goodwill.DailyDialogueLightweightHeaderPartDefinition;
import com.facebook.graphql.model.GraphQLCustomizedStory;
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
/* compiled from: last_head_fetch_time */
public class CustomizedStoryDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static CustomizedStoryDeclaration f17970b;
    private static final Object f17971c = new Object();
    private final Lazy<CustomizedStoryPartDefinition> f17972a;

    private static CustomizedStoryDeclaration m25215b(InjectorLike injectorLike) {
        return new CustomizedStoryDeclaration(IdBasedLazy.m1808a(injectorLike, 1844));
    }

    @Inject
    public CustomizedStoryDeclaration(Lazy<CustomizedStoryPartDefinition> lazy) {
        this.f17972a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(CustomizedStoryHeaderFbVoicePartDefinition.a);
        listItemRowController.m16558a(DailyDialogueLightweightHeaderPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLCustomizedStory.class, this.f17972a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
    }

    public static CustomizedStoryDeclaration m25214a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17971c) {
                CustomizedStoryDeclaration customizedStoryDeclaration;
                if (a2 != null) {
                    customizedStoryDeclaration = (CustomizedStoryDeclaration) a2.mo818a(f17971c);
                } else {
                    customizedStoryDeclaration = f17970b;
                }
                if (customizedStoryDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25215b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17971c, b3);
                        } else {
                            f17970b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

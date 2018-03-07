package com.facebook.feedplugins.socialgood;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

@ContextScoped
/* compiled from: keyStrength */
public class SocialGoodDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static SocialGoodDeclaration f18486a;
    private static final Object f18487b = new Object();

    private static SocialGoodDeclaration m25950a() {
        return new SocialGoodDeclaration();
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(FundraiserPageAttachmentHeaderPartDefinition.a);
        listItemRowController.m16558a(FundraiserPageAttachmentBodyPartDefinition.a);
        listItemRowController.m16558a(FundraiserPersonToCharityAttachmentFacepilePartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, FundraiserPageAttachmentHeaderPartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, FundraiserPageAttachmentBodyPartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, FundraiserPersonToCharityAttachmentFacepilePartDefinition.a);
    }

    public static SocialGoodDeclaration m25951a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialGoodDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f18487b) {
                SocialGoodDeclaration socialGoodDeclaration;
                if (a3 != null) {
                    socialGoodDeclaration = (SocialGoodDeclaration) a3.mo818a(f18487b);
                } else {
                    socialGoodDeclaration = f18486a;
                }
                if (socialGoodDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m25950a();
                        if (a3 != null) {
                            a3.mo822a(f18487b, a2);
                        } else {
                            f18486a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = socialGoodDeclaration;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}

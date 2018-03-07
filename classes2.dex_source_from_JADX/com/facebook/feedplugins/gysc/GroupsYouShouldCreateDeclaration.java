package com.facebook.feedplugins.gysc;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateHScrollRowPartDefinition;
import com.facebook.feedplugins.gysc.partdefinitions.GroupsYouShouldCreateMessengerTypePagePartDefinition;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
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
/* compiled from: last_asset_flush_check_time */
public class GroupsYouShouldCreateDeclaration implements RootPartsDeclaration, RecyclableViewsDeclaration {
    private static GroupsYouShouldCreateDeclaration f18174b;
    private static final Object f18175c = new Object();
    private final Lazy<GroupsYouShouldCreateHScrollRowPartDefinition> f18176a;

    private static GroupsYouShouldCreateDeclaration m25497b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateDeclaration(IdBasedLazy.m1808a(injectorLike, 6348));
    }

    @Inject
    public GroupsYouShouldCreateDeclaration(Lazy<GroupsYouShouldCreateHScrollRowPartDefinition> lazy) {
        this.f18176a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLGroupsYouShouldCreateFeedUnit.class, this.f18176a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(GroupsYouShouldCreateMessengerTypePagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public static GroupsYouShouldCreateDeclaration m25496a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18175c) {
                GroupsYouShouldCreateDeclaration groupsYouShouldCreateDeclaration;
                if (a2 != null) {
                    groupsYouShouldCreateDeclaration = (GroupsYouShouldCreateDeclaration) a2.mo818a(f18175c);
                } else {
                    groupsYouShouldCreateDeclaration = f18174b;
                }
                if (groupsYouShouldCreateDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25497b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18175c, b3);
                        } else {
                            f18174b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

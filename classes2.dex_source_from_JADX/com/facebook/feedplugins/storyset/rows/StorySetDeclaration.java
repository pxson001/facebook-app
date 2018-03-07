package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key= */
public class StorySetDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    public static final ViewType[] f18510a = new ViewType[]{StorySetPhotoPageRootPartDefinition.f18514a, StorySetAutoPlayPageRootPartDefinition.f18521a, StorySetVideoPageRootPartDefinition.f18527a, StorySetLoadingPageRootPartDefinition.f18533a, StorySetAppInstallPageRootPartDefinition.f18536a, VideoSetsPageItemWithActionButtonPartDefinition.f18541a, VideoSetsPageItemWithSocialContextPartDefinition.f18547a, VideoSetsPageItemWithFooterPartDefinition.f18553a, VideoSetsPageItemWithSimpleBlingbarPartDefinition.f18560a, VideoSetsBasicPageItemPartDefinition.f18566a, VideoSetsVideoPartDefinition.f18572a};
    private static StorySetDeclaration f18511c;
    private static final Object f18512d = new Object();
    private final Lazy<StorySetPartDefinition> f18513b;

    private static StorySetDeclaration m25987b(InjectorLike injectorLike) {
        return new StorySetDeclaration(IdBasedLazy.m1808a(injectorLike, 6599));
    }

    @Inject
    public StorySetDeclaration(Lazy<StorySetPartDefinition> lazy) {
        this.f18513b = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(StorySetHeaderWithIconAndMenuPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLStorySet.class, this.f18513b);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        for (ViewType a : f18510a) {
            RecyclableViewTypeUtil.a(recyclableViewPoolManager, a);
        }
    }

    public static StorySetDeclaration m25986a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18512d) {
                StorySetDeclaration storySetDeclaration;
                if (a2 != null) {
                    storySetDeclaration = (StorySetDeclaration) a2.mo818a(f18512d);
                } else {
                    storySetDeclaration = f18511c;
                }
                if (storySetDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25987b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18512d, b3);
                        } else {
                            f18511c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

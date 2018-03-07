package com.facebook.feedplugins.researchpoll;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key_value/# */
public class ResearchPollDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static ResearchPollDeclarations f18422b;
    private static final Object f18423c = new Object();
    private Lazy<ResearchPollGroupPartDefinition> f18424a;

    private static ResearchPollDeclarations m25850b(InjectorLike injectorLike) {
        return new ResearchPollDeclarations(IdBasedLazy.m1808a(injectorLike, 6516));
    }

    @Inject
    public ResearchPollDeclarations(Lazy<ResearchPollGroupPartDefinition> lazy) {
        this.f18424a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(ResearchPollSurveyPartDefinition.a, ResearchPollSingleResultPartDefinition.a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.m16558a((ViewType) of.get(i));
        }
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, ResultItemPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLResearchPollFeedUnit.class, this.f18424a);
    }

    public static ResearchPollDeclarations m25849a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResearchPollDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18423c) {
                ResearchPollDeclarations researchPollDeclarations;
                if (a2 != null) {
                    researchPollDeclarations = (ResearchPollDeclarations) a2.mo818a(f18423c);
                } else {
                    researchPollDeclarations = f18422b;
                }
                if (researchPollDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25850b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18423c, b3);
                        } else {
                            f18422b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = researchPollDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

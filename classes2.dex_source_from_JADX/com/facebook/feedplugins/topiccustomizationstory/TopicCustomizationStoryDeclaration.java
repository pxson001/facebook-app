package com.facebook.feedplugins.topiccustomizationstory;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.topiccustomizationstory.partdefinitions.TopicCustomizationStoryHScrollRowPartDefinition;
import com.facebook.feedplugins.topiccustomizationstory.partdefinitions.TopicCustomizationStoryPagePartDefinition;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
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
/* compiled from: join_approval_setting */
public class TopicCustomizationStoryDeclaration implements RootPartsDeclaration, RecyclableViewsDeclaration {
    private static TopicCustomizationStoryDeclaration f18603b;
    private static final Object f18604c = new Object();
    private final Lazy<TopicCustomizationStoryHScrollRowPartDefinition> f18605a;

    private static TopicCustomizationStoryDeclaration m26089b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryDeclaration(IdBasedLazy.m1808a(injectorLike, 6616));
    }

    @Inject
    public TopicCustomizationStoryDeclaration(Lazy<TopicCustomizationStoryHScrollRowPartDefinition> lazy) {
        this.f18605a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLTopicCustomizationStory.class, this.f18605a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(TopicCustomizationStoryPagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public static TopicCustomizationStoryDeclaration m26088a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18604c) {
                TopicCustomizationStoryDeclaration topicCustomizationStoryDeclaration;
                if (a2 != null) {
                    topicCustomizationStoryDeclaration = (TopicCustomizationStoryDeclaration) a2.mo818a(f18604c);
                } else {
                    topicCustomizationStoryDeclaration = f18603b;
                }
                if (topicCustomizationStoryDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26089b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18604c, b3);
                        } else {
                            f18603b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

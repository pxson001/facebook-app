package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: TAGS */
public class BasicFooterComponentSpec<E extends HasFeedListType & HasPersistentState> {
    public static final SparseArray<Object> f22994a = TrackingNodes.a(TrackingNode.FEEDBACK_SECTION);
    private static BasicFooterComponentSpec f22995e;
    private static final Object f22996f = new Object();
    public final BasicFooterButtonsComponent<E> f22997b;
    public final UnseenStoryManager f22998c;
    public final FooterButtonStylePartDefinition f22999d;

    private static BasicFooterComponentSpec m25483b(InjectorLike injectorLike) {
        return new BasicFooterComponentSpec(BasicFooterButtonsComponent.m25470a(injectorLike), UnseenStoryManager.a(injectorLike), FooterButtonStylePartDefinition.a(injectorLike));
    }

    @Inject
    public BasicFooterComponentSpec(BasicFooterButtonsComponent basicFooterButtonsComponent, UnseenStoryManager unseenStoryManager, FooterButtonStylePartDefinition footerButtonStylePartDefinition) {
        this.f22997b = basicFooterButtonsComponent;
        this.f22998c = unseenStoryManager;
        this.f22999d = footerButtonStylePartDefinition;
    }

    public static BasicFooterComponentSpec m25482a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22996f) {
                BasicFooterComponentSpec basicFooterComponentSpec;
                if (a2 != null) {
                    basicFooterComponentSpec = (BasicFooterComponentSpec) a2.a(f22996f);
                } else {
                    basicFooterComponentSpec = f22995e;
                }
                if (basicFooterComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25483b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22996f, b3);
                        } else {
                            f22995e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

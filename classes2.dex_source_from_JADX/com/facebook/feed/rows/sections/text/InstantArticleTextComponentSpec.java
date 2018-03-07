package com.facebook.feed.rows.sections.text;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@LayoutSpec
@ContextScoped
/* compiled from: home_stories_story_type_index */
public class InstantArticleTextComponentSpec<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState> {
    private static InstantArticleTextComponentSpec f20909d;
    private static final Object f20910e = new Object();
    public final ContentTextComponent<E> f20911a;
    private final InstantArticleClickTextPartDefinition f20912b;
    public final Provider<InstantArticleClickWithPositionListener> f20913c;

    private static InstantArticleTextComponentSpec m28639b(InjectorLike injectorLike) {
        return new InstantArticleTextComponentSpec(ContentTextComponent.m28640a(injectorLike), InstantArticleClickTextPartDefinition.m28579a(injectorLike), IdBasedProvider.m1811a(injectorLike, 6045));
    }

    @Inject
    public InstantArticleTextComponentSpec(ContentTextComponent contentTextComponent, InstantArticleClickTextPartDefinition instantArticleClickTextPartDefinition, Provider<InstantArticleClickWithPositionListener> provider) {
        this.f20911a = contentTextComponent;
        this.f20912b = instantArticleClickTextPartDefinition;
        this.f20913c = provider;
    }

    public static InstantArticleTextComponentSpec m28638a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleTextComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20910e) {
                InstantArticleTextComponentSpec instantArticleTextComponentSpec;
                if (a2 != null) {
                    instantArticleTextComponentSpec = (InstantArticleTextComponentSpec) a2.mo818a(f20910e);
                } else {
                    instantArticleTextComponentSpec = f20909d;
                }
                if (instantArticleTextComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28639b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20910e, b3);
                        } else {
                            f20909d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleTextComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

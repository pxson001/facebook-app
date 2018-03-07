package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.widget.TouchSpringIconComponent;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.glyph.GlyphColorizerDrawableReference.Builder;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.StoryActionLinkUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: freshfeed_db_fetcher */
public class HeaderLikeButtonComponentSpec<E extends CanLikePage & HasPersistentState> {
    private static final int[] f23201a = new int[]{16842913};
    private static HeaderLikeButtonComponentSpec f23202g;
    private static final Object f23203h = new Object();
    private final TouchSpringIconComponent<E> f23204b;
    private final GlyphColorizerDrawableReference f23205c;
    public final GatekeeperStoreImpl f23206d;
    public final StoryActionLinkUtil f23207e;
    private final ColorStateList f23208f;

    private static HeaderLikeButtonComponentSpec m31313b(InjectorLike injectorLike) {
        return new HeaderLikeButtonComponentSpec(TouchSpringIconComponent.m28303a(injectorLike), GlyphColorizerDrawableReference.m28322a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), StoryActionLinkUtil.m28026b(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public HeaderLikeButtonComponentSpec(TouchSpringIconComponent touchSpringIconComponent, GlyphColorizerDrawableReference glyphColorizerDrawableReference, GatekeeperStoreImpl gatekeeperStoreImpl, StoryActionLinkUtil storyActionLinkUtil, Resources resources) {
        this.f23204b = touchSpringIconComponent;
        this.f23205c = glyphColorizerDrawableReference;
        this.f23206d = gatekeeperStoreImpl;
        this.f23207e = storyActionLinkUtil;
        this.f23208f = resources.getColorStateList(2131364107);
    }

    public static HeaderLikeButtonComponentSpec m31312a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderLikeButtonComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23203h) {
                HeaderLikeButtonComponentSpec headerLikeButtonComponentSpec;
                if (a2 != null) {
                    headerLikeButtonComponentSpec = (HeaderLikeButtonComponentSpec) a2.mo818a(f23203h);
                } else {
                    headerLikeButtonComponentSpec = f23202g;
                }
                if (headerLikeButtonComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31313b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23203h, b3);
                        } else {
                            f23202g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerLikeButtonComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m31314a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        int[] iArr = null;
        GraphQLStoryActionLink a = this.f23207e.m28027a(feedProps);
        if (a == null) {
            return null;
        }
        GraphQLPage ab = a.ab();
        boolean O = ab.m23463O();
        Builder h = this.f23205c.m28324a(componentContext).h(2130840276);
        ColorStateList colorStateList = this.f23208f;
        if (O) {
            iArr = f23201a;
        }
        return this.f23204b.m28305a(componentContext).a(h.i(colorStateList.getColorForState(iArr, this.f23208f.getDefaultColor())).mo3297b()).a((HasPersistentState) e).a(ab.ae()).a((CacheableEntity) feedProps.f13444a).m30663c().mo3311a(ComponentLifecycle.m28112a(componentContext, 839108621, null)).mo3338h(8, 2).mo3330d(1, 2).mo3343j();
    }
}

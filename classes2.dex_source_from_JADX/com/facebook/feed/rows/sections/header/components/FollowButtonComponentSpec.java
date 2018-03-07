package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.widget.TouchSpringIconComponent;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.glyph.GlyphColorizerDrawableReference.Builder;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.FollowUserButtonPartDefinition;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: ignore_old_datasource @ onNewResult */
public class FollowButtonComponentSpec<E extends CanFollowUser & HasPersistentState> {
    static final int f20561a = 2130839875;
    static final int f20562b = 2130839874;
    private static final int[] f20563c = new int[]{16842913};
    private static FollowButtonComponentSpec f20564g;
    private static final Object f20565h = new Object();
    private final TouchSpringIconComponent<E> f20566d;
    private final GlyphColorizerDrawableReference f20567e;
    private final ColorStateList f20568f;

    private static FollowButtonComponentSpec m28301b(InjectorLike injectorLike) {
        return new FollowButtonComponentSpec(TouchSpringIconComponent.m28303a(injectorLike), GlyphColorizerDrawableReference.m28322a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public FollowButtonComponentSpec(TouchSpringIconComponent touchSpringIconComponent, GlyphColorizerDrawableReference glyphColorizerDrawableReference, Resources resources) {
        this.f20566d = touchSpringIconComponent;
        this.f20567e = glyphColorizerDrawableReference;
        this.f20568f = resources.getColorStateList(2131364107);
    }

    public static FollowButtonComponentSpec m28299a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowButtonComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20565h) {
                FollowButtonComponentSpec followButtonComponentSpec;
                if (a2 != null) {
                    followButtonComponentSpec = (FollowButtonComponentSpec) a2.mo818a(f20565h);
                } else {
                    followButtonComponentSpec = f20564g;
                }
                if (followButtonComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28301b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20565h, b3);
                        } else {
                            f20564g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followButtonComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m28302a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, String str, GraphQLSubscribeStatus graphQLSubscribeStatus, E e, int i, int i2) {
        Object obj = graphQLSubscribeStatus == GraphQLSubscribeStatus.IS_SUBSCRIBED ? 1 : null;
        Builder a = this.f20567e.m28324a(componentContext);
        if (obj == null) {
            i = i2;
        }
        return this.f20566d.m28305a(componentContext).a(a.h(i).i(this.f20568f.getColorForState(obj != null ? f20563c : null, this.f20568f.getDefaultColor())).mo3297b()).a((HasPersistentState) e).a(str).a((CacheableEntity) feedProps.f13444a).m30663c().mo3311a(ComponentLifecycle.m28112a(componentContext, 1523724257, null)).mo3343j();
    }

    protected static void m28300a(View view, String str, GraphQLSubscribeStatus graphQLSubscribeStatus, SubscribeLocation subscribeLocation, ActorUnsubscribeInputData.SubscribeLocation subscribeLocation2, E e) {
        FollowUserButtonPartDefinition.m28455a(str, graphQLSubscribeStatus, subscribeLocation, subscribeLocation2, e).onClick(view);
    }
}

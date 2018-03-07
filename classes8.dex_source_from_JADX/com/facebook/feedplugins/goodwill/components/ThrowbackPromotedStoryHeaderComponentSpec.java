package com.facebook.feedplugins.goodwill.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.VerticalGravity;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponent;
import com.facebook.feedplugins.goodwill.DefaultThrowbackPromotedStoryHeaderPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: getMediaItem is null */
public class ThrowbackPromotedStoryHeaderComponentSpec<E extends HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> {
    private static ThrowbackPromotedStoryHeaderComponentSpec f12672d;
    private static final Object f12673e = new Object();
    private final Context f12674a;
    private final GatekeeperStoreImpl f12675b;
    private final DefaultHeaderComponent<E> f12676c;

    private static ThrowbackPromotedStoryHeaderComponentSpec m14493b(InjectorLike injectorLike) {
        return new ThrowbackPromotedStoryHeaderComponentSpec((Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultHeaderComponent.a(injectorLike));
    }

    public static ThrowbackPromotedStoryHeaderComponentSpec m14492a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotedStoryHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12673e) {
                ThrowbackPromotedStoryHeaderComponentSpec throwbackPromotedStoryHeaderComponentSpec;
                if (a2 != null) {
                    throwbackPromotedStoryHeaderComponentSpec = (ThrowbackPromotedStoryHeaderComponentSpec) a2.a(f12673e);
                } else {
                    throwbackPromotedStoryHeaderComponentSpec = f12672d;
                }
                if (throwbackPromotedStoryHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14493b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12673e, b3);
                        } else {
                            f12672d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotedStoryHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackPromotedStoryHeaderComponentSpec(Context context, GatekeeperStoreImpl gatekeeperStoreImpl, DefaultHeaderComponent defaultHeaderComponent) {
        this.f12674a = context;
        this.f12675b = gatekeeperStoreImpl;
        this.f12676c = defaultHeaderComponent;
    }

    protected final ComponentLayout m14494a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        ContainerBuilder a = Container.a(componentContext).C(2).E(2).a(this.f12676c.a(componentContext).a(feedProps).a((HasFeedListType) e).c().a(1.0f).j());
        if (this.f12675b.a(860, false)) {
            return a.j();
        }
        a.a(Container.a(componentContext).v(1).w(0).y(0).x(0).z(0).D(2).C(2).a(Container.a(componentContext).C(2).B(0).k(1, 12).k(2, 8).G(2130843606).u(2).a(Image.a(componentContext).h(2130843600).c().g(4, 2131432770).g(2, 2131432765)).a(Text.a(componentContext).l(2131361920).o(2131427400).a(VerticalGravity.CENTER).a(DefaultThrowbackPromotedStoryHeaderPartDefinition.m14180a(feedProps, componentContext)).c()).o(4, 6).o(5, 12)));
        return a.j();
    }
}

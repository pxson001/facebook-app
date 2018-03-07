package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ufi.UFIParams;
import com.facebook.feed.ufi.UFIParams.I18nStyleType;
import com.facebook.feed.ufi.UFIStyle;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
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
/* compiled from: TAG_PEOPLE_FOR_CHECKIN */
public class BasicFooterButtonsComponentSpec<E extends HasFeedListType & HasPersistentState> {
    private static BasicFooterButtonsComponentSpec f22980c;
    private static final Object f22981d = new Object();
    private final BasicFooterButtonComponent<E> f22982a;
    private final UFIStyle f22983b;

    private static BasicFooterButtonsComponentSpec m25476b(InjectorLike injectorLike) {
        return new BasicFooterButtonsComponentSpec(BasicFooterButtonComponent.m25456a(injectorLike), FooterButtonStylePartDefinition.a(injectorLike));
    }

    @Inject
    public BasicFooterButtonsComponentSpec(BasicFooterButtonComponent basicFooterButtonComponent, FooterButtonStylePartDefinition footerButtonStylePartDefinition) {
        this.f22982a = basicFooterButtonComponent;
        this.f22983b = footerButtonStylePartDefinition.a();
    }

    protected final ComponentLayout m25477a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, boolean z, boolean z2, boolean z3, DownstateType downstateType, int i, E e) {
        int i2;
        int i3 = 1;
        ContainerBuilder D = Container.a(componentContext).C(2).A(2131427485).D(1);
        UFIParams a = this.f22983b.a(z, z2, z3);
        I18nStyleType a2 = a.a(i);
        boolean hasIcons = I18nStyleType.hasIcons(a2);
        float[] a3 = a.a(a2);
        if (z) {
            D.a(this.f22982a.m25460a(componentContext).m25450a((FeedProps) feedProps).m25452a(FooterButtonId.LIKE).m25451a(downstateType).m25449a((HasFeedListType) e).m25453a(hasIcons).c().a(a3[0]));
        } else {
            i3 = 0;
        }
        if (z2) {
            i2 = i3 + 1;
            D.a(this.f22982a.m25460a(componentContext).m25450a((FeedProps) feedProps).m25452a(FooterButtonId.COMMENT).m25451a(downstateType).m25449a((HasFeedListType) e).m25453a(hasIcons).c().a(a3[i3]));
        } else {
            i2 = i3;
        }
        if (z3) {
            D.a(this.f22982a.m25460a(componentContext).m25450a((FeedProps) feedProps).m25452a(FooterButtonId.SHARE).m25451a(downstateType).m25449a((HasFeedListType) e).m25453a(hasIcons).c().a(a3[i2]));
        }
        return D.j();
    }

    public static BasicFooterButtonsComponentSpec m25475a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterButtonsComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22981d) {
                BasicFooterButtonsComponentSpec basicFooterButtonsComponentSpec;
                if (a2 != null) {
                    basicFooterButtonsComponentSpec = (BasicFooterButtonsComponentSpec) a2.a(f22981d);
                } else {
                    basicFooterButtonsComponentSpec = f22980c;
                }
                if (basicFooterButtonsComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25476b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22981d, b3);
                        } else {
                            f22980c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterButtonsComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

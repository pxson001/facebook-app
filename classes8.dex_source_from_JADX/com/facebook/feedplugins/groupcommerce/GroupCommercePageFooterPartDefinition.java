package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: from_checkin */
public class GroupCommercePageFooterPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultFooterView> {
    private static GroupCommercePageFooterPartDefinition f12754c;
    private static final Object f12755d = new Object();
    private final BasicFooterPartDefinition f12756a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f12757b;

    private static GroupCommercePageFooterPartDefinition m14555b(InjectorLike injectorLike) {
        return new GroupCommercePageFooterPartDefinition(BasicFooterPartDefinition.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14556a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12757b, new Props(feedProps, FooterLevel.PAGE));
        subParts.a(this.f12756a, new BasicFooterPartDefinition.Props(feedProps, true));
        return null;
    }

    @Inject
    public GroupCommercePageFooterPartDefinition(BasicFooterPartDefinition basicFooterPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition) {
        this.f12756a = basicFooterPartDefinition;
        this.f12757b = footerBackgroundPartDefinition;
    }

    public static GroupCommercePageFooterPartDefinition m14554a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommercePageFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12755d) {
                GroupCommercePageFooterPartDefinition groupCommercePageFooterPartDefinition;
                if (a2 != null) {
                    groupCommercePageFooterPartDefinition = (GroupCommercePageFooterPartDefinition) a2.a(f12755d);
                } else {
                    groupCommercePageFooterPartDefinition = f12754c;
                }
                if (groupCommercePageFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14555b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12755d, b3);
                        } else {
                            f12754c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommercePageFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

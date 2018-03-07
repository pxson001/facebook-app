package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_required_space */
public class FooterBackgroundPartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, V> {
    private static FooterBackgroundPartDefinition f21295c;
    private static final Object f21296d = new Object();
    private final Lazy<FbErrorReporter> f21297a;
    private final Lazy<DefaultFooterBackgroundPartDefinition<V>> f21298b;

    /* compiled from: has_required_space */
    public class Props {
        public final FeedProps<GraphQLStory> f22358a;
        public final FooterLevel f22359b;

        public Props(FeedProps<GraphQLStory> feedProps, FooterLevel footerLevel) {
            this.f22358a = feedProps;
            this.f22359b = footerLevel;
        }
    }

    private static FooterBackgroundPartDefinition m28998b(InjectorLike injectorLike) {
        return new FooterBackgroundPartDefinition(IdBasedLazy.m1808a(injectorLike, 1822), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLStory graphQLStory = (GraphQLStory) props.f22358a.f13444a;
        if (props.f22359b == null) {
            SoftErrorBuilder a = SoftError.a("Null_Footer_Level", "Debug info: \n" + graphQLStory.S_());
            a.d = true;
            ((AbstractFbErrorReporter) this.f21297a.get()).mo336a(a.g());
        }
        subParts.mo2756a((SinglePartDefinition) this.f21298b.get(), new com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props(graphQLStory.m22369z(), graphQLStory.m22315A(), StorySharingHelper.m30305b(graphQLStory), props.f22359b, props.f22358a));
        return null;
    }

    @Inject
    public FooterBackgroundPartDefinition(Lazy<DefaultFooterBackgroundPartDefinition> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f21298b = lazy;
        this.f21297a = lazy2;
    }

    public static FooterBackgroundPartDefinition m28997a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21296d) {
                FooterBackgroundPartDefinition footerBackgroundPartDefinition;
                if (a2 != null) {
                    footerBackgroundPartDefinition = (FooterBackgroundPartDefinition) a2.mo818a(f21296d);
                } else {
                    footerBackgroundPartDefinition = f21295c;
                }
                if (footerBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28998b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21296d, b3);
                        } else {
                            f21295c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = footerBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

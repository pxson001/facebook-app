package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils.TruncateAt;
import android.util.SparseArray;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.images.FbFeedFrescoComponent;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition.Props;
import com.facebook.feedplugins.pyml.rows.PymlSpannableHeaderBuilder;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: android_calling_package */
public class PageYouMayLikeBodyHeaderComponentSpec<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> {
    private static final SparseArray<Object> f19726a = new SparseArray();
    private static final CallerContext f19727b = CallerContext.a(PageYouMayLikeBodyHeaderComponentSpec.class, "native_newsfeed", "actor_photo");
    private static PageYouMayLikeBodyHeaderComponentSpec f19728e;
    private static final Object f19729f = new Object();
    private final FbFeedFrescoComponent f19730c;
    private final PymlSpannableHeaderBuilder f19731d;

    private static PageYouMayLikeBodyHeaderComponentSpec m20000b(InjectorLike injectorLike) {
        return new PageYouMayLikeBodyHeaderComponentSpec(FbFeedFrescoComponent.a(injectorLike), PymlSpannableHeaderBuilder.b(injectorLike));
    }

    public static PageYouMayLikeBodyHeaderComponentSpec m19999a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeBodyHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19729f) {
                PageYouMayLikeBodyHeaderComponentSpec pageYouMayLikeBodyHeaderComponentSpec;
                if (a2 != null) {
                    pageYouMayLikeBodyHeaderComponentSpec = (PageYouMayLikeBodyHeaderComponentSpec) a2.a(f19729f);
                } else {
                    pageYouMayLikeBodyHeaderComponentSpec = f19728e;
                }
                if (pageYouMayLikeBodyHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20000b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19729f, b3);
                        } else {
                            f19728e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeBodyHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageYouMayLikeBodyHeaderComponentSpec(FbFeedFrescoComponent fbFeedFrescoComponent, PymlSpannableHeaderBuilder pymlSpannableHeaderBuilder) {
        this.f19730c = fbFeedFrescoComponent;
        this.f19731d = pymlSpannableHeaderBuilder;
    }

    public final ComponentLayout m20001a(ComponentContext componentContext, E e, Props props) {
        Spannable a = this.f19731d.a(props.a, props.b);
        CharSequence b = EgoUnitUtil.b(componentContext, props.b);
        SponsoredImpression ab_ = props.b.ab_();
        boolean z = ab_ != null && ab_.k();
        return Container.a(componentContext).C(2).j(3, 2131427640).n(5, 2131428854).n(1, 2131428895).a(m19998a(componentContext, props, FeedProps.c(props.a), e)).a(Container.a(componentContext).C(0).b(1.0f).a(m19997a(componentContext, a, z)).a(Text.a(componentContext).a(false).a(b).l(2131362754).o(2131427400))).j();
    }

    private Builder m19998a(ComponentContext componentContext, Props props, FeedProps feedProps, E e) {
        return this.f19730c.a(componentContext).a((HasFeedListType) e).a(feedProps).a(ImageUtil.a(EgoUnitUtil.b(props.b))).a(f19727b).c().l(2131428825).p(2131428825).c(2, 2131428854).c(7, 2131428854);
    }

    private static Builder m19997a(ComponentContext componentContext, Spannable spannable, boolean z) {
        if (f19726a.size() == 0) {
            f19726a.put(2131558541, Boolean.valueOf(z));
        }
        return Text.a(componentContext).a(TruncateAt.END).b(true).a(false).a(spannable).o(2131427402).r(1).c().a(z ? f19726a : null);
    }
}

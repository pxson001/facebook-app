package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition.Props;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_user_entered_video_home_tab */
public class FooterPartDefinition<V extends View & Footer> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanFeedback, V> {
    private static FooterPartDefinition f21250c;
    private static final Object f21251d = new Object();
    private final GraphQLStoryUtil f21252a;
    private final BasicFooterPartDefinition f21253b;

    private static FooterPartDefinition m28969b(InjectorLike injectorLike) {
        return new FooterPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), BasicFooterPartDefinition.m28974a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f21253b, new Props((FeedProps) obj, true));
        return null;
    }

    @Inject
    public FooterPartDefinition(GraphQLStoryUtil graphQLStoryUtil, BasicFooterPartDefinition basicFooterPartDefinition) {
        this.f21252a = graphQLStoryUtil;
        this.f21253b = basicFooterPartDefinition;
    }

    public final ViewType mo2547a() {
        return DefaultFooterView.f22314a;
    }

    public final boolean m28972a(FeedProps<GraphQLStory> feedProps) {
        return this.f21252a.m9594c(feedProps);
    }

    public static FooterPartDefinition m28968a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21251d) {
                FooterPartDefinition footerPartDefinition;
                if (a2 != null) {
                    footerPartDefinition = (FooterPartDefinition) a2.mo818a(f21251d);
                } else {
                    footerPartDefinition = f21250c;
                }
                if (footerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28969b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21251d, b3);
                        } else {
                            f21250c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = footerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

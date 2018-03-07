package com.facebook.feedplugins.profile.introcard.favphotos;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.photosfeed.SnowflakeLauncherHelper;
import com.facebook.feedplugins.profile.ui.CenteredButtonView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: imp_phase */
public class ViewAllFavPhotosPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, String, FeedEnvironment, CenteredButtonView> {
    private static ViewAllFavPhotosPartDefinition f20343d;
    private static final Object f20344e = new Object();
    private final Lazy<ClickListenerPartDefinition> f20345a;
    private final Lazy<SnowflakeLauncherHelper> f20346b;
    private final Lazy<Resources> f20347c;

    private static ViewAllFavPhotosPartDefinition m28006b(InjectorLike injectorLike) {
        return new ViewAllFavPhotosPartDefinition(IdBasedLazy.m1808a(injectorLike, 2770), IdBasedLazy.m1808a(injectorLike, 1496), IdBasedSingletonScopeProvider.m1810b(injectorLike, 30));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a((SinglePartDefinition) this.f20345a.get(), new 1(this, (FeedProps) obj, (FeedEnvironment) anyEnvironment));
        return ((Resources) this.f20347c.get()).getString(2131239209);
    }

    public final boolean m28010a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return (StoryAttachmentHelper.m28042o(graphQLStory) == null || ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory)) == null || ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory)).m22901a() == null || ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory)).m22901a().m22301g() != 180534125) ? false : true;
    }

    @Inject
    public ViewAllFavPhotosPartDefinition(Lazy<ClickListenerPartDefinition> lazy, Lazy<SnowflakeLauncherHelper> lazy2, Lazy<Resources> lazy3) {
        this.f20345a = lazy;
        this.f20346b = lazy2;
        this.f20347c = lazy3;
    }

    public final ViewType mo2547a() {
        return CenteredButtonView.a;
    }

    public static ViewAllFavPhotosPartDefinition m28004a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewAllFavPhotosPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20344e) {
                ViewAllFavPhotosPartDefinition viewAllFavPhotosPartDefinition;
                if (a2 != null) {
                    viewAllFavPhotosPartDefinition = (ViewAllFavPhotosPartDefinition) a2.mo818a(f20344e);
                } else {
                    viewAllFavPhotosPartDefinition = f20343d;
                }
                if (viewAllFavPhotosPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28006b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20344e, b3);
                        } else {
                            f20343d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = viewAllFavPhotosPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static void m28005a(ViewAllFavPhotosPartDefinition viewAllFavPhotosPartDefinition, View view, FeedProps feedProps, FeedEnvironment feedEnvironment) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a);
        ((SnowflakeLauncherHelper) viewAllFavPhotosPartDefinition.f20346b.get()).m29263a(StoryProps.m27461i(feedProps), 0, view, feedEnvironment.mo2446c(), o.m23979r() != null ? o.m23979r().m24452b() : null, false, null, feedEnvironment);
    }
}

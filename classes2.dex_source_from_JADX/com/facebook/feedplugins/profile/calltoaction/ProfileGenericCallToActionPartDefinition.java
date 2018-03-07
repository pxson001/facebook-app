package com.facebook.feedplugins.profile.calltoaction;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
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
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: feedback_reaction */
public class ProfileGenericCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static ProfileGenericCallToActionPartDefinition f24409d;
    private static final Object f24410e = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f24411a;
    public final Lazy<UriIntentMapper> f24412b;
    public final Lazy<SecureContextHelper> f24413c;

    private static ProfileGenericCallToActionPartDefinition m32712b(InjectorLike injectorLike) {
        return new ProfileGenericCallToActionPartDefinition(IdBasedLazy.m1808a(injectorLike, 1837), IdBasedProvider.m1811a(injectorLike, 4442), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2436), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a((SinglePartDefinition) this.f24411a.get(), Props.a(feedProps, null, new 1(this, ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a))), null, null));
        return null;
    }

    public final boolean m32715a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        if (StoryActorHelper.m27492b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.m28863b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory));
        if (a.m22901a() == null || a.m22901a().m22301g() != -1260727392 || StringUtil.m3599c(a.aE())) {
            return false;
        }
        return true;
    }

    @Inject
    public ProfileGenericCallToActionPartDefinition(Lazy<ActionLinkCallToActionPartDefinition> lazy, Provider<String> provider, Lazy<UriIntentMapper> lazy2, Lazy<SecureContextHelper> lazy3) {
        this.f24411a = lazy;
        this.f24412b = lazy2;
        this.f24413c = lazy3;
    }

    public static ProfileGenericCallToActionPartDefinition m32711a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileGenericCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24410e) {
                ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition;
                if (a2 != null) {
                    profileGenericCallToActionPartDefinition = (ProfileGenericCallToActionPartDefinition) a2.mo818a(f24410e);
                } else {
                    profileGenericCallToActionPartDefinition = f24409d;
                }
                if (profileGenericCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32712b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24410e, b3);
                        } else {
                            f24409d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = profileGenericCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<ActionLinkCallToActionView> mo2547a() {
        return ActionLinkCallToActionView.h;
    }
}

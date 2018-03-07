package com.facebook.feedplugins.profile.calltoaction;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: feedback_reaction_settings_fetch */
public class CreateProfileVideoCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static CreateProfileVideoCallToActionPartDefinition f24401g;
    private static final Object f24402h = new Object();
    private final Lazy<ActionLinkCallToActionPartDefinition> f24403a;
    private final QeAccessor f24404b;
    @LoggedInUserId
    public final Provider<String> f24405c;
    public final Lazy<UriIntentMapper> f24406d;
    public final Lazy<SecureContextHelper> f24407e;
    public final Lazy<ProfileVideoSessionTracker> f24408f;

    private static CreateProfileVideoCallToActionPartDefinition m32707b(InjectorLike injectorLike) {
        return new CreateProfileVideoCallToActionPartDefinition(QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1837), IdBasedProvider.m1811a(injectorLike, 4442), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2436), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11313));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_action_on_fragment_create_create_profile_video", true);
        subParts.mo2756a((SinglePartDefinition) this.f24403a.get(), Props.a(feedProps, null, ProfileCallToActionHelper.a(bundle, this.f24405c, (UriIntentMapper) this.f24406d.get(), (SecureContextHelper) this.f24407e.get(), new 1(this, o)), null, null));
        ((ProfileVideoSessionTracker) this.f24408f.get()).b(ProfileVideoEvent.CALL_TO_ACTION_BUTTON_IMPRESSION, o.m23979r() == null ? "" : o.m23979r().m24452b());
        return null;
    }

    public final boolean m32710a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        if (!this.f24404b.mo596a(ExperimentsForTimelineAbTestModule.aK, false) || StoryActorHelper.m27492b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.m28863b(graphQLStory)) {
            return false;
        }
        GraphQLObjectType a = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory)).m22901a();
        return a != null && a.m22301g() == 692952418;
    }

    @Inject
    public CreateProfileVideoCallToActionPartDefinition(QeAccessor qeAccessor, Lazy<ActionLinkCallToActionPartDefinition> lazy, Provider<String> provider, Lazy<UriIntentMapper> lazy2, Lazy<SecureContextHelper> lazy3, Lazy<ProfileVideoSessionTracker> lazy4) {
        this.f24403a = lazy;
        this.f24404b = qeAccessor;
        this.f24405c = provider;
        this.f24406d = lazy2;
        this.f24407e = lazy3;
        this.f24408f = lazy4;
    }

    public static CreateProfileVideoCallToActionPartDefinition m32706a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CreateProfileVideoCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24402h) {
                CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition;
                if (a2 != null) {
                    createProfileVideoCallToActionPartDefinition = (CreateProfileVideoCallToActionPartDefinition) a2.mo818a(f24402h);
                } else {
                    createProfileVideoCallToActionPartDefinition = f24401g;
                }
                if (createProfileVideoCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32707b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24402h, b3);
                        } else {
                            f24401g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = createProfileVideoCallToActionPartDefinition;
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

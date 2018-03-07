package com.facebook.feedplugins.profile.calltoaction;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.heisman.ProfilePictureOverlayActivityLauncher;
import com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: feedback_reactions_nux_interaction */
public class ProfilePictureOverlayCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static ProfilePictureOverlayCallToActionPartDefinition f24376i;
    private static final Object f24377j = new Object();
    private final ActionLinkCallToActionPartDefinition<E> f24378a;
    public final Provider<ProfilePictureOverlayActivityLauncher> f24379b;
    public final Provider<ProfilePictureOverlayAnalyticsLogger> f24380c;
    public final GraphQLLinkExtractor f24381d;
    public final Provider<IFeedIntentBuilder> f24382e;
    public final QeAccessor f24383f;
    public final Lazy<ComposerLauncher> f24384g;
    public final Lazy<JsonPluginConfigSerializer> f24385h;

    private static ProfilePictureOverlayCallToActionPartDefinition m32689b(InjectorLike injectorLike) {
        return new ProfilePictureOverlayCallToActionPartDefinition(ActionLinkCallToActionPartDefinition.m28859a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 7160), IdBasedSingletonScopeProvider.m1809a(injectorLike, 7161), GraphQLLinkExtractor.m26442a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2347), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 849), IdBasedLazy.m1808a(injectorLike, 2370));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object a;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStoryActionLink a2 = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory));
        if (GraphQLProfilePictureActionLinkType.BIRTHDAY_WISHES.equals(a2.m22905j())) {
            a = Props.a(feedProps, null, new 1(this, graphQLStory), null, null);
        } else {
            a = Props.a(feedProps, new 3(this, a2, graphQLStory), new 2(this, a2, graphQLStory), ImageUtil.m26990a(a2.ah().ai()), null);
        }
        subParts.mo2756a(this.f24378a, a);
        return null;
    }

    public final boolean m32692a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        if (!this.f24383f.mo596a(ExperimentsForProfilePictureOverlayAbTestModule.f24444b, false) || StoryActorHelper.m27492b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.m28863b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory));
        GraphQLObjectType a2 = a.m22901a();
        GraphQLActor b = StoryActorHelper.m27492b(graphQLStory);
        return (a2 == null || a2.m22301g() != -1029190389 || a.ah() == null || a.ah().ai() == null || b == null || TextUtils.isEmpty(b.m23765H()) || TextUtils.isEmpty(b.aa()) || b.ai() == null || TextUtils.isEmpty(b.ai().mo2924b())) ? false : true;
    }

    public static ProfilePictureOverlayCallToActionPartDefinition m32688a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfilePictureOverlayCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24377j) {
                ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition;
                if (a2 != null) {
                    profilePictureOverlayCallToActionPartDefinition = (ProfilePictureOverlayCallToActionPartDefinition) a2.mo818a(f24377j);
                } else {
                    profilePictureOverlayCallToActionPartDefinition = f24376i;
                }
                if (profilePictureOverlayCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32689b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24377j, b3);
                        } else {
                            f24376i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = profilePictureOverlayCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ProfilePictureOverlayCallToActionPartDefinition(ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition, Provider<ProfilePictureOverlayActivityLauncher> provider, Provider<ProfilePictureOverlayAnalyticsLogger> provider2, GraphQLLinkExtractor graphQLLinkExtractor, Provider<IFeedIntentBuilder> provider3, QeAccessor qeAccessor, Lazy<ComposerLauncher> lazy, Lazy<JsonPluginConfigSerializer> lazy2) {
        this.f24378a = actionLinkCallToActionPartDefinition;
        this.f24379b = provider;
        this.f24380c = provider2;
        this.f24381d = graphQLLinkExtractor;
        this.f24382e = provider3;
        this.f24383f = qeAccessor;
        this.f24384g = lazy;
        this.f24385h = lazy2;
    }

    public final ViewType<ActionLinkCallToActionView> mo2547a() {
        return ActionLinkCallToActionView.h;
    }
}

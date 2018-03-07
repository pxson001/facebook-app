package com.facebook.feedplugins.profile.calltoaction;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition.Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: feedback_reactions/ */
public class CreateProfilePictureCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static CreateProfilePictureCallToActionPartDefinition f24394f;
    private static final Object f24395g = new Object();
    private final ActionLinkCallToActionPartDefinition<E> f24396a;
    private final QeAccessor f24397b;
    @LoggedInUserId
    public final Provider<String> f24398c;
    public final UriIntentMapper f24399d;
    public final SecureContextHelper f24400e;

    private static CreateProfilePictureCallToActionPartDefinition m32702b(InjectorLike injectorLike) {
        return new CreateProfilePictureCallToActionPartDefinition(ActionLinkCallToActionPartDefinition.m28859a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), Fb4aUriIntentMapper.m8640a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLProfilePictureActionLinkType j = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a)).m22905j();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_action_on_fragment_create", j);
        subParts.mo2756a(this.f24396a, Props.a(feedProps, null, ProfileCallToActionHelper.a(bundle, this.f24398c, this.f24399d, this.f24400e, null), null, null));
        return null;
    }

    public final boolean m32705a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        if (StoryActorHelper.m27492b(graphQLStory) == null || !ActionLinkCallToActionPartDefinition.m28863b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22935a(StoryAttachmentHelper.m28042o(graphQLStory));
        GraphQLObjectType a2 = a.m22901a();
        if (a2 == null || a2.m22301g() != 1526426725 || a.aB() == null) {
            return false;
        }
        GraphQLProfilePictureActionLinkType j = a.m22905j();
        if (j == null) {
            return false;
        }
        switch (1.a[j.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return true;
            default:
                return false;
        }
    }

    @Inject
    public CreateProfilePictureCallToActionPartDefinition(ActionLinkCallToActionPartDefinition actionLinkCallToActionPartDefinition, QeAccessor qeAccessor, Provider<String> provider, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper) {
        this.f24396a = actionLinkCallToActionPartDefinition;
        this.f24397b = qeAccessor;
        this.f24398c = provider;
        this.f24399d = uriIntentMapper;
        this.f24400e = secureContextHelper;
    }

    public static CreateProfilePictureCallToActionPartDefinition m32701a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CreateProfilePictureCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24395g) {
                CreateProfilePictureCallToActionPartDefinition createProfilePictureCallToActionPartDefinition;
                if (a2 != null) {
                    createProfilePictureCallToActionPartDefinition = (CreateProfilePictureCallToActionPartDefinition) a2.mo818a(f24395g);
                } else {
                    createProfilePictureCallToActionPartDefinition = f24394f;
                }
                if (createProfilePictureCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32702b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24395g, b3);
                        } else {
                            f24394f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = createProfilePictureCallToActionPartDefinition;
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

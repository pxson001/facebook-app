package com.facebook.productionprompts.actionhandlers;

import android.app.Activity;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.heisman.ProfilePictureOverlayActivityLauncher;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel.Builder;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel.ImageModel;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mobile_supl */
public class ProfilePhotoOverlayPromptActionHandler<CONTEXT extends PromptActionContext & HasPromptSessionId> implements PromptActionHandler<CONTEXT> {
    private final Provider<ProfilePictureOverlayActivityLauncher> f13383a;

    @Inject
    public ProfilePhotoOverlayPromptActionHandler(Provider<ProfilePictureOverlayActivityLauncher> provider) {
        this.f13383a = provider;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof ProductionPromptObject);
        return ((ProductionPromptObject) a).f12765a.l() != null;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof ProductionPromptObject);
        ProductionPrompt e = ((ProductionPromptObject) a).m18807e();
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        if (activity != null) {
            ImageOverlayFieldsModel a2 = new Builder().a(e.l().a()).a(new ImageModel.Builder().a(e.l().b()).a()).a();
            ProfilePictureOverlayActivityLauncher profilePictureOverlayActivityLauncher = (ProfilePictureOverlayActivityLauncher) this.f13383a.get();
            GraphQLProfilePictureActionLinkType graphQLProfilePictureActionLinkType = GraphQLProfilePictureActionLinkType.SINGLE_OVERLAY;
            ProfilePictureOverlayActivityLauncher profilePictureOverlayActivityLauncher2 = profilePictureOverlayActivityLauncher;
            Activity activity2 = activity;
            GraphQLProfilePictureActionLinkType graphQLProfilePictureActionLinkType2 = graphQLProfilePictureActionLinkType;
            String str = null;
            String str2 = null;
            profilePictureOverlayActivityLauncher2.a(activity2, graphQLProfilePictureActionLinkType2, str, str2, "composer_prompt", a2, 0, PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).b(), null, inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName()), 0);
        }
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
    }
}

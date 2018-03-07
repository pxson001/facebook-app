package com.facebook.productionprompts.actionhandlers;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.friendsharing.suggestedcoverphotos.SuggestedCoverPhotoEditHelper;
import com.facebook.friendsharing.suggestedcoverphotos.SuggestedCoverPhotoEditHelperProvider;
import com.facebook.friendsharing.suggestedcoverphotos.SuggestedCoverPhotosActivity;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger.Action;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasSelectedCoverPhotoInfo;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: modify_thread */
public class CoverPhotoPromptActionHandler<CONTEXT extends PromptActionContext & HasComposerSessionId & HasPromptSessionId & HasSelectedCoverPhotoInfo> implements PromptActionHandler<CONTEXT> {
    private final SecureContextHelper f13366a;
    private final SuggestedCoverPhotoEditHelperProvider f13367b;
    private final SuggestedCoverPhotosLogger f13368c;
    private final PromptImpressionLoggingSessionIdMap f13369d;
    private SuggestedCoverPhotoEditHelper f13370e;

    @Inject
    public CoverPhotoPromptActionHandler(SecureContextHelper secureContextHelper, SuggestedCoverPhotoEditHelperProvider suggestedCoverPhotoEditHelperProvider, SuggestedCoverPhotosLogger suggestedCoverPhotosLogger, PromptImpressionLoggingSessionIdMap promptImpressionLoggingSessionIdMap) {
        this.f13366a = secureContextHelper;
        this.f13367b = suggestedCoverPhotoEditHelperProvider;
        this.f13368c = suggestedCoverPhotosLogger;
        this.f13369d = promptImpressionLoggingSessionIdMap;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        ProductionPrompt a = m19691a(inlineComposerPromptSession);
        return (a.s() == null || a.s().isEmpty()) ? false : true;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        Uri uri = ((PromptActionContextImpl) context).h;
        PromptAnalytics a = PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, ((PromptActionContextImpl) context).a, (String) ((PromptActionContextImpl) context).j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName());
        if (uri == null) {
            if (((PromptActionContextImpl) context).i == -2) {
                this.f13368c.f13371a.mo526a(SuggestedCoverPhotosLogger.m19696a(((PromptActionContextImpl) context).a, Action.CLICK_MORE.name()));
            } else {
                this.f13368c.f13371a.mo526a(SuggestedCoverPhotosLogger.m19696a(((PromptActionContextImpl) context).a, Action.CLICK_PROMPT_CONTAINER.name()));
            }
            this.f13366a.mo660a(SuggestedCoverPhotosActivity.a(((PromptActionContextImpl) context).a, activity, m19691a(inlineComposerPromptSession).s(), a), 8373, activity);
            return;
        }
        this.f13368c.m19698a(((PromptActionContextImpl) context).a, ((PromptActionContextImpl) context).i);
        if (this.f13370e == null) {
            this.f13370e = this.f13367b.m19695a(activity, ((PromptActionContextImpl) context).a, a);
        }
        this.f13370e.a(uri);
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f13368c.f13371a.mo526a(SuggestedCoverPhotosLogger.m19696a(this.f13369d.m19702a(inlineComposerPromptSession.f13409a.mo2493b()), Action.DISMISS.name()));
    }

    public static ProductionPrompt m19691a(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkArgument(a instanceof ProductionPromptObject);
        return ((ProductionPromptObject) a).f12765a;
    }
}

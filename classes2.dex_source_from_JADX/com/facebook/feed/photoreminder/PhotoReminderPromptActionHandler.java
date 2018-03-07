package com.facebook.feed.photoreminder;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.photoreminder.composer.PhotoReminderPluginConfig;
import com.facebook.feed.photoreminder.model.MediaModel$MediaType;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.feed.util.composer.launch.DefaultNewsfeedComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Action;
import com.facebook.ipc.productionprompts.actioncontext.photoreminder.PhotoReminderPromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: moments_in_feed_upsell_impression */
public class PhotoReminderPromptActionHandler<CONTEXT extends PhotoReminderPromptActionContext> implements PromptActionHandler<CONTEXT> {
    private final MediaReminderUtil f13341a;
    private final MediaItemFactory f13342b;
    private final FeedComposerLauncherProvider f13343c;
    private final JsonPluginConfigSerializer f13344d;
    private final PhotoReminderLogger f13345e;

    public static PhotoReminderPromptActionHandler m19655b(InjectorLike injectorLike) {
        return new PhotoReminderPromptActionHandler(MediaReminderUtil.m18699a(injectorLike), MediaItemFactory.m19668b(injectorLike), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), JsonPluginConfigSerializer.m18629b(injectorLike), PhotoReminderLogger.m19675a(injectorLike));
    }

    @Inject
    public PhotoReminderPromptActionHandler(MediaReminderUtil mediaReminderUtil, MediaItemFactory mediaItemFactory, FeedComposerLauncherProvider feedComposerLauncherProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer, PhotoReminderLogger photoReminderLogger) {
        this.f13341a = mediaReminderUtil;
        this.f13342b = mediaItemFactory;
        this.f13343c = feedComposerLauncherProvider;
        this.f13344d = jsonPluginConfigSerializer;
        this.f13345e = photoReminderLogger;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject;
    }

    public final void m19656a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        Activity activity = (Activity) ContextUtils.m2500a(view.getContext(), Activity.class);
        PromptAnalytics a = PromptAnalytics.a(inlineComposerPromptSession.f13409a.mo2493b(), inlineComposerPromptSession.f13410b.f15099c, context.a, (String) context.j.orNull(), inlineComposerPromptSession.f13410b.f15098b, inlineComposerPromptSession.f13411c.a.getName());
        if (Action.PHOTO_REMINDER_TAP_ON_MEDIA.equals(context.b)) {
            m19652a(activity, (PromptActionContextImpl) context, a);
        } else if (Action.PHOTO_REMINDER_TAP_ON_MORE.equals(context.b)) {
            m19653a(activity, a);
        }
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f13341a.m18710d();
        this.f13341a.f12615j.edit().mo1275a(PromptsPrefKeys.f12781c, SystemClock.f762a.mo211a()).commit();
    }

    private void m19652a(Activity activity, PromptActionContextImpl promptActionContextImpl, PromptAnalytics promptAnalytics) {
        m19654a(activity, promptAnalytics, promptActionContextImpl.c, promptActionContextImpl.d, ImmutableList.of(promptActionContextImpl.e));
    }

    private void m19653a(Activity activity, PromptAnalytics promptAnalytics) {
        PhotoReminderLogger photoReminderLogger = this.f13345e;
        photoReminderLogger.f13355d.m18869a(promptAnalytics);
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("photo_reminder_open_picker");
        honeyClientEvent.f3099c = "photo_reminder";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f3102f = promptAnalytics.promptSessionId;
        honeyClientEvent.m5090b("source", "photo_tray");
        honeyClientEvent.m5090b("prompt_type", promptAnalytics.promptType);
        photoReminderLogger.f13352a.mo526a(honeyClientEvent);
        m19651a().b(Optional.fromNullable(promptAnalytics.composerSessionId), activity, RegularImmutableList.f535a, null);
    }

    private void m19654a(Activity activity, PromptAnalytics promptAnalytics, int i, MediaModel$MediaType mediaModel$MediaType, List<Uri> list) {
        if (activity != null) {
            this.f13341a.m18710d();
            Builder builder = ImmutableList.builder();
            for (Uri a : list) {
                MediaItem a2 = this.f13342b.m19672a(a, FallbackMediaId.DEFAULT);
                if (a2 != null) {
                    builder.m1069c(a2);
                }
            }
            m19651a().a(Optional.fromNullable(promptAnalytics.composerSessionId), builder.m1068b(), PhotoReminderPluginConfig.a(promptAnalytics), this.f13344d, activity);
            PhotoReminderLogger photoReminderLogger = this.f13345e;
            photoReminderLogger.f13355d.m18869a(promptAnalytics);
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photo_reminder_tap");
            honeyClientEvent.f3099c = "photo_reminder";
            HoneyAnalyticsEvent b = honeyClientEvent.m5083a("position", i).m5090b("media_type", mediaModel$MediaType.name()).m5090b("prompt_type", promptAnalytics.promptType);
            b.f3102f = promptAnalytics.promptSessionId;
            photoReminderLogger.f13352a.mo526a(b);
        }
    }

    private FeedComposerLauncher m19651a() {
        return this.f13343c.m15515a(new NewsfeedLauncherContext("photoReminderPrompt"), new DefaultNewsfeedComposerConfigCustomizer());
    }
}

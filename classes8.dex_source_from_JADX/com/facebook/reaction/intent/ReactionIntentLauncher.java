package com.facebook.reaction.intent;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.event.ReactionEventBus;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: XXHDPI */
public class ReactionIntentLauncher {
    private static volatile ReactionIntentLauncher f20718i;
    private final ComposerLauncher f20719a;
    private final Lazy<FbErrorReporter> f20720b;
    private final Lazy<ReactionExperimentController> f20721c;
    public final ReactionEventBus f20722d;
    private final ReactionMediaGalleryUtil f20723e;
    public final Lazy<ReactionPerfLogger> f20724f;
    private final Provider<ReactionSessionHelper> f20725g;
    private final SecureContextHelper f20726h;

    public static com.facebook.reaction.intent.ReactionIntentLauncher m24381a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20718i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.intent.ReactionIntentLauncher.class;
        monitor-enter(r1);
        r0 = f20718i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24383b(r0);	 Catch:{ all -> 0x0035 }
        f20718i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20718i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.intent.ReactionIntentLauncher.a(com.facebook.inject.InjectorLike):com.facebook.reaction.intent.ReactionIntentLauncher");
    }

    private static ReactionIntentLauncher m24383b(InjectorLike injectorLike) {
        return new ReactionIntentLauncher((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 3256), ReactionEventBus.m22919a(injectorLike), ReactionMediaGalleryUtil.m22513b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3255), IdBasedProvider.a(injectorLike, 9835), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public ReactionIntentLauncher(ComposerLauncher composerLauncher, Lazy<FbErrorReporter> lazy, Lazy<ReactionExperimentController> lazy2, ReactionEventBus reactionEventBus, ReactionMediaGalleryUtil reactionMediaGalleryUtil, Lazy<ReactionPerfLogger> lazy3, Provider<ReactionSessionHelper> provider, SecureContextHelper secureContextHelper) {
        this.f20719a = composerLauncher;
        this.f20720b = lazy;
        this.f20721c = lazy2;
        this.f20722d = reactionEventBus;
        this.f20723e = reactionMediaGalleryUtil;
        this.f20724f = lazy3;
        this.f20725g = provider;
        this.f20726h = secureContextHelper;
    }

    public final void m24384a(String str, ReactionAttachmentIntent reactionAttachmentIntent, @Nullable ReactionCardContainer reactionCardContainer, Context context) {
        if (reactionCardContainer == null) {
            ((AbstractFbErrorReporter) this.f20720b.get()).b(getClass().getSimpleName(), "null cardContainer");
        } else if (reactionAttachmentIntent.f18831d == null) {
            if (reactionAttachmentIntent.f18830c != null) {
                this.f20722d.a(reactionAttachmentIntent.f18830c);
            }
        } else if (reactionAttachmentIntent.f18831d.getBooleanExtra("launch_media_gallery", false)) {
            ReactionMediaGalleryUtil reactionMediaGalleryUtil = this.f20723e;
            Builder a = MediaGalleryLauncherParamsFactory.a(str, null).a(FullscreenGallerySource.REACTION_SHOW_MORE_PHOTOS);
            a.m = true;
            reactionMediaGalleryUtil.f18613a.a(context, a.b(), null);
        } else if (reactionAttachmentIntent.f18831d.hasExtra("composer_configuration")) {
            this.f20719a.a(null, (ComposerConfiguration) reactionAttachmentIntent.f18831d.getParcelableExtra("composer_configuration"), reactionAttachmentIntent.f18828a.ordinal(), reactionCardContainer.getFragment());
        } else if (reactionAttachmentIntent.f18831d.getBooleanExtra("launch_external_activity", false)) {
            this.f20726h.b(reactionAttachmentIntent.f18831d, context);
        } else if (reactionAttachmentIntent.f18831d.getBooleanExtra("launch_activity_for_result", false)) {
            this.f20726h.a(reactionAttachmentIntent.f18831d, reactionAttachmentIntent.f18831d.getIntExtra("reaction_request_code", reactionAttachmentIntent.f18828a.ordinal()), reactionCardContainer.getFragment());
        } else {
            if (reactionAttachmentIntent.f18828a == UnitInteractionType.OPEN_LOCAL_SEARCH_TAP) {
                String stringExtra = reactionAttachmentIntent.f18831d.getStringExtra("reaction_session_id");
                Surface surface = (Surface) reactionAttachmentIntent.f18831d.getSerializableExtra("reaction_surface");
                if (!(TextUtils.isEmpty(stringExtra) || surface == null)) {
                    ReactionPerfLogger reactionPerfLogger = (ReactionPerfLogger) this.f20724f.get();
                    reactionPerfLogger.b(1966082, stringExtra, surface);
                    reactionPerfLogger.a(1966090, stringExtra, surface);
                    m24382a(reactionAttachmentIntent.f18831d, stringExtra, surface);
                }
            }
            this.f20726h.a(reactionAttachmentIntent.f18831d, context);
        }
    }

    private void m24382a(Intent intent, String str, Surface surface) {
        if (intent.getExtras() != null && !TextUtils.isEmpty(intent.getExtras().getString("place_id"))) {
            long parseLong = Long.parseLong(intent.getExtras().getString("place_id"));
            if (((ReactionExperimentController) this.f20721c.get()).j()) {
                ReactionSessionHelper reactionSessionHelper = (ReactionSessionHelper) this.f20725g.get();
                ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
                reactionQueryParams.f18631l = Long.valueOf(parseLong);
                reactionQueryParams = reactionQueryParams;
                reactionQueryParams.f18639t = Long.valueOf(parseLong);
                reactionSessionHelper.m22585a(str, surface, reactionQueryParams);
            }
        }
    }
}

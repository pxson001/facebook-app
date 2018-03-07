package com.facebook.timeline.services.intentbuilder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.lifeevent.config.LifeEventComposerPluginConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: uimonitor_enabled */
public class ProfileServicesIntentBuilder {
    private static volatile ProfileServicesIntentBuilder f1158d;
    private final Lazy<String> f1159a;
    private final Provider<ViewerContextManager> f1160b;
    private final QeAccessor f1161c;

    public static com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder m1205a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1158d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1158d;	 Catch:{ all -> 0x003a }
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
        r0 = m1207b(r0);	 Catch:{ all -> 0x0035 }
        f1158d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1158d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder");
    }

    private static ProfileServicesIntentBuilder m1207b(InjectorLike injectorLike) {
        return new ProfileServicesIntentBuilder(IdBasedLazy.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 375), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileServicesIntentBuilder(Lazy<String> lazy, Provider<ViewerContextManager> provider, QeAccessor qeAccessor) {
        this.f1159a = lazy;
        this.f1160b = provider;
        this.f1161c = qeAccessor;
    }

    public final Builder m1210a(String str, String str2, String str3, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        Builder a = ComposerConfigurationFactory.a(ComposerSourceSurface.TIMELINE, "statusFromTimeline");
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), m1204a(str));
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        return a.setInitialTargetData(builder.a(composerTargetDataPrivacyScopeFields).a()).setNectarModule("timeline_composer").setAllowsRedSpaceToggle(false).setReactionSurface(Surface.ANDROID_TIMELINE_COMPOSER).setShouldPickerSupportLiveCamera(true).setAllowDynamicTextStyle(true);
    }

    public final Intent m1208a(Context context) {
        return new Intent().setComponent(new ComponentName(context, "com.facebook.composer.lifeevent.type.ComposerLifeEventTypeActivity")).putExtra("extra_composer_configuration", ComposerConfigurationFactory.b(ComposerSourceType.TIMELINE).setPluginConfig(new DefaultPluginConfigSerializer().a(LifeEventComposerPluginConfig.c())).setNectarModule("timeline_composer").setReactionSurface(Surface.ANDROID_TIMELINE_COMPOSER).a()).putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", ((ViewerContextManager) this.f1160b.get()).b());
    }

    public final Intent m1209a(Context context, String str, String str2, String str3, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        return SimplePickerIntent.a(context, m1206b(str, str2, str3, composerTargetDataPrivacyScopeFields));
    }

    @VisibleForTesting
    private SimplePickerLauncherConfiguration.Builder m1206b(String str, String str2, String str3, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        ComposerTargetData composerTargetData;
        if (Objects.equal(this.f1159a.get(), str)) {
            composerTargetData = ComposerTargetData.a;
        } else {
            ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), m1204a(str));
            builder.c = str2;
            builder = builder;
            builder.d = str3;
            composerTargetData = builder.a(composerTargetDataPrivacyScopeFields).a();
        }
        Builder shouldPickerSupportLiveCamera = ComposerConfigurationFactory.a(ComposerSourceSurface.TIMELINE, "photoFromTimeline").setAllowsRedSpaceToggle(false).setReactionSurface(Surface.ANDROID_TIMELINE_COMPOSER).setInitialTargetData(composerTargetData).setShouldPickerSupportLiveCamera(true);
        SimplePickerLauncherConfiguration.Builder builder2 = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.TIMELINE);
        builder2.a = shouldPickerSupportLiveCamera.a();
        SimplePickerLauncherConfiguration.Builder e = builder2.o().p().g().e();
        if (Objects.equal(this.f1159a.get(), str)) {
            e.c();
            if (this.f1161c.a(ExperimentsForComposerAbTestModule.Q, false)) {
                e.b();
            }
        } else if (!this.f1161c.a(ExperimentsForComposerAbTestModule.r, false)) {
            e.h();
        }
        return e;
    }

    private TargetType m1204a(String str) {
        return Objects.equal(this.f1159a.get(), str) ? TargetType.UNDIRECTED : TargetType.USER;
    }
}

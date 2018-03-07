package com.facebook.composer.shareintent.util;

import android.content.Context;
import android.content.Intent;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishEditHelperProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.EmptyPluginConfig;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$Factory;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.platform.analytics.PlatformAnalyticsLogger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: connection_quality */
public class UserDraftComposerPlugin extends ComposerPluginDefault {
    public final OptimisticPostHelperProvider f16941a;
    public final PublishEditHelperProvider f16942b;
    public final GatekeeperStoreImpl f16943c;
    public final PlatformAnalyticsLogger f16944d;

    /* compiled from: connection_quality */
    class C13521 implements ComposerPluginGetters$Getter<Intent> {
        final /* synthetic */ UserDraftComposerPlugin f16885a;

        C13521(UserDraftComposerPlugin userDraftComposerPlugin) {
            this.f16885a = userDraftComposerPlugin;
        }

        public final Object mo1300a() {
            this.f16885a.f16944d.a(this.f16885a.m20863E().a.o().getStoryId(), this.f16885a.m20863E().a.ab());
            return this.f16885a.f16942b.m20839a(this.f16885a.m20863E().a, this.f16885a.f16941a.m20824a(this.f16885a.m20863E().a, this.f16885a.f16931q)).m20838a(true);
        }
    }

    /* compiled from: connection_quality */
    class C13532 implements ComposerPluginGetters$BooleanGetter {
        final /* synthetic */ UserDraftComposerPlugin f16888c;

        C13532(UserDraftComposerPlugin userDraftComposerPlugin) {
            this.f16888c = userDraftComposerPlugin;
        }

        public final boolean mo1301a() {
            return this.f16888c.f16943c.a(ShareIntentUtilGatekeepers.f16884a, false);
        }
    }

    /* compiled from: connection_quality */
    class C13543 implements ComposerPluginGetters$BooleanGetter {
        final /* synthetic */ UserDraftComposerPlugin f16889c;

        C13543(UserDraftComposerPlugin userDraftComposerPlugin) {
            this.f16889c = userDraftComposerPlugin;
        }

        public final boolean mo1301a() {
            return this.f16889c.f16943c.a(ShareIntentUtilGatekeepers.f16884a, false);
        }
    }

    /* compiled from: connection_quality */
    class C13554 implements ComposerPluginGetters$BooleanGetter {
        final /* synthetic */ UserDraftComposerPlugin f16890c;

        C13554(UserDraftComposerPlugin userDraftComposerPlugin) {
            this.f16890c = userDraftComposerPlugin;
        }

        public final boolean mo1301a() {
            return this.f16890c.f16943c.a(ShareIntentUtilGatekeepers.f16884a, false);
        }
    }

    /* compiled from: connection_quality */
    public class Factory implements ComposerPlugin$Factory {
        public static final EmptyPluginConfig f16891a = EmptyPluginConfig.a("user_draft");
        private final UserDraftComposerPluginProvider f16892b;

        @Inject
        public Factory(UserDraftComposerPluginProvider userDraftComposerPluginProvider) {
            this.f16892b = userDraftComposerPluginProvider;
        }

        public final ComposerPluginDefault mo1302a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            UserDraftComposerPluginProvider userDraftComposerPluginProvider = this.f16892b;
            return new UserDraftComposerPlugin(composerPluginSession, (Context) userDraftComposerPluginProvider.getInstance(Context.class), (OptimisticPostHelperProvider) userDraftComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (PublishEditHelperProvider) userDraftComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishEditHelperProvider.class), GatekeeperStoreImplMethodAutoProvider.a(userDraftComposerPluginProvider), PlatformAnalyticsLogger.a(userDraftComposerPluginProvider));
        }

        public final String m20861b() {
            return f16891a.b();
        }
    }

    @Inject
    public UserDraftComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, Context context, OptimisticPostHelperProvider optimisticPostHelperProvider, PublishEditHelperProvider publishEditHelperProvider, GatekeeperStoreImpl gatekeeperStoreImpl, PlatformAnalyticsLogger platformAnalyticsLogger) {
        super(context, composerPluginSession);
        this.f16941a = optimisticPostHelperProvider;
        this.f16942b = publishEditHelperProvider;
        this.f16943c = gatekeeperStoreImpl;
        this.f16944d = platformAnalyticsLogger;
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<Intent> mo1327V() {
        return new C13521(this);
    }

    protected final ComposerPluginGetters$BooleanGetter mo1324R() {
        return new C13532(this);
    }

    protected final ComposerPluginGetters$BooleanGetter mo1320L() {
        return new C13543(this);
    }

    protected final ComposerPluginGetters$BooleanGetter mo1322P() {
        return new C13554(this);
    }

    protected final ComposerPluginGetters$BooleanGetter mo1323Q() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter mo1325S() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter mo1326T() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter mo1328X() {
        return ComposerPluginGetters$BooleanGetter.f16886a;
    }

    protected final ComposerPluginGetters$BooleanGetter mo1319H() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter ac() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter aD() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter aF() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter aM() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    public final ComposerPluginGetters$BooleanGetter mo1334f() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter aL() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$BooleanGetter mo1321M() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }
}

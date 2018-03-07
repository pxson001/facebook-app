package com.facebook.goodwill.composer;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import javax.inject.Inject;

/* compiled from: {referrer} */
public final class GoodwillCampaignComposerPlugin extends ComposerPluginDefault {
    public final GoodwillCampaignComposerPluginConfig f47a;

    /* compiled from: {referrer} */
    class C00051 implements Getter<String> {
        final /* synthetic */ GoodwillCampaignComposerPlugin f42a;

        C00051(GoodwillCampaignComposerPlugin goodwillCampaignComposerPlugin) {
            this.f42a = goodwillCampaignComposerPlugin;
        }

        public final Object m33a() {
            return this.f42a.f47a.m55d();
        }
    }

    /* compiled from: {referrer} */
    class C00062 implements Getter<String> {
        final /* synthetic */ GoodwillCampaignComposerPlugin f43a;

        C00062(GoodwillCampaignComposerPlugin goodwillCampaignComposerPlugin) {
            this.f43a = goodwillCampaignComposerPlugin;
        }

        public final Object m34a() {
            return this.f43a.f47a.m54c();
        }
    }

    @UserScoped
    /* compiled from: {referrer} */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f44c = new Object();
        private final GoodwillCampaignComposerPluginProvider f45a;
        private final JsonPluginConfigSerializer<GoodwillCampaignComposerPluginConfig> f46b;

        private static Factory m36b(InjectorLike injectorLike) {
            return new Factory((GoodwillCampaignComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GoodwillCampaignComposerPluginProvider.class), JsonPluginConfigSerializer.b(injectorLike));
        }

        @Inject
        public Factory(GoodwillCampaignComposerPluginProvider goodwillCampaignComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f45a = goodwillCampaignComposerPluginProvider;
            this.f46b = jsonPluginConfigSerializer;
        }

        public final String m38b() {
            return "GoodwillCampaignComposerPluginConfig";
        }

        public final ComposerPluginDefault m37a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            return new GoodwillCampaignComposerPlugin(composerPluginSession, (GoodwillCampaignComposerPluginConfig) this.f46b.a(serializedComposerPluginConfig, GoodwillCampaignComposerPluginConfig.class), (Context) this.f45a.getInstance(Context.class));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin.Factory m35a(com.facebook.inject.InjectorLike r7) {
            /*
            r2 = com.facebook.inject.ScopeSet.a();
            r0 = com.facebook.auth.userscope.UserScope.class;
            r0 = r7.getInstance(r0);
            r0 = (com.facebook.auth.userscope.UserScope) r0;
            r1 = r7.getScopeAwareInjector();
            r1 = r1.b();
            if (r1 != 0) goto L_0x001e;
        L_0x0016:
            r0 = new com.facebook.inject.ProvisioningException;
            r1 = "Called user scoped provider outside of context scope";
            r0.<init>(r1);
            throw r0;
        L_0x001e:
            r3 = r0.a(r1);
            r4 = r3.b();	 Catch:{ all -> 0x006c }
            r1 = f44c;	 Catch:{ all -> 0x006c }
            r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
            r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
            if (r1 != r5) goto L_0x0035;
        L_0x0030:
            r3.c();
            r0 = 0;
        L_0x0034:
            return r0;
        L_0x0035:
            if (r1 != 0) goto L_0x007c;
        L_0x0037:
            r1 = 4;
            r5 = r2.b(r1);	 Catch:{  }
            r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
            r0 = r6.e();	 Catch:{ all -> 0x0062 }
            r1 = m36b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f44c;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin.Factory) r0;	 Catch:{  }
            r3.c();
            goto L_0x0034;
        L_0x0062:
            r0 = move-exception;
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x0067:
            r0 = move-exception;
            r2.c(r5);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x006c:
            r0 = move-exception;
            r3.c();
            throw r0;
        L_0x0071:
            r0 = f44c;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin$Factory");
        }
    }

    @Inject
    public GoodwillCampaignComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted GoodwillCampaignComposerPluginConfig goodwillCampaignComposerPluginConfig, Context context) {
        super(context, composerPluginSession);
        this.f47a = goodwillCampaignComposerPluginConfig;
    }

    @Nullable
    protected final BooleanGetter m47T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m39H() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m40J() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> m41K() {
        return new C00051(this);
    }

    @Nullable
    protected final BooleanGetter m42L() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m43M() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m44O() {
        return BooleanGetter.a;
    }

    @Nullable
    protected final BooleanGetter m48X() {
        return BooleanGetter.a;
    }

    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m45P() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m46Q() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> aB() {
        return new C00062(this);
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    @javax.annotation.Nullable
    protected final BooleanGetter m49Z() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    public final BooleanGetter m50f() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }
}

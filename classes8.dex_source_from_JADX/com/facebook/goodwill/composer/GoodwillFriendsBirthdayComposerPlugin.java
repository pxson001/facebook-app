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

/* compiled from: {offer_code} */
public final class GoodwillFriendsBirthdayComposerPlugin extends ComposerPluginDefault {
    public final GoodwillFriendsBirthdayComposerPluginConfig f86a;

    /* compiled from: {offer_code} */
    class C00101 implements Getter<String> {
        final /* synthetic */ GoodwillFriendsBirthdayComposerPlugin f82a;

        C00101(GoodwillFriendsBirthdayComposerPlugin goodwillFriendsBirthdayComposerPlugin) {
            this.f82a = goodwillFriendsBirthdayComposerPlugin;
        }

        public final Object m100a() {
            return this.f82a.f86a.m110c();
        }
    }

    @UserScoped
    /* compiled from: {offer_code} */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f83c = new Object();
        private final GoodwillFriendsBirthdayComposerPluginProvider f84a;
        private final JsonPluginConfigSerializer<GoodwillFriendsBirthdayComposerPluginConfig> f85b;

        private static Factory m102b(InjectorLike injectorLike) {
            return new Factory((GoodwillFriendsBirthdayComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GoodwillFriendsBirthdayComposerPluginProvider.class), JsonPluginConfigSerializer.b(injectorLike));
        }

        @Inject
        public Factory(GoodwillFriendsBirthdayComposerPluginProvider goodwillFriendsBirthdayComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f84a = goodwillFriendsBirthdayComposerPluginProvider;
            this.f85b = jsonPluginConfigSerializer;
        }

        public final String m104b() {
            return "GoodwillFriendsBirthdayComposerPluginConfig";
        }

        public final ComposerPluginDefault m103a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            return new GoodwillFriendsBirthdayComposerPlugin(composerPluginSession, (GoodwillFriendsBirthdayComposerPluginConfig) this.f85b.a(serializedComposerPluginConfig, GoodwillFriendsBirthdayComposerPluginConfig.class), (Context) this.f84a.getInstance(Context.class));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin.Factory m101a(com.facebook.inject.InjectorLike r7) {
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
            r1 = f83c;	 Catch:{ all -> 0x006c }
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
            r1 = m102b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f83c;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin.Factory) r0;	 Catch:{  }
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
            r0 = f83c;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin$Factory");
        }
    }

    @Inject
    public GoodwillFriendsBirthdayComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted GoodwillFriendsBirthdayComposerPluginConfig goodwillFriendsBirthdayComposerPluginConfig, Context context) {
        super(context, composerPluginSession);
        this.f86a = goodwillFriendsBirthdayComposerPluginConfig;
    }

    @Nullable
    protected final BooleanGetter m106T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> aB() {
        return new C00101(this);
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m105M() {
        return BooleanGetter.b;
    }
}

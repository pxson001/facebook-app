package com.facebook.goodwill.composer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelperProvider;
import com.facebook.composer.publish.helpers.PublishStatusHelper;
import com.facebook.composer.publish.helpers.PublishStatusHelperProvider;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: {fallback_url} */
public class GoodwillFriendversaryCardComposerPlugin extends ComposerPluginDefault {
    public final OptimisticPostHelperProvider f92a;
    public final PublishAttachmentsHelperProvider f93b;
    public final PublishStatusHelperProvider f94c;
    public final GoodwillFriendversaryCardComposerPluginConfig f95d;
    public final ObjectMapper f96e;

    /* compiled from: {fallback_url} */
    class C00111 implements Getter<Intent> {
        final /* synthetic */ GoodwillFriendversaryCardComposerPlugin f88a;

        C00111(GoodwillFriendversaryCardComposerPlugin goodwillFriendversaryCardComposerPlugin) {
            this.f88a = goodwillFriendversaryCardComposerPlugin;
        }

        public final Object m115a() {
            OptimisticPostHelper a = this.f88a.f92a.a(this.f88a.E().m1370a(), this.f88a.g());
            PublishStatusHelper a2 = this.f88a.f94c.a(this.f88a.E().m1370a(), this.f88a.f93b.a(this.f88a.E().m1370a()), a);
            String str = null;
            try {
                str = this.f88a.f96e.a(this.f88a.f95d);
            } catch (JsonProcessingException e) {
            }
            return a2.a(new Builder(a2.a()).u(str).a(), false);
        }
    }

    @UserScoped
    /* compiled from: {fallback_url} */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f89c = new Object();
        private final GoodwillFriendversaryCardComposerPluginProvider f90a;
        private final JsonPluginConfigSerializer<GoodwillFriendversaryCardComposerPluginConfig> f91b;

        private static Factory m117b(InjectorLike injectorLike) {
            return new Factory((GoodwillFriendversaryCardComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GoodwillFriendversaryCardComposerPluginProvider.class), JsonPluginConfigSerializer.b(injectorLike));
        }

        @Inject
        public Factory(GoodwillFriendversaryCardComposerPluginProvider goodwillFriendversaryCardComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f90a = goodwillFriendversaryCardComposerPluginProvider;
            this.f91b = jsonPluginConfigSerializer;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin.Factory m116a(com.facebook.inject.InjectorLike r7) {
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
            r1 = f89c;	 Catch:{ all -> 0x006c }
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
            r1 = m117b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f89c;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin.Factory) r0;	 Catch:{  }
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
            r0 = f89c;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin$Factory");
        }

        public final String m119b() {
            return "GoodwillFriendversaryCardComposerPluginConfig";
        }

        public final ComposerPluginDefault m118a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            GoodwillFriendversaryCardComposerPluginProvider goodwillFriendversaryCardComposerPluginProvider = this.f90a;
            return new GoodwillFriendversaryCardComposerPlugin(composerPluginSession, (GoodwillFriendversaryCardComposerPluginConfig) this.f91b.a(serializedComposerPluginConfig, GoodwillFriendversaryCardComposerPluginConfig.class), (Context) goodwillFriendversaryCardComposerPluginProvider.getInstance(Context.class), (OptimisticPostHelperProvider) goodwillFriendversaryCardComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (PublishAttachmentsHelperProvider) goodwillFriendversaryCardComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishAttachmentsHelperProvider.class), (PublishStatusHelperProvider) goodwillFriendversaryCardComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishStatusHelperProvider.class), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(goodwillFriendversaryCardComposerPluginProvider));
        }
    }

    @Inject
    public GoodwillFriendversaryCardComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted GoodwillFriendversaryCardComposerPluginConfig goodwillFriendversaryCardComposerPluginConfig, Context context, OptimisticPostHelperProvider optimisticPostHelperProvider, PublishAttachmentsHelperProvider publishAttachmentsHelperProvider, PublishStatusHelperProvider publishStatusHelperProvider, ObjectMapper objectMapper) {
        super(context, composerPluginSession);
        this.f92a = optimisticPostHelperProvider;
        this.f94c = publishStatusHelperProvider;
        this.f93b = publishAttachmentsHelperProvider;
        this.f95d = goodwillFriendversaryCardComposerPluginConfig;
        this.f96e = objectMapper;
    }

    @Nullable
    protected final BooleanGetter m126T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m123H() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m125O() {
        return BooleanGetter.a;
    }

    @Nullable
    protected final BooleanGetter m124M() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<Intent> m127V() {
        return new C00111(this);
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    public final BooleanGetter m128f() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }
}

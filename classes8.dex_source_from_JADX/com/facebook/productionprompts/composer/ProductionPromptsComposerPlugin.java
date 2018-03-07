package com.facebook.productionprompts.composer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: request_callback */
public class ProductionPromptsComposerPlugin extends ComposerPluginDefault {
    protected final ProductionPromptsPluginConfig f4536a;
    public final PromptPublishIntentHelper f4537b;

    /* compiled from: request_callback */
    class C05921 implements Getter<Intent> {
        final /* synthetic */ ProductionPromptsComposerPlugin f4531a;

        C05921(ProductionPromptsComposerPlugin productionPromptsComposerPlugin) {
            this.f4531a = productionPromptsComposerPlugin;
        }

        public final Object m4383a() {
            return this.f4531a.f4537b.m4363a(this.f4531a.E().f1139a, this.f4531a.q, this.f4531a.f4536a.m4396d(), ProductionPromptsComposerPlugin.aQ(this.f4531a), this.f4531a.aP());
        }
    }

    /* compiled from: request_callback */
    class C05932 implements Getter<Bundle> {
        final /* synthetic */ ProductionPromptsComposerPlugin f4532a;

        C05932(ProductionPromptsComposerPlugin productionPromptsComposerPlugin) {
            this.f4532a = productionPromptsComposerPlugin;
        }

        public final Object m4384a() {
            return PromptPublishIntentHelper.m4361a(this.f4532a.f4536a.m4396d(), ProductionPromptsComposerPlugin.aQ(this.f4532a), null);
        }
    }

    @UserScoped
    /* compiled from: request_callback */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f4533c = new Object();
        private final ProductionPromptsComposerPluginProvider f4534a;
        private final JsonPluginConfigSerializer<ProductionPromptsPluginConfig> f4535b;

        private static Factory m4386b(InjectorLike injectorLike) {
            return new Factory((ProductionPromptsComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProductionPromptsComposerPluginProvider.class), JsonPluginConfigSerializer.b(injectorLike));
        }

        @Inject
        public Factory(ProductionPromptsComposerPluginProvider productionPromptsComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f4534a = productionPromptsComposerPluginProvider;
            this.f4535b = jsonPluginConfigSerializer;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin.Factory m4385a(com.facebook.inject.InjectorLike r7) {
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
            r1 = f4533c;	 Catch:{ all -> 0x006c }
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
            r1 = m4386b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f4533c;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin.Factory) r0;	 Catch:{  }
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
            r0 = f4533c;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin$Factory");
        }

        public final String m4388b() {
            return ProductionPromptsPluginConfig.f4538a;
        }

        public final ComposerPluginDefault m4387a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            ProductionPromptsComposerPluginProvider productionPromptsComposerPluginProvider = this.f4534a;
            return new ProductionPromptsComposerPlugin(composerPluginSession, (ProductionPromptsPluginConfig) this.f4535b.a(serializedComposerPluginConfig, ProductionPromptsPluginConfig.class), (Context) productionPromptsComposerPluginProvider.getInstance(Context.class), PromptPublishIntentHelper.m4362b(productionPromptsComposerPluginProvider));
        }
    }

    @Inject
    public ProductionPromptsComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted ProductionPromptsPluginConfig productionPromptsPluginConfig, Context context, PromptPublishIntentHelper promptPublishIntentHelper) {
        super(context, composerPluginSession);
        this.f4536a = (ProductionPromptsPluginConfig) Preconditions.checkNotNull(productionPromptsPluginConfig);
        this.f4537b = promptPublishIntentHelper;
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
    protected final Getter<Intent> m4390V() {
        return new C05921(this);
    }

    @Nullable
    protected final Getter<Bundle> aI() {
        return new C05932(this);
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    public final BooleanGetter m4391f() {
        return BooleanGetter.b;
    }

    public final boolean aP() {
        ProvidesMinutiae providesMinutiae = E().f1139a;
        ProductionPrompt c = this.f4536a.m4395c();
        if (c.d() != null && c.d().b(providesMinutiae.l())) {
            return true;
        }
        if (c.g() != null && Long.valueOf(Long.parseLong(c.g())).equals(Long.valueOf(providesMinutiae.g().j()))) {
            return true;
        }
        if (c.f() != null) {
            ComposerShareParams q = providesMinutiae.q();
            if (c.f().equals(q == null ? null : q.linkForShare)) {
                return true;
            }
        }
        if (c.m() != null) {
            int i;
            Set hashSet = new HashSet();
            ImmutableList c2 = c.m().c();
            int size = c2.size();
            for (i = 0; i < size; i++) {
                hashSet.add(((FrameModel) c2.get(i)).c());
            }
            c2 = E().f1139a.m();
            size = c2.size();
            for (i = 0; i < size; i++) {
                CreativeEditingData e = ((ComposerAttachment) c2.get(i)).e();
                if (e != null && hashSet.contains(e.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Class aQ(ProductionPromptsComposerPlugin productionPromptsComposerPlugin) {
        return productionPromptsComposerPlugin.f4536a.m4395c().k() ? ClipboardPromptObject.class : ProductionPromptObject.class;
    }

    @Nullable
    protected final BooleanGetter m4389M() {
        return BooleanGetter.b;
    }
}

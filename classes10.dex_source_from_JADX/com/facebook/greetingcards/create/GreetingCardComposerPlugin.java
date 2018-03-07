package com.facebook.greetingcards.create;

import android.content.Context;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.EmptyPluginConfig;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {learn_more_link} */
public class GreetingCardComposerPlugin extends ComposerPluginDefault {

    /* compiled from: {learn_more_link} */
    class C00051 implements Getter<String> {
        final /* synthetic */ GreetingCardComposerPlugin f56a;

        C00051(GreetingCardComposerPlugin greetingCardComposerPlugin) {
            this.f56a = greetingCardComposerPlugin;
        }

        public final Object m53a() {
            return this.f56a.b.getResources().getString(2131241457);
        }
    }

    /* compiled from: {learn_more_link} */
    class C00062 implements Getter<String> {
        final /* synthetic */ GreetingCardComposerPlugin f57a;

        C00062(GreetingCardComposerPlugin greetingCardComposerPlugin) {
            this.f57a = greetingCardComposerPlugin;
        }

        public final Object m54a() {
            return this.f57a.b.getResources().getString(2131241456);
        }
    }

    @UserScoped
    /* compiled from: {learn_more_link} */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        public static final EmptyPluginConfig f58a = EmptyPluginConfig.a(ComposerType.GREETING_CARD.toString());
        private static final Object f59c = new Object();
        private final GreetingCardComposerPluginProvider f60b;

        private static Factory m56b(InjectorLike injectorLike) {
            return new Factory((GreetingCardComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GreetingCardComposerPluginProvider.class));
        }

        @Inject
        Factory(GreetingCardComposerPluginProvider greetingCardComposerPluginProvider) {
            this.f60b = greetingCardComposerPluginProvider;
        }

        public final String m58b() {
            return f58a.b();
        }

        public final ComposerPluginDefault m57a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            return new GreetingCardComposerPlugin(composerPluginSession, (Context) this.f60b.getInstance(Context.class));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory m55a(com.facebook.inject.InjectorLike r7) {
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
            r1 = f59c;	 Catch:{ all -> 0x006c }
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
            r1 = m56b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f59c;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory) r0;	 Catch:{  }
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
            r0 = f59c;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.greetingcards.create.GreetingCardComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.greetingcards.create.GreetingCardComposerPlugin$Factory");
        }
    }

    @Inject
    public GreetingCardComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, Context context) {
        super(context, composerPluginSession);
    }

    @Nullable
    protected final BooleanGetter m64T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> m59G() {
        return new C00051(this);
    }

    @Nullable
    protected final Getter<String> m61K() {
        return new C00062(this);
    }

    @Nullable
    protected final BooleanGetter m60H() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m63Q() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    public final BooleanGetter m65f() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }

    @android.support.annotation.Nullable
    protected final BooleanGetter m62M() {
        return BooleanGetter.b;
    }
}

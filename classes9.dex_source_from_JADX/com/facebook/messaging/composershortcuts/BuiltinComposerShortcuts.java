package com.facebook.messaging.composershortcuts;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_commerce_user_control_action */
public class BuiltinComposerShortcuts {
    private static volatile BuiltinComposerShortcuts f9934g;
    private final Lazy<BigEmojis> f9935a;
    private final Lazy<EmojiUtil> f9936b;
    private final Resources f9937c;
    private final DefaultThreadViewTheme f9938d;
    private final boolean f9939e;
    @GuardedBy("this")
    private ImmutableMap<String, ComposerShortcutItem> f9940f;

    public static com.facebook.messaging.composershortcuts.BuiltinComposerShortcuts m10488a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9934g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.composershortcuts.BuiltinComposerShortcuts.class;
        monitor-enter(r1);
        r0 = f9934g;	 Catch:{ all -> 0x003a }
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
        r0 = m10491b(r0);	 Catch:{ all -> 0x0035 }
        f9934g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9934g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composershortcuts.BuiltinComposerShortcuts.a(com.facebook.inject.InjectorLike):com.facebook.messaging.composershortcuts.BuiltinComposerShortcuts");
    }

    private static BuiltinComposerShortcuts m10491b(InjectorLike injectorLike) {
        return new BuiltinComposerShortcuts(IdBasedLazy.a(injectorLike, 11501), IdBasedLazy.a(injectorLike, 3556), ResourcesMethodAutoProvider.a(injectorLike), DefaultThreadViewTheme.m10881b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BuiltinComposerShortcuts(Lazy<BigEmojis> lazy, Lazy<EmojiUtil> lazy2, Resources resources, ThreadViewTheme threadViewTheme, Boolean bool) {
        this.f9935a = lazy;
        this.f9936b = lazy2;
        this.f9937c = resources;
        this.f9938d = threadViewTheme;
        this.f9939e = bool.booleanValue();
    }

    public final synchronized ComposerShortcutItem m10493a(String str) {
        m10489a();
        return (ComposerShortcutItem) this.f9940f.get(str);
    }

    private synchronized void m10489a() {
        if (this.f9940f == null) {
            Builder builder = ImmutableMap.builder();
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("text").m10518a(2131558414).m10523b(2130841447).m10526c(this.f9937c.getString(2131230968)).m10522a(true).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("camera").m10518a(2131558415).m10523b(2130841344).m10522a(true).m10526c(this.f9937c.getString(2131230967)).m10524b(true).m10519a(2130905744, 2130905735).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("contentsearch").m10518a(2131558416).m10523b(2130841385).m10522a(true).m10526c(this.f9937c.getString(2131231263)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("gallery").m10518a(2131558417).m10523b(2130841384).m10522a(true).m10526c(this.f9937c.getString(2131230973)).m10524b(true).m10527d(2130905744).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("stickers").m10518a(2131558418).m10523b(2130841443).m10522a(true).m10526c(this.f9937c.getString(2131230966)).m10524b(true).m10527d(2130905751).m10528s());
            if (!this.f9939e) {
                m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("payment").m10518a(2131558419).m10523b(2130841410).m10522a(true).m10526c(this.f9937c.getString(2131230974)).m10524b(true).m10528s());
            }
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("voice_clip").m10518a(2131558421).m10523b(2130841459).m10522a(true).m10526c(this.f9937c.getString(2131230978)).m10524b(true).m10527d(2130905730).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("ride_service").m10522a(true).m10518a(2131558423).m10523b(2130841431).m10526c(this.f9937c.getString(2131230976)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("ride_service_promotion").m10522a(true).m10518a(2131558424).m10523b(2130841431).m10526c(this.f9937c.getString(2131230976)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("quick_reply").m10522a(true).m10518a(2131558425).m10523b(2130841428).m10526c(this.f9937c.getString(2131230977)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("sendlocation").m10523b(2130841425).m10522a(true).m10526c(this.f9937c.getString(2131230985)).m10524b(true).m10528s());
            m10490a(builder, m10492b());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("send").m10522a(true).m10518a(2131562049).m10523b(2130841433).m10526c(this.f9937c.getString(2131230984)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("overflow").m10522a(true).m10518a(2131558426).m10523b(2130841405).m10526c(this.f9937c.getString(2131231261)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("emoji").m10522a(true).m10518a(2131565262).m10523b(2130841371).m10526c(this.f9937c.getString(2131230981)).m10524b(true).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("message_cap").m10522a(true).m10518a(2131565263).m10526c(this.f9937c.getString(2131230994)).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("ephemeral").m10522a(true).m10523b(2130839479).m10524b(true).m10525c(this.f9937c.getColor(2131362298)).m10518a(2131558427).m10526c(this.f9937c.getString(2131232423)).m10528s());
            m10490a(builder, ComposerShortcutItem.newBuilder().m10521a("send_event").m10523b(2130841373).m10522a(true).m10526c(this.f9937c.getString(2131230986)).m10524b(true).m10528s());
            this.f9940f = builder.b();
        }
    }

    private static void m10490a(Builder<String, ComposerShortcutItem> builder, ComposerShortcutItem composerShortcutItem) {
        builder.b(composerShortcutItem.f9973b, composerShortcutItem);
    }

    private ComposerShortcutItem m10492b() {
        ComposerShortcutItemBuilder newBuilder = ComposerShortcutItem.newBuilder();
        newBuilder.f9992b = "like";
        newBuilder = newBuilder;
        newBuilder.f10000j = true;
        newBuilder = newBuilder;
        newBuilder.f9993c = 2131562066;
        newBuilder = newBuilder;
        newBuilder.f9997g = this.f9937c.getString(2131230982);
        ComposerShortcutItemBuilder composerShortcutItemBuilder = newBuilder;
        String g = this.f9938d.m10898g();
        Emoji emoji = null;
        if (g != null) {
            emoji = ((EmojiUtil) this.f9936b.get()).a(g);
        }
        if (emoji != null) {
            composerShortcutItemBuilder.f9994d = ((BigEmojis) this.f9935a.get()).a();
        } else {
            composerShortcutItemBuilder.f9994d = 2130841393;
            composerShortcutItemBuilder.f10005o = true;
        }
        return composerShortcutItemBuilder.m10528s();
    }
}

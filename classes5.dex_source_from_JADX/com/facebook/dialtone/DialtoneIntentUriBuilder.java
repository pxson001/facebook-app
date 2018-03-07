package com.facebook.dialtone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.dialtone.activity.DialtoneModeTransitionInterstitialActivity;
import com.facebook.dialtone.activity.DialtoneUriIntentHandlerActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: \u%04x */
public class DialtoneIntentUriBuilder extends UriIntentBuilder {
    private static volatile DialtoneIntentUriBuilder f11804a;

    /* compiled from: \u%04x */
    class DialtoneIntentActivityIntentBuilder implements IUriTemplateIntentBuilder {
        private final String f11803a;

        public DialtoneIntentActivityIntentBuilder(String str) {
            this.f11803a = str;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            Intent intent = new Intent(context, DialtoneUriIntentHandlerActivity.class);
            intent.putExtra(this.f11803a, true);
            return intent;
        }
    }

    public static com.facebook.dialtone.DialtoneIntentUriBuilder m19826a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f11804a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtoneIntentUriBuilder.class;
        monitor-enter(r1);
        r0 = f11804a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m19827b();	 Catch:{ all -> 0x0034 }
        f11804a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11804a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneIntentUriBuilder.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneIntentUriBuilder");
    }

    private static DialtoneIntentUriBuilder m19827b() {
        return new DialtoneIntentUriBuilder();
    }

    @Inject
    public DialtoneIntentUriBuilder() {
        m14187a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("dialtone?ref={%s}&action={%s}&follow_up_intent={%s}"), "ref", "action", "follow_up_intent"), DialtoneModeTransitionInterstitialActivity.class);
        m14186a(StringFormatUtil.formatStrLocaleSafe("dialtone://start", "ref"), new DialtoneIntentActivityIntentBuilder("start"));
        m14186a(StringFormatUtil.formatStrLocaleSafe("dialtone://switch_to_dialtone", "ref"), new DialtoneIntentActivityIntentBuilder("switch_to_dialtone"));
        m14186a(StringFormatUtil.formatStrLocaleSafe("dialtone://switch_to_full_fb", "ref"), new DialtoneIntentActivityIntentBuilder("switch_to_full_fb"));
    }
}

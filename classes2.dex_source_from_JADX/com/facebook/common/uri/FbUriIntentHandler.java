package com.facebook.common.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.perf.InteractionTTILogger;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: signal_evdo_dbm */
public class FbUriIntentHandler {
    private static volatile FbUriIntentHandler f4780f;
    private final UriIntentMapper f4781a;
    private final Lazy<Set<UriIntentListener>> f4782b;
    private final SecureContextHelper f4783c;
    private final InteractionTTILogger f4784d;
    private final Lazy<Set<NativeUriInlineHandler>> f4785e;

    public static com.facebook.common.uri.FbUriIntentHandler m8626a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4780f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.uri.FbUriIntentHandler.class;
        monitor-enter(r1);
        r0 = f4780f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8630b(r0);	 Catch:{ all -> 0x0035 }
        f4780f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4780f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.uri.FbUriIntentHandler.a(com.facebook.inject.InjectorLike):com.facebook.common.uri.FbUriIntentHandler");
    }

    private static FbUriIntentHandler m8630b(InjectorLike injectorLike) {
        return new FbUriIntentHandler(Fb4aUriIntentMapper.m8640a(injectorLike), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$UriIntentListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$NativeUriInlineHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), DefaultSecureContextHelper.m4636a(injectorLike), InteractionTTILogger.m4228a(injectorLike));
    }

    @Inject
    public FbUriIntentHandler(UriIntentMapper uriIntentMapper, Lazy<Set<UriIntentListener>> lazy, Lazy<Set<NativeUriInlineHandler>> lazy2, SecureContextHelper secureContextHelper, InteractionTTILogger interactionTTILogger) {
        this.f4781a = uriIntentMapper;
        this.f4782b = lazy;
        this.f4785e = lazy2;
        this.f4783c = secureContextHelper;
        this.f4784d = interactionTTILogger;
    }

    public final boolean m8632a(Context context, String str) {
        return m8634a(context, str, null, null);
    }

    public final boolean m8633a(Context context, String str, Bundle bundle) {
        return m8634a(context, str, bundle, null);
    }

    public final boolean m8634a(Context context, String str, @Nullable Bundle bundle, @Nullable Map<String, Object> map) {
        this.f4784d.m4248a(context, "FbUriIntentHandler");
        Intent a = this.f4781a.mo1267a(context, str);
        if (a != null) {
            if (bundle != null) {
                a.putExtras(bundle);
            }
            m8627a(context, a, str, (Map) map);
            return true;
        }
        this.f4784d.m4245a();
        return false;
    }

    public final boolean m8635a(Context context, String str, @Nullable Bundle bundle, @Nullable Map<String, Object> map, int i, Fragment fragment) {
        this.f4784d.m4248a(context, "FbUriIntentHandler");
        Intent a = this.f4781a.mo1267a(context, str);
        if (a == null) {
            this.f4784d.m4245a();
            return false;
        }
        if (bundle != null) {
            a.putExtras(bundle);
        }
        m8628a(context, a, str, (Map) map, i, fragment);
        return true;
    }

    public final boolean m8631a(Context context, NativeUri nativeUri) {
        Intent a = this.f4781a.mo1266a(context, nativeUri);
        if (a == null) {
            return false;
        }
        if (nativeUri.b != null) {
            a.putExtras(nativeUri.b);
        }
        m8627a(context, a, nativeUri.a, (Map) nativeUri.c);
        return true;
    }

    private void m8627a(Context context, Intent intent, String str, @Nullable Map<String, Object> map) {
        for (UriIntentListener a : (Set) this.f4782b.get()) {
            a.a(context, str, intent, map);
        }
        if (m8629a(intent, str)) {
            this.f4783c.mo662a(intent, context);
        } else {
            this.f4783c.mo665b(intent, context);
        }
    }

    private void m8628a(Context context, Intent intent, String str, @Nullable Map<String, Object> map, int i, Fragment fragment) {
        for (UriIntentListener a : (Set) this.f4782b.get()) {
            a.a(context, str, intent, map);
        }
        if (m8629a(intent, str)) {
            this.f4783c.mo661a(intent, i, fragment);
        } else {
            this.f4783c.mo664b(intent, i, fragment);
        }
    }

    private static boolean m8629a(Intent intent, String str) {
        Uri parse = Uri.parse(str);
        boolean booleanExtra = intent.getBooleanExtra("force_external_activity", false);
        if ((!FacebookUriUtil.m20919c(parse) || FacebookUriUtil.m20916a(parse)) && (!FacebookUriUtil.m20922g(parse) || booleanExtra)) {
            return false;
        }
        return true;
    }
}

package com.facebook.places.suggestions;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: secondary_action_url */
public class PlaceSuggestionsIntentBuilder {
    private static volatile PlaceSuggestionsIntentBuilder f3658c;
    private final Context f3659a;
    private final UriIntentMapper f3660b;

    public static com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder m3589a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3658c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder.class;
        monitor-enter(r1);
        r0 = f3658c;	 Catch:{ all -> 0x003a }
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
        r0 = m3590b(r0);	 Catch:{ all -> 0x0035 }
        f3658c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3658c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder");
    }

    private static PlaceSuggestionsIntentBuilder m3590b(InjectorLike injectorLike) {
        return new PlaceSuggestionsIntentBuilder((Context) injectorLike.getInstance(Context.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public PlaceSuggestionsIntentBuilder(Context context, UriIntentMapper uriIntentMapper) {
        this.f3659a = context;
        this.f3660b = uriIntentMapper;
    }

    @Nullable
    public final Intent m3591a(long j, String str, String str2, @Nullable CrowdsourcingSource crowdsourcingSource, CrowdEntryPoint crowdEntryPoint) {
        Intent a = this.f3660b.a(this.f3659a, StringFormatUtil.a(FBLinks.al, new Object[]{Long.valueOf(j), crowdEntryPoint.getFullName()}));
        if (a == null) {
            return null;
        }
        return a.putExtra("place_id", j).putExtra("profile_name", str).putExtra("place_pic_url", str2).putExtra("source", crowdsourcingSource).putExtra("entry_point", crowdEntryPoint);
    }
}

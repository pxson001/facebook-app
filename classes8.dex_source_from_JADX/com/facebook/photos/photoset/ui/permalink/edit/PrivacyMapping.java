package com.facebook.photos.photoset.ui.permalink.edit;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: client_network */
public class PrivacyMapping {
    private static volatile PrivacyMapping f17883d;
    public final Context f17884a;
    public final Map<String, String> f17885b = Maps.c();
    public final Map<String, String> f17886c;

    public static com.facebook.photos.photoset.ui.permalink.edit.PrivacyMapping m21850a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17883d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.photoset.ui.permalink.edit.PrivacyMapping.class;
        monitor-enter(r1);
        r0 = f17883d;	 Catch:{ all -> 0x003a }
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
        r0 = m21851b(r0);	 Catch:{ all -> 0x0035 }
        f17883d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17883d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.photoset.ui.permalink.edit.PrivacyMapping.a(com.facebook.inject.InjectorLike):com.facebook.photos.photoset.ui.permalink.edit.PrivacyMapping");
    }

    private static PrivacyMapping m21851b(InjectorLike injectorLike) {
        return new PrivacyMapping((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PrivacyMapping(Context context) {
        this.f17884a = context;
        this.f17885b.put("everyone", this.f17884a.getString(2131236727));
        this.f17885b.put("facebook", this.f17884a.getString(2131236728));
        this.f17885b.put("only_me", this.f17884a.getString(2131236730));
        this.f17885b.put("friends", this.f17884a.getString(2131236729));
        this.f17886c = Maps.c();
        this.f17886c.put("everyone", this.f17884a.getString(2131234192));
        this.f17886c.put("facebook", this.f17884a.getString(2131236728));
        this.f17886c.put("only_me", this.f17884a.getString(2131234198));
        this.f17886c.put("friends", this.f17884a.getString(2131234195));
    }

    public final boolean m21852a(PrivacyOptionWithIconFields privacyOptionWithIconFields) {
        return this.f17885b.containsKey(privacyOptionWithIconFields.b().d());
    }

    public final String m21853b(PrivacyOptionWithIconFields privacyOptionWithIconFields) {
        if (m21852a(privacyOptionWithIconFields)) {
            return (String) this.f17885b.get(privacyOptionWithIconFields.b().d());
        }
        return this.f17884a.getString(2131236729);
    }
}

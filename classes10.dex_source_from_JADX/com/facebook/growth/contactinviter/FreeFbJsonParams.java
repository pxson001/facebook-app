package com.facebook.growth.contactinviter;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: TERMS_ACCEPTED */
public class FreeFbJsonParams {
    private static final String f23300j = FreeFbJsonParams.class.getName();
    private static volatile FreeFbJsonParams f23301l;
    public String f23302a;
    public String f23303b;
    public String f23304c;
    public String f23305d;
    public String f23306e;
    public String f23307f;
    public String f23308g;
    public String f23309h;
    public boolean f23310i;
    private AbstractFbErrorReporter f23311k;

    public static com.facebook.growth.contactinviter.FreeFbJsonParams m24621a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23301l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.growth.contactinviter.FreeFbJsonParams.class;
        monitor-enter(r1);
        r0 = f23301l;	 Catch:{ all -> 0x003a }
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
        r0 = m24622b(r0);	 Catch:{ all -> 0x0035 }
        f23301l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23301l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.growth.contactinviter.FreeFbJsonParams.a(com.facebook.inject.InjectorLike):com.facebook.growth.contactinviter.FreeFbJsonParams");
    }

    private static FreeFbJsonParams m24622b(InjectorLike injectorLike) {
        return new FreeFbJsonParams((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FreeFbJsonParams(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f23311k = abstractFbErrorReporter;
    }

    public final void m24623a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f23302a = jSONObject.getString("contact_list_header_text");
            this.f23303b = jSONObject.getString("contact_list_item_add_message_action_text");
            this.f23304c = jSONObject.getString("confirmation_header_text");
            this.f23306e = jSONObject.getString("confirmation_title_text");
            this.f23308g = jSONObject.getString("confirmation_body_text");
            this.f23309h = jSONObject.getString("confirmation_link_intent_uri");
            this.f23305d = jSONObject.getString("confirmation_pre_title_text");
            this.f23307f = jSONObject.getString("confirmation_change_number_link_text");
            this.f23310i = jSONObject.getBoolean("is_top_up_incentive");
        } catch (Throwable e) {
            this.f23311k.a(f23300j, e);
        }
    }
}

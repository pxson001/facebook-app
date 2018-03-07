package com.facebook.katana.orca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.ProvisioningException;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.util.MessengerAppUtils;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unfavoriteGroup */
public class MessengerRedirectUriIntentBuilder extends UriIntentBuilder {
    public static final String f1022a = FBLinks.O;
    public static final Class<?> f1023b = MessengerRedirectUriIntentBuilder.class;
    private static volatile MessengerRedirectUriIntentBuilder f1024f;
    public final MessengerAppUtils f1025c;
    public final Provider<DataCache> f1026d;
    public final AbstractFbErrorReporter f1027e;

    /* compiled from: unfavoriteGroup */
    class GroupThreadUriIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ MessengerRedirectUriIntentBuilder f1021a;

        GroupThreadUriIntentBuilder(MessengerRedirectUriIntentBuilder messengerRedirectUriIntentBuilder) {
            this.f1021a = messengerRedirectUriIntentBuilder;
        }

        public final Intent m1071a(Context context, Bundle bundle) {
            Intent intent = new Intent("android.intent.action.VIEW");
            String string = bundle.getString("groupthreadfbid");
            if (string == null) {
                this.f1021a.f1027e.a(MessengerRedirectUriIntentBuilder.f1023b.getName(), "groupthreadfbid in uri is null.");
                intent.setData(Uri.parse(MessengerLinks.g));
            } else if (this.f1021a.f1025c.a("5.0")) {
                intent.setData(Uri.parse(MessengerLinks.z + string));
            } else {
                ThreadKey a = ThreadKey.a(Long.parseLong(string));
                try {
                    ThreadSummary a2 = ((DataCache) this.f1021a.f1026d.get()).a(a);
                    if (a2 != null) {
                        intent.setData(Uri.parse(MessengerLinks.u + a2.b));
                    } else {
                        this.f1021a.f1027e.a(MessengerRedirectUriIntentBuilder.f1023b.getName(), "threadSummary for " + a.g() + " was null in DataCache.");
                        intent.setData(Uri.parse(MessengerLinks.g));
                    }
                } catch (ProvisioningException e) {
                    this.f1021a.f1027e.a(MessengerRedirectUriIntentBuilder.f1023b.getName(), e.getMessage());
                    intent.setData(Uri.parse(MessengerLinks.g));
                    return intent;
                }
            }
            return intent;
        }
    }

    public static com.facebook.katana.orca.MessengerRedirectUriIntentBuilder m1072a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1024f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.orca.MessengerRedirectUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1024f;	 Catch:{ all -> 0x003a }
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
        r0 = m1073b(r0);	 Catch:{ all -> 0x0035 }
        f1024f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1024f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.orca.MessengerRedirectUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.orca.MessengerRedirectUriIntentBuilder");
    }

    private static MessengerRedirectUriIntentBuilder m1073b(InjectorLike injectorLike) {
        return new MessengerRedirectUriIntentBuilder(MessengerAppUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 2567), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MessengerRedirectUriIntentBuilder(MessengerAppUtils messengerAppUtils, Provider<DataCache> provider, FbErrorReporter fbErrorReporter) {
        this.f1025c = messengerAppUtils;
        this.f1026d = provider;
        this.f1027e = fbErrorReporter;
        a(FBLinks.O, MessengerLinks.g);
        a(FBLinks.S, m1074b(MessengerLinks.h, MessengerLinks.g));
        a(FBLinks.T, m1074b(MessengerLinks.h, MessengerLinks.g));
        a(FBLinks.W, MessengerLinks.g);
        a(FBLinks.U + "{user}", MessengerLinks.x + "<user>");
        a(FBLinks.Q + "{user}", MessengerLinks.x + "<user>");
        a(FBLinks.Y + "{thread_id}", MessengerLinks.u + "<thread_id>");
        a(FBLinks.W + "{groupthreadfbid}", new GroupThreadUriIntentBuilder(this));
    }

    private String m1074b(String str, String str2) {
        return this.f1025c.a("2.7.0") ? str : str2;
    }
}

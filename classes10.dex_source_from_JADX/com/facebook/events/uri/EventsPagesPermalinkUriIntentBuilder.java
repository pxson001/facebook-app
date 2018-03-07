package com.facebook.events.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.events.common.EventsUriUtil;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: app_has_publish */
public class EventsPagesPermalinkUriIntentBuilder extends UriIntentBuilder {
    public static final String f19625a = FBLinks.a("event/<p$1>");
    private static volatile EventsPagesPermalinkUriIntentBuilder f19626d;
    private Product f19627b;
    private QeAccessor f19628c;

    public static com.facebook.events.uri.EventsPagesPermalinkUriIntentBuilder m19904a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19626d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.uri.EventsPagesPermalinkUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f19626d;	 Catch:{ all -> 0x003a }
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
        r0 = m19906b(r0);	 Catch:{ all -> 0x0035 }
        f19626d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19626d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.uri.EventsPagesPermalinkUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.events.uri.EventsPagesPermalinkUriIntentBuilder");
    }

    private static EventsPagesPermalinkUriIntentBuilder m19906b(InjectorLike injectorLike) {
        return new EventsPagesPermalinkUriIntentBuilder(ProductMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventsPagesPermalinkUriIntentBuilder(Product product, QeAccessor qeAccessor) {
        this.f19627b = product;
        this.f19628c = qeAccessor;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("event/{%s}"), "event_id"), FragmentChromeActivity.class, ContentFragmentType.EVENTS_PERMALINK_FRAGMENT.ordinal());
    }

    protected final boolean m19908a() {
        return this.f19627b == Product.PAA;
    }

    @Nullable
    public final Intent m19907a(Context context, String str) {
        String a = m19905a(Uri.parse(str));
        if (a != null) {
            str = a;
        }
        Intent a2 = super.a(context, str);
        return (a2 == null || !this.f19628c.a(Liveness.Live, ExperimentsForEventsGatingModule.X, false)) ? null : a2;
    }

    @Nullable
    private String m19905a(Uri uri) {
        if (uri.toString().startsWith(FBLinks.cr)) {
            String queryParameter = uri.getQueryParameter("href");
            if (queryParameter == null) {
                return null;
            }
            uri = Uri.parse(queryParameter);
        }
        if (uri.getHost() != null && !FacebookUriUtil.c(uri)) {
            return null;
        }
        String str = null;
        if (uri.getPath() != null) {
            Matcher matcher = EventsUriUtil.a.matcher(uri.getPath());
            if (matcher.matches()) {
                str = f19625a;
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    str = str.replaceAll("<p\\$" + i + ">", matcher.group(i));
                }
            }
        }
        return str;
    }
}

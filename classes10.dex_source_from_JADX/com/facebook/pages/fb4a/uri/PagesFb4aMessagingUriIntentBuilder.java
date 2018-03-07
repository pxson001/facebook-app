package com.facebook.pages.fb4a.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.PagesManagerConstants.PopupState;
import com.facebook.pages.deeplinking.PageAdminUtils;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: m.%s */
public class PagesFb4aMessagingUriIntentBuilder extends UriIntentBuilder {
    private static volatile PagesFb4aMessagingUriIntentBuilder f8408b;
    private final UriTemplateIntentBuilder f8409a;

    /* compiled from: m.%s */
    public class UriTemplateIntentBuilder implements IUriTemplateIntentBuilder {
        public final PageAdminUtils f8405a;
        private final QeAccessor f8406b;
        public final GooglePlayIntentHelper f8407c;

        @Inject
        public UriTemplateIntentBuilder(PageAdminUtils pageAdminUtils, QeAccessor qeAccessor, GooglePlayIntentHelper googlePlayIntentHelper) {
            this.f8405a = pageAdminUtils;
            this.f8406b = qeAccessor;
            this.f8407c = googlePlayIntentHelper;
        }

        public final Intent m8337a(Context context, Bundle bundle) {
            long j = bundle.getLong("com.facebook.katana.profile.id");
            Intent a = this.f8405a.m8328a(j);
            if (a != null) {
                a.putExtra("popup_state", PopupState.MESSAGES.toString());
            }
            Intent intent = a;
            if (intent != null) {
                return intent;
            }
            if (this.f8406b.a(ExperimentsForPagesFb4aAbTestModule.f8401j, false)) {
                return this.f8407c.b("com.facebook.pages.app");
            }
            return new Intent().setAction("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/messages/?pageID=%s", Long.valueOf(j)))).putExtra("force_in_app_browser", true).putExtra("should_hide_menu", true).putExtra("iab_origin", "messenger").putExtra("custom_user_agent_suffix", "FB4A_Messaging_MSite");
        }
    }

    public static com.facebook.pages.fb4a.uri.PagesFb4aMessagingUriIntentBuilder m8338a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8408b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.fb4a.uri.PagesFb4aMessagingUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f8408b;	 Catch:{ all -> 0x003a }
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
        r0 = m8339b(r0);	 Catch:{ all -> 0x0035 }
        f8408b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8408b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.fb4a.uri.PagesFb4aMessagingUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.pages.fb4a.uri.PagesFb4aMessagingUriIntentBuilder");
    }

    private static PagesFb4aMessagingUriIntentBuilder m8339b(InjectorLike injectorLike) {
        return new PagesFb4aMessagingUriIntentBuilder(new UriTemplateIntentBuilder(PageAdminUtils.m8325a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GooglePlayIntentHelper.b(injectorLike)));
    }

    @Inject
    public PagesFb4aMessagingUriIntentBuilder(UriTemplateIntentBuilder uriTemplateIntentBuilder) {
        this.f8409a = uriTemplateIntentBuilder;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.aA, "{#" + "com.facebook.katana.profile.id" + "}"), this.f8409a);
    }

    protected final boolean m8340a() {
        return true;
    }
}

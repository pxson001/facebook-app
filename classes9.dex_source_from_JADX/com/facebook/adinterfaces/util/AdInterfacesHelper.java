package com.facebook.adinterfaces.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.ui.AdInterfacesCardLayout;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unknown boost types */
public class AdInterfacesHelper {
    public static Product f23242c;
    private static volatile AdInterfacesHelper f23243e;
    public SecureContextHelper f23244a;
    public final QeAccessor f23245b;
    private final GatekeeperStoreImpl f23246d;

    public static com.facebook.adinterfaces.util.AdInterfacesHelper m25227a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23243e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.util.AdInterfacesHelper.class;
        monitor-enter(r1);
        r0 = f23243e;	 Catch:{ all -> 0x003a }
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
        r0 = m25229b(r0);	 Catch:{ all -> 0x0035 }
        f23243e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23243e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.util.AdInterfacesHelper.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.util.AdInterfacesHelper");
    }

    private static AdInterfacesHelper m25229b(InjectorLike injectorLike) {
        return new AdInterfacesHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AdInterfacesHelper(SecureContextHelper secureContextHelper, QeAccessor qeAccessor, Product product, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f23244a = secureContextHelper;
        this.f23245b = qeAccessor;
        f23242c = product;
        this.f23246d = gatekeeperStoreImpl;
    }

    public static Intent m25226a(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("force_in_app_browser", true);
        intent.putExtra("should_hide_menu", true);
        if (f23242c == Product.PAA) {
            intent.setData(parse);
        }
        if (f23242c == Product.FB4A) {
            intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, parse)));
        }
        return intent;
    }

    public final void m25231a(Context context, long j) {
        if (m25232b()) {
            String valueOf = String.valueOf(j);
            Intent a = AdInterfacesIntentUtil.a(context, ObjectiveType.PAGE_LIKE, Integer.valueOf(2131234049), "pages_manager_activity_tab");
            a.putExtra("page_id", valueOf);
            this.f23244a.a(a, context);
            return;
        }
        valueOf = StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/pages/boosted_page_like/view/?pid=%s&hide_chrome=1", String.valueOf(j));
        a = new Intent();
        a.setData(Uri.parse(valueOf));
        a.putExtra("force_in_app_browser", true);
        a.putExtra("should_hide_menu", true);
        this.f23244a.b(a, context);
    }

    public final boolean m25232b() {
        return this.f23246d.a(521, false);
    }

    public final SpannableString m25230a(int i, final String str, TextWithEntitiesView textWithEntitiesView, final AdInterfacesContext adInterfacesContext) {
        Resources resources = textWithEntitiesView.getContext().getResources();
        CharSequence string = resources.getString(i);
        String string2 = resources.getString(2131233873);
        final int color = resources.getColor(2131361996);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(string);
        styledStringBuilder.a("[[ads_manager_link]]", string2, new ClickableSpan(this) {
            final /* synthetic */ AdInterfacesHelper f23241d;

            public void onClick(View view) {
                adInterfacesContext.m22429a(new IntentEvent(AdInterfacesHelper.m25226a(str), 5, false));
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(color);
            }
        }, 33);
        textWithEntitiesView.setMovementMethod(LinkMovementMethod.getInstance());
        return styledStringBuilder.b();
    }

    public static void m25228a(View view, AdInterfacesCardLayout adInterfacesCardLayout, int i) {
        view.setVisibility(i);
        if (adInterfacesCardLayout != null) {
            adInterfacesCardLayout.setVisibility(i);
        }
    }
}

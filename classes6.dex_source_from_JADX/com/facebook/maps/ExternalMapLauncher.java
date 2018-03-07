package com.facebook.maps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.maps.abtest.ExperimentsForMapsModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.dialogs.FbAlertDialog;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: {CurrencyConstant.symbol}{amount} */
public class ExternalMapLauncher {
    private static final InterstitialTrigger f114a = new InterstitialTrigger(Action.MAPS_LAUNCH_EXTERNAL_MAP_APP);
    private static String f115b;
    private static volatile ExternalMapLauncher f116h;
    public final StaticMapLogger f117c;
    private final SecureContextHelper f118d;
    private final InterstitialManager f119e;
    private final QeAccessor f120f;
    private final Lazy<FbUriIntentHandler> f121g;

    /* compiled from: {CurrencyConstant.symbol}{amount} */
    public class C00183 {
        final /* synthetic */ ExternalMapLauncher f113a;

        C00183(ExternalMapLauncher externalMapLauncher) {
            this.f113a = externalMapLauncher;
        }

        public final void m83a(String str, long j) {
            StaticMapLogger staticMapLogger = this.f113a.f117c;
            String str2 = "oxygen_map_here_upsell_dialog_map_image_download_success";
            if (staticMapLogger.f329b.a(str2)) {
                HoneyClientEventFast a = staticMapLogger.f328a.a(str2, false);
                if (a.a()) {
                    a.a("oxygen_map").a("query_type", str).a("load_time", j);
                    a.b();
                }
            }
        }

        public final void m82a(String str) {
            StaticMapLogger staticMapLogger = this.f113a.f117c;
            String str2 = "oxygen_map_here_upsell_dialog_map_image_download_failure";
            if (staticMapLogger.f329b.a(str2)) {
                HoneyClientEventFast a = staticMapLogger.f328a.a(str2, false);
                if (a.a()) {
                    a.a("oxygen_map").a("reason", str);
                    a.b();
                }
            }
        }
    }

    public static com.facebook.maps.ExternalMapLauncher m86a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f116h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.maps.ExternalMapLauncher.class;
        monitor-enter(r1);
        r0 = f116h;	 Catch:{ all -> 0x003a }
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
        r0 = m89b(r0);	 Catch:{ all -> 0x0035 }
        f116h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f116h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.maps.ExternalMapLauncher.a(com.facebook.inject.InjectorLike):com.facebook.maps.ExternalMapLauncher");
    }

    private static ExternalMapLauncher m89b(InjectorLike injectorLike) {
        return new ExternalMapLauncher((Context) injectorLike.getInstance(Context.class), StaticMapLogger.m285a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), InterstitialManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 616));
    }

    @Inject
    public ExternalMapLauncher(Context context, StaticMapLogger staticMapLogger, SecureContextHelper secureContextHelper, InterstitialManager interstitialManager, QeAccessor qeAccessor, Lazy<FbUriIntentHandler> lazy) {
        this.f117c = staticMapLogger;
        this.f118d = secureContextHelper;
        this.f119e = interstitialManager;
        this.f120f = qeAccessor;
        this.f121g = lazy;
        if (f115b == null) {
            PackageManager packageManager = context.getPackageManager();
            f115b = context.getApplicationInfo().loadLabel(packageManager).toString();
            try {
                f115b += "_" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
        }
    }

    public final void m90a(Context context, String str, double d, double d2, String str2, @Nullable String str3) {
        boolean z = false;
        if (CurationSurface.AFTER_PARTY.toString().equals(str) || CurationSurface.NATIVE_STORY.toString().equals(str)) {
            z = true;
        } else if (CurationSurface.NATIVE_PAGE_PROFILE.toString().equals(str)) {
            z = this.f120f.a(ExperimentsForMapsModule.f341a, false);
        }
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putString("place_name", str2);
            bundle.putString("address", str3);
            bundle.putDouble("latitude", d);
            bundle.putDouble("longitude", d2);
            bundle.putFloat("zoom", 13.0f);
            bundle.putString("curation_surface", str);
            this.f117c.m289a(str, "latitude_longitude");
            ((FbUriIntentHandler) this.f121g.get()).a(context, FBLinks.eP, bundle);
            return;
        }
        this.f117c.m290b(str, "latitude_longitude");
        Intent a = m85a(context, d, d2, str3);
        if (!CurationSurface.NATIVE_PAGE_PROFILE.toString().equals(str) || !m88a(context, a, d, d2, str2, str3)) {
            this.f118d.b(a, context);
        }
    }

    public final void m92b(Context context, String str, double d, double d2, String str2, @Nullable String str3) {
        this.f117c.m290b(str, "directions_latitude_longitude");
        Intent a = m84a(d, d2, str3);
        if (!m88a(context, a, d, d2, str2, str3)) {
            this.f118d.b(a, context);
        }
    }

    public static Intent m85a(Context context, double d, double d2, @Nullable String str) {
        String encode = !TextUtils.isEmpty(str) ? Uri.encode(str) : d + "," + d2;
        Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse("geo:0,0?q=" + encode)).setFlags(268435456).putExtra("android.intent.extra.REFERRER", f115b).putExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", true);
        if (!IntentResolver.b(context, putExtra)) {
            putExtra.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("%s?q=%s", "http://maps.google.com/maps", encode)));
        }
        return putExtra;
    }

    public static String m87a(double d, double d2) {
        return StringFormatUtil.formatStrLocaleSafe("%s?q=%f,%f", "http://maps.google.com/maps", Double.valueOf(d), Double.valueOf(d2));
    }

    public static Intent m84a(double d, double d2, String str) {
        return new Intent("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("%s?daddr=%s", "http://maps.google.com/maps", !TextUtils.isEmpty(str) ? Uri.encode(str) : d + "," + d2))).setFlags(268435456).putExtra("android.intent.extra.REFERRER", f115b).putExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", true);
    }

    private boolean m88a(Context context, Intent intent, double d, double d2, String str, @Nullable String str2) {
        return m91a(context, intent, d, d2, str, str2, null);
    }

    public final boolean m91a(Context context, Intent intent, double d, double d2, String str, @Nullable String str2, @Nullable OnDismissListener onDismissListener) {
        InterstitialController a = this.f119e.a(f114a);
        if (!(a instanceof HereMapsUpsellInterstitialController)) {
            return false;
        }
        View hereMapsUpsellView = new HereMapsUpsellView(context, intent, d, d2, str, str2);
        final FbAlertDialog fbAlertDialog = new FbAlertDialog(context);
        fbAlertDialog.setTitle(2131230961);
        fbAlertDialog.a(hereMapsUpsellView, 0, 0, 0, 0);
        final OnDismissListener onDismissListener2 = onDismissListener;
        fbAlertDialog.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ ExternalMapLauncher f110b;

            public void onDismiss(DialogInterface dialogInterface) {
                this.f110b.f117c.m288a("Dismiss");
                if (onDismissListener2 != null) {
                    onDismissListener2.onDismiss(dialogInterface);
                }
            }
        });
        hereMapsUpsellView.setOnIntentClickListener(new Object(this) {
            final /* synthetic */ ExternalMapLauncher f112b;

            public final void m81a(String str) {
                fbAlertDialog.dismiss();
                this.f112b.f117c.m288a(str);
            }
        });
        hereMapsUpsellView.setOnMapImageDownloadListener(new C00183(this));
        fbAlertDialog.show();
        this.f117c.m287a();
        this.f119e.a().a(a.b());
        return true;
    }
}

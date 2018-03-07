package com.facebook.katana.urimap;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.common.uri.UriIntentListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.annotation.FrozenParcelable;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.notifications.model.SMSNotificationURL.NotificationLongURL;
import com.facebook.notifications.protocol.FetchNotificationURIResult;
import com.facebook.notifications.widget.NotificationsFragment;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_unknown_section_id */
public class IntentHandlerUtil {
    private static volatile IntentHandlerUtil f1215l;
    private final AppLinksUtil f1216a;
    private final Fb4aUriIntentMapper f1217b;
    public final SecureContextHelper f1218c;
    private final ExecutorService f1219d;
    private final DefaultBlueServiceOperationFactory f1220e;
    private final AbstractFbErrorReporter f1221f;
    private final Set<UriIntentListener> f1222g;
    private final AnalyticsLogger f1223h;
    private final NavigationLogger f1224i;
    private final InteractionTTILogger f1225j;
    public final ComponentName f1226k;

    public static com.facebook.katana.urimap.IntentHandlerUtil m1246a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1215l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.IntentHandlerUtil.class;
        monitor-enter(r1);
        r0 = f1215l;	 Catch:{ all -> 0x003a }
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
        r0 = m1250b(r0);	 Catch:{ all -> 0x0035 }
        f1215l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1215l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.IntentHandlerUtil.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.IntentHandlerUtil");
    }

    private static IntentHandlerUtil m1250b(InjectorLike injectorLike) {
        return new IntentHandlerUtil(AppLinksUtil.m1231a(injectorLike), Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER.UriIntentListener(injectorLike)), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike), InteractionTTILogger.a(injectorLike), ComponentName_LoginActivityComponentMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public IntentHandlerUtil(AppLinksUtil appLinksUtil, Fb4aUriIntentMapper fb4aUriIntentMapper, SecureContextHelper secureContextHelper, ExecutorService executorService, BlueServiceOperationFactory blueServiceOperationFactory, FbErrorReporter fbErrorReporter, Set<UriIntentListener> set, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, InteractionTTILogger interactionTTILogger, ComponentName componentName) {
        this.f1216a = (AppLinksUtil) Preconditions.checkNotNull(appLinksUtil);
        this.f1217b = (Fb4aUriIntentMapper) Preconditions.checkNotNull(fb4aUriIntentMapper);
        this.f1218c = (SecureContextHelper) Preconditions.checkNotNull(secureContextHelper);
        this.f1219d = executorService;
        this.f1220e = blueServiceOperationFactory;
        this.f1221f = (AbstractFbErrorReporter) Preconditions.checkNotNull(fbErrorReporter);
        this.f1222g = set;
        this.f1223h = analyticsLogger;
        this.f1224i = navigationLogger;
        this.f1225j = interactionTTILogger;
        this.f1226k = componentName;
    }

    public final void m1253a(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            String scheme = data.getScheme();
            if (scheme != null && (scheme.equals("http") || scheme.equals("https"))) {
                scheme = data.getHost();
                if (scheme != null && scheme.toLowerCase(Locale.US).endsWith(".fb.com")) {
                    scheme = data.getPath();
                    if (scheme != null && scheme.startsWith("/l/")) {
                        obj = 1;
                    }
                }
            }
        }
        if (obj != null) {
            m1247a(context, data);
            return;
        }
        boolean a = m1254a(context, String.valueOf(data));
        if (!a) {
            if (intent.getExtras() != null && intent.hasExtra("al_applink_data")) {
                Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
                if (bundleExtra != null && bundleExtra.containsKey("target_url")) {
                    String string = bundleExtra.getString("target_url");
                    Object a2 = AppLinksUtil.m1232a(Uri.parse(string));
                    if (!StringUtil.a(a2)) {
                        a = m1248a(context, string, AppLinksUtil.m1229a(this.f1217b, context, a2), null);
                        if (a) {
                            bundleExtra = bundleExtra.getBundle("extras");
                            HoneyClientEvent b = new HoneyClientEvent("applink_navigation_event").b("target_url", string);
                            String str = "";
                            if (bundleExtra == null || !bundleExtra.containsKey("ref")) {
                                b.b("ref", str);
                            } else {
                                str = bundleExtra.getString("ref");
                                if (str == null) {
                                    str = "";
                                }
                                b.b("ref", str);
                            }
                            this.f1223h.a(b);
                        }
                    }
                }
            }
            if (!a) {
                m1254a(context, FBLinks.bT);
            }
        } else if (intent.getBooleanExtra("shortcut_open", false)) {
            this.f1223h.c(new HoneyClientEvent("open_shortcut").b("uri", data.toString()));
            this.f1224i.a("tap_shortcut");
        } else {
            this.f1224i.a("from_other_app");
        }
    }

    public final boolean m1254a(Context context, String str) {
        return m1249a(context, str, null, null);
    }

    private boolean m1249a(Context context, String str, @Nullable Bundle bundle, @Nullable Map<String, Object> map) {
        this.f1225j.a(context, "IntentHandlerUtil");
        Intent a = this.f1217b.a(context, str);
        if (a == null) {
            this.f1225j.a();
            return false;
        }
        if (bundle != null) {
            a.putExtras(bundle);
        }
        if (a.hasExtra("is_diode")) {
            Bundle extras = a.getExtras();
            List<String> a2 = Lists.a();
            for (String str2 : extras.keySet()) {
                if ((extras.get(str2) instanceof Parcelable) && !(extras.get(str2) instanceof FrozenParcelable)) {
                    a2.add(str2);
                }
            }
            for (String str22 : a2) {
                extras.remove(str22);
            }
            a.putExtras(extras);
            if (a.hasExtra("trigger")) {
                String stringExtra = a.getStringExtra("trigger");
                if (!stringExtra.startsWith("diode")) {
                    a.putExtra("trigger", "diode_" + stringExtra);
                }
            } else {
                a.putExtra("trigger", "diode");
            }
        }
        return m1248a(context, str, a, (Map) map);
    }

    private boolean m1248a(Context context, String str, Intent intent, @Nullable Map<String, Object> map) {
        if (intent == null) {
            return false;
        }
        for (UriIntentListener a : this.f1222g) {
            a.a(context, str, intent, map);
        }
        Context b = ActivityMethodAutoProvider.b(FbInjector.get(context));
        m1251b(b != null ? b : context, intent);
        try {
            if (b instanceof Activity) {
                m1252c(context, intent);
            } else {
                intent.setFlags(intent.getFlags() | 268435456);
                m1252c(context, intent);
            }
            return true;
        } catch (Throwable e) {
            this.f1221f.a("IntentHandlerUtil", "Exception caught while starting Activity", e);
            return false;
        }
    }

    private void m1251b(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null && Objects.equal(component.getPackageName(), context.getPackageName())) {
            this.f1218c.a(new Intent().setComponent(this.f1226k).addFlags(270532608).setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").putExtra("finish_immediately", true), context);
        }
    }

    private void m1252c(Context context, Intent intent) {
        boolean hasExtra = intent.hasExtra("request_code");
        int intExtra = intent.getIntExtra("request_code", 0);
        Activity activity = hasExtra ? (Activity) ContextUtils.a(context, Activity.class) : null;
        if (!hasExtra || activity == null) {
            if (IntentResolver.a(context, intent)) {
                this.f1218c.a(intent, context);
            } else {
                this.f1218c.b(intent, context);
            }
        } else if (IntentResolver.a(context, intent)) {
            this.f1218c.a(intent, intExtra, activity);
        } else {
            this.f1218c.b(intent, intExtra, activity);
        }
    }

    private void m1247a(final Context context, Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putString("url", uri.toString());
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f1220e, "fetchNotificationURI", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(NotificationsFragment.class), 756767160).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ IntentHandlerUtil f1214b;

            public void onSuccess(@Nullable Object obj) {
                FetchNotificationURIResult fetchNotificationURIResult = (FetchNotificationURIResult) ((OperationResult) obj).h();
                if (!(fetchNotificationURIResult == null || fetchNotificationURIResult.a == null || fetchNotificationURIResult.a.notificationLongUrlList == null || fetchNotificationURIResult.a.notificationLongUrlList.isEmpty())) {
                    String str = ((NotificationLongURL) fetchNotificationURIResult.a.notificationLongUrlList.get(0)).longUrl;
                    if (str != null && this.f1214b.m1254a(context, str)) {
                        return;
                    }
                }
                this.f1214b.m1254a(context, FBLinks.bT);
            }

            public void onFailure(Throwable th) {
                this.f1214b.m1254a(context, FBLinks.bT);
            }
        }, this.f1219d);
    }
}

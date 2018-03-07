package com.facebook.ui.errordialog;

import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.IntendedAudience;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: play_video_interstitial */
public class ErrorDialogs {
    private static ErrorDialogs f9533g;
    private static final Object f9534h = new Object();
    public final Context f9535a;
    public final ErrorMessageGenerator f9536b;
    private final NavigationLogger f9537c;
    private final AbstractFbErrorReporter f9538d;
    public final SecureContextHelper f9539e;
    private final Provider<IntendedAudience> f9540f;

    private static ErrorDialogs m14523b(InjectorLike injectorLike) {
        return new ErrorDialogs((Context) injectorLike.getInstance(Context.class), ErrorMessageGenerator.m14518b(injectorLike), IdBasedProvider.m1811a(injectorLike, 872), NavigationLogger.m5475a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public ErrorDialogs(Context context, ErrorMessageGenerator errorMessageGenerator, Provider<IntendedAudience> provider, NavigationLogger navigationLogger, FbErrorReporter fbErrorReporter, SecureContextHelper secureContextHelper) {
        this.f9535a = context;
        this.f9536b = errorMessageGenerator;
        this.f9540f = provider;
        this.f9537c = navigationLogger;
        this.f9538d = fbErrorReporter;
        this.f9539e = secureContextHelper;
    }

    public static ErrorDialogs m14522a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ErrorDialogs b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9534h) {
                ErrorDialogs errorDialogs;
                if (a2 != null) {
                    errorDialogs = (ErrorDialogs) a2.mo818a(f9534h);
                } else {
                    errorDialogs = f9533g;
                }
                if (errorDialogs == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14523b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9534h, b3);
                        } else {
                            f9533g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = errorDialogs;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ErrorDialogParams m14525a(ServiceException serviceException) {
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f9535a);
        a.f = serviceException;
        return a.l();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.fbui.dialog.AlertDialog m14524a(com.facebook.ui.errordialog.ErrorDialogParams r11) {
        /*
        r10 = this;
        r2 = 1;
        r9 = 0;
        r7 = r11.e;
        if (r7 == 0) goto L_0x0010;
    L_0x0006:
        r7 = r10.f9536b;
        r8 = r11.e;
        r7 = r7.m14520a(r8, r9, r9);
        if (r7 != 0) goto L_0x0012;
    L_0x0010:
        r7 = r11.b;
    L_0x0012:
        if (r7 != 0) goto L_0x001d;
    L_0x0014:
        r7 = r10.f9535a;
        r8 = 2131230758; // 0x7f080026 float:1.8077578E38 double:1.052967901E-314;
        r7 = r7.getString(r8);
    L_0x001d:
        r8 = r11.k;
        if (r8 == 0) goto L_0x0025;
    L_0x0021:
        r7 = com.facebook.http.protocol.ApiErrorResult.a(r7);
    L_0x0025:
        r0 = r7;
        r1 = r11.c;
        if (r1 == 0) goto L_0x0043;
    L_0x002a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r1 = "\n\n";
        r0 = r0.append(r1);
        r1 = r11.c;
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x0043:
        r1 = r10.f9535a;
        r3 = android.app.Activity.class;
        r1 = com.facebook.common.util.ContextUtils.m2500a(r1, r3);
        if (r1 != 0) goto L_0x0057;
    L_0x004d:
        r1 = r10.f9535a;
        r3 = com.facebook.ui.dialogs.DialogWindowUtils.CustomDialogHostContext.class;
        r1 = com.facebook.common.util.ContextUtils.m2500a(r1, r3);
        if (r1 == 0) goto L_0x00e4;
    L_0x0057:
        r1 = r2;
    L_0x0058:
        r3 = "ErrorDialogBuilder should only be used with an Activity context or a context that implements CustomDialogHostContext";
        com.facebook.common.invariants.Invariants.a(r1, r3);
        r1 = r11.f;
        if (r1 != 0) goto L_0x0066;
    L_0x0061:
        r1 = new com.facebook.ui.errordialog.ErrorDialogs$1;
        r1.<init>(r10, r11);
    L_0x0066:
        r3 = new com.facebook.ui.errordialog.ErrorDialogs$2;
        r3.<init>(r10, r11);
        r4 = new com.facebook.ui.dialogs.FbAlertDialogBuilder;
        r5 = r10.f9535a;
        r4.<init>(r5);
        r5 = r11.a;
        r4 = r4.a(r5);
        r4 = r4.b(r0);
        r5 = r10.f9535a;
        r6 = 2131230726; // 0x7f080006 float:1.8077513E38 double:1.052967885E-314;
        r5 = r5.getString(r6);
        r1 = r4.a(r5, r1);
        r4 = r11.g;
        r1 = r1.a(r4);
        r4 = r11.e;
        if (r4 == 0) goto L_0x00a9;
    L_0x0093:
        r4 = r10.f9540f;
        r4 = r4.get();
        r5 = com.facebook.config.application.IntendedAudience.PUBLIC;
        if (r4 == r5) goto L_0x00a9;
    L_0x009d:
        r4 = r10.f9535a;
        r5 = 2131230769; // 0x7f080031 float:1.80776E38 double:1.0529679063E-314;
        r4 = r4.getString(r5);
        r1.c(r4, r3);
    L_0x00a9:
        r3 = r11.d;
        if (r3 == 0) goto L_0x00be;
    L_0x00ad:
        r3 = new com.facebook.ui.errordialog.ErrorDialogs$3;
        r3.<init>(r10, r11);
        r4 = r10.f9535a;
        r5 = 2131230785; // 0x7f080041 float:1.8077633E38 double:1.052967914E-314;
        r4 = r4.getString(r5);
        r1.c(r4, r3);
    L_0x00be:
        r3 = r10.f9537c;
        r4 = "error_dialog";
        r3.m5511a(r4, r2);
        r2 = r11.j;
        if (r2 == 0) goto L_0x00df;
    L_0x00c9:
        r2 = r10.f9538d;
        r3 = new java.lang.StringBuilder;
        r4 = "dialog-error:";
        r3.<init>(r4);
        r4 = r11.a;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.m2340a(r3, r0);
    L_0x00df:
        r0 = r1.b();
        return r0;
    L_0x00e4:
        r1 = 0;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.errordialog.ErrorDialogs.a(com.facebook.ui.errordialog.ErrorDialogParams):com.facebook.fbui.dialog.AlertDialog");
    }
}

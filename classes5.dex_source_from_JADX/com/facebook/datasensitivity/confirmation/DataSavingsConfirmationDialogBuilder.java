package com.facebook.datasensitivity.confirmation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fig.dialog.FigDialog.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _old_tables_cleaner */
public class DataSavingsConfirmationDialogBuilder {
    private static volatile DataSavingsConfirmationDialogBuilder f11762f;
    public final DsmAnalyticsEventLogger f11763a;
    private final DataSensitivitySettingsPrefUtil f11764b;
    public final SecureContextHelper f11765c;
    public final UriIntentMapper f11766d;
    private Tooltip f11767e;

    /* compiled from: _old_tables_cleaner */
    public class C11012 implements OnClickListener {
        final /* synthetic */ DataSavingsConfirmationDialogBuilder f11761a;

        public C11012(DataSavingsConfirmationDialogBuilder dataSavingsConfirmationDialogBuilder) {
            this.f11761a = dataSavingsConfirmationDialogBuilder;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f11761a.f11763a.b();
        }
    }

    public static com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder m19795a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11762f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder.class;
        monitor-enter(r1);
        r0 = f11762f;	 Catch:{ all -> 0x003a }
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
        r0 = m19796b(r0);	 Catch:{ all -> 0x0035 }
        f11762f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11762f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder.a(com.facebook.inject.InjectorLike):com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder");
    }

    private static DataSavingsConfirmationDialogBuilder m19796b(InjectorLike injectorLike) {
        return new DataSavingsConfirmationDialogBuilder(DsmAnalyticsEventLogger.a(injectorLike), DataSensitivitySettingsPrefUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    DataSavingsConfirmationDialogBuilder(DsmAnalyticsEventLogger dsmAnalyticsEventLogger, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        this.f11763a = dsmAnalyticsEventLogger;
        this.f11764b = dataSensitivitySettingsPrefUtil;
        this.f11765c = secureContextHelper;
        this.f11766d = uriIntentMapper;
    }

    public final void m19797a() {
        this.f11763a.d();
        this.f11764b.c(true);
    }

    public final void m19798a(final Context context) {
        this.f11763a.d();
        this.f11764b.c(true);
        this.f11763a.a();
        Builder builder = new Builder(context);
        builder.f12291a.i = ContextCompat.a(builder.f12291a.a, 2130838461);
        builder = builder.m20362a(2131233816).m20364b(2131233817);
        OnClickListener c11012 = new C11012(this);
        builder.f12291a.k = builder.f12291a.a.getText(2131233818);
        builder.f12291a.l = c11012;
        builder = builder;
        c11012 = new OnClickListener(this) {
            final /* synthetic */ DataSavingsConfirmationDialogBuilder f11760b;

            public void onClick(DialogInterface dialogInterface, int i) {
                Intent a = this.f11760b.f11766d.a(context, FBLinks.eM);
                this.f11760b.f11763a.e();
                this.f11760b.f11765c.a(a, context);
            }
        };
        builder.f12291a.m = builder.f12291a.a.getText(2131233819);
        builder.f12291a.n = c11012;
        builder.m20366b();
    }

    public final void m19799a(Context context, View view) {
        this.f11763a.c();
        this.f11767e = new Tooltip(context);
        this.f11767e.t = -1;
        this.f11767e.c(view);
        this.f11767e.b(2131233820);
        this.f11767e.a(2131233821);
        this.f11767e.d();
    }
}

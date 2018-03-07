package com.facebook.katana.urimap;

import android.content.Intent;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.crudolib.urimap.runtime.ComponentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.settings.PaymentSettingsPickerScreenParams;
import com.facebook.payments.settings.PaymentSettingsPickerScreenParamsBuilder;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenFetcherParams;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenFetcherParamsBuilder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_search */
public class PaymentSettingsPickerScreenActivityComponentHelper extends ComponentHelper {
    private static volatile PaymentSettingsPickerScreenActivityComponentHelper f4854b;
    private final Resources f4855a;

    public static com.facebook.katana.urimap.PaymentSettingsPickerScreenActivityComponentHelper m8690a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4854b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.PaymentSettingsPickerScreenActivityComponentHelper.class;
        monitor-enter(r1);
        r0 = f4854b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8691b(r0);	 Catch:{ all -> 0x0035 }
        f4854b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4854b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.PaymentSettingsPickerScreenActivityComponentHelper.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.PaymentSettingsPickerScreenActivityComponentHelper");
    }

    private static PaymentSettingsPickerScreenActivityComponentHelper m8691b(InjectorLike injectorLike) {
        return new PaymentSettingsPickerScreenActivityComponentHelper(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public PaymentSettingsPickerScreenActivityComponentHelper(Resources resources) {
        this.f4855a = resources;
    }

    public final Intent mo1269a(Intent intent) {
        Intent a = super.mo1269a(intent);
        PaymentSettingsPickerScreenParamsBuilder paymentSettingsPickerScreenParamsBuilder = new PaymentSettingsPickerScreenParamsBuilder();
        PickerScreenStyle pickerScreenStyle = PickerScreenStyle.FB_PAYMENT_SETTINGS;
        String string = this.f4855a.getString(2131236550);
        PickerScreenCommonParamsBuilder newBuilder = PickerScreenCommonParams.newBuilder();
        newBuilder.b = PickerScreenStyleParams.newBuilder().c();
        newBuilder = newBuilder;
        PickerScreenAnalyticsParamsBuilder newBuilder2 = PickerScreenAnalyticsParams.newBuilder();
        newBuilder2.a = "payment_settings";
        newBuilder2 = newBuilder2;
        newBuilder2.c = PaymentsFlowType.PICKER_SCREEN;
        newBuilder.a = newBuilder2.e();
        newBuilder = newBuilder;
        newBuilder.c = pickerScreenStyle;
        newBuilder = newBuilder;
        newBuilder.d = PaymentItemType.NONE;
        newBuilder = newBuilder;
        newBuilder.g = string;
        newBuilder = newBuilder;
        PaymentSettingsPickerScreenFetcherParamsBuilder newBuilder3 = PaymentSettingsPickerScreenFetcherParams.newBuilder();
        newBuilder3.a = true;
        newBuilder.h = newBuilder3.b();
        paymentSettingsPickerScreenParamsBuilder.a = newBuilder.j();
        PickerScreenActivity.a(a, new PaymentSettingsPickerScreenParams(paymentSettingsPickerScreenParamsBuilder));
        return a;
    }
}

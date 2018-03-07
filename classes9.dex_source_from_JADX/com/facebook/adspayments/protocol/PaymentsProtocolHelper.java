package com.facebook.adspayments.protocol;

import com.facebook.adspayments.model.BusinessAddressDetails;
import com.facebook.common.locale.Country;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.cardform.CardFormInput;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: USER_CLICKED_RESULT */
public class PaymentsProtocolHelper {
    private static volatile PaymentsProtocolHelper f23699h;
    private final GetAccountDetailsMethod f23700a;
    private final AddPaymentCardMethod f23701b;
    private final EditPaymentCardMethod f23702c;
    public final VerifyBrazilianTaxIdMethod f23703d;
    public final GetBrazilianAddressDetailsMethod f23704e;
    public final PostBusinessAddressMethod f23705f;
    public final GetPrepayDetailsMethod f23706g;

    public static com.facebook.adspayments.protocol.PaymentsProtocolHelper m25732a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23699h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adspayments.protocol.PaymentsProtocolHelper.class;
        monitor-enter(r1);
        r0 = f23699h;	 Catch:{ all -> 0x003a }
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
        r0 = m25733b(r0);	 Catch:{ all -> 0x0035 }
        f23699h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23699h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adspayments.protocol.PaymentsProtocolHelper.a(com.facebook.inject.InjectorLike):com.facebook.adspayments.protocol.PaymentsProtocolHelper");
    }

    private static PaymentsProtocolHelper m25733b(InjectorLike injectorLike) {
        return new PaymentsProtocolHelper(GetAccountDetailsMethod.m25712b(injectorLike), AddPaymentCardMethod.m25699b(injectorLike), EditPaymentCardMethod.m25709b(injectorLike), VerifyBrazilianTaxIdMethod.m25749b(injectorLike), GetBrazilianAddressDetailsMethod.m25718b(injectorLike), PostBusinessAddressMethod.m25740b(injectorLike), GetPrepayDetailsMethod.m25728b(injectorLike));
    }

    @Inject
    public PaymentsProtocolHelper(GetAccountDetailsMethod getAccountDetailsMethod, AddPaymentCardMethod addPaymentCardMethod, EditPaymentCardMethod editPaymentCardMethod, VerifyBrazilianTaxIdMethod verifyBrazilianTaxIdMethod, GetBrazilianAddressDetailsMethod getBrazilianAddressDetailsMethod, PostBusinessAddressMethod postBusinessAddressMethod, GetPrepayDetailsMethod getPrepayDetailsMethod) {
        this.f23700a = getAccountDetailsMethod;
        this.f23701b = addPaymentCardMethod;
        this.f23702c = editPaymentCardMethod;
        this.f23703d = verifyBrazilianTaxIdMethod;
        this.f23704e = getBrazilianAddressDetailsMethod;
        this.f23705f = postBusinessAddressMethod;
        this.f23706g = getPrepayDetailsMethod;
    }

    public final ListenableFuture<OperationResult> m25734a(CardFormInput cardFormInput, Country country, String str, String str2, PaymentItemType paymentItemType, boolean z) {
        return this.f23701b.a(new AddPaymentCardParams(cardFormInput.a, cardFormInput.c, cardFormInput.d, cardFormInput.e, cardFormInput.f, country, str, str2, paymentItemType, z));
    }

    public final ListenableFuture<OperationResult> m25735a(String str, PaymentItemType paymentItemType, String str2, int i, int i2, String str3, Country country) {
        return this.f23702c.a(new EditPaymentCardParams(str, paymentItemType, str2, i, i2, str3, country));
    }

    public final ListenableFuture<Void> m25736a(String str, String str2, BusinessAddressDetails businessAddressDetails, String str3, boolean z, boolean z2) {
        return this.f23705f.c(new PostBusinessAddressParams(str, str2, businessAddressDetails, str3, z, z2));
    }

    public final ListenableFuture<Void> m25737a(String str, String str2, BusinessAddressDetails businessAddressDetails, String str3, boolean z, boolean z2, String str4, BusinessAddressDetails businessAddressDetails2, String str5, boolean z3) {
        return this.f23705f.c(new PostBusinessAddressParams(str, str2, businessAddressDetails, str3, z, z2, str4, businessAddressDetails2, str5, z3));
    }
}

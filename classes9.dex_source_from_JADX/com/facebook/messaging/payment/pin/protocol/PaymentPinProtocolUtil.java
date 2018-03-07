package com.facebook.messaging.payment.pin.protocol;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PageInfo;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPinStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PageInfoModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPinStatusModel;
import com.facebook.messaging.payment.pin.model.CheckPaymentPinParams;
import com.facebook.messaging.payment.pin.model.DeletePaymentPinParams;
import com.facebook.messaging.payment.pin.model.FetchPageInfoParams;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.model.SetPaymentPinParams;
import com.facebook.messaging.payment.pin.model.SetPaymentPinParamsBuilder;
import com.facebook.messaging.payment.pin.model.UpdatePaymentPinStatusParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: gti */
public class PaymentPinProtocolUtil {
    private static volatile PaymentPinProtocolUtil f13740b;
    private final DefaultBlueServiceOperationFactory f13741a;

    /* compiled from: gti */
    class C15481 implements Function<OperationResult, PageInfo> {
        final /* synthetic */ PaymentPinProtocolUtil f13737a;

        C15481(PaymentPinProtocolUtil paymentPinProtocolUtil) {
            this.f13737a = paymentPinProtocolUtil;
        }

        public Object apply(Object obj) {
            return (PageInfoModel) ((OperationResult) obj).h();
        }
    }

    /* compiled from: gti */
    class C15492 implements Function<OperationResult, PaymentPin> {
        final /* synthetic */ PaymentPinProtocolUtil f13738a;

        C15492(PaymentPinProtocolUtil paymentPinProtocolUtil) {
            this.f13738a = paymentPinProtocolUtil;
        }

        public Object apply(Object obj) {
            return (PaymentPin) ((OperationResult) obj).h();
        }
    }

    /* compiled from: gti */
    public class C15503 implements Function<OperationResult, PaymentPinStatus> {
        final /* synthetic */ PaymentPinProtocolUtil f13739a;

        public C15503(PaymentPinProtocolUtil paymentPinProtocolUtil) {
            this.f13739a = paymentPinProtocolUtil;
        }

        public Object apply(Object obj) {
            return (PaymentPinStatusModel) ((OperationResult) obj).h();
        }
    }

    public static com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil m14279a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13740b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil.class;
        monitor-enter(r1);
        r0 = f13740b;	 Catch:{ all -> 0x003a }
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
        r0 = m14282b(r0);	 Catch:{ all -> 0x0035 }
        f13740b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13740b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil");
    }

    private static PaymentPinProtocolUtil m14282b(InjectorLike injectorLike) {
        return new PaymentPinProtocolUtil(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PaymentPinProtocolUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f13741a = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<OperationResult> m14286a(long j, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(UpdatePaymentPinStatusParams.f13722a, new UpdatePaymentPinStatusParams(j, str, str2, TriState.UNSET, null));
        return m14280a(bundle, "update_payment_pin_status");
    }

    public final ListenableFuture<OperationResult> m14285a(long j, String str, TriState triState, Map<Long, Boolean> map) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(UpdatePaymentPinStatusParams.f13722a, new UpdatePaymentPinStatusParams(j, str, null, triState, map));
        return m14280a(bundle, "update_payment_pin_status");
    }

    public final ListenableFuture<OperationResult> m14287a(long j, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DeletePaymentPinParams.f13705a, new DeletePaymentPinParams(j, str, z));
        return m14280a(bundle, "delete_payment_pin");
    }

    public final ListenableFuture<PaymentPin> m14284a(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CheckPaymentPinParams.f13702a, new CheckPaymentPinParams(j, str));
        return m14281a(m14280a(bundle, "check_payment_pin"));
    }

    public final ListenableFuture<PaymentPin> m14283a() {
        return m14281a(m14280a(new Bundle(), "fetch_payment_pin"));
    }

    public final ListenableFuture<PaymentPin> m14289a(String str, long j, TriState triState, Map<Long, Boolean> map) {
        Bundle bundle = new Bundle();
        String str2 = SetPaymentPinParams.f13713a;
        SetPaymentPinParamsBuilder setPaymentPinParamsBuilder = new SetPaymentPinParamsBuilder();
        setPaymentPinParamsBuilder.f13718a = str;
        setPaymentPinParamsBuilder = setPaymentPinParamsBuilder;
        setPaymentPinParamsBuilder.f13719b = j;
        setPaymentPinParamsBuilder = setPaymentPinParamsBuilder;
        setPaymentPinParamsBuilder.f13720c = triState;
        setPaymentPinParamsBuilder = setPaymentPinParamsBuilder;
        setPaymentPinParamsBuilder.f13721d = map;
        bundle.putParcelable(str2, new SetPaymentPinParams(setPaymentPinParamsBuilder));
        return m14281a(m14280a(bundle, "set_payment_pin"));
    }

    public final ListenableFuture<PaymentPinStatus> m14290b() {
        return Futures.a(m14280a(new Bundle(), "fetch_payment_pin_status"), new C15503(this), MoreExecutors.a());
    }

    public final ListenableFuture<PageInfo> m14288a(String str) {
        Parcelable fetchPageInfoParams = new FetchPageInfoParams(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FetchPageInfoParams.f13709a, fetchPageInfoParams);
        return Futures.a(m14280a(bundle, "fetch_page_info"), new C15481(this), MoreExecutors.a());
    }

    private ListenableFuture<OperationResult> m14280a(Bundle bundle, String str) {
        return BlueServiceOperationFactoryDetour.a(this.f13741a, str, bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), -1163176712).a();
    }

    private ListenableFuture<PaymentPin> m14281a(ListenableFuture<OperationResult> listenableFuture) {
        return Futures.a(listenableFuture, new C15492(this), MoreExecutors.a());
    }
}

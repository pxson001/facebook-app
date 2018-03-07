package com.facebook.payments.shipping.protocol;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.shipping.model.MailingAddress;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: backstage_camera_cancel */
public class MailingAddressProtocolUtil {
    private final ListeningExecutorService f19055a;
    private final GetMailingAddressesMethod f19056b;

    /* compiled from: backstage_camera_cancel */
    class C22471 implements Function<OperationResult, ImmutableList<MailingAddress>> {
        final /* synthetic */ MailingAddressProtocolUtil f19054a;

        C22471(MailingAddressProtocolUtil mailingAddressProtocolUtil) {
            this.f19054a = mailingAddressProtocolUtil;
        }

        public Object apply(Object obj) {
            return ((GetMailingAddressesResult) ((OperationResult) obj).h()).f19044a;
        }
    }

    public static MailingAddressProtocolUtil m19019b(InjectorLike injectorLike) {
        return new MailingAddressProtocolUtil(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GetMailingAddressesMethod.m19007b(injectorLike));
    }

    @Inject
    public MailingAddressProtocolUtil(ListeningExecutorService listeningExecutorService, GetMailingAddressesMethod getMailingAddressesMethod) {
        this.f19055a = listeningExecutorService;
        this.f19056b = getMailingAddressesMethod;
    }

    public final ListenableFuture<ImmutableList<MailingAddress>> m19020a() {
        return Futures.a(this.f19056b.a(null), new C22471(this), this.f19055a);
    }
}

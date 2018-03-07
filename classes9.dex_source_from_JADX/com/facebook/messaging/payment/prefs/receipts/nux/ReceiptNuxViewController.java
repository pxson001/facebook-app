package com.facebook.messaging.payment.prefs.receipts.nux;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController.ResultCallback;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationNuxDialogsHelper;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationParams.Builder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.VerificationFollowUpAction;
import com.facebook.messaging.payment.prefs.receipts.ReceiptFragment;
import com.facebook.messaging.payment.prefs.receipts.animation.ReceiptAnimationController;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptAmountViewController;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptSentTimeViewController;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.BetterButton;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gametime_match_reaction_units */
public class ReceiptNuxViewController {
    public static final Class<?> f14293a = ReceiptNuxViewController.class;
    private static ReceiptNuxViewController f14294s;
    private static final Object f14295t = new Object();
    private final ReceiptAnimationController f14296b;
    public final ReceiptAmountViewController f14297c;
    public final ReceiptSentTimeViewController f14298d;
    public final PaymentCardsFetcher f14299e;
    public final PaymentMethodVerificationController f14300f;
    public final PaymentMethodVerificationNuxDialogsHelper f14301g;
    public final AbstractFbErrorReporter f14302h;
    public final Executor f14303i;
    public PaymentTransaction f14304j;
    public ListenableFuture<ImmutableList<PaymentCard>> f14305k;
    public ImmutableList<PaymentCard> f14306l;
    public ReceiptFragment f14307m;
    public FbTextView f14308n;
    public LinearLayout f14309o;
    private BetterButton f14310p;
    private FbTextView f14311q;
    public FbTextView f14312r;

    /* compiled from: gametime_match_reaction_units */
    class C16211 implements OnClickListener {
        final /* synthetic */ ReceiptNuxViewController f14286a;

        C16211(ReceiptNuxViewController receiptNuxViewController) {
            this.f14286a = receiptNuxViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 958961963);
            DeclinePaymentDialogFragment.m14710a(this.f14286a.f14304j.f13231d.mo527c(), this.f14286a.f14304j.f13229b).a(this.f14286a.f14307m.kO_(), "decline_payment_dialog_fragment");
            Logger.a(2, EntryType.UI_INPUT_END, 1422032551, a);
        }
    }

    /* compiled from: gametime_match_reaction_units */
    public class C16222 implements FutureCallback<ImmutableList<PaymentCard>> {
        final /* synthetic */ ReceiptNuxViewController f14287a;

        public C16222(ReceiptNuxViewController receiptNuxViewController) {
            this.f14287a = receiptNuxViewController;
        }

        public void onSuccess(Object obj) {
            this.f14287a.f14306l = (ImmutableList) obj;
            ReceiptNuxViewController receiptNuxViewController = this.f14287a;
            ReceiptAmountViewController receiptAmountViewController = receiptNuxViewController.f14297c;
            receiptAmountViewController.f14039e.getLocationOnScreen(receiptAmountViewController.f14038d);
            ReceiptSentTimeViewController receiptSentTimeViewController = receiptNuxViewController.f14298d;
            receiptSentTimeViewController.f14130e.getLocationOnScreen(receiptSentTimeViewController.f14128c);
            ViewTreeObserver viewTreeObserver = receiptNuxViewController.f14309o.getViewTreeObserver();
            viewTreeObserver.addOnPreDrawListener(new C16255(receiptNuxViewController, viewTreeObserver));
            ReceiptAnimationController.m14527a(receiptNuxViewController.f14308n, 0);
            ReceiptAnimationController.m14527a(receiptNuxViewController.f14309o, 0);
            ReceiptAnimationController.m14527a(receiptNuxViewController.f14312r, 0);
        }

        public void onFailure(Throwable th) {
            BLog.b(ReceiptNuxViewController.f14293a, "Payment cards failed to fetch");
        }
    }

    /* compiled from: gametime_match_reaction_units */
    public class C16233 implements ResultCallback {
        final /* synthetic */ ReceiptNuxViewController f14288a;

        public C16233(ReceiptNuxViewController receiptNuxViewController) {
            this.f14288a = receiptNuxViewController;
        }

        public final void mo544a() {
            this.f14288a.f14302h.b(ReceiptNuxViewController.f14293a.getName(), "A card already verified event received when adding a new card");
        }

        public final void mo545a(PaymentCard paymentCard, @Nullable VerificationFollowUpAction verificationFollowUpAction, boolean z, boolean z2) {
            this.f14288a.f14301g.m13459a(z, z2, verificationFollowUpAction);
        }

        public final void mo546b() {
        }

        public final void mo547c() {
        }
    }

    /* compiled from: gametime_match_reaction_units */
    public class C16255 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f14291a;
        final /* synthetic */ ReceiptNuxViewController f14292b;

        public C16255(ReceiptNuxViewController receiptNuxViewController, ViewTreeObserver viewTreeObserver) {
            this.f14292b = receiptNuxViewController;
            this.f14291a = viewTreeObserver;
        }

        public boolean onPreDraw() {
            this.f14291a.removeOnPreDrawListener(this);
            ReceiptAmountViewController receiptAmountViewController = this.f14292b.f14297c;
            ReceiptAnimationController.m14528a(receiptAmountViewController.f14039e, receiptAmountViewController.f14038d);
            ReceiptSentTimeViewController receiptSentTimeViewController = this.f14292b.f14298d;
            ReceiptAnimationController.m14528a(receiptSentTimeViewController.f14130e, receiptSentTimeViewController.f14128c);
            return false;
        }
    }

    private static ReceiptNuxViewController m14720b(InjectorLike injectorLike) {
        return new ReceiptNuxViewController(ReceiptAnimationController.m14526a(injectorLike), ReceiptAmountViewController.m14529a(injectorLike), ReceiptSentTimeViewController.m14593a(injectorLike), PaymentCardsFetcher.m13429a(injectorLike), PaymentMethodVerificationController.m13449b(injectorLike), PaymentMethodVerificationNuxDialogsHelper.m13457b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static ReceiptNuxViewController m14719a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptNuxViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14295t) {
                ReceiptNuxViewController receiptNuxViewController;
                if (a2 != null) {
                    receiptNuxViewController = (ReceiptNuxViewController) a2.a(f14295t);
                } else {
                    receiptNuxViewController = f14294s;
                }
                if (receiptNuxViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14720b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14295t, b3);
                        } else {
                            f14294s = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptNuxViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReceiptNuxViewController(ReceiptAnimationController receiptAnimationController, ReceiptAmountViewController receiptAmountViewController, ReceiptSentTimeViewController receiptSentTimeViewController, PaymentCardsFetcher paymentCardsFetcher, PaymentMethodVerificationController paymentMethodVerificationController, PaymentMethodVerificationNuxDialogsHelper paymentMethodVerificationNuxDialogsHelper, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor) {
        this.f14296b = receiptAnimationController;
        this.f14297c = receiptAmountViewController;
        this.f14298d = receiptSentTimeViewController;
        this.f14299e = paymentCardsFetcher;
        this.f14300f = paymentMethodVerificationController;
        this.f14301g = paymentMethodVerificationNuxDialogsHelper;
        this.f14302h = abstractFbErrorReporter;
        this.f14303i = executor;
    }

    public final void m14722a(FbTextView fbTextView, LinearLayout linearLayout, BetterButton betterButton, FbTextView fbTextView2, FbTextView fbTextView3) {
        this.f14308n = fbTextView;
        this.f14309o = linearLayout;
        this.f14310p = betterButton;
        this.f14311q = fbTextView2;
        this.f14312r = fbTextView3;
        BetterButton betterButton2 = this.f14310p;
        final ResultCallback c16233 = new C16233(this);
        betterButton2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReceiptNuxViewController f14290b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1360408200);
                Builder newBuilder = PaymentMethodVerificationParams.newBuilder();
                newBuilder.f13172b = this.f14290b.f14306l;
                newBuilder = newBuilder;
                newBuilder.f13175e = PaymentFlowType.NUX;
                newBuilder = newBuilder;
                newBuilder.f13173c = this.f14290b.f14307m;
                newBuilder = newBuilder;
                newBuilder.f13176f = this.f14290b.f14304j.f13231d.mo527c();
                newBuilder = newBuilder;
                newBuilder.f13177g = this.f14290b.f14304j.f13229b;
                this.f14290b.f14300f.m13455a(newBuilder.m13461a(), c16233);
                Logger.a(2, EntryType.UI_INPUT_END, 1440781874, a);
            }
        });
        this.f14311q.setOnClickListener(new C16211(this));
    }

    public final void m14721a(PaymentTransaction paymentTransaction, ReceiptFragment receiptFragment) {
        this.f14304j = paymentTransaction;
        this.f14307m = receiptFragment;
        if (this.f14304j.f13234g != TransferStatus.R_PENDING_NUX) {
            this.f14308n.setVisibility(8);
            this.f14309o.setVisibility(8);
            this.f14312r.setVisibility(8);
            return;
        }
        this.f14305k = this.f14299e.m13434a();
        Futures.a(this.f14305k, new C16222(this), this.f14303i);
    }
}

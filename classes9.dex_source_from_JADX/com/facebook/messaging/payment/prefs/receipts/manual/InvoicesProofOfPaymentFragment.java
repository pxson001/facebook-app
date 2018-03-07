package com.facebook.messaging.payment.prefs.receipts.manual;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment.Listener;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentPresenter.C16174;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesProofOfPaymentPresenter.Tasks;
import com.facebook.messaging.payment.service.model.cards.ManualTransferMethod;
import com.facebook.pages.common.util.PortraitOrientationController;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Inject;

/* compiled from: getPaymentTransaction */
public class InvoicesProofOfPaymentFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public InvoicesProofOfPaymentPresenterProvider f14164a;
    public boolean al;
    @Nullable
    private EventListener am;
    private final C16111 an = new C16111(this);
    private final Listener ao = new C16122(this);
    @Inject
    public InvoicesProofOfPaymentMediaControllerProvider f14165b;
    @Inject
    public SecureContextHelper f14166c;
    public InvoicesProofOfPaymentPresenter f14167d;
    public InvoicesProofOfPaymentMediaController f14168e;
    private String f14169f;
    @Nullable
    private String f14170g;
    @Nullable
    private String f14171h;
    public ManualTransferMethod f14172i;

    /* compiled from: getPaymentTransaction */
    public class C16111 {
        public final /* synthetic */ InvoicesProofOfPaymentFragment f14160a;

        C16111(InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment) {
            this.f14160a = invoicesProofOfPaymentFragment;
        }
    }

    /* compiled from: getPaymentTransaction */
    class C16122 implements Listener {
        final /* synthetic */ InvoicesProofOfPaymentFragment f14161a;

        C16122(InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment) {
            this.f14161a = invoicesProofOfPaymentFragment;
        }

        public final void mo556a(List<MediaResource> list) {
            if (!(list == null || list.isEmpty())) {
                Uri uri;
                InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter = this.f14161a.f14167d;
                MediaResourceBuilder a = new MediaResourceBuilder().a((MediaResource) list.get(0));
                a.b = Type.ENT_PHOTO;
                MediaResource C = a.C();
                invoicesProofOfPaymentPresenter.f14187i = C;
                InvoicesProofOfPaymentView invoicesProofOfPaymentView = invoicesProofOfPaymentPresenter.f14184f;
                if (C != null) {
                    uri = C.c;
                } else {
                    uri = null;
                }
                CallerContext callerContext = InvoicesProofOfPaymentPresenter.f14179a;
                invoicesProofOfPaymentView.f14202i.setVisibility(0);
                invoicesProofOfPaymentView.f14203j.setVisibility(0);
                invoicesProofOfPaymentView.f14200g.setVisibility(8);
                invoicesProofOfPaymentView.f14204k.a(uri, callerContext);
            }
            this.f14161a.C();
        }

        public final void mo555a() {
        }

        public final void mo557b() {
        }
    }

    /* compiled from: getPaymentTransaction */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "InvoicesProofOfPaymentFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new InvoicesProofOfPaymentFragment();
        }
    }

    /* compiled from: getPaymentTransaction */
    final class InterceptEventListener implements EventListener {
        final /* synthetic */ InvoicesProofOfPaymentFragment f14162a;
        @Nullable
        private final EventListener f14163b;

        public InterceptEventListener(InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment, @Nullable EventListener eventListener) {
            this.f14162a = invoicesProofOfPaymentFragment;
            this.f14163b = eventListener;
        }

        public final void mo313a() {
            this.f14162a.al = true;
            this.f14162a.C();
            if (this.f14163b != null) {
                this.f14163b.mo313a();
            }
        }

        public final void mo314b() {
            this.f14162a.al = false;
            this.f14162a.C();
            if (this.f14163b != null) {
                this.f14163b.mo314b();
            }
        }
    }

    public static void m14637a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment = (InvoicesProofOfPaymentFragment) obj;
        InvoicesProofOfPaymentPresenterProvider invoicesProofOfPaymentPresenterProvider = (InvoicesProofOfPaymentPresenterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InvoicesProofOfPaymentPresenterProvider.class);
        InvoicesProofOfPaymentMediaControllerProvider invoicesProofOfPaymentMediaControllerProvider = (InvoicesProofOfPaymentMediaControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(InvoicesProofOfPaymentMediaControllerProvider.class);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        invoicesProofOfPaymentFragment.f14164a = invoicesProofOfPaymentPresenterProvider;
        invoicesProofOfPaymentFragment.f14165b = invoicesProofOfPaymentMediaControllerProvider;
        invoicesProofOfPaymentFragment.f14166c = secureContextHelper;
    }

    public final void m14648c(Bundle bundle) {
        super.c(bundle);
        e(true);
        Class cls = InvoicesProofOfPaymentFragment.class;
        m14637a((Object) this, getContext());
        a(new PortraitOrientationController());
    }

    public final View m14640a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 89285007);
        View inflate = layoutInflater.inflate(2130903642, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1549690415, a);
        return inflate;
    }

    public final void m14646a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f14167d = this.f14164a.m14657a(new InvoicesProofOfPaymentView((ViewGroup) view), this.f14169f, this.an, this.f14170g, this.f14171h);
        this.f14168e = new InvoicesProofOfPaymentMediaController(this);
        m14638b();
    }

    public final void m14639I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1672954739);
        super.I();
        InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter = this.f14167d;
        invoicesProofOfPaymentPresenter.f14183e.c();
        invoicesProofOfPaymentPresenter.f14188j = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1112342899, a);
    }

    public final void m14645a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (this.al) {
            menuInflater.inflate(2131820583, menu);
        }
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568680) {
            return false;
        }
        InvoicesProofOfPaymentPresenter invoicesProofOfPaymentPresenter = this.f14167d;
        Preconditions.checkNotNull(invoicesProofOfPaymentPresenter.f14187i, "Cannot perform media upload with null MediaResource");
        if (invoicesProofOfPaymentPresenter.f14189k == null || !invoicesProofOfPaymentPresenter.f14189k.isShowing()) {
            invoicesProofOfPaymentPresenter.f14189k = new ProgressDialog(invoicesProofOfPaymentPresenter.f14184f.m14658a());
            invoicesProofOfPaymentPresenter.f14189k.a(invoicesProofOfPaymentPresenter.f14184f.m14658a().getString(2131240601));
            invoicesProofOfPaymentPresenter.f14189k.show();
        }
        invoicesProofOfPaymentPresenter.f14188j = invoicesProofOfPaymentPresenter.f14182d.a(invoicesProofOfPaymentPresenter.f14187i);
        invoicesProofOfPaymentPresenter.f14183e.a(Tasks.UPLOAD_RECEIPT, invoicesProofOfPaymentPresenter.f14188j, new C16174(invoicesProofOfPaymentPresenter));
        return true;
    }

    public final void m14644a(Menu menu) {
        super.a(menu);
        MenuItem findItem = menu.findItem(2131568680);
        if (findItem != null) {
            findItem.setEnabled(this.f14167d.f14187i != null);
        }
    }

    public final void mo310a(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        this.f14169f = bundle.getString("InvoicesProofOfPaymentFragment_KEY_TRANSACTION_ID");
        this.f14172i = (ManualTransferMethod) Preconditions.checkNotNull((ManualTransferMethod) bundle.getParcelable("InvoicesProofOfPaymentFragment_KEY_MANUAL_TRANSFER_METHOD"));
        this.f14170g = this.f14172i.f14640d;
        this.f14171h = this.f14172i.f14641e;
        Preconditions.checkState(!StringUtil.a(this.f14169f));
    }

    public final String mo309a(Context context) {
        return context.getString(2131240590);
    }

    public final void mo311a(EventListener eventListener) {
        this.am = new InterceptEventListener(this, eventListener);
        m14638b();
    }

    private void m14638b() {
        if (this.f14167d != null) {
            this.f14167d.f14186h = this.am;
        }
    }

    public final void m14643a(Fragment fragment) {
        if (fragment instanceof PickMediaDialogFragment) {
            ((PickMediaDialogFragment) fragment).aE = this.ao;
        }
    }
}

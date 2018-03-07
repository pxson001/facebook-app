package com.facebook.confirmation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.confirmation.util.ConfirmationUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.model.Contactpoint;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitialType */
public abstract class ConfContactpointFragment extends ConfInputFragment {
    @Inject
    public DefaultBlueServiceOperationFactory f10746b;
    @Inject
    public Lazy<BackgroundConfirmationHelper> f10747c;
    @Inject
    public ConfirmationUtil f10748d;
    private final CallerContext f10749e = CallerContext.a(ConfContactpointFragment.class);
    private TextView f10750f;

    /* compiled from: interstitialType */
    class C11531 implements OnClickListener {
        final /* synthetic */ ConfContactpointFragment f10743a;

        C11531(ConfContactpointFragment confContactpointFragment) {
            this.f10743a = confContactpointFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1093650628);
            this.f10743a.m12663a(this.f10743a.ay());
            Logger.a(2, EntryType.UI_INPUT_END, 572004654, a);
        }
    }

    public static void m12676a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ConfContactpointFragment confContactpointFragment = (ConfContactpointFragment) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        Lazy a = IdBasedLazy.a(fbInjector, 882);
        ConfirmationUtil b2 = ConfirmationUtil.m12750b(fbInjector);
        confContactpointFragment.f10746b = b;
        confContactpointFragment.f10747c = a;
        confContactpointFragment.f10748d = b2;
    }

    @Nullable
    protected abstract Contactpoint au();

    protected abstract ConfFragmentState av();

    public void mo755c(Bundle bundle) {
        super.mo755c(bundle);
        Class cls = ConfContactpointFragment.class;
        m12676a(this, getContext());
    }

    protected final void mo754b(View view, Bundle bundle) {
        this.f10750f = (TextView) FindViewUtil.b(view, 2131560673);
        if (this.al.f10778c) {
            this.f10750f.setVisibility(8);
        } else {
            this.f10750f.setText(az());
            this.f10750f.setOnClickListener(new C11531(this));
        }
        mo765b(view);
    }

    protected void mo765b(View view) {
    }

    protected final int aq() {
        return 2130903744;
    }

    protected final int as() {
        return 2131239765;
    }

    protected final void at() {
        final Object au = au();
        if (au != null && au.m17345a()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("confirmationEditRegistrationContactpointParams", au);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f10746b, "confirmation_edit_registration_contactpoint", bundle, ErrorPropagation.BY_ERROR_CODE, this.f10749e, -808978468).a(new DialogBasedProgressIndicator(getContext(), 2131230757)).a(), new OperationResultFutureCallback(this) {
                final /* synthetic */ ConfContactpointFragment f10745b;

                protected final void m12674a(ServiceException serviceException) {
                    this.f10745b.m12664a(serviceException);
                }

                protected final void m12675a(Object obj) {
                    if (this.f10745b.al.f10777b) {
                        this.f10745b.f10748d.m12751a();
                    }
                    this.f10745b.al.m12726a(au);
                    ((BackgroundConfirmationHelper) this.f10745b.f10747c.get()).a(au);
                    this.f10745b.m12663a(this.f10745b.av());
                }
            }, this.am);
        }
    }
}

package com.facebook.messaging.business.nativesignup.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.AppInfo;
import com.facebook.content.AppInfoCore;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel.MessengerCommerceModel.NewUserSignupModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel.MessengerCommerceModel.NewUserSignupModel.ServiceIntroImageModel;
import com.facebook.messaging.business.nativesignup.helpers.BusinessNativeSignUpResultHandler;
import com.facebook.messaging.business.nativesignup.helpers.STATICDI_MULTIBIND_PROVIDER$BusinessNativeSignUpResultHandler;
import com.facebook.messaging.business.nativesignup.loaders.SignUpQueryLoader;
import com.facebook.messaging.business.nativesignup.loaders.SignUpQueryLoader.Callback;
import com.facebook.messaging.business.nativesignup.logging.NativeSignUpLogger;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.ride.abtest.ExperimentsForRideAbtestModule;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: msg_send_attempted */
public final class BusinessSignUpFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public SignUpQueryLoader f9010a;
    public boolean al;
    public boolean am;
    private boolean an;
    private FbDraweeView ao;
    private BetterTextView ap;
    private BetterTextView aq;
    private BetterTextView ar;
    private BetterButton as;
    public ImageView at;
    private ProgressBar au;
    private FbRelativeLayout av;
    private FbDraweeView aw;
    @Nullable
    public NewUserSignupModel ax;
    @Inject
    SecureContextHelper f9011b;
    @Inject
    BusinessMessageDialogHelper f9012c;
    @Inject
    public Set<BusinessNativeSignUpResultHandler> f9013d;
    @Inject
    public NativeSignUpLogger f9014e;
    @Inject
    AbstractFbErrorReporter f9015f;
    @Inject
    AppInfo f9016g;
    private final AbstractFbActivityListener f9017h = new C10431(this);
    public NativeSignUpParams f9018i;

    /* compiled from: msg_send_attempted */
    class C10431 extends AbstractFbActivityListener {
        final /* synthetic */ BusinessSignUpFragment f9003a;

        C10431(BusinessSignUpFragment businessSignUpFragment) {
            this.f9003a = businessSignUpFragment;
        }

        public final boolean m9262i(Activity activity) {
            BusinessSignUpFragment.m9269a(this.f9003a, "back_button_pressed");
            BusinessSignUpFragment businessSignUpFragment = this.f9003a;
            for (BusinessNativeSignUpResultHandler businessNativeSignUpResultHandler : businessSignUpFragment.f9013d) {
                if (businessSignUpFragment.f9018i.f8885b.equals(businessNativeSignUpResultHandler.mo321a()) && businessNativeSignUpResultHandler.mo323b(businessSignUpFragment.f9018i)) {
                    break;
                }
            }
            return false;
        }
    }

    /* compiled from: msg_send_attempted */
    public class C10442 implements Callback {
        final /* synthetic */ BusinessSignUpFragment f9004a;

        public C10442(BusinessSignUpFragment businessSignUpFragment) {
            this.f9004a = businessSignUpFragment;
        }

        public final void mo327a(NewUserSignupModel newUserSignupModel) {
            this.f9004a.ax = newUserSignupModel;
            BusinessSignUpFragment.m9272b(this.f9004a, newUserSignupModel);
            BusinessSignUpFragment.m9270a(this.f9004a, false);
            this.f9004a.f9014e.m9161b("success_load_new_user_signup", "BusinessSignUpFragment");
        }

        public final void mo326a() {
            BusinessSignUpFragment.m9270a(this.f9004a, false);
            this.f9004a.f9012c.m9019a();
            this.f9004a.f9014e.m9161b("error_load_new_user_signup", "BusinessSignUpFragment");
        }
    }

    /* compiled from: msg_send_attempted */
    public class C10475 implements OnClickListener {
        final /* synthetic */ BusinessSignUpFragment f9009a;

        public C10475(BusinessSignUpFragment businessSignUpFragment) {
            this.f9009a = businessSignUpFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 712807467);
            this.f9009a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 544973409, a);
        }
    }

    /* compiled from: msg_send_attempted */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessSignUpFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessSignUpFragment();
        }
    }

    public static void m9271a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BusinessSignUpFragment) obj).m9268a(SignUpQueryLoader.m9154b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BusinessNativeSignUpResultHandler(injectorLike)), NativeSignUpLogger.m9158b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AppInfo.a(injectorLike));
    }

    private void m9268a(SignUpQueryLoader signUpQueryLoader, SecureContextHelper secureContextHelper, BusinessMessageDialogHelper businessMessageDialogHelper, Set<BusinessNativeSignUpResultHandler> set, NativeSignUpLogger nativeSignUpLogger, FbErrorReporter fbErrorReporter, AppInfo appInfo) {
        this.f9010a = signUpQueryLoader;
        this.f9011b = secureContextHelper;
        this.f9012c = businessMessageDialogHelper;
        this.f9013d = set;
        this.f9014e = nativeSignUpLogger;
        this.f9015f = fbErrorReporter;
        this.f9016g = appInfo;
    }

    public final String mo309a(Context context) {
        return "";
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void m9283e(Bundle bundle) {
        super.e(bundle);
        FlatBufferModelHelper.a(bundle, "new_user_signup", this.ax);
        bundle.putBoolean("is_funnel_logging_started", this.al);
        bundle.putBoolean("is_new_sign_up_logged", this.am);
        bundle.putBoolean("is_warning_message_showed", this.an);
    }

    public final void mo310a(Parcelable parcelable) {
        this.f9018i = (NativeSignUpParams) ((Bundle) parcelable).getParcelable("native_signup_params");
    }

    public final void m9282c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessSignUpFragment.class;
        m9271a((Object) this, getContext());
        if (bundle != null) {
            this.ax = (NewUserSignupModel) FlatBufferModelHelper.a(bundle, "new_user_signup");
            this.al = bundle.getBoolean("is_funnel_logging_started", false);
            this.am = bundle.getBoolean("is_new_sign_up_logged", false);
            this.an = bundle.getBoolean("is_warning_message_showed", false);
        }
    }

    public final View m9276a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1832327802);
        View inflate = layoutInflater.inflate(2130903473, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 190903831, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1765028321);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -535943484, a);
    }

    public final void m9280a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ao = (FbDraweeView) e(2131560114);
        this.ap = (BetterTextView) e(2131560115);
        this.aq = (BetterTextView) e(2131560116);
        this.ar = (BetterTextView) e(2131560117);
        this.at = (ImageView) e(2131560079);
        this.as = (BetterButton) e(2131560118);
        this.au = (ProgressBar) e(2131560120);
        this.av = (FbRelativeLayout) e(2131560113);
        this.aw = (FbDraweeView) e(2131560119);
        this.at.setOnClickListener(new C10475(this));
        if (this.ax == null) {
            m9270a(this, true);
            this.f9010a.m9156a(this.f9018i, new C10442(this));
        } else {
            m9272b(this, this.ax);
            m9270a(this, false);
        }
        this.f9014e.m9160b(this.f9018i);
        NativeSignUpParams nativeSignUpParams = this.f9018i;
        if (!this.al) {
            this.al = true;
            NativeSignUpLogger nativeSignUpLogger = this.f9014e;
            nativeSignUpLogger.f8875a.a(FunnelRegistry.p);
            nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "PROVIDER_ID:" + nativeSignUpParams.f8884a);
            if (!Strings.isNullOrEmpty(nativeSignUpParams.f8886c)) {
                nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "TRIGGER_SOURCE:" + nativeSignUpParams.f8886c);
            }
            if (!Strings.isNullOrEmpty(nativeSignUpParams.f8887d)) {
                nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "TRIGGER_SOURCE_TAG:" + nativeSignUpParams.f8887d);
            }
            if (nativeSignUpParams.f8888e != null) {
                nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "THREAD_ID:" + String.valueOf(nativeSignUpParams.f8888e.i()));
                nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "THREAD_TYPE:" + nativeSignUpParams.f8888e.a.toString());
            }
            if (Strings.isNullOrEmpty(nativeSignUpParams.f8890g)) {
                nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "TRIGGER_PROMO_DATA:" + nativeSignUpParams.f8890g);
            }
            nativeSignUpLogger.f8875a.a(FunnelRegistry.p, "INTRO_IMAGE_QE_GROUP:" + nativeSignUpLogger.f8876b.a(ExperimentsForRideAbtestModule.f9054f, "default"));
        }
    }

    public final void m9278a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    int intExtra = intent.getIntExtra("next_step", -1);
                    if (intExtra == 2) {
                        as();
                        return;
                    } else if (intExtra == 1) {
                        m9269a(this, "complete_create_account");
                        at();
                        ao().finish();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    m9269a(this, "complete_oauth");
                    at();
                    ao().finish();
                    return;
                }
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    public final void m9274G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1665386229);
        super.G();
        if (ao() instanceof FbFragmentActivity) {
            ((FbFragmentActivity) ao()).a(this.f9017h);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -747335089, a);
    }

    public final void m9275H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1501992652);
        super.H();
        if (ao() instanceof FbFragmentActivity) {
            ((FbFragmentActivity) ao()).b(this.f9017h);
        }
        this.f9010a.m9155a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1032454429, a);
    }

    public static Intent m9267a(Context context, NativeSignUpParams nativeSignUpParams) {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("native_signup_params", nativeSignUpParams);
        return BusinessActivity.m8889a(context, "BusinessSignUpFragment", bundle);
    }

    public static void m9272b(BusinessSignUpFragment businessSignUpFragment, final NewUserSignupModel newUserSignupModel) {
        if (!businessSignUpFragment.am) {
            businessSignUpFragment.am = true;
            businessSignUpFragment.f9014e.f8875a.a(FunnelRegistry.p, "IS_OPTIONAL_PAYMENT_ENABLED:" + Boolean.toString(newUserSignupModel.m9091c()));
        }
        if (newUserSignupModel.m9103s() != null) {
            Object obj;
            ServiceIntroImageModel s = newUserSignupModel.m9103s();
            if (s.m9067a() > s.m9072c()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                businessSignUpFragment.ao.setAspectRatio(((float) newUserSignupModel.m9103s().m9072c()) / ((float) newUserSignupModel.m9103s().m9067a()));
                businessSignUpFragment.ap.setVisibility(8);
                businessSignUpFragment.aq.setVisibility(8);
            } else {
                TypedValue typedValue = new TypedValue();
                businessSignUpFragment.jW_().getValue(2131433755, typedValue, true);
                businessSignUpFragment.ao.setAspectRatio(typedValue.getFloat());
                businessSignUpFragment.ap.setText(newUserSignupModel.m9102r());
                businessSignUpFragment.aq.setText(newUserSignupModel.m9105u());
            }
            businessSignUpFragment.ao.a(Uri.parse(newUserSignupModel.m9103s().m9071b()), CallerContext.a(BusinessSignUpFragment.class));
        }
        if (newUserSignupModel.m9104t() != null) {
            businessSignUpFragment.aw.a(Uri.parse(newUserSignupModel.m9104t().m9077a()), CallerContext.a(BusinessSignUpFragment.class));
        }
        if (m9273b(businessSignUpFragment, newUserSignupModel.m9099o())) {
            businessSignUpFragment.as.setText(newUserSignupModel.m9088a());
            businessSignUpFragment.ar.setText(newUserSignupModel.m9090b());
        } else {
            businessSignUpFragment.as.setText(newUserSignupModel.m9090b());
            businessSignUpFragment.ar.setText(newUserSignupModel.m9088a());
        }
        businessSignUpFragment.ar.setOnClickListener(new OnClickListener(businessSignUpFragment) {
            final /* synthetic */ BusinessSignUpFragment f9006b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1819232699);
                if (BusinessSignUpFragment.m9273b(this.f9006b, newUserSignupModel.m9099o())) {
                    BusinessSignUpFragment.ar(this.f9006b);
                } else {
                    BusinessSignUpFragment.aq(this.f9006b);
                }
                LogUtils.a(1374686079, a);
            }
        });
        businessSignUpFragment.as.setOnClickListener(new OnClickListener(businessSignUpFragment) {
            final /* synthetic */ BusinessSignUpFragment f9008b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 933198333);
                if (BusinessSignUpFragment.m9273b(this.f9008b, newUserSignupModel.m9099o())) {
                    BusinessSignUpFragment.aq(this.f9008b);
                } else {
                    BusinessSignUpFragment.ar(this.f9008b);
                }
                LogUtils.a(747695406, a);
            }
        });
        if (!businessSignUpFragment.an && !Strings.isNullOrEmpty(newUserSignupModel.m9106v())) {
            businessSignUpFragment.an = true;
            businessSignUpFragment.f9012c.m9020a(newUserSignupModel.m9106v());
        }
    }

    public static void m9270a(BusinessSignUpFragment businessSignUpFragment, boolean z) {
        if (z) {
            businessSignUpFragment.av.setVisibility(4);
            businessSignUpFragment.at.setVisibility(4);
            businessSignUpFragment.au.setVisibility(0);
            return;
        }
        businessSignUpFragment.av.setVisibility(0);
        businessSignUpFragment.at.setVisibility(0);
        businessSignUpFragment.au.setVisibility(4);
    }

    public static void aq(BusinessSignUpFragment businessSignUpFragment) {
        businessSignUpFragment.f9014e.m9159a("click_log_in_button");
        businessSignUpFragment.as();
    }

    public static void ar(BusinessSignUpFragment businessSignUpFragment) {
        businessSignUpFragment.f9014e.m9159a("click_sign_up_button");
        Context context = businessSignUpFragment.getContext();
        Parcelable parcelable = businessSignUpFragment.f9018i;
        Parcelable bundle = new Bundle();
        bundle.putParcelable("native_signup_params", parcelable);
        businessSignUpFragment.f9011b.a(BusinessActivity.m8889a(context, "BusinessCreateAccountFragment", bundle), 1, businessSignUpFragment);
    }

    private void as() {
        if (this.ax == null) {
            this.f9015f.a("BusinessSignUpFragment", "mNewUserSignup object is null in openOauthFragment()");
            this.f9012c.m9019a();
            return;
        }
        Context context = getContext();
        String p = this.ax.m9100p();
        String string = jW_().getString(2131241104, new Object[]{this.ax.m9107w()});
        String x = this.ax.m9108x();
        Parcelable bundle = new Bundle();
        bundle.putString("oauth_url", p);
        bundle.putString("fragment_title", string);
        bundle.putString("dismiss_url", x);
        this.f9011b.a(BusinessActivity.m8889a(context, "BusinessOauthFragment", bundle), 2, this);
    }

    public static void m9269a(BusinessSignUpFragment businessSignUpFragment, String str) {
        NativeSignUpLogger nativeSignUpLogger = businessSignUpFragment.f9014e;
        nativeSignUpLogger.m9161b(str, "BusinessSignUpFragment");
        nativeSignUpLogger.f8875a.b(FunnelRegistry.p);
        businessSignUpFragment.al = false;
    }

    private void at() {
        for (BusinessNativeSignUpResultHandler businessNativeSignUpResultHandler : this.f9013d) {
            if (this.f9018i.f8885b.equals(businessNativeSignUpResultHandler.mo321a()) && businessNativeSignUpResultHandler.mo322a(this.f9018i)) {
                return;
            }
        }
    }

    public static boolean m9273b(@Nullable BusinessSignUpFragment businessSignUpFragment, String str) {
        if (!Strings.isNullOrEmpty(str)) {
            AppInfo appInfo = businessSignUpFragment.f9016g;
            if (AppInfoCore.f(str) ? appInfo.c(str) : appInfo.e(str)) {
                return true;
            }
        }
        return false;
    }
}

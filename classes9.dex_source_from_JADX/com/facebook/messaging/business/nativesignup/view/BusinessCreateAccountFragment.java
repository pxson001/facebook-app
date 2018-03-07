package com.facebook.messaging.business.nativesignup.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel.MessengerCommerceModel.NewUserSignupModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel;
import com.facebook.messaging.business.nativesignup.loaders.SignUpQueryLoader;
import com.facebook.messaging.business.nativesignup.loaders.SignUpQueryLoader.Callback;
import com.facebook.messaging.business.nativesignup.logging.NativeSignUpLogger;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.nativesignup.protocol.methods.ProxyLoginMethod.Params;
import com.facebook.messaging.business.nativesignup.protocol.methods.ThirdPartyRegistrationMethod;
import com.facebook.messaging.business.nativesignup.view.model.NativeSignUpRowViewParams;
import com.facebook.messaging.business.nativesignup.view.model.NativeSignUpRowViewParamsBuilder;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.method.verification.PaymentMethodVerificationController;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueHelper;
import com.facebook.messaging.payment.value.input.EnterPaymentValueHelper.C17793;
import com.facebook.messaging.payment.value.input.EnterPaymentValueHelperProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.User;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONObject;

/* compiled from: msite */
public final class BusinessCreateAccountFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    @ViewerContextUser
    Provider<User> f8963a;
    private NativeSignUpRowView aA;
    private NativeSignUpRowView aB;
    private NativeSignUpRowView aC;
    public NativeSignUpRowView aD;
    public NativeSignUpRowView aE;
    private BetterTextView aF;
    private LinearLayout aG;
    private ProgressBar aH;
    public CheckBox aI;
    public BetterButton aJ;
    private BlueServiceFragment aK;
    public ImageView aL;
    @Inject
    GatekeeperStoreImpl al;
    private final AbstractFbActivityListener am = new C10221(this);
    public EnterPaymentValueHelper an;
    public ImmutableList<PaymentCard> ao = RegularImmutableList.a;
    @Nullable
    public PaymentCard ap;
    @Nullable
    public PhoneNumberInfoModel aq;
    @Nullable
    public NewUserSignupModel ar;
    @Nullable
    public String as;
    public NativeSignUpParams at;
    private boolean au;
    private boolean av;
    public boolean aw;
    private FbDraweeView ax;
    private FbDraweeView ay;
    private BetterTextView az;
    @Inject
    Lazy<LinkHandlingHelper> f8964b;
    @Inject
    public SignUpQueryLoader f8965c;
    @Inject
    BetterLinkMovementMethod f8966d;
    @Inject
    EnterPaymentValueHelperProvider f8967e;
    @Inject
    SecureContextHelper f8968f;
    @Inject
    BusinessMessageDialogHelper f8969g;
    @Inject
    public AbstractFbErrorReporter f8970h;
    @Inject
    NativeSignUpLogger f8971i;

    /* compiled from: msite */
    class C10221 extends AbstractFbActivityListener {
        final /* synthetic */ BusinessCreateAccountFragment f8949a;

        C10221(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8949a = businessCreateAccountFragment;
        }

        public final boolean m9193i(Activity activity) {
            if (this.f8949a.aw) {
                return false;
            }
            this.f8949a.aw = true;
            BusinessCreateAccountFragment businessCreateAccountFragment = this.f8949a;
            new FbAlertDialogBuilder(businessCreateAccountFragment.getContext()).a(2131241115).b(2131241116).a(businessCreateAccountFragment.jW_().getString(2131241118), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8952a;

                {
                    this.f8952a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f8952a.aw = false;
                    dialogInterface.dismiss();
                }
            }).b(businessCreateAccountFragment.jW_().getString(2131230737), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8951a;

                {
                    this.f8951a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.f8951a.ao().onBackPressed();
                }
            }).b();
            return true;
        }
    }

    /* compiled from: msite */
    public class C10254 implements Callback {
        final /* synthetic */ BusinessCreateAccountFragment f8957a;

        public C10254(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8957a = businessCreateAccountFragment;
        }

        public final void mo327a(NewUserSignupModel newUserSignupModel) {
            BusinessCreateAccountFragment.m9207b(this.f8957a, false);
            this.f8957a.ar = newUserSignupModel;
            BusinessCreateAccountFragment.m9201a(this.f8957a, newUserSignupModel.m9110z());
            BusinessCreateAccountFragment.m9200a(this.f8957a, newUserSignupModel);
        }

        public final void mo326a() {
            BusinessCreateAccountFragment.m9207b(this.f8957a, false);
            this.f8957a.f8969g.m9019a();
        }
    }

    /* compiled from: msite */
    public class C10265 implements View.OnClickListener {
        final /* synthetic */ BusinessCreateAccountFragment f8958a;

        public C10265(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8958a = businessCreateAccountFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1582969853);
            if (this.f8958a.ap == null) {
                this.f8958a.f8971i.m9161b("click_payment_row", "add_card");
                EnterPaymentValueHelper.m15661c(this.f8958a.an, this.f8958a.ao);
            } else {
                this.f8958a.f8971i.m9161b("click_payment_row", "change_card");
                EnterPaymentValueHelper enterPaymentValueHelper = this.f8958a.an;
                ImmutableList immutableList = this.f8958a.ao;
                PaymentDialogsBuilder.m13297a(enterPaymentValueHelper.f15299h, PaymentDialogsBuilder.m13302a(enterPaymentValueHelper.f15299h, PaymentCardsFetcher.m13432c(immutableList)), enterPaymentValueHelper.f15300i.getString(2131240393), enterPaymentValueHelper.f15300i.getString(2131240397), null, new C17793(enterPaymentValueHelper, immutableList)).show();
            }
            LogUtils.a(-1893392137, a);
        }
    }

    /* compiled from: msite */
    public class C10276 {
        public final /* synthetic */ BusinessCreateAccountFragment f8959a;

        public C10276(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8959a = businessCreateAccountFragment;
        }
    }

    /* compiled from: msite */
    public class C10287 implements View.OnClickListener {
        final /* synthetic */ BusinessCreateAccountFragment f8960a;

        public C10287(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8960a = businessCreateAccountFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1214594478);
            this.f8960a.f8971i.m9159a("click_phone_row");
            BusinessCreateAccountFragment.aD(this.f8960a);
            Logger.a(2, EntryType.UI_INPUT_END, -303409242, a);
        }
    }

    /* compiled from: msite */
    class C10298 implements View.OnClickListener {
        final /* synthetic */ BusinessCreateAccountFragment f8961a;

        C10298(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8961a = businessCreateAccountFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1258389443);
            this.f8961a.f8971i.m9159a("click_email_row");
            BusinessCreateAccountFragment.aE(this.f8961a);
            Logger.a(2, EntryType.UI_INPUT_END, -528765703, a);
        }
    }

    /* compiled from: msite */
    public class C10309 implements View.OnClickListener {
        final /* synthetic */ BusinessCreateAccountFragment f8962a;

        public C10309(BusinessCreateAccountFragment businessCreateAccountFragment) {
            this.f8962a = businessCreateAccountFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1173567399);
            this.f8962a.f8971i.m9161b("click_term_checkbox", String.valueOf(this.f8962a.aI.isChecked()));
            Logger.a(2, EntryType.UI_INPUT_END, -1136527682, a);
        }
    }

    /* compiled from: msite */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessCreateAccountFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessCreateAccountFragment();
        }
    }

    public static void m9205a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BusinessCreateAccountFragment) obj).m9206a(IdBasedProvider.a(injectorLike, 3596), IdBasedSingletonScopeProvider.b(injectorLike, 7898), SignUpQueryLoader.m9154b(injectorLike), BetterLinkMovementMethod.a(injectorLike), (EnterPaymentValueHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EnterPaymentValueHelperProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NativeSignUpLogger.m9158b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void m9206a(Provider<User> provider, Lazy<LinkHandlingHelper> lazy, SignUpQueryLoader signUpQueryLoader, BetterLinkMovementMethod betterLinkMovementMethod, EnterPaymentValueHelperProvider enterPaymentValueHelperProvider, SecureContextHelper secureContextHelper, BusinessMessageDialogHelper businessMessageDialogHelper, FbErrorReporter fbErrorReporter, NativeSignUpLogger nativeSignUpLogger, GatekeeperStore gatekeeperStore) {
        this.f8963a = provider;
        this.f8964b = lazy;
        this.f8965c = signUpQueryLoader;
        this.f8966d = betterLinkMovementMethod;
        this.f8967e = enterPaymentValueHelperProvider;
        this.f8968f = secureContextHelper;
        this.f8969g = businessMessageDialogHelper;
        this.f8970h = fbErrorReporter;
        this.f8971i = nativeSignUpLogger;
        this.al = gatekeeperStore;
    }

    public final void m9219c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessCreateAccountFragment.class;
        m9205a((Object) this, getContext());
        InjectorLike injectorLike = this.f8967e;
        this.an = new EnterPaymentValueHelper(this, true, (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentCardsFetcher.m13429a(injectorLike), PaymentDialogsBuilder.m13301a(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), PaymentMethodVerificationController.m13449b(injectorLike));
        aw();
    }

    public final String mo309a(Context context) {
        return "";
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void m9220e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("native_signup_params", this.at);
        if (this.ar != null) {
            FlatBufferModelHelper.a(bundle, "new_user_signup", this.ar);
        }
        if (this.aq != null) {
            FlatBufferModelHelper.a(bundle, "last_confirmed_number", this.aq);
        }
        if (this.ap != null) {
            bundle.putParcelable("last_selected_card", this.ap);
        }
        bundle.putString("last_updated_email", this.as);
    }

    public final void mo310a(Parcelable parcelable) {
        this.at = (NativeSignUpParams) ((Bundle) parcelable).getParcelable("native_signup_params");
    }

    public final View m9213a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1360961540);
        View inflate = layoutInflater.inflate(2130903463, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1797933046, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1958956658);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1887888468, a);
    }

    public final void m9217a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ax = (FbDraweeView) e(2131564051);
        this.ay = (FbDraweeView) e(2131564050);
        this.az = (BetterTextView) e(2131560081);
        this.aA = (NativeSignUpRowView) e(2131560082);
        this.aB = (NativeSignUpRowView) e(2131560083);
        this.aC = (NativeSignUpRowView) e(2131560085);
        this.aD = (NativeSignUpRowView) e(2131560086);
        this.aE = (NativeSignUpRowView) e(2131560084);
        this.aF = (BetterTextView) e(2131560088);
        this.aG = (LinearLayout) e(2131560080);
        this.aH = (ProgressBar) e(2131560090);
        this.aI = (CheckBox) e(2131560087);
        this.aJ = (BetterButton) e(2131560089);
        this.aL = (ImageView) e(2131560079);
        this.an.f15293b = new C10276(this);
        m9204a(this, true);
        this.an.m15662a();
        this.aE.setOnClickListener(new C10265(this));
        this.ax.a(Uri.parse(((User) this.f8963a.get()).x()), CallerContext.a(BusinessCreateAccountFragment.class));
        this.aI.setOnClickListener(new C10309(this));
        au();
        this.aL.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BusinessCreateAccountFragment f8941a;

            {
                this.f8941a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1076522689);
                this.f8941a.ao().onBackPressed();
                Logger.a(2, EntryType.UI_INPUT_END, 1281561635, a);
            }
        });
        if (bundle != null) {
            this.ar = (NewUserSignupModel) FlatBufferModelHelper.a(bundle, "new_user_signup");
            this.aq = (PhoneNumberInfoModel) FlatBufferModelHelper.a(bundle, "last_confirmed_number");
            this.ap = (PaymentCard) bundle.getParcelable("last_selected_card");
            this.as = bundle.getString("last_updated_email");
        }
        m9202a(this, this.ap);
        m9201a(this, this.aq);
        if (this.ar == null) {
            m9207b(this, true);
            this.f8965c.m9156a(this.at, new C10254(this));
            return;
        }
        m9200a(this, this.ar);
    }

    public final void m9215a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        EnterPaymentValueHelper enterPaymentValueHelper = this.an;
        switch (i) {
            case 1000:
                enterPaymentValueHelper.f15301j.m13454a(i, i2, intent);
                break;
        }
        if (i == 1 && i2 == -1) {
            PhoneNumberInfoModel phoneNumberInfoModel = (PhoneNumberInfoModel) FlatBufferModelHelper.a(intent, "confirmed_phone_number");
            if (phoneNumberInfoModel != null) {
                m9201a(this, phoneNumberInfoModel);
            } else {
                this.f8969g.m9019a();
            }
        } else if (i == 2 && i2 == -1) {
            this.f8971i.m9159a("success_update_email");
            m9208b(intent.getStringExtra("updated_email"));
        }
    }

    public final void m9211G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 593514175);
        super.G();
        if (ao() instanceof FbFragmentActivity) {
            ((FbFragmentActivity) ao()).a(this.am);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1722464887, a);
    }

    public final void m9212H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -447212265);
        super.H();
        if (ao() instanceof FbFragmentActivity) {
            ((FbFragmentActivity) ao()).b(this.am);
        }
        this.f8965c.m9155a();
        EnterPaymentValueHelper enterPaymentValueHelper = this.an;
        if (enterPaymentValueHelper.f15303l != null) {
            enterPaymentValueHelper.f15303l.cancel(true);
            enterPaymentValueHelper.f15303l = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -625342933, a);
    }

    public static void m9203a(BusinessCreateAccountFragment businessCreateAccountFragment, String str) {
        ((LinkHandlingHelper) businessCreateAccountFragment.f8964b.get()).a(businessCreateAccountFragment.getContext(), Uri.parse(str));
    }

    public static void m9200a(BusinessCreateAccountFragment businessCreateAccountFragment, final NewUserSignupModel newUserSignupModel) {
        businessCreateAccountFragment.aJ.setOnClickListener(new View.OnClickListener(businessCreateAccountFragment) {
            final /* synthetic */ BusinessCreateAccountFragment f8940b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1506439057);
                BusinessCreateAccountFragment businessCreateAccountFragment = this.f8940b;
                Object obj = 1;
                Object obj2;
                if (newUserSignupModel.m9091c()) {
                    obj2 = 1;
                } else if (businessCreateAccountFragment.ap != null) {
                    int i = 1;
                } else {
                    obj2 = null;
                }
                if (!businessCreateAccountFragment.aI.isChecked() || r3 == null || businessCreateAccountFragment.aq == null || Strings.isNullOrEmpty(businessCreateAccountFragment.as)) {
                    obj = null;
                }
                if (obj != null) {
                    this.f8940b.f8971i.m9159a("click_create_account_button");
                    BusinessCreateAccountFragment.m9209d(this.f8940b, newUserSignupModel);
                } else {
                    BusinessCreateAccountFragment.ax(this.f8940b);
                }
                LogUtils.a(-1793387439, a);
            }
        });
        businessCreateAccountFragment.az.setText(newUserSignupModel.lU_());
        if (newUserSignupModel.m9098n().contains("public_profile")) {
            NativeSignUpRowView nativeSignUpRowView = businessCreateAccountFragment.aA;
            NativeSignUpRowViewParamsBuilder newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9027b = newUserSignupModel.m9095k();
            NativeSignUpRowViewParamsBuilder nativeSignUpRowViewParamsBuilder = newBuilder;
            nativeSignUpRowViewParamsBuilder.f9028c = (CharSequence) newUserSignupModel.m9096l().get(0);
            nativeSignUpRowView.setViewParams(nativeSignUpRowViewParamsBuilder.m9287d());
        } else {
            businessCreateAccountFragment.aA.setVisibility(8);
        }
        if (newUserSignupModel.m9098n().contains("user_friends")) {
            nativeSignUpRowView = businessCreateAccountFragment.aB;
            newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9027b = newUserSignupModel.m9093g();
            nativeSignUpRowViewParamsBuilder = newBuilder;
            nativeSignUpRowViewParamsBuilder.f9028c = (CharSequence) newUserSignupModel.lT_().get(0);
            nativeSignUpRowView.setViewParams(nativeSignUpRowViewParamsBuilder.m9287d());
        } else {
            businessCreateAccountFragment.aB.setVisibility(8);
        }
        if (!newUserSignupModel.m9098n().contains("user_payment_tokens") || newUserSignupModel.m9091c()) {
            businessCreateAccountFragment.aE.setVisibility(8);
        }
        if (newUserSignupModel.m9098n().contains("email")) {
            businessCreateAccountFragment.m9208b(newUserSignupModel.lS_().isEmpty() ? null : (String) newUserSignupModel.lS_().get(0));
        } else {
            businessCreateAccountFragment.aC.setVisibility(8);
        }
        if (!newUserSignupModel.m9098n().contains("user_mobile_phone")) {
            businessCreateAccountFragment.aD.setVisibility(8);
        }
        businessCreateAccountFragment.aF.setMovementMethod(businessCreateAccountFragment.f8966d);
        BetterTextView betterTextView = businessCreateAccountFragment.aF;
        CharSequence w = newUserSignupModel.m9107w();
        final String y = newUserSignupModel.m9109y();
        final String m = newUserSignupModel.m9097m();
        betterTextView.setText(new StyledStringBuilder(businessCreateAccountFragment.jW_()).a(2131241080).a("%1$s", w).a("%2$s", businessCreateAccountFragment.jW_().getString(2131241081), new ClickableSpan(businessCreateAccountFragment) {
            final /* synthetic */ BusinessCreateAccountFragment f8954b;

            public void onClick(View view) {
                BusinessCreateAccountFragment.m9203a(this.f8954b, y);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f8954b.jW_().getColor(2131363294));
                textPaint.setUnderlineText(false);
            }
        }, 33).a("%3$s", businessCreateAccountFragment.jW_().getString(2131241082), new ClickableSpan(businessCreateAccountFragment) {
            final /* synthetic */ BusinessCreateAccountFragment f8956b;

            public void onClick(View view) {
                BusinessCreateAccountFragment.m9203a(this.f8956b, m);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f8956b.jW_().getColor(2131363294));
                textPaint.setUnderlineText(false);
            }
        }, 33).b());
        if (newUserSignupModel.m9092d() != null) {
            businessCreateAccountFragment.ay.a(Uri.parse(newUserSignupModel.m9092d().m9063a()), CallerContext.a(BusinessCreateAccountFragment.class));
        }
        businessCreateAccountFragment.ar();
    }

    public static void m9202a(@Nullable BusinessCreateAccountFragment businessCreateAccountFragment, PaymentCard paymentCard) {
        businessCreateAccountFragment.ap = paymentCard;
        businessCreateAccountFragment.ar();
    }

    private void ar() {
        if (this.ap == null || this.ar == null || this.ar.m9094j() == null || this.ar.m9094j().isEmpty()) {
            NativeSignUpRowView nativeSignUpRowView = this.aE;
            NativeSignUpRowViewParamsBuilder newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9026a = jW_().getString(2131241088);
            nativeSignUpRowView.setViewParams(newBuilder.m9287d());
            return;
        }
        StyledStringBuilder a = new StyledStringBuilder(jW_()).a("%1$s %2$s\n%3$s").a("%1$s", PaymentViewUtil.m15541a(getContext(), this.ap)).a("%2$s", jW_().getString(2131241106), new ForegroundColorSpan(jW_().getColor(2131363294)), 33).a("%3$s", (CharSequence) this.ar.m9094j().get(0));
        NativeSignUpRowView nativeSignUpRowView2 = this.aE;
        NativeSignUpRowViewParamsBuilder newBuilder2 = NativeSignUpRowViewParams.newBuilder();
        newBuilder2.f9027b = jW_().getString(2131241089);
        newBuilder2 = newBuilder2;
        newBuilder2.f9028c = a.b();
        nativeSignUpRowView2.setViewParams(newBuilder2.m9287d());
    }

    public static void m9204a(BusinessCreateAccountFragment businessCreateAccountFragment, boolean z) {
        businessCreateAccountFragment.au = z;
        businessCreateAccountFragment.as();
    }

    public static void m9207b(BusinessCreateAccountFragment businessCreateAccountFragment, boolean z) {
        businessCreateAccountFragment.av = z;
        businessCreateAccountFragment.as();
    }

    private void as() {
        if (this.au || this.av) {
            this.aG.setVisibility(4);
            this.aH.setVisibility(0);
            return;
        }
        this.aG.setVisibility(0);
        this.aH.setVisibility(4);
    }

    public static void m9201a(@Nullable BusinessCreateAccountFragment businessCreateAccountFragment, PhoneNumberInfoModel phoneNumberInfoModel) {
        businessCreateAccountFragment.aq = phoneNumberInfoModel;
        NativeSignUpRowView nativeSignUpRowView;
        NativeSignUpRowViewParamsBuilder newBuilder;
        if (businessCreateAccountFragment.aq == null) {
            nativeSignUpRowView = businessCreateAccountFragment.aD;
            newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9026a = businessCreateAccountFragment.jW_().getString(2131241084);
            nativeSignUpRowView.setViewParams(newBuilder.m9287d());
        } else {
            nativeSignUpRowView = businessCreateAccountFragment.aD;
            newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9027b = businessCreateAccountFragment.jW_().getString(2131241085);
            newBuilder = newBuilder;
            newBuilder.f9028c = businessCreateAccountFragment.aq.m9128a();
            nativeSignUpRowView.setViewParams(newBuilder.m9287d());
        }
        businessCreateAccountFragment.aD.setOnClickListener(new C10287(businessCreateAccountFragment));
    }

    private void m9208b(@Nullable String str) {
        if (aF()) {
            boolean z;
            if (Strings.isNullOrEmpty(str)) {
                z = false;
            } else {
                z = Patterns.EMAIL_ADDRESS.matcher(str).find();
            }
            if (!z) {
                str = null;
            }
        }
        this.as = str;
        if (this.as == null) {
            NativeSignUpRowView nativeSignUpRowView = this.aC;
            NativeSignUpRowViewParamsBuilder newBuilder = NativeSignUpRowViewParams.newBuilder();
            newBuilder.f9026a = jW_().getString(2131241086);
            nativeSignUpRowView.setViewParams(newBuilder.m9287d());
            return;
        }
        nativeSignUpRowView = this.aC;
        newBuilder = NativeSignUpRowViewParams.newBuilder();
        newBuilder.f9027b = jW_().getString(2131241087);
        newBuilder = newBuilder;
        newBuilder.f9028c = this.as;
        nativeSignUpRowView.setViewParams(newBuilder.m9287d());
    }

    private void au() {
        if (aF()) {
            this.aC.setOnClickListener(new C10298(this));
        }
    }

    private void aw() {
        this.aK = BlueServiceFragment.a(o(), "create_account");
        this.aK.b = new OnCompletedListener(this) {
            final /* synthetic */ BusinessCreateAccountFragment f8938a;

            {
                this.f8938a = r1;
            }

            public final void m9191a(OperationResult operationResult) {
                operationResult.toString();
                this.f8938a.f8971i.m9159a("success_create_account");
                Intent intent = new Intent();
                intent.putExtra("next_step", 1);
                this.f8938a.ao().setResult(-1, intent);
                this.f8938a.ao().finish();
            }

            public final void m9192a(ServiceException serviceException) {
                serviceException.toString();
                this.f8938a.f8970h.a("BusinessCreateAccountFragment", "Failed creating account", serviceException);
                this.f8938a.f8971i.m9159a("error_create_account");
                BusinessCreateAccountFragment.m9199a(this.f8938a, serviceException);
            }
        };
        this.aK.a(new DialogBasedProgressIndicator(getContext(), 2131241101));
    }

    public static void ax(BusinessCreateAccountFragment businessCreateAccountFragment) {
        if (businessCreateAccountFragment.ap == null) {
            businessCreateAccountFragment.aE.m9286a();
        }
        if (businessCreateAccountFragment.aF() && Strings.isNullOrEmpty(businessCreateAccountFragment.as)) {
            businessCreateAccountFragment.aC.m9286a();
        }
        if (businessCreateAccountFragment.aq == null) {
            businessCreateAccountFragment.aD.m9286a();
        }
        if (businessCreateAccountFragment.ap == null) {
            new FbAlertDialogBuilder(businessCreateAccountFragment.getContext()).a(2131241109).b(2131241110).a(businessCreateAccountFragment.jW_().getString(2131241117), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8945a;

                {
                    this.f8945a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    EnterPaymentValueHelper.m15661c(this.f8945a.an, this.f8945a.ao);
                }
            }).b(businessCreateAccountFragment.jW_().getString(2131230727), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8944a;

                {
                    this.f8944a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).b();
        } else if (businessCreateAccountFragment.aq == null) {
            new FbAlertDialogBuilder(businessCreateAccountFragment.getContext()).a(2131241113).b(2131241114).a(businessCreateAccountFragment.jW_().getString(2131241117), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8947a;

                {
                    this.f8947a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    BusinessCreateAccountFragment.aD(this.f8947a);
                }
            }).b(businessCreateAccountFragment.jW_().getString(2131230727), new OnClickListener(businessCreateAccountFragment) {
                final /* synthetic */ BusinessCreateAccountFragment f8946a;

                {
                    this.f8946a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).b();
        } else if (businessCreateAccountFragment.aF() && Strings.isNullOrEmpty(businessCreateAccountFragment.as)) {
            businessCreateAccountFragment.m9210d(businessCreateAccountFragment.b(2131241112));
        }
    }

    public static void m9209d(BusinessCreateAccountFragment businessCreateAccountFragment, NewUserSignupModel newUserSignupModel) {
        if (newUserSignupModel == null || Strings.isNullOrEmpty(newUserSignupModel.m9101q()) || newUserSignupModel.m9098n() == null || businessCreateAccountFragment.aq == null || Strings.isNullOrEmpty(businessCreateAccountFragment.as) || (!newUserSignupModel.m9091c() && businessCreateAccountFragment.ap == null)) {
            businessCreateAccountFragment.f8970h.a("BusinessCreateAccountFragment", "missing required data when calling doCreateAccount()");
            return;
        }
        String str;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putParcelable("proxy_login_params", new Params(newUserSignupModel.m9101q(), StringUtil.b(",", new Object[]{newUserSignupModel.m9098n()})));
        if (newUserSignupModel.m9091c() || businessCreateAccountFragment.ap == null) {
            str = "";
        } else {
            str = String.valueOf(businessCreateAccountFragment.ap.f13202a);
        }
        String b = businessCreateAccountFragment.aq.m9129b();
        String str3 = businessCreateAccountFragment.as;
        if (Strings.isNullOrEmpty(businessCreateAccountFragment.at.f8890g)) {
            str2 = "";
        } else {
            str2 = businessCreateAccountFragment.at.f8890g;
        }
        bundle.putParcelable("third_party_registration_params", new ThirdPartyRegistrationMethod.Params(b, str, str3, "promo_data=" + str2));
        businessCreateAccountFragment.aK.a("create_account", bundle);
    }

    public static void m9199a(BusinessCreateAccountFragment businessCreateAccountFragment, ServiceException serviceException) {
        if (serviceException == null || serviceException.b() == null || serviceException.b().m() == null) {
            businessCreateAccountFragment.f8969g.m9019a();
            return;
        }
        ApiException apiException = (ApiException) ExceptionUtil.a(serviceException, ApiException.class);
        if (apiException != null) {
            businessCreateAccountFragment.m9198a(apiException.b().b(), apiException.d());
            return;
        }
        String string = serviceException.b().m().getString("originalExceptionMessage");
        if (string != null) {
            int indexOf = string.indexOf("\n");
            if (indexOf != -1) {
                try {
                    JSONObject jSONObject = new JSONObject(string.substring(indexOf + 1)).getJSONObject("error");
                    businessCreateAccountFragment.m9198a(jSONObject.getInt("error_subcode"), jSONObject.getString("error_user_msg"));
                    return;
                } catch (Exception e) {
                    businessCreateAccountFragment.f8969g.m9019a();
                    return;
                }
            }
        }
        businessCreateAccountFragment.f8969g.m9019a();
    }

    private void m9198a(int i, String str) {
        if (Strings.isNullOrEmpty(str)) {
            this.f8970h.a("BusinessCreateAccountFragment", "null error msg in CreateAccount response for subcode " + String.valueOf(i));
            this.f8969g.m9019a();
            return;
        }
        switch (i) {
            case 1349161:
            case 1349162:
            case 1349163:
            case 1349167:
                new FbAlertDialogBuilder(getContext()).b(str).a(jW_().getString(2131241105), new OnClickListener(this) {
                    final /* synthetic */ BusinessCreateAccountFragment f8943a;

                    {
                        this.f8943a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f8943a.f8971i.m9159a("click_log_in_dialog_log_in_button");
                        dialogInterface.dismiss();
                        Intent intent = new Intent();
                        intent.putExtra("next_step", 2);
                        this.f8943a.ao().setResult(-1, intent);
                        this.f8943a.ao().finish();
                    }
                }).b(jW_().getString(2131230727), new OnClickListener(this) {
                    final /* synthetic */ BusinessCreateAccountFragment f8942a;

                    {
                        this.f8942a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f8942a.f8971i.m9159a("click_log_in_dialog_cancel_button");
                        dialogInterface.dismiss();
                    }
                }).b();
                return;
            case 1349176:
                m9210d(str);
                return;
            default:
                this.f8969g.m9020a(str);
                return;
        }
    }

    private void m9210d(String str) {
        if (aF()) {
            new FbAlertDialogBuilder(getContext()).a(2131241111).b(str).a(jW_().getString(2131241117), new OnClickListener(this) {
                final /* synthetic */ BusinessCreateAccountFragment f8950a;

                {
                    this.f8950a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    BusinessCreateAccountFragment.aE(this.f8950a);
                }
            }).b(jW_().getString(2131230727), new OnClickListener(this) {
                final /* synthetic */ BusinessCreateAccountFragment f8948a;

                {
                    this.f8948a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).b();
        } else {
            this.f8969g.m9020a(str);
        }
    }

    public static void aD(BusinessCreateAccountFragment businessCreateAccountFragment) {
        businessCreateAccountFragment.f8968f.a(BusinessActivity.m8889a(businessCreateAccountFragment.getContext(), "BusinessRequestCodeFragment", null), 1, businessCreateAccountFragment);
    }

    public static void aE(BusinessCreateAccountFragment businessCreateAccountFragment) {
        businessCreateAccountFragment.f8968f.a(BusinessActivity.m8889a(businessCreateAccountFragment.getContext(), "BusinessEmailInputFragment", null), 2, businessCreateAccountFragment);
    }

    private boolean aF() {
        return this.al.a(172, false);
    }
}

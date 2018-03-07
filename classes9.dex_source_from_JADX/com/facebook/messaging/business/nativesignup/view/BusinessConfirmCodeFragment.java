package com.facebook.messaging.business.nativesignup.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ConfirmPhoneCodeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutations.NativeSignUpConfirmPhoneCodeMutationString;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpSendConfirmationMutationModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel;
import com.facebook.messaging.business.nativesignup.logging.NativeSignUpLogger;
import com.facebook.messaging.business.nativesignup.mutators.ConfirmPhoneCodeMutator;
import com.facebook.messaging.business.nativesignup.mutators.ConfirmPhoneCodeMutator.C10111;
import com.facebook.messaging.business.nativesignup.mutators.SendConfirmationMutator;
import com.facebook.messaging.business.nativesignup.mutators.SendConfirmationMutator.Callback;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: msite_dialog_fragment_tag */
public final class BusinessConfirmCodeFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public ConfirmPhoneCodeMutator f8929a;
    public DialogBasedProgressIndicator al;
    public TextView am;
    public ImageView an;
    public PhoneNumberInfoModel ao;
    @Inject
    public SendConfirmationMutator f8930b;
    @Inject
    public BetterLinkMovementMethod f8931c;
    @Inject
    BusinessMessageDialogHelper f8932d;
    @Inject
    public NativeSignUpLogger f8933e;
    public final Pattern f8934f = Pattern.compile("\\d{6}");
    public EditText f8935g;
    public BetterButton f8936h;
    public DialogBasedProgressIndicator f8937i;

    /* compiled from: msite_dialog_fragment_tag */
    class C10151 implements Runnable {
        final /* synthetic */ BusinessConfirmCodeFragment f8921a;

        C10151(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8921a = businessConfirmCodeFragment;
        }

        public void run() {
            if (this.f8921a.f8935g.requestFocus()) {
                KeyboardUtils.b(this.f8921a.getContext(), this.f8921a.f8935g);
            }
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class C10162 implements TextWatcher {
        final /* synthetic */ BusinessConfirmCodeFragment f8922a;

        public C10162(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8922a = businessConfirmCodeFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f8922a.f8936h.setEnabled(this.f8922a.f8934f.matcher(charSequence).matches());
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class C10173 {
        public final /* synthetic */ BusinessConfirmCodeFragment f8923a;

        public C10173(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8923a = businessConfirmCodeFragment;
        }

        public final void m9175a() {
            BusinessConfirmCodeFragment.as(this.f8923a);
            this.f8923a.f8932d.m9020a(this.f8923a.b(2131241107));
            this.f8923a.f8933e.m9159a("error_verify_sms_code");
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class C10184 implements OnClickListener {
        final /* synthetic */ BusinessConfirmCodeFragment f8924a;

        public C10184(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8924a = businessConfirmCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -497337970);
            this.f8924a.f8933e.m9159a("click_confirm_code_button");
            BusinessConfirmCodeFragment businessConfirmCodeFragment = this.f8924a;
            if (businessConfirmCodeFragment.f8937i == null) {
                businessConfirmCodeFragment.f8937i = new DialogBasedProgressIndicator(businessConfirmCodeFragment.getContext(), 2131241099);
            }
            businessConfirmCodeFragment.f8937i.a();
            ConfirmPhoneCodeMutator confirmPhoneCodeMutator = this.f8924a.f8929a;
            String obj = this.f8924a.f8935g.getText().toString();
            if (confirmPhoneCodeMutator.f8896e == null) {
                GraphQlQueryString nativeSignUpConfirmPhoneCodeMutationString = new NativeSignUpConfirmPhoneCodeMutationString();
                ConfirmPhoneCodeInputData confirmPhoneCodeInputData = new ConfirmPhoneCodeInputData();
                confirmPhoneCodeInputData.a("confirmation_code", obj);
                nativeSignUpConfirmPhoneCodeMutationString.a("input", confirmPhoneCodeInputData);
                confirmPhoneCodeMutator.f8896e = confirmPhoneCodeMutator.f8893b.a(GraphQLRequest.a(nativeSignUpConfirmPhoneCodeMutationString));
                Futures.a(confirmPhoneCodeMutator.f8896e, new C10111(confirmPhoneCodeMutator), confirmPhoneCodeMutator.f8894c);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -268043307, a);
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class C10206 implements Callback {
        final /* synthetic */ BusinessConfirmCodeFragment f8927a;

        public C10206(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8927a = businessConfirmCodeFragment;
        }

        public final void mo325a(@Nullable NativeSignUpSendConfirmationMutationModel nativeSignUpSendConfirmationMutationModel) {
            BusinessConfirmCodeFragment.aw(this.f8927a);
            this.f8927a.f8933e.m9159a("success_resend_sms_code");
        }

        public final void mo324a() {
            BusinessConfirmCodeFragment.aw(this.f8927a);
            this.f8927a.f8932d.m9019a();
            this.f8927a.f8933e.m9159a("error_resend_sms_code");
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class C10217 implements OnClickListener {
        final /* synthetic */ BusinessConfirmCodeFragment f8928a;

        public C10217(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
            this.f8928a = businessConfirmCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1268305525);
            this.f8928a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -823937841, a);
        }
    }

    /* compiled from: msite_dialog_fragment_tag */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessConfirmCodeFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessConfirmCodeFragment();
        }
    }

    public static void m9182a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BusinessConfirmCodeFragment) obj).m9181a(new ConfirmPhoneCodeMutator((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class)), SendConfirmationMutator.m9165b(injectorLike), BetterLinkMovementMethod.a(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), NativeSignUpLogger.m9158b(injectorLike));
    }

    private void m9181a(ConfirmPhoneCodeMutator confirmPhoneCodeMutator, SendConfirmationMutator sendConfirmationMutator, BetterLinkMovementMethod betterLinkMovementMethod, BusinessMessageDialogHelper businessMessageDialogHelper, NativeSignUpLogger nativeSignUpLogger) {
        this.f8929a = confirmPhoneCodeMutator;
        this.f8930b = sendConfirmationMutator;
        this.f8931c = betterLinkMovementMethod;
        this.f8932d = businessMessageDialogHelper;
        this.f8933e = nativeSignUpLogger;
    }

    public final void m9190c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessConfirmCodeFragment.class;
        m9182a((Object) this, getContext());
    }

    public final String mo309a(Context context) {
        return "";
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void mo310a(Parcelable parcelable) {
        this.ao = (PhoneNumberInfoModel) FlatBufferModelHelper.a((Bundle) parcelable, "phone_number_to_confirm");
    }

    public final void m9183G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1068414947);
        super.G();
        this.f8935g.postDelayed(new C10151(this), 200);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 268265136, a);
    }

    public final void m9184H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1369371846);
        super.H();
        this.f8930b.m9166a();
        ConfirmPhoneCodeMutator confirmPhoneCodeMutator = this.f8929a;
        if (confirmPhoneCodeMutator.f8896e != null) {
            confirmPhoneCodeMutator.f8896e.cancel(true);
            confirmPhoneCodeMutator.f8896e = null;
        }
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1473323321, a);
    }

    public final View m9185a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -994021401);
        View inflate = layoutInflater.inflate(2130903462, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1136116429, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1396783080);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -798696565, a);
    }

    public final void m9188a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8935g = (EditText) e(2131560077);
        this.f8936h = (BetterButton) e(2131560078);
        this.am = (TextView) e(2131560076);
        this.an = (ImageView) e(2131560079);
        this.f8935g.addTextChangedListener(new C10162(this));
        this.f8936h.setOnClickListener(new C10184(this));
        this.f8929a.f8897f = new C10173(this);
        this.f8930b.f8903e = new C10206(this);
        final int color = jW_().getColor(2131363294);
        C10195 c10195 = new ClickableSpan(this) {
            final /* synthetic */ BusinessConfirmCodeFragment f8926b;

            public void onClick(View view) {
                this.f8926b.f8933e.m9159a("click_resend_code_button");
                BusinessConfirmCodeFragment businessConfirmCodeFragment = this.f8926b;
                if (businessConfirmCodeFragment.al == null) {
                    businessConfirmCodeFragment.al = new DialogBasedProgressIndicator(businessConfirmCodeFragment.getContext(), 2131241100);
                }
                businessConfirmCodeFragment.al.a();
                this.f8926b.f8930b.m9167a(this.f8926b.ao.m9129b());
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(color);
            }
        };
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(jW_());
        styledStringBuilder.a(2131241102);
        styledStringBuilder.a("[[phone_number]]", this.ao.m9128a(), 33, new Object[0]);
        styledStringBuilder.a("[[resend_code_link]]", b(2131241103), c10195, 33);
        this.am.setMovementMethod(this.f8931c);
        this.am.setText(styledStringBuilder.b());
        this.an.setOnClickListener(new C10217(this));
    }

    public static Intent m9180a(Context context, PhoneNumberInfoModel phoneNumberInfoModel) {
        Parcelable bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "phone_number_to_confirm", phoneNumberInfoModel);
        return BusinessActivity.m8889a(context, "BusinessConfirmCodeFragment", bundle);
    }

    public static void as(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
        if (businessConfirmCodeFragment.f8937i != null) {
            businessConfirmCodeFragment.f8937i.b();
        }
    }

    public static void aw(BusinessConfirmCodeFragment businessConfirmCodeFragment) {
        if (businessConfirmCodeFragment.al != null) {
            businessConfirmCodeFragment.al.b();
        }
    }
}

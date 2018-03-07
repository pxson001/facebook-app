package com.facebook.messaging.business.nativesignup.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLSendConfirmationCodeOutcome;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpSendConfirmationMutationModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel.Builder;
import com.facebook.messaging.business.nativesignup.logging.NativeSignUpLogger;
import com.facebook.messaging.business.nativesignup.mutators.SendConfirmationMutator;
import com.facebook.messaging.business.nativesignup.mutators.SendConfirmationMutator.Callback;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.countryselector.CountrySelector;
import com.facebook.widget.countryselector.CountrySelector.OnCountrySelectListener;
import com.facebook.widget.countryselector.CountrySelectorProvider;
import com.facebook.widget.countryspinner.CountryCode;
import com.facebook.widget.text.BetterButton;
import java.nio.ByteBuffer;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: msg_send_click */
public final class BusinessRequestCodeFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    CountrySelectorProvider f8994a;
    public BetterButton al;
    private PhoneNumberFormattingTextWatcher am;
    public DialogBasedProgressIndicator an;
    public ImageView ao;
    public String ap = Locale.US.getCountry();
    @Inject
    public SendConfirmationMutator f8995b;
    @Inject
    PhoneNumberUtil f8996c;
    @Inject
    SecureContextHelper f8997d;
    @Inject
    BusinessMessageDialogHelper f8998e;
    @Inject
    NativeSignUpLogger f8999f;
    public CountrySelector f9000g;
    public EditText f9001h;
    public TextView f9002i;

    /* compiled from: msg_send_click */
    class C10361 implements Runnable {
        final /* synthetic */ BusinessRequestCodeFragment f8987a;

        C10361(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8987a = businessRequestCodeFragment;
        }

        public void run() {
            if (this.f8987a.f9001h.requestFocus()) {
                KeyboardUtils.b(this.f8987a.getContext(), this.f8987a.f9001h);
            }
        }
    }

    /* compiled from: msg_send_click */
    public class C10382 implements OnClickListener {
        final /* synthetic */ BusinessRequestCodeFragment f8989a;

        /* compiled from: msg_send_click */
        class C10371 implements OnCountrySelectListener {
            final /* synthetic */ C10382 f8988a;

            C10371(C10382 c10382) {
                this.f8988a = c10382;
            }

            public final void m9244a(CountryCode countryCode) {
                BusinessRequestCodeFragment.m9250a(this.f8988a.f8989a, countryCode.f3547a);
            }
        }

        public C10382(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8989a = businessRequestCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -80361652);
            KeyboardUtils.a(this.f8989a.getContext(), this.f8989a.T);
            if (this.f8989a.f9000g == null) {
                this.f8989a.f9000g = this.f8989a.f8994a.m3342a(this.f8989a.getContext(), true);
            }
            this.f8989a.f9000g.f3545u = new C10371(this);
            this.f8989a.f9000g.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, -139317189, a);
        }
    }

    /* compiled from: msg_send_click */
    public class C10393 implements TextWatcher {
        final /* synthetic */ BusinessRequestCodeFragment f8990a;

        public C10393(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8990a = businessRequestCodeFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f8990a.al.setEnabled(charSequence.length() > 0);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: msg_send_click */
    public class C10404 implements Callback {
        final /* synthetic */ BusinessRequestCodeFragment f8991a;

        public C10404(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8991a = businessRequestCodeFragment;
        }

        public final void mo325a(@Nullable NativeSignUpSendConfirmationMutationModel nativeSignUpSendConfirmationMutationModel) {
            BusinessRequestCodeFragment.ay(this.f8991a);
            if (nativeSignUpSendConfirmationMutationModel == null || nativeSignUpSendConfirmationMutationModel.m9052j() == null) {
                this.f8991a.f8998e.m9019a();
                return;
            }
            GraphQLSendConfirmationCodeOutcome j = nativeSignUpSendConfirmationMutationModel.m9052j();
            Builder builder = new Builder();
            builder.f8859a = BusinessRequestCodeFragment.at(this.f8991a);
            builder = builder;
            builder.f8861c = BusinessRequestCodeFragment.au(this.f8991a);
            builder = builder;
            builder.f8860b = BusinessRequestCodeFragment.aw(this.f8991a);
            builder = builder;
            builder.f8862d = BusinessRequestCodeFragment.at(this.f8991a) + BusinessRequestCodeFragment.au(this.f8991a);
            builder = builder;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f8859a);
            int b2 = flatBufferBuilder.b(builder.f8860b);
            int b3 = flatBufferBuilder.b(builder.f8861c);
            int b4 = flatBufferBuilder.b(builder.f8862d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            PhoneNumberInfoModel phoneNumberInfoModel = new PhoneNumberInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            if (GraphQLSendConfirmationCodeOutcome.SUCCESS.equals(j)) {
                this.f8991a.f8997d.a(BusinessConfirmCodeFragment.m9180a(this.f8991a.getContext(), phoneNumberInfoModel), 1, this.f8991a);
            } else if (GraphQLSendConfirmationCodeOutcome.PHONE_NUMBER_ALREADY_VERIFIED.equals(j)) {
                BusinessRequestCodeFragment.m9249a(this.f8991a, phoneNumberInfoModel);
            } else {
                this.f8991a.f8998e.m9020a(nativeSignUpSendConfirmationMutationModel.m9051a());
            }
            this.f8991a.f8999f.m9161b("success_request_sms_code", j.name());
        }

        public final void mo324a() {
            BusinessRequestCodeFragment.ay(this.f8991a);
            this.f8991a.f8999f.m9159a("error_request_sms_code");
            this.f8991a.f8998e.m9019a();
        }
    }

    /* compiled from: msg_send_click */
    public class C10415 implements OnClickListener {
        final /* synthetic */ BusinessRequestCodeFragment f8992a;

        public C10415(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8992a = businessRequestCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -999013773);
            this.f8992a.f8999f.m9159a("click_request_code_button");
            BusinessRequestCodeFragment businessRequestCodeFragment = this.f8992a;
            if (businessRequestCodeFragment.an == null) {
                businessRequestCodeFragment.an = new DialogBasedProgressIndicator(businessRequestCodeFragment.getContext(), 2131241098);
            }
            businessRequestCodeFragment.an.a();
            SendConfirmationMutator sendConfirmationMutator = this.f8992a.f8995b;
            BusinessRequestCodeFragment businessRequestCodeFragment2 = this.f8992a;
            sendConfirmationMutator.m9167a(BusinessRequestCodeFragment.at(businessRequestCodeFragment2) + BusinessRequestCodeFragment.au(businessRequestCodeFragment2));
            Logger.a(2, EntryType.UI_INPUT_END, 564022472, a);
        }
    }

    /* compiled from: msg_send_click */
    public class C10426 implements OnClickListener {
        final /* synthetic */ BusinessRequestCodeFragment f8993a;

        public C10426(BusinessRequestCodeFragment businessRequestCodeFragment) {
            this.f8993a = businessRequestCodeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 645716855);
            this.f8993a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1770986981, a);
        }
    }

    /* compiled from: msg_send_click */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessRequestCodeFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessRequestCodeFragment();
        }
    }

    public static void m9252a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BusinessRequestCodeFragment) obj).m9251a((CountrySelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CountrySelectorProvider.class), SendConfirmationMutator.m9165b(injectorLike), PhoneNumberUtilMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), BusinessMessageDialogHelper.m9018b(injectorLike), NativeSignUpLogger.m9158b(injectorLike));
    }

    private void m9251a(CountrySelectorProvider countrySelectorProvider, SendConfirmationMutator sendConfirmationMutator, PhoneNumberUtil phoneNumberUtil, SecureContextHelper secureContextHelper, BusinessMessageDialogHelper businessMessageDialogHelper, NativeSignUpLogger nativeSignUpLogger) {
        this.f8994a = countrySelectorProvider;
        this.f8995b = sendConfirmationMutator;
        this.f8996c = phoneNumberUtil;
        this.f8997d = secureContextHelper;
        this.f8998e = businessMessageDialogHelper;
        this.f8999f = nativeSignUpLogger;
    }

    public final void m9261c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessRequestCodeFragment.class;
        m9252a((Object) this, getContext());
    }

    public final String mo309a(Context context) {
        return "";
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void mo310a(Parcelable parcelable) {
    }

    public final void m9253G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1363161661);
        super.G();
        this.f9001h.postDelayed(new C10361(this), 200);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1000258809, a);
    }

    public final void m9254H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1535188773);
        super.H();
        this.f8995b.m9166a();
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1722946686, a);
    }

    public final View m9255a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1250682728);
        View inflate = layoutInflater.inflate(2130903472, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1472704855, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1609875840);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 602701030, a);
    }

    public final void m9259a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f9001h = (EditText) e(2131560111);
        this.f9002i = (TextView) e(2131560110);
        this.al = (BetterButton) e(2131560112);
        this.ao = (ImageView) e(2131560079);
        this.f9001h.addTextChangedListener(new C10393(this));
        m9250a(this, this.ap);
        this.f9002i.setOnClickListener(new C10382(this));
        this.f8995b.f8903e = new C10404(this);
        this.al.setOnClickListener(new C10415(this));
        this.ao.setOnClickListener(new C10426(this));
    }

    public final void m9257a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1 && i2 == -1) {
            m9249a(this, (PhoneNumberInfoModel) FlatBufferModelHelper.a(intent, "confirmed_phone_number"));
        }
    }

    public static void m9250a(BusinessRequestCodeFragment businessRequestCodeFragment, String str) {
        businessRequestCodeFragment.ap = str;
        businessRequestCodeFragment.f9002i.setText(businessRequestCodeFragment.ap);
        businessRequestCodeFragment.f9001h.removeTextChangedListener(businessRequestCodeFragment.am);
        businessRequestCodeFragment.am = new PhoneNumberFormattingTextWatcher(businessRequestCodeFragment.ap, businessRequestCodeFragment.getContext().getApplicationContext());
        businessRequestCodeFragment.f9001h.addTextChangedListener(businessRequestCodeFragment.am);
        businessRequestCodeFragment.f9001h.setText(businessRequestCodeFragment.f9001h.getText());
    }

    public static String at(BusinessRequestCodeFragment businessRequestCodeFragment) {
        return String.valueOf(businessRequestCodeFragment.f8996c.getCountryCodeForRegion(businessRequestCodeFragment.ap));
    }

    public static String au(BusinessRequestCodeFragment businessRequestCodeFragment) {
        return PhoneNumberUtil.normalizeDigitsOnly(aw(businessRequestCodeFragment));
    }

    public static String aw(BusinessRequestCodeFragment businessRequestCodeFragment) {
        return businessRequestCodeFragment.f9001h.getText().toString();
    }

    public static void m9249a(BusinessRequestCodeFragment businessRequestCodeFragment, PhoneNumberInfoModel phoneNumberInfoModel) {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "confirmed_phone_number", phoneNumberInfoModel);
        businessRequestCodeFragment.ao().setResult(-1, intent);
        businessRequestCodeFragment.ao().finish();
    }

    public static void ay(BusinessRequestCodeFragment businessRequestCodeFragment) {
        if (businessRequestCodeFragment.an != null) {
            businessRequestCodeFragment.an.b();
        }
    }
}

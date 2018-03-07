package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPinStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPinStatusModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPinStatusModel.ProtectedThreadProfilesModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPinStatusModel.UnprotectedThreadProfilesModel;
import com.facebook.messaging.payment.pin.PaymentPinRequireActivity;
import com.facebook.messaging.payment.pin.PaymentPinRequireActivity.LaunchMode;
import com.facebook.messaging.payment.pin.params.PaymentPinProtectionsParams;
import com.facebook.messaging.payment.pin.params.PaymentPinProtectionsParamsBuilder;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity.C15621;
import com.facebook.widget.fbpreferencefragment.FbPreferenceFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_commerce_product_item */
public class ProtectConversationsPayPreferences extends FbPreferenceFragment implements MessengerPayPreferences<PaymentPinStatus> {
    @Inject
    public PaymentPinProtocolUtil f13849a;
    @Inject
    public SecureContextHelper f13850b;
    @Inject
    @ForUiThread
    public Executor f13851c;
    @Inject
    public GatekeeperStoreImpl f13852d;
    private C15621 f13853e;
    private PreferenceCategory f13854f;
    public ListenableFuture<PaymentPinStatus> f13855g;
    private ProtectConversationPayPreference f13856h;

    /* compiled from: group_commerce_product_item */
    class C15671 implements FutureCallback<PaymentPinStatus> {
        final /* synthetic */ ProtectConversationsPayPreferences f13847a;

        C15671(ProtectConversationsPayPreferences protectConversationsPayPreferences) {
            this.f13847a = protectConversationsPayPreferences;
        }

        public void onSuccess(@Nullable Object obj) {
            ProtectConversationsPayPreferences.m14394a(this.f13847a, (PaymentPinStatusModel) obj);
        }

        public void onFailure(Throwable th) {
            ProtectConversationsPayPreferences.m14394a(this.f13847a, null);
        }
    }

    /* compiled from: group_commerce_product_item */
    class C15682 implements OnPreferenceClickListener {
        final /* synthetic */ ProtectConversationsPayPreferences f13848a;

        C15682(ProtectConversationsPayPreferences protectConversationsPayPreferences) {
            this.f13848a = protectConversationsPayPreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            ProtectConversationsPayPreferences.m14393a(this.f13848a, preference);
            return true;
        }
    }

    public static void m14395a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ProtectConversationsPayPreferences protectConversationsPayPreferences = (ProtectConversationsPayPreferences) obj;
        PaymentPinProtocolUtil a = PaymentPinProtocolUtil.m14279a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        protectConversationsPayPreferences.f13849a = a;
        protectConversationsPayPreferences.f13850b = secureContextHelper;
        protectConversationsPayPreferences.f13851c = executor;
        protectConversationsPayPreferences.f13852d = a2;
    }

    public final void mo539a(C15621 c15621) {
        this.f13853e = c15621;
    }

    public final void mo542c(Bundle bundle) {
        super.mo542c(bundle);
        Class cls = ProtectConversationsPayPreferences.class;
        m14395a((Object) this, getContext());
        this.f13854f = new PreferenceCategory(ao());
        this.f13854f.setLayoutResource(2130906356);
        this.f13853e.m14374a(this.f13854f);
    }

    public final void mo540a(boolean z) {
    }

    public static void m14394a(@Nullable ProtectConversationsPayPreferences protectConversationsPayPreferences, PaymentPinStatusModel paymentPinStatusModel) {
        protectConversationsPayPreferences.f13854f.removeAll();
        protectConversationsPayPreferences.m14396b(paymentPinStatusModel);
    }

    private void m14396b(@Nullable PaymentPinStatusModel paymentPinStatusModel) {
        if (!this.f13852d.a(294, false) || paymentPinStatusModel == null || (paymentPinStatusModel.m13734b().isEmpty() && paymentPinStatusModel.m13735c().isEmpty())) {
            this.f13854f.setTitle(null);
            return;
        }
        int i;
        this.f13854f.setTitle(2131240303);
        ImmutableList b = paymentPinStatusModel.m13734b();
        int size = b.size();
        for (i = 0; i < size; i++) {
            this.f13854f.addPreference(m14392a(((ProtectedThreadProfilesModel) b.get(i)).m13718b(), true));
        }
        b = paymentPinStatusModel.m13735c();
        size = b.size();
        for (i = 0; i < size; i++) {
            this.f13854f.addPreference(m14392a(((UnprotectedThreadProfilesModel) b.get(i)).m13728b(), false));
        }
    }

    private ProtectConversationPayPreference m14392a(String str, boolean z) {
        ProtectConversationPayPreference protectConversationPayPreference = new ProtectConversationPayPreference(getContext(), str, z);
        protectConversationPayPreference.setOnPreferenceClickListener(new C15682(this));
        return protectConversationPayPreference;
    }

    public static void m14393a(ProtectConversationsPayPreferences protectConversationsPayPreferences, Preference preference) {
        preference = (ProtectConversationPayPreference) preference;
        protectConversationsPayPreferences.f13853e.m14373a(preference);
        preference.m14391c();
        protectConversationsPayPreferences.f13856h = preference;
        Map hashMap = new HashMap();
        hashMap.put(Long.valueOf(Long.parseLong(preference.f13844e)), Boolean.valueOf(preference.f13845f));
        Context context = protectConversationsPayPreferences.getContext();
        Serializable serializable = LaunchMode.CREATE_OR_UPDATE_PIN_STATUS;
        PaymentPinProtectionsParamsBuilder paymentPinProtectionsParamsBuilder = new PaymentPinProtectionsParamsBuilder();
        paymentPinProtectionsParamsBuilder.f13732b = hashMap;
        PaymentPinProtectionsParams paymentPinProtectionsParams = new PaymentPinProtectionsParams(paymentPinProtectionsParamsBuilder);
        Preconditions.checkNotNull(context);
        Intent intent = new Intent(context, PaymentPinRequireActivity.class);
        intent.putExtra("launch_mode_extra", serializable);
        Intent intent2 = intent;
        intent2.putExtra("payment_pin_protections_params_extra", paymentPinProtectionsParams);
        protectConversationsPayPreferences.f13850b.a(intent2, 1, protectConversationsPayPreferences);
    }

    public final void mo548a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (!(i2 == -1 || this.f13856h == null)) {
                    this.f13856h.m14391c();
                }
                this.f13856h = null;
                return;
            default:
                super.mo548a(i, i2, intent);
                return;
        }
    }

    public final ListenableFuture<PaymentPinStatus> mo541b() {
        Object obj;
        if (this.f13855g == null || this.f13855g.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this.f13855g;
        }
        this.f13855g = this.f13849a.m14290b();
        Futures.a(this.f13855g, new C15671(this), this.f13851c);
        return this.f13855g;
    }
}

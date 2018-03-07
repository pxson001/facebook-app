package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.addresstypeahead.AddressTypeAheadActivity;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.geocoder.FbGeocoder;
import com.facebook.geocoder.FbGeocoder.C06932;
import com.facebook.geocoder.GeocoderQuery.GeocodeQueryString;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams.Addresses;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.ride.analytics.RideAnalyticsLogger;
import com.facebook.messaging.business.ride.enums.RideLocationType;
import com.facebook.messaging.business.ride.gating.IsRideGoogleMapEnabled;
import com.facebook.messaging.business.ride.graphql.RideQueryFragments.RideEstimateQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragments.RidePaymentQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypeModel;
import com.facebook.messaging.business.ride.helper.RideAddressTriggerHelper;
import com.facebook.messaging.business.ride.helper.RideAddressTriggerHelper.C10481;
import com.facebook.messaging.business.ride.helper.RideEstimateHelper;
import com.facebook.messaging.business.ride.helper.RideEstimateHelper.C10501;
import com.facebook.messaging.business.ride.helper.RideLocationHelper;
import com.facebook.messaging.business.ride.helper.RideMutationHelper;
import com.facebook.messaging.business.ride.helper.RidePaymentHelper;
import com.facebook.messaging.business.ride.helper.RidePaymentHelper.C10651;
import com.facebook.messaging.business.ride.helper.RideRequestParam;
import com.facebook.messaging.business.ride.helper.RideTypeInfoHelper;
import com.facebook.messaging.business.ride.utils.LocationParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.view.RideMapView.MapDisplayListener;
import com.facebook.messaging.business.ride.view.RideMultiOptionsView.Listener;
import com.facebook.messaging.business.ride.view.RideTypeTabContainerView.OnTabClickListener;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.text.BetterButton;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mmssms_custom_bundle */
public final class RideRequestFragment extends FbFragment implements BusinessActivityFragment {
    private static final String[] ap = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    @Inject
    RidePaymentHelper f9403a;
    public BetterButton aA;
    public RideMultiOptionsView aB;
    public RideMultiOptionsView aC;
    public RideMultiOptionsView aD;
    public LocationParams aE = new LocationParams();
    public LocationParams aF = new LocationParams();
    @Nullable
    public String aG;
    @Nullable
    public Location aH;
    @Nullable
    public Runnable aI;
    @Nullable
    public CreditCard aJ;
    @Inject
    RideGmsLsUpsellController al;
    @Inject
    GooglePlayServicesLocationUpsellDialogController am;
    @IsRideGoogleMapEnabled
    @Inject
    Provider<Boolean> an;
    @Inject
    public BusinessMessageDialogHelper ao;
    public final C10921 aq = new C10921(this);
    public boolean ar;
    public boolean as;
    public RideServiceParams at;
    private Handler au;
    public RideMapView av;
    public boolean aw;
    private boolean ax;
    public boolean ay;
    public RideTypeTabContainerView az;
    @Inject
    public RideEstimateHelper f9404b;
    @Inject
    RideTypeInfoHelper f9405c;
    @Inject
    public RideMutationHelper f9406d;
    @Inject
    public RideLocationHelper f9407e;
    @Inject
    public RideAnalyticsLogger f9408f;
    @Inject
    SecureContextHelper f9409g;
    @Inject
    RuntimePermissionsUtil f9410h;
    @Inject
    RideAddressTriggerHelper f9411i;

    /* compiled from: mmssms_custom_bundle */
    public class C10921 {
        public final /* synthetic */ RideRequestFragment f9394a;

        C10921(RideRequestFragment rideRequestFragment) {
            this.f9394a = rideRequestFragment;
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10932 {
        final /* synthetic */ RideRequestFragment f9395a;

        C10932(RideRequestFragment rideRequestFragment) {
            this.f9395a = rideRequestFragment;
        }

        public final void m9831a(@Nullable Address address) {
            if (!this.f9395a.mx_()) {
                return;
            }
            if (address != null) {
                RideRequestFragment.m9847a(this.f9395a, this.f9395a.at.f9310c, RideLocationType.DESTINATION);
                this.f9395a.m9851b(address.getLatitude(), address.getLongitude(), RideRequestFragment.m9850b(address));
                RideRequestFragment.ar(this.f9395a);
                return;
            }
            this.f9395a.aC.setActionText(this.f9395a.b(2131240756));
        }
    }

    /* compiled from: mmssms_custom_bundle */
    class C10943 implements MapDisplayListener {
        final /* synthetic */ RideRequestFragment f9396a;

        C10943(RideRequestFragment rideRequestFragment) {
            this.f9396a = rideRequestFragment;
        }

        public final void mo334a(Location location) {
            this.f9396a.aH = location;
            if (!this.f9396a.aw) {
                RideRequestFragment.aB(this.f9396a);
            }
        }

        public final void mo333a() {
            RideRequestFragment.aB(this.f9396a);
        }

        public final void mo335a(LatLng latLng) {
            if (this.f9396a.aw && !RideRequestFragment.aG(this.f9396a)) {
                RideRequestFragment.m9847a(this.f9396a, this.f9396a.b(2131240744), RideLocationType.ORIGIN);
                this.f9396a.aE.f9293b = null;
                this.f9396a.m9842a(latLng.a, latLng.b, null);
                RideRequestFragment.m9844a(this.f9396a, latLng.a, latLng.b);
            }
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10954 implements OnTabClickListener {
        final /* synthetic */ RideRequestFragment f9397a;

        public C10954(RideRequestFragment rideRequestFragment) {
            this.f9397a = rideRequestFragment;
        }

        public final void mo336a(RideTypeModel rideTypeModel) {
            if (this.f9397a.aE.f9292a != null) {
                this.f9397a.f9408f.m9369b("click_ride_type_item");
                RideEstimateHelper rideEstimateHelper = this.f9397a.f9404b;
                String str = this.f9397a.at.f9311d;
                String j = rideTypeModel.m9606j();
                Location location = this.f9397a.aE.f9292a;
                Location location2 = this.f9397a.aF.f9292a;
                rideEstimateHelper.m9698a();
                RideEstimateQueryString rideEstimateQueryString = (RideEstimateQueryString) new RideEstimateQueryString().a("provider", str).a("ride_type", j).a("source_latitude", Double.valueOf(location.getLatitude())).a("source_longitude", Double.valueOf(location.getLongitude()));
                if (location2 != null) {
                    rideEstimateQueryString.a("destination_latitude", Double.valueOf(location2.getLatitude())).a("destination_longitude", Double.valueOf(location2.getLongitude()));
                }
                rideEstimateHelper.f9157e = rideEstimateHelper.f9155c.a(GraphQLRequest.a(rideEstimateQueryString));
                Futures.a(rideEstimateHelper.f9157e, new C10501(rideEstimateHelper), rideEstimateHelper.f9156d);
            }
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10965 {
        public final /* synthetic */ RideRequestFragment f9398a;

        public C10965(RideRequestFragment rideRequestFragment) {
            this.f9398a = rideRequestFragment;
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10976 {
        public final /* synthetic */ RideRequestFragment f9399a;

        public C10976(RideRequestFragment rideRequestFragment) {
            this.f9399a = rideRequestFragment;
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10987 {
        public final /* synthetic */ RideRequestFragment f9400a;

        public C10987(RideRequestFragment rideRequestFragment) {
            this.f9400a = rideRequestFragment;
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C10998 implements OnClickListener {
        final /* synthetic */ RideRequestFragment f9401a;

        public C10998(RideRequestFragment rideRequestFragment) {
            this.f9401a = rideRequestFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1357093829);
            RideTypeModel rideTypeModel = this.f9401a.az.f9424f;
            if (rideTypeModel == null || this.f9401a.aE.f9292a == null || !RideRequestFragment.aK(this.f9401a) || this.f9401a.at.f9309b == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1076181634, a);
                return;
            }
            String a2;
            this.f9401a.f9408f.m9369b("click_request_ride_button");
            RideRequestParam rideRequestParam = new RideRequestParam();
            rideRequestParam.f9262a = Long.toString(this.f9401a.at.f9309b.i());
            rideRequestParam = rideRequestParam;
            rideRequestParam.f9263b = this.f9401a.at.f9311d;
            rideRequestParam = rideRequestParam;
            rideRequestParam.f9264c = rideTypeModel.m9605a();
            rideRequestParam = rideRequestParam;
            rideRequestParam.f9265d = rideTypeModel.m9606j();
            RideRequestParam rideRequestParam2 = rideRequestParam;
            rideRequestParam2.f9266e = this.f9401a.aE.f9292a;
            rideRequestParam2 = rideRequestParam2;
            rideRequestParam2.f9267f = this.f9401a.aF.f9292a;
            rideRequestParam2 = rideRequestParam2;
            rideRequestParam2.f9269h = this.f9401a.aE.f9294c;
            rideRequestParam2 = rideRequestParam2;
            rideRequestParam2.f9271j = this.f9401a.aF.f9294c;
            rideRequestParam2 = rideRequestParam2;
            rideRequestParam2.f9268g = this.f9401a.aE.f9293b;
            rideRequestParam2 = rideRequestParam2;
            rideRequestParam2.f9270i = this.f9401a.aF.f9293b;
            rideRequestParam = rideRequestParam2;
            if (this.f9401a.aJ != null) {
                a2 = this.f9401a.aJ.a();
            } else {
                a2 = null;
            }
            rideRequestParam.f9272k = a2;
            this.f9401a.f9406d.m9716a(rideRequestParam);
            LogUtils.a(-1102997477, a);
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class C11009 implements Listener {
        final /* synthetic */ RideRequestFragment f9402a;

        public C11009(RideRequestFragment rideRequestFragment) {
            this.f9402a = rideRequestFragment;
        }

        public final void mo331a() {
            this.f9402a.f9408f.m9369b("click_pickup_location_row");
            RideRequestFragment.m9854g(this.f9402a, 1);
        }

        public final void mo332b() {
            this.f9402a.f9408f.m9369b("click_pickup_location_row");
            RideRequestFragment.m9854g(this.f9402a, 1);
        }
    }

    /* compiled from: mmssms_custom_bundle */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "RideRequestFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new RideRequestFragment();
        }
    }

    public static void m9849a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RideRequestFragment) obj).m9843a(RidePaymentHelper.m9739b(injectorLike), RideEstimateHelper.m9697b(injectorLike), RideTypeInfoHelper.m9752b(injectorLike), RideMutationHelper.m9712b(injectorLike), RideLocationHelper.m9703b(injectorLike), RideAnalyticsLogger.m9362b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), RuntimePermissionsUtil.b(injectorLike), RideAddressTriggerHelper.m9694b(injectorLike), RideGmsLsUpsellController.m9774b(injectorLike), GooglePlayServicesLocationUpsellDialogController.b(injectorLike), IdBasedProvider.a(injectorLike, 4120), BusinessMessageDialogHelper.m9018b(injectorLike));
    }

    private void m9843a(RidePaymentHelper ridePaymentHelper, RideEstimateHelper rideEstimateHelper, RideTypeInfoHelper rideTypeInfoHelper, RideMutationHelper rideMutationHelper, RideLocationHelper rideLocationHelper, RideAnalyticsLogger rideAnalyticsLogger, SecureContextHelper secureContextHelper, RuntimePermissionsUtil runtimePermissionsUtil, RideAddressTriggerHelper rideAddressTriggerHelper, RideGmsLsUpsellController rideGmsLsUpsellController, GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController, Provider<Boolean> provider, BusinessMessageDialogHelper businessMessageDialogHelper) {
        this.f9403a = ridePaymentHelper;
        this.f9404b = rideEstimateHelper;
        this.f9405c = rideTypeInfoHelper;
        this.f9406d = rideMutationHelper;
        this.f9407e = rideLocationHelper;
        this.f9408f = rideAnalyticsLogger;
        this.f9409g = secureContextHelper;
        this.f9410h = runtimePermissionsUtil;
        this.f9411i = rideAddressTriggerHelper;
        this.al = rideGmsLsUpsellController;
        this.am = googlePlayServicesLocationUpsellDialogController;
        this.an = provider;
        this.ao = businessMessageDialogHelper;
    }

    public final void mo310a(Parcelable parcelable) {
        boolean z;
        boolean z2 = true;
        this.at = (RideServiceParams) ((Bundle) parcelable).getParcelable("ride_service_params");
        if (Strings.isNullOrEmpty(this.at.f9311d)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (Strings.isNullOrEmpty(this.at.f9312e)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Preconditions.checkNotNull(this.at.f9309b);
    }

    public static Intent m9841a(Context context, RideServiceParams rideServiceParams) {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("ride_service_params", rideServiceParams);
        return BusinessActivity.m8889a(context, "RideRequestFragment", bundle);
    }

    public final String mo309a(Context context) {
        return context.getString(2131240729);
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void m9865c(Bundle bundle) {
        super.c(bundle);
        Class cls = RideRequestFragment.class;
        m9849a((Object) this, getContext());
        this.au = new Handler();
        this.am.a(this, this.al);
    }

    public final View m9858a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 351746276);
        View inflate = layoutInflater.inflate(2130906894, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1069978218, a);
        return inflate;
    }

    public final void m9862a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.av = (RideMapView) e(2131567076);
        this.av.m9808a(bundle);
        this.az = (RideTypeTabContainerView) e(2131567077);
        this.aA = (BetterButton) e(2131567081);
        this.aB = (RideMultiOptionsView) e(2131567078);
        this.aC = (RideMultiOptionsView) e(2131567079);
        this.aD = (RideMultiOptionsView) e(2131567080);
        this.az.m9889b(bundle);
        if (bundle != null) {
            this.aG = bundle.getString("payment_row_display_text");
            Bundle bundle2 = bundle.getBundle("origin_location_params");
            if (bundle2 != null) {
                this.aE = (LocationParams) bundle2.getParcelable("location_params");
            }
            bundle2 = bundle.getBundle("destination_location_params");
            if (bundle2 != null) {
                this.aF = (LocationParams) bundle2.getParcelable("location_params");
            }
            this.aJ = (CreditCard) bundle.getParcelable("last_picked_payment_card");
            this.ay = bundle.getBoolean("is_optional_payment_enabled");
            this.ar = bundle.getBoolean("is_funnel_logging_started", false);
        }
        this.f9404b.f9158f = new C10965(this);
        this.az.f9425g = new C10954(this);
        this.f9406d.f9206m = new C10976(this);
        this.f9407e.f9174g = new C10987(this);
        as();
        if (this.aE.f9293b != null) {
            m9847a(this, this.aE.f9293b, RideLocationType.ORIGIN);
        } else {
            this.aB.setActionText(b(2131240755));
        }
        this.aB.f9362k = new C11009(this);
        if (this.aF.f9293b != null) {
            m9847a(this, this.aF.f9293b, RideLocationType.DESTINATION);
        } else {
            this.aC.setActionText(b(2131240756));
        }
        this.aC.setupCancelButton(new OnClickListener(this) {
            final /* synthetic */ RideRequestFragment f9385a;

            {
                this.f9385a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 928240993);
                this.f9385a.aC.setActionText(this.f9385a.b(2131240756));
                this.f9385a.aF.f9292a = null;
                if (this.f9385a.aE.f9292a != null) {
                    this.f9385a.av.m9805a(this.f9385a.aE.f9292a.getLatitude(), this.f9385a.aE.f9292a.getLongitude());
                }
                RideRequestFragment.aD(this.f9385a);
                Logger.a(2, EntryType.UI_INPUT_END, 265457312, a);
            }
        });
        this.aC.f9362k = new Listener(this) {
            final /* synthetic */ RideRequestFragment f9386a;

            {
                this.f9386a = r1;
            }

            public final void mo331a() {
                this.f9386a.f9408f.m9369b("click_pickup_location_row");
                RideRequestFragment.m9854g(this.f9386a, 2);
            }

            public final void mo332b() {
                this.f9386a.f9408f.m9369b("click_pickup_location_row");
                RideRequestFragment.m9854g(this.f9386a, 2);
            }
        };
        aA();
        this.aA.setOnClickListener(new C10998(this));
        RideServiceParams rideServiceParams = this.at;
        if (!this.ar) {
            this.ar = true;
            RideAnalyticsLogger rideAnalyticsLogger = this.f9408f;
            rideAnalyticsLogger.f9056b.a(FunnelRegistry.q);
            if (!Strings.isNullOrEmpty(rideServiceParams.f9311d)) {
                rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "PROVIDER_ID:" + rideServiceParams.f9311d);
            }
            if (!Strings.isNullOrEmpty(rideServiceParams.f9308a)) {
                rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "TRIGGER_SOURCE:" + rideServiceParams.f9308a);
            }
            if (!Strings.isNullOrEmpty(rideServiceParams.f9313f)) {
                rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "TRIGGER_SOURCE_TAG:" + rideServiceParams.f9313f);
            }
            if (rideServiceParams.f9309b != null) {
                rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "THREAD_ID:" + String.valueOf(rideServiceParams.f9309b.i()));
                rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "THREAD_TYPE:" + rideServiceParams.f9309b.a.toString());
            }
            rideAnalyticsLogger.f9056b.a(FunnelRegistry.q, "IS_DESTINATION_OPTIONAL:" + Boolean.toString(rideServiceParams.f9316i));
        }
        aE();
        if (!m9853e()) {
            aq();
        }
    }

    private boolean m9853e() {
        if (this.at.f9314g == null) {
            return false;
        }
        String string;
        if (Strings.isNullOrEmpty(this.at.f9310c)) {
            string = jW_().getString(2131240770);
        } else {
            string = this.at.f9310c;
        }
        m9847a(this, string, RideLocationType.DESTINATION);
        m9851b(this.at.f9314g.a, this.at.f9314g.b, null);
        ar(this);
        return true;
    }

    private void aq() {
        if (!Strings.isNullOrEmpty(this.at.f9310c)) {
            this.aC.m9819b();
            RideAddressTriggerHelper rideAddressTriggerHelper = this.f9411i;
            String str = this.at.f9310c;
            C10932 c10932 = new C10932(this);
            Preconditions.checkState(!Strings.isNullOrEmpty(str));
            rideAddressTriggerHelper.m9695a();
            FbGeocoder fbGeocoder = rideAddressTriggerHelper.f9146e;
            Preconditions.checkNotNull(str);
            rideAddressTriggerHelper.f9151j = Futures.a(fbGeocoder.f6754b.a(GraphQLRequest.a((GeocodeQueryString) new GeocodeQueryString().a("addresses", new GeocodeAddressInputQueryParams().a(ImmutableList.of(new Addresses().a(str)))).a("limit", Integer.valueOf(1)))), new C06932(fbGeocoder), MoreExecutors.a());
            Futures.a(rideAddressTriggerHelper.f9151j, new C10481(rideAddressTriggerHelper, str, c10932), rideAddressTriggerHelper.f9147f);
        }
    }

    public final void m9860a(int i, int i2, Intent intent) {
        Address address;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.f9408f.m9369b("success_update_pickup_location");
                    address = (Address) intent.getParcelableExtra("selected_address");
                    m9847a(this, this.f9407e.m9704a(address), RideLocationType.ORIGIN);
                    m9842a(address.getLatitude(), address.getLongitude(), m9850b(address));
                    this.aw = true;
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.f9408f.m9369b("success_update_dropoff_location");
                    address = (Address) intent.getParcelableExtra("selected_address");
                    m9847a(this, this.f9407e.m9704a(address), RideLocationType.DESTINATION);
                    m9851b(address.getLatitude(), address.getLongitude(), m9850b(address));
                    return;
                }
                return;
            case 4:
                if (i2 == -1 && intent != null) {
                    this.f9408f.m9369b("success_update_payment_info");
                    PaymentMethod paymentMethod = (PaymentMethod) intent.getParcelableExtra("selected_payment_method");
                    if (PaymentMethodType.CREDIT_CARD == paymentMethod.b()) {
                        this.aJ = (CreditCard) paymentMethod;
                        m9848a(this.aJ);
                    }
                }
                aD(this);
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    public final void m9864b() {
        if (!this.ax && aF()) {
            this.av.m9804a();
            this.ax = true;
            if (aG(this)) {
                this.aw = true;
            } else {
                this.az.m9885a();
            }
        }
    }

    public static void ar(RideRequestFragment rideRequestFragment) {
        if (rideRequestFragment.aE.f9292a == null) {
            rideRequestFragment.az.m9888a(rideRequestFragment.b(2131240752));
            return;
        }
        if (aG(rideRequestFragment)) {
            rideRequestFragment.av.m9807a(rideRequestFragment.aE.f9292a, rideRequestFragment.aF.f9292a);
        } else {
            rideRequestFragment.av.m9805a(rideRequestFragment.aE.f9292a.getLatitude(), rideRequestFragment.aE.f9292a.getLongitude());
        }
        rideRequestFragment.f9405c.m9753a(rideRequestFragment.at.f9311d, rideRequestFragment.aE.f9292a.getLatitude(), rideRequestFragment.aE.f9292a.getLongitude(), rideRequestFragment.aq);
        if (Strings.isNullOrEmpty(rideRequestFragment.aE.f9293b)) {
            rideRequestFragment.f9407e.m9706a(rideRequestFragment.aE.f9292a.getLatitude(), rideRequestFragment.aE.f9292a.getLongitude());
        }
    }

    private void as() {
        this.ax = false;
        this.aw = false;
        if (aF()) {
            this.av.m9804a();
            this.ax = true;
        }
        this.av.f9346h = new C10943(this);
        if (this.aH == null) {
            this.az.m9888a(b(2131240752));
        }
    }

    private void aA() {
        this.aD.setIconTintColor(jW_().getColor(2131363789));
        aI(this);
        if (this.aJ != null) {
            m9848a(this.aJ);
        } else if (Strings.isNullOrEmpty(this.aG)) {
            this.aD.m9819b();
            RidePaymentHelper ridePaymentHelper = this.f9403a;
            String str = this.at.f9311d;
            AnonymousClass12 anonymousClass12 = new Object(this) {
                public final /* synthetic */ RideRequestFragment f9387a;

                {
                    this.f9387a = r1;
                }
            };
            ridePaymentHelper.m9740a();
            ridePaymentHelper.f9241c.a("task_key_fetch_payment_info", ridePaymentHelper.f9240b.a(GraphQLRequest.a((RidePaymentQueryString) new RidePaymentQueryString().a("provider", str))), new C10651(ridePaymentHelper, anonymousClass12));
        } else {
            m9846a(this, this.aG);
        }
    }

    public static void m9854g(RideRequestFragment rideRequestFragment, int i) {
        Parcelable parcelable;
        String str;
        if (rideRequestFragment.aH != null) {
            parcelable = rideRequestFragment.aH;
        } else if (rideRequestFragment.aE.f9292a != null) {
            r1 = rideRequestFragment.aE.f9292a;
        } else if (rideRequestFragment.aF.f9292a != null) {
            r1 = rideRequestFragment.aF.f9292a;
        } else {
            parcelable = null;
        }
        Context context = rideRequestFragment.getContext();
        boolean booleanValue = ((Boolean) rideRequestFragment.an.get()).booleanValue();
        if (i == 2) {
            str = "rideshare_destination";
        } else {
            str = "rideshare_origin";
        }
        Intent intent = new Intent(context, AddressTypeAheadActivity.class);
        intent.putExtra("current_location", parcelable);
        intent.putExtra("is_using_google_api", booleanValue);
        intent.putExtra("product_tag", str);
        rideRequestFragment.f9409g.a(intent, i, rideRequestFragment);
    }

    public static void aB(RideRequestFragment rideRequestFragment) {
        if (rideRequestFragment.aH != null) {
            if (!aG(rideRequestFragment)) {
                m9847a(rideRequestFragment, rideRequestFragment.b(2131240745), RideLocationType.ORIGIN);
                rideRequestFragment.aE.f9293b = null;
                rideRequestFragment.m9842a(rideRequestFragment.aH.getLatitude(), rideRequestFragment.aH.getLongitude(), null);
                m9844a(rideRequestFragment, rideRequestFragment.aH.getLatitude(), rideRequestFragment.aH.getLongitude());
            }
            rideRequestFragment.aw = true;
            rideRequestFragment.av.m9806a(rideRequestFragment.aH);
        }
    }

    public static void m9847a(@Nullable RideRequestFragment rideRequestFragment, String str, RideLocationType rideLocationType) {
        if (!Strings.isNullOrEmpty(str)) {
            if (rideLocationType == RideLocationType.ORIGIN) {
                rideRequestFragment.aE.f9293b = str;
                rideRequestFragment.aB.setSelectedItem(str);
            } else if (rideLocationType == RideLocationType.DESTINATION) {
                rideRequestFragment.aF.f9293b = str;
                rideRequestFragment.aC.setSelectedItem(str);
            }
        }
    }

    private void m9842a(double d, double d2, @Nullable String str) {
        if (this.aE.f9292a == null) {
            this.aE.f9292a = new Location("");
        }
        this.aE.f9292a.setLatitude(d);
        this.aE.f9292a.setLongitude(d2);
        this.aE.f9294c = str;
        aD(this);
    }

    private void m9851b(double d, double d2, @Nullable String str) {
        if (this.aF.f9292a == null) {
            this.aF.f9292a = new Location("");
        }
        this.aF.f9292a.setLatitude(d);
        this.aF.f9292a.setLongitude(d2);
        this.aF.f9294c = str;
        aD(this);
    }

    public static void m9844a(RideRequestFragment rideRequestFragment, double d, double d2) {
        rideRequestFragment.aC();
        final double d3 = d;
        final double d4 = d2;
        rideRequestFragment.aI = new Runnable(rideRequestFragment) {
            final /* synthetic */ RideRequestFragment f9390c;

            public void run() {
                this.f9390c.aI = null;
                this.f9390c.f9405c.m9753a(this.f9390c.at.f9311d, d3, d4, this.f9390c.aq);
                this.f9390c.f9407e.m9706a(d3, d4);
            }
        };
        HandlerDetour.b(rideRequestFragment.au, rideRequestFragment.aI, 1000, 1129746224);
    }

    private void aC() {
        if (this.aI != null) {
            HandlerDetour.a(this.au, this.aI);
        }
    }

    public static void aD(RideRequestFragment rideRequestFragment) {
        BetterButton betterButton = rideRequestFragment.aA;
        boolean z = rideRequestFragment.aE.f9292a != null && aK(rideRequestFragment);
        betterButton.setEnabled(z);
    }

    private void aE() {
        if (!aF()) {
            Intent intent = new Intent(getContext(), RequestPermissionsActivity.class);
            intent.putExtra("extra_permissions", ap);
            this.f9409g.a(intent, 3, this);
        }
    }

    private boolean aF() {
        return this.f9410h.a(ap);
    }

    public static boolean aG(RideRequestFragment rideRequestFragment) {
        return (rideRequestFragment.aE.f9292a == null || rideRequestFragment.aF.f9292a == null) ? false : true;
    }

    @Nullable
    public static String m9850b(@Nullable Address address) {
        if (address == null) {
            return null;
        }
        Bundle extras = address.getExtras();
        if (extras != null) {
            return extras.getString("google_place_id");
        }
        return null;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1213463377);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1989964004, a);
    }

    public final void m9855G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1112873874);
        super.G();
        this.av.m9809b();
        RideGmsLsUpsellController rideGmsLsUpsellController = this.al;
        GooglePlayServicesLocationUpsellDialogController googlePlayServicesLocationUpsellDialogController = this.am;
        if (rideGmsLsUpsellController.f9324a.a() != State.OKAY) {
            rideGmsLsUpsellController.f9325b = this;
            googlePlayServicesLocationUpsellDialogController.a(new LocationSettingsRequestParams(), "surface_messenger_ride_service", "mechanism_messenger_ride_service_button");
        }
        if (aF()) {
            m9864b();
        }
        ar(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1426910878, a);
    }

    public final void m9856H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 418872729);
        super.H();
        this.av.m9811e();
        aC();
        this.f9407e.m9705a();
        this.f9404b.m9698a();
        this.f9411i.m9695a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -376711395, a);
    }

    public final void m9857I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 354098823);
        super.I();
        if (!this.as) {
            aH(this);
        }
        this.f9405c.f9278c.c("task_key_fetch_ride_type");
        this.f9403a.m9740a();
        this.av.m9812f();
        this.am.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1534218244, a);
    }

    public final void m9866e(Bundle bundle) {
        super.e(bundle);
        this.av.m9810b(bundle);
        this.az.m9886a(bundle);
        bundle.putString("payment_row_display_text", this.aG);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("location_params", this.aE);
        bundle.putBundle("origin_location_params", bundle2);
        bundle2 = new Bundle();
        bundle2.putParcelable("location_params", this.aF);
        bundle.putBundle("destination_location_params", bundle2);
        bundle.putParcelable("last_picked_payment_card", this.aJ);
        bundle.putBoolean("is_optional_payment_enabled", this.ay);
        bundle.putBoolean("is_funnel_logging_started", this.ar);
    }

    public final void onLowMemory() {
        super.onLowMemory();
        this.av.m9813g();
    }

    public static void aH(RideRequestFragment rideRequestFragment) {
        RideTypeModel rideTypeModel = rideRequestFragment.az.f9424f;
        rideRequestFragment.f9408f.m9367a(rideRequestFragment.at, rideRequestFragment.as, rideTypeModel == null ? null : rideTypeModel.m9606j(), rideRequestFragment.aE.f9293b, rideRequestFragment.aF.f9293b);
    }

    private void m9848a(CreditCard creditCard) {
        Preconditions.checkNotNull(creditCard);
        m9846a(this, a(2131240750, new Object[]{creditCard.g(), creditCard.e()}));
        this.aD.setSelectedSubText(a(2131240773, new Object[]{this.at.f9312e}));
    }

    public static void aI(RideRequestFragment rideRequestFragment) {
        if (rideRequestFragment.ay) {
            rideRequestFragment.aD.m9821d();
            rideRequestFragment.aD.f9362k = new Listener(rideRequestFragment) {
                final /* synthetic */ RideRequestFragment f9391a;

                {
                    this.f9391a = r1;
                }

                public final void mo331a() {
                    this.f9391a.f9408f.m9369b("click_payment_row");
                    RideRequestFragment.aJ(this.f9391a);
                }

                public final void mo332b() {
                    this.f9391a.f9408f.m9369b("click_payment_row");
                    RideRequestFragment.aJ(this.f9391a);
                }
            };
            return;
        }
        rideRequestFragment.aD.m9820c();
    }

    public static void m9846a(@Nullable RideRequestFragment rideRequestFragment, String str) {
        if (!Strings.isNullOrEmpty(str)) {
            rideRequestFragment.aD.setSelectedItem(str);
        }
    }

    public static void aJ(RideRequestFragment rideRequestFragment) {
        PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
        newBuilder.f18780a = PaymentFlowType.MESSENGER_COMMERCE.analyticsModule;
        newBuilder = newBuilder;
        newBuilder.f18782c = PaymentsFlowType.PICKER_SCREEN;
        PickerScreenAnalyticsParams e = newBuilder.m18789e();
        PickerScreenCommonParamsBuilder newBuilder2 = PickerScreenCommonParams.newBuilder();
        newBuilder2.f18793a = e;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder2;
        pickerScreenCommonParamsBuilder.f18794b = PickerScreenStyleParams.newBuilder().m18827c();
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18795c = PickerScreenStyle.MESSENGER_COMMERCE;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18796d = PaymentItemType.MESSENGER_COMMERCE;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder3 = PaymentMethodsPickerScreenFetcherParams.newBuilder();
        newBuilder3.f18850a = true;
        pickerScreenCommonParamsBuilder.f18800h = newBuilder3.m18855d();
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18797e = ImmutableList.of(NewPaymentOptionType.NEW_PAYPAL);
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18799g = rideRequestFragment.b(2131233858);
        rideRequestFragment.f9409g.a(PickerScreenActivity.m18779a(rideRequestFragment.getContext(), pickerScreenCommonParamsBuilder.m18799j()), 4, rideRequestFragment);
    }

    public static boolean aK(RideRequestFragment rideRequestFragment) {
        return rideRequestFragment.at.f9316i || rideRequestFragment.aF.f9292a != null;
    }
}

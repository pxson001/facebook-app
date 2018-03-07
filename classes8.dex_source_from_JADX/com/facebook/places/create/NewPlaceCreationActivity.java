package com.facebook.places.create;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.View;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.PageTopic;
import com.facebook.places.checkin.analytics.PlacePickerSessionData;
import com.facebook.places.create.PlaceCreationState.Builder;
import com.facebook.places.create.citypicker.NewCityPickerFragment;
import com.facebook.places.create.citypicker.NewCityPickerFragment.CitySelectedListener;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory;
import com.facebook.places.create.network.PlacePinAppId;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.pagetopics.PlaceCategoryPickerFragment;
import com.facebook.places.pagetopics.PlaceCategoryPickerFragment.Listener;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: centerInParent */
public class NewPlaceCreationActivity extends BasePlaceCreationActivity {
    @Inject
    public PlaceCreationAnalyticsLogger f18133p;
    public Optional<PageTopic> f18134q;
    public CrowdsourcingContext f18135r;

    /* compiled from: centerInParent */
    class CategoryPickerListener implements Listener {
        public final void m22117a(PlaceCategoryPickerFragment placeCategoryPickerFragment, PageTopic pageTopic) {
            NewPlaceCreationActivity newPlaceCreationActivity = (NewPlaceCreationActivity) placeCategoryPickerFragment.o();
            newPlaceCreationActivity.f18134q = Optional.of(pageTopic);
            if (pageTopic.id == 197289820310880L) {
                newPlaceCreationActivity.f18133p.b(newPlaceCreationActivity.f18135r, View.HOME_CREATION);
                Intent intent = new Intent();
                intent.putExtra("create_home_from_place_creation", true);
                newPlaceCreationActivity.setResult(-1, intent);
                newPlaceCreationActivity.finish();
                return;
            }
            NewPlaceCreationActivity.m22127j(newPlaceCreationActivity);
        }
    }

    /* compiled from: centerInParent */
    class CityPickerListener implements CitySelectedListener {
        public final void mo190a(NewCityPickerFragment newCityPickerFragment, CheckinPlaceModel checkinPlaceModel, boolean z) {
            NewPlaceCreationActivity newPlaceCreationActivity = (NewPlaceCreationActivity) newCityPickerFragment.o();
            if (((PageTopic) newPlaceCreationActivity.f18134q.get()).id == 224455390913969L) {
                View view = View.CITY_PICKER;
                Intent intent = new Intent();
                FlatBufferModelHelper.a(intent, "selected_existing_place", checkinPlaceModel);
                newPlaceCreationActivity.f18133p.a(newPlaceCreationActivity.f18135r, view, Long.parseLong(checkinPlaceModel.cf_()));
                newPlaceCreationActivity.setResult(-1, intent);
                newPlaceCreationActivity.finish();
                return;
            }
            NewPlaceCreationActivity.m22122a(newPlaceCreationActivity, checkinPlaceModel, z);
        }
    }

    private static <T extends Context> void m22123a(Class<T> cls, T t) {
        m22124a((Object) t, (Context) t);
    }

    public static void m22124a(Object obj, Context context) {
        ((NewPlaceCreationActivity) obj).f18133p = PlaceCreationAnalyticsLogger.a(FbInjector.get(context));
    }

    protected final String mo1087i() {
        return getString(2131235263);
    }

    protected final void mo1086b(@Nullable Bundle bundle) {
        Optional fromNullable;
        super.mo1086b(bundle);
        Class cls = NewPlaceCreationActivity.class;
        m22124a((Object) this, (Context) this);
        this.f18135r = new CrowdsourcingContext(CrowdEntryPoint.PLACE_PICKER_ADD_BUTTON, CrowdEndpoint.PLACE_CREATION_V2_WITH_FORM);
        if (bundle != null) {
            fromNullable = Optional.fromNullable(bundle.getParcelable("state_category"));
        } else {
            fromNullable = Absent.INSTANCE;
        }
        this.f18134q = fromNullable;
        if (kO_().a(2131558429) == null) {
            this.f18133p.a(this.f18135r, View.CATEGORY_PICKER);
            kO_().a().b(2131558429, PlaceCategoryPickerFragment.a(Absent.INSTANCE, new CategoryPickerListener(), true, Type.PLACE_CREATION_LOGGER, this.f18135r)).b();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_category", (Parcelable) this.f18134q.orNull());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && !intent.getBooleanExtra("create_home_from_place_creation", false)) {
            switch (i) {
                case 1:
                    if (intent.hasExtra("extra_place")) {
                        this.f18133p.c(this.f18135r, Long.parseLong(((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place")).cf_()));
                    } else if (intent.hasExtra("selected_existing_place")) {
                        this.f18133p.a(this.f18135r, View.DEDUPER, Long.parseLong(((CheckinPlaceModel) FlatBufferModelHelper.a(intent, "selected_existing_place")).cf_()));
                    }
                    z = true;
                    break;
            }
            if (z) {
                setResult(i2, intent);
                finish();
            }
        }
    }

    private void m22121a(PlaceCreationAnalyticsLogger placeCreationAnalyticsLogger) {
        this.f18133p = placeCreationAnalyticsLogger;
    }

    public static void m22127j(NewPlaceCreationActivity newPlaceCreationActivity) {
        newPlaceCreationActivity.f18133p.b(newPlaceCreationActivity.f18135r, View.CITY_PICKER);
        newPlaceCreationActivity.kO_().a().a(null).a(2130968727, 2130968617, 2130968727, 2130968617).b(2131558429, NewCityPickerFragment.m3493a((Location) newPlaceCreationActivity.getIntent().getParcelableExtra("extra_location"), ((PageTopic) newPlaceCreationActivity.f18134q.get()).id == 224455390913969L, true, new CityPickerListener(), true, CityPickerLoggerFactory.Type.PLACE_CREATION_LOGGER, newPlaceCreationActivity.f18135r)).b();
    }

    static /* synthetic */ void m22122a(NewPlaceCreationActivity newPlaceCreationActivity, CheckinPlaceModel checkinPlaceModel, boolean z) {
        Optional optional;
        Location location;
        newPlaceCreationActivity.f18133p.b(newPlaceCreationActivity.f18135r, View.FORM);
        Location location2 = (Location) newPlaceCreationActivity.getIntent().getParcelableExtra("extra_location");
        if (z) {
            optional = Absent.INSTANCE;
            location = location2;
        } else {
            location = new Location("");
            if (checkinPlaceModel.cg_() != null) {
                location.setLatitude(checkinPlaceModel.cg_().a());
                location.setLongitude(checkinPlaceModel.cg_().b());
            }
            optional = Optional.of(PlacePinAppId.CITY_CENTER);
        }
        Builder builder = new Builder(newPlaceCreationActivity.getIntent().getStringExtra("android.intent.extra.SUBJECT"), (PageTopic) newPlaceCreationActivity.f18134q.get(), location, optional, CheckinPlaceModel.a(checkinPlaceModel));
        builder.f18241g = z;
        Parcelable a = builder.m22184a();
        CrowdsourcingContext crowdsourcingContext = newPlaceCreationActivity.f18135r;
        PlacePickerSessionData placePickerSessionData = (PlacePickerSessionData) newPlaceCreationActivity.getIntent().getParcelableExtra("place_picker_session_data");
        NewPlaceCreationFormFragment newPlaceCreationFormFragment = new NewPlaceCreationFormFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("initial_place_state", a);
        bundle.putParcelable("user_current_location", location2);
        bundle.putParcelable("crowdsourcing_context", crowdsourcingContext);
        bundle.putParcelable("place_picker_session_data", placePickerSessionData);
        newPlaceCreationFormFragment.g(bundle);
        newPlaceCreationActivity.kO_().a().a(null).a(2130968727, 2130968617, 2130968727, 2130968617).b(2131558429, newPlaceCreationFormFragment).b();
    }
}

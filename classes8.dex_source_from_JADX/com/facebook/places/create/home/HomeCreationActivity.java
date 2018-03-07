package com.facebook.places.create.home;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLImage.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.create.citypicker.CityPickerActivity;
import com.facebook.places.create.network.ClosestCityRunner;
import com.facebook.places.create.network.ClosestCityRunner.C20081;
import com.facebook.places.create.network.PlaceCreationErrorParser.LocationInaccurateException;
import com.facebook.places.create.network.PlaceCreationErrorParser.SentryFailException;
import com.facebook.places.create.network.PlaceCreationErrorParser.TooManyPlaceException;
import com.facebook.places.create.network.PlaceCreationParams;
import com.facebook.places.create.network.PlaceCreationRunner;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQL.FBCheckinNearbyCityQueryString;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.FBCheckinNearbyCityQuery.ClosestCity;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCheckinNearbyCityQueryModel.ClosestCityModel;
import com.facebook.privacy.model.GraphQLPrivacyOptionBuilder;
import com.facebook.user.model.User;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: card_holder_name */
public class HomeCreationActivity extends HomeActivity {
    @Nullable
    private PlaceCreationParams f18323A;
    private final FutureCallback<Long> f18324B = new C19961(this);
    private final OnClickListener f18325C = new C19972(this);
    @Inject
    PlaceCreationRunner f18326y;
    @Inject
    ClosestCityRunner f18327z;

    /* compiled from: card_holder_name */
    class C19961 implements FutureCallback<Long> {
        final /* synthetic */ HomeCreationActivity f18320a;

        C19961(HomeCreationActivity homeCreationActivity) {
            this.f18320a = homeCreationActivity;
        }

        public void onSuccess(Object obj) {
            this.f18320a.m22266a(((Long) obj).longValue());
        }

        public void onFailure(Throwable th) {
            HomeCreationActivity.m22274b(this.f18320a, th);
        }
    }

    /* compiled from: card_holder_name */
    class C19972 implements OnClickListener {
        final /* synthetic */ HomeCreationActivity f18321a;

        C19972(HomeCreationActivity homeCreationActivity) {
            this.f18321a = homeCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1956053310);
            this.f18321a.f18292w.m22252j();
            HomeCreationActivity.m22276t(this.f18321a);
            Logger.a(2, EntryType.UI_INPUT_END, -1229363492, a);
        }
    }

    /* compiled from: card_holder_name */
    class C19983 implements FutureCallback<ClosestCity> {
        final /* synthetic */ HomeCreationActivity f18322a;

        C19983(HomeCreationActivity homeCreationActivity) {
            this.f18322a = homeCreationActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            ClosestCityModel closestCityModel = (ClosestCityModel) obj;
            if (closestCityModel != null) {
                this.f18322a.f18285p.f18312e = Long.parseLong(closestCityModel.b());
                this.f18322a.f18285p.f18309b = closestCityModel.c();
                this.f18322a.mo1093n();
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    private static <T extends Context> void m22271a(Class<T> cls, T t) {
        m22272a((Object) t, (Context) t);
    }

    public static void m22272a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((HomeCreationActivity) obj).m22270a(PlaceCreationRunner.m22330b(fbInjector), new ClosestCityRunner(SimpleExecutor.b(fbInjector), GraphQLQueryExecutor.a(fbInjector)));
    }

    private void m22270a(PlaceCreationRunner placeCreationRunner, ClosestCityRunner closestCityRunner) {
        this.f18326y = placeCreationRunner;
        this.f18327z = closestCityRunner;
    }

    protected final String mo1089i() {
        return getString(2131235234);
    }

    protected final void mo1090j() {
        this.p = new HomeActivityModel(HomeActivityMode.CREATE);
        Location location = (Location) getIntent().getParcelableExtra("map_location");
        this.f18285p.f18308a = getResources().getString(2131235237, new Object[]{((User) this.f18291v.get()).h()});
        this.f18285p.f18313f = location;
        GraphQLPrivacyOptionBuilder d = new GraphQLPrivacyOptionBuilder().d(getString(2131235260));
        Builder builder = new Builder();
        builder.e = "friends";
        d = d.a(builder.a()).c("{\"value\":\"ALL_FRIENDS\"}");
        this.f18285p.f18314g = d.b();
    }

    protected final HomeActivityLoggerData mo1091k() {
        Preconditions.checkArgument(getIntent().hasExtra("home_creation_logger_data"));
        return (HomeActivityLoggerData) getIntent().getParcelableExtra("home_creation_logger_data");
    }

    protected final void mo1088c(Bundle bundle) {
        Class cls = HomeCreationActivity.class;
        m22272a((Object) this, (Context) this);
        this.f18288s.setOnClickListener(this.f18325C);
        this.f18289t.setOnClickListener(this.f18325C);
        if (bundle == null) {
            m22277u();
        }
    }

    protected final void mo1092l() {
        if (this.f18285p.f18312e == 0 || this.f18285p.f18309b == null) {
            m22273a(getResources().getString(2131235246), getResources().getString(2131235247));
            this.f18292w.m22263u();
            return;
        }
        m22275s();
    }

    protected final void mo1093n() {
        super.mo1093n();
        if (this.f18285p.f18309b != null) {
            this.f18288s.setTextColor(getResources().getColor(17170435));
        } else {
            this.f18288s.setTextColor(getResources().getColor(17170440));
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1390950297);
        super.onDestroy();
        this.f18327z.m22311a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1066229132, a);
    }

    private void m22275s() {
        Location location;
        m22224b(false);
        m22233p();
        String str = this.f18285p.f18308a;
        if (this.f18285p.f18313f != null) {
            location = this.f18285p.f18313f;
        } else {
            location = new Location("");
        }
        this.f18323A = PlaceCreationParams.m22326a(str, location, Absent.withType(), this.f18285p.f18315h, null, this.f18285p.f18309b, this.f18285p.f18312e, this.f18285p.f18310c, null, this.f18285p.f18311d, null, null, true, this.f18285p.f18314g, null);
        this.f18326y.m22331a(this.f18323A, this.f18324B);
    }

    private void m22266a(long j) {
        CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
        builder.f = String.valueOf(j);
        builder = builder;
        builder.h = this.f18287r.getText().toString();
        CheckinPlaceModel a = builder.a();
        this.f18292w.f18300d = String.valueOf(j);
        this.f18292w.m22264v();
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "extra_place", a);
        setResult(-1, intent);
        finish();
    }

    public static void m22274b(HomeCreationActivity homeCreationActivity, Throwable th) {
        String string;
        homeCreationActivity.m22234q();
        homeCreationActivity.m22224b(true);
        try {
            throw th;
        } catch (LocationInaccurateException e) {
            string = homeCreationActivity.getResources().getString(2131235159);
        } catch (TooManyPlaceException e2) {
            string = homeCreationActivity.getResources().getString(2131235244);
        } catch (SentryFailException e3) {
            string = homeCreationActivity.getResources().getString(2131235244);
        } catch (Exception e4) {
            string = homeCreationActivity.getResources().getString(2131235245);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException(th2);
        }
        homeCreationActivity.f18286q.a(homeCreationActivity.f18286q.a().a().a(true).a());
        homeCreationActivity.f18292w.m22263u();
        homeCreationActivity.m22273a(homeCreationActivity.getResources().getString(2131235157), string);
    }

    public static void m22276t(HomeCreationActivity homeCreationActivity) {
        homeCreationActivity.m22232o();
        Intent intent = new Intent(homeCreationActivity, CityPickerActivity.class);
        intent.putExtra("extra_location", homeCreationActivity.f18285p.f18313f);
        homeCreationActivity.f18290u.a(intent, 12, homeCreationActivity);
    }

    private void m22273a(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.a(str);
        builder.a(2131235282, null);
        builder.b(str2);
        builder.b();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 12) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "selected_city");
            this.f18285p.f18309b = checkinPlaceModel.j();
            this.f18285p.f18312e = Long.parseLong(checkinPlaceModel.cf_());
            if (this.f18285p.f18313f == null) {
                this.f18285p.f18313f = new Location("");
                this.f18285p.f18313f.setLatitude(checkinPlaceModel.cg_().a());
                this.f18285p.f18313f.setLongitude(checkinPlaceModel.cg_().b());
            }
            mo1093n();
            this.f18292w.m22253k();
        }
    }

    private void m22277u() {
        if (this.f18285p.f18313f != null) {
            this.f18327z.m22311a();
            ClosestCityRunner closestCityRunner = this.f18327z;
            Location location = this.f18285p.f18313f;
            C19983 c19983 = new C19983(this);
            Preconditions.checkNotNull(location);
            Preconditions.checkNotNull(c19983);
            CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
            ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
            viewerCoordinates.a(Double.valueOf(location.getLatitude()));
            viewerCoordinates.b(Double.valueOf(location.getLongitude()));
            if (location.getAccuracy() != 0.0f) {
                viewerCoordinates.c(Double.valueOf((double) location.getAccuracy()));
            }
            if (location.hasSpeed()) {
                viewerCoordinates.d(Double.valueOf((double) location.getSpeed()));
            }
            checkinSearchQueryInputCheckinSearchQuery.a(viewerCoordinates);
            closestCityRunner.f18362a.a(GraphQLQueryExecutor.a(closestCityRunner.f18363b.a(GraphQLRequest.a((FBCheckinNearbyCityQueryString) new FBCheckinNearbyCityQueryString().a("query", checkinSearchQueryInputCheckinSearchQuery)))), new C20081(closestCityRunner, c19983));
        }
    }
}

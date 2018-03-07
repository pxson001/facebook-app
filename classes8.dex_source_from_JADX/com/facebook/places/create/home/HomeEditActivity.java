package com.facebook.places.create.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.places.create.citypicker.CityPickerActivity;
import com.facebook.places.create.home.HomeUpdateRunner.C20071;
import com.facebook.places.create.home.HomeUpdateRunner.HomeUpdateCityDeniedException;
import com.facebook.places.create.home.HomeUpdateRunner.HomeUpdateNameDeniedException;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQL.HomeResidenceQueryString;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.HomeResidenceQuery;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.HomeResidenceQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.HomeResidenceQueryModel.CityModel;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: card_form_success */
public class HomeEditActivity extends HomeActivity {
    @Inject
    Toaster f18335A;
    private final OnClickListener f18336B = new C19991(this);
    private ErrorState f18337C;
    public String f18338D;
    public CityModel f18339E;
    private final FutureCallback<Boolean> f18340F = new C20002(this);
    private final FutureCallback<HomeResidenceQuery> f18341G = new C20013(this);
    @Inject
    HomeFetchRunner f18342y;
    @Inject
    HomeUpdateRunner f18343z;

    /* compiled from: card_form_success */
    class C19991 implements OnClickListener {
        final /* synthetic */ HomeEditActivity f18328a;

        C19991(HomeEditActivity homeEditActivity) {
            this.f18328a = homeEditActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1126633801);
            HomeEditActivity.m22295s(this.f18328a);
            Logger.a(2, EntryType.UI_INPUT_END, 353364276, a);
        }
    }

    /* compiled from: card_form_success */
    class C20002 implements FutureCallback<Boolean> {
        final /* synthetic */ HomeEditActivity f18329a;

        C20002(HomeEditActivity homeEditActivity) {
            this.f18329a = homeEditActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            if (((Boolean) obj).booleanValue()) {
                HomeEditActivity.m22298v(this.f18329a);
            } else {
                HomeEditActivity.m22291b(this.f18329a, null);
            }
        }

        public void onFailure(Throwable th) {
            HomeEditActivity.m22291b(this.f18329a, th);
        }
    }

    /* compiled from: card_form_success */
    class C20013 implements FutureCallback<HomeResidenceQuery> {
        final /* synthetic */ HomeEditActivity f18330a;

        C20013(HomeEditActivity homeEditActivity) {
            this.f18330a = homeEditActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            HomeResidenceQueryModel homeResidenceQueryModel = (HomeResidenceQueryModel) obj;
            if (homeResidenceQueryModel != null) {
                HomeActivity homeActivity = this.f18330a;
                homeActivity.m22234q();
                homeActivity.f18285p.f18308a = homeResidenceQueryModel.c();
                homeActivity.f18338D = homeResidenceQueryModel.c();
                if (homeResidenceQueryModel.b() != null) {
                    homeActivity.f18339E = homeResidenceQueryModel.b();
                    homeActivity.f18285p.f18309b = homeResidenceQueryModel.b().d();
                    homeActivity.f18285p.f18312e = Long.parseLong(homeResidenceQueryModel.b().b());
                }
                if (homeResidenceQueryModel.a() != null) {
                    homeActivity.f18285p.f18310c = homeResidenceQueryModel.a().a();
                }
                homeActivity.f18285p.f18311d = homeResidenceQueryModel.d();
                Location location = new Location("");
                location.setLatitude(homeResidenceQueryModel.b().c().a());
                location.setLongitude(homeResidenceQueryModel.b().c().b());
                homeActivity.f18285p.f18313f = location;
                if (!homeResidenceQueryModel.cj_()) {
                    homeActivity.f18285p.f18316i = Uri.parse(homeResidenceQueryModel.g().a());
                }
                homeActivity.f18285p.f18314g = homeResidenceQueryModel.ci_();
                homeActivity.m22230m();
                return;
            }
            HomeEditActivity.m22299w(this.f18330a);
        }

        public void onFailure(Throwable th) {
            HomeEditActivity.m22299w(this.f18330a);
        }
    }

    /* compiled from: card_form_success */
    class C20024 implements DialogInterface.OnClickListener {
        final /* synthetic */ HomeEditActivity f18331a;

        C20024(HomeEditActivity homeEditActivity) {
            this.f18331a = homeEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18331a.finish();
        }
    }

    /* compiled from: card_form_success */
    class C20035 implements DialogInterface.OnClickListener {
        final /* synthetic */ HomeEditActivity f18332a;

        C20035(HomeEditActivity homeEditActivity) {
            this.f18332a = homeEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18332a.f18287r.setText(this.f18332a.f18338D);
        }
    }

    /* compiled from: card_form_success */
    class C20046 implements DialogInterface.OnClickListener {
        final /* synthetic */ HomeEditActivity f18333a;

        C20046(HomeEditActivity homeEditActivity) {
            this.f18333a = homeEditActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f18333a.f18285p.f18309b = this.f18333a.f18339E.d();
            this.f18333a.f18285p.f18312e = Long.parseLong(this.f18333a.f18339E.b());
            this.f18333a.mo1093n();
        }
    }

    /* compiled from: card_form_success */
    public enum ErrorState {
        NO_ERROR,
        HOME_FETCH_ERROR,
        HOME_NAME_CHANGE_DENIED_ERROR,
        HOME_CITY_CHANGE_DENIED_ERROR,
        HOME_UPDATE_ERROR
    }

    private static <T extends Context> void m22288a(Class<T> cls, T t) {
        m22289a((Object) t, (Context) t);
    }

    public static void m22289a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((HomeEditActivity) obj).m22287a(new HomeFetchRunner(SimpleExecutor.b(fbInjector), GraphQLQueryExecutor.a(fbInjector)), new HomeUpdateRunner(SimpleExecutor.b(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 2289), new HomeUpdateMethod()), Toaster.b(fbInjector));
    }

    private void m22287a(HomeFetchRunner homeFetchRunner, HomeUpdateRunner homeUpdateRunner, Toaster toaster) {
        this.f18342y = homeFetchRunner;
        this.f18343z = homeUpdateRunner;
        this.f18335A = toaster;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "selected_city");
            this.f18285p.f18309b = checkinPlaceModel.j();
            this.f18285p.f18312e = Long.parseLong(checkinPlaceModel.cf_());
            mo1093n();
        }
    }

    protected final void mo1093n() {
        super.mo1093n();
        this.f18288s.setTextColor(getResources().getColor(17170435));
    }

    protected final String mo1089i() {
        return getString(2131235289);
    }

    protected final void mo1090j() {
        Preconditions.checkArgument(getIntent().hasExtra("home_id"));
        Preconditions.checkArgument(getIntent().hasExtra("home_name"));
        this.p = new HomeActivityModel(HomeActivityMode.EDIT);
        this.f18285p.f18308a = getIntent().getStringExtra("home_name");
        this.f18285p.f18319l = getIntent().getLongExtra("home_id", 0);
        Preconditions.checkArgument(this.f18285p.f18319l != 0);
    }

    protected final HomeActivityLoggerData mo1091k() {
        return new HomeActivityLoggerData();
    }

    public static void m22295s(HomeEditActivity homeEditActivity) {
        homeEditActivity.m22232o();
        Intent intent = new Intent(homeEditActivity, CityPickerActivity.class);
        intent.putExtra("extra_location", homeEditActivity.f18285p.f18313f);
        homeEditActivity.f18290u.a(intent, 1, homeEditActivity);
    }

    protected final void mo1088c(Bundle bundle) {
        Class cls = HomeEditActivity.class;
        m22289a((Object) this, (Context) this);
        this.f18289t.setOnClickListener(this.f18336B);
        this.f18288s.setOnClickListener(this.f18336B);
        if (bundle == null) {
            this.f18337C = ErrorState.NO_ERROR;
            m22297u();
            return;
        }
        Preconditions.checkArgument(bundle.containsKey("state_error_state"));
        Preconditions.checkArgument(bundle.containsKey("state_can_edit_name"));
        Preconditions.checkArgument(bundle.containsKey("state_original_name"));
        Preconditions.checkArgument(bundle.containsKey("state_original_city"));
        this.f18337C = ErrorState.values()[bundle.getInt("state_error_state")];
        this.f18287r.setEnabled(bundle.getBoolean("state_can_edit_name"));
        this.f18338D = bundle.getString("state_original_name");
        this.f18339E = (CityModel) FlatBufferModelHelper.a(bundle, "state_original_city");
        if (this.f18337C != ErrorState.NO_ERROR) {
            m22300x();
        }
    }

    protected final void mo1097r() {
        m22296t();
        super.mo1097r();
    }

    protected final void mo1095a(PhotoItem photoItem) {
        m22296t();
        super.mo1095a(photoItem);
    }

    private void m22296t() {
        if (this.f18285p.f18315h == null && this.f18285p.f18316i != null) {
            this.f18285p.f18317j = true;
        }
    }

    private void m22297u() {
        m22233p();
        HomeFetchRunner homeFetchRunner = this.f18342y;
        long j = this.f18285p.f18319l;
        FutureCallback futureCallback = this.f18341G;
        Preconditions.checkNotNull(Long.valueOf(j));
        Preconditions.checkNotNull(futureCallback);
        GraphQlQueryString homeResidenceQueryString = new HomeResidenceQueryString();
        homeResidenceQueryString.a("node", String.valueOf(j)).a("size", "320");
        homeFetchRunner.f18344a.a(GraphQLQueryExecutor.a(homeFetchRunner.f18345b.a(GraphQLRequest.a(homeResidenceQueryString))), futureCallback);
    }

    public static void m22298v(HomeEditActivity homeEditActivity) {
        homeEditActivity.f18292w.m22265w();
        homeEditActivity.setResult(-1, null);
        homeEditActivity.finish();
    }

    public static void m22291b(HomeEditActivity homeEditActivity, Throwable th) {
        homeEditActivity.m22234q();
        homeEditActivity.m22224b(true);
        try {
            throw th;
        } catch (HomeUpdateNameDeniedException e) {
            homeEditActivity.f18337C = ErrorState.HOME_NAME_CHANGE_DENIED_ERROR;
        } catch (HomeUpdateCityDeniedException e2) {
            homeEditActivity.f18337C = ErrorState.HOME_CITY_CHANGE_DENIED_ERROR;
        } catch (Throwable th2) {
            homeEditActivity.f18337C = ErrorState.HOME_UPDATE_ERROR;
        }
        homeEditActivity.m22300x();
    }

    public static void m22299w(HomeEditActivity homeEditActivity) {
        homeEditActivity.m22234q();
        homeEditActivity.f18337C = ErrorState.HOME_FETCH_ERROR;
        homeEditActivity.m22300x();
    }

    private void m22300x() {
        FbAlertDialogBuilder a;
        switch (this.f18337C) {
            case HOME_FETCH_ERROR:
                a = m22284a(getString(2131235156), getString(2131235290));
                a.a(2131235282, new C20024(this));
                a.b();
                return;
            case HOME_UPDATE_ERROR:
                a = m22284a(getString(2131235156), getString(2131235291));
                a.a(2131235282, null);
                a.b();
                return;
            case HOME_NAME_CHANGE_DENIED_ERROR:
                a = m22284a(getString(2131235314), getString(2131235313));
                a.a(2131235282, new C20035(this));
                a.b();
                return;
            case HOME_CITY_CHANGE_DENIED_ERROR:
                a = m22284a(getString(2131235315), getString(2131235316));
                a.a(2131235282, new C20046(this));
                a.b();
                return;
            default:
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state_can_edit_name", this.f18287r.isEnabled());
        bundle.putString("state_original_name", this.f18338D);
        FlatBufferModelHelper.a(bundle, "state_original_city", this.f18339E);
        bundle.putInt("state_error_state", this.f18337C.ordinal());
    }

    protected final void mo1092l() {
        m22224b(false);
        m22233p();
        HomeUpdateParams homeUpdateParams = new HomeUpdateParams(this.f18285p);
        HomeUpdateRunner homeUpdateRunner = this.f18343z;
        homeUpdateRunner.f18357a.a(new C20071(homeUpdateRunner, homeUpdateParams), this.f18340F);
    }

    private FbAlertDialogBuilder m22284a(String str, String str2) {
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(this);
        fbAlertDialogBuilder.a(str);
        fbAlertDialogBuilder.b(str2);
        return fbAlertDialogBuilder;
    }
}

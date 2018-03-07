package com.facebook.places.create.citypicker;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.FieldType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.create.citypicker.CitySearchResultsManager.FetchCityCallback;
import com.facebook.places.create.citypicker.graphql.PlaceCreationCityPickerGraphQL.SuggestedCitiesQueryString;
import com.facebook.places.create.citypicker.graphql.PlaceCreationCityPickerGraphQLModels.SuggestedCitiesQueryModel;
import com.facebook.places.create.citypicker.logger.CityPickerLogger;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory;
import com.facebook.places.create.citypicker.logger.CityPickerLoggerFactory.Type;
import com.facebook.places.create.citypicker.logger.CityPickerPlaceCreationLoggerProvider;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.Builder;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.LocationModel;
import com.facebook.places.pickers.PlaceContentPickerFragment;
import com.facebook.places.pickers.PlaceContentPickerHeaderView;
import com.facebook.places.pickers.PlaceContentPickerRow;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: see_more_session_start_time_ms */
public class NewCityPickerFragment extends PlaceContentPickerFragment<CheckinPlace> {
    @Inject
    CitySearchResultsManager f3580a;
    public Optional<? extends CheckinPlace> al;
    public Location am;
    private final C04551 an = new C04551(this);
    @Inject
    public TasksManager f3581b;
    @Inject
    GraphQLQueryExecutor f3582c;
    @Inject
    PlaceCreationCityAtLocationQuery f3583d;
    @Inject
    CityPickerLoggerFactory f3584e;
    private CityPickerLogger f3585f;
    public boolean f3586g;
    public boolean f3587h;
    public Optional<? extends CheckinPlace> f3588i;

    /* compiled from: see_more_session_start_time_ms */
    public interface CitySelectedListener extends Serializable {
        void mo190a(NewCityPickerFragment newCityPickerFragment, CheckinPlaceModel checkinPlaceModel, boolean z);
    }

    /* compiled from: see_more_session_start_time_ms */
    public class C04551 {
        public final /* synthetic */ NewCityPickerFragment f3575a;

        C04551(NewCityPickerFragment newCityPickerFragment) {
            this.f3575a = newCityPickerFragment;
        }
    }

    /* compiled from: see_more_session_start_time_ms */
    public class C04562 implements Callable<ListenableFuture<SuggestedCitiesQueryModel>> {
        final /* synthetic */ NewCityPickerFragment f3576a;

        public Object call() {
            return GraphQLQueryExecutor.a(this.f3576a.f3582c.a(GraphQLRequest.a(new SuggestedCitiesQueryString())));
        }

        public C04562(NewCityPickerFragment newCityPickerFragment) {
            this.f3576a = newCityPickerFragment;
        }
    }

    /* compiled from: see_more_session_start_time_ms */
    public class C04573 extends AbstractDisposableFutureCallback<SuggestedCitiesQueryModel> {
        final /* synthetic */ NewCityPickerFragment f3577a;

        public C04573(NewCityPickerFragment newCityPickerFragment) {
            this.f3577a = newCityPickerFragment;
        }

        protected final void m3489a(Object obj) {
            SuggestedCitiesQueryModel suggestedCitiesQueryModel = (SuggestedCitiesQueryModel) obj;
            this.f3577a.f3586g = true;
            if (suggestedCitiesQueryModel.m3528a() == null || suggestedCitiesQueryModel.m3528a().m3521k() == null) {
                this.f3577a.f3588i = Absent.INSTANCE;
            } else {
                NewCityPickerFragment newCityPickerFragment = this.f3577a;
                Builder builder = new Builder();
                builder.f = suggestedCitiesQueryModel.m3528a().m3520j();
                builder = builder;
                builder.h = suggestedCitiesQueryModel.m3528a().m3522l();
                builder = builder;
                LocationModel.Builder builder2 = new LocationModel.Builder();
                builder2.a = suggestedCitiesQueryModel.m3528a().m3521k().m3509a();
                builder2 = builder2;
                builder2.b = suggestedCitiesQueryModel.m3528a().m3521k().m3513j();
                builder.g = builder2.a();
                newCityPickerFragment.f3588i = Optional.of(builder.a());
            }
            this.f3577a.at();
        }

        protected final void m3490a(Throwable th) {
        }
    }

    /* compiled from: see_more_session_start_time_ms */
    public class C04584 implements Callable<ListenableFuture<Optional<? extends CheckinPlace>>> {
        final /* synthetic */ NewCityPickerFragment f3578a;

        public C04584(NewCityPickerFragment newCityPickerFragment) {
            this.f3578a = newCityPickerFragment;
        }

        public Object call() {
            return this.f3578a.f3583d.m3505a(this.f3578a.am);
        }
    }

    /* compiled from: see_more_session_start_time_ms */
    public class C04595 extends AbstractDisposableFutureCallback<Optional<? extends CheckinPlace>> {
        final /* synthetic */ NewCityPickerFragment f3579a;

        public C04595(NewCityPickerFragment newCityPickerFragment) {
            this.f3579a = newCityPickerFragment;
        }

        protected final void m3491a(Object obj) {
            Optional optional = (Optional) obj;
            this.f3579a.f3587h = true;
            this.f3579a.al = optional;
            this.f3579a.at();
        }

        protected final void m3492a(Throwable th) {
        }
    }

    public static void m3495a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NewCityPickerFragment) obj).m3494a(CitySearchResultsManager.m3484a(fbInjector), TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), PlaceCreationCityAtLocationQuery.m3504b(fbInjector), new CityPickerLoggerFactory((CityPickerPlaceCreationLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CityPickerPlaceCreationLoggerProvider.class)));
    }

    protected final void m3499a(Object obj) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) obj;
        if (!TextUtils.isEmpty(au())) {
            this.f3585f.mo193a(FieldType.PLACE_CITY, Long.parseLong(checkinPlaceModel.cf_()), au());
        } else if (this.f3588i.isPresent() && this.f3588i.get() == checkinPlaceModel) {
            this.f3585f.mo192a(FieldType.PLACE_CITY, Long.parseLong(checkinPlaceModel.cf_()));
        } else if (this.al.isPresent() && this.al.get() == checkinPlaceModel) {
            this.f3585f.mo191a(Long.parseLong(checkinPlaceModel.cf_()));
        }
        CitySelectedListener citySelectedListener = (CitySelectedListener) this.s.getSerializable("extra_city_selected_listener");
        boolean z = this.al.isPresent() && this.al.get() == checkinPlaceModel;
        citySelectedListener.mo190a(this, checkinPlaceModel, z);
    }

    private void m3494a(CitySearchResultsManager citySearchResultsManager, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, PlaceCreationCityAtLocationQuery placeCreationCityAtLocationQuery, CityPickerLoggerFactory cityPickerLoggerFactory) {
        this.f3580a = citySearchResultsManager;
        this.f3581b = tasksManager;
        this.f3582c = graphQLQueryExecutor;
        this.f3583d = placeCreationCityAtLocationQuery;
        this.f3584e = cityPickerLoggerFactory;
    }

    public static NewCityPickerFragment m3493a(Location location, boolean z, boolean z2, CitySelectedListener citySelectedListener, boolean z3, Type type, @Nullable Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_current_location", location);
        bundle.putBoolean("extra_is_checking_into_city", z);
        bundle.putBoolean("extra_show_current_location", z2);
        bundle.putSerializable("extra_city_selected_listener", citySelectedListener);
        bundle.putBoolean("extra_show_null_state_header", z3);
        bundle.putSerializable("extra_logger_type", type);
        bundle.putParcelable("extra_logger_params", parcelable);
        NewCityPickerFragment newCityPickerFragment = new NewCityPickerFragment();
        newCityPickerFragment.g(bundle);
        return newCityPickerFragment;
    }

    public final void m3502c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NewCityPickerFragment.class;
        m3495a(this, getContext());
        this.f3588i = Absent.INSTANCE;
        this.al = Absent.INSTANCE;
        this.am = (Location) this.s.getParcelable("extra_current_location");
        this.f3585f = this.f3584e.m3539a((Type) this.s.getSerializable("extra_logger_type"), this.s.getParcelable("extra_logger_params"));
    }

    public final void m3496G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -137937986);
        super.G();
        CitySearchResultsManager citySearchResultsManager = this.f3580a;
        citySearchResultsManager.f3566e.add(this.an);
        HasTitleBar hasTitleBar = (HasTitleBar) Preconditions.checkNotNull(a(HasTitleBar.class));
        hasTitleBar.y_(2131235265);
        hasTitleBar.kg_();
        if (!this.f3588i.isPresent()) {
            this.f3586g = false;
            this.f3581b.a(Integer.valueOf(1), new C04562(this), new C04573(this));
        }
        this.f3587h = false;
        this.f3581b.a(Integer.valueOf(2), new C04584(this), new C04595(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1837206774, a);
    }

    public final void m3497H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1194217525);
        super.H();
        CitySearchResultsManager citySearchResultsManager = this.f3580a;
        citySearchResultsManager.f3566e.remove(this.an);
        this.f3581b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -882226037, a);
    }

    protected final ImmutableList<PlaceContentPickerRow<CheckinPlace>> m3498a(String str) {
        ImmutableList immutableList;
        FetchCityParam fetchCityParam = new FetchCityParam(str, this.am);
        ImmutableList.Builder builder = ImmutableList.builder();
        CitySearchResultsManager citySearchResultsManager = this.f3580a;
        if (citySearchResultsManager.f3562a.isPresent() && fetchCityParam.f3567a.equals(((FetchCityParam) citySearchResultsManager.f3562a.get()).f3567a) && fetchCityParam.f3568b.equals(((FetchCityParam) citySearchResultsManager.f3562a.get()).f3568b)) {
            immutableList = (ImmutableList) citySearchResultsManager.f3563b.or(RegularImmutableList.a);
        } else {
            citySearchResultsManager.f3564c.m3487a();
            citySearchResultsManager.f3562a = Optional.of(fetchCityParam);
            citySearchResultsManager.f3563b = Absent.INSTANCE;
            citySearchResultsManager.f3564c.m3488a(fetchCityParam, new FetchCityCallback(citySearchResultsManager));
            immutableList = RegularImmutableList.a;
        }
        ImmutableList immutableList2 = immutableList;
        int size = immutableList2.size();
        for (int i = 0; i < size; i++) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) immutableList2.get(i);
            builder.c(PlaceContentPickerRow.a(checkinPlaceModel, Long.parseLong(checkinPlaceModel.cf_()), checkinPlaceModel.j()).a());
        }
        return builder.b();
    }

    protected final ImmutableList<PlaceContentPickerRow<CheckinPlace>> m3500b() {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (this.al.isPresent() && this.s.getBoolean("extra_show_current_location")) {
            Object b;
            boolean z = this.s.getBoolean("extra_is_checking_into_city");
            String j = z ? ((CheckinPlaceModel) this.al.get()).j() : b(2131235268);
            if (z) {
                b = b(2131235270);
            } else {
                String b2 = b(2131235269);
            }
            PlaceContentPickerRow.Builder a = PlaceContentPickerRow.a(this.al.get(), Long.parseLong(((CheckinPlaceModel) this.al.get()).cf_()), j);
            a.d = 2131625485;
            a = a;
            a.e = Optional.of(b);
            a = a;
            a.f = 2130841955;
            builder.c(a.a());
        }
        if (this.f3588i.isPresent() && this.s.getBoolean("extra_show_current_location")) {
            a = PlaceContentPickerRow.a(this.f3588i.get(), Long.parseLong(((CheckinPlaceModel) this.f3588i.get()).cf_()), ((CheckinPlaceModel) this.f3588i.get()).j());
            a.f = 2130842680;
            builder.c(a.a());
        }
        return builder.b();
    }

    protected final String m3503e() {
        return b(2131235267);
    }

    protected final Optional<PlaceContentPickerHeaderView> aq() {
        PlaceContentPickerHeaderView placeContentPickerHeaderView = new PlaceContentPickerHeaderView(getContext());
        placeContentPickerHeaderView.setImage(2130838301);
        placeContentPickerHeaderView.setTitle(2131235278);
        placeContentPickerHeaderView.setSubTitle(2131235279);
        placeContentPickerHeaderView.setSectionTitle(2131235277);
        return Optional.of(placeContentPickerHeaderView);
    }

    protected final boolean ar() {
        return (this.f3587h && this.f3586g) ? false : true;
    }

    protected final boolean as() {
        CitySearchResultsManager citySearchResultsManager = this.f3580a;
        boolean z = citySearchResultsManager.f3562a.isPresent() && !citySearchResultsManager.f3563b.isPresent();
        return z;
    }

    protected final CharSequence m3501b(String str) {
        return a(2131235280, new Object[]{str});
    }
}

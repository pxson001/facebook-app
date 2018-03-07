package com.facebook.places.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.FieldType;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams.Addresses;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams.Addresses.City;
import com.facebook.graphql.calls.GeocodeAddressInputQueryParams.Addresses.Street;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.model.PageTopic;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.places.checkin.analytics.PlacePickerSessionData;
import com.facebook.places.create.PlaceCreationAddressToLocationFetcher.C19741;
import com.facebook.places.create.PlaceCreationBellerophonController.C19751;
import com.facebook.places.create.citypicker.PlaceCreationCityAtLocationQuery;
import com.facebook.places.create.graphql.GeocodeAddress.GeocodeAddressToLocationString;
import com.facebook.places.create.network.PlaceCreationParams;
import com.facebook.places.create.network.PlaceCreationRunner;
import com.facebook.places.create.network.PlacePinAppId;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: centerHorizontal */
public class NewPlaceCreationFormFragment extends FbFragment {
    @Inject
    PlaceCreationBellerophonController f18174a;
    private Optional<PlacePinAppId> aA;
    private Location aB;
    private final DedupCallbacks aC = new DedupCallbacks(this);
    private final StaticMapOptions aD = new StaticMapOptions("new_place_creation");
    @Inject
    PlaceCreationCityAtLocationQuery al;
    private PlacePickerSessionData am;
    public List<Long> an;
    @Nullable
    private ProgressDialog ao;
    public ViewContainer ap;
    private PageTopic aq;
    private CheckinPlaceModel ar;
    private Optional<Uri> as;
    private PlaceCreationState at;
    public Location au;
    public Optional<? extends CheckinPlace> av;
    public Optional<ListenableFuture<Optional<Location>>> aw;
    public Optional<Location> ax;
    public CrowdsourcingContext ay;
    private boolean az;
    @Inject
    public SecureContextHelper f18175b;
    @Inject
    PlaceCreationRunner f18176c;
    @Inject
    PlaceCreationErrorHandler f18177d;
    @Inject
    PlaceCreationAddressToLocationFetcher f18178e;
    @Inject
    @ForUiThread
    Executor f18179f;
    @Inject
    public TasksManager f18180g;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f18181h;
    @Inject
    public PlaceCreationAnalyticsLogger f18182i;

    /* compiled from: centerHorizontal */
    class C19621 extends OnToolbarButtonListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18141a;

        C19621(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18141a = newPlaceCreationFormFragment;
        }

        public final void m22132a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18141a.f18182i.b(this.f18141a.ay);
            NewPlaceCreationFormFragment.aF(this.f18141a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19632 implements OnClickListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18142a;

        public C19632(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18142a = newPlaceCreationFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 613238615);
            Intent putExtra = new Intent(this.f18142a.getContext(), PlaceCreationCategoryPickerActivity.class).putExtra("logger_type", Type.PLACE_CREATION_LOGGER).putExtra("logger_params", this.f18142a.ay);
            this.f18142a.f18182i.b(this.f18142a.ay, PlaceCreationAnalyticsLogger.View.CATEGORY_PICKER);
            this.f18142a.f18175b.a(putExtra, 2, this.f18142a);
            Logger.a(2, EntryType.UI_INPUT_END, 1116990550, a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19643 implements OnClickListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18143a;

        public C19643(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18143a = newPlaceCreationFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 772670917);
            Intent intent = new Intent(this.f18143a.getContext(), PlaceCreationCityPickerActivity.class);
            intent.putExtra("current_location", this.f18143a.au);
            intent.putExtra("crowdsourcing_context", this.f18143a.s.getParcelable("crowdsourcing_context"));
            this.f18143a.f18182i.b(this.f18143a.ay, PlaceCreationAnalyticsLogger.View.CITY_PICKER);
            this.f18143a.f18175b.a(intent, 3, this.f18143a);
            Logger.a(2, EntryType.UI_INPUT_END, -761894770, a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19654 implements OnCheckedChangeListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18144a;

        public C19654(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18144a = newPlaceCreationFormFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z && this.f18144a.av.isPresent()) {
                NewPlaceCreationFormFragment.m22139a(this.f18144a, (CheckinPlaceModel) this.f18144a.av.get());
            }
            this.f18144a.f18182i.a(this.f18144a.ay);
            NewPlaceCreationFormFragment.ax(this.f18144a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19665 implements OnClickListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18145a;

        public C19665(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18145a = newPlaceCreationFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1888932266);
            this.f18145a.f18175b.a(SimplePickerIntent.a(this.f18145a.getContext(), new Builder(SimplePickerSource.PLACE_CREATION).k().h().i().a(Action.LAUNCH_GENERIC_CROPPER)), 4, this.f18145a);
            this.f18145a.f18182i.c(this.f18145a.ay);
            this.f18145a.f18182i.b(this.f18145a.ay, PlaceCreationAnalyticsLogger.View.PHOTO_PICKER);
            Logger.a(2, EntryType.UI_INPUT_END, -2040321534, a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19686 implements OnClickListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18147a;

        /* compiled from: centerHorizontal */
        class C19671 implements OnMenuItemClickListener {
            final /* synthetic */ C19686 f18146a;

            C19671(C19686 c19686) {
                this.f18146a = c19686;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                NewPlaceCreationFormFragment.m22140a(this.f18146a.f18147a, (Optional) Absent.INSTANCE);
                this.f18146a.f18147a.f18182i.a(this.f18146a.f18147a.ay, FieldType.PAGE_PHOTO);
                return true;
            }
        }

        public C19686(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18147a = newPlaceCreationFormFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 967216903);
            FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18147a.getContext());
            figPopoverMenuWindow.c().a(2131235288).setIcon(2130841203).setOnMenuItemClickListener(new C19671(this));
            figPopoverMenuWindow.f(this.f18147a.ap.f18172j);
            Logger.a(2, EntryType.UI_INPUT_END, -446091027, a);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19708 implements Callable<ListenableFuture<Optional<? extends CheckinPlace>>> {
        final /* synthetic */ NewPlaceCreationFormFragment f18150a;

        public C19708(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18150a = newPlaceCreationFormFragment;
        }

        public Object call() {
            return this.f18150a.al.m3505a(this.f18150a.au);
        }
    }

    /* compiled from: centerHorizontal */
    public class C19719 extends AbstractDisposableFutureCallback<Optional<? extends CheckinPlace>> {
        final /* synthetic */ NewPlaceCreationFormFragment f18151a;

        public C19719(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18151a = newPlaceCreationFormFragment;
        }

        protected final void m22133a(Object obj) {
            this.f18151a.av = (Optional) obj;
            if (this.f18151a.av.isPresent() && this.f18151a.ap.f18168f.isChecked()) {
                NewPlaceCreationFormFragment.m22139a(this.f18151a, (CheckinPlaceModel) this.f18151a.av.get());
            }
        }

        protected final void m22134a(Throwable th) {
        }
    }

    /* compiled from: centerHorizontal */
    public class AddressTextWatcher implements TextWatcher {
        final /* synthetic */ NewPlaceCreationFormFragment f18154a;

        /* compiled from: centerHorizontal */
        class C19721 implements Callable<Void> {
            final /* synthetic */ AddressTextWatcher f18152a;

            C19721(AddressTextWatcher addressTextWatcher) {
                this.f18152a = addressTextWatcher;
            }

            public Object call() {
                Thread.sleep(1000);
                return null;
            }
        }

        /* compiled from: centerHorizontal */
        class C19732 extends AbstractDisposableFutureCallback<Void> {
            final /* synthetic */ AddressTextWatcher f18153a;

            C19732(AddressTextWatcher addressTextWatcher) {
                this.f18153a = addressTextWatcher;
            }

            protected final void m22135a(Object obj) {
                NewPlaceCreationFormFragment.ax(this.f18153a.f18154a);
            }

            protected final void m22136a(Throwable th) {
            }
        }

        public AddressTextWatcher(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18154a = newPlaceCreationFormFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            NewPlaceCreationFormFragment.ay(this.f18154a);
            this.f18154a.f18180g.a(Integer.valueOf(1), this.f18154a.f18181h.a(new C19721(this)), new C19732(this));
        }
    }

    /* compiled from: centerHorizontal */
    class CreatePlaceCallback implements FutureCallback<Long> {
        final /* synthetic */ NewPlaceCreationFormFragment f18155a;

        public CreatePlaceCallback(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18155a = newPlaceCreationFormFragment;
        }

        public void onSuccess(Object obj) {
            Long l = (Long) obj;
            this.f18155a.f18182i.c(this.f18155a.ay, l.longValue());
            Intent intent = new Intent();
            CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
            builder.f = String.valueOf(l);
            builder = builder;
            builder.h = NewPlaceCreationFormFragment.aC(this.f18155a).f18244a;
            FlatBufferModelHelper.a(intent, "extra_place", builder.a());
            this.f18155a.o().setResult(-1, intent);
            this.f18155a.o().finish();
        }

        public void onFailure(Throwable th) {
            NewPlaceCreationFormFragment.aI(this.f18155a);
            this.f18155a.f18177d.m22182a(th, new ErrorHandlerFormDelegate(this.f18155a));
        }
    }

    /* compiled from: centerHorizontal */
    public class DedupCallbacks {
        public final /* synthetic */ NewPlaceCreationFormFragment f18156a;

        public DedupCallbacks(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18156a = newPlaceCreationFormFragment;
        }

        public final void m22137b() {
            NewPlaceCreationFormFragment.aH(this.f18156a);
            NewPlaceCreationFormFragment.aG(this.f18156a);
        }
    }

    /* compiled from: centerHorizontal */
    public class ErrorHandlerFormDelegate {
        public final /* synthetic */ NewPlaceCreationFormFragment f18157a;

        public ErrorHandlerFormDelegate(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
            this.f18157a = newPlaceCreationFormFragment;
        }
    }

    /* compiled from: centerHorizontal */
    public class LogTextFieldEditedListener implements OnFocusChangeListener {
        final /* synthetic */ NewPlaceCreationFormFragment f18158a;
        private final FieldType f18159b;
        private String f18160c;

        public LogTextFieldEditedListener(NewPlaceCreationFormFragment newPlaceCreationFormFragment, EditText editText, FieldType fieldType) {
            this.f18158a = newPlaceCreationFormFragment;
            this.f18160c = editText.getText().toString();
            this.f18159b = fieldType;
        }

        public void onFocusChange(View view, boolean z) {
            String obj = ((EditText) view).getText().toString();
            if (!(z || this.f18160c.equals(obj))) {
                this.f18158a.f18182i.a(this.f18158a.ay, this.f18159b);
            }
            this.f18160c = obj;
        }
    }

    /* compiled from: centerHorizontal */
    public class NameTextWatcher implements TextWatcher {
        final /* synthetic */ NewPlaceCreationFormFragment f18161a;
        private String f18162b;

        public NameTextWatcher(NewPlaceCreationFormFragment newPlaceCreationFormFragment, CharSequence charSequence) {
            this.f18161a = newPlaceCreationFormFragment;
            this.f18162b = charSequence.toString();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (NewPlaceCreationFormFragment.m22143b(this.f18162b) != NewPlaceCreationFormFragment.m22143b(editable)) {
                NewPlaceCreationFormFragment.aB(this.f18161a);
            }
            this.f18162b = editable.toString();
        }
    }

    /* compiled from: centerHorizontal */
    public class ViewContainer {
        public final EditText f18163a;
        public final EditText f18164b;
        public final EditText f18165c;
        public final FbTextView f18166d;
        public final FbTextView f18167e;
        public final CheckBox f18168f;
        public final FbStaticMapView f18169g;
        public final ImageView f18170h;
        public final ImageView f18171i;
        public final View f18172j;
        final /* synthetic */ NewPlaceCreationFormFragment f18173k;

        public ViewContainer(NewPlaceCreationFormFragment newPlaceCreationFormFragment, View view) {
            this.f18173k = newPlaceCreationFormFragment;
            this.f18163a = (EditText) FindViewUtil.b(view, 2131562901);
            this.f18164b = (EditText) FindViewUtil.b(view, 2131564223);
            this.f18165c = (EditText) FindViewUtil.b(view, 2131564225);
            this.f18166d = (FbTextView) FindViewUtil.b(view, 2131562902);
            this.f18167e = (FbTextView) FindViewUtil.b(view, 2131564224);
            this.f18168f = (CheckBox) FindViewUtil.b(view, 2131564227);
            this.f18169g = (FbStaticMapView) FindViewUtil.b(view, 2131564226);
            this.f18170h = (ImageView) FindViewUtil.b(view, 2131564220);
            this.f18171i = (ImageView) FindViewUtil.b(view, 2131564222);
            this.f18172j = FindViewUtil.b(view, 2131564221);
        }
    }

    public static void m22142a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NewPlaceCreationFormFragment) obj).m22141a(PlaceCreationBellerophonController.m22153b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PlaceCreationRunner.m22330b(injectorLike), PlaceCreationErrorHandler.m22174a(injectorLike), new PlaceCreationAddressToLocationFetcher(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PlaceCreationAnalyticsLogger.a(injectorLike), PlaceCreationCityAtLocationQuery.m3504b(injectorLike));
    }

    private void m22141a(PlaceCreationBellerophonController placeCreationBellerophonController, SecureContextHelper secureContextHelper, PlaceCreationRunner placeCreationRunner, PlaceCreationErrorHandler placeCreationErrorHandler, PlaceCreationAddressToLocationFetcher placeCreationAddressToLocationFetcher, Executor executor, TasksManager tasksManager, ListeningExecutorService listeningExecutorService, PlaceCreationAnalyticsLogger placeCreationAnalyticsLogger, PlaceCreationCityAtLocationQuery placeCreationCityAtLocationQuery) {
        this.f18174a = placeCreationBellerophonController;
        this.f18175b = secureContextHelper;
        this.f18176c = placeCreationRunner;
        this.f18177d = placeCreationErrorHandler;
        this.f18178e = placeCreationAddressToLocationFetcher;
        this.f18179f = executor;
        this.f18180g = tasksManager;
        this.f18181h = listeningExecutorService;
        this.f18182i = placeCreationAnalyticsLogger;
        this.al = placeCreationCityAtLocationQuery;
    }

    public final void m22149c(Bundle bundle) {
        super.c(bundle);
        Class cls = NewPlaceCreationFormFragment.class;
        m22142a((Object) this, getContext());
        this.am = (PlacePickerSessionData) this.s.getParcelable("place_picker_session_data");
        this.at = (PlaceCreationState) this.s.getParcelable("initial_place_state");
        this.au = (Location) this.s.getParcelable("user_current_location");
        this.ay = (CrowdsourcingContext) this.s.getParcelable("crowdsourcing_context");
        boolean z = (bundle == null || bundle.getLongArray("duplicate_override_ids") == null) ? false : true;
        this.an = z ? Lists.a(Longs.a(bundle.getLongArray("duplicate_override_ids"))) : Lists.a();
        this.aw = Absent.INSTANCE;
        this.ax = Absent.INSTANCE;
        this.av = Absent.INSTANCE;
        this.az = false;
    }

    public final void m22145H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -84477843);
        super.H();
        this.az = aE();
        aI(this);
        this.f18174a.f18191c.m22171a();
        this.f18176c.f18388a.c();
        ay(this);
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1621230512, a);
    }

    public final void m22150e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("place", aC(this));
        bundle.putLongArray("duplicate_override_ids", Longs.a(this.an));
        String str = "paused_create_request";
        boolean z = this.az || aE();
        bundle.putBoolean(str, z);
    }

    public final View m22146a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 109720221);
        View inflate = layoutInflater.inflate(2130905443, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1700904429, a);
        return inflate;
    }

    public final void m22144G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -575869923);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) Preconditions.checkNotNull(a(HasTitleBar.class));
        hasTitleBar.y_(2131235263);
        hasTitleBar.a(new C19621(this));
        aB(this);
        ax(this);
        if (this.az) {
            aF(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 498398420, a);
    }

    public final void m22148a(View view, Bundle bundle) {
        super.a(view, bundle);
        PlaceCreationState placeCreationState = (bundle == null || bundle.getParcelable("place") == null) ? this.at : (PlaceCreationState) bundle.getParcelable("place");
        this.ap = new ViewContainer(this, view);
        this.aq = placeCreationState.f18245b;
        this.ar = placeCreationState.f18248e;
        this.ap.f18163a.setText(placeCreationState.f18244a);
        this.ap.f18164b.setText(placeCreationState.f18247d);
        this.ap.f18165c.setText(placeCreationState.f18249f);
        this.ap.f18166d.setText(placeCreationState.f18245b.displayName);
        this.ap.f18167e.setText(placeCreationState.f18248e.j());
        this.ap.f18168f.setChecked(placeCreationState.f18250g);
        m22140a(this, placeCreationState.f18251h);
        this.ap.f18166d.setOnClickListener(new C19632(this));
        this.ap.f18167e.setOnClickListener(new C19643(this));
        this.ap.f18168f.setOnCheckedChangeListener(new C19654(this));
        this.ap.f18163a.setOnFocusChangeListener(new LogTextFieldEditedListener(this, this.ap.f18163a, FieldType.PAGE_NAME));
        this.ap.f18163a.addTextChangedListener(new NameTextWatcher(this, this.ap.f18163a.getText()));
        this.ap.f18164b.addTextChangedListener(new AddressTextWatcher(this));
        this.ap.f18164b.setOnFocusChangeListener(new LogTextFieldEditedListener(this, this.ap.f18164b, FieldType.PLACE_STREET_ADDRESS));
        this.ap.f18165c.addTextChangedListener(new AddressTextWatcher(this));
        this.ap.f18165c.setOnFocusChangeListener(new LogTextFieldEditedListener(this, this.ap.f18165c, FieldType.PLACE_ZIP_CODE));
        this.ap.f18170h.setOnClickListener(new C19665(this));
        this.ap.f18172j.setOnClickListener(new C19686(this));
        final View e = e(2131564219);
        e(2131564218).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NewPlaceCreationFormFragment f18149b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1043662741);
                e.requestFocus();
                KeyboardUtils.a(this.f18149b.ao());
                Logger.a(2, EntryType.UI_INPUT_END, 289931046, a);
            }
        });
        this.f18180g.a(Integer.valueOf(2), new C19708(this), new C19719(this));
        ax(this);
        if (bundle != null && bundle.getBoolean("paused_create_request")) {
            aF(this);
        }
    }

    public static void m22140a(NewPlaceCreationFormFragment newPlaceCreationFormFragment, Optional optional) {
        newPlaceCreationFormFragment.as = optional;
        if (optional.isPresent()) {
            newPlaceCreationFormFragment.ap.f18170h.setVisibility(8);
            newPlaceCreationFormFragment.ap.f18172j.setVisibility(0);
            newPlaceCreationFormFragment.ap.f18171i.setImageURI((Uri) optional.get());
            return;
        }
        newPlaceCreationFormFragment.ap.f18170h.setVisibility(0);
        newPlaceCreationFormFragment.ap.f18172j.setVisibility(8);
        newPlaceCreationFormFragment.ap.f18171i.setImageURI(null);
    }

    public static void ax(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        Object obj;
        int i;
        if (newPlaceCreationFormFragment.ap.f18168f.isChecked()) {
            newPlaceCreationFormFragment.aA = Absent.INSTANCE;
            newPlaceCreationFormFragment.aB = newPlaceCreationFormFragment.au;
            obj = 1;
            i = 13;
        } else if (newPlaceCreationFormFragment.ax.isPresent()) {
            newPlaceCreationFormFragment.aA = Optional.of(PlacePinAppId.GEOCODED_ADDRESS);
            newPlaceCreationFormFragment.aB = (Location) newPlaceCreationFormFragment.ax.get();
            int i2 = 1;
            i = 13;
        } else {
            Object obj2;
            if (TextUtils.isEmpty(newPlaceCreationFormFragment.ap.f18164b.getText())) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                newPlaceCreationFormFragment.aA();
            }
            i = 10;
            obj = null;
            newPlaceCreationFormFragment.aA = Optional.of(PlacePinAppId.CITY_CENTER);
            newPlaceCreationFormFragment.aB = new Location("");
            if (newPlaceCreationFormFragment.ar.cg_() != null) {
                newPlaceCreationFormFragment.aB.setLatitude(newPlaceCreationFormFragment.ar.cg_().a());
                newPlaceCreationFormFragment.aB.setLongitude(newPlaceCreationFormFragment.ar.cg_().b());
            }
        }
        newPlaceCreationFormFragment.ap.f18169g.a(obj != null ? newPlaceCreationFormFragment.jW_().getDrawable(2130841143) : null, 0.5f, 0.93f);
        newPlaceCreationFormFragment.ap.f18169g.setMapOptions(newPlaceCreationFormFragment.aD.a().a(newPlaceCreationFormFragment.aB).a(i));
    }

    public static void ay(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        if (newPlaceCreationFormFragment.aw.isPresent()) {
            ((ListenableFuture) newPlaceCreationFormFragment.aw.get()).cancel(true);
            newPlaceCreationFormFragment.aw = Absent.INSTANCE;
        }
        newPlaceCreationFormFragment.f18180g.c(Integer.valueOf(1));
        newPlaceCreationFormFragment.ax = Absent.INSTANCE;
    }

    private void aA() {
        if (!this.aw.isPresent()) {
            PlaceCreationAddressToLocationFetcher placeCreationAddressToLocationFetcher = this.f18178e;
            String obj = this.ap.f18164b.getText().toString();
            long parseLong = Long.parseLong(this.ar.cf_());
            this.ap.f18165c.getText().toString();
            Addresses addresses = new Addresses();
            Street street = new Street();
            street.a("name", obj);
            addresses.a("street", street);
            GraphQlCallInput graphQlCallInput = addresses;
            City city = new City();
            city.a("id", Long.toString(parseLong));
            graphQlCallInput.a("city", city);
            ListenableFuture a = Futures.a(placeCreationAddressToLocationFetcher.f18184a.a(GraphQLRequest.a((GeocodeAddressToLocationString) new GeocodeAddressToLocationString().a("addresses", new GeocodeAddressInputQueryParams().a(ImmutableList.of(graphQlCallInput))))), new C19741(placeCreationAddressToLocationFetcher), placeCreationAddressToLocationFetcher.f18185b);
            this.aw = Optional.of(a);
            this.ax = Absent.INSTANCE;
            Futures.a(a, new AbstractDisposableFutureCallback<Optional<Location>>(this) {
                final /* synthetic */ NewPlaceCreationFormFragment f18136a;

                {
                    this.f18136a = r1;
                }

                protected final void m22130a(Object obj) {
                    this.f18136a.ax = (Optional) obj;
                    NewPlaceCreationFormFragment.ax(this.f18136a);
                    this.f18136a.aw = Absent.INSTANCE;
                }

                protected final void m22131a(Throwable th) {
                    this.f18136a.aw = Absent.INSTANCE;
                }
            }, this.f18179f);
        }
    }

    public static void aB(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        boolean z;
        HasTitleBar hasTitleBar = (HasTitleBar) Preconditions.checkNotNull(newPlaceCreationFormFragment.a(HasTitleBar.class));
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = newPlaceCreationFormFragment.b(2131235283);
        TitleBarButtonSpec.Builder builder = a;
        if (m22143b(newPlaceCreationFormFragment.ap.f18163a.getText())) {
            z = false;
        } else {
            z = true;
        }
        builder.d = z;
        hasTitleBar.a(builder.a());
    }

    public static PlaceCreationState aC(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        PlaceCreationState placeCreationState = newPlaceCreationFormFragment.at;
        PlaceCreationState.Builder builder = new PlaceCreationState.Builder(placeCreationState.f18244a, placeCreationState.f18245b, placeCreationState.f18246c, placeCreationState.f18252i, placeCreationState.f18248e);
        builder.f18238d = placeCreationState.f18247d;
        builder = builder.m22183a(placeCreationState.f18248e);
        builder.f18240f = placeCreationState.f18249f;
        PlaceCreationState.Builder builder2 = builder;
        builder2.f18235a = newPlaceCreationFormFragment.ap.f18163a.getText().toString();
        builder2 = builder2;
        builder2.f18238d = newPlaceCreationFormFragment.ap.f18164b.getText().toString();
        builder2 = builder2;
        builder2.f18240f = newPlaceCreationFormFragment.ap.f18165c.getText().toString();
        builder2 = builder2;
        builder2.f18241g = newPlaceCreationFormFragment.ap.f18168f.isChecked();
        builder2 = builder2;
        builder2.f18236b = newPlaceCreationFormFragment.aq;
        builder2 = builder2.m22183a(newPlaceCreationFormFragment.ar);
        builder2.f18237c = newPlaceCreationFormFragment.aB;
        builder2 = builder2;
        builder2.f18243i = newPlaceCreationFormFragment.aA;
        builder2 = builder2;
        builder2.f18242h = newPlaceCreationFormFragment.as;
        return builder2.m22184a();
    }

    private boolean aE() {
        return this.ao != null && this.ao.isShowing();
    }

    public static void aF(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        if (!newPlaceCreationFormFragment.aE()) {
            aH(newPlaceCreationFormFragment);
            PlaceCreationState aC = aC(newPlaceCreationFormFragment);
            PlaceCreationDupSearchParams placeCreationDupSearchParams = new PlaceCreationDupSearchParams();
            placeCreationDupSearchParams.f18210a = aC.f18244a;
            placeCreationDupSearchParams.f18212c = (int) aC.f18245b.id;
            placeCreationDupSearchParams.f18211b = aC.f18246c;
            placeCreationDupSearchParams.f18214e = aC.f18248e.j();
            placeCreationDupSearchParams.f18213d = aC.f18247d;
            PlaceCreationBellerophonController placeCreationBellerophonController = newPlaceCreationFormFragment.f18174a;
            AnonymousClass11 anonymousClass11 = new Object(newPlaceCreationFormFragment) {
                public final /* synthetic */ NewPlaceCreationFormFragment f18137a;

                {
                    this.f18137a = r1;
                }
            };
            DedupCallbacks dedupCallbacks = newPlaceCreationFormFragment.aC;
            PlacePickerSessionData placePickerSessionData = newPlaceCreationFormFragment.am;
            if (placeCreationBellerophonController.f18192d.a(520, false)) {
                placeCreationBellerophonController.f18190b.f18119a = new BellerophonLoggerData(placePickerSessionData);
                placeCreationBellerophonController.f18190b.m22102b();
                placeCreationBellerophonController.f18191c.m22171a();
                placeCreationBellerophonController.f18191c.m22172a(placeCreationDupSearchParams, new C19751(placeCreationBellerophonController, dedupCallbacks, anonymousClass11));
            } else {
                dedupCallbacks.m22137b();
            }
        }
    }

    public final void m22147a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 1:
                PlaceCreationBellerophonController.m22151a(this.aC, i2, intent);
                return;
            case 2:
                if (i2 == -1) {
                    PageTopic pageTopic = (PageTopic) intent.getParcelableExtra("category");
                    this.aq = pageTopic;
                    this.ap.f18166d.setText(pageTopic.displayName);
                    this.f18182i.a(this.ay, FieldType.PLACE_CATEGORY);
                    if (pageTopic.id == 197289820310880L) {
                        this.f18182i.b(this.ay, PlaceCreationAnalyticsLogger.View.HOME_CREATION);
                        intent.putExtra("create_home_from_place_creation", true);
                        o().setResult(-1, intent);
                        o().finish();
                        return;
                    }
                }
                this.f18182i.b(this.ay, PlaceCreationAnalyticsLogger.View.FORM);
                return;
            case 3:
                if (i2 == -1) {
                    CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "picked_city");
                    this.ap.f18168f.setChecked(intent.getBooleanExtra("is_currently_there", false));
                    m22139a(this, checkinPlaceModel);
                    ay(this);
                    ax(this);
                    this.f18182i.a(this.ay, FieldType.PLACE_CITY);
                }
                this.f18182i.b(this.ay, PlaceCreationAnalyticsLogger.View.FORM);
                return;
            case 4:
                if (i2 == -1) {
                    final EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
                    new FbAlertDialogBuilder(getContext()).b(2131235208).a(true).a(2131230730, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ NewPlaceCreationFormFragment f18140b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            NewPlaceCreationFormFragment.m22140a(this.f18140b, Optional.of(editGalleryIpcBundle.b));
                            this.f18140b.f18182i.a(this.f18140b.ay, FieldType.PAGE_PHOTO);
                        }
                    }).b(2131230727, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ NewPlaceCreationFormFragment f18138a;

                        {
                            this.f18138a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.f18138a.f18182i.d(this.f18138a.ay);
                        }
                    }).a().show();
                }
                this.f18182i.b(this.ay, PlaceCreationAnalyticsLogger.View.FORM);
                return;
            default:
                return;
        }
    }

    public static void m22139a(NewPlaceCreationFormFragment newPlaceCreationFormFragment, CheckinPlaceModel checkinPlaceModel) {
        newPlaceCreationFormFragment.ar = checkinPlaceModel;
        newPlaceCreationFormFragment.ap.f18167e.setText(newPlaceCreationFormFragment.ar.j());
    }

    public static void aG(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        PhotoItem a;
        PlaceCreationState aC = aC(newPlaceCreationFormFragment);
        String str = aC.f18244a;
        Location location = aC.f18246c;
        Optional optional = aC.f18252i;
        if (newPlaceCreationFormFragment.as.isPresent()) {
            a = new PhotoItemBuilder().b(((Uri) newPlaceCreationFormFragment.as.get()).getPath()).d("image/jpeg").a();
        } else {
            a = null;
        }
        newPlaceCreationFormFragment.f18176c.m22331a(PlaceCreationParams.m22326a(str, location, optional, a, ImmutableList.of(Long.valueOf(aC.f18245b.id)), aC.f18248e.j(), Long.parseLong(aC.f18248e.cf_()), aC.f18247d, aC.f18249f, null, null, null, false, PlaceCreationParams.m22328b(), newPlaceCreationFormFragment.an), new CreatePlaceCallback(newPlaceCreationFormFragment));
    }

    public static void m22138a(NewPlaceCreationFormFragment newPlaceCreationFormFragment, long j, String str, PlaceCreationAnalyticsLogger.View view) {
        newPlaceCreationFormFragment.f18182i.a(newPlaceCreationFormFragment.ay, view, j);
        Intent intent = new Intent();
        CheckinPlaceModel.Builder builder = new CheckinPlaceModel.Builder();
        builder.f = String.valueOf(j);
        builder = builder;
        builder.h = str;
        FlatBufferModelHelper.a(intent, "selected_existing_place", builder.a());
        newPlaceCreationFormFragment.o().setResult(-1, intent);
        newPlaceCreationFormFragment.o().finish();
    }

    public static void aH(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        if (!newPlaceCreationFormFragment.aE()) {
            newPlaceCreationFormFragment.ao = new ProgressDialog(newPlaceCreationFormFragment.getContext());
            newPlaceCreationFormFragment.ao.d = 0;
            newPlaceCreationFormFragment.ao.a(newPlaceCreationFormFragment.a(2131235272));
            newPlaceCreationFormFragment.ao.a(true);
            newPlaceCreationFormFragment.ao.setCancelable(false);
            newPlaceCreationFormFragment.ao.show();
        }
    }

    public static void aI(NewPlaceCreationFormFragment newPlaceCreationFormFragment) {
        if (newPlaceCreationFormFragment.ao != null) {
            newPlaceCreationFormFragment.ao.dismiss();
            newPlaceCreationFormFragment.ao = null;
        }
    }

    public static boolean m22143b(@Nullable CharSequence charSequence) {
        return charSequence == null || TextUtils.getTrimmedLength(charSequence) == 0;
    }
}

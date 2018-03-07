package com.facebook.places.pagetopics;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.PageTopic;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLogger;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory;
import com.facebook.places.pagetopics.logging.PlaceCategoryPickerLoggerFactory.Type;
import com.facebook.places.pagetopics.logging.PlaceCreationCategoryPickerLoggerProvider;
import com.facebook.places.pagetopics.stores.PlaceCategoriesChildrenStore;
import com.facebook.places.pagetopics.stores.PlaceCategoriesSearchResultsStore;
import com.facebook.places.pagetopics.stores.PlacePickerCategory;
import com.facebook.places.pickers.PlaceContentPickerFragment;
import com.facebook.places.pickers.PlaceContentPickerHeaderView;
import com.facebook.places.pickers.PlaceContentPickerRow;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.Serializable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: formatted_datetime_for_display */
public class PlaceCategoryPickerFragment extends PlaceContentPickerFragment<PlacePickerCategory> {
    @Inject
    public PlaceCategoriesSearchResultsStore f14748a;
    private final C09491 al = new C09491(this);
    private final Function<PlacePickerCategory, Optional<String>> am = new C09502(this);
    private final Function<PlacePickerCategory, Optional<String>> an = new C09513(this);
    @Inject
    public PlaceCategoriesChildrenStore f14749b;
    @Inject
    public PlaceCategoryPickerLoggerFactory f14750c;
    public Optional<PlacePickerCategory> f14751d;
    private Listener f14752e;
    private PlaceCategoryPickerLogger f14753f;
    public int f14754g = 1;
    private Optional<String> f14755h;
    private boolean f14756i;

    /* compiled from: formatted_datetime_for_display */
    public interface Listener extends Serializable {
        void mo1162a(PlaceCategoryPickerFragment placeCategoryPickerFragment, PageTopic pageTopic);
    }

    /* compiled from: formatted_datetime_for_display */
    public class C09491 {
        final /* synthetic */ PlaceCategoryPickerFragment f14744a;

        C09491(PlaceCategoryPickerFragment placeCategoryPickerFragment) {
            this.f14744a = placeCategoryPickerFragment;
        }

        public final void m22307a() {
            this.f14744a.at();
        }
    }

    /* compiled from: formatted_datetime_for_display */
    class C09502 implements Function<PlacePickerCategory, Optional<String>> {
        final /* synthetic */ PlaceCategoryPickerFragment f14745a;

        public Object apply(Object obj) {
            return Absent.INSTANCE;
        }

        C09502(PlaceCategoryPickerFragment placeCategoryPickerFragment) {
            this.f14745a = placeCategoryPickerFragment;
        }
    }

    /* compiled from: formatted_datetime_for_display */
    class C09513 implements Function<PlacePickerCategory, Optional<String>> {
        final /* synthetic */ PlaceCategoryPickerFragment f14746a;

        C09513(PlaceCategoryPickerFragment placeCategoryPickerFragment) {
            this.f14746a = placeCategoryPickerFragment;
        }

        public Object apply(Object obj) {
            PlacePickerCategory placePickerCategory = (PlacePickerCategory) obj;
            if (this.f14746a.f14751d.isPresent() && ((PlacePickerCategory) this.f14746a.f14751d.get()).f14793a.equals(placePickerCategory.f14793a)) {
                return Absent.INSTANCE;
            }
            SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" · ");
            ImmutableList immutableList = placePickerCategory.f14796d;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                separatedSpannableStringBuilder.a((String) immutableList.get(i));
            }
            return Optional.of(separatedSpannableStringBuilder.toString());
        }
    }

    public static void m22319a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PlaceCategoryPickerFragment placeCategoryPickerFragment = (PlaceCategoryPickerFragment) obj;
        PlaceCategoriesSearchResultsStore a = PlaceCategoriesSearchResultsStore.m22443a(injectorLike);
        PlaceCategoriesChildrenStore a2 = PlaceCategoriesChildrenStore.m22434a(injectorLike);
        PlaceCategoryPickerLoggerFactory placeCategoryPickerLoggerFactory = new PlaceCategoryPickerLoggerFactory((PlaceCreationCategoryPickerLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlaceCreationCategoryPickerLoggerProvider.class));
        placeCategoryPickerFragment.f14748a = a;
        placeCategoryPickerFragment.f14749b = a2;
        placeCategoryPickerFragment.f14750c = placeCategoryPickerLoggerFactory;
    }

    protected final void mo1166a(Object obj) {
        PlacePickerCategory placePickerCategory = (PlacePickerCategory) obj;
        if (TextUtils.isEmpty(au())) {
            this.f14753f.mo1173a(placePickerCategory.m22450a());
        } else {
            this.f14753f.mo1174a(placePickerCategory.m22450a(), au());
        }
        Object obj2 = 1;
        Object obj3 = (this.f14751d.isPresent() && placePickerCategory.f14793a == ((PlacePickerCategory) this.f14751d.get()).f14793a) ? 1 : null;
        if (!(this.f14754g == 1 && obj3 == null && !placePickerCategory.f14796d.isEmpty())) {
            obj2 = null;
        }
        if (obj2 != null) {
            this.D.a().a(null).a(2130968752, 2130968616, 2130968726, 2130968767).b(this.H, m22317a(Optional.of(placePickerCategory), this.f14752e, this.s.getBoolean("extra_show_null_state_header", false), Type.valueOf(this.s.getString("extra_logger_type")), this.s.getParcelable("extra_logger_params"))).b();
        } else {
            this.f14752e.mo1162a(this, placePickerCategory.m22450a());
        }
    }

    public static PlaceCategoryPickerFragment m22317a(Optional<PlacePickerCategory> optional, @Nonnull Listener listener, boolean z, Type type, @Nullable Parcelable parcelable) {
        PlaceCategoryPickerFragment placeCategoryPickerFragment = new PlaceCategoryPickerFragment();
        Bundle bundle = new Bundle();
        if (optional.isPresent()) {
            bundle.putParcelable("extra_parent_category", (Parcelable) optional.get());
        }
        bundle.putSerializable("extra_listener", listener);
        bundle.putString("extra_logger_type", type.name());
        bundle.putParcelable("extra_logger_params", parcelable);
        bundle.putBoolean("extra_show_null_state_header", z);
        placeCategoryPickerFragment.g(bundle);
        return placeCategoryPickerFragment;
    }

    public final void m22326c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PlaceCategoryPickerFragment.class;
        m22319a((Object) this, getContext());
        this.f14751d = Optional.fromNullable((PlacePickerCategory) this.s.getParcelable("extra_parent_category"));
        this.f14752e = (Listener) this.s.getSerializable("extra_listener");
        this.f14753f = this.f14750c.m22419a(Type.valueOf(this.s.getString("extra_logger_type")), this.s.getParcelable("extra_logger_params"));
        this.f14755h = Absent.INSTANCE;
        this.f14756i = false;
    }

    public final void mo1163G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1885991353);
        super.mo1163G();
        HasTitleBar hasTitleBar = (HasTitleBar) Preconditions.checkNotNull(a(HasTitleBar.class));
        if (this.f14751d.isPresent()) {
            this.f14753f.mo1176b(((PlacePickerCategory) this.f14751d.get()).m22450a());
            hasTitleBar.a_(((PlacePickerCategory) this.f14751d.get()).f14795c);
        } else {
            hasTitleBar.y_(2131235264);
        }
        hasTitleBar.kg_();
        this.f14748a.m22431a(this.al);
        this.f14749b.m22431a(this.al);
        LogUtils.f(2056114402, a);
    }

    public final void mo1164H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1021139140);
        super.mo1164H();
        this.f14748a.m22433b(this.al);
        this.f14749b.m22433b(this.al);
        aw();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1485052589, a);
    }

    protected final String mo1172e() {
        return b(2131235266);
    }

    protected final ImmutableList<PlaceContentPickerRow<PlacePickerCategory>> mo1170b() {
        Iterable b;
        this.f14754g = 1;
        if (this.f14751d.isPresent()) {
            b = ImmutableList.builder().c(this.f14751d.get()).b(this.f14749b.m22440a((PlacePickerCategory) this.f14751d.get())).b();
        } else {
            b = this.f14748a.m22448a("");
        }
        return m22318a(b, this.an);
    }

    protected final ImmutableList<PlaceContentPickerRow<PlacePickerCategory>> mo1165a(String str) {
        this.f14754g = 2;
        Iterable a = this.f14748a.m22448a(str);
        if (a.isEmpty() && !as()) {
            av();
        }
        return m22318a(a, this.am);
    }

    protected final Optional<PlaceContentPickerHeaderView> aq() {
        if (this.f14751d.isPresent()) {
            return Absent.INSTANCE;
        }
        PlaceContentPickerHeaderView placeContentPickerHeaderView = new PlaceContentPickerHeaderView(getContext());
        placeContentPickerHeaderView.setImage(2130838299);
        placeContentPickerHeaderView.setTitle(2131235274);
        placeContentPickerHeaderView.setSubTitle(2131235275);
        placeContentPickerHeaderView.setSectionTitle(2131235273);
        return Optional.of(placeContentPickerHeaderView);
    }

    protected final boolean ar() {
        return this.f14751d.isPresent() ? this.f14749b.f14786d.b().contains(Integer.valueOf(1)) : this.f14748a.m22449a();
    }

    protected final boolean as() {
        return this.f14748a.m22449a();
    }

    protected final CharSequence mo1171b(String str) {
        return a(2131235276, new Object[]{str});
    }

    private void av() {
        if (!this.f14755h.isPresent() || au().length() >= ((String) this.f14755h.get()).length()) {
            this.f14755h = Optional.of(au());
            this.f14756i = false;
            return;
        }
        aw();
    }

    private void aw() {
        if (this.f14755h.isPresent() && !this.f14756i) {
            this.f14753f.mo1175a((String) this.f14755h.get());
            this.f14756i = true;
        }
    }

    private static ImmutableList<PlaceContentPickerRow<PlacePickerCategory>> m22318a(Iterable<PlacePickerCategory> iterable, Function<PlacePickerCategory, Optional<String>> function) {
        Builder builder = ImmutableList.builder();
        for (PlacePickerCategory placePickerCategory : iterable) {
            PlaceContentPickerRow.Builder a = PlaceContentPickerRow.m22455a(placePickerCategory, placePickerCategory.f14794b, placePickerCategory.f14795c);
            a.f14809e = (Optional) function.apply(placePickerCategory);
            builder.c(a.m22454a());
        }
        return builder.b();
    }
}

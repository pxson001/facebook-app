package com.facebook.adinterfaces.ui.selector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQL.FetchPageTargetingTypeaheadLocationQueryString;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadMethod;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadMethod.C25471;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet.Builder;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown image format %s */
public class LocationTargetingFragment extends BaseTargetingSelectorFragment<GeoLocationModel> {
    @Inject
    public FetchPageTargetingTypeaheadMethod f23228a;
    private ArrayList<GeoLocationModel> f23229b;
    private String f23230c;

    /* compiled from: Unknown image format %s */
    class C27401 implements Function<GeoLocationModel, String> {
        final /* synthetic */ LocationTargetingFragment f23219a;

        C27401(LocationTargetingFragment locationTargetingFragment) {
            this.f23219a = locationTargetingFragment;
        }

        public Object apply(Object obj) {
            return ((GeoLocationModel) obj).m23443j();
        }
    }

    /* compiled from: Unknown image format %s */
    class C27412 implements Function<LocationToken, String> {
        final /* synthetic */ LocationTargetingFragment f23220a;

        C27412(LocationTargetingFragment locationTargetingFragment) {
            this.f23220a = locationTargetingFragment;
        }

        public Object apply(Object obj) {
            return ((LocationToken) obj).b();
        }
    }

    /* compiled from: Unknown image format %s */
    class C27423 implements OnClickListener {
        final /* synthetic */ LocationTargetingFragment f23221a;

        C27423(LocationTargetingFragment locationTargetingFragment) {
            this.f23221a = locationTargetingFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: Unknown image format %s */
    /* synthetic */ class C27445 {
        static final /* synthetic */ int[] f23225a = new int[GraphQLAdGeoLocationType.values().length];

        static {
            try {
                f23225a[GraphQLAdGeoLocationType.COUNTRY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23225a[GraphQLAdGeoLocationType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23225a[GraphQLAdGeoLocationType.CITY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: Unknown image format %s */
    public class LocationToken extends BaseToken<GeoLocationModel> {
        public static final Comparator<LocationToken> f23226e = new C27451();
        public final GeoLocationModel f23227f;

        /* compiled from: Unknown image format %s */
        final class C27451 implements Comparator<LocationToken> {
            C27451() {
            }

            public final int compare(Object obj, Object obj2) {
                LocationToken locationToken = (LocationToken) obj;
                LocationToken locationToken2 = (LocationToken) obj2;
                Preconditions.checkNotNull(locationToken);
                Preconditions.checkNotNull(locationToken2);
                return locationToken.b().compareTo(locationToken2.b());
            }
        }

        public LocationToken(GeoLocationModel geoLocationModel) {
            super(Type.SUGGESTION);
            Preconditions.checkNotNull(geoLocationModel);
            this.f23227f = geoLocationModel;
        }

        public final /* synthetic */ Object m25201d() {
            return this.f23227f;
        }

        public final String m25200b() {
            return this.f23227f.m23440c();
        }

        public final int m25202e() {
            return -1;
        }

        public final int m25203f() {
            return -1;
        }

        public final int m25204g() {
            return -1;
        }

        public final int m25205h() {
            return -1;
        }

        public final String m25206i() {
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof LocationToken)) {
                return false;
            }
            GeoLocationModel geoLocationModel = ((LocationToken) obj).f23227f;
            return obj == this || (this.f23227f.mM_() == geoLocationModel.mM_() && Objects.equal(this.f23227f.m23439b(), geoLocationModel.m23439b()) && Objects.equal(this.f23227f.m23443j(), geoLocationModel.m23443j()) && Objects.equal(this.f23227f.mL_(), geoLocationModel.mL_()));
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f23227f.mL_(), this.f23227f.m23443j(), this.f23227f.m23439b(), this.f23227f.mM_()});
        }
    }

    public static void m25208a(Object obj, Context context) {
        ((LocationTargetingFragment) obj).f23228a = FetchPageTargetingTypeaheadMethod.m24218b(FbInjector.get(context));
    }

    protected final BaseToken mo1038a(Object obj) {
        return new LocationToken((GeoLocationModel) obj);
    }

    public final void mo1046d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -781393199);
        super.mo1046d(bundle);
        if (bundle == null) {
            bundle = this.s;
        }
        if (bundle != null) {
            this.f23229b = (ArrayList) FlatBufferModelHelper.b(bundle, "defaultLocations");
            if (this.f23229b != null) {
                this.f23230c = Joiner.on(", ").join(Iterables.a(this.f23229b, new C27401(this)));
            }
        }
        LogUtils.f(-2142172161, a);
    }

    public final void mo1042c(Bundle bundle) {
        super.mo1042c(bundle);
        Class cls = LocationTargetingFragment.class;
        m25208a((Object) this, getContext());
    }

    public final void mo1047e(Bundle bundle) {
        if (!(this.f23229b == null || this.f23229b.isEmpty())) {
            FlatBufferModelHelper.a(bundle, "defaultLocations", new ArrayList(this.f23229b));
        }
        super.mo1047e(bundle);
    }

    protected final List<? extends SectionedListSection<? extends BaseToken<GeoLocationModel>>> mo1040a(List<GeoLocationModel> list) {
        Builder b = ImmutableSortedSet.b(LocationToken.f23226e);
        Builder b2 = ImmutableSortedSet.b(LocationToken.f23226e);
        Builder b3 = ImmutableSortedSet.b(LocationToken.f23226e);
        for (GeoLocationModel geoLocationModel : list) {
            LocationToken locationToken = new LocationToken(geoLocationModel);
            switch (C27445.f23225a[geoLocationModel.mM_().ordinal()]) {
                case 1:
                    b.d(locationToken);
                    break;
                case 2:
                    b2.d(locationToken);
                    break;
                case 3:
                    b3.d(locationToken);
                    break;
                default:
                    break;
            }
        }
        return ImmutableList.of(new ImmutableSectionedListSection(b(2131234080), ImmutableList.copyOf(b.c())), new ImmutableSectionedListSection(b(2131234081), ImmutableList.copyOf(b2.c())), new ImmutableSectionedListSection(b(2131234082), ImmutableList.copyOf(b3.c())));
    }

    protected final String mo1041b() {
        return StringFormatUtil.formatStrLocaleSafe(b(2131234076), this.f23230c);
    }

    protected final String mo1043e() {
        return b(2131234075);
    }

    @Nullable
    protected final ListenableFuture<List<GeoLocationModel>> mo1039a(String str) {
        FetchPageTargetingTypeaheadMethod fetchPageTargetingTypeaheadMethod = this.f23228a;
        Preconditions.checkNotNull(str);
        GraphQlQueryString fetchPageTargetingTypeaheadLocationQueryString = new FetchPageTargetingTypeaheadLocationQueryString();
        fetchPageTargetingTypeaheadLocationQueryString.a("query", str).a("types", ImmutableList.of(GraphQLAdGeoLocationType.COUNTRY.toString(), GraphQLAdGeoLocationType.REGION.toString(), GraphQLAdGeoLocationType.CITY.toString()));
        return Futures.a(fetchPageTargetingTypeaheadMethod.f22380a.a(GraphQLRequest.a(fetchPageTargetingTypeaheadLocationQueryString)), new C25471(fetchPageTargetingTypeaheadMethod), MoreExecutors.a());
    }

    protected final ArrayList<?> as() {
        ArrayList<?> as = super.as();
        return !as.isEmpty() ? as : this.f23229b;
    }

    protected final void mo1044a(final BaseToken<GeoLocationModel> baseToken) {
        List<BaseToken> at = at();
        if (at.size() < 25 && !at.contains(baseToken)) {
            LocationToken locationToken = (LocationToken) baseToken;
            final Object arrayList = new ArrayList();
            for (BaseToken baseToken2 : at) {
                Object obj;
                GeoLocationModel geoLocationModel = (GeoLocationModel) baseToken2.d();
                GeoLocationModel geoLocationModel2 = locationToken.f23227f;
                if (Objects.equal(geoLocationModel2.m23439b(), geoLocationModel.m23439b()) && (geoLocationModel2.mM_() == GraphQLAdGeoLocationType.COUNTRY || geoLocationModel.mM_() == GraphQLAdGeoLocationType.COUNTRY || Objects.equal(geoLocationModel2.mL_(), geoLocationModel.m23445l()) || Objects.equal(geoLocationModel.mL_(), geoLocationModel2.m23445l()))) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add((LocationToken) baseToken2);
                }
            }
            if (arrayList.isEmpty()) {
                super.mo1044a((BaseToken) baseToken);
                return;
            }
            new AlertDialog.Builder(getContext()).a(false).b(StringFormatUtil.formatStrLocaleSafe(b(2131234079), Joiner.on("; ").join(Iterables.a(arrayList, new C27412(this))), baseToken.b())).a(2131230726, new OnClickListener(this) {
                final /* synthetic */ LocationTargetingFragment f23224c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    super.mo1044a(baseToken);
                    for (BaseToken b : arrayList) {
                        this.f23224c.m25181b(b);
                    }
                }
            }).b(2131230727, new C27423(this)).b();
        }
    }
}

package com.facebook.composer.minutiae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.MinutiaeTaggableObjectsModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.model.MinutiaeObjectsData;
import com.facebook.composer.minutiae.perf.MinutiaeObjectPickerPerformanceLogger;
import com.facebook.composer.minutiae.protocol.MinutiaeObjectsDataFetcher;
import com.facebook.composer.minutiae.view.MinutiaeBaseRowView;
import com.facebook.composer.minutiae.view.MinutiaeObjectRowView;
import com.facebook.composer.minutiae.view.MinutiaeTaggableObjectViewController;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.sectionedadapter.SectionedAdapterForListView.SectionAdapter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: total_visits_label */
public class MinutiaeTaggableObjectAdapter extends SectionAdapter {
    @VisibleForTesting
    protected static final Object f1391a = new Object();
    public MinutiaeTaggableActivity f1392b;
    private final Context f1393c;
    private final LayoutInflater f1394d;
    private final MinutiaeTaggableObjectFragment f1395e;
    private final MinutiaeTaggableObjectViewController f1396f;
    public final MinutiaeObjectPickerPerformanceLogger f1397g;
    public final MinutiaeObjectsData f1398h;
    private final MinutiaeObjectsDataFetcher f1399i;
    public final AbstractFbErrorReporter f1400j;
    public final Map<Object, ItemBindedCallback> f1401k = Maps.c();
    private TaggableObjectEdgeModel f1402l;
    private String f1403m;

    /* compiled from: total_visits_label */
    public enum ViewType {
        ITEM_VIEW,
        FREE_FORM_VIEW,
        LOADING_INDICATOR
    }

    public MinutiaeTaggableObjectAdapter(Context context, MinutiaeObjectsDataFetcher minutiaeObjectsDataFetcher, AbstractFbErrorReporter abstractFbErrorReporter, MinutiaeObjectPickerPerformanceLogger minutiaeObjectPickerPerformanceLogger, MinutiaeTaggableObjectFragment minutiaeTaggableObjectFragment) {
        this.f1393c = context;
        this.f1394d = LayoutInflater.from(context);
        this.f1395e = minutiaeTaggableObjectFragment;
        this.f1399i = minutiaeObjectsDataFetcher;
        this.f1400j = abstractFbErrorReporter;
        this.f1397g = minutiaeObjectPickerPerformanceLogger;
        this.f1398h = new MinutiaeObjectsData();
        this.f1396f = new MinutiaeTaggableObjectViewController();
    }

    public final void m1476a(@Nullable String str, MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel, @Nullable TaggableObjectEdgeModel taggableObjectEdgeModel, String str2, boolean z) {
        MinutiaeObjectsData minutiaeObjectsData = this.f1398h;
        minutiaeObjectsData.a.clear();
        minutiaeObjectsData.b.clear();
        minutiaeObjectsData.a(minutiaeTaggableObjectsModel, str2);
        this.f1403m = str;
        this.f1402l = taggableObjectEdgeModel;
        this.f1396f.f1889a = z;
        AdapterDetour.a(this, -1028023687);
    }

    public final View m1474a(int i, ViewGroup viewGroup) {
        switch (ViewType.values()[i]) {
            case ITEM_VIEW:
            case FREE_FORM_VIEW:
                return new MinutiaeObjectRowView(this.f1393c);
            case LOADING_INDICATOR:
                return this.f1394d.inflate(2130903701, viewGroup, false);
            default:
                throw new IllegalArgumentException("Unknown view type," + i);
        }
    }

    public final void m1475a(int i, Object obj, final View view, int i2, ViewGroup viewGroup) {
        ViewType viewType = ViewType.values()[i2];
        if (this.f1401k.size() > 0 && this.f1401k.containsKey(obj)) {
            C01261 c01261 = (C01261) this.f1401k.get(obj);
            c01261.f1387a.f1389b.f1397g.m1660c();
            c01261.f1387a.f1389b.f1397g.m1661d();
            this.f1401k.remove(obj);
        }
        switch (viewType) {
            case ITEM_VIEW:
                this.f1396f.m1844a((MinutiaeBaseRowView) view, (TaggableObjectEdgeModel) obj, this.f1392b, false, this.f1395e);
                return;
            case FREE_FORM_VIEW:
                this.f1396f.m1844a((MinutiaeBaseRowView) view, (TaggableObjectEdgeModel) obj, this.f1392b, true, this.f1395e);
                return;
            case LOADING_INDICATOR:
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ MinutiaeTaggableObjectAdapter f1386b;

                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.f1386b.f1397g.m1660c();
                        return true;
                    }
                });
                return;
            default:
                throw new IllegalArgumentException("Unknown view type," + i2);
        }
    }

    public int getCount() {
        int b = this.f1398h.b();
        if (this.f1402l != null) {
            return b + 1;
        }
        if (this.f1398h.a()) {
            return b + 1;
        }
        return b;
    }

    public Object getItem(int i) {
        if (m1470b(i)) {
            return this.f1402l;
        }
        if (m1471c(i)) {
            return f1391a;
        }
        return this.f1398h.a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return m1469a(i).ordinal();
    }

    private ViewType m1469a(int i) {
        if (m1470b(i)) {
            return ViewType.FREE_FORM_VIEW;
        }
        if (m1471c(i)) {
            return ViewType.LOADING_INDICATOR;
        }
        return ViewType.ITEM_VIEW;
    }

    private boolean m1470b(int i) {
        return this.f1402l != null && i == getCount() - 1;
    }

    private boolean m1471c(int i) {
        return this.f1402l == null && this.f1398h.a() && i == getCount() - 1;
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public final void m1478b(MinutiaeTaggableActivity minutiaeTaggableActivity) {
        final String uuid = SafeUUIDGenerator.a().toString();
        MinutiaeObjectsDataFetcher minutiaeObjectsDataFetcher = this.f1399i;
        String str = this.f1403m;
        MinutiaeObjectsData minutiaeObjectsData = this.f1398h;
        minutiaeObjectsDataFetcher.m1684a(minutiaeTaggableActivity, str, uuid, minutiaeObjectsData.a() ? minutiaeObjectsData.c.a() : null, new AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableObjectsQueryModel>>(this) {
            public final /* synthetic */ MinutiaeTaggableObjectAdapter f1389b;

            /* compiled from: total_visits_label */
            public class C01261 {
                public final /* synthetic */ C01272 f1387a;

                C01261(C01272 c01272) {
                    this.f1387a = c01272;
                }
            }

            protected final void m1467a(Object obj) {
                MinutiaeTaggableObjectsModel p = ((FetchTaggableObjectsQueryModel) ((GraphQLResult) obj).e).p();
                this.f1389b.f1398h.a(p, uuid);
                if (this.f1389b.f1397g.f1604a.h(4325387, "minutiae_object_picker_time_to_scroll_load")) {
                    this.f1389b.f1397g.m1661d();
                } else if (!(p.a() == null || p.a().isEmpty())) {
                    this.f1389b.f1401k.put(p.a().get(0), new C01261(this));
                }
                AdapterDetour.a(this.f1389b, 1549799753);
            }

            protected final void m1468a(Throwable th) {
                this.f1389b.f1400j.a("minutiae_taggable_object_fetch_fail", th);
            }
        });
    }

    public final int m1473a(TaggableObjectEdgeModel taggableObjectEdgeModel) {
        return m1479b(taggableObjectEdgeModel) ? m1477b() : this.f1398h.a.indexOf(taggableObjectEdgeModel);
    }

    public final boolean m1479b(@Nullable TaggableObjectEdgeModel taggableObjectEdgeModel) {
        return taggableObjectEdgeModel != null && this.f1402l == taggableObjectEdgeModel;
    }

    public final int m1472a() {
        return this.f1398h.a() ? getCount() - 1 : -1;
    }

    public final int m1477b() {
        return this.f1398h.b();
    }

    @Nullable
    public final String m1481c(TaggableObjectEdgeModel taggableObjectEdgeModel) {
        String str;
        MinutiaeObjectsData minutiaeObjectsData = this.f1398h;
        if (minutiaeObjectsData.b.containsKey(taggableObjectEdgeModel)) {
            str = (String) minutiaeObjectsData.b.get(taggableObjectEdgeModel);
        } else {
            str = null;
        }
        return str;
    }

    @Nullable
    public final String m1480c() {
        return this.f1398h.d;
    }

    public final ImmutableList<String> m1482d() {
        Builder builder = new Builder();
        for (int i = 0; i < this.f1398h.b(); i++) {
            builder.c(this.f1398h.a(i).af_().d());
        }
        if (this.f1402l != null) {
            builder.c("0");
        }
        return builder.b();
    }
}

package com.facebook.timeline.aboutpage.sections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodeIdFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineCollectionsSectionViewQueryModel.CollectionsModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.aboutpage.views.header.CollectionSectionHeader;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: MINUTIAE_NOT_ALLOWED */
public class CollectionsSectionAdapter extends BaseAdapter implements Adapter {
    public static final int f13527a;
    public static final int f13528b = (f13534s + 1);
    public static final int f13529c = (f13534s + 2);
    private static final Class<?> f13530d = CollectionsSectionAdapter.class;
    private static final Object f13531p = new Object();
    private static final Object f13532q = new Object();
    private static final Object f13533r = new Object();
    private static final int f13534s;
    private final Context f13535e;
    private final CollectionsViewFactory f13536f;
    private final ListCollectionItemDataFactory f13537g;
    private final CollectionStyleMapper f13538h;
    private final CollectionsViewFramer f13539i;
    private final CollectionsAnalyticsLogger f13540j;
    private final ProfileViewerContext f13541k;
    private final CollectionsUriIntentBuilder f13542l;
    private final LayoutInflater f13543m;
    private CollectionsAppSection f13544n;
    private final ArrayList<CollectionItemData> f13545o = new ArrayList();
    private boolean f13546t;

    static {
        int length = GraphQLTimelineAppCollectionStyle.values().length;
        f13534s = length;
        f13527a = length;
    }

    @Inject
    public CollectionsSectionAdapter(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, CollectionsViewFactory collectionsViewFactory, ListCollectionItemDataFactory listCollectionItemDataFactory, CollectionStyleMapper collectionStyleMapper, CollectionsViewFramer collectionsViewFramer, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, CollectionsUriIntentBuilder collectionsUriIntentBuilder, @Assisted LayoutInflater layoutInflater) {
        this.f13535e = context;
        this.f13541k = profileViewerContext;
        this.f13536f = collectionsViewFactory;
        this.f13537g = listCollectionItemDataFactory;
        this.f13538h = collectionStyleMapper;
        this.f13539i = collectionsViewFramer;
        this.f13540j = collectionsAnalyticsLogger;
        this.f13542l = collectionsUriIntentBuilder;
        this.f13543m = layoutInflater;
        this.f13546t = true;
    }

    public final void mo405a(boolean z) {
        this.f13546t = z;
        AdapterDetour.a(this, -483419373);
    }

    public final void m14757a(FetchTimelineCollectionsSectionViewQueryModel fetchTimelineCollectionsSectionViewQueryModel) {
        if (this.f13544n != fetchTimelineCollectionsSectionViewQueryModel && fetchTimelineCollectionsSectionViewQueryModel != null) {
            this.f13544n = fetchTimelineCollectionsSectionViewQueryModel;
            this.f13545o.clear();
            AdapterDetour.a(this, 462341230);
            if (fetchTimelineCollectionsSectionViewQueryModel.m14715j() != null && fetchTimelineCollectionsSectionViewQueryModel.m14715j().m14700a() != null) {
                m14754a(fetchTimelineCollectionsSectionViewQueryModel.m14715j());
            }
        }
    }

    private static boolean m14756c(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions) {
        Object obj;
        if (collectionWithItemsAndSuggestions.nU_() == null || collectionWithItemsAndSuggestions.nU_().m14346b().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            obj = (collectionWithItemsAndSuggestions.mo404q() == null || collectionWithItemsAndSuggestions.mo404q().m14409a().isEmpty()) ? null : 1;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    private void m14754a(CollectionsModel collectionsModel) {
        ImmutableList a = collectionsModel.m14700a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsAndSuggestions) a.get(i);
            if (m14756c(collectionWithItemsAndSuggestions)) {
                String str;
                ImmutableList a2;
                GraphQLTimelineAppCollectionStyle a3 = this.f13538h.m14916a(collectionWithItemsAndSuggestions.mo396d());
                if (collectionWithItemsAndSuggestions.nU_().m14342a() == 0) {
                    str = null;
                } else {
                    str = String.valueOf(collectionWithItemsAndSuggestions.nU_().m14342a());
                }
                ItemData itemData = new ItemData(collectionWithItemsAndSuggestions.mo395c(), collectionWithItemsAndSuggestions.nS_(), null, str, this.f13544n.mo388b(), collectionWithItemsAndSuggestions.mo402o(), collectionWithItemsAndSuggestions, null, null, null, CollectionsUriIntentBuilder.m13783a((CollectionsNodeIdFields) collectionWithItemsAndSuggestions, this.f13541k.a(), this.f13544n.mo389c()), null, this.f13542l.m13786a(collectionWithItemsAndSuggestions, this.f13544n.nP_(), a3), this.f13544n.nP_(), this.f13541k, false);
                if (GraphQLTimelineAppCollectionStyle.LIST.equals(a3)) {
                    a2 = ListCollectionItemDataFactory.m14998a(collectionWithItemsAndSuggestions, itemData.f13794n);
                } else {
                    a2 = itemData.f13787g.nU_().m14346b();
                }
                this.f13545o.add(new CollectionItemData(collectionWithItemsAndSuggestions, itemData, a3, a2));
            }
        }
        AdapterDetour.a(this, -618946140);
    }

    public int getCount() {
        if (this.f13545o == null || StringUtil.a(this.f13544n.mo390d())) {
            return 0;
        }
        int size = this.f13545o.size() + 1;
        if (this.f13545o.isEmpty() || this.f13546t) {
            return size + 1;
        }
        return size;
    }

    public Object getItem(int i) {
        if (i == 0) {
            return f13531p;
        }
        if (i == getCount() - 1) {
            if (this.f13545o.isEmpty()) {
                return f13532q;
            }
            if (this.f13546t) {
                return f13533r;
            }
        }
        return this.f13545o.get(i - 1);
    }

    public int getViewTypeCount() {
        return f13534s + 3;
    }

    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item == f13531p) {
            return f13527a;
        }
        if (item == f13533r) {
            return f13528b;
        }
        if (item == f13532q) {
            return f13529c;
        }
        return ((CollectionItemData) item).f13514c.ordinal();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            int itemViewType = getItemViewType(i);
            if (itemViewType == f13528b) {
                return this.f13543m.inflate(2130907476, null);
            }
            if (itemViewType == f13529c) {
                return this.f13543m.inflate(2130903606, null);
            }
            View a;
            if (view == null || CollectionsViewFactory.m14945a(view)) {
                a = m14753a(itemViewType, viewGroup);
            } else {
                a = view;
            }
            m14755a(getItem(i), a, itemViewType);
            return a;
        } catch (Exception e) {
            String str;
            Exception exception = e;
            Object item = getItem(i);
            if (item == f13531p) {
                str = "section_header";
            } else {
                CollectionItemData collectionItemData = (CollectionItemData) item;
                str = (collectionItemData == null || collectionItemData.f13512a.nS_() == null) ? null : collectionItemData.f13512a.nS_();
            }
            return this.f13536f.m14950a(exception, this.f13535e, str, "CollectionsSectionAdapter.getView");
        }
    }

    private View m14753a(int i, ViewGroup viewGroup) {
        if (i == f13527a) {
            CollectionSectionHeader collectionSectionHeader = new CollectionSectionHeader(this.f13535e);
            int dimensionPixelSize = this.f13535e.getResources().getDimensionPixelSize(2131434532);
            collectionSectionHeader.setPadding(this.f13535e.getResources().getDimensionPixelSize(2131434517), dimensionPixelSize, 0, dimensionPixelSize);
            return collectionSectionHeader;
        }
        return this.f13539i.m13791a(this.f13536f.m14949a(GraphQLTimelineAppCollectionStyle.values()[i], this.f13543m, this.f13535e), this.f13543m);
    }

    private void m14755a(Object obj, View view, int i) {
        if (i == f13527a) {
            ((CollectionSectionHeader) view).m15080a(this.f13544n);
            return;
        }
        CollectionItemData collectionItemData = (CollectionItemData) obj;
        this.f13536f.m14953a(collectionItemData.f13513b, collectionItemData.f13515d, CollectionsViewFramer.m13788a(view), this.f13541k, null);
        this.f13540j.m13741a(this.f13541k.a, CollectionsAnalyticsLogger.m13739a(this.f13541k), this.f13544n.nQ_(), collectionItemData.f13512a.mo398j());
    }
}

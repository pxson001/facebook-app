package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.analytics.InteractionLogger;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionDefaultFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader;
import com.facebook.timeline.aboutpage.views.header.CollectionSectionHeader;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: NAS chose Only Me */
public class CollectionsCollectionAdapter extends BaseAdapter {
    private static final Class<?> f13067a = CollectionsCollectionAdapter.class;
    private static final Object f13068l = new Object();
    private static final Object f13069m = new Object();
    private final Context f13070b;
    private final ProfileViewerContext f13071c;
    private final CollectionsViewFactory f13072d;
    public final CollectionStyleMapper f13073e;
    private final ListCollectionItemDataFactory f13074f;
    private final CollectionsViewFramer f13075g;
    private final CollectionsAnalyticsLogger f13076h;
    private final InteractionLogger f13077i;
    private final CollectionsUriIntentBuilder f13078j;
    private final LayoutInflater f13079k;
    public boolean f13080n;
    private CollectionsAppSection f13081o;
    private CollectionWithItemsAndSuggestions f13082p;
    public GraphQLTimelineAppCollectionStyle f13083q;
    public ICollectionSubAdapter f13084r;
    public DefaultPageInfoFields f13085s = null;

    /* compiled from: NAS chose Only Me */
    public enum ViewType {
        SECTION_HEADER,
        COLLECTION_HEADER,
        SUB_ADAPTER_ITEM_MIDDLE,
        SUB_ADAPTER_ITEM_BOTTOM,
        SUGGESTIONS_BANNER,
        SUGGESTIONS_TYPEAHEAD,
        CURATE_SEARCH_RESULT,
        LOADING_INDICATOR
    }

    @Inject
    public CollectionsCollectionAdapter(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, CollectionsViewFactory collectionsViewFactory, CollectionStyleMapper collectionStyleMapper, ListCollectionItemDataFactory listCollectionItemDataFactory, CollectionsViewFramer collectionsViewFramer, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, InteractionLogger interactionLogger, CollectionsUriIntentBuilder collectionsUriIntentBuilder, @Assisted LayoutInflater layoutInflater) {
        this.f13070b = context;
        this.f13071c = profileViewerContext;
        this.f13072d = collectionsViewFactory;
        this.f13073e = collectionStyleMapper;
        this.f13074f = listCollectionItemDataFactory;
        this.f13075g = collectionsViewFramer;
        this.f13076h = collectionsAnalyticsLogger;
        this.f13077i = interactionLogger;
        this.f13078j = collectionsUriIntentBuilder;
        this.f13079k = layoutInflater;
        this.f13080n = false;
    }

    public final void m13847a(FetchTimelineSingleCollectionViewQueryModel fetchTimelineSingleCollectionViewQueryModel) {
        Object obj;
        if (this.f13081o != null) {
            m13845a();
        }
        this.f13081o = fetchTimelineSingleCollectionViewQueryModel;
        if (fetchTimelineSingleCollectionViewQueryModel == null || fetchTimelineSingleCollectionViewQueryModel.m14734j() == null || fetchTimelineSingleCollectionViewQueryModel.m14734j().m14722a() == null || fetchTimelineSingleCollectionViewQueryModel.m14734j().m14722a().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsAndSuggestions) fetchTimelineSingleCollectionViewQueryModel.m14734j().m14722a().get(0);
            this.f13082p = collectionWithItemsAndSuggestions;
            this.f13083q = this.f13073e.m14916a(collectionWithItemsAndSuggestions.mo396d());
            if (this.f13083q.equals(GraphQLTimelineAppCollectionStyle.LIST)) {
                this.f13084r = new ListCollectionSubAdapter(this.f13074f, this.f13075g, this.f13071c, this.f13079k, this.f13083q);
            } else if (this.f13083q.equals(GraphQLTimelineAppCollectionStyle.GRID) || this.f13083q.equals(GraphQLTimelineAppCollectionStyle.PHOTOS)) {
                this.f13084r = new TableCollectionSubAdapter(this.f13072d, this.f13075g, this.f13083q, this.f13079k);
            } else {
                this.f13084r = new GenericCollectionSubAdapter(this.f13072d, this.f13075g, this.f13083q, this.f13079k);
            }
            m13846a(collectionWithItemsAndSuggestions);
        }
    }

    public final void m13846a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions) {
        Preconditions.checkNotNull(this.f13081o, "Must initialize section first");
        if (collectionWithItemsAndSuggestions != null && collectionWithItemsAndSuggestions.nU_() != null && collectionWithItemsAndSuggestions.nU_().m14346b() != null) {
            this.f13085s = this.f13084r.mo373a(collectionWithItemsAndSuggestions, this.f13081o.nP_());
            AdapterDetour.a(this, 349781692);
        }
    }

    public final void m13845a() {
        this.f13080n = false;
        this.f13081o = null;
        this.f13082p = null;
        this.f13085s = null;
        if (this.f13084r != null) {
            this.f13084r.mo378c();
            this.f13084r = null;
        }
        this.f13083q = GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public final void m13848a(boolean z) {
        this.f13080n = z;
        AdapterDetour.a(this, -75179486);
    }

    public int getCount() {
        if (this.f13081o == null) {
            return 0;
        }
        int d = this.f13084r.mo379d() + 2;
        if (this.f13080n) {
            return d + 1;
        }
        return d;
    }

    public Object getItem(int i) {
        if (i == 0) {
            return f13068l;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return this.f13082p;
        }
        i2--;
        if (i2 < this.f13084r.mo379d()) {
            return this.f13084r.mo374a(i2);
        }
        if (i2 - this.f13084r.mo379d() == 0 && this.f13080n) {
            return f13069m;
        }
        throw new IllegalStateException("Invalid adapter position. Probably loading state not maintained properly");
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item == f13068l) {
            return ViewType.SECTION_HEADER.ordinal();
        }
        if (item instanceof AppCollectionDefaultFields) {
            return ViewType.COLLECTION_HEADER.ordinal();
        }
        if (item == f13069m) {
            return ViewType.LOADING_INDICATOR.ordinal();
        }
        return this.f13084r.mo377b(i - 2).ordinal();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ItemData f;
        String str;
        boolean z = false;
        ViewType viewType = ViewType.values()[getItemViewType(i)];
        if (view != null) {
            try {
                if (!CollectionsViewFactory.m14945a(view)) {
                    view2 = view;
                    switch (viewType) {
                        case SECTION_HEADER:
                            ((CollectionSectionHeader) view2).m15080a(this.f13081o);
                            return view2;
                        case COLLECTION_HEADER:
                            f = m13844f();
                            CollectionCollectionHeader collectionCollectionHeader = (CollectionCollectionHeader) CollectionsViewFramer.m13788a(view2);
                            if (f.f13793m != null) {
                                z = true;
                            }
                            collectionCollectionHeader.m15079a(f, false, z, false);
                            if (this.f13081o.nQ_() != null) {
                                return view2;
                            }
                            this.f13076h.m13741a(this.f13071c.a(), CollectionsAnalyticsLogger.m13739a(this.f13071c), this.f13081o.nQ_(), this.f13082p.mo398j());
                            return view2;
                        case LOADING_INDICATOR:
                            return view2;
                        default:
                            this.f13084r.mo375a(getItem(i), view2, this.f13071c);
                            return view2;
                    }
                }
            } catch (Throwable e) {
                Throwable th = e;
                BLog.b(f13067a, "getView", th);
                if (i == 0) {
                    str = "section_header: " + this.f13081o.mo390d();
                } else if (i == 1) {
                    str = "collection_header: " + this.f13082p.nS_();
                } else {
                    str = "item_view, type: " + this.f13083q;
                }
                return this.f13072d.m14950a(th, this.f13070b, str, "CollectionsCollectionAdapter.getView");
            }
        }
        view2 = m13843a(viewType, viewGroup);
        switch (viewType) {
            case SECTION_HEADER:
                ((CollectionSectionHeader) view2).m15080a(this.f13081o);
                return view2;
            case COLLECTION_HEADER:
                f = m13844f();
                CollectionCollectionHeader collectionCollectionHeader2 = (CollectionCollectionHeader) CollectionsViewFramer.m13788a(view2);
                if (f.f13793m != null) {
                    z = true;
                }
                collectionCollectionHeader2.m15079a(f, false, z, false);
                if (this.f13081o.nQ_() != null) {
                    return view2;
                }
                this.f13076h.m13741a(this.f13071c.a(), CollectionsAnalyticsLogger.m13739a(this.f13071c), this.f13081o.nQ_(), this.f13082p.mo398j());
                return view2;
            case LOADING_INDICATOR:
                return view2;
            default:
                this.f13084r.mo375a(getItem(i), view2, this.f13071c);
                return view2;
        }
    }

    private View m13843a(ViewType viewType, ViewGroup viewGroup) {
        switch (viewType) {
            case SECTION_HEADER:
                View collectionSectionHeader = new CollectionSectionHeader(this.f13070b);
                Resources resources = this.f13070b.getResources();
                collectionSectionHeader.setPadding(resources.getDimensionPixelSize(2131434517), resources.getDimensionPixelSize(2131434532), 0, resources.getDimensionPixelSize(2131434532) + resources.getDimensionPixelSize(2131434530));
                return collectionSectionHeader;
            case COLLECTION_HEADER:
                return this.f13075g.m13792b(new CollectionCollectionHeader(this.f13070b), this.f13079k);
            case LOADING_INDICATOR:
                this.f13077i.a(true);
                return this.f13079k.inflate(2130907476, null);
            default:
                return this.f13084r.mo372a(this.f13070b, viewType, viewGroup);
        }
    }

    private ItemData m13844f() {
        GraphQLTimelineAppSectionType graphQLTimelineAppSectionType = null;
        String str = null;
        if (this.f13081o != null) {
            graphQLTimelineAppSectionType = this.f13081o.nP_();
            str = this.f13078j.m13786a(this.f13082p, this.f13081o.nP_(), this.f13083q);
        }
        return new ItemData(this.f13082p.mo395c(), this.f13082p.nS_(), null, this.f13082p.nU_().m14342a() == 0 ? null : String.valueOf(this.f13082p.nU_().m14342a()), null, this.f13082p.mo402o(), this.f13082p, null, null, null, null, null, str, graphQLTimelineAppSectionType, this.f13071c, false);
    }
}

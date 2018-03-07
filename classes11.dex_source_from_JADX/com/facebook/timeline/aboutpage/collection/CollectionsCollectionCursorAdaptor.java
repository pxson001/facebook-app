package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.cursor.GraphConnectionAggregatedRowCursor;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.collection.CollectionsCollectionAdapter.ViewType;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLModels.CollectionWithItemsAndSuggestionsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.aboutpage.views.header.CollectionCollectionHeader;
import com.facebook.timeline.aboutpage.views.header.CollectionSectionHeader;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: Multiple Choices */
public class CollectionsCollectionCursorAdaptor extends CursorAdapter {
    public final CollectionsViewFramer f13087j;
    public final ListCollectionItemDataFactory f13088k;
    public final CollectionStyleMapper f13089l;
    public final ProfileViewerContext f13090m;
    public final CollectionsViewFactory f13091n;
    private final CollectionsUriIntentBuilder f13092o;
    public final LayoutInflater f13093p;
    private final CollectionsAnalyticsLogger f13094q;
    private String f13095r;
    private GraphQLTimelineAppSectionType f13096s;
    public ICollectionSubAdapter f13097t;

    @Inject
    public CollectionsCollectionCursorAdaptor(@Assisted ProfileViewerContext profileViewerContext, @Assisted Context context, @Assisted LayoutInflater layoutInflater, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, CollectionsViewFramer collectionsViewFramer, ListCollectionItemDataFactory listCollectionItemDataFactory, CollectionsViewFactory collectionsViewFactory, CollectionStyleMapper collectionStyleMapper, CollectionsUriIntentBuilder collectionsUriIntentBuilder) {
        super(context, null, 0);
        this.f13091n = collectionsViewFactory;
        this.f13087j = collectionsViewFramer;
        this.f13088k = listCollectionItemDataFactory;
        this.f13090m = profileViewerContext;
        this.f13089l = collectionStyleMapper;
        this.f13092o = collectionsUriIntentBuilder;
        this.f13093p = layoutInflater;
        this.f13094q = collectionsAnalyticsLogger;
    }

    public final Cursor m13856b(Cursor cursor) {
        if (cursor == null) {
            return super.b(null);
        }
        int b;
        if (this.f13097t == null && cursor.getCount() >= 2) {
            Preconditions.checkState(cursor.moveToPosition(0));
            FetchTimelineSingleCollectionViewQueryModel fetchTimelineSingleCollectionViewQueryModel = (FetchTimelineSingleCollectionViewQueryModel) ((ModelCursor) cursor).d();
            this.f13095r = fetchTimelineSingleCollectionViewQueryModel.nQ_();
            this.f13096s = fetchTimelineSingleCollectionViewQueryModel.nP_();
            Preconditions.checkState(cursor.moveToPosition(1));
            GraphQLTimelineAppCollectionStyle a = this.f13089l.m14916a(((CollectionWithItemsAndSuggestionsModel) ((ModelCursor) cursor).d()).mo396d());
            if (a.equals(GraphQLTimelineAppCollectionStyle.LIST)) {
                this.f13097t = new ListCollectionSubAdapter(this.f13088k, this.f13087j, this.f13090m, this.f13093p, a);
            } else if (a.equals(GraphQLTimelineAppCollectionStyle.GRID) || a.equals(GraphQLTimelineAppCollectionStyle.PHOTOS)) {
                this.f13097t = new TableCollectionSubAdapter(this.f13091n, this.f13087j, a, this.f13093p);
            } else {
                this.f13097t = new GenericCollectionSubAdapter(this.f13091n, this.f13087j, a, this.f13093p);
            }
        }
        if (this.f13097t != null) {
            b = this.f13097t.mo376b();
        } else {
            b = 1;
        }
        return super.b(new GraphConnectionAggregatedRowCursor(cursor, 2, b));
    }

    public final void m13855a(View view, Cursor cursor) {
        ViewType a = m13852a(cursor.getPosition());
        BaseModel baseModel = (BaseModel) ((GraphConnectionAggregatedRowCursor) cursor).d();
        Preconditions.checkNotNull(baseModel);
        try {
            switch (a) {
                case SECTION_HEADER:
                    ((CollectionSectionHeader) view).m15080a((FetchTimelineSingleCollectionViewQueryModel) baseModel);
                    return;
                case COLLECTION_HEADER:
                    CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel = (CollectionWithItemsAndSuggestionsModel) baseModel;
                    ItemData a2 = m13853a(collectionWithItemsAndSuggestionsModel);
                    ((CollectionCollectionHeader) CollectionsViewFramer.m13788a(view)).m15079a(a2, false, a2.f13793m != null, false);
                    if (this.f13095r != null) {
                        this.f13094q.m13741a(this.f13090m.a(), CollectionsAnalyticsLogger.m13739a(this.f13090m), this.f13095r, collectionWithItemsAndSuggestionsModel.mo398j());
                        return;
                    }
                    return;
                default:
                    Object a3;
                    if (this.f13097t instanceof ListCollectionSubAdapter) {
                        a3 = ListCollectionItemData.m14994a((AppCollectionItemModel) baseModel, this.f13096s);
                    } else {
                        a3 = ((GraphConnectionAggregatedRowCursor) cursor).a();
                    }
                    this.f13097t.mo375a(a3, view, this.f13090m);
                    return;
            }
        } catch (Throwable e) {
            BLog.b(CollectionsCollectionCursorAdaptor.class, e, "Error binding view at position %d", new Object[]{Integer.valueOf(cursor.getPosition())});
        }
    }

    public int getItemViewType(int i) {
        return m13852a(i).ordinal();
    }

    public int getViewTypeCount() {
        return 4;
    }

    public final View m13854a(Context context, Cursor cursor, ViewGroup viewGroup) {
        ViewType a = m13852a(cursor.getPosition());
        switch (a) {
            case SECTION_HEADER:
                View collectionSectionHeader = new CollectionSectionHeader(this.d);
                Resources resources = context.getResources();
                collectionSectionHeader.setPadding(resources.getDimensionPixelSize(2131434517), resources.getDimensionPixelSize(2131434532), 0, resources.getDimensionPixelSize(2131434532) + resources.getDimensionPixelSize(2131434530));
                return collectionSectionHeader;
            case COLLECTION_HEADER:
                return this.f13087j.m13792b(new CollectionCollectionHeader(this.d), this.f13093p);
            default:
                return this.f13097t.mo372a(this.d, a, viewGroup);
        }
    }

    private ItemData m13853a(CollectionWithItemsAndSuggestionsModel collectionWithItemsAndSuggestionsModel) {
        Preconditions.checkNotNull(collectionWithItemsAndSuggestionsModel);
        String str = null;
        if (collectionWithItemsAndSuggestionsModel != null) {
            str = this.f13092o.m13786a((CollectionWithItemsAndSuggestions) collectionWithItemsAndSuggestionsModel, this.f13096s, this.f13097t.mo380e());
        }
        return new ItemData(collectionWithItemsAndSuggestionsModel.mo395c(), collectionWithItemsAndSuggestionsModel.nS_(), null, collectionWithItemsAndSuggestionsModel.m14684k().m14342a() == 0 ? null : String.valueOf(collectionWithItemsAndSuggestionsModel.m14684k().m14342a()), null, collectionWithItemsAndSuggestionsModel.mo402o(), collectionWithItemsAndSuggestionsModel, null, null, null, null, null, str, this.f13096s, this.f13090m, false);
    }

    private ViewType m13852a(int i) {
        GraphConnectionAggregatedRowCursor graphConnectionAggregatedRowCursor = (GraphConnectionAggregatedRowCursor) a();
        if (i == 0) {
            return ViewType.SECTION_HEADER;
        }
        if (i == 1) {
            return ViewType.COLLECTION_HEADER;
        }
        if (i == graphConnectionAggregatedRowCursor.getCount() - 1) {
            return ViewType.SUB_ADAPTER_ITEM_BOTTOM;
        }
        return ViewType.SUB_ADAPTER_ITEM_MIDDLE;
    }
}

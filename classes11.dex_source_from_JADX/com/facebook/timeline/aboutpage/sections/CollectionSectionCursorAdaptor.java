package com.facebook.timeline.aboutpage.sections;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.MultiCollectionFragment.Adapter;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.aboutpage.views.header.CollectionSectionHeader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: MMMM yyyy */
public class CollectionSectionCursorAdaptor extends CursorAdapter implements Adapter {
    public static final int f13516j;
    private static final int f13517s;
    private final ProfileViewerContext f13518k;
    private final LayoutInflater f13519l;
    private final CollectionsAnalyticsLogger f13520m;
    private final CollectionsViewFactory f13521n;
    private final CollectionsViewFramer f13522o;
    public final CollectionStyleMapper f13523p;
    private final ListCollectionItemDataFactory f13524q;
    private final GraphQLTimelineAppCollectionStyle[] f13525r = GraphQLTimelineAppCollectionStyle.values();
    public CollectionsAppSection f13526t;

    static {
        int length = GraphQLTimelineAppCollectionStyle.values().length;
        f13517s = length;
        f13516j = length;
    }

    @Inject
    public CollectionSectionCursorAdaptor(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, @Assisted LayoutInflater layoutInflater, @Assisted CollectionsAnalyticsLogger collectionsAnalyticsLogger, CollectionsViewFramer collectionsViewFramer, CollectionsViewFactory collectionsViewFactory, CollectionStyleMapper collectionStyleMapper, ListCollectionItemDataFactory listCollectionItemDataFactory) {
        super(context, null, 0);
        this.f13518k = profileViewerContext;
        this.f13519l = layoutInflater;
        this.f13520m = collectionsAnalyticsLogger;
        this.f13521n = collectionsViewFactory;
        this.f13522o = collectionsViewFramer;
        this.f13523p = collectionStyleMapper;
        this.f13524q = listCollectionItemDataFactory;
    }

    public final Cursor m14752b(Cursor cursor) {
        if (cursor == null) {
            return super.b(null);
        }
        if (this.f13526t == null && cursor.getCount() > 0) {
            Preconditions.checkState(cursor.moveToPosition(0));
            this.f13526t = (CollectionsAppSection) ((ModelCursor) cursor).d();
        }
        return super.b(cursor);
    }

    public final View m14749a(Context context, Cursor cursor, ViewGroup viewGroup) {
        try {
            int itemViewType = getItemViewType(cursor.getPosition());
            if (itemViewType == f13516j) {
                CollectionSectionHeader collectionSectionHeader = new CollectionSectionHeader(this.d);
                Resources resources = context.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(2131434532);
                collectionSectionHeader.setPadding(resources.getDimensionPixelSize(2131434517), dimensionPixelSize, 0, dimensionPixelSize);
                return collectionSectionHeader;
            }
            return this.f13522o.m13791a(this.f13521n.m14949a(this.f13525r[itemViewType], this.f13519l, this.d), this.f13519l);
        } catch (Exception e) {
            String str;
            Exception exception = e;
            if (getItemViewType(cursor.getPosition()) == f13516j) {
                str = "section_header";
            } else {
                str = this.f13523p.m14916a(((CollectionWithItemsAndSuggestions) ((ModelCursor) cursor).d()).mo396d()).toString();
            }
            return this.f13521n.m14950a(exception, this.d, str, "CollectionsSectionCursorAdapter.getView");
        }
    }

    public final void m14750a(View view, Cursor cursor) {
        BaseModel baseModel = (BaseModel) ((ModelCursor) cursor).d();
        if (getItemViewType(cursor.getPosition()) == f13516j) {
            ((CollectionSectionHeader) view).m15080a((CollectionsAppSection) baseModel);
            return;
        }
        ImmutableList a;
        CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsAndSuggestions) baseModel;
        CollectionsViewFactory collectionsViewFactory = this.f13521n;
        if (GraphQLTimelineAppCollectionStyle.LIST.equals(this.f13523p.m14916a(collectionWithItemsAndSuggestions.mo396d()))) {
            a = ListCollectionItemDataFactory.m14998a(collectionWithItemsAndSuggestions, this.f13526t.nP_());
        } else {
            a = collectionWithItemsAndSuggestions.nU_().m14346b();
        }
        collectionsViewFactory.m14952a(collectionWithItemsAndSuggestions, a, view, this.f13518k, null, this.f13526t, null, null);
        this.f13520m.m13741a(this.f13518k.a, CollectionsAnalyticsLogger.m13739a(this.f13518k), this.f13526t.nQ_(), collectionWithItemsAndSuggestions.mo398j());
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return f13516j;
        }
        ModelCursor modelCursor = (ModelCursor) a();
        modelCursor.moveToPosition(i);
        return this.f13523p.m14916a(((CollectionWithItemsAndSuggestions) modelCursor.d()).mo396d()).ordinal();
    }

    public int getViewTypeCount() {
        return f13516j + 1;
    }

    public final void mo405a(boolean z) {
    }
}

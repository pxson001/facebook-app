package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.collection.CollectionsCollectionAdapter.ViewType;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.ListCollectionItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.aboutpage.views.ListCollectionItemView;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Missing required arguments. */
public class ListCollectionSubAdapter implements ICollectionSubAdapter {
    private final ListCollectionItemDataFactory f13125a;
    private final CollectionsViewFramer f13126b;
    private final ProfileViewerContext f13127c;
    private final LayoutInflater f13128d;
    private final GraphQLTimelineAppCollectionStyle f13129e;
    private List<ListCollectionItemData> f13130f;

    @Inject
    public ListCollectionSubAdapter(ListCollectionItemDataFactory listCollectionItemDataFactory, CollectionsViewFramer collectionsViewFramer, @Assisted ProfileViewerContext profileViewerContext, @Assisted LayoutInflater layoutInflater, @Assisted GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle) {
        this.f13125a = listCollectionItemDataFactory;
        this.f13126b = collectionsViewFramer;
        this.f13127c = profileViewerContext;
        this.f13128d = layoutInflater;
        this.f13129e = graphQLTimelineAppCollectionStyle;
    }

    public final int mo371a() {
        return 36;
    }

    public final int mo376b() {
        return 1;
    }

    public final DefaultPageInfoFields mo373a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions);
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_());
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_().m14346b());
        if (this.f13130f == null) {
            this.f13130f = new ArrayList();
        }
        this.f13130f.addAll(ListCollectionItemDataFactory.m14998a(collectionWithItemsAndSuggestions, graphQLTimelineAppSectionType));
        return collectionWithItemsAndSuggestions.nU_().m14347c();
    }

    public final void mo378c() {
        this.f13130f = null;
    }

    public final int mo379d() {
        if (this.f13130f != null) {
            return this.f13130f.size();
        }
        return 0;
    }

    public final Object mo374a(int i) {
        return this.f13130f.get(i);
    }

    public final ViewType mo377b(int i) {
        if (i == mo379d() - 1) {
            return ViewType.SUB_ADAPTER_ITEM_BOTTOM;
        }
        return ViewType.SUB_ADAPTER_ITEM_MIDDLE;
    }

    public final GraphQLTimelineAppCollectionStyle mo380e() {
        return this.f13129e;
    }

    public final View mo372a(Context context, ViewType viewType, ViewGroup viewGroup) {
        switch (viewType) {
            case SUB_ADAPTER_ITEM_MIDDLE:
                return this.f13126b.m13793c(new ListCollectionItemView(context), this.f13128d);
            case SUB_ADAPTER_ITEM_BOTTOM:
                View listCollectionItemView = new ListCollectionItemView(context);
                listCollectionItemView.findViewById(2131560343).setVisibility(4);
                return this.f13126b.m13794d(listCollectionItemView, this.f13128d);
            default:
                throw new IllegalArgumentException("Unknown type in TableCollectionSubAdapter");
        }
    }

    public final void mo375a(Object obj, View view, ProfileViewerContext profileViewerContext) {
        ((ListCollectionItemView) CollectionsViewFramer.m13788a(view)).m15010a((ListCollectionItemData) obj, this.f13127c);
    }
}

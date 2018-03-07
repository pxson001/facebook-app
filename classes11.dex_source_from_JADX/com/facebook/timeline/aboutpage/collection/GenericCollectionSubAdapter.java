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
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionItem;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ICollectionItemView;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Model had empty profile picture URL */
public class GenericCollectionSubAdapter implements ICollectionSubAdapter {
    private final CollectionsViewFactory f13118a;
    private final CollectionsViewFramer f13119b;
    private final GraphQLTimelineAppCollectionStyle f13120c;
    private final LayoutInflater f13121d;
    private List<AppCollectionItem> f13122e;
    private GraphQLTimelineAppSectionType f13123f = null;

    @Inject
    public GenericCollectionSubAdapter(CollectionsViewFactory collectionsViewFactory, CollectionsViewFramer collectionsViewFramer, @Assisted GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, @Assisted LayoutInflater layoutInflater) {
        this.f13118a = collectionsViewFactory;
        this.f13119b = collectionsViewFramer;
        this.f13120c = graphQLTimelineAppCollectionStyle;
        this.f13121d = layoutInflater;
    }

    public final int mo371a() {
        return 36;
    }

    public final int mo376b() {
        return this.f13118a.m14955b(this.f13120c);
    }

    public final DefaultPageInfoFields mo373a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions);
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_());
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_().m14346b());
        this.f13123f = graphQLTimelineAppSectionType;
        if (this.f13122e == null) {
            this.f13122e = new ArrayList();
        }
        this.f13122e.addAll(collectionWithItemsAndSuggestions.nU_().m14346b());
        return collectionWithItemsAndSuggestions.nU_().m14347c();
    }

    public final void mo378c() {
        this.f13122e = null;
    }

    public final int mo379d() {
        if (this.f13122e != null) {
            return this.f13122e.size();
        }
        return 0;
    }

    public final Object mo374a(int i) {
        if (this.f13122e != null) {
            return this.f13122e.get(i);
        }
        return null;
    }

    public final ViewType mo377b(int i) {
        if (i == mo379d() - 1) {
            return ViewType.SUB_ADAPTER_ITEM_BOTTOM;
        }
        return ViewType.SUB_ADAPTER_ITEM_MIDDLE;
    }

    public final GraphQLTimelineAppCollectionStyle mo380e() {
        return this.f13120c;
    }

    public final View mo372a(Context context, ViewType viewType, ViewGroup viewGroup) {
        switch (viewType) {
            case SUB_ADAPTER_ITEM_MIDDLE:
                return this.f13119b.m13793c(CollectionsViewFactory.m14938a(this.f13120c, this.f13121d, viewGroup), this.f13121d);
            case SUB_ADAPTER_ITEM_BOTTOM:
                View a = CollectionsViewFactory.m14938a(this.f13120c, this.f13121d, viewGroup);
                View findViewById = a.findViewById(2131560343);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                }
                return this.f13119b.m13794d(a, this.f13121d);
            default:
                throw new IllegalArgumentException("Unknown type in GenericCollectionSubAdapter");
        }
    }

    public final void mo375a(Object obj, View view, ProfileViewerContext profileViewerContext) {
        ICollectionItemView iCollectionItemView = (ICollectionItemView) CollectionsViewFramer.m13788a(view);
        AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) obj;
        if (this.f13123f == null) {
            GraphQLTimelineAppSectionType graphQLTimelineAppSectionType = GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        iCollectionItemView.mo424a(appCollectionItemModel);
    }
}

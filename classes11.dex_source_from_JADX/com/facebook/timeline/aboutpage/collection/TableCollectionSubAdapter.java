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
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.TableCollectionView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Missing page info */
public class TableCollectionSubAdapter implements ICollectionSubAdapter {
    private final CollectionsViewFactory f13132a;
    private final CollectionsViewFramer f13133b;
    private final GraphQLTimelineAppCollectionStyle f13134c;
    private final LayoutInflater f13135d;
    private List<List<AppCollectionItem>> f13136e;
    private int f13137f = this.f13132a.m14948a(this.f13134c);
    private GraphQLTimelineAppSectionType f13138g = null;

    @Inject
    public TableCollectionSubAdapter(CollectionsViewFactory collectionsViewFactory, CollectionsViewFramer collectionsViewFramer, @Assisted GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle, @Assisted LayoutInflater layoutInflater) {
        this.f13132a = collectionsViewFactory;
        this.f13133b = collectionsViewFramer;
        this.f13134c = graphQLTimelineAppCollectionStyle;
        this.f13135d = layoutInflater;
    }

    public final int mo371a() {
        return 36 - (36 % this.f13137f);
    }

    public final int mo376b() {
        return this.f13132a.m14955b(this.f13134c);
    }

    public final DefaultPageInfoFields mo373a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions);
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_());
        Preconditions.checkNotNull(collectionWithItemsAndSuggestions.nU_().m14346b());
        this.f13138g = graphQLTimelineAppSectionType;
        int i = 0;
        if (this.f13136e == null) {
            this.f13136e = new ArrayList();
        } else {
            List list = (List) this.f13136e.get(this.f13136e.size() - 1);
            if (list.size() < this.f13137f) {
                this.f13136e.remove(list);
                Builder builder = ImmutableList.builder();
                builder.b(list);
                int size = list.size();
                while (i < collectionWithItemsAndSuggestions.nU_().m14346b().size() && size < this.f13137f) {
                    builder.c(collectionWithItemsAndSuggestions.nU_().m14346b().get(i));
                    i++;
                    size++;
                }
                this.f13136e.add(builder.b());
            }
        }
        while (i < collectionWithItemsAndSuggestions.nU_().m14346b().size()) {
            this.f13136e.add(collectionWithItemsAndSuggestions.nU_().m14346b().subList(i, Math.min(collectionWithItemsAndSuggestions.nU_().m14346b().size(), this.f13137f + i)));
            i += this.f13137f;
        }
        return collectionWithItemsAndSuggestions.nU_().m14347c();
    }

    public final void mo378c() {
        this.f13136e = null;
    }

    public final int mo379d() {
        if (this.f13136e != null) {
            return this.f13136e.size();
        }
        return 0;
    }

    public final Object mo374a(int i) {
        if (this.f13136e != null) {
            return this.f13136e.get(i);
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
        return this.f13134c;
    }

    public final View mo372a(Context context, ViewType viewType, ViewGroup viewGroup) {
        View b;
        if (this.f13134c.equals(GraphQLTimelineAppCollectionStyle.GRID)) {
            b = TableCollectionView.m15052b(context, this.f13135d, 2130903588);
        } else if (this.f13134c.equals(GraphQLTimelineAppCollectionStyle.PHOTOS)) {
            b = TableCollectionView.m15052b(context, this.f13135d, 2130903595);
        } else {
            throw new IllegalArgumentException("unexpected collection style");
        }
        switch (viewType) {
            case SUB_ADAPTER_ITEM_MIDDLE:
                return this.f13133b.m13793c(b, this.f13135d);
            case SUB_ADAPTER_ITEM_BOTTOM:
                return this.f13133b.m13794d(b, this.f13135d);
            default:
                throw new IllegalArgumentException("Unknown type in TableCollectionSubAdapter");
        }
    }

    public final void mo375a(Object obj, View view, ProfileViewerContext profileViewerContext) {
        ((TableCollectionView) CollectionsViewFramer.m13788a(view)).m15053a((List) obj, profileViewerContext, this.f13138g != null ? this.f13138g : GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
    }
}

package com.facebook.pages.identity.cards.commerce;

import com.facebook.commerce.core.util.CommerceMerchantUtil;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLInterfaces.PageIdentityCommerceCardQuery.CommerceStore.OrderedCollections;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLInterfaces.PageIdentityCommerceCardQuery.CommerceStore.OrderedCollections.Nodes.CollectionProductItems.CollectionProductItemsNodes;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel.NodesModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel.OrderedImagesModel;
import com.facebook.reaction.ui.attachment.handler.ReactionPageCommerceProductHandler;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: privacy_checkup_manager_null_composer_options */
public class PageIdentityCommerceCardViewHelper {

    /* compiled from: privacy_checkup_manager_null_composer_options */
    public class ClickedItemId {
        public final int f3383a;
        public final String f3384b;

        public ClickedItemId(int i, String str) {
            this.f3383a = i;
            this.f3384b = str;
        }
    }

    private PageIdentityCommerceCardViewHelper() {
    }

    public static ImmutableList<CollectionProductItemsNodes> m4482a(OrderedCollections orderedCollections) {
        if (orderedCollections == null || orderedCollections.a() == null) {
            return RegularImmutableList.a;
        }
        Set hashSet = new HashSet();
        Builder builder = new Builder();
        ImmutableList a = orderedCollections.a();
        int size = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (!(nodesModel.b() == null || nodesModel.b().a() == null)) {
                ImmutableList a2 = nodesModel.b().a();
                int size2 = a2.size();
                int i4 = 0;
                while (i4 < size2) {
                    CollectionProductItemsNodesModel collectionProductItemsNodesModel = (CollectionProductItemsNodesModel) a2.get(i4);
                    if (!hashSet.contains(collectionProductItemsNodesModel.b()) && !collectionProductItemsNodesModel.d().isEmpty() && ((OrderedImagesModel) collectionProductItemsNodesModel.d().get(0)).a() != null) {
                        builder.c(collectionProductItemsNodesModel);
                        hashSet.add(collectionProductItemsNodesModel.b());
                        i3 = i2 + 1;
                        if (i3 == 5) {
                            break;
                        }
                    } else {
                        i3 = i2;
                    }
                    i4++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        return m4483a(builder.b());
    }

    private static ImmutableList<CollectionProductItemsNodes> m4483a(ImmutableList<CollectionProductItemsNodes> immutableList) {
        int b = ReactionPageCommerceProductHandler.b(immutableList.size());
        if (b == immutableList.size()) {
            return immutableList;
        }
        Builder builder = new Builder();
        for (int i = 0; i < b; i++) {
            builder.c(immutableList.get(i));
        }
        return builder.b();
    }

    public static boolean m4487c(@Nullable PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel) {
        return (pageIdentityCommerceCardQueryModel == null || pageIdentityCommerceCardQueryModel.a() == null || pageIdentityCommerceCardQueryModel.a().a() == null || !pageIdentityCommerceCardQueryModel.a().a().b()) ? false : true;
    }

    public static boolean m4485b(PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel) {
        Preconditions.checkNotNull(pageIdentityCommerceCardQueryModel);
        Preconditions.checkNotNull(pageIdentityCommerceCardQueryModel.a());
        Preconditions.checkNotNull(pageIdentityCommerceCardQueryModel.a().b());
        if (pageIdentityCommerceCardQueryModel.a().a() != null && CommerceMerchantUtil.a(pageIdentityCommerceCardQueryModel.a().a().a())) {
            return false;
        }
        OrderedCollectionsModel b = pageIdentityCommerceCardQueryModel.a().b();
        int size = b.a().size();
        int i = 0;
        int i2 = size;
        while (i < size) {
            int i3;
            if (((NodesModel) b.a().get(i)).b().a().isEmpty()) {
                i3 = i2 - 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2 == 1;
    }

    @Nullable
    public static String m4484b(OrderedCollectionsModel orderedCollectionsModel) {
        for (int i = 0; i < orderedCollectionsModel.a().size(); i++) {
            if (!((NodesModel) orderedCollectionsModel.a().get(i)).b().a().isEmpty()) {
                return ((NodesModel) orderedCollectionsModel.a().get(i)).c();
            }
        }
        return null;
    }

    public static boolean m4486c(OrderedCollectionsModel orderedCollectionsModel) {
        ImmutableList a = orderedCollectionsModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel.b() != null && !nodesModel.b().a().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

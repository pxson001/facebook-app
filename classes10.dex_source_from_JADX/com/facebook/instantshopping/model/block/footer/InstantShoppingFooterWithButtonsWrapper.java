package com.facebook.instantshopping.model.block.footer;

import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.instantshopping.model.block.button.InstantShoppingButtonBlockWrapper;
import com.facebook.instantshopping.model.block.button.InstantShoppingToggleButtonBlockWrapper;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingFooterElementFragment.FooterElements;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel.FooterElementsModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFooterElementFragmentModel;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Server Error */
public class InstantShoppingFooterWithButtonsWrapper {
    public ImmutableList<FooterElementsModel> f23592a;
    public ImmutableList<FooterElements> f23593b;

    /* compiled from: Server Error */
    public /* synthetic */ class C33941 {
        public static final /* synthetic */ int[] f23591a = new int[GraphQLInstantShoppingDocumentElementType.values().length];

        static {
            try {
                f23591a[GraphQLInstantShoppingDocumentElementType.BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23591a[GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public final Map<GraphQLInstantShoppingDocumentElementType, Object> m24898a() {
        if (this.f23592a != null) {
            Map<GraphQLInstantShoppingDocumentElementType, Object> hashMap = new HashMap();
            int size = this.f23592a.size();
            for (int i = 0; i < size; i++) {
                FooterElementsModel footerElementsModel = (FooterElementsModel) this.f23592a.get(i);
                switch (C33941.f23591a[footerElementsModel.c().ordinal()]) {
                    case 1:
                        hashMap.put(GraphQLInstantShoppingDocumentElementType.BUTTON, new InstantShoppingButtonBlockWrapper(footerElementsModel));
                        break;
                    case 2:
                        hashMap.put(GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON, new InstantShoppingToggleButtonBlockWrapper(footerElementsModel));
                        break;
                    default:
                        break;
                }
            }
            return hashMap;
        }
        Map<GraphQLInstantShoppingDocumentElementType, Object> hashMap2 = new HashMap();
        int size2 = this.f23593b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            InstantShoppingFooterElementFragmentModel.FooterElementsModel footerElementsModel2 = (InstantShoppingFooterElementFragmentModel.FooterElementsModel) this.f23593b.get(i2);
            switch (C33941.f23591a[footerElementsModel2.c().ordinal()]) {
                case 1:
                    hashMap2.put(GraphQLInstantShoppingDocumentElementType.BUTTON, new InstantShoppingButtonBlockWrapper(footerElementsModel2));
                    break;
                case 2:
                    hashMap2.put(GraphQLInstantShoppingDocumentElementType.TOGGLE_BUTTON, new InstantShoppingToggleButtonBlockWrapper(footerElementsModel2));
                    break;
                default:
                    break;
            }
        }
        return hashMap2;
    }
}

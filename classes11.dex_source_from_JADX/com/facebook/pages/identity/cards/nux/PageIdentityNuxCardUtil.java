package com.facebook.pages.identity.cards.nux;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import javax.annotation.Nullable;

/* compiled from: privacy_checkup_composer_step_next */
public class PageIdentityNuxCardUtil {

    /* compiled from: privacy_checkup_composer_step_next */
    /* synthetic */ class C04811 {
        static final /* synthetic */ int[] f3538a = new int[GraphQLReactionRequestedUnit.values().length];

        static {
            try {
                f3538a[GraphQLReactionRequestedUnit.SERVICES_NUX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3538a[GraphQLReactionRequestedUnit.SHOP_NUX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private PageIdentityNuxCardUtil() {
    }

    public static boolean m4576a(@Nullable GraphQLReactionRequestedUnit graphQLReactionRequestedUnit) {
        if (graphQLReactionRequestedUnit == null) {
            return false;
        }
        if (graphQLReactionRequestedUnit == GraphQLReactionRequestedUnit.SERVICES_NUX || graphQLReactionRequestedUnit == GraphQLReactionRequestedUnit.SHOP_NUX) {
            return true;
        }
        return false;
    }

    public static PageIdentityNuxCardViewModel m4575a(Context context, GraphQLReactionRequestedUnit graphQLReactionRequestedUnit) {
        switch (C04811.f3538a[graphQLReactionRequestedUnit.ordinal()]) {
            case 1:
                return new PageIdentityServicesNuxCardViewModel(context.getResources());
            case 2:
                return new PageIdentityShopNuxCardViewModel(context.getResources());
            default:
                throw new IllegalArgumentException("Unsupported GraphQLReactionRequestedUnit: " + graphQLReactionRequestedUnit);
        }
    }
}

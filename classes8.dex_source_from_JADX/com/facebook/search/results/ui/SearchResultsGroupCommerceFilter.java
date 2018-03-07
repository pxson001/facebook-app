package com.facebook.search.results.ui;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.graphql.calls.ForSaleInputForSaleAvailability;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQueryCommerceModifier;
import javax.inject.Inject;

/* compiled from: PICKER_CREATIVECAM_START_FRAMES_DOWNLOAD */
public class SearchResultsGroupCommerceFilter {
    public Resources f25320a;

    /* compiled from: PICKER_CREATIVECAM_START_FRAMES_DOWNLOAD */
    public /* synthetic */ class C26551 {
        public static final /* synthetic */ int[] f25319a = new int[FilterIndex.values().length];

        static {
            try {
                f25319a[FilterIndex.ALL_POSTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f25319a[FilterIndex.SALE_POSTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f25319a[FilterIndex.AVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f25319a[FilterIndex.SOLD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f25319a[FilterIndex.ARCHIVED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: PICKER_CREATIVECAM_START_FRAMES_DOWNLOAD */
    public enum FilterIndex {
        ALL_POSTS,
        SALE_POSTS,
        AVAILABLE,
        SOLD,
        ARCHIVED
    }

    public static SearchResultsGroupCommerceFilter m28562a(InjectorLike injectorLike) {
        return new SearchResultsGroupCommerceFilter(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultsGroupCommerceFilter(Resources resources) {
        this.f25320a = resources;
    }

    public static void m28563a(MenuItemImpl menuItemImpl, ForSaleInputForSaleAvailability forSaleInputForSaleAvailability, GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier) {
        boolean z;
        menuItemImpl.setCheckable(true);
        if (graphSearchQueryCommerceModifier.c && graphSearchQueryCommerceModifier.a == forSaleInputForSaleAvailability) {
            z = true;
        } else {
            z = false;
        }
        menuItemImpl.setChecked(z);
        menuItemImpl.j = true;
        menuItemImpl.k = true;
    }

    public static boolean m28564a(GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier, ForSaleInputForSaleAvailability forSaleInputForSaleAvailability) {
        boolean z;
        if (graphSearchQueryCommerceModifier.c && graphSearchQueryCommerceModifier.a == forSaleInputForSaleAvailability) {
            z = false;
        } else {
            z = true;
        }
        graphSearchQueryCommerceModifier.c = true;
        graphSearchQueryCommerceModifier.a = forSaleInputForSaleAvailability;
        return z;
    }
}

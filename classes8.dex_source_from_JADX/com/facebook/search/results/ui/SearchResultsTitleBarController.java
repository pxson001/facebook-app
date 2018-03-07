package com.facebook.search.results.ui;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverListView;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.ForSaleInputForSaleAvailability;
import com.facebook.inject.Assisted;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQueryCommerceModifier;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment.C24571;
import com.facebook.search.results.ui.SearchResultsGroupCommerceFilter.FilterIndex;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import javax.inject.Inject;

/* compiled from: PICKER_CREATIVECAM_IMPRESSION */
public class SearchResultsTitleBarController {
    public final HasTitleBar f25322a;
    public final OnToolbarButtonListener f25323b = new C26561(this);
    public OnMenuItemClickListener f25324c;
    public C24571 f25325d;
    public TitleBarButtonSpec f25326e;

    /* compiled from: PICKER_CREATIVECAM_IMPRESSION */
    class C26561 extends OnToolbarButtonListener {
        final /* synthetic */ SearchResultsTitleBarController f25321a;

        C26561(SearchResultsTitleBarController searchResultsTitleBarController) {
            this.f25321a = searchResultsTitleBarController;
        }

        public final void m28565a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            SearchResultsTitleBarController.m28567a(this.f25321a, view);
        }
    }

    /* compiled from: PICKER_CREATIVECAM_IMPRESSION */
    class SearchResultsPopoverMenuWindow extends FigPopoverMenuWindow {
        public SearchResultsPopoverMenuWindow(Context context) {
            super(context);
        }

        protected final PopoverListView m28566b() {
            PopoverListView b = super.b();
            b.setMaxRows(10.0f);
            return b;
        }
    }

    @Inject
    public SearchResultsTitleBarController(@Assisted HasTitleBar hasTitleBar, @Assisted C24571 c24571) {
        this.f25322a = hasTitleBar;
        this.f25325d = c24571;
    }

    public static void m28567a(SearchResultsTitleBarController searchResultsTitleBarController, View view) {
        Context context = view.getContext();
        SearchResultsPopoverMenuWindow searchResultsPopoverMenuWindow = new SearchResultsPopoverMenuWindow(context);
        PopoverMenu popoverMenu = new PopoverMenu(context);
        C24571 c24571 = searchResultsTitleBarController.f25325d;
        SearchResultsGroupCommerceFilter aI = SearchResultsFeedFragment.aI(c24571.f23031a);
        if (aI != null) {
            GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier = (GraphSearchQueryCommerceModifier) c24571.f23031a.f22960h.jJ_().get(ModifierKeys.GROUP_COMMERCE.name());
            if (graphSearchQueryCommerceModifier != null && graphSearchQueryCommerceModifier.b) {
                boolean z;
                MenuItemImpl a = popoverMenu.a(FilterIndex.ALL_POSTS.ordinal(), 0, aI.f25320a.getString(2131237494));
                a.setIcon(2130840052);
                a.setCheckable(true);
                if (graphSearchQueryCommerceModifier.c) {
                    z = false;
                } else {
                    z = true;
                }
                a.setChecked(z);
                MenuItemImpl a2 = popoverMenu.a(FilterIndex.SALE_POSTS.ordinal(), 0, aI.f25320a.getString(2131237495));
                a2.setIcon(2130840122);
                a2.setCheckable(true);
                a2.setChecked(graphSearchQueryCommerceModifier.c);
                SearchResultsGroupCommerceFilter.m28563a(popoverMenu.a(FilterIndex.AVAILABLE.ordinal(), 0, aI.f25320a.getString(2131237497)), ForSaleInputForSaleAvailability.AVAILABLE, graphSearchQueryCommerceModifier);
                SearchResultsGroupCommerceFilter.m28563a(popoverMenu.a(FilterIndex.SOLD.ordinal(), 0, aI.f25320a.getString(2131237496)), ForSaleInputForSaleAvailability.SOLD, graphSearchQueryCommerceModifier);
                SearchResultsGroupCommerceFilter.m28563a(popoverMenu.a(FilterIndex.ARCHIVED.ordinal(), 0, aI.f25320a.getString(2131237498)), ForSaleInputForSaleAvailability.EXPIRED, graphSearchQueryCommerceModifier);
            }
        }
        searchResultsPopoverMenuWindow.a(popoverMenu);
        searchResultsPopoverMenuWindow.p = searchResultsTitleBarController.f25324c;
        searchResultsPopoverMenuWindow.f(view);
    }
}

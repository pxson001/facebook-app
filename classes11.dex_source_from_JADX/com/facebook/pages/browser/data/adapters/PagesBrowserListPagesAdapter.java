package com.facebook.pages.browser.data.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel;
import com.facebook.pages.browser.ui.list.PagesBrowserListExploreView;
import com.facebook.pages.browser.ui.list.PagesBrowserListHeaderView;
import com.facebook.pages.browser.ui.list.PagesBrowserListRowView;
import com.facebook.widget.listview.FbBaseAdapter;
import java.util.List;
import javax.inject.Inject;

/* compiled from: suggestionSearchBarText */
public class PagesBrowserListPagesAdapter extends FbBaseAdapter {
    private static final Object f1220a = new Object();
    private static final Object f1221b = new Object();
    private final Context f1222c;
    private List<RecommendedPageFieldsModel> f1223d;
    private String f1224e;
    private String f1225f;

    /* compiled from: suggestionSearchBarText */
    public enum ViewTypes {
        PAGE,
        EXPLORE,
        HEADER
    }

    private static PagesBrowserListPagesAdapter m1792b(InjectorLike injectorLike) {
        return new PagesBrowserListPagesAdapter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PagesBrowserListPagesAdapter(Context context) {
        this.f1222c = context;
    }

    public Object getItem(int i) {
        if (i == 0) {
            return f1221b;
        }
        if (i - 1 < this.f1223d.size()) {
            return this.f1223d.get(i - 1);
        }
        return f1220a;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return ViewTypes.HEADER.ordinal();
        }
        if (i - 1 < this.f1223d.size()) {
            return ViewTypes.PAGE.ordinal();
        }
        return ViewTypes.EXPLORE.ordinal();
    }

    public int getCount() {
        if (this.f1223d.size() == 0) {
            return 0;
        }
        return this.f1223d.size() + 2;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final View m1793a(int i, ViewGroup viewGroup) {
        if (i == ViewTypes.PAGE.ordinal()) {
            return new PagesBrowserListRowView(this.f1222c);
        }
        if (i == ViewTypes.EXPLORE.ordinal()) {
            return new PagesBrowserListExploreView(this.f1222c);
        }
        if (i == ViewTypes.HEADER.ordinal()) {
            return new PagesBrowserListHeaderView(this.f1222c);
        }
        return null;
    }

    public final void m1794a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (obj instanceof RecommendedPageFieldsModel) {
            PagesBrowserListRowView pagesBrowserListRowView = (PagesBrowserListRowView) view;
            RecommendedPageFieldsModel recommendedPageFieldsModel = (RecommendedPageFieldsModel) obj;
            pagesBrowserListRowView.setTag("id:" + recommendedPageFieldsModel.m1873c());
            pagesBrowserListRowView.m1984a(recommendedPageFieldsModel, this.f1224e);
        } else if (obj.equals(f1221b)) {
            PagesBrowserListHeaderView pagesBrowserListHeaderView = (PagesBrowserListHeaderView) view;
            pagesBrowserListHeaderView.f1320a.setText(this.f1225f);
        }
    }
}

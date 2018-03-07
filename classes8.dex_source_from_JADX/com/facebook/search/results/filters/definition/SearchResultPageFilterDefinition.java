package com.facebook.search.results.filters.definition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.search.results.filters.definition.SearchResultPageRadioGroupFilterDefinition.OnChooseMoreSelectedListener;
import com.facebook.search.results.filters.ui.SearchResultFilterExpandableListAdapter.FilterPersistentStateCallback;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import javax.annotation.Nullable;

/* compiled from: SMS_TAKEOVER_FULL_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
public interface SearchResultPageFilterDefinition<Header extends View, Child extends View> {

    /* compiled from: SMS_TAKEOVER_FULL_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
    public interface ViewSpec<V extends View> {
        V mo1272a(Context context);
    }

    /* compiled from: SMS_TAKEOVER_FULL_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
    public class FilterPillData {
        public final String f22810a;
        @Nullable
        public final Drawable f22811b;
        @Nullable
        public final Filters f22812c;

        public FilterPillData(String str, @Nullable Drawable drawable, @Nullable Filters filters) {
            this.f22810a = str;
            this.f22811b = drawable;
            this.f22812c = filters;
        }
    }

    @Nullable
    FilterPersistentState mo1273a(String str, FilterValuesModel filterValuesModel);

    FilterPillData mo1274a(FilterPersistentState filterPersistentState);

    ViewSpec<Header> mo1275a();

    void mo1276a(MainFilter mainFilter, Header header, FilterPersistentState filterPersistentState);

    void mo1277a(MainFilter mainFilter, Child child, FilterPersistentState filterPersistentState, OnChooseMoreSelectedListener onChooseMoreSelectedListener, FilterPersistentStateCallback filterPersistentStateCallback);

    ViewSpec<Child> mo1278b();
}

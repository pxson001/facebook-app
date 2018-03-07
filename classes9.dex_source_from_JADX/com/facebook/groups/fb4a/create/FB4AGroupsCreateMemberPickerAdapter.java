package com.facebook.groups.fb4a.create;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.userfilter.TypeaheadUserSearchFilterProvider;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.friendselector.TypeaheadAdapterWithStickyHeader;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import javax.inject.Inject;

/* compiled from: payments_flow_cancel */
public class FB4AGroupsCreateMemberPickerAdapter extends TypeaheadAdapterWithStickyHeader {
    private final CustomFilter f6873e;
    private final QeAccessor f6874f;

    @Inject
    public FB4AGroupsCreateMemberPickerAdapter(InputMethodManager inputMethodManager, Context context, TypeaheadMatcherFilterProvider typeaheadMatcherFilterProvider, TypeaheadUserSearchFilterProvider typeaheadUserSearchFilterProvider, FB4AGroupsCreateFilterProvider fB4AGroupsCreateFilterProvider, Boolean bool, QeAccessor qeAccessor) {
        super(inputMethodManager, context, typeaheadMatcherFilterProvider, typeaheadUserSearchFilterProvider);
        this.f6874f = qeAccessor;
        if (bool.booleanValue()) {
            this.f6873e = typeaheadUserSearchFilterProvider.a(e());
            return;
        }
        this.f6873e = new FB4AGroupsCreateFilter(FbHandlerThreadFactory.a(fB4AGroupsCreateFilterProvider), UserTokenMatcher.b(fB4AGroupsCreateFilterProvider), e(), GraphQLQueryExecutor.a(fB4AGroupsCreateFilterProvider), IdBasedProvider.a(fB4AGroupsCreateFilterProvider, 4442), ResourcesMethodAutoProvider.a(fB4AGroupsCreateFilterProvider));
    }

    public final CustomFilter m7149a() {
        return this.f6873e;
    }
}

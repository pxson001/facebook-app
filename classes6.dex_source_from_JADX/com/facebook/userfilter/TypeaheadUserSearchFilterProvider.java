package com.facebook.userfilter;

import android.content.Context;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.protocol.FetchSimpleSearchTypeaheadApiMethod;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.C15121;

/* compiled from: content_id */
public class TypeaheadUserSearchFilterProvider extends AbstractAssistedProvider<TypeaheadUserSearchFilter> {
    public final TypeaheadUserSearchFilter m27124a(C15121 c15121) {
        return new TypeaheadUserSearchFilter(FbHandlerThreadFactory.a(this), (Context) getInstance(Context.class), UserTokenMatcher.m22748b((InjectorLike) this), new UserSearchService((Context) getInstance(Context.class), FetchSimpleSearchTypeaheadApiMethod.m23176b(this), IdBasedSingletonScopeProvider.a(this, 2289), String_LoggedInUserIdMethodAutoProvider.b(this)), Boolean_IsWorkBuildMethodAutoProvider.a(this), c15121);
    }
}

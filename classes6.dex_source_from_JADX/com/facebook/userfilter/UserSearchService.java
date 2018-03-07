package com.facebook.userfilter;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.Builder;
import com.facebook.search.api.protocol.FetchSimpleSearchTypeaheadApiMethod;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: content_bytes */
public class UserSearchService {
    private final AbstractSingleMethodRunner f18494a;
    private final FetchSimpleSearchTypeaheadApiMethod f18495b;
    public final String f18496c;
    public final int f18497d;
    public final Set<String> f18498e = new HashSet();
    public final Set<String> f18499f = new HashSet();

    @Inject
    public UserSearchService(Context context, FetchSimpleSearchTypeaheadApiMethod fetchSimpleSearchTypeaheadApiMethod, Provider<SingleMethodRunner> provider, String str) {
        this.f18495b = fetchSimpleSearchTypeaheadApiMethod;
        this.f18494a = (AbstractSingleMethodRunner) provider.get();
        this.f18496c = str;
        this.f18497d = context.getResources().getDimensionPixelSize(2131430811);
    }

    public final ImmutableList<BaseToken> m27125a(CharSequence charSequence) {
        Builder builder = new Builder();
        builder.f15543a = GraphSearchQuery.m23091a(charSequence.toString());
        builder = builder;
        builder.f15546d = ImmutableList.of(Type.USER);
        builder = builder;
        builder.f15547e = 20;
        builder = builder;
        builder.f15545c = this.f18497d;
        SearchResponse searchResponse = (SearchResponse) this.f18494a.a(this.f18495b, builder.m23175a(), CallerContext.a(TypeaheadUserSearchFilter.class));
        ImmutableList.Builder builder2 = ImmutableList.builder();
        ImmutableList immutableList = searchResponse.f18413b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            SearchTypeaheadResult searchTypeaheadResult = (SearchTypeaheadResult) immutableList.get(i);
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.h = searchTypeaheadResult.f15495k;
            userBuilder = userBuilder;
            userBuilder.n = searchTypeaheadResult.f15490f.toString();
            User aa = userBuilder.a(User.Type.FACEBOOK, String.valueOf(searchTypeaheadResult.f15497m)).aa();
            if (aa.a.equals(this.f18496c) || this.f18499f.contains(aa.a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                boolean z;
                if (this.f18498e.contains(aa.a)) {
                    z = false;
                } else {
                    z = true;
                }
                boolean z2 = z;
                SimpleUserToken simpleUserToken = new SimpleUserToken(aa);
                simpleUserToken.f20127i = z2;
                builder2.c(simpleUserToken);
            }
        }
        return builder2.b();
    }
}

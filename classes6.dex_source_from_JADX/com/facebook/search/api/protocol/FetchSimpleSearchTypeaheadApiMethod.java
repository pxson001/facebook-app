package com.facebook.search.api.protocol;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.SearchTypeaheadResultsCreator;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: extra_last_user_attempt_time */
public class FetchSimpleSearchTypeaheadApiMethod implements SearchTypeaheadApiMethod {
    private final SearchTypeaheadResultsCreator f15563a;
    private final SearchTypeaheadApiMethodUtil f15564b;
    private final GatekeeperStoreImpl f15565c;

    public static FetchSimpleSearchTypeaheadApiMethod m23176b(InjectorLike injectorLike) {
        return new FetchSimpleSearchTypeaheadApiMethod(SearchTypeaheadResultsCreator.m23159a(injectorLike), SearchTypeaheadApiMethodUtil.m23179a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m23177a(Object obj) {
        ImmutableList of;
        FetchSearchTypeaheadResultParams fetchSearchTypeaheadResultParams = (FetchSearchTypeaheadResultParams) obj;
        boolean z = true;
        List arrayList = new ArrayList();
        this.f15564b.m23181a(fetchSearchTypeaheadResultParams, arrayList);
        arrayList.add(new BasicNameValuePair("query", fetchSearchTypeaheadResultParams.f15553a.f15458b));
        arrayList.add(new BasicNameValuePair("cached_ids", fetchSearchTypeaheadResultParams.f15558f));
        arrayList.add(new BasicNameValuePair("support_groups_icons", Boolean.toString(true)));
        arrayList.add(new BasicNameValuePair("group_icon_scale", Integer.toString(2)));
        arrayList.add(new BasicNameValuePair("include_is_verified", Boolean.toString(true)));
        arrayList.add(new BasicNameValuePair("no_profile_image_urls", Boolean.toString(fetchSearchTypeaheadResultParams.f15559g)));
        if (this.f15565c.a(SearchAbTestGatekeepers.z) != TriState.YES) {
            z = false;
        }
        String str = Strings.isNullOrEmpty(fetchSearchTypeaheadResultParams.f15560h) ? "simplesearch_typeahead" : fetchSearchTypeaheadResultParams.f15560h;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.c = "GET";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "method/ubersearch.get";
        apiRequestBuilder = apiRequestBuilder.a(RequestPriority.INTERACTIVE);
        apiRequestBuilder.g = arrayList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        if (z) {
            of = ImmutableList.of(new BasicHeader("X-FB-ForkingType", "edge-sgp-search"));
        } else {
            of = null;
        }
        apiRequestBuilder = apiRequestBuilder2.a(of);
        apiRequestBuilder.B = z;
        return apiRequestBuilder.C();
    }

    @Inject
    public FetchSimpleSearchTypeaheadApiMethod(SearchTypeaheadResultsCreator searchTypeaheadResultsCreator, SearchTypeaheadApiMethodUtil searchTypeaheadApiMethodUtil, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f15563a = searchTypeaheadResultsCreator;
        this.f15564b = searchTypeaheadApiMethodUtil;
        this.f15565c = gatekeeperStoreImpl;
    }

    public final Object m23178a(Object obj, ApiResponse apiResponse) {
        TracerDetour.a("FetchUberbarResultMethod.getResponse", 597257007);
        try {
            Object searchResponse = new SearchResponse(this.f15563a.m23163a(apiResponse.d()));
            return searchResponse;
        } finally {
            TracerDetour.a(-1954230564);
        }
    }
}

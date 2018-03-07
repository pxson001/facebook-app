package com.facebook.search.api.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.EdgeRoutingConfig.Caller;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchTypeaheadResultsCreator;
import com.facebook.search.api.model.GraphSearchJsonResponse;
import com.facebook.search.api.model.GraphSearchTypeaheadJsonResult;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams.KeywordMode;
import com.facebook.ui.typeahead.SearchResponse;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: extra_listener */
public class FetchGraphSearchTypeaheadApiMethod implements SearchTypeaheadApiMethod {
    private static final TypeReference<GraphSearchJsonResponse> f15537a = new C11051();
    private static final TypeReference<List<GraphSearchTypeaheadJsonResult>> f15538b = new C11062();
    private final SearchTypeaheadApiMethodUtil f15539c;
    private final FbObjectMapper f15540d;
    @Inject
    public QeAccessor f15541e;
    @Inject
    public EdgeRoutingConfig f15542f;

    /* compiled from: extra_listener */
    final class C11051 extends TypeReference<GraphSearchJsonResponse> {
        C11051() {
        }
    }

    /* compiled from: extra_listener */
    final class C11062 extends TypeReference<List<GraphSearchTypeaheadJsonResult>> {
        C11062() {
        }
    }

    public final ApiRequest m23173a(Object obj) {
        String str;
        String str2;
        Caller caller;
        FetchSearchTypeaheadResultParams fetchSearchTypeaheadResultParams = (FetchSearchTypeaheadResultParams) obj;
        List a = Lists.a();
        if (fetchSearchTypeaheadResultParams.f15561i == KeywordMode.KEYWORD_ONLY_MODE && this.f15541e.a(ExperimentsForSearchAbTestModule.bt, false)) {
            a.add(new BasicNameValuePair("format", "json"));
            a.add(new BasicNameValuePair("platform", "android"));
            a.add(new BasicNameValuePair("global", "true"));
            a.add(new BasicNameValuePair("cdn_cfg", this.f15541e.a(ExperimentsForSearchAbTestModule.bu, "default")));
            str = "graphsearch_typeahead_global_keywords";
        } else {
            this.f15539c.m23181a(fetchSearchTypeaheadResultParams, a);
            a.add(new BasicNameValuePair("keyword_mode", fetchSearchTypeaheadResultParams.f15561i.getValue()));
            a.add(new BasicNameValuePair("ranking_model", fetchSearchTypeaheadResultParams.f15562j));
            str = "graphsearch_typeahead";
        }
        String str3 = "query";
        GraphSearchQuery graphSearchQuery = fetchSearchTypeaheadResultParams.f15553a;
        Object obj2 = fetchSearchTypeaheadResultParams.f15561i == KeywordMode.SINGLE_STATE_MODE ? 1 : null;
        if (graphSearchQuery.f15464h == ScopedEntityType.URL) {
            str2 = graphSearchQuery.f15463g;
        } else {
            StringBuilder stringBuilder = new StringBuilder("[");
            if (graphSearchQuery.m23103j()) {
                stringBuilder.append(m23172a(graphSearchQuery));
            }
            if (!Strings.isNullOrEmpty(graphSearchQuery.f15458b) && obj2 == null) {
                if (graphSearchQuery.m23103j()) {
                    stringBuilder.append(", \"");
                } else {
                    stringBuilder.append("\"");
                }
                stringBuilder.append(graphSearchQuery.f15458b).append("\"");
            }
            str2 = stringBuilder.append("]").toString();
        }
        a.add(new BasicNameValuePair(str3, str2));
        if (!Strings.isNullOrEmpty(fetchSearchTypeaheadResultParams.f15560h)) {
            str = fetchSearchTypeaheadResultParams.f15560h;
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.c = "GET";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "method/graphsearchtypeahead.get";
        apiRequestBuilder = apiRequestBuilder.a(RequestPriority.INTERACTIVE);
        apiRequestBuilder.g = a;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSONPARSER;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        if (fetchSearchTypeaheadResultParams.f15561i == KeywordMode.KEYWORD_ONLY_MODE && this.f15541e.a(ExperimentsForSearchAbTestModule.bv, false)) {
            apiRequestBuilder2.B = true;
        }
        EdgeRoutingConfig edgeRoutingConfig = this.f15542f;
        if (Strings.isNullOrEmpty(fetchSearchTypeaheadResultParams.f15553a.f15458b)) {
            caller = Caller.CACHEWARMER;
        } else {
            caller = Caller.TYPEAHEAD;
        }
        edgeRoutingConfig.a(caller, apiRequestBuilder2);
        return apiRequestBuilder2.C();
    }

    @Inject
    public FetchGraphSearchTypeaheadApiMethod(SearchTypeaheadApiMethodUtil searchTypeaheadApiMethodUtil, FbObjectMapper fbObjectMapper) {
        this.f15539c = searchTypeaheadApiMethodUtil;
        this.f15540d = fbObjectMapper;
    }

    public final Object m23174a(Object obj, ApiResponse apiResponse) {
        GraphSearchJsonResponse graphSearchJsonResponse = (GraphSearchJsonResponse) apiResponse.d().a(f15537a);
        JsonParser a = new JsonFactory().a(graphSearchJsonResponse.response);
        a.a(this.f15540d);
        return new SearchResponse(GraphSearchTypeaheadResultsCreator.m23110a((List) a.a(f15538b)), !Strings.isNullOrEmpty(graphSearchJsonResponse.numTopResultsToShow) ? Integer.parseInt(graphSearchJsonResponse.numTopResultsToShow) : 0);
    }

    public static String m23172a(GraphSearchQuery graphSearchQuery) {
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            a.a("uid", Long.parseLong(graphSearchQuery.m23100f()));
            a.a("type", graphSearchQuery.m23102h().name().toLowerCase(Locale.getDefault()));
            a.a("text", graphSearchQuery.m23101g());
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (Throwable e) {
            throw new RuntimeException("Unable to generate single state pivot query", e);
        }
    }
}

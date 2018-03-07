package com.facebook.search.service;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.search.protocol.FetchGraphSearchResultDataMethod;
import com.facebook.search.protocol.FetchGraphSearchResultDataParams;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogMethod;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogParams;
import javax.inject.Inject;

/* compiled from: PHOTO_FLOW_SEARCH */
public class GraphSearchServiceHandler implements BlueServiceHandler {
    public final AbstractSingleMethodRunner f25335a;
    public final FetchGraphSearchResultDataMethod f25336b;
    public final LogSelectedSuggestionToActivityLogMethod f25337c;

    public static GraphSearchServiceHandler m28580b(InjectorLike injectorLike) {
        return new GraphSearchServiceHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), FetchGraphSearchResultDataMethod.m8502a(injectorLike), new LogSelectedSuggestionToActivityLogMethod());
    }

    @Inject
    public GraphSearchServiceHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, FetchGraphSearchResultDataMethod fetchGraphSearchResultDataMethod, LogSelectedSuggestionToActivityLogMethod logSelectedSuggestionToActivityLogMethod) {
        this.f25335a = abstractSingleMethodRunner;
        this.f25336b = fetchGraphSearchResultDataMethod;
        this.f25337c = logSelectedSuggestionToActivityLogMethod;
    }

    public final OperationResult m28581a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("graph_search_query_result_data")) {
            return OperationResult.a(this.f25335a.a(this.f25336b, (FetchGraphSearchResultDataParams) operationParams.c.getParcelable("FetchGraphSearchResultDataParams")));
        } else if (str.equals("graph_search_log_selected_suggestion_to_activity_log")) {
            this.f25335a.a(this.f25337c, (LogSelectedSuggestionToActivityLogParams) operationParams.c.getParcelable("logSelectedSuggestionToActivityLogParams"));
            return OperationResult.a;
        } else {
            throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }
}

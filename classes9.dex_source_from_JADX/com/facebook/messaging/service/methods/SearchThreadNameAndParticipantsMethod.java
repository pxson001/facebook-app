package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ListUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.methods.FetchThreadsFqlHelper.ThreadsResult;
import com.facebook.messaging.service.model.FetchGroupThreadsResultBuilder;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: cta_clicks */
public class SearchThreadNameAndParticipantsMethod implements ApiMethod<SearchThreadNameAndParticipantsParams, SearchThreadNameAndParticipantsResult> {
    private static final Class<?> f16970a = SearchThreadNameAndParticipantsMethod.class;
    public final FetchThreadsFqlHelper f16971b;
    private final Clock f16972c;

    public static SearchThreadNameAndParticipantsMethod m17022b(InjectorLike injectorLike) {
        return new SearchThreadNameAndParticipantsMethod(FetchThreadsFqlHelper.m16938b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m17023a(Object obj) {
        SearchThreadNameAndParticipantsParams searchThreadNameAndParticipantsParams = (SearchThreadNameAndParticipantsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        String str = "q";
        String str2 = searchThreadNameAndParticipantsParams.f17289b;
        StringBuilder stringBuilder = new StringBuilder();
        if (!StringUtil.c(str2)) {
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("CONTAINS('%1$s', thread_and_participants_name) AND ", str2));
        }
        stringBuilder.append("folder='inbox' AND not archived");
        if (searchThreadNameAndParticipantsParams.f17290c) {
            stringBuilder.append(" AND is_group_conversation = 1");
        }
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        FetchThreadsFqlHelper.m16933a(fqlMultiQueryHelper);
        this.f16971b.m16949a(fqlMultiQueryHelper, stringBuilder.toString(), searchThreadNameAndParticipantsParams.f17288a + 1, false);
        a.add(new BasicNameValuePair(str, fqlMultiQueryHelper.a().toString()));
        return new ApiRequest("fetchGroupThreads", "GET", "fql", a, ApiResponseType.JSON);
    }

    public final Object m17024a(Object obj, ApiResponse apiResponse) {
        boolean z;
        SearchThreadNameAndParticipantsParams searchThreadNameAndParticipantsParams = (SearchThreadNameAndParticipantsParams) obj;
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        int i = searchThreadNameAndParticipantsParams.f17288a;
        ThreadsResult c = this.f16971b.m16955c(fqlResultHelper);
        if (c.f16914a.size() < searchThreadNameAndParticipantsParams.f17288a + 1) {
            z = true;
        } else {
            z = false;
        }
        ThreadsCollection threadsCollection = new ThreadsCollection((ImmutableList) ListUtil.a(c.f16914a, 0, i), z);
        FetchGroupThreadsResultBuilder newBuilder = SearchThreadNameAndParticipantsResult.newBuilder();
        newBuilder.f17053a = DataFreshnessResult.FROM_SERVER;
        newBuilder = newBuilder;
        newBuilder.f17054b = threadsCollection;
        newBuilder = newBuilder;
        newBuilder.f17055c = c.f16916c;
        newBuilder = newBuilder;
        newBuilder.f17056d = this.f16972c.a();
        newBuilder = newBuilder;
        newBuilder.f17057e = c.f16917d;
        return newBuilder.m17085f();
    }

    @Inject
    public SearchThreadNameAndParticipantsMethod(FetchThreadsFqlHelper fetchThreadsFqlHelper, Clock clock) {
        this.f16971b = fetchThreadsFqlHelper;
        this.f16972c = clock;
    }
}

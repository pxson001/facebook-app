package com.facebook.api.feed;

import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: audience_info */
public class CheckForInvalidStoriesMethod extends AbstractPersistedGraphQlApiMethod<CheckForInvalidStoriesParams, CheckForInvalidStoriesResult> {
    private static final String f8681c = CheckForInvalidStoriesMethod.class.getSimpleName();
    private final Clock f8682d;

    private static CheckForInvalidStoriesMethod m14641b(InjectorLike injectorLike) {
        return new CheckForInvalidStoriesMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike));
    }

    public final Object m14642a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        CheckForInvalidStoriesParams checkForInvalidStoriesParams = (CheckForInvalidStoriesParams) obj;
        Set a = Sets.a();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            throw new RuntimeException("Error - response not expected: " + apiResponse.toString());
        }
        List list;
        while (jsonParser.c() != null) {
            if (jsonParser.i() != null && jsonParser.i().equals("id")) {
                jsonParser.c();
                a.add(jsonParser.o());
            }
        }
        List a2 = Lists.a();
        for (String str : checkForInvalidStoriesParams.f8683a) {
            if (!a.contains(str)) {
                a2.add(str);
            }
        }
        if (((float) a2.size()) <= ((float) a.size()) * 0.2f || a2.size() <= 5) {
            list = a2;
        } else {
            BLog.b(f8681c, "Looks like the server was returning a crazy number of invalid IDs.  We asked about " + a.size() + " and " + a2.size() + "were invalid, so we returned nothing");
            list = Lists.a();
        }
        Integer.valueOf(list.size());
        return new CheckForInvalidStoriesResult(list, DataFreshnessResult.FROM_SERVER, this.f8682d.a());
    }

    public final GraphQlQueryString m14644f(Object obj) {
        CheckForInvalidStoriesParams checkForInvalidStoriesParams = (CheckForInvalidStoriesParams) obj;
        TypedGraphQlQueryString b = FetchInvalidStoriesGraphQl.m16674a().b(true);
        if (checkForInvalidStoriesParams != null) {
            b.a("ids", checkForInvalidStoriesParams.f8683a);
        }
        return b;
    }

    @Inject
    public CheckForInvalidStoriesMethod(Clock clock, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f8682d = clock;
    }

    public final int m14643b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}

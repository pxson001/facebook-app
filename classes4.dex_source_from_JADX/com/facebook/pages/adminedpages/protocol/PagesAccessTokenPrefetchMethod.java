package com.facebook.pages.adminedpages.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fql.FqlMultiQueryHelper;
import com.facebook.fql.FqlResultHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: push_notifications_db */
public class PagesAccessTokenPrefetchMethod implements ApiMethod<Params, Result> {
    PagesInfoFqlHelper f12849a;

    /* compiled from: push_notifications_db */
    public class Result extends BaseResult implements Parcelable {
        public static final Creator<Result> CREATOR = new C01901();
        public Map<String, String> f4011a;

        /* compiled from: push_notifications_db */
        final class C01901 implements Creator<Result> {
            C01901() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(Parcel parcel) {
            super(parcel);
            this.f4011a = new HashMap();
            ParcelUtil.b(parcel, this.f4011a);
        }

        public Result(DataFreshnessResult dataFreshnessResult, long j, Map<String, String> map) {
            super(dataFreshnessResult, j);
            this.f4011a = map;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            ParcelUtil.a(parcel, this.f4011a);
        }
    }

    /* compiled from: push_notifications_db */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C05881();
        public final int f12429a;

        /* compiled from: push_notifications_db */
        final class C05881 implements Creator<Params> {
            C05881() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(int i) {
            this.f12429a = i;
        }

        public Params(Parcel parcel) {
            this.f12429a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f12429a);
        }
    }

    public final ApiRequest m13706a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        FqlMultiQueryHelper fqlMultiQueryHelper = new FqlMultiQueryHelper();
        fqlMultiQueryHelper.m4506a("page_query", "SELECT page_id FROM page_admin WHERE uid = me() AND type != 'APPLICATION' ORDER BY last_used_time DESC LIMIT " + params.f12429a);
        fqlMultiQueryHelper.m4506a("token_query", "SELECT page_id, access_token FROM page WHERE page_id IN (SELECT page_id FROM #page_query)");
        a.add(new BasicNameValuePair("q", fqlMultiQueryHelper.m4505a().toString()));
        return new ApiRequest("page_access_token", TigonRequest.GET, "fql", a, ApiResponseType.JSON);
    }

    @Inject
    public PagesAccessTokenPrefetchMethod(PagesInfoFqlHelper pagesInfoFqlHelper) {
        this.f12849a = pagesInfoFqlHelper;
    }

    public final Object m13707a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        FqlResultHelper fqlResultHelper = new FqlResultHelper(apiResponse.c());
        DataFreshnessResult dataFreshnessResult = DataFreshnessResult.FROM_SERVER;
        long currentTimeMillis = System.currentTimeMillis();
        JsonNode a = fqlResultHelper.m4512a("token_query");
        HashMap c = Maps.c();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode = (JsonNode) it.next();
            JsonNode b = jsonNode.b("page_id");
            jsonNode = jsonNode.b("access_token");
            if (!(b == null || jsonNode == null)) {
                c.put(b.B(), jsonNode.B());
            }
        }
        return new Result(dataFreshnessResult, currentTimeMillis, c);
    }
}

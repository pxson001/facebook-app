package com.facebook.uberbar.analytics;

import com.facebook.debug.log.BLog;
import com.facebook.search.api.SearchTypeaheadResult;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: transactions */
public class SearchClickEvent {
    public final String f1394a;
    private final SearchTypeaheadResult f1395b;
    private final String f1396c;
    private final int f1397d;
    private final List<SearchTypeaheadResult> f1398e;
    private final long f1399f;

    public SearchClickEvent(String str, SearchTypeaheadResult searchTypeaheadResult, int i, String str2, List<SearchTypeaheadResult> list, long j) {
        this.f1394a = str;
        this.f1395b = searchTypeaheadResult;
        this.f1397d = i;
        this.f1396c = str2;
        this.f1398e = list;
        this.f1399f = j;
    }

    public final JSONObject m1508b() {
        long j;
        Object obj;
        Object obj2;
        if (this.f1395b != null) {
            long j2 = this.f1395b.m;
            j = j2;
            obj = this.f1395b.l;
            obj2 = this.f1395b.c;
        } else {
            obj2 = null;
            j = -1;
            obj = null;
        }
        JSONArray jSONArray = new JSONArray();
        if (this.f1395b != null) {
            for (SearchTypeaheadResult searchTypeaheadResult : this.f1398e) {
                jSONArray.put(searchTypeaheadResult.m);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", this.f1394a).put("id", String.valueOf(j)).put("type", String.valueOf(obj)).put("friend_status", String.valueOf(obj2)).put("query", this.f1396c).put("position", String.valueOf(this.f1397d)).put("results", jSONArray.toString()).put("timestamp_ms", this.f1399f);
        } catch (JSONException e) {
            BLog.b("SearchClickEvent", "JSONException when ENCODING data: " + e.getMessage());
        }
        return jSONObject;
    }
}

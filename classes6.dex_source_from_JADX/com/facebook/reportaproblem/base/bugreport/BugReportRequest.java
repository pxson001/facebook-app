package com.facebook.reportaproblem.base.bugreport;

import android.util.Log;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: shipment */
public class BugReportRequest {
    private final String f4550a;
    private final String f4551b;
    private final String f4552c;
    private final Map<String, String> f4553d;
    private final Set<BugReportFile> f4554e;

    public BugReportRequest(String str, String str2, String str3, Map<String, String> map, Set<BugReportFile> set) {
        this.f4550a = str;
        this.f4551b = str2;
        this.f4552c = str3;
        this.f4554e = set;
        this.f4553d = map;
    }

    public final List<NameValuePair> m7039a() {
        List<NameValuePair> arrayList = new ArrayList();
        String l = Long.toString(System.currentTimeMillis() / 1000);
        arrayList.add(new BasicNameValuePair("user_identifier", this.f4550a));
        arrayList.add(new BasicNameValuePair("client_time", l));
        arrayList.add(new BasicNameValuePair("config_id", this.f4551b));
        arrayList.add(new BasicNameValuePair("locale", this.f4552c));
        JSONObject jSONObject = new JSONObject();
        try {
            for (String l2 : this.f4553d.keySet()) {
                jSONObject.put(l2, this.f4553d.get(l2));
            }
            arrayList.add(new BasicNameValuePair("metadata", jSONObject.toString()));
        } catch (Throwable e) {
            Log.w("failed to add metadata to bug report", e);
        }
        return arrayList;
    }

    public final String m7040b() {
        return this.f4550a;
    }

    public final Set<BugReportFile> m7041c() {
        return this.f4554e;
    }
}

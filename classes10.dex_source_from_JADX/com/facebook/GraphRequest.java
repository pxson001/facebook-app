package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: event_buy_tickets_completed */
public class GraphRequest {
    public static final String f13796a = GraphRequest.class.getSimpleName();
    public static String f13797b;
    private static Pattern f13798c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    public static volatile String f13799q;
    public AccessToken f13800d;
    public HttpMethod f13801e;
    public String f13802f;
    public JSONObject f13803g;
    private String f13804h;
    private String f13805i;
    private boolean f13806j;
    public Bundle f13807k;
    public Callback f13808l;
    private String f13809m;
    private Object f13810n;
    public String f13811o;
    public boolean f13812p;

    /* compiled from: event_buy_tickets_completed */
    public interface Callback {
        void mo693a(GraphResponse graphResponse);
    }

    /* compiled from: event_buy_tickets_completed */
    final class C18725 implements Runnable {
        final /* synthetic */ ArrayList f13784a;
        final /* synthetic */ GraphRequestBatch f13785b;

        C18725(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
            this.f13784a = arrayList;
            this.f13785b = graphRequestBatch;
        }

        public final void run() {
            Iterator it = this.f13784a.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ((Callback) pair.first).mo693a((GraphResponse) pair.second);
            }
            for (com.facebook.GraphRequestBatch.Callback a : this.f13785b.f13822f) {
                a.mo694a();
            }
        }
    }

    /* compiled from: event_buy_tickets_completed */
    interface KeyValueSerializer {
        void mo696a(String str, String str2);
    }

    /* compiled from: event_buy_tickets_completed */
    public class Attachment {
        public final GraphRequest f13788a;
        public final Object f13789b;

        public Attachment(GraphRequest graphRequest, Object obj) {
            this.f13788a = graphRequest;
            this.f13789b = obj;
        }
    }

    /* compiled from: event_buy_tickets_completed */
    public interface OnProgressCallback extends Callback {
    }

    /* compiled from: event_buy_tickets_completed */
    public class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new C18741();
        public final String f13790a;
        public final RESOURCE f13791b;

        /* compiled from: event_buy_tickets_completed */
        final class C18741 implements Creator<ParcelableResourceWithMimeType> {
            C18741() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel);
            }

            public final Object[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f13790a);
            parcel.writeParcelable(this.f13791b, i);
        }

        public ParcelableResourceWithMimeType(Parcel parcel) {
            this.f13790a = parcel.readString();
            this.f13791b = parcel.readParcelable(FacebookSdk.m14051f().getClassLoader());
        }
    }

    /* compiled from: event_buy_tickets_completed */
    class Serializer implements KeyValueSerializer {
        private final OutputStream f13792a;
        private final Logger f13793b;
        private boolean f13794c = true;
        private boolean f13795d = false;

        public Serializer(OutputStream outputStream, Logger logger, boolean z) {
            this.f13792a = outputStream;
            this.f13793b = logger;
            this.f13795d = z;
        }

        public final void m14068a(String str, Object obj, GraphRequest graphRequest) {
            if (this.f13792a instanceof RequestOutputStream) {
                ((RequestOutputStream) this.f13792a).mo699a(graphRequest);
            }
            if (GraphRequest.m14094e(obj)) {
                mo696a(str, GraphRequest.m14095f(obj));
            } else if (obj instanceof Bitmap) {
                m14060a(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                m14064a(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                m14061a(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                m14062a(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable parcelable = parcelableResourceWithMimeType.f13791b;
                String str2 = parcelableResourceWithMimeType.f13790a;
                if (parcelable instanceof ParcelFileDescriptor) {
                    m14062a(str, (ParcelFileDescriptor) parcelable, str2);
                } else if (parcelable instanceof Uri) {
                    m14061a(str, (Uri) parcelable, str2);
                } else {
                    throw m14059a();
                }
            } else {
                throw m14059a();
            }
        }

        private static RuntimeException m14059a() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void m14070a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
            if (this.f13792a instanceof RequestOutputStream) {
                RequestOutputStream requestOutputStream = (RequestOutputStream) this.f13792a;
                m14063a(str, null, null);
                m14065a("[", new Object[0]);
                int i = 0;
                for (GraphRequest graphRequest : collection) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    requestOutputStream.mo699a(graphRequest);
                    if (i > 0) {
                        m14065a(",%s", jSONObject.toString());
                    } else {
                        m14065a("%s", jSONObject.toString());
                    }
                    i++;
                }
                m14065a("]", new Object[0]);
                if (this.f13793b != null) {
                    this.f13793b.m25283a("    " + str, jSONArray.toString());
                    return;
                }
                return;
            }
            mo696a(str, jSONArray.toString());
        }

        public final void mo696a(String str, String str2) {
            m14063a(str, null, null);
            m14067b("%s", str2);
            m14066b();
            if (this.f13793b != null) {
                this.f13793b.m25283a("    " + str, (Object) str2);
            }
        }

        private void m14060a(String str, Bitmap bitmap) {
            m14063a(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.f13792a);
            m14067b("", new Object[0]);
            m14066b();
            if (this.f13793b != null) {
                this.f13793b.m25283a("    " + str, (Object) "<Image>");
            }
        }

        private void m14064a(String str, byte[] bArr) {
            m14063a(str, str, "content/unknown");
            this.f13792a.write(bArr);
            m14067b("", new Object[0]);
            m14066b();
            if (this.f13793b != null) {
                this.f13793b.m25283a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
        }

        private void m14061a(String str, Uri uri, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m14063a(str, str, str2);
            InputStream openInputStream = FacebookSdk.m14051f().getContentResolver().openInputStream(uri);
            if (this.f13792a instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.f13792a).m14144a(Utility.m25317a(uri));
                i = 0;
            } else {
                i = Utility.m25315a(openInputStream, this.f13792a) + 0;
            }
            m14067b("", new Object[0]);
            m14066b();
            if (this.f13793b != null) {
                this.f13793b.m25283a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        private void m14062a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m14063a(str, str, str2);
            if (this.f13792a instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.f13792a).m14144a(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = Utility.m25315a(new AutoCloseInputStream(parcelFileDescriptor), this.f13792a) + 0;
            }
            m14067b("", new Object[0]);
            m14066b();
            if (this.f13793b != null) {
                this.f13793b.m25283a("    " + str, String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        private void m14066b() {
            if (this.f13795d) {
                this.f13792a.write("&".getBytes());
                return;
            }
            m14067b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        }

        private void m14063a(String str, String str2, String str3) {
            if (this.f13795d) {
                this.f13792a.write(String.format("%s=", new Object[]{str}).getBytes());
                return;
            }
            m14065a("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                m14065a("; filename=\"%s\"", str2);
            }
            m14067b("", new Object[0]);
            if (str3 != null) {
                m14067b("%s: %s", "Content-Type", str3);
            }
            m14067b("", new Object[0]);
        }

        private void m14065a(String str, Object... objArr) {
            if (this.f13795d) {
                this.f13792a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
                return;
            }
            if (this.f13794c) {
                this.f13792a.write("--".getBytes());
                this.f13792a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                this.f13792a.write("\r\n".getBytes());
                this.f13794c = false;
            }
            this.f13792a.write(String.format(str, objArr).getBytes());
        }

        private void m14067b(String str, Object... objArr) {
            m14065a(str, objArr);
            if (!this.f13795d) {
                m14065a("\r\n", new Object[0]);
            }
        }
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null);
    }

    private GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.f13806j = true;
        this.f13812p = false;
        this.f13800d = accessToken;
        this.f13802f = str;
        this.f13811o = str2;
        m14103a(callback);
        m14082a(httpMethod);
        if (bundle != null) {
            this.f13807k = new Bundle(bundle);
        } else {
            this.f13807k = new Bundle();
        }
        if (this.f13811o == null) {
            this.f13811o = "v2.5";
        }
    }

    public static GraphRequest m14071a(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback);
        graphRequest.f13803g = jSONObject;
        return graphRequest;
    }

    public final JSONObject m14101a() {
        return this.f13803g;
    }

    public final void m14105a(JSONObject jSONObject) {
        this.f13803g = jSONObject;
    }

    private void m14082a(HttpMethod httpMethod) {
        if (this.f13809m == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.f13801e = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final Bundle m14106b() {
        return this.f13807k;
    }

    public final void m14102a(Bundle bundle) {
        this.f13807k = bundle;
    }

    public final void m14103a(final Callback callback) {
        if (FacebookSdk.m14047a(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.m14047a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f13808l = new Callback(this) {
                final /* synthetic */ GraphRequest f13783b;

                public final void mo693a(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    JSONObject jSONObject = graphResponse.f13825b;
                    jSONObject = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
                    if (jSONObject != null) {
                        optJSONArray = jSONObject.optJSONArray("messages");
                    } else {
                        optJSONArray = null;
                    }
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString;
                            String optString2;
                            String optString3;
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                optString = optJSONObject.optString("message");
                            } else {
                                optString = null;
                            }
                            if (optJSONObject != null) {
                                optString2 = optJSONObject.optString("type");
                            } else {
                                optString2 = null;
                            }
                            if (optJSONObject != null) {
                                optString3 = optJSONObject.optString("link");
                            } else {
                                optString3 = null;
                            }
                            if (!(optString == null || optString2 == null)) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals("warning")) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!Utility.m25345a(optString3)) {
                                    optString = optString + " Link: " + optString3;
                                }
                                Logger.m25275a(loggingBehavior, GraphRequest.f13796a, optString);
                            }
                        }
                    }
                    if (callback != null) {
                        callback.mo693a(graphResponse);
                    }
                }
            };
        } else {
            this.f13808l = callback;
        }
    }

    public final void m14104a(Object obj) {
        this.f13810n = obj;
    }

    public final Object m14107e() {
        return this.f13810n;
    }

    public final GraphResponse m14108f() {
        return m14072a(this);
    }

    public final GraphRequestAsyncTask m14109g() {
        Object obj = new GraphRequest[]{this};
        Validate.m25366a(obj, "requests");
        return m14088b(new GraphRequestBatch(Arrays.asList(obj)));
    }

    private static HttpURLConnection m14090c(GraphRequestBatch graphRequestBatch) {
        Throwable e;
        m14096f(graphRequestBatch);
        try {
            URL url;
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.m14111a(0).m14099m());
            } else {
                url = new URL(ServerProtocol.m25309b());
            }
            URLConnection uRLConnection = null;
            try {
                uRLConnection = m14074a(url);
                m14080a(graphRequestBatch, (HttpURLConnection) uRLConnection);
                return uRLConnection;
            } catch (IOException e2) {
                e = e2;
                Utility.m25341a(uRLConnection);
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e3) {
                e = e3;
                Utility.m25341a(uRLConnection);
                throw new FacebookException("could not construct request body", e);
            }
        } catch (Throwable e4) {
            throw new FacebookException("could not construct URL for request", e4);
        }
    }

    private static GraphResponse m14072a(GraphRequest graphRequest) {
        Object obj = new GraphRequest[]{graphRequest};
        Validate.m25366a(obj, "requests");
        List a = m14075a(new GraphRequestBatch(Arrays.asList(obj)));
        if (a != null && a.size() == 1) {
            return (GraphResponse) a.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<GraphResponse> m14075a(GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> a;
        URLConnection uRLConnection = null;
        Validate.m25368a((Collection) graphRequestBatch, "requests");
        try {
            uRLConnection = m14090c(graphRequestBatch);
            try {
                a = m14076a((HttpURLConnection) uRLConnection, graphRequestBatch);
            } finally {
                Utility.m25341a(uRLConnection);
            }
        } catch (Throwable e) {
            List a2 = GraphResponse.m14121a(graphRequestBatch.m14114d(), null, new FacebookException(e));
            m14081a(graphRequestBatch, a2);
            Utility.m25341a(uRLConnection);
        }
        return a;
    }

    public static GraphRequestAsyncTask m14088b(GraphRequestBatch graphRequestBatch) {
        Validate.m25368a((Collection) graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.m14050d(), null);
        return graphRequestAsyncTask;
    }

    public static List<GraphResponse> m14076a(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List a = GraphResponse.m14119a(httpURLConnection, graphRequestBatch);
        Utility.m25341a((URLConnection) httpURLConnection);
        if (graphRequestBatch.size() != a.size()) {
            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(a.size()), Integer.valueOf(graphRequestBatch.size())}));
        }
        m14081a(graphRequestBatch, a);
        AccessTokenManager.m14028a().m14036d();
        return a;
    }

    public String toString() {
        return "{Request: " + " accessToken: " + (this.f13800d == null ? "null" : this.f13800d) + ", graphPath: " + this.f13802f + ", graphObject: " + this.f13803g + ", httpMethod: " + this.f13801e + ", parameters: " + this.f13807k + "}";
    }

    private static void m14081a(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        int size = graphRequestBatch.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            GraphRequest a = graphRequestBatch.m14111a(i);
            if (a.f13808l != null) {
                arrayList.add(new Pair(a.f13808l, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable c18725 = new C18725(arrayList, graphRequestBatch);
            Handler handler = graphRequestBatch.f13818b;
            if (handler == null) {
                c18725.run();
            } else {
                HandlerDetour.a(handler, c18725, 1046404407);
            }
        }
    }

    private static HttpURLConnection m14074a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        String str = "User-Agent";
        if (f13799q == null) {
            f13799q = String.format("%s.%s", new Object[]{"FBAndroidSDK", "4.9.0"});
            if (!Utility.m25345a(InternalSettings.f24001a)) {
                f13799q = String.format(Locale.ROOT, "%s/%s", new Object[]{f13799q, InternalSettings.f24001a});
            }
        }
        httpURLConnection.setRequestProperty(str, f13799q);
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    private void m14097k() {
        String str;
        if (this.f13800d != null) {
            if (!this.f13807k.containsKey("access_token")) {
                str = this.f13800d.f13711h;
                Logger.m25277a(str);
                this.f13807k.putString("access_token", str);
            }
        } else if (!(this.f13812p || this.f13807k.containsKey("access_token"))) {
            str = FacebookSdk.m14053i();
            Validate.m25364a();
            String str2 = FacebookSdk.f13769f;
            if (Utility.m25345a(str) || Utility.m25345a(str2)) {
                Log.d(f13796a, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.f13807k.putString("access_token", str + "|" + str2);
            }
        }
        this.f13807k.putString("sdk", "android");
        this.f13807k.putString("format", "json");
        this.f13807k.putString("locale", Locale.getDefault().toString());
        if (FacebookSdk.m14047a(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.f13807k.putString("debug", "info");
        } else if (FacebookSdk.m14047a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f13807k.putString("debug", "warning");
        }
    }

    private String m14073a(String str) {
        Builder encodedPath = new Builder().encodedPath(str);
        for (String str2 : this.f13807k.keySet()) {
            Object obj = this.f13807k.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (m14094e(obj)) {
                encodedPath.appendQueryParameter(str2, m14095f(obj).toString());
            } else if (this.f13801e == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
            }
        }
        return encodedPath.toString();
    }

    private String m14098l() {
        if (this.f13809m != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String n = m14100n();
        m14097k();
        return m14073a(n);
    }

    private String m14099m() {
        if (this.f13809m != null) {
            return this.f13809m.toString();
        }
        String format;
        if (this.f13801e == HttpMethod.POST && this.f13802f != null && this.f13802f.endsWith("/videos")) {
            format = String.format("https://graph-video.%s", new Object[]{FacebookSdk.f13771h});
        } else {
            format = ServerProtocol.m25309b();
        }
        format = String.format("%s/%s", new Object[]{format, m14100n()});
        m14097k();
        return m14073a(format);
    }

    private String m14100n() {
        if (f13798c.matcher(this.f13802f).matches()) {
            return this.f13802f;
        }
        return String.format("%s/%s", new Object[]{this.f13811o, this.f13802f});
    }

    private void m14086a(JSONArray jSONArray, Map<String, Attachment> map) {
        JSONObject jSONObject = new JSONObject();
        if (this.f13804h != null) {
            jSONObject.put("name", this.f13804h);
            jSONObject.put("omit_response_on_success", this.f13806j);
        }
        if (this.f13805i != null) {
            jSONObject.put("depends_on", this.f13805i);
        }
        String l = m14098l();
        jSONObject.put("relative_url", l);
        jSONObject.put("method", this.f13801e);
        if (this.f13800d != null) {
            Logger.m25277a(this.f13800d.f13711h);
        }
        Iterable arrayList = new ArrayList();
        for (String str : this.f13807k.keySet()) {
            Object obj = this.f13807k.get(str);
            if (m14092d(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f13803g != null) {
            final Iterable arrayList2 = new ArrayList();
            m14087a(this.f13803g, l, new KeyValueSerializer(this) {
                final /* synthetic */ GraphRequest f13787b;

                public final void mo696a(String str, String str2) {
                    arrayList2.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private static boolean m14091d(GraphRequestBatch graphRequestBatch) {
        for (com.facebook.GraphRequestBatch.Callback callback : graphRequestBatch.f13822f) {
            if (callback instanceof com.facebook.GraphRequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).f13808l instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private static void m14084a(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", new Object[]{"3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"}));
    }

    private static boolean m14093e(GraphRequestBatch graphRequestBatch) {
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            for (String str : graphRequest.f13807k.keySet()) {
                if (m14092d(graphRequest.f13807k.get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void m14096f(GraphRequestBatch graphRequestBatch) {
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            if (HttpMethod.GET.equals(graphRequest.f13801e)) {
                int i;
                String str = graphRequest.f13811o;
                if (Utility.m25345a(str)) {
                    i = 1;
                } else {
                    if (str.startsWith("v")) {
                        str = str.substring(1);
                    }
                    String[] split = str.split("\\.");
                    i = ((split.length < 2 || Integer.parseInt(split[0]) <= 2) && (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4)) ? 0 : 1;
                }
                if (i != 0) {
                    Bundle bundle = graphRequest.f13807k;
                    if (!bundle.containsKey("fields") || Utility.m25345a(bundle.getString("fields"))) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        String str2 = "Request";
                        String str3 = "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.";
                        Object[] objArr = new Object[]{graphRequest.f13802f};
                        if (FacebookSdk.m14047a(loggingBehavior)) {
                            Logger.m25274a(loggingBehavior, 5, str2, String.format(str3, objArr));
                        }
                    }
                }
            }
        }
    }

    private static void m14080a(GraphRequestBatch graphRequestBatch, HttpURLConnection httpURLConnection) {
        Throwable th;
        OutputStream progressNoopOutputStream;
        Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int size = graphRequestBatch.size();
        boolean e = m14093e(graphRequestBatch);
        HttpMethod httpMethod = size == 1 ? graphRequestBatch.m14111a(0).f13801e : HttpMethod.POST;
        httpURLConnection.setRequestMethod(httpMethod.name());
        m14084a(httpURLConnection, e);
        Object url = httpURLConnection.getURL();
        logger.m25284b("Request:\n");
        logger.m25283a("Id", graphRequestBatch.m14112b());
        logger.m25283a("URL", url);
        logger.m25283a("Method", httpURLConnection.getRequestMethod());
        logger.m25283a("User-Agent", httpURLConnection.getRequestProperty("User-Agent"));
        logger.m25283a("Content-Type", httpURLConnection.getRequestProperty("Content-Type"));
        httpURLConnection.setConnectTimeout(graphRequestBatch.m14110a());
        httpURLConnection.setReadTimeout(graphRequestBatch.m14110a());
        if (httpMethod == HttpMethod.POST) {
            httpURLConnection.setDoOutput(true);
            OutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                if (e) {
                    try {
                        bufferedOutputStream = new GZIPOutputStream(bufferedOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                }
                if (m14091d(graphRequestBatch)) {
                    progressNoopOutputStream = new ProgressNoopOutputStream(graphRequestBatch.m14113c());
                    m14079a(graphRequestBatch, null, size, url, progressNoopOutputStream, e);
                    progressNoopOutputStream = new ProgressOutputStream(bufferedOutputStream, graphRequestBatch, progressNoopOutputStream.m14146b(), (long) progressNoopOutputStream.m14143a());
                } else {
                    progressNoopOutputStream = bufferedOutputStream;
                }
                try {
                    m14079a(graphRequestBatch, logger, size, url, progressNoopOutputStream, e);
                    progressNoopOutputStream.close();
                    logger.m25282a();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = progressNoopOutputStream;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        }
        logger.m25282a();
    }

    private static void m14079a(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
        Serializer serializer = new Serializer(outputStream, logger, z);
        String str;
        if (i == 1) {
            GraphRequest a = graphRequestBatch.m14111a(0);
            Map hashMap = new HashMap();
            for (String str2 : a.f13807k.keySet()) {
                Object obj = a.f13807k.get(str2);
                if (m14092d(obj)) {
                    hashMap.put(str2, new Attachment(a, obj));
                }
            }
            if (logger != null) {
                logger.m25284b("  Parameters:\n");
            }
            m14077a(a.f13807k, serializer, a);
            if (logger != null) {
                logger.m25284b("  Attachments:\n");
            }
            m14085a(hashMap, serializer);
            if (a.f13803g != null) {
                m14087a(a.f13803g, url.getPath(), (KeyValueSerializer) serializer);
                return;
            }
            return;
        }
        String str3;
        if (Utility.m25345a(graphRequestBatch.f13823g)) {
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = ((GraphRequest) it.next()).f13800d;
                if (accessToken != null) {
                    str3 = accessToken.f13714k;
                    if (str3 != null) {
                        break;
                    }
                }
            }
            if (Utility.m25345a(f13797b)) {
                str3 = FacebookSdk.m14053i();
            } else {
                str3 = f13797b;
            }
        } else {
            str3 = graphRequestBatch.f13823g;
        }
        str2 = str3;
        if (Utility.m25345a(str2)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        serializer.mo696a("batch_app_id", str2);
        Map hashMap2 = new HashMap();
        m14078a(serializer, (Collection) graphRequestBatch, hashMap2);
        if (logger != null) {
            logger.m25284b("  Attachments:\n");
        }
        m14085a(hashMap2, serializer);
    }

    private static boolean m14089b(String str) {
        Matcher matcher = f13798c.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    private static void m14087a(JSONObject jSONObject, String str, KeyValueSerializer keyValueSerializer) {
        Object obj;
        if (m14089b(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            Object obj2 = (indexOf <= 3 || (indexOf2 != -1 && indexOf >= indexOf2)) ? null : 1;
            obj = obj2;
        } else {
            obj = null;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            boolean z;
            String str2 = (String) keys.next();
            Object opt = jSONObject.opt(str2);
            if (obj == null || !str2.equalsIgnoreCase("image")) {
                z = false;
            } else {
                z = true;
            }
            m14083a(str2, opt, keyValueSerializer, z);
        }
    }

    private static void m14083a(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
        Class cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{str, (String) keys.next()};
                    m14083a(String.format("%s[%s]", objArr), jSONObject.opt((String) keys.next()), keyValueSerializer, z);
                }
            } else if (jSONObject.has("id")) {
                m14083a(str, jSONObject.optString("id"), keyValueSerializer, z);
            } else if (jSONObject.has("url")) {
                m14083a(str, jSONObject.optString("url"), keyValueSerializer, z);
            } else if (jSONObject.has("fbsdk:create_object")) {
                m14083a(str, jSONObject.toString(), keyValueSerializer, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                m14083a(String.format(Locale.ROOT, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), keyValueSerializer, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            keyValueSerializer.mo696a(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            keyValueSerializer.mo696a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    private static void m14077a(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m14094e(obj)) {
                serializer.m14068a(str, obj, graphRequest);
            }
        }
    }

    private static void m14085a(Map<String, Attachment> map, Serializer serializer) {
        for (String str : map.keySet()) {
            Attachment attachment = (Attachment) map.get(str);
            if (m14092d(attachment.f13789b)) {
                serializer.m14068a(str, attachment.f13789b, attachment.f13788a);
            }
        }
    }

    private static void m14078a(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest a : collection) {
            a.m14086a(jSONArray, (Map) map);
        }
        serializer.m14070a("batch", jSONArray, (Collection) collection);
    }

    private static boolean m14092d(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    public static boolean m14094e(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static String m14095f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}

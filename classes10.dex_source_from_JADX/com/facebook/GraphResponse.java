package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: eventLocation */
public class GraphResponse {
    private final HttpURLConnection f13824a;
    public final JSONObject f13825b;
    private final JSONArray f13826c;
    public final FacebookRequestError f13827d;
    private final String f13828e;
    private final GraphRequest f13829f;

    private GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    private GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    private GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    private GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f13829f = graphRequest;
        this.f13824a = httpURLConnection;
        this.f13828e = str;
        this.f13825b = jSONObject;
        this.f13826c = jSONArray;
        this.f13827d = facebookRequestError;
    }

    public final FacebookRequestError m14122a() {
        return this.f13827d;
    }

    public final JSONObject m14123b() {
        return this.f13825b;
    }

    public String toString() {
        String format;
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.f13824a != null ? this.f13824a.getResponseCode() : 200);
            format = String.format(locale, str, objArr);
        } catch (IOException e) {
            format = "unknown";
        }
        return "{Response: " + " responseCode: " + format + ", graphObject: " + this.f13825b + ", error: " + this.f13827d + "}";
    }

    static List<GraphResponse> m14119a(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> a;
        Closeable closeable = null;
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                closeable = httpURLConnection.getErrorStream();
            } else {
                closeable = httpURLConnection.getInputStream();
            }
            a = m14117a((InputStream) closeable, httpURLConnection, graphRequestBatch);
        } catch (FacebookException e) {
            Logger.m25276a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e);
            a = m14121a((List) graphRequestBatch, httpURLConnection, e);
        } catch (Throwable e2) {
            Logger.m25276a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e2);
            a = m14121a((List) graphRequestBatch, httpURLConnection, new FacebookException(e2));
        } catch (Throwable e22) {
            Logger.m25276a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e22);
            a = m14121a((List) graphRequestBatch, httpURLConnection, new FacebookException(e22));
        } catch (Throwable e222) {
            Logger.m25276a(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", e222);
            a = m14121a((List) graphRequestBatch, httpURLConnection, new FacebookException(e222));
        } finally {
            Utility.m25336a(closeable);
        }
        return a;
    }

    private static List<GraphResponse> m14117a(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Logger.m25276a(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(Utility.m25324a(inputStream).length()), r0);
        return m14118a(Utility.m25324a(inputStream), httpURLConnection, graphRequestBatch);
    }

    private static List<GraphResponse> m14118a(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Logger.m25276a(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.f13821e, Integer.valueOf(str.length()), m14120a(httpURLConnection, (List) graphRequestBatch, new JSONTokener(str).nextValue()));
        return m14120a(httpURLConnection, (List) graphRequestBatch, new JSONTokener(str).nextValue());
    }

    private static List<GraphResponse> m14120a(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) {
        JSONArray jSONArray;
        int i = 0;
        int size = list.size();
        List<GraphResponse> arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = (GraphRequest) list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e)));
                jSONArray = obj;
            } catch (Exception e2) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
            }
            if ((jSONArray instanceof JSONArray) || jSONArray.length() != size) {
                throw new FacebookException("Unexpected number of results");
            }
            jSONArray = jSONArray;
            while (i < jSONArray.length()) {
                graphRequest = (GraphRequest) list.get(i);
                try {
                    arrayList.add(m14116a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                } catch (Exception e3) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
                } catch (Exception e32) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e32)));
                }
                i++;
            }
            return arrayList;
        }
        jSONArray = obj;
        if (jSONArray instanceof JSONArray) {
        }
        throw new FacebookException("Unexpected number of results");
    }

    private static GraphResponse m14116a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError a = FacebookRequestError.m14038a(jSONObject, obj2, httpURLConnection);
            if (a != null) {
                if (a.f13750d == 190) {
                    boolean equals;
                    AccessToken accessToken = graphRequest.f13800d;
                    if (accessToken != null) {
                        equals = accessToken.equals(AccessToken.m14004a());
                    } else {
                        equals = false;
                    }
                    if (equals) {
                        AccessTokenManager.m14028a().m14033a(null);
                    }
                }
                return new GraphResponse(graphRequest, httpURLConnection, a);
            }
            Object a2 = Utility.m25322a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (a2 instanceof JSONObject) {
                return new GraphResponse(graphRequest, httpURLConnection, a2.toString(), (JSONObject) a2);
            }
            if (a2 instanceof JSONArray) {
                return new GraphResponse(graphRequest, httpURLConnection, a2.toString(), (JSONArray) a2);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), null);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    static List<GraphResponse> m14121a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        List<GraphResponse> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new GraphResponse((GraphRequest) list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }
}

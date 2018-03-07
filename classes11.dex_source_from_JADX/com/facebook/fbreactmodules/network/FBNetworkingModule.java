package com.facebook.fbreactmodules.network;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.config.server.UserAgentFactory;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.entity.mime.GzipCompressingEntity;
import com.facebook.http.entity.mime.apache.MultipartEntity;
import com.facebook.http.entity.mime.apache.content.StringBody;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.net.URI;
import java.util.ArrayList;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/* compiled from: edit_bio */
public class FBNetworkingModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private final FbHttpRequestProcessor f7502a;
    private final Object f7503b = new Object();
    private final SparseArray<FbHttpRequest<ResponseData>> f7504c = new SparseArray();
    private final CallerContext f7505d;
    private final String f7506e;
    private final ResponseHandler<ResponseData> f7507f = new C09501(this);

    /* compiled from: edit_bio */
    class C09501 implements ResponseHandler<ResponseData> {
        final /* synthetic */ FBNetworkingModule f7496a;

        C09501(FBNetworkingModule fBNetworkingModule) {
            this.f7496a = fBNetworkingModule;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            ResponseData responseData = new ResponseData();
            HttpEntity entity = httpResponse.getEntity();
            responseData.f7501c = entity != null ? EntityUtils.toString(entity) : null;
            responseData.f7500b = httpResponse.getAllHeaders();
            responseData.f7499a = httpResponse.getStatusLine().getStatusCode();
            return responseData;
        }
    }

    /* compiled from: edit_bio */
    class ResponseData {
        int f7499a;
        Header[] f7500b;
        String f7501c;
    }

    private RCTDeviceEventEmitter m8709r() {
        return (RCTDeviceEventEmitter) this.a.a(RCTDeviceEventEmitter.class);
    }

    public final void m8710c() {
        this.a.a(this);
    }

    public FBNetworkingModule(ReactApplicationContext reactApplicationContext, FbHttpRequestProcessor fbHttpRequestProcessor, CallerContext callerContext, UserAgentFactory userAgentFactory) {
        super(reactApplicationContext);
        this.f7502a = fbHttpRequestProcessor;
        this.f7505d = callerContext;
        this.f7506e = userAgentFactory.a();
    }

    public String getName() {
        return "RCTNetworking";
    }

    @ReactMethod
    public void abortRequest(int i) {
        FbHttpRequest a = m8693a(i);
        if (a != null) {
            this.f7502a.c(a);
        }
    }

    @ReactMethod
    public void sendRequest(String str, String str2, int i, ReadableArray readableArray, ReadableMap readableMap, boolean z, int i2) {
        try {
            m8704a(str, str2, i, readableArray, readableMap);
        } catch (Throwable e) {
            BLog.b(FBNetworkingModule.class, "Error while preparing request", e);
            m8708b(this, i, e.getMessage());
        }
    }

    private void m8704a(String str, String str2, final int i, ReadableArray readableArray, ReadableMap readableMap) {
        HttpUriRequest httpGet;
        URI create = URI.create(str2);
        Header[] a = m8707a(readableArray);
        if ("GET".equalsIgnoreCase(str)) {
            httpGet = new HttpGet(create);
            m8706a(httpGet, a);
        } else if ("POST".equalsIgnoreCase(str)) {
            if (readableMap.hasKey("string")) {
                httpGet = m8697a(a, readableMap.getString("string"));
            } else if (readableMap.hasKey("formData")) {
                httpGet = m8696a(a, readableMap.a("formData"));
            } else {
                throw new IllegalArgumentException("Unsupported POST data type");
            }
            r0.setURI(create);
            m8705a(r0);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP request method " + str);
        }
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.c = "react_native";
        newBuilder = newBuilder;
        newBuilder.d = this.f7505d;
        newBuilder = newBuilder;
        newBuilder.e = "ReactNativeHTTP";
        newBuilder = newBuilder;
        newBuilder.b = httpGet;
        Builder builder = newBuilder;
        builder.g = this.f7507f;
        FbHttpRequest a2 = builder.a();
        m8700a(i, a2);
        Futures.a(this.f7502a.b(a2).b, new FutureCallback<ResponseData>(this) {
            final /* synthetic */ FBNetworkingModule f7498b;

            public void onSuccess(@Nullable Object obj) {
                ResponseData responseData = (ResponseData) Assertions.b((ResponseData) obj);
                this.f7498b.m8693a(i);
                this.f7498b.m8699a(i, responseData);
            }

            public void onFailure(Throwable th) {
                this.f7498b.m8693a(i);
                BLog.b(FBNetworkingModule.class, "Error while invoking request", th);
                FBNetworkingModule.m8708b(this.f7498b, i, th.getMessage());
            }
        });
    }

    private void m8701a(int i, String str) {
        WritableArray a = Arguments.a();
        a.pushInt(i);
        a.pushString(str);
        m8709r().emit("didReceiveNetworkData", a);
    }

    public static void m8708b(FBNetworkingModule fBNetworkingModule, int i, String str) {
        WritableArray a = Arguments.a();
        a.pushInt(i);
        a.pushString(str);
        fBNetworkingModule.m8709r().emit("didCompleteNetworkResponse", a);
    }

    private void m8699a(int i, ResponseData responseData) {
        m8698a(i, responseData.f7499a, responseData.f7500b);
        m8701a(i, responseData.f7501c);
        WritableArray a = Arguments.a();
        a.pushInt(i);
        a.pushNull();
        m8709r().emit("didCompleteNetworkResponse", a);
    }

    private void m8698a(int i, int i2, Header[] headerArr) {
        WritableMap a = m8695a(headerArr);
        WritableArray a2 = Arguments.a();
        a2.pushInt(i);
        a2.pushInt(i2);
        a2.a(a);
        m8709r().emit("didReceiveNetworkResponse", a2);
    }

    private static WritableMap m8695a(Header[] headerArr) {
        WritableMap b = Arguments.b();
        for (Header header : headerArr) {
            String name = header.getName();
            if (b.hasKey(name)) {
                b.putString(name, b.getString(name) + ", " + header.getValue());
            } else {
                b.putString(name, header.getValue());
            }
        }
        return b;
    }

    private static HttpPost m8697a(@Nullable Header[] headerArr, String str) {
        int i;
        int i2 = 0;
        HttpPost httpPost = new HttpPost();
        Object stringEntity = new StringEntity(str);
        httpPost.setEntity(stringEntity);
        if (headerArr != null) {
            i = 0;
            while (i2 < headerArr.length) {
                if (headerArr[i2].getName().equalsIgnoreCase("content-type")) {
                    stringEntity.setContentType(headerArr[i2].getValue());
                    i = 1;
                } else {
                    httpPost.addHeader(headerArr[i2]);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return httpPost;
        }
        throw new IllegalArgumentException("Payload is set but no content-type header specified");
    }

    private HttpPost m8696a(@Nullable Header[] headerArr, ReadableArray readableArray) {
        MultipartEntity multipartEntity = new MultipartEntity();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap b = readableArray.b(i);
            String string = b.getString("fieldName");
            if (string == null) {
                throw new IllegalArgumentException("Attribute 'name' missing for formData part at index " + i);
            }
            if (b.hasKey("string")) {
                multipartEntity.a(string, new StringBody(b.getString("string")));
            } else if (b.hasKey("uri")) {
                String string2 = b.getString("uri");
                String string3 = b.getString("name");
                String string4 = b.getString("type");
                if (string3 == null || string4 == null) {
                    throw new IllegalArgumentException("Incomplete payload for URI formData part");
                }
                multipartEntity.a(string, new ContentUriBody(this.a.getContentResolver(), Uri.parse(string2), string4, string3));
            } else {
                throw new IllegalArgumentException("Unrecognized FormData part.");
            }
        }
        HttpUriRequest httpPost = new HttpPost();
        m8706a(httpPost, headerArr);
        httpPost.setEntity(multipartEntity);
        return httpPost;
    }

    private static void m8706a(HttpUriRequest httpUriRequest, @Nullable Header[] headerArr) {
        if (headerArr != null) {
            for (Header addHeader : headerArr) {
                httpUriRequest.addHeader(addHeader);
            }
        }
    }

    @Nullable
    private Header[] m8707a(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        int size = readableArray.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ReadableArray a = readableArray.a(i2);
            if (a == null || a.size() != 2) {
                throw new JSApplicationCausedNativeException("Unexpected structure of headers array");
            }
            String string = a.getString(0);
            String string2 = a.getString(1);
            if (string.equalsIgnoreCase("user-agent")) {
                i = 1;
            }
            arrayList.add(new BasicHeader(string, string2));
        }
        if (i == 0) {
            arrayList.add(new BasicHeader("user-agent", this.f7506e));
        }
        return (Header[]) arrayList.toArray(new Header[0]);
    }

    private static void m8705a(HttpPost httpPost) {
        Header firstHeader = httpPost.getFirstHeader("content-encoding");
        if (firstHeader != null) {
            httpPost.removeHeader(firstHeader);
        }
        HttpEntity entity = httpPost.getEntity();
        Header header = (Header) Preconditions.checkNotNull(entity.getContentType(), "Unexpected entitiy with no COntent-Type defined");
        if (firstHeader != null || "application/x-www-form-urlencoded".equals(header)) {
            httpPost.setEntity(new GzipCompressingEntity(entity));
        }
    }

    private void m8700a(int i, FbHttpRequest<ResponseData> fbHttpRequest) {
        synchronized (this.f7503b) {
            this.f7504c.put(i, fbHttpRequest);
        }
    }

    @Nullable
    private FbHttpRequest<ResponseData> m8693a(int i) {
        FbHttpRequest<ResponseData> fbHttpRequest;
        synchronized (this.f7503b) {
            fbHttpRequest = (FbHttpRequest) this.f7504c.get(i);
            this.f7504c.remove(i);
        }
        return fbHttpRequest;
    }

    public final void hf_() {
    }

    public final void hg_() {
    }

    public final void hh_() {
        synchronized (this.f7503b) {
            int size = this.f7504c.size();
            for (int i = 0; i < size; i++) {
                FbHttpRequest fbHttpRequest = (FbHttpRequest) this.f7504c.valueAt(i);
                if (fbHttpRequest != null) {
                    this.f7502a.c(fbHttpRequest);
                }
            }
            this.f7504c.clear();
        }
    }
}

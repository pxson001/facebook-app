package com.facebook.adinterfaces.protocol;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

@ContextScoped
/* compiled from: Verbose */
public class UploadAdImageMethod implements ApiMethod<Params, Result> {
    private static UploadAdImageMethod f22420b;
    private static final Object f22421c = new Object();
    private String f22422a;

    /* compiled from: Verbose */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C25531();
        public final String f22416a;
        public final String f22417b;

        /* compiled from: Verbose */
        final class C25531 implements Creator<Params> {
            C25531() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(String str, String str2) {
            this.f22416a = str;
            this.f22417b = str2;
        }

        public Params(Parcel parcel) {
            this.f22416a = parcel.readString();
            this.f22417b = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f22416a);
            parcel.writeString(this.f22417b);
        }
    }

    /* compiled from: Verbose */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C25541();
        public final String f22418a;
        public final String f22419b;

        /* compiled from: Verbose */
        final class C25541 implements Creator<Result> {
            C25541() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        public Result(String str, String str2) {
            this.f22418a = str;
            this.f22419b = str2;
        }

        public Result(Parcel parcel) {
            this.f22418a = parcel.readString();
            this.f22419b = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f22418a);
            parcel.writeString(this.f22419b);
        }
    }

    private static UploadAdImageMethod m24291a() {
        return new UploadAdImageMethod();
    }

    public final ApiRequest m24293a(Object obj) {
        Params params = (Params) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        File file = new File(params.f22417b);
        this.f22422a = file.getName();
        FormBodyPart formBodyPart = new FormBodyPart("source", new DataStreamBody(file, "image/jpeg", this.f22422a));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "uploadAdImage";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("act_%s/adimages", params.f22416a);
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = ImmutableList.of(formBodyPart);
        return apiRequestBuilder.C();
    }

    public final Object m24294a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        if (apiResponse.c() == null || apiResponse.c().b("images") == null || apiResponse.c().b("images").b(this.f22422a) == null) {
            return null;
        }
        JsonNode b = apiResponse.c().b("images").b(this.f22422a);
        if (b.b("hash") == null || b.b("url") == null) {
            return null;
        }
        return new Result(b.b("hash").s(), b.b("url").s());
    }

    public static UploadAdImageMethod m24292a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UploadAdImageMethod a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f22421c) {
                UploadAdImageMethod uploadAdImageMethod;
                if (a3 != null) {
                    uploadAdImageMethod = (UploadAdImageMethod) a3.a(f22421c);
                } else {
                    uploadAdImageMethod = f22420b;
                }
                if (uploadAdImageMethod == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24291a();
                        if (a3 != null) {
                            a3.a(f22421c, a2);
                        } else {
                            f22420b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = uploadAdImageMethod;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

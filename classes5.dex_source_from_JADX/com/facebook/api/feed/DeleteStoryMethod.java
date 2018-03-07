package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: audience */
public class DeleteStoryMethod implements ApiMethod<Params, Void> {
    private static volatile DeleteStoryMethod f8692a;

    /* compiled from: audience */
    public class Params implements Parcelable {
        public static final Creator<Params> CREATOR = new C09391();
        public final String f8688a;
        public final List<String> f8689b;
        public final String f8690c;
        public final DeleteMode f8691d;

        /* compiled from: audience */
        final class C09391 implements Creator<Params> {
            C09391() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Params(parcel);
            }

            public final Object[] newArray(int i) {
                return new Params[i];
            }
        }

        /* compiled from: audience */
        public enum DeleteMode {
            LOCAL_ONLY,
            LOCAL_AND_SERVER
        }

        public Params(String str, List<String> list, String str2, DeleteMode deleteMode) {
            this.f8688a = str;
            this.f8689b = list;
            this.f8690c = str2;
            this.f8691d = deleteMode;
        }

        public Params(Parcel parcel) {
            this.f8688a = parcel.readString();
            this.f8689b = Lists.a();
            parcel.readStringList(this.f8689b);
            this.f8690c = parcel.readString();
            this.f8691d = DeleteMode.valueOf(parcel.readString());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8688a);
            parcel.writeStringList(this.f8689b);
            parcel.writeString(this.f8690c);
            parcel.writeString(this.f8691d.toString());
        }

        public String toString() {
            return Objects.toStringHelper(this).add("method", "DeleteStoryMethod").add("legacyApiPostId", String.valueOf(this.f8688a)).add("cacheIds", String.valueOf(this.f8689b)).add("storyId", String.valueOf(this.f8690c)).add("deleteFromServer", this.f8691d.toString()).toString();
        }
    }

    public static com.facebook.api.feed.DeleteStoryMethod m14646a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8692a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.feed.DeleteStoryMethod.class;
        monitor-enter(r1);
        r0 = f8692a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14645a();	 Catch:{ all -> 0x0034 }
        f8692a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8692a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.DeleteStoryMethod.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.DeleteStoryMethod");
    }

    private static DeleteStoryMethod m14645a() {
        return new DeleteStoryMethod();
    }

    public final ApiRequest m14647a(Object obj) {
        Params params = (Params) obj;
        if (params.f8691d != DeleteMode.LOCAL_AND_SERVER) {
            throw new RuntimeException("Trying to get API request when we should not be deleting from server");
        }
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphStoryDelete", "DELETE", params.f8688a, a, ApiResponseType.JSON);
    }

    public final Object m14648a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

package com.facebook.platform.opengraph;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bitmaps.BitmapException;
import com.facebook.bitmaps.BitmapImageSourceException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.action.PlatformAppCall;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: file_key */
public class OpenGraphRequest {
    private final BitmapUtils f14882a;
    private final Context f14883b;
    public final ObjectNode f14884c;
    public final String f14885d;
    public final String f14886e;
    private boolean f14887f;
    private final Map<Uri, Bitmap> f14888g = Maps.c();
    public final Set<String> f14889h = Sets.a();
    private Uri f14890i;
    private final Set<Uri> f14891j = Sets.a();

    /* compiled from: file_key */
    public class OpenGraphRequestException extends Exception {
        public OpenGraphRequestException(String str) {
            super(str);
        }

        public OpenGraphRequestException(String str, Throwable th) {
            super(str, th);
        }

        public final Bundle m22506a(PlatformAppCall platformAppCall) {
            Throwable cause = getCause();
            if (cause != null) {
                return PlatformAppResults.m5895a(platformAppCall, cause, getMessage());
            }
            return null;
        }
    }

    /* compiled from: file_key */
    public class SavedInstanceState implements Parcelable {
        public static final Creator<SavedInstanceState> CREATOR = new C09741();
        final String f14879a;
        final String f14880b;
        final String f14881c;

        /* compiled from: file_key */
        final class C09741 implements Creator<SavedInstanceState> {
            C09741() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedInstanceState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedInstanceState[i];
            }
        }

        public SavedInstanceState(OpenGraphRequest openGraphRequest) {
            this.f14879a = openGraphRequest.f14884c.toString();
            this.f14880b = openGraphRequest.f14885d;
            this.f14881c = openGraphRequest.f14886e;
        }

        SavedInstanceState(Parcel parcel) {
            this.f14879a = parcel.readString();
            this.f14880b = parcel.readString();
            this.f14881c = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f14879a);
            parcel.writeString(this.f14880b);
            parcel.writeString(this.f14881c);
        }
    }

    OpenGraphRequest(BitmapUtils bitmapUtils, Context context, ObjectNode objectNode, String str, String str2) {
        this.f14882a = bitmapUtils;
        this.f14883b = context;
        this.f14884c = objectNode;
        this.f14885d = str;
        this.f14886e = str2;
    }

    public final ObjectNode m22515a() {
        m22512i();
        ObjectNode I = this.f14884c.I();
        m22509a(I);
        m22511c(I);
        for (String b : this.f14889h) {
            m22511c((ObjectNode) I.b(b));
        }
        return I;
    }

    public final ObjectNode m22516a(Bundle bundle) {
        m22512i();
        ObjectNode I = this.f14884c.I();
        m22509a(I);
        if (bundle != null) {
            m22510b(I, bundle);
            for (String b : this.f14889h) {
                m22510b((ObjectNode) I.b(b), bundle);
            }
        }
        ArrayNode arrayNode = (ArrayNode) I.b("image");
        if (arrayNode != null) {
            int e = arrayNode.e();
            for (int i = 0; i < e; i++) {
                Iterator H = ((ObjectNode) arrayNode.a(i)).H();
                while (H.hasNext()) {
                    Object[] objArr = new Object[]{Integer.valueOf(i), ((Entry) H.next()).getKey()};
                    I.c(StringFormatUtil.a("image[%d][%s]", objArr), (JsonNode) ((Entry) H.next()).getValue());
                }
            }
            I.h("image");
        }
        return I;
    }

    public final String m22518b() {
        return this.f14885d;
    }

    public final String m22519c() {
        return this.f14886e;
    }

    public final Uri m22520d() {
        m22512i();
        return this.f14890i;
    }

    public final ImmutableMap<Uri, Bitmap> m22521e() {
        m22512i();
        return ImmutableMap.copyOf(this.f14888g);
    }

    public final ImmutableSet<Uri> m22522f() {
        m22512i();
        return ImmutableSet.copyOf(this.f14891j);
    }

    public final boolean m22517a(String str) {
        m22512i();
        return this.f14889h.contains(str);
    }

    public final void m22523h() {
        if (!this.f14887f) {
            m22513j();
            m22514k();
            this.f14887f = true;
        }
    }

    private void m22512i() {
        Preconditions.checkState(this.f14887f, "OpenGraphRequest::validate was not called.");
    }

    private void m22513j() {
        Iterator H = this.f14884c.H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            if (((JsonNode) entry.getValue()).i()) {
                ObjectNode objectNode = (ObjectNode) entry.getValue();
                if (objectNode.d("fbsdk:create_object") && objectNode.b("fbsdk:create_object").a(false)) {
                    JsonNode b = objectNode.b("type");
                    if (b == null || !b.o()) {
                        throw new OpenGraphRequestException("Unable to determine type of Open Graph object: " + ((String) entry.getKey()));
                    }
                    this.f14889h.add(entry.getKey());
                }
            }
        }
    }

    private void m22514k() {
        JsonNode b = this.f14884c.b("image");
        if (b != null) {
            ArrayNode arrayNode = (ArrayNode) m22507a(b, null, true);
            if (arrayNode == null) {
                throw new OpenGraphRequestException("Unable to process attached image property");
            }
            m22508a(arrayNode);
            this.f14884c.c("image", arrayNode);
        }
        for (String str : this.f14889h) {
            ObjectNode objectNode = (ObjectNode) this.f14884c.b(str);
            JsonNode b2 = objectNode.b("image");
            if (b2 == null) {
                b2 = objectNode.b("og:image");
                if (b2 != null) {
                    objectNode.h("og:image");
                }
            }
            if (b2 != null) {
                ArrayNode arrayNode2 = (ArrayNode) m22507a(b2, str, true);
                if (arrayNode2 == null) {
                    throw new OpenGraphRequestException("Unable to process attached image property on " + str);
                }
                m22508a(arrayNode2);
                objectNode.c("image", arrayNode2);
            }
        }
    }

    private JsonNode m22507a(JsonNode jsonNode, String str, boolean z) {
        JsonNode arrayNode;
        boolean z2 = true;
        boolean z3 = str == null;
        boolean z4;
        if (str == null || !str.equalsIgnoreCase(this.f14886e)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!(this.f14890i == null && (z3 || r0))) {
            z2 = false;
        }
        if (jsonNode.h() && z) {
            ArrayNode arrayNode2 = (ArrayNode) jsonNode;
            arrayNode = new ArrayNode(JsonNodeFactory.a);
            int e = arrayNode2.e();
            for (int i = 0; i < e; i++) {
                JsonNode a = m22507a(arrayNode2.a(i), str, false);
                if (a == null) {
                    return null;
                }
                arrayNode.a(a);
            }
            z = false;
        } else if (jsonNode.i()) {
            if (jsonNode.d("url")) {
                if (z2) {
                    this.f14890i = Uri.parse(jsonNode.b("url").B());
                }
                arrayNode = jsonNode;
            } else {
                throw new OpenGraphRequestException("Image node does not have 'url' property.");
            }
        } else if (jsonNode.o()) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            String B = jsonNode.B();
            objectNode.a("url", B);
            if (z2) {
                this.f14890i = Uri.parse(B);
            }
            arrayNode = objectNode;
        } else {
            throw new OpenGraphRequestException("Unable to parse image node.");
        }
        if (!z) {
            return arrayNode;
        }
        JsonNode arrayNode3 = new ArrayNode(JsonNodeFactory.a);
        arrayNode3.a(arrayNode);
        return arrayNode3;
    }

    private void m22508a(ArrayNode arrayNode) {
        try {
            int e = arrayNode.e();
            for (int i = 0; i < e; i++) {
                JsonNode jsonNode = (ObjectNode) arrayNode.a(i);
                String B = jsonNode.b("url").B();
                if (B != null) {
                    Uri parse = Uri.parse(B);
                    if (B.startsWith("content:") || B.startsWith("file:")) {
                        try {
                            Bitmap a = this.f14882a.a(this.f14883b, parse, 960, 960, true);
                            if (a == null) {
                                throw new OpenGraphRequestException("Error retrieving image attachment.");
                            }
                            this.f14888g.put(parse, a);
                        } catch (BitmapImageSourceException e2) {
                            throw new OpenGraphRequestException("Error retrieving image attachment.  Check that the NativeAppCallContentProvider in your AndroidManifest.xml contains android:exported=\"true\".");
                        }
                    }
                    JsonNode b = jsonNode.b("user_generated");
                    if (b != null && b.a(false)) {
                        this.f14891j.add(parse);
                    }
                }
            }
        } catch (BitmapException e3) {
            throw new OpenGraphRequestException("Error retrieving image attachment.", e3);
        }
    }

    private void m22509a(ObjectNode objectNode) {
        for (String b : this.f14889h) {
            ObjectNode objectNode2 = (ObjectNode) objectNode.b(b);
            objectNode2.h("fbsdk:create_object");
            objectNode2.h("type");
        }
    }

    public static void m22511c(ObjectNode objectNode) {
        if (objectNode.d("image")) {
            objectNode.h("image");
        }
    }

    public static void m22510b(ObjectNode objectNode, Bundle bundle) {
        if (objectNode.d("image")) {
            ArrayNode arrayNode = (ArrayNode) objectNode.b("image");
            int e = arrayNode.e();
            for (int i = 0; i < e; i++) {
                ObjectNode objectNode2 = (ObjectNode) arrayNode.a(i);
                String B = objectNode2.b("url").B();
                if (B != null && bundle.containsKey(B)) {
                    objectNode2.a("url", bundle.getString(B));
                }
            }
        }
    }
}

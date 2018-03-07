package com.facebook.platform.opengraph.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.platform.server.protocol.ProxiedAppMethodParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: field_type_name */
public class PublishOpenGraphActionMethod$Params extends ProxiedAppMethodParams {
    public static final Creator<PublishOpenGraphActionMethod$Params> CREATOR = new C09811();
    public final String f14912d;
    private final String f14913e;
    private final boolean f14914f;
    private final boolean f14915g;
    private final String f14916h;
    private final HashSet<Long> f14917i;
    private final String f14918j;
    private final String f14919k;
    public final HashMap<String, String> f14920l;

    /* compiled from: field_type_name */
    final class C09811 implements Creator<PublishOpenGraphActionMethod$Params> {
        C09811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new PublishOpenGraphActionMethod$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new PublishOpenGraphActionMethod$Params[i];
        }
    }

    public PublishOpenGraphActionMethod$Params(String str, ObjectNode objectNode, String str2, String str3, Set<Long> set, String str4, String str5, boolean z, boolean z2, String str6, String str7, String str8) {
        super(str6, str7, str8);
        this.f14912d = str;
        this.f14913e = str3;
        this.f14917i = new HashSet(set);
        this.f14918j = str4;
        this.f14919k = str5;
        this.f14916h = str2;
        this.f14914f = z;
        this.f14915g = z2;
        this.f14920l = new HashMap();
        Iterator H = objectNode.H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            JsonNode jsonNode = (JsonNode) entry.getValue();
            this.f14920l.put(entry.getKey(), jsonNode.o() ? jsonNode.B() : jsonNode.toString());
        }
    }

    public PublishOpenGraphActionMethod$Params(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        this.f14912d = parcel.readString();
        this.f14920l = (HashMap) parcel.readSerializable();
        this.f14917i = (HashSet) parcel.readSerializable();
        this.f14918j = parcel.readString();
        this.f14919k = parcel.readString();
        this.f14916h = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f14914f = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f14915g = z2;
        this.f14913e = parcel.readString();
    }

    public final void mo1180a(List<NameValuePair> list) {
        super.mo1180a(list);
        list.add(new BasicNameValuePair("user_selected_tags", String.valueOf(this.f14914f)));
        list.add(new BasicNameValuePair("user_selected_place", String.valueOf(this.f14915g)));
        for (String str : this.f14920l.keySet()) {
            list.add(new BasicNameValuePair(str, (String) this.f14920l.get(str)));
        }
        if (this.f14916h != null) {
            list.add(new BasicNameValuePair("message", this.f14916h));
        }
        if (this.f14917i != null && this.f14917i.size() > 0) {
            list.add(new BasicNameValuePair("tags", TextUtils.join(",", this.f14917i)));
        }
        if (this.f14918j != null) {
            list.add(new BasicNameValuePair("place", this.f14918j));
        }
        if (this.f14919k != null) {
            list.add(new BasicNameValuePair("privacy", this.f14919k));
        }
        if (this.f14913e != null) {
            list.add(new BasicNameValuePair("fb:channel", this.f14913e));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f14912d);
        parcel.writeSerializable(this.f14920l);
        parcel.writeSerializable(this.f14917i);
        parcel.writeString(this.f14918j);
        parcel.writeString(this.f14919k);
        parcel.writeString(this.f14916h);
        if (this.f14914f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f14915g) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f14913e);
    }
}

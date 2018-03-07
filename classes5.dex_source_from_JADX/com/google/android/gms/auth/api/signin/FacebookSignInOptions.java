package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookSignInOptions implements SafeParcelable {
    public static final Creator<FacebookSignInOptions> CREATOR = new zzb();
    public final int f6365a;
    public Intent f6366b;
    private final ArrayList<String> f6367c;

    public FacebookSignInOptions() {
        this(1, null, new ArrayList());
    }

    FacebookSignInOptions(int i, Intent intent, ArrayList<String> arrayList) {
        this.f6365a = i;
        this.f6366b = intent;
        this.f6367c = arrayList;
    }

    private JSONObject m12065d() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f6367c.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("scopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final ArrayList<String> m12066b() {
        return new ArrayList(this.f6367c);
    }

    public final String m12067c() {
        return m12065d().toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            FacebookSignInOptions facebookSignInOptions = (FacebookSignInOptions) obj;
            return this.f6367c.size() == facebookSignInOptions.m12066b().size() && this.f6367c.containsAll(facebookSignInOptions.m12066b());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        Collections.sort(this.f6367c);
        return this.f6367c.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6365a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f6366b, i, false);
        zzb.m12257b(parcel, 3, m12066b(), false);
        zzb.m12258c(parcel, a);
    }
}

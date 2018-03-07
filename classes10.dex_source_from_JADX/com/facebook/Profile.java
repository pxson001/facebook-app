package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: event/{%s}/messagefriends */
public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new C18762();
    private final String f13833a;
    private final String f13834b;
    private final String f13835c;
    private final String f13836d;
    private final String f13837e;
    private final Uri f13838f;

    /* compiled from: event/{%s}/messagefriends */
    public final class C18751 implements GraphMeRequestWithCacheCallback {
        public final void mo698a(JSONObject jSONObject) {
            String optString = jSONObject.optString("id");
            if (optString != null) {
                String optString2 = jSONObject.optString("link");
                Profile.m14135a(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
            }
        }

        public final void mo697a(FacebookException facebookException) {
        }
    }

    /* compiled from: event/{%s}/messagefriends */
    final class C18762 implements Creator {
        C18762() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public final Object[] newArray(int i) {
            return new Profile[i];
        }
    }

    public static void m14135a(Profile profile) {
        ProfileManager.m14138a().m14140a(profile);
    }

    public Profile(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Uri uri) {
        Validate.m25367a(str, "id");
        this.f13833a = str;
        this.f13834b = str2;
        this.f13835c = str3;
        this.f13836d = str4;
        this.f13837e = str5;
        this.f13838f = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.f13833a.equals(profile.f13833a) && this.f13834b == null) {
            if (profile.f13834b != null) {
                return false;
            }
            return true;
        } else if (this.f13834b.equals(profile.f13834b) && this.f13835c == null) {
            if (profile.f13835c != null) {
                return false;
            }
            return true;
        } else if (this.f13835c.equals(profile.f13835c) && this.f13836d == null) {
            if (profile.f13836d != null) {
                return false;
            }
            return true;
        } else if (this.f13836d.equals(profile.f13836d) && this.f13837e == null) {
            if (profile.f13837e != null) {
                return false;
            }
            return true;
        } else if (!this.f13837e.equals(profile.f13837e) || this.f13838f != null) {
            return this.f13838f.equals(profile.f13838f);
        } else {
            if (profile.f13838f != null) {
                return false;
            }
            return true;
        }
    }

    public final int hashCode() {
        int hashCode = this.f13833a.hashCode() + 527;
        if (this.f13834b != null) {
            hashCode = (hashCode * 31) + this.f13834b.hashCode();
        }
        if (this.f13835c != null) {
            hashCode = (hashCode * 31) + this.f13835c.hashCode();
        }
        if (this.f13836d != null) {
            hashCode = (hashCode * 31) + this.f13836d.hashCode();
        }
        if (this.f13837e != null) {
            hashCode = (hashCode * 31) + this.f13837e.hashCode();
        }
        if (this.f13838f != null) {
            return (hashCode * 31) + this.f13838f.hashCode();
        }
        return hashCode;
    }

    public final JSONObject m14136c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f13833a);
            jSONObject.put("first_name", this.f13834b);
            jSONObject.put("middle_name", this.f13835c);
            jSONObject.put("last_name", this.f13836d);
            jSONObject.put("name", this.f13837e);
            if (this.f13838f == null) {
                return jSONObject;
            }
            jSONObject.put("link_uri", this.f13838f.toString());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.f13833a = jSONObject.optString("id", null);
        this.f13834b = jSONObject.optString("first_name", null);
        this.f13835c = jSONObject.optString("middle_name", null);
        this.f13836d = jSONObject.optString("last_name", null);
        this.f13837e = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        if (optString != null) {
            uri = Uri.parse(optString);
        }
        this.f13838f = uri;
    }

    public Profile(Parcel parcel) {
        this.f13833a = parcel.readString();
        this.f13834b = parcel.readString();
        this.f13835c = parcel.readString();
        this.f13836d = parcel.readString();
        this.f13837e = parcel.readString();
        String readString = parcel.readString();
        this.f13838f = readString == null ? null : Uri.parse(readString);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13833a);
        parcel.writeString(this.f13834b);
        parcel.writeString(this.f13835c);
        parcel.writeString(this.f13836d);
        parcel.writeString(this.f13837e);
        parcel.writeString(this.f13838f == null ? null : this.f13838f.toString());
    }
}

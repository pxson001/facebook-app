package com.facebook.events.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.events.common.EventActionContext;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nonnull;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: auth */
public abstract class ContextParams implements Parcelable {
    @Nonnull
    public final EventActionContext f19019a;

    /* compiled from: auth */
    public class Builder<T extends Builder> {
        public EventActionContext f19018a;

        public Builder(Parcel parcel) {
            this.f19018a = (EventActionContext) parcel.readParcelable(EventActionContext.class.getClassLoader());
        }
    }

    protected ContextParams(Builder builder) {
        this.f19019a = builder.f19018a;
    }

    public List<NameValuePair> mo855a() {
        List<NameValuePair> a = Lists.a();
        String str = "action_context";
        EventActionContext eventActionContext = this.f19019a;
        if (eventActionContext.j == null) {
            int i;
            String str2 = "source";
            Integer valueOf = Integer.valueOf(eventActionContext.e.getParamValue());
            String str3 = "ref";
            Integer valueOf2 = Integer.valueOf(eventActionContext.f.getParamValue());
            String str4 = "app_started_by_launcher";
            if (eventActionContext.i) {
                i = 1;
            } else {
                i = 0;
            }
            eventActionContext.j = new JSONObject(ImmutableMap.of(str2, valueOf, str3, valueOf2, str4, Integer.valueOf(i)));
        }
        a.add(new BasicNameValuePair(str, eventActionContext.j.toString()));
        return a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f19019a, i);
    }
}

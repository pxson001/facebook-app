package com.facebook.richdocument.logging;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.bugreporter.BugReportingXConfig;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.MonotonicClock;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.richdocument.RichDocumentConstants;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.File;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_picker_session_data */
public class RichDocumentBugReportExtraFileMapProvider implements BugReportExtraFileMapProvider {
    private final FbSharedPreferences f5495a;
    private final FbObjectMapper f5496b;
    private final MonotonicClock f5497c;
    private final XConfigReader f5498d;

    @AutoGenJsonSerializer
    @JsonSerialize(using = C0709x65474de0.class)
    /* compiled from: place_picker_session_data */
    class RichDocumentBugReportData implements Parcelable {
        public static final Creator<RichDocumentBugReportData> CREATOR = new C07081();
        @JsonProperty("last_article_debug_info")
        final String mLastARticleDebugInfo;

        /* compiled from: place_picker_session_data */
        final class C07081 implements Creator<RichDocumentBugReportData> {
            C07081() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new RichDocumentBugReportData(parcel);
            }

            public final Object[] newArray(int i) {
                return new RichDocumentBugReportData[i];
            }
        }

        public RichDocumentBugReportData(String str) {
            this.mLastARticleDebugInfo = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mLastARticleDebugInfo);
        }

        public int describeContents() {
            return 0;
        }

        public RichDocumentBugReportData(Parcel parcel) {
            this.mLastARticleDebugInfo = parcel.readString();
        }
    }

    @Inject
    public RichDocumentBugReportExtraFileMapProvider(FbSharedPreferences fbSharedPreferences, FbObjectMapper fbObjectMapper, MonotonicClock monotonicClock, XConfigReader xConfigReader) {
        this.f5495a = fbSharedPreferences;
        this.f5496b = fbObjectMapper;
        this.f5497c = monotonicClock;
        this.f5498d = xConfigReader;
    }

    public boolean shouldSendAsync() {
        return this.f5498d.a(BugReportingXConfig.k, false);
    }

    public Map<String, String> getExtraFileFromWorkerThread(File file) {
        Map<String, String> map = null;
        Builder builder = ImmutableMap.builder();
        if (this.f5497c.now() - Long.valueOf(this.f5495a.a(RichDocumentConstants.f5039c, 0)).longValue() < 120000) {
            try {
                File file2 = new File(file, "instant_article_activity_json");
                Uri fromFile = Uri.fromFile(file2);
                this.f5496b.a(file2, new RichDocumentBugReportData(this.f5495a.a(RichDocumentConstants.f5038b, "no article debug info in shared preferences")));
                builder.b("instant_article_activity_json", fromFile.toString());
                map = builder.b();
            } catch (Exception e) {
            }
        }
        return map;
    }

    public void prepareDataForWriting() {
    }
}

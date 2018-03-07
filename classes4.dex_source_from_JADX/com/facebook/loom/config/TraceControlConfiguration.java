package com.facebook.loom.config;

import android.util.SparseArray;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.loom.config.Config.RootControllerConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = TraceControlConfigurationDeserializer.class)
/* compiled from: getTopOnlineFriends */
public class TraceControlConfiguration implements Postprocessable<TraceControlConfiguration>, RootControllerConfig {
    @Nullable
    private QPLControllerConfig f11094a;
    @JsonProperty("cold_start")
    private final ColdStartTraceControlConfiguration mColdStartTraceControl = null;
    @JsonProperty("http")
    private final HTTPTraceControlConfiguration mHTTPTraceControl = null;
    @JsonProperty("qpl")
    @Nullable
    private ImmutableMap<Integer, QPLTraceControlConfiguration> mQPLTraceControl = null;
    @JsonProperty("timed_out_upload_sample_rate")
    private int mTimedOutUploadSampleRate = 0;
    @JsonProperty("max_trace_timeout_ms")
    private int mTraceTimeousMs = -1;

    public final Object m11523a() {
        if (this.mQPLTraceControl != null && this.mQPLTraceControl.size() > 0) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.mQPLTraceControl.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                sparseArray.put(((Integer) entry.getKey()).intValue(), entry.getValue());
            }
            this.f11094a = new QPLControllerConfig(sparseArray);
            this.mQPLTraceControl = null;
        }
        return this;
    }

    public final HTTPTraceControlConfiguration m11526d() {
        return this.mHTTPTraceControl;
    }

    public final ControllerConfig m11522a(int i) {
        switch (i) {
            case 1:
            case 16:
                return this.f11094a;
            case 2:
                return this.mHTTPTraceControl;
            case 8:
                return this.mColdStartTraceControl;
            default:
                return null;
        }
    }

    public final int m11524b() {
        return this.mTraceTimeousMs;
    }

    public final int m11525c() {
        return this.mTimedOutUploadSampleRate;
    }
}

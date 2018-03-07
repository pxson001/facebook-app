package com.facebook.device.resourcemonitor;

import android.os.Process;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = MonitoredProcessDeserializer.class)
/* compiled from: setContentView */
public enum MonitoredProcess {
    MY_APP(Process.myUid(), "data", false);
    
    public final String analyticCounterName;
    public final boolean trackForegroundOnly;
    public final int uid;

    private MonitoredProcess(int i, String str, boolean z) {
        this.uid = i;
        this.analyticCounterName = str;
        this.trackForegroundOnly = z;
    }

    @JsonCreator
    public static MonitoredProcess fromString(String str) {
        for (MonitoredProcess monitoredProcess : values()) {
            if (monitoredProcess.name().equals(str)) {
                return monitoredProcess;
            }
        }
        return MY_APP;
    }
}

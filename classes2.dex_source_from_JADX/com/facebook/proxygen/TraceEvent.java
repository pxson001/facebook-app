package com.facebook.proxygen;

import java.util.Map;
import java.util.Map.Entry;

/* compiled from: zero_rating2/allow_zero_rating_on_wifi */
public class TraceEvent extends NativeHandleImpl {
    private final long mEnd;
    private final int mID;
    public final String mName;
    private final int mParentID;
    private final long mStart;

    public native void close();

    public native Map<String, String> getMetaData();

    public TraceEvent(String str, int i, int i2, long j, long j2) {
        this.mName = str;
        this.mID = i;
        this.mParentID = i2;
        this.mStart = j;
        this.mEnd = j2;
    }

    public TraceEvent(String str) {
        this.mName = str;
        this.mID = 0;
        this.mParentID = 0;
        this.mStart = 0;
        this.mEnd = 0;
    }

    public String getName() {
        return this.mName;
    }

    public int getId() {
        return this.mID;
    }

    public int getParentID() {
        return this.mParentID;
    }

    public long getStart() {
        return this.mStart;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TraceEvent(name='" + this.mName + "', id='" + this.mID + "', parentID='" + this.mParentID + "', start='" + this.mStart + "', end='" + this.mEnd + "', metaData='{");
        for (Entry entry : getMetaData().entrySet()) {
            stringBuffer.append(((String) entry.getKey()) + ": " + ((String) entry.getValue()) + ", ");
        }
        stringBuffer.append("}')");
        return stringBuffer.toString();
    }

    public String toPrettyJson() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\n  \"name\":\"" + this.mName + "\",\n  \"id\":" + this.mID + ",\n  \"parentID\":" + this.mParentID + ",\n  \"start\":" + this.mStart + ",\n  \"end\":" + this.mEnd + ",\n  \"metaData\":{\n");
        int i = 1;
        for (Entry entry : getMetaData().entrySet()) {
            if (i == 0) {
                stringBuffer.append(",\n");
            }
            stringBuffer.append("    \"" + ((String) entry.getKey()) + "\":\"");
            if (((String) entry.getValue()).length() > 100) {
                stringBuffer.append(((String) entry.getValue()).substring(0, 97) + "...\"");
                i = 0;
            } else {
                stringBuffer.append(((String) entry.getValue()) + "\"");
                i = 0;
            }
        }
        stringBuffer.append("\n  }\n}");
        return stringBuffer.toString();
    }
}

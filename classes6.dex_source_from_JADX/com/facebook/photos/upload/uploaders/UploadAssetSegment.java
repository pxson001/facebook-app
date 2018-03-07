package com.facebook.photos.upload.uploaders;

import com.facebook.videocodec.resizer.SegmentTranscodeSettings;

/* compiled from: friends_locations_feedstory_item_impression */
public class UploadAssetSegment {
    public String f14440a;
    public String f14441b;
    public final SegmentType f14442c;
    public final int f14443d;
    public long f14444e;
    public long f14445f;
    public SegmentTranscodeSettings f14446g;

    /* compiled from: friends_locations_feedstory_item_impression */
    public enum SegmentType {
        Audio(1),
        Video(2),
        Mixed(3);
        
        private int mValue;

        private SegmentType(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public UploadAssetSegment(SegmentType segmentType, int i) {
        this.f14442c = segmentType;
        this.f14443d = i;
    }

    public final void m22072a(String str, long j, long j2) {
        this.f14440a = str;
        this.f14444e = j2;
        this.f14445f = j2 + j;
    }

    public final void m22071a(String str) {
        this.f14441b = str + ("_" + Integer.toString(this.f14442c.getValue()) + "_" + this.f14443d);
    }

    public final String m22070a() {
        return this.f14441b;
    }
}

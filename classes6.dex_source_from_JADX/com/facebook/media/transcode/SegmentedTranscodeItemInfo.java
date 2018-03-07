package com.facebook.media.transcode;

import com.facebook.videocodec.resizer.SegmentTranscodeSettings;

/* compiled from: keyword_text */
public class SegmentedTranscodeItemInfo {
    public final SegmentType f11856a;
    public final int f11857b;
    public SegmentTranscodeSettings f11858c;

    /* compiled from: keyword_text */
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

    public SegmentedTranscodeItemInfo(SegmentType segmentType, int i) {
        this.f11856a = segmentType;
        this.f11857b = i;
    }
}

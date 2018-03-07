package com.facebook.photos.upload.uploaders;

import com.facebook.photos.upload.uploaders.UploadAssetSegment.SegmentType;
import com.facebook.videocodec.resizer.SegmentTranscodeSettings;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: friends_locations_feedstory_scroll_right */
public class SegmentedUploadItem {
    public int f14433a;
    public List<UploadAssetSegment> f14434b;

    private SegmentedUploadItem(List<UploadAssetSegment> list, int i) {
        boolean z;
        boolean z2 = true;
        if (list != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (list.isEmpty()) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f14434b = list;
        this.f14433a = i;
    }

    public final UploadAssetSegment m22063a() {
        return (UploadAssetSegment) this.f14434b.get(0);
    }

    public final UploadAssetSegment m22064a(int i) {
        boolean z = i >= 0 && i < this.f14434b.size();
        Preconditions.checkArgument(z);
        return (UploadAssetSegment) this.f14434b.get(i);
    }

    public final int m22066b() {
        Preconditions.checkArgument(this.f14434b != null);
        return this.f14434b.size();
    }

    public final UploadAssetSegment m22065a(long j) {
        for (int i = 0; i < this.f14434b.size(); i++) {
            UploadAssetSegment uploadAssetSegment = (UploadAssetSegment) this.f14434b.get(i);
            if (j < uploadAssetSegment.f14445f) {
                return uploadAssetSegment;
            }
        }
        return null;
    }

    public static SegmentedUploadItem m22061a(long j, int i) {
        int i2;
        Preconditions.checkArgument(j >= 20000);
        int i3 = 2;
        if (j >= 40000) {
            i3 = 4;
        }
        int i4 = (int) (j / ((long) i3));
        List arrayList = new ArrayList();
        if (i > 0) {
            i2 = i3 + 1;
        } else {
            i2 = i3;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            SegmentType segmentType;
            if (i5 < i3) {
                segmentType = SegmentType.Video;
            } else {
                segmentType = SegmentType.Audio;
            }
            UploadAssetSegment uploadAssetSegment = new UploadAssetSegment(segmentType, i5);
            uploadAssetSegment.f14446g = m22062a(uploadAssetSegment.f14442c, i3, i5, i4);
            arrayList.add(uploadAssetSegment);
        }
        return new SegmentedUploadItem(arrayList, i3);
    }

    private static SegmentTranscodeSettings m22062a(SegmentType segmentType, int i, int i2, int i3) {
        boolean z;
        int i4;
        boolean z2 = true;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -2;
        if (segmentType == SegmentType.Video) {
            boolean z4;
            z = i2 == i + -1;
            if (i2 == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z) {
                z = false;
            } else {
                i6 = (i2 + 1) * i3;
                z = true;
            }
            if (!z4) {
                i5 = i2 * i3;
            }
            i4 = i5;
            z3 = true;
            z2 = false;
        } else {
            i4 = -1;
            z = false;
        }
        return new SegmentTranscodeSettings(z3, z2, z, i4, i6);
    }
}

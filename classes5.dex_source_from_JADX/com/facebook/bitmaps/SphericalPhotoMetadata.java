package com.facebook.bitmaps;

import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: android.support.localOnly */
public class SphericalPhotoMetadata {
    @DoNotStrip
    private int mCroppedAreaImageHeightPixels;
    @DoNotStrip
    private int mCroppedAreaImageWidthPixels;
    @DoNotStrip
    private int mCroppedAreaLeftPixels;
    @DoNotStrip
    private int mCroppedAreaTopPixels;
    @DoNotStrip
    private int mFullPanoHeightPixels;
    @DoNotStrip
    private int mFullPanoWidthPixels;
    @DoNotStrip
    private double mInitialViewHeadingDegrees;
    @DoNotStrip
    private double mInitialViewPitchDegrees;
    @DoNotStrip
    private double mPoseHeadingDegrees;
    @DoNotStrip
    private double mPosePitchDegrees;
    @DoNotStrip
    private double mPoseRollDegrees;
    @DoNotStrip
    private String mProjectionType;

    @DoNotStrip
    public native String serializeToJson();

    static {
        SoLoaderShim.a("fb_imgproc");
    }

    public final double m18486a() {
        if (((double) this.mFullPanoWidthPixels) == 0.0d) {
            return 0.0d;
        }
        return (360.0d * ((double) this.mCroppedAreaImageWidthPixels)) / ((double) this.mFullPanoWidthPixels);
    }
}

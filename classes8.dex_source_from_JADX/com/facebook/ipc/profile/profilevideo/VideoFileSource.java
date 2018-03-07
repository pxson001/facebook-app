package com.facebook.ipc.profile.profilevideo;

import com.facebook.ipc.creativecam.CreativeCamMediaSource;

/* compiled from: unitId */
public class VideoFileSource {

    /* compiled from: unitId */
    /* synthetic */ class C01051 {
        static final /* synthetic */ int[] f1166a = new int[CreativeCamMediaSource.values().length];

        static {
            try {
                f1166a[CreativeCamMediaSource.CREATIVE_CAM_FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1166a[CreativeCamMediaSource.CREATIVE_CAM_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1166a[CreativeCamMediaSource.CREATIVE_CAM_PICKER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static int m1393a(CreativeCamMediaSource creativeCamMediaSource) {
        switch (C01051.f1166a[creativeCamMediaSource.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default:
                return -1;
        }
    }
}

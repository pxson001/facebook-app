package com.facebook.camera.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Display;
import com.facebook.common.build.BuildConstants;

/* compiled from: all_share_stories */
public class CameraOrientation {
    public Orientation f10980a;
    public Orientation f10981b;
    public int f10982c;
    public int f10983d;
    public int f10984e;

    /* compiled from: all_share_stories */
    public /* synthetic */ class C10601 {
        public static final /* synthetic */ int[] f10979a = new int[Orientation.values().length];

        static {
            try {
                f10979a[Orientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10979a[Orientation.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10979a[Orientation.REVERSE_LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10979a[Orientation.REVERSE_PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @TargetApi(11)
    public CameraOrientation(Activity activity, boolean z, Class<?> cls) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        int i = defaultDisplay.getWidth() <= defaultDisplay.getHeight() ? 1 : 0;
        if ((i == 0 || !(rotation == 0 || rotation == 2)) && !(i == 0 && (rotation == 1 || rotation == 3))) {
            switch (rotation) {
                case 1:
                    this.f10980a = Orientation.REVERSE_PORTRAIT;
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    this.f10980a = Orientation.REVERSE_LANDSCAPE;
                    break;
                case 3:
                    this.f10980a = Orientation.PORTRAIT;
                    break;
                default:
                    this.f10980a = Orientation.LANDSCAPE;
                    break;
            }
            this.f10981b = this.f10980a;
            this.f10982c = -90;
        } else {
            switch (rotation) {
                case 1:
                    this.f10980a = Orientation.LANDSCAPE;
                    this.f10981b = Orientation.LANDSCAPE;
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    this.f10980a = Orientation.REVERSE_PORTRAIT;
                    this.f10981b = Orientation.PORTRAIT;
                    break;
                case 3:
                    this.f10980a = Orientation.REVERSE_LANDSCAPE;
                    this.f10981b = Orientation.REVERSE_LANDSCAPE;
                    break;
                default:
                    this.f10980a = Orientation.PORTRAIT;
                    this.f10981b = Orientation.PORTRAIT;
                    break;
            }
            this.f10982c = 0;
        }
        if (z) {
            this.f10981b = Orientation.LANDSCAPE;
        }
        if (CameraHacks.f10977b || CameraHacks.f10978c) {
            this.f10981b = Orientation.PORTRAIT;
        }
        switch (C10601.f10979a[this.f10981b.ordinal()]) {
            case 1:
                this.f10984e = 0;
                this.f10983d = 2130903488;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f10984e = 1;
                this.f10983d = 2130903492;
                break;
            case 3:
                this.f10984e = 8;
                this.f10983d = 2130903494;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                this.f10984e = 9;
                this.f10983d = 2130903492;
                break;
            default:
                this.f10981b = Orientation.LANDSCAPE;
                this.f10984e = 0;
                this.f10983d = 2130903488;
                break;
        }
        if (BuildConstants.i) {
            new StringBuilder("Rotation: ").append(rotation).append(i != 0 ? " Tall" : " Wide");
            new StringBuilder("Layout: ").append(this.f10981b).append("/").append(this.f10983d).append(" Offset: ").append(this.f10982c);
            new StringBuilder("Orientation: ").append(this.f10980a).append(" Activity: ").append(this.f10984e);
        }
    }
}

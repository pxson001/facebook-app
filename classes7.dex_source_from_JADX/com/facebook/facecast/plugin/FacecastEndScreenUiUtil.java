package com.facebook.facecast.plugin;

import android.content.res.Resources;
import com.facebook.facecastdisplay.FacecastUiUtil;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;

/* compiled from: border_color */
public class FacecastEndScreenUiUtil {

    /* compiled from: border_color */
    /* synthetic */ class C15551 {
        static final /* synthetic */ int[] f18325a = new int[TargetType.values().length];

        static {
            try {
                f18325a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18325a[TargetType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18325a[TargetType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18325a[TargetType.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static CharSequence m22037a(Resources resources, long j, ComposerTargetData composerTargetData) {
        String a = FacecastUiUtil.m3100a(j);
        switch (C15551.f18325a[composerTargetData.targetType.ordinal()]) {
            case 1:
                return resources.getString(2131238242, new Object[]{a});
            case 2:
                return resources.getString(2131238244, new Object[]{a});
            case 3:
                return resources.getString(2131238245, new Object[]{a});
            case 4:
                return resources.getString(2131238243, new Object[]{a});
            default:
                return null;
        }
    }
}

package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: vod_video_timestamp */
public class IntentCompat {
    private static final IntentCompatImpl f220a;

    /* compiled from: vod_video_timestamp */
    interface IntentCompatImpl {
        Intent mo41a(ComponentName componentName);
    }

    /* compiled from: vod_video_timestamp */
    class IntentCompatImplBase implements IntentCompatImpl {
        IntentCompatImplBase() {
        }

        public Intent mo41a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    /* compiled from: vod_video_timestamp */
    class IntentCompatImplHC extends IntentCompatImplBase {
        public final Intent mo41a(ComponentName componentName) {
            return Intent.makeMainActivity(componentName);
        }

        IntentCompatImplHC() {
        }
    }

    /* compiled from: vod_video_timestamp */
    class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        IntentCompatImplIcsMr1() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f220a = new IntentCompatImplIcsMr1();
        } else if (i >= 11) {
            f220a = new IntentCompatImplHC();
        } else {
            f220a = new IntentCompatImplBase();
        }
    }

    private IntentCompat() {
    }

    public static Intent m234a(ComponentName componentName) {
        return f220a.mo41a(componentName);
    }
}

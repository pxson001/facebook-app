package com.facebook.react.modules.debug;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.widget.Toast;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: from_activity_tab */
public class AnimationsDebugModule extends ReactContextBaseJavaModule {
    @Nullable
    private FpsDebugFrameCallback f11651a;
    @Nullable
    private final DeveloperSettings f11652b;

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, DeveloperSettings developerSettings) {
        super(reactApplicationContext);
        this.f11652b = developerSettings;
    }

    public String getName() {
        return "AnimationsDebugModule";
    }

    @ReactMethod
    public void startRecordingFps() {
        if (this.f11652b != null && this.f11652b.m13721a()) {
            if (this.f11651a != null) {
                throw new JSApplicationCausedNativeException("Already recording FPS!");
            }
            m13719r();
            this.f11651a = new FpsDebugFrameCallback(Choreographer.getInstance(), this.f1100a);
            this.f11651a.m13742a();
        }
    }

    @ReactMethod
    public void stopRecordingFps(double d) {
        if (this.f11651a != null) {
            m13719r();
            this.f11651a.m13743b();
            if (this.f11651a.m13741a((long) d) == null) {
                Toast.makeText(this.f1100a, "Unable to get FPS info", 1);
            } else {
                String format = String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(this.f11651a.m13741a((long) d).f11662e), Integer.valueOf(this.f11651a.m13741a((long) d).f11658a), Integer.valueOf(this.f11651a.m13741a((long) d).f11660c)});
                Toast.makeText(this.f1100a, format + "\n" + String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(r0.f11663f), Integer.valueOf(r0.f11659b), Integer.valueOf(r0.f11660c)}) + "\nTotal Time MS: " + String.format(Locale.US, "%d", new Object[]{Integer.valueOf(r0.f11664g)}), 1).show();
            }
            this.f11651a = null;
        }
    }

    public final void m13720e() {
        if (this.f11651a != null) {
            this.f11651a.m13743b();
            this.f11651a = null;
        }
    }

    private static void m13719r() {
        if (VERSION.SDK_INT < 16) {
            throw new JSApplicationCausedNativeException("Animation debugging is not supported in API <16");
        }
    }
}

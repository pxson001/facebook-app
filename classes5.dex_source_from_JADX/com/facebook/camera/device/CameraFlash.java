package com.facebook.camera.device;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.prefs.CameraPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: amount_offset */
public class CameraFlash implements OnTouchListener {
    public static HashMap<String, Integer> f10799a = new HashMap(3);
    public static HashMap<String, Integer> f10800b = new HashMap(3);
    private static final Class<?> f10801d = CameraFlash.class;
    private Camera f10802c;
    private List<String> f10803e;
    private final String f10804f = "auto";
    public String f10805g = "auto";
    private final CameraFlowLogger f10806h;
    private final CameraHolder f10807i;

    public CameraFlash(FbSharedPreferences fbSharedPreferences, CameraFlowLogger cameraFlowLogger, CameraHolder cameraHolder) {
        this.f10806h = cameraFlowLogger;
        this.f10807i = cameraHolder;
        f10799a.put("on", Integer.valueOf(2130837933));
        f10799a.put("off", Integer.valueOf(2130837936));
        f10799a.put("auto", Integer.valueOf(2130837934));
        f10800b.put("on", Integer.valueOf(2130837938));
        f10800b.put("off", Integer.valueOf(2130837937));
        f10800b.put("auto", Integer.valueOf(2130837935));
        this.f10805g = fbSharedPreferences.a(CameraPrefKeys.f10972b, "auto");
    }

    public final boolean m18880a() {
        if (this.f10802c != null && this.f10803e.size() > 1) {
            return true;
        }
        return false;
    }

    public final void m18879a(Camera camera) {
        this.f10802c = camera;
        if (this.f10802c == null) {
            this.f10803e = null;
            return;
        }
        this.f10803e = new ArrayList();
        Parameters parameters = this.f10802c.getParameters();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String str : supportedFlashModes) {
                if (f10799a.containsKey(str)) {
                    this.f10803e.add(str);
                }
            }
            if (this.f10803e.size() > 0) {
                if (this.f10803e.contains(this.f10805g)) {
                    m18878a(this.f10805g, parameters, false);
                } else if (this.f10803e.contains("auto")) {
                    m18878a("auto", parameters, false);
                } else {
                    m18878a((String) this.f10803e.get(0), parameters, false);
                }
                try {
                    this.f10802c.setParameters(parameters);
                } catch (Exception e) {
                    this.f10806h.mo1147a("setCamera/setParameters failed", e);
                }
            }
        }
    }

    private Parameters m18878a(String str, Parameters parameters, boolean z) {
        parameters.setFlashMode(str);
        this.f10805g = str;
        this.f10806h.mo1148a(str, z);
        return parameters;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f10802c == null || this.f10803e.size() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            return false;
        }
        if (this.f10807i.m18921a()) {
            Parameters parameters = this.f10802c.getParameters();
            int indexOf = this.f10803e.indexOf(parameters.getFlashMode());
            if (action == 0) {
                view.setBackgroundResource(((Integer) f10800b.get(this.f10803e.get(indexOf))).intValue());
            } else {
                action = (indexOf + 1) % this.f10803e.size();
                m18878a((String) this.f10803e.get(action), parameters, true);
                view.setBackgroundResource(((Integer) f10799a.get(this.f10803e.get(action))).intValue());
                try {
                    this.f10802c.setParameters(parameters);
                } catch (Exception e) {
                    this.f10806h.mo1147a("onTouch/setParameters failed", e);
                }
            }
        }
        return true;
    }
}

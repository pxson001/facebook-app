package org.webrtc.videoengine;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import org.json.JSONArray;
import org.json.JSONObject;

@DoNotStrip
/* compiled from: after_time_sec */
public class VideoCaptureDeviceInfoAndroid {
    private static final Class<?> f21165a = VideoCaptureDeviceInfoAndroid.class;
    private static String f21166b = null;
    public static int f21167c;
    public static int f21168d;
    private static boolean f21169e = false;
    public static boolean f21170f = false;

    public static CameraInfo m21593a(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
            if (!f21170f) {
                return cameraInfo;
            }
            if (cameraInfo.facing == 1) {
                cameraInfo.facing = 0;
                return cameraInfo;
            }
            cameraInfo.facing = 1;
            return cameraInfo;
        } catch (Throwable e) {
            BLog.b(f21165a, "Failed to get camera info", e);
            return null;
        }
    }

    private static boolean m21594a(CameraInfo cameraInfo) {
        return cameraInfo.facing == 1;
    }

    public static String m21595b(int i) {
        if (i < 0) {
            return null;
        }
        return "Camera_" + i;
    }

    public static synchronized void m21596c() {
        synchronized (VideoCaptureDeviceInfoAndroid.class) {
            if (!f21169e) {
                f21167c = -1;
                f21168d = -1;
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    CameraInfo a = m21593a(i);
                    if (a != null) {
                        m21595b(i);
                        if (f21167c < 0 && m21594a(a)) {
                            f21167c = i;
                        }
                        if (f21168d < 0 && !m21594a(a)) {
                            f21168d = i;
                        }
                        Integer.valueOf(i);
                        Boolean.valueOf(m21594a(a));
                        Integer.valueOf(a.orientation);
                    }
                }
                f21169e = true;
            }
        }
    }

    @DoNotStrip
    private static String getDeviceInfo() {
        if (f21166b != null) {
            return f21166b;
        }
        m21596c();
        try {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < Camera.getNumberOfCameras()) {
                if (i == f21167c || i == f21168d) {
                    CameraInfo a = m21593a(i);
                    String b = m21595b(i);
                    int[][] iArr = new int[][]{new int[]{640, 480}, new int[]{352, 288}, new int[]{320, 240}};
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < 3; i2++) {
                        int[] iArr2 = iArr[i2];
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("width", iArr2[0]);
                        jSONObject.put("height", iArr2[1]);
                        jSONArray2.put(jSONObject);
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("min_mfps", 15000);
                    jSONObject2.put("max_mfps", 30000);
                    jSONArray3.put(jSONObject2);
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("name", b).put("front_facing", m21594a(a)).put("orientation", a.orientation).put("sizes", jSONArray2).put("mfpsRanges", jSONArray3);
                    jSONArray.put(jSONObject2);
                }
                i++;
            }
            f21166b = jSONArray.toString(2);
            return f21166b;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

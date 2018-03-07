package com.facebook.camera.device;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.facetracking.FaceTracker.TrackedFacesListener;
import com.facebook.camera.facetracking.TrackedFace;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.camera.views.FocusIndicator;
import com.facebook.camera.views.FocusIndicatorView;
import com.facebook.debug.log.BLog;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* compiled from: already_invited_live_viewers */
public class FocusManager implements TrackedFacesListener {
    private static final Class<?> f10886b = FocusManager.class;
    private int f10887A = 0;
    CameraHolder f10888a;
    public int f10889c = 0;
    private boolean f10890d;
    public boolean f10891e;
    public boolean f10892f;
    private boolean f10893g;
    private Matrix f10894h = null;
    private View f10895i;
    private FocusIndicatorView f10896j;
    private View f10897k;
    public List<Area> f10898l;
    private List<Area> f10899m;
    public String f10900n;
    public String[] f10901o;
    public String f10902p;
    private Handler f10903q;
    private boolean f10904r;
    private int f10905s;
    private CameraFlowLogger f10906t;
    public Camera f10907u;
    private Comparator<TrackedFace> f10908v;
    public int f10909w = 0;
    public int f10910x = 0;
    private HashSet<Long> f10911y;
    private long f10912z = 0;

    /* compiled from: already_invited_live_viewers */
    class C10581 implements Comparator<TrackedFace> {
        final /* synthetic */ FocusManager f10884a;

        C10581(FocusManager focusManager) {
            this.f10884a = focusManager;
        }

        public int compare(Object obj, Object obj2) {
            return ((TrackedFace) obj).m18979a() - ((TrackedFace) obj2).m18979a();
        }
    }

    /* compiled from: already_invited_live_viewers */
    public enum AutoFocusSource {
        TOUCH_TO_FOCUS,
        LAST_SECOND_AUTOFOCUS,
        FACE_DETECTION_AUTOFOCUS
    }

    /* compiled from: already_invited_live_viewers */
    class MainHandler extends Handler {
        final /* synthetic */ FocusManager f10885a;

        public MainHandler(FocusManager focusManager) {
            this.f10885a = focusManager;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    FocusManager.m18947i(this.f10885a);
                    return;
                default:
                    return;
            }
        }
    }

    public FocusManager(String[] strArr, CameraFlowLogger cameraFlowLogger) {
        this.f10901o = strArr;
        this.f10903q = new MainHandler(this);
        this.f10906t = cameraFlowLogger;
    }

    public final void m18953a(View view, View view2, CameraHolder cameraHolder, boolean z, int i) {
        this.f10895i = view;
        this.f10896j = (FocusIndicatorView) view.findViewById(2131562105);
        this.f10897k = view2;
        this.f10888a = cameraHolder;
        this.f10904r = z;
        this.f10905s = i;
        this.f10894h = null;
        this.f10908v = new C10581(this);
        this.f10911y = Sets.a();
        this.f10890d = true;
    }

    public final void m18952a() {
        if (this.f10890d) {
            if (!this.f10893g) {
                this.f10893g = true;
            }
            if (m18951n() && this.f10889c == 0 && this.f10912z < SystemClock.uptimeMillis()) {
                m18943a(AutoFocusSource.LAST_SECOND_AUTOFOCUS, 2000);
            }
        }
    }

    public final boolean m18957b() {
        if (!this.f10890d) {
            BLog.a(f10886b, "FocusManager.doSnap not initialized");
            return false;
        } else if (!m18951n() || this.f10889c == 3 || this.f10889c == 4) {
            m18948j();
            return true;
        } else if (this.f10889c == 1) {
            this.f10889c = 2;
            return true;
        } else if (this.f10889c != 0) {
            return true;
        } else {
            m18948j();
            return true;
        }
    }

    public final void m18955a(boolean z) {
        int i = 3;
        if (this.f10889c == 2) {
            if (z) {
                this.f10889c = 3;
            } else {
                this.f10889c = 4;
            }
            m18949l();
            m18948j();
        } else if (this.f10889c == 1) {
            if (!z) {
                i = 4;
            }
            this.f10889c = i;
            m18940a(this.f10887A);
        }
    }

    @TargetApi(14)
    public final boolean m18956a(MotionEvent motionEvent) {
        if (!this.f10890d || this.f10889c == 2) {
            return false;
        }
        if (this.f10889c == 1 || this.f10889c == 3 || this.f10889c == 4) {
            m18947i(this);
        }
        int round = Math.round(motionEvent.getX());
        int round2 = Math.round(motionEvent.getY());
        if (this.f10892f) {
            m18941a(round, round2);
        }
        if (this.f10891e && motionEvent.getAction() == 1) {
            if (this.f10892f) {
                int width = this.f10895i.getWidth();
                int height = this.f10895i.getHeight();
                int width2 = this.f10897k.getWidth();
                int height2 = this.f10897k.getHeight();
                this.f10898l = new ArrayList();
                this.f10898l.add(new Area(new Rect(), 1));
                this.f10899m = new ArrayList();
                this.f10899m.add(new Area(new Rect(), 1));
                m18942a(width, height, 1.0f, round, round2, width2, height2, ((Area) this.f10898l.get(0)).rect);
                m18942a(width, height, 1.5f, round, round2, width2, height2, ((Area) this.f10899m.get(0)).rect);
                m18946a(this.f10898l, this.f10899m);
            }
            m18943a(AutoFocusSource.TOUCH_TO_FOCUS, 10000);
        } else {
            m18940a(10000);
        }
        return true;
    }

    @TargetApi(14)
    public final void mo1159a(List<TrackedFace> list) {
        int i = 0;
        if (this.f10890d && this.f10892f && this.f10889c != 1 && this.f10889c != 3 && this.f10889c != 4) {
            if (list != null) {
                int i2;
                List<TrackedFace> a = Lists.a();
                for (TrackedFace trackedFace : list) {
                    if (trackedFace.f10956h && trackedFace.m18979a() > 80000 && trackedFace.f10959k == 5) {
                        a.add(trackedFace);
                    }
                }
                int i3 = 0;
                for (TrackedFace trackedFace2 : a) {
                    if (this.f10911y.contains(Long.valueOf(trackedFace2.f10960l))) {
                        i2 = i3 + 1;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
                if (i3 == this.f10911y.size() && i3 == a.size()) {
                    m18940a(5000);
                    return;
                }
                this.f10911y.clear();
                if (a.size() > 0) {
                    if (this.f10898l == null) {
                        this.f10898l = Lists.a();
                    } else {
                        this.f10898l.clear();
                    }
                    if (this.f10899m == null) {
                        this.f10899m = Lists.a();
                    } else {
                        this.f10899m.clear();
                    }
                    TrackedFace[] trackedFaceArr = new TrackedFace[a.size()];
                    for (TrackedFace trackedFace22 : a) {
                        i3 = i + 1;
                        trackedFaceArr[i] = trackedFace22;
                        this.f10911y.add(Long.valueOf(trackedFace22.f10960l));
                        i = i3;
                    }
                    Arrays.sort(trackedFaceArr, this.f10908v);
                    for (i2 = trackedFaceArr.length - 1; i2 >= 0; i2--) {
                        Area area = new Area(m18939a(trackedFaceArr[i2].f10954f), 1000);
                        if ((trackedFaceArr.length - 1) - i2 < this.f10909w) {
                            this.f10898l.add(area);
                        }
                        if ((trackedFaceArr.length - 1) - i2 < this.f10910x) {
                            this.f10899m.add(area);
                        }
                    }
                    if (m18946a(this.f10898l, this.f10899m)) {
                        Rect a2 = FaceDetectionIndicatorView.m18965a(trackedFaceArr[trackedFaceArr.length - 1], this.f10897k.getWidth(), this.f10897k.getHeight());
                        m18941a(a2.centerX(), a2.centerY());
                        if (this.f10891e) {
                            m18943a(AutoFocusSource.FACE_DETECTION_AUTOFOCUS, 5000);
                        } else {
                            m18940a(5000);
                        }
                    }
                }
            } else if (this.f10911y.size() > 0) {
                this.f10911y.clear();
                m18947i(this);
            }
        }
    }

    private void m18941a(int i, int i2) {
        int width = this.f10895i.getWidth();
        int height = this.f10895i.getHeight();
        LayoutParams layoutParams = (LayoutParams) this.f10895i.getLayoutParams();
        layoutParams.setMargins(CameraUtils.m19051a(i - (width / 2), 0, this.f10897k.getWidth() - width), CameraUtils.m19051a(i2 - (height / 2), 0, this.f10897k.getHeight() - height), 0, 0);
        layoutParams.getRules()[13] = 0;
        this.f10895i.requestLayout();
    }

    public final void m18958c() {
        this.f10889c = 0;
    }

    public final void m18959d() {
        this.f10889c = 0;
        m18950m();
        m18949l();
    }

    public final void m18960e() {
        m18959d();
    }

    private void m18943a(AutoFocusSource autoFocusSource, int i) {
        this.f10888a.m18920a(autoFocusSource);
        this.f10887A = i;
        this.f10889c = 1;
        m18949l();
        m18950m();
    }

    public static void m18947i(FocusManager focusManager) {
        focusManager.m18962g();
        focusManager.f10888a.m18935r();
        focusManager.f10889c = 0;
        focusManager.m18949l();
        focusManager.m18950m();
    }

    private void m18940a(int i) {
        m18949l();
        m18950m();
        this.f10903q.sendEmptyMessageDelayed(0, (long) i);
        this.f10912z = SystemClock.uptimeMillis() + ((long) i);
    }

    private void m18948j() {
        this.f10896j.mo1183d();
        if (this.f10888a.m18934q()) {
            m18950m();
        } else {
            BLog.a(f10886b, "FocusManager.capture rejected");
        }
    }

    public final void m18961f() {
        if (this.f10889c == 4) {
            this.f10889c = 0;
            this.f10912z = 0;
            return;
        }
        this.f10912z = SystemClock.uptimeMillis() + 2000;
        this.f10903q.sendEmptyMessageDelayed(0, 2000);
    }

    private void m18949l() {
        if (this.f10890d) {
            int min = Math.min(this.f10897k.getWidth(), this.f10897k.getHeight()) / 4;
            ViewGroup.LayoutParams layoutParams = this.f10896j.getLayoutParams();
            layoutParams.width = min;
            layoutParams.height = min;
            FocusIndicator focusIndicator = this.f10896j;
            if (this.f10889c == 0) {
                if (this.f10898l == null) {
                    focusIndicator.mo1183d();
                } else {
                    focusIndicator.mo1180a();
                }
            } else if (this.f10889c == 1 || this.f10889c == 2) {
                focusIndicator.mo1180a();
            } else if ("continuous-picture".equals(this.f10900n)) {
                focusIndicator.mo1180a();
            } else if (this.f10889c == 3) {
                focusIndicator.mo1181b();
            } else if (this.f10889c == 4) {
                focusIndicator.mo1182c();
            }
        }
    }

    @TargetApi(14)
    public final void m18962g() {
        if (this.f10890d) {
            LayoutParams layoutParams = (LayoutParams) this.f10895i.getLayoutParams();
            layoutParams.getRules()[13] = -1;
            layoutParams.setMargins(0, 0, 0, 0);
            if (this.f10892f) {
                this.f10898l = null;
                this.f10899m = null;
                Parameters parameters = this.f10907u.getParameters();
                parameters.setFocusAreas(null);
                parameters.setMeteringAreas(null);
                try {
                    this.f10907u.setParameters(parameters);
                } catch (Exception e) {
                    this.f10906t.mo1147a("resetFocus/setParameters failed", e);
                }
            }
        }
    }

    @TargetApi(14)
    private boolean m18946a(List<Area> list, List<Area> list2) {
        try {
            Parameters parameters = this.f10907u.getParameters();
            parameters.setFocusAreas(list);
            parameters.setMeteringAreas(list2);
            this.f10907u.setParameters(parameters);
            return true;
        } catch (Exception e) {
            this.f10906t.mo1147a("setFocusAndMeteringAreas/setParameters failed", e);
            this.f10892f = false;
            return false;
        }
    }

    private void m18942a(int i, int i2, float f, int i3, int i4, int i5, int i6, Rect rect) {
        int i7 = (int) (((float) i) * f);
        int i8 = (int) (((float) i2) * f);
        int a = CameraUtils.m19051a(i3 - (i7 / 2), 0, i5 - i7);
        int a2 = CameraUtils.m19051a(i4 - (i8 / 2), 0, i6 - i8);
        RectF rectF = new RectF((float) a, (float) a2, (float) (i7 + a), (float) (i8 + a2));
        if (this.f10894h == null) {
            this.f10894h = new Matrix();
            Matrix matrix = new Matrix();
            CameraUtils.m19055a(matrix, this.f10904r, this.f10905s, this.f10897k.getWidth(), this.f10897k.getHeight());
            matrix.invert(this.f10894h);
        }
        this.f10894h.mapRect(rectF);
        CameraUtils.m19056a(rectF, rect);
    }

    private void m18950m() {
        this.f10903q.removeMessages(0);
        this.f10912z = 0;
    }

    public static boolean m18945a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    @TargetApi(14)
    public static boolean m18944a(Parameters parameters) {
        return parameters.getMaxNumFocusAreas() > 0 || parameters.getMaxNumMeteringAreas() > 0;
    }

    private boolean m18951n() {
        String str;
        if (this.f10902p != null) {
            str = this.f10902p;
        } else {
            Parameters parameters = this.f10907u.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (!this.f10891e || this.f10898l == null) {
                this.f10900n = null;
                for (String str2 : this.f10901o) {
                    if (m18945a(str2, supportedFocusModes)) {
                        this.f10900n = str2;
                        break;
                    }
                }
            } else {
                this.f10900n = "auto";
            }
            if (!m18945a(this.f10900n, supportedFocusModes)) {
                if (m18945a("auto", parameters.getSupportedFocusModes())) {
                    this.f10900n = "auto";
                } else {
                    this.f10900n = parameters.getFocusMode();
                }
            }
            str = this.f10900n;
        }
        String str3 = str;
        if (str3 == null || str3.equals("infinity") || str3.equals("fixed") || str3.equals("edof")) {
            return false;
        }
        return true;
    }

    private static Rect m18939a(Rect rect) {
        return new Rect(Math.max(-1000, (int) Math.floor(((double) rect.left) * 1.2d)), Math.min(1000, (int) Math.floor(((double) rect.top) * 1.2d)), Math.min(1000, (int) Math.floor(((double) rect.right) * 1.2d)), Math.max(-1000, (int) Math.floor(((double) rect.bottom) * 1.2d)));
    }
}

package com.facebook.camera.facetracking;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera.Face;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.debug.log.BLog;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: already_completed */
public class FaceTracker {
    public static final Class<?> f10940a = FaceTracker.class;
    public ArrayList<TrackedFacesListener> f10941b = new ArrayList();
    private FaceDetectionManager f10942c;
    public volatile ArrayList<TrackedFace> f10943d = Lists.a();
    public Face[] f10944e;
    public boolean f10945f = false;
    private HandlerThread f10946g = null;
    public Handler f10947h;
    public Handler f10948i;

    /* compiled from: already_completed */
    public interface TrackedFacesListener {
        void mo1159a(List<TrackedFace> list);
    }

    /* compiled from: already_completed */
    class PublishingHandler extends Handler {
        final /* synthetic */ FaceTracker f10938a;

        public PublishingHandler(FaceTracker faceTracker) {
            this.f10938a = faceTracker;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 10:
                    FaceTracker.m18976a(this.f10938a, null);
                    return;
                case 11:
                    List unmodifiableList;
                    synchronized (this) {
                        List a = Lists.a();
                        int size = this.f10938a.f10943d.size();
                        for (int i = 0; i < size; i++) {
                            a.add(((TrackedFace) this.f10938a.f10943d.get(i)).m18981b());
                        }
                        unmodifiableList = Collections.unmodifiableList(a);
                    }
                    FaceTracker.m18976a(this.f10938a, unmodifiableList);
                    return;
                default:
                    BLog.b(FaceTracker.f10940a, "Unknown PublishingHandler msg type: " + message.what);
                    return;
            }
        }
    }

    /* compiled from: already_completed */
    class TrackingHandler extends Handler {
        final /* synthetic */ FaceTracker f10939a;

        TrackingHandler(FaceTracker faceTracker, Looper looper) {
            this.f10939a = faceTracker;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    m18971a();
                    return;
                default:
                    BLog.b(FaceTracker.f10940a, "Unknown TrackingHandler message: " + message);
                    return;
            }
        }

        private void m18973a(boolean z) {
            if (z) {
                this.f10939a.f10948i.sendEmptyMessage(10);
            } else {
                this.f10939a.f10948i.sendEmptyMessage(11);
            }
        }

        @TargetApi(14)
        private void m18971a() {
            this.f10939a.f10945f = true;
            if (this.f10939a.f10944e.length == 0) {
                m18973a(true);
                this.f10939a.f10945f = false;
                return;
            }
            int size;
            ArrayList arrayList = new ArrayList(this.f10939a.f10944e.length);
            for (Face face : this.f10939a.f10944e) {
                if (face.score >= 40) {
                    arrayList.add(face);
                }
            }
            if (this.f10939a.f10943d.size() == 0) {
                size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.f10939a.f10943d.add(new TrackedFace(((Face) arrayList.get(i)).rect));
                }
                m18973a(false);
                this.f10939a.f10945f = false;
                return;
            }
            m18972a(arrayList);
            m18974b();
            m18973a(false);
            this.f10939a.f10945f = false;
        }

        @TargetApi(14)
        private void m18972a(ArrayList<Face> arrayList) {
            int i;
            Rect rect;
            ArrayList arrayList2 = (ArrayList) this.f10939a.f10943d.clone();
            HashMap c = Maps.c();
            for (i = 0; i < arrayList.size(); i++) {
                Rect rect2 = ((Face) arrayList.get(i)).rect;
                float exactCenterX = rect2.exactCenterX();
                float exactCenterY = rect2.exactCenterY();
                double d = Double.MAX_VALUE;
                TrackedFace trackedFace = null;
                int size = this.f10939a.f10943d.size();
                int i2 = 0;
                while (i2 < size) {
                    TrackedFace trackedFace2 = (TrackedFace) this.f10939a.f10943d.get(i2);
                    Rect rect3 = trackedFace2.f10954f;
                    double a = FaceTracker.m18975a(exactCenterX, exactCenterY, rect3.exactCenterX(), rect3.exactCenterY());
                    if (a >= d) {
                        trackedFace2 = trackedFace;
                        a = d;
                    }
                    i2++;
                    d = a;
                    trackedFace = trackedFace2;
                }
                c.put(rect2, trackedFace);
                arrayList2.remove(trackedFace);
            }
            if (arrayList2.size() > 0) {
                int size2 = arrayList2.size();
                for (i = 0; i < size2; i++) {
                    this.f10939a.f10943d.remove((TrackedFace) arrayList2.get(i));
                }
            }
            if (this.f10939a.f10943d.size() < arrayList.size()) {
                HashMap c2 = Maps.c();
                for (Rect rect4 : c.keySet()) {
                    trackedFace2 = (TrackedFace) c.get(rect4);
                    c2.put(Double.valueOf(FaceTracker.m18975a(rect4.exactCenterX(), rect4.exactCenterY(), trackedFace2.f10952d, trackedFace2.f10953e)), rect4);
                }
                Set<Double> keySet = c2.keySet();
                Double[] dArr = new Double[keySet.size()];
                int i3 = 0;
                for (Double d2 : keySet) {
                    dArr[i3] = d2;
                    i3++;
                }
                Arrays.sort(dArr);
                int size3 = arrayList.size() - this.f10939a.f10943d.size();
                for (i3 = 0; i3 < size3; i3++) {
                    rect4 = (Rect) c2.get(dArr[(dArr.length - 1) - i3]);
                    this.f10939a.f10943d.add(new TrackedFace(rect4));
                    c.remove(rect4);
                }
            }
            for (Rect rect42 : c.keySet()) {
                ((TrackedFace) c.get(rect42)).m18980a(rect42);
            }
        }

        private void m18974b() {
            int size = this.f10939a.f10943d.size();
            for (int i = 0; i < size; i++) {
                TrackedFace trackedFace = (TrackedFace) this.f10939a.f10943d.get(i);
                if (trackedFace.f10956h) {
                    if (FaceTracker.m18975a(trackedFace.f10952d, trackedFace.f10953e, trackedFace.f10957i, trackedFace.f10958j) > 120.0d) {
                        trackedFace.f10956h = false;
                        trackedFace.f10959k = 0;
                    } else {
                        trackedFace.f10959k++;
                    }
                } else if (trackedFace.f10955g < 60.0d) {
                    trackedFace.f10956h = true;
                    trackedFace.f10957i = trackedFace.f10952d;
                    trackedFace.f10958j = trackedFace.f10953e;
                }
            }
        }
    }

    public FaceTracker(FaceDetectionManager faceDetectionManager, FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f10946g = fbHandlerThreadFactory.a(getClass().getCanonicalName() + ".background", ThreadPriority.BACKGROUND);
        this.f10946g.start();
        Looper looper = this.f10946g.getLooper();
        if (looper == null) {
            BLog.b(f10940a, "Error creating FaceTracker -- no looper could be retrieved frombackground thread");
            return;
        }
        this.f10947h = new TrackingHandler(this, looper);
        this.f10948i = new PublishingHandler(this);
        this.f10942c = faceDetectionManager;
        this.f10942c.f10937g.add(this);
    }

    public final void m18977a() {
        int i;
        FaceDetectionManager faceDetectionManager = this.f10942c;
        int i2 = 0;
        ArrayList a = Lists.a();
        for (i = 0; i < faceDetectionManager.f10937g.size(); i++) {
            if (((FaceTracker) faceDetectionManager.f10937g.get(i)).equals(this)) {
                a.add(Integer.valueOf(i));
            }
        }
        i = a.size();
        while (i2 < i) {
            faceDetectionManager.f10937g.remove(((Integer) a.get(i2)).intValue());
            i2++;
        }
        this.f10946g.interrupt();
    }

    public static double m18975a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public static void m18976a(FaceTracker faceTracker, List list) {
        int size = faceTracker.f10941b.size();
        for (int i = 0; i < size; i++) {
            ((TrackedFacesListener) faceTracker.f10941b.get(i)).mo1159a(list);
        }
    }

    public final void m18978b(TrackedFacesListener trackedFacesListener) {
        if (trackedFacesListener != null) {
            this.f10941b.remove(trackedFacesListener);
        }
    }
}

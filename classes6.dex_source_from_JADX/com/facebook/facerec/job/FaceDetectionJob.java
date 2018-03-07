package com.facebook.facerec.job;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.facedetection.Tracker;
import com.facebook.facedetection.model.TagDescriptor;
import com.facebook.facerec.manager.LegacyFaceRecManager.FaceDetectionCompletedListenerImpl;
import com.facebook.photos.base.tagging.FaceBox;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: null camera target */
public class FaceDetectionJob implements Runnable {
    private final FaceDetectionCompletedListenerImpl f9836a;
    private final DefaultAndroidThreadUtil f9837b;
    private final Tracker f9838c;
    private final boolean f9839d;
    @Nullable
    private final String f9840e;
    @Nullable
    private final Bitmap f9841f;
    private final int f9842g;

    public FaceDetectionJob(FaceDetectionCompletedListenerImpl faceDetectionCompletedListenerImpl, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Tracker tracker, String str, Bitmap bitmap, boolean z, int i) {
        this.f9836a = faceDetectionCompletedListenerImpl;
        this.f9837b = defaultAndroidThreadUtil;
        this.f9838c = (Tracker) Preconditions.checkNotNull(tracker);
        this.f9840e = str;
        this.f9841f = bitmap;
        this.f9839d = z;
        this.f9842g = i;
    }

    public void run() {
        this.f9837b.b();
        if (this.f9838c.m15545a()) {
            List a = Lists.a();
            List a2;
            if (this.f9841f != null) {
                a2 = this.f9838c.m15544a(this.f9841f, this.f9842g, this.f9839d);
            } else if (this.f9840e != null) {
                List a3;
                Tracker tracker = this.f9838c;
                String str = this.f9840e;
                int i = this.f9842g;
                boolean z = this.f9839d;
                if (tracker.f9800b == null || !tracker.f9800b.mo1020a()) {
                    a3 = Lists.a();
                } else {
                    a3 = tracker.f9800b.mo1019a(str, i, tracker.f9799a, z);
                }
                a2 = a3;
            } else {
                m15590a();
                return;
            }
            for (TagDescriptor tagDescriptor : r0) {
                RectF rectF = tagDescriptor.f9826c;
                if (rectF.height() < 0.0f) {
                    float f = rectF.top;
                    rectF.top = rectF.bottom;
                    rectF.bottom = f;
                }
                new StringBuilder("face found! rect: ").append(rectF.toString());
                FaceBox faceBox = new FaceBox(rectF, null, false);
                faceBox.m20154a(tagDescriptor.f9831h, tagDescriptor.f9832i);
                faceBox.f12774j = tagDescriptor.f9830g;
                a.add(faceBox);
            }
            this.f9836a.m15637a(a);
            new StringBuilder("Faces detected in exhaustive mode: ").append(a.size());
            return;
        }
        m15590a();
    }

    private void m15590a() {
        this.f9836a.m15637a(new ArrayList());
    }
}

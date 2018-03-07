package com.facebook.facedetection.detector;

import android.graphics.Bitmap;
import com.facebook.facedetection.model.TagDescriptor;
import java.util.List;

/* compiled from: numNoOps */
public interface InternalFaceDetector {
    List<TagDescriptor> mo1018a(Bitmap bitmap, int i, boolean z);

    @Deprecated
    List<TagDescriptor> mo1019a(String str, int i, int i2, boolean z);

    boolean mo1020a();
}

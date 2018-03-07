package com.facebook.facerec.recog;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.photos.base.tagging.FaceBox;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: no_results_found */
public class FaceRecParams {
    public final AbstractFbErrorReporter f9947a;
    public final List<FaceBox> f9948b;
    private final String f9949c;

    public FaceRecParams(FbErrorReporter fbErrorReporter, List<FaceBox> list, String str) {
        this.f9947a = (AbstractFbErrorReporter) Preconditions.checkNotNull(fbErrorReporter);
        this.f9948b = (List) Preconditions.checkNotNull(list);
        this.f9949c = str;
    }
}

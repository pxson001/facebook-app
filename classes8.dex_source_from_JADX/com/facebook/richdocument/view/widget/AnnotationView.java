package com.facebook.richdocument.view.widget;

import android.view.View;
import com.facebook.richdocument.model.block.Annotation;

/* compiled from: open_page_promotion */
public interface AnnotationView<V extends Annotation> {
    View mo438b();

    boolean mo439c();

    V getAnnotation();

    void setIsOverlay(boolean z);
}

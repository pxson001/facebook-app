package com.facebook.photos.tagging.shared.layout;

import com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection;

/* compiled from: hardware_click */
public interface LayoutableTagView {
    void m21060a(int i);

    void m21061a(ArrowDirection arrowDirection, InsetContainerBounds insetContainerBounds);

    ArrowDirection getArrowDirection();

    int getArrowLength();

    void setArrowDirection(ArrowDirection arrowDirection);
}

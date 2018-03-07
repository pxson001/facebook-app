package com.facebook.richdocument.view.block;

import com.facebook.richdocument.model.block.AudioAnnotation;

/* compiled from: pandora_two_views_row */
public interface AudioAnnotationAware {

    /* compiled from: pandora_two_views_row */
    public enum AudioAnnotationActionCondition {
        EXPAND_COLLAPSE_TRIGGERED,
        SCROLL_TRIGGERED,
        ENFORCED
    }

    void mo390a(AudioAnnotation audioAnnotation);

    void mo393a(AudioAnnotationActionCondition audioAnnotationActionCondition);

    void mo394b(AudioAnnotationActionCondition audioAnnotationActionCondition);
}

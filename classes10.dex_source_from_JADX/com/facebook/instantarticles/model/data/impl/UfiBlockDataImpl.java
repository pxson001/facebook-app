package com.facebook.instantarticles.model.data.impl;

import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData;
import javax.annotation.Nullable;

/* compiled from: video_element_end */
public class UfiBlockDataImpl extends BaseBlockData implements BlockData {
    public final FeedbackAnnotation f513a;

    public UfiBlockDataImpl(FeedbackAnnotation feedbackAnnotation) {
        super(301);
        this.f513a = feedbackAnnotation;
    }

    @Nullable
    public final String m612l() {
        return this.f513a.b.z_();
    }
}

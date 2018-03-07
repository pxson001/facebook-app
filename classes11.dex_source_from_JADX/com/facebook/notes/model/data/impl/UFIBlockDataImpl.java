package com.facebook.notes.model.data.impl;

import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData;
import javax.annotation.Nullable;

/* compiled from: Trying to link to a map without any address or location */
public class UFIBlockDataImpl extends BaseBlockData implements BlockData {
    public final FeedbackAnnotation f10534a;

    public UFIBlockDataImpl(FeedbackAnnotation feedbackAnnotation) {
        super(203);
        this.f10534a = feedbackAnnotation;
    }

    @Nullable
    public final String m11035l() {
        return this.f10534a.b.z_();
    }
}

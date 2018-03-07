package com.facebook.feedback.reactions.ui;

import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.ui.ReactionsLongPressTouchListener.LongPressListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: gk_android_video_exoplayer_direct_source_rollout */
public class ReactionsLongPressTouchListenerProvider extends AbstractAssistedProvider<ReactionsLongPressTouchListener> {
    public final ReactionsLongPressTouchListener m30254a(LongPressListener longPressListener) {
        return new ReactionsLongPressTouchListener(QeInternalImplMethodAutoProvider.m3744a(this), ReactionsExperimentUtil.m10410a(this), longPressListener);
    }
}

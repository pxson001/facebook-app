package com.facebook.ui.animations;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringCurveRecorder;
import javax.inject.Inject;

/* compiled from: composerSessionId */
public class ListViewEntryAnimator {
    private static final SpringConfig f5363a = SpringConfig.b(10.0d, 3.0d);
    private final DefaultAndroidThreadUtil f5364b;
    private final SpringCurveRecorder f5365c;
    private SpringConfig f5366d = f5363a;
    public AnimationState f5367e = AnimationState.INACTIVE;

    /* compiled from: composerSessionId */
    public enum AnimationState {
        INACTIVE,
        SCHEDULED,
        ACTIVE,
        COMPLETE
    }

    private static ListViewEntryAnimator m10258b(InjectorLike injectorLike) {
        return new ListViewEntryAnimator(DefaultAndroidThreadUtil.b(injectorLike), SpringCurveRecorder.m10189a(injectorLike));
    }

    @Inject
    public ListViewEntryAnimator(DefaultAndroidThreadUtil defaultAndroidThreadUtil, SpringCurveRecorder springCurveRecorder) {
        this.f5364b = defaultAndroidThreadUtil;
        this.f5365c = springCurveRecorder;
    }
}

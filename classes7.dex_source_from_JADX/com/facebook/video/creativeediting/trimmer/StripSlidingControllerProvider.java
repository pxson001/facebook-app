package com.facebook.video.creativeediting.trimmer;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.creativeediting.VideoTrimmingController.C11847;
import com.facebook.video.creativeediting.utilities.StripViewVideoTimeConverter;
import com.facebook.video.creativeediting.utilities.TrimmedVideoLengthChecker;
import java.util.concurrent.Executor;

/* compiled from: draft_comment_text_restored */
public class StripSlidingControllerProvider extends AbstractAssistedProvider<StripSlidingController> {
    public final StripSlidingController m19568a(StripViewVideoTimeConverter stripViewVideoTimeConverter, StripHandleController stripHandleController, TrimmedVideoLengthChecker trimmedVideoLengthChecker, C11847 c11847) {
        return new StripSlidingController((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), stripViewVideoTimeConverter, stripHandleController, trimmedVideoLengthChecker, c11847);
    }
}

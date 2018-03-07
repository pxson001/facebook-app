package com.facebook.video.creativeediting.trimmer;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.creativeediting.VideoTrimmingController.C11858;
import com.facebook.video.creativeediting.utilities.ZoomPositionConverter;
import java.util.concurrent.Executor;

/* compiled from: downstateType */
public class StripZoomingControllerProvider extends AbstractAssistedProvider<StripZoomingController> {
    public final StripZoomingController m19572a(ZoomPositionConverter zoomPositionConverter, StripHandleController stripHandleController, StripScrubberController stripScrubberController, C11858 c11858) {
        return new StripZoomingController((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), zoomPositionConverter, stripHandleController, stripScrubberController, c11858);
    }
}

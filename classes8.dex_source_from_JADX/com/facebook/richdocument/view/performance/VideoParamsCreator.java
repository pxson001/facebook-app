package com.facebook.richdocument.view.performance;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.model.block.VideoBlockInput;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.VideoBlockData;
import com.facebook.richdocument.view.autoplay.VideoAutoPlayPolicy;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.inject.Inject;

@ContextScoped
/* compiled from: page_call_to_action_delete */
public class VideoParamsCreator implements IncrementalUiIdleJob {
    private static VideoParamsCreator f6918f;
    private static final Object f6919g = new Object();
    @Inject
    public VideoServer f6920a;
    @Inject
    public VideoAutoPlayPolicy f6921b;
    @Inject
    public GatekeeperStoreImpl f6922c;
    private final Queue<VideoBlockData> f6923d = new LinkedList();
    private final HashMap<VideoBlockData, VideoBlockInput> f6924e = new HashMap();

    private static VideoParamsCreator m7159b(InjectorLike injectorLike) {
        VideoParamsCreator videoParamsCreator = new VideoParamsCreator();
        VideoAutoPlayPolicy a = VideoAutoPlayPolicy.m6889a(injectorLike);
        GatekeeperStoreImpl a2 = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        videoParamsCreator.f6920a = VideoServerMethodAutoProvider.a(injectorLike);
        videoParamsCreator.f6921b = a;
        videoParamsCreator.f6922c = a2;
        return videoParamsCreator;
    }

    public final synchronized void m7161a(RichDocumentBlocksImpl richDocumentBlocksImpl) {
        if (richDocumentBlocksImpl != null) {
            for (int i = 0; i < richDocumentBlocksImpl.m5459c(); i++) {
                BlockData a = richDocumentBlocksImpl.m5457a(i);
                if ((a instanceof VideoBlockData) && ((VideoBlockData) a).mo305p() != null) {
                    this.f6923d.add((VideoBlockData) a);
                }
            }
        }
    }

    public final boolean mo409i() {
        return !this.f6923d.isEmpty();
    }

    public static VideoParamsCreator m7158a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoParamsCreator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6919g) {
                VideoParamsCreator videoParamsCreator;
                if (a2 != null) {
                    videoParamsCreator = (VideoParamsCreator) a2.a(f6919g);
                } else {
                    videoParamsCreator = f6918f;
                }
                if (videoParamsCreator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7159b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6919g, b3);
                        } else {
                            f6918f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoParamsCreator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void mo410j() {
        VideoBlockData videoBlockData = (VideoBlockData) this.f6923d.poll();
        if (videoBlockData != null) {
            this.f6924e.put(videoBlockData, VideoBlockInput.m5450a(videoBlockData, this.f6920a, this.f6921b, this.f6922c.a(96, false)));
        }
    }

    public final synchronized VideoBlockInput m7160a(VideoBlockData videoBlockData) {
        VideoBlockInput videoBlockInput;
        if (videoBlockData == null) {
            videoBlockInput = null;
        } else if (this.f6924e.containsKey(videoBlockData)) {
            videoBlockInput = (VideoBlockInput) this.f6924e.get(videoBlockData);
        } else {
            videoBlockInput = VideoBlockInput.m5450a(videoBlockData, this.f6920a, this.f6921b, this.f6922c.a(96, false));
            this.f6923d.remove(videoBlockData);
            this.f6924e.put(videoBlockData, videoBlockInput);
        }
        return videoBlockInput;
    }
}

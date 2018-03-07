package com.facebook.composer.ui.underwood;

import android.os.Handler;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.media.transcode.video.VideoTranscodeSession;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.creativeediting.abtest.ExperimentsForVideoCreativeEditingAbtestModule;
import javax.inject.Inject;

/* compiled from: commercial_break_cancel */
public class UnderwoodVideoTranscodingUtil {
    public final VideoTranscodeSession f17238a;
    private final MediaItemFactory f17239b;
    public final QeAccessor f17240c;
    public final Handler f17241d;
    private final Handler f17242e;

    public static UnderwoodVideoTranscodingUtil m21170b(InjectorLike injectorLike) {
        return new UnderwoodVideoTranscodingUtil(VideoTranscodeSession.b(injectorLike), MediaItemFactory.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public UnderwoodVideoTranscodingUtil(VideoTranscodeSession videoTranscodeSession, MediaItemFactory mediaItemFactory, QeAccessor qeAccessor, Handler handler, Handler handler2) {
        this.f17238a = videoTranscodeSession;
        this.f17239b = mediaItemFactory;
        this.f17240c = qeAccessor;
        this.f17241d = handler;
        this.f17242e = handler2;
    }

    public static UnderwoodVideoTranscodingUtil m21169a(InjectorLike injectorLike) {
        return m21170b(injectorLike);
    }

    public final void m21171a(final ComposerAttachment composerAttachment, final Runnable runnable) {
        if (composerAttachment.b() != null && composerAttachment.b().m() == MediaType.VIDEO && composerAttachment.c() != null && MediaItemFactory.a(composerAttachment.c())) {
            if (this.f17240c.a(Liveness.Live, ExposureLogging.Off, ExperimentsForVideoCreativeEditingAbtestModule.d, false)) {
                HandlerDetour.a(this.f17242e, new Runnable(this) {
                    final /* synthetic */ UnderwoodVideoTranscodingUtil f17237c;

                    public void run() {
                        if (this.f17237c.f17238a.a((VideoItem) composerAttachment.b()) && this.f17237c.f17240c.a(ExperimentsForVideoCreativeEditingAbtestModule.f, false)) {
                            HandlerDetour.a(this.f17237c.f17241d, runnable, -1878320460);
                        }
                    }
                }, -1715430268);
            } else if (this.f17240c.a(ExperimentsForVideoCreativeEditingAbtestModule.f, false)) {
                HandlerDetour.a(this.f17241d, runnable, -2082811849);
            }
        }
    }
}

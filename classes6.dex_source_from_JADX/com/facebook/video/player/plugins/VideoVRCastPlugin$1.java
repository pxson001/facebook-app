package com.facebook.video.player.plugins;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: commerce_view_page_store_entry_point */
class VideoVRCastPlugin$1 implements OnClickListener {
    final /* synthetic */ VideoVRCastPlugin f19425a;

    /* compiled from: commerce_view_page_store_entry_point */
    class C14501 extends FbAsyncTask<Void, Void, Void> {
        final /* synthetic */ VideoVRCastPlugin$1 f19424a;

        C14501(VideoVRCastPlugin$1 videoVRCastPlugin$1) {
            this.f19424a = videoVRCastPlugin$1;
        }

        protected final Object m28202a(Object[] objArr) {
            VideoVRCastPlugin videoVRCastPlugin = this.f19424a.f19425a;
            Intent a = VideoVRCastPlugin.a(videoVRCastPlugin.m, videoVRCastPlugin.v, videoVRCastPlugin.n, videoVRCastPlugin.o, videoVRCastPlugin.p);
            videoVRCastPlugin.c.a(videoVRCastPlugin.s.value, videoVRCastPlugin.v, videoVRCastPlugin.h != null ? videoVRCastPlugin.h.f() : -1);
            videoVRCastPlugin.b.b(a, videoVRCastPlugin.getContext());
            return null;
        }
    }

    VideoVRCastPlugin$1(VideoVRCastPlugin videoVRCastPlugin) {
        this.f19425a = videoVRCastPlugin;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 867625632);
        new C14501(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        Logger.a(2, EntryType.UI_INPUT_END, 427452570, a);
    }
}

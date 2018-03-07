package com.facebook.messaging.composershortcuts;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainerLogic.C11621;
import com.facebook.messaging.composershortcuts.OverflowComposerShortcutsAdapter.C11681;
import com.facebook.messaging.composershortcuts.PlatformContentViewHolder.C11741;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: message_send */
public class PlatformContentAdapter extends Adapter<PlatformContentViewHolder> {
    private final PlatformContentViewHolderProvider f10157a;
    public ImmutableList<PlatformSampleContent> f10158b = RegularImmutableList.a;
    public C11681 f10159c;

    public final void m10615a(ViewHolder viewHolder, int i) {
        PlatformContentViewHolder platformContentViewHolder = (PlatformContentViewHolder) viewHolder;
        MediaResource mediaResource = ((PlatformSampleContent) this.f10158b.get(i)).f10164a;
        final MediaResource mediaResource2 = ((PlatformSampleContent) this.f10158b.get(i)).f10165b;
        platformContentViewHolder.f10163n.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) platformContentViewHolder.f10162m.b(platformContentViewHolder.f10163n.getController())).a(PlatformContentViewHolder.f10161l).b(mediaResource.c).a(new C11741(platformContentViewHolder))).s());
        platformContentViewHolder.f10163n.setAspectRatio(((float) mediaResource.j) / ((float) mediaResource.k));
        platformContentViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformContentAdapter f10156b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1332558604);
                C11681 c11681 = this.f10156b.f10159c;
                MediaResource mediaResource = mediaResource2;
                if (c11681.f10120a.f10144s != null) {
                    C11621 c11621 = c11681.f10120a.f10144s;
                    if (c11621.f10016a.f10046w != null) {
                        c11621.f10016a.f10046w.a(mediaResource);
                    }
                    c11621.f10016a.m10555g();
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1097489961, a);
            }
        });
    }

    @Inject
    public PlatformContentAdapter(PlatformContentViewHolderProvider platformContentViewHolderProvider) {
        this.f10157a = platformContentViewHolderProvider;
    }

    public final ViewHolder m10614a(ViewGroup viewGroup, int i) {
        return new PlatformContentViewHolder((FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906328, viewGroup, false), FbDraweeControllerBuilder.b(this.f10157a));
    }

    public final int aZ_() {
        return this.f10158b.size();
    }
}

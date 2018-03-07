package com.facebook.messaging.montage.composer;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.editing.MultimediaEditorController;
import com.facebook.messaging.media.editing.MultimediaEditorController.C13023;
import com.facebook.messaging.montage.composer.MontageMediaPickerCanvasFragment.C13941;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: is_nux */
public class MontageMediaPickerAdapter extends Adapter<MediaResourceViewHolder> {
    public final List<MediaResource> f12530a = new ArrayList();
    private final OnClickListener f12531b = new C13931(this);
    public C13941 f12532c;

    /* compiled from: is_nux */
    class C13931 implements OnClickListener {
        final /* synthetic */ MontageMediaPickerAdapter f12529a;

        C13931(MontageMediaPickerAdapter montageMediaPickerAdapter) {
            this.f12529a = montageMediaPickerAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -180739588);
            if (this.f12529a.f12532c != null) {
                MediaResource mediaResource = (MediaResource) view.getTag();
                if (mediaResource != null) {
                    C13941 c13941 = this.f12529a.f12532c;
                    if (c13941.f12533a.al != null) {
                        MontageComposerController montageComposerController = c13941.f12533a.al;
                        if (mediaResource.c()) {
                            MontageComposerController.m12933a(montageComposerController, montageComposerController.f12471f.m13015a(mediaResource), false);
                        } else {
                            montageComposerController.f12477l.m12969e();
                            if (Type.VIDEO.equals(mediaResource.d)) {
                                montageComposerController.f12479n.m12219a(mediaResource.c, null);
                            } else if (Type.PHOTO.equals(mediaResource.d)) {
                                MultimediaEditorController multimediaEditorController = montageComposerController.f12479n;
                                multimediaEditorController.f11567d.c(ImageRequest.a(mediaResource.c), null).a(new C13023(multimediaEditorController), multimediaEditorController.f11569f);
                            }
                            MontageComposerController.m12936j(montageComposerController);
                        }
                    }
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 643304026, a);
        }
    }

    /* compiled from: is_nux */
    class MediaResourceViewHolder extends ViewHolder {
        public MediaResourceViewHolder(View view) {
            super(view);
        }
    }

    MontageMediaPickerAdapter() {
    }

    public final void m13000a(ViewHolder viewHolder, int i) {
        MediaResourceViewHolder mediaResourceViewHolder = (MediaResourceViewHolder) viewHolder;
        MediaResource mediaResource = (MediaResource) this.f12530a.get(i);
        mediaResourceViewHolder.a.setTag(mediaResource);
        MontageComposerMediaPickerItemView montageComposerMediaPickerItemView = (MontageComposerMediaPickerItemView) mediaResourceViewHolder.a;
        ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource.c);
        a.d = montageComposerMediaPickerItemView.f12491d;
        montageComposerMediaPickerItemView.f12493f.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) montageComposerMediaPickerItemView.f12489a.p().a(MontageComposerMediaPickerItemView.f12488b).a(montageComposerMediaPickerItemView.f12490c)).c(a.m())).b(montageComposerMediaPickerItemView.f12493f.getController())).s());
        montageComposerMediaPickerItemView.f12493f.setVisibility(0);
        montageComposerMediaPickerItemView.f12494g.setVisibility(Type.VIDEO.equals(mediaResource.d) ? 0 : 8);
        montageComposerMediaPickerItemView.f12492e.e();
    }

    public final ViewHolder m12999a(ViewGroup viewGroup, int i) {
        MontageComposerMediaPickerItemView montageComposerMediaPickerItemView = new MontageComposerMediaPickerItemView(viewGroup.getContext());
        montageComposerMediaPickerItemView.setOnClickListener(this.f12531b);
        return new MediaResourceViewHolder(montageComposerMediaPickerItemView);
    }

    public final int aZ_() {
        return this.f12530a.size();
    }
}

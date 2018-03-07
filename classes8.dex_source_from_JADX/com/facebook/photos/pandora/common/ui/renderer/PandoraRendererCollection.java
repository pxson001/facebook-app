package com.facebook.photos.pandora.common.ui.renderer;

import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: com.google.cast.media */
public class PandoraRendererCollection {
    public ImmutableList<PandoraRendererRow> f17469a;

    public final void m21442a(ImmutableList<PandoraRendererRow> immutableList) {
        if (this.f17469a == null) {
            this.f17469a = immutableList;
            return;
        }
        Builder builder = new Builder();
        builder.b(this.f17469a).b(immutableList);
        this.f17469a = builder.b();
    }

    public final int m21443c() {
        if (this.f17469a == null) {
            return 0;
        }
        int size = this.f17469a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow = (PandoraRendererMultiMediaRow) ((PandoraRendererRow) this.f17469a.get(i2));
            if (pandoraRendererMultiMediaRow.f17502a == null) {
                i3 = 0;
            } else {
                i3 = pandoraRendererMultiMediaRow.f17502a.size();
            }
            i += i3;
        }
        return i;
    }

    public final ImmutableList<SizeAwareMedia> m21444d() {
        int i = 0;
        Builder builder = new Builder();
        int size = this.f17469a.size();
        for (int i2 = 0; i2 < size; i2++) {
            PandoraRendererRow pandoraRendererRow = (PandoraRendererRow) this.f17469a.get(i2);
            if (pandoraRendererRow instanceof PandoraRendererMultiMediaRow) {
                builder.b(((PandoraRendererMultiMediaRow) pandoraRendererRow).f17502a);
            }
        }
        ImmutableList b = builder.b();
        builder = new Builder();
        size = b.size();
        while (i < size) {
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = (PandoraMultiMediaStoryEntry) b.get(i);
            if (!(pandoraMultiMediaStoryEntry == null || pandoraMultiMediaStoryEntry.f17498a == null)) {
                builder.c(pandoraMultiMediaStoryEntry.f17498a);
            }
            i++;
        }
        return builder.b();
    }
}

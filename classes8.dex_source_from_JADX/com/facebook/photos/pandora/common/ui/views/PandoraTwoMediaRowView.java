package com.facebook.photos.pandora.common.ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: com.facebook.search.results.fragment.entities.SearchResultsEntitiesFragment */
public class PandoraTwoMediaRowView extends BasePandoraMultiMediaRowView {
    public double f17564i;
    public double f17565j;

    public PandoraTwoMediaRowView(Context context) {
        super(context);
        mo1048a();
    }

    protected final void mo1048a() {
        super.mo1048a();
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f17565j = (double) getResources().getDimension(2131430950);
        this.f17564i = (((double) i) - this.f17565j) / 2.0d;
    }

    public final void mo1049a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, String str, boolean z, boolean z2, boolean z3, @Nullable PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment) {
        super.mo1049a(pandoraRendererMultiMediaRow, pandoraInstanceId, pandoraRequestSource, str, z, z2, z3, pandoraInlineVideoEnvironment);
        if (pandoraRendererMultiMediaRow != null && pandoraRendererMultiMediaRow.f17502a != null && !pandoraRendererMultiMediaRow.f17502a.isEmpty()) {
            m21502c();
            m21538a(pandoraRendererMultiMediaRow.f17502a);
            m21501b();
        }
    }

    private void m21538a(ImmutableList<PandoraMultiMediaStoryEntry> immutableList) {
        for (int i = 0; i < immutableList.size(); i++) {
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = (PandoraMultiMediaStoryEntry) immutableList.get(i);
            if (!(pandoraMultiMediaStoryEntry == null || pandoraMultiMediaStoryEntry.f17498a == null || pandoraMultiMediaStoryEntry.f17498a.J() == null)) {
                int i2 = (int) (((double) i) * (this.f17564i + this.f17565j));
                m21499a(new Rect(i2, 0, (int) (((double) i2) + this.f17564i), (int) this.f17564i), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.J().b()), pandoraMultiMediaStoryEntry.f17498a, i, "LoadSquareImageThumbnail");
            }
        }
    }

    protected int getRowHeight() {
        return (int) this.f17564i;
    }

    protected final int getNumOfItems() {
        return 2;
    }
}

package com.facebook.photos.pandora.common.ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry.PhotoEntryType;
import javax.annotation.Nullable;

/* compiled from: com.facebook.search.results.fragment.photos.SearchResultsPhotosFragment */
public class PandoraSingleMediaRowView extends BasePandoraMultiMediaRowView {
    private double f17551i = -1.0d;
    private double f17552j = -1.0d;
    private double f17553k = -1.0d;
    private double f17554l = -1.0d;
    private double f17555m = -1.0d;
    private double f17556n = -1.0d;
    private double f17557o = -1.0d;
    private PandoraRendererMultiMediaRow f17558p;

    public PandoraSingleMediaRowView(Context context) {
        super(context);
        mo1048a();
    }

    protected final void mo1048a() {
        super.mo1048a();
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f17551i = (double) getResources().getDimension(2131430950);
        this.f17552j = (((double) i) - (this.f17551i * 2.0d)) / 3.0d;
        this.f17553k = (double) i;
        this.f17554l = (this.f17552j * 2.0d) + this.f17551i;
        this.f17555m = this.f17553k;
        this.f17557o = this.f17553k;
    }

    public final void mo1049a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, String str, boolean z, boolean z2, boolean z3, @Nullable PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment) {
        super.mo1049a(pandoraRendererMultiMediaRow, pandoraInstanceId, pandoraRequestSource, str, z, z2, z3, pandoraInlineVideoEnvironment);
        if (pandoraRendererMultiMediaRow != null && pandoraRendererMultiMediaRow.f17502a != null && !pandoraRendererMultiMediaRow.f17502a.isEmpty()) {
            m21502c();
            this.f17558p = pandoraRendererMultiMediaRow;
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = (PandoraMultiMediaStoryEntry) pandoraRendererMultiMediaRow.f17502a.get(0);
            if (pandoraMultiMediaStoryEntry != null) {
                if (pandoraMultiMediaStoryEntry.f17500c == PhotoEntryType.LANDSCAPE) {
                    m21526a(pandoraMultiMediaStoryEntry);
                } else if (pandoraMultiMediaStoryEntry.f17500c == PhotoEntryType.PORTRAIT) {
                    m21527b(pandoraMultiMediaStoryEntry);
                } else {
                    m21528c(pandoraMultiMediaStoryEntry);
                }
                forceLayout();
                m21501b();
            }
        }
    }

    private void m21526a(PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.F() != null) {
            m21499a(new Rect(0, 0, (int) this.f17553k, (int) this.f17554l), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.F().b()), pandoraMultiMediaStoryEntry.f17498a, 0, "LoadLandscapeImageThumbnail");
        }
    }

    private void m21527b(PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.G() != null) {
            this.f17556n = (this.f17555m / ((double) pandoraMultiMediaStoryEntry.f17498a.G().c())) * ((double) pandoraMultiMediaStoryEntry.f17498a.G().a());
            m21499a(new Rect(0, 0, (int) this.f17555m, (int) this.f17556n), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.G().b()), pandoraMultiMediaStoryEntry.f17498a, 0, "LoadPortraitImageThumbnail");
        }
    }

    private void m21528c(PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.J() != null) {
            m21499a(new Rect(0, 0, (int) this.f17557o, (int) this.f17557o), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.J().b()), pandoraMultiMediaStoryEntry.f17498a, 0, "LoadSquareImageThumbnail");
        }
    }

    protected int getRowHeight() {
        PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = (PandoraMultiMediaStoryEntry) this.f17558p.f17502a.get(0);
        if (pandoraMultiMediaStoryEntry == null) {
            return 0;
        }
        if (pandoraMultiMediaStoryEntry.f17500c == PhotoEntryType.LANDSCAPE) {
            return (int) this.f17554l;
        }
        if (pandoraMultiMediaStoryEntry.f17500c == PhotoEntryType.PORTRAIT) {
            return (int) this.f17556n;
        }
        return pandoraMultiMediaStoryEntry.f17500c == PhotoEntryType.SQUARE ? (int) this.f17557o : 0;
    }
}

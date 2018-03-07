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

/* compiled from: com.facebook.search.results.fragment.feed.SearchResultsFeedFragment */
public class PandoraThreeMediaRowView extends BasePandoraMultiMediaRowView {
    private double f17559i = -1.0d;
    private double f17560j = -1.0d;
    private double f17561k = -1.0d;
    private int f17562l;
    private PandoraRendererMultiMediaRow f17563m;

    public PandoraThreeMediaRowView(Context context) {
        super(context);
        mo1048a();
    }

    protected final void mo1048a() {
        super.mo1048a();
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f17559i = (double) getResources().getDimension(2131430950);
        this.f17560j = (((double) i) - (this.f17559i * ((double) (getNumOfItems() - 1)))) / ((double) getNumOfItems());
        this.f17561k = (this.f17560j * ((double) (getNumOfItems() - 1))) + this.f17559i;
    }

    public final void mo1049a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, String str, boolean z, boolean z2, boolean z3, @Nullable PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment) {
        super.mo1049a(pandoraRendererMultiMediaRow, pandoraInstanceId, pandoraRequestSource, str, z, z2, z3, pandoraInlineVideoEnvironment);
        if (pandoraRendererMultiMediaRow != null && pandoraRendererMultiMediaRow.f17502a != null && !pandoraRendererMultiMediaRow.f17502a.isEmpty()) {
            m21502c();
            this.f17563m = pandoraRendererMultiMediaRow;
            if (((PandoraMultiMediaStoryEntry) pandoraRendererMultiMediaRow.f17502a.get(0)) != null) {
                this.f17562l = m21531a(pandoraRendererMultiMediaRow);
                forceLayout();
                m21535b(this.f17562l);
                m21501b();
            }
        }
    }

    private static int m21531a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
        if (pandoraRendererMultiMediaRow.f17502a.size() == 1) {
            return -1;
        }
        ImmutableList immutableList = pandoraRendererMultiMediaRow.f17502a;
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((PandoraMultiMediaStoryEntry) immutableList.get(i2)).f17501d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void m21535b(int i) {
        int i2 = -1;
        int i3;
        int i4;
        if (i == -1) {
            ImmutableList immutableList = this.f17563m.f17502a;
            int size = immutableList.size();
            i3 = 0;
            for (i4 = 0; i4 < size; i4++) {
                m21534a(i3, (PandoraMultiMediaStoryEntry) immutableList.get(i4), false);
                i3++;
            }
            return;
        }
        boolean z;
        boolean z2;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i2 = 0;
        }
        if (z) {
            z2 = true;
        } else {
            z2 = false;
        }
        ImmutableList immutableList2 = this.f17563m.f17502a;
        int size2 = immutableList2.size();
        i4 = 0;
        for (int i5 = 0; i5 < size2; i5++) {
            boolean z3;
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = (PandoraMultiMediaStoryEntry) immutableList2.get(i5);
            if (i4 == i) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i3 = i4;
            } else {
                boolean z4 = z2;
            }
            m21533a(i4, i3, i2, pandoraMultiMediaStoryEntry, z3);
            if (i4 != i || z) {
                i2++;
            }
            i4++;
        }
    }

    private void m21534a(int i, PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry, boolean z) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.E() != null) {
            m21499a(m21532a(i, 0, false), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.E().b()), pandoraMultiMediaStoryEntry.f17498a, i, z ? "LoadSquareImageThumbnail" : "LoadSmallImageThumbnail");
        }
    }

    private void m21533a(int i, int i2, int i3, PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry, boolean z) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null) {
            if (!z || pandoraMultiMediaStoryEntry.f17498a.H() != null) {
                if (z || pandoraMultiMediaStoryEntry.f17498a.E() != null) {
                    m21499a(m21532a(i2, i3, z), z ? Uri.parse(pandoraMultiMediaStoryEntry.f17498a.H().b()) : Uri.parse(pandoraMultiMediaStoryEntry.f17498a.E().b()), pandoraMultiMediaStoryEntry.f17498a, i, z ? "LoadSquareImageThumbnail" : "LoadSmallImageThumbnail");
                }
            }
        }
    }

    private Rect m21532a(int i, int i2, boolean z) {
        int i3;
        if (i != 0 && !z) {
            i3 = (int) (((double) i) * (this.f17559i + this.f17560j));
        } else if (i == 0 || !z) {
            i3 = 0;
        } else {
            i3 = (int) (this.f17559i + this.f17560j);
        }
        if (z) {
            return new Rect(i3, 0, (int) (((double) i3) + this.f17561k), (int) this.f17561k);
        }
        return new Rect(i3, (int) (((double) i2) * (this.f17560j + this.f17559i)), (int) (((double) i3) + this.f17560j), (int) ((((double) i2) * (this.f17560j + this.f17559i)) + this.f17560j));
    }

    protected int getRowHeight() {
        if (this.f17563m == null || this.f17563m.f17502a == null) {
            return 0;
        }
        if (this.f17562l == -1) {
            return (int) this.f17560j;
        }
        return (int) this.f17561k;
    }

    protected final int getNumOfItems() {
        return 3;
    }
}

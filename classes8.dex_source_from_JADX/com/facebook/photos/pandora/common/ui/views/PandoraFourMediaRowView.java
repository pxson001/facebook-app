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

/* compiled from: com.google.android.gms.cast.CATEGORY_CAST */
public class PandoraFourMediaRowView extends BasePandoraMultiMediaRowView {
    public double f17538i = -1.0d;
    public double f17539j = -1.0d;
    public double f17540k = -1.0d;
    public double f17541l = -1.0d;
    private PandoraRendererMultiMediaRow f17542m;

    public PandoraFourMediaRowView(Context context) {
        super(context);
        mo1048a();
    }

    protected final void mo1048a() {
        super.mo1048a();
        int i = getResources().getDisplayMetrics().widthPixels;
        this.f17538i = (double) getResources().getDimension(2131430950);
        this.f17539j = (((double) i) - (this.f17538i * 2.0d)) / 3.0d;
        this.f17540k = (this.f17539j * 3.0d) + (this.f17538i * 2.0d);
        this.f17541l = (this.f17539j * 2.0d) + this.f17538i;
    }

    public final void mo1049a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow, PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, String str, boolean z, boolean z2, boolean z3, @Nullable PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment) {
        super.mo1049a(pandoraRendererMultiMediaRow, pandoraInstanceId, pandoraRequestSource, str, z, z2, z3, pandoraInlineVideoEnvironment);
        if (pandoraRendererMultiMediaRow != null && pandoraRendererMultiMediaRow.f17502a != null && !pandoraRendererMultiMediaRow.f17502a.isEmpty()) {
            m21502c();
            this.f17542m = pandoraRendererMultiMediaRow;
            if (((PandoraMultiMediaStoryEntry) pandoraRendererMultiMediaRow.f17502a.get(0)) != null) {
                int a = m21507a(pandoraRendererMultiMediaRow);
                forceLayout();
                m21511b(a);
                m21501b();
            }
        }
    }

    private static int m21507a(PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow) {
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

    private void m21511b(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f17542m.f17502a.size(); i3++) {
            if (i != i3) {
                int i4;
                if (i < 2) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                int i5 = i2 + 1;
                m21508a(i4, i2, (PandoraMultiMediaStoryEntry) this.f17542m.f17502a.get(i3));
                i2 = i5;
            } else {
                m21509a((PandoraMultiMediaStoryEntry) this.f17542m.f17502a.get(i3), i < 2 ? 0 : 1);
            }
        }
    }

    private void m21509a(PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry, int i) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.I() != null) {
            Rect rect;
            if (i == 0) {
                rect = new Rect(0, 0, (int) this.f17541l, (int) this.f17540k);
            } else {
                rect = new Rect((int) (this.f17538i + this.f17539j), 0, (int) ((this.f17538i + this.f17539j) + this.f17541l), (int) this.f17540k);
            }
            m21499a(rect, Uri.parse(pandoraMultiMediaStoryEntry.f17498a.I().b()), pandoraMultiMediaStoryEntry.f17498a, getNumOfItems() - 1, "LoadPortraitImageThumbnail");
        }
    }

    private void m21508a(int i, int i2, PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry) {
        if (pandoraMultiMediaStoryEntry != null && pandoraMultiMediaStoryEntry.f17498a != null && pandoraMultiMediaStoryEntry.f17498a.H() != null) {
            m21499a(m21510b(i, i2), Uri.parse(pandoraMultiMediaStoryEntry.f17498a.H().b()), pandoraMultiMediaStoryEntry.f17498a, i2, "LoadSmallImageThumbnail");
        }
    }

    private Rect m21510b(int i, int i2) {
        int i3 = 0;
        if (i != 0) {
            i3 = (int) (((double) i) * (this.f17538i + this.f17539j));
        }
        return new Rect(i3, (int) (((double) i2) * (this.f17539j + this.f17538i)), (int) (((double) i3) + this.f17539j), (int) ((((double) i2) * (this.f17539j + this.f17538i)) + this.f17539j));
    }

    protected int getRowHeight() {
        if (this.f17542m == null || this.f17542m.f17502a == null) {
            return 0;
        }
        return (int) this.f17540k;
    }

    protected final int getNumOfItems() {
        return 4;
    }
}

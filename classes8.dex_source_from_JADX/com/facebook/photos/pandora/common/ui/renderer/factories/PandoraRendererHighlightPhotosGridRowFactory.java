package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModelType;
import com.facebook.photos.pandora.common.data.model.PandoraMultiPhotoStoryModel;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiMediaRow.PandoraMultiMediaStoryEntry.PhotoEntryType;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.cast.metadata.LOCATION_LATITUDE */
public class PandoraRendererHighlightPhotosGridRowFactory extends AbstractPandoraRendererMultiDataModelsRowFactory {
    private final Lazy<PandoraHighlightsCalculator> f17487a;
    private final Lazy<MultiPhotoStoryModelRowBuilder> f17488b;
    private final Lazy<PandoraRendererMultiMediaRowEntryCache> f17489c;
    private final boolean f17490d;

    @Inject
    public PandoraRendererHighlightPhotosGridRowFactory(Lazy<PandoraHighlightsCalculator> lazy, Lazy<MultiPhotoStoryModelRowBuilder> lazy2, Lazy<PandoraRendererMultiMediaRowEntryCache> lazy3, @Assisted Boolean bool) {
        this.f17487a = lazy;
        this.f17488b = lazy2;
        this.f17489c = lazy3;
        this.f17490d = bool.booleanValue();
    }

    public final ImmutableList<PandoraRendererRow> m21471a(PandoraRendererCacheConfig pandoraRendererCacheConfig, ImmutableList<PandoraDataModel> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            Builder builder3;
            PandoraDataModel pandoraDataModel = (PandoraDataModel) immutableList.get(i);
            if (pandoraDataModel.mo1041a() == PandoraDataModelType.SINGLE_MEDIA) {
                PandoraSingleMediaModel pandoraSingleMediaModel = (PandoraSingleMediaModel) pandoraDataModel;
                PandoraMediaModel pandoraMediaModel = pandoraSingleMediaModel.f17370a;
                this.f17487a.get();
                builder.c(new PandoraMultiMediaStoryEntry(pandoraMediaModel, PandoraHighlightsCalculator.m21483a(pandoraSingleMediaModel.f17370a)));
                builder3 = builder;
            } else if (pandoraDataModel.mo1041a() == PandoraDataModelType.MULTI_PHOTO_STORY) {
                ImmutableList b = builder.b();
                if (!b.isEmpty()) {
                    builder2.b(m21469a(b, pandoraRendererCacheConfig));
                }
                Builder builder4 = new Builder();
                builder2.b(((MultiPhotoStoryModelRowBuilder) this.f17488b.get()).m21457a((PandoraMultiPhotoStoryModel) pandoraDataModel));
                builder3 = builder4;
            } else {
                builder3 = builder;
            }
            i++;
            builder = builder3;
        }
        ImmutableList b2 = builder.b();
        if (!b2.isEmpty()) {
            builder2.b(m21469a(b2, pandoraRendererCacheConfig));
        }
        return builder2.b();
    }

    private ImmutableList<PandoraRendererMultiMediaRow> m21469a(ImmutableList<PandoraMultiMediaStoryEntry> immutableList, PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        Builder builder = new Builder();
        PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry = null;
        int i = 0;
        List<PandoraMultiMediaStoryEntry> arrayList = new ArrayList();
        Object a = m21470a(pandoraRendererCacheConfig);
        if (!(a == null || a.isEmpty())) {
            arrayList.addAll(a);
            a.clear();
        }
        arrayList.addAll(immutableList);
        for (PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry2 : arrayList) {
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry22;
            pandoraMultiMediaStoryEntry22.f17501d = false;
        }
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3;
            PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry3;
            pandoraMultiMediaStoryEntry22 = (PandoraMultiMediaStoryEntry) arrayList.get(i2);
            if (((pandoraMultiMediaStoryEntry == null || (pandoraMultiMediaStoryEntry.f17498a.p() == pandoraMultiMediaStoryEntry22.f17498a.p() && pandoraMultiMediaStoryEntry.f17499b < pandoraMultiMediaStoryEntry22.f17499b)) && pandoraMultiMediaStoryEntry22.f17499b > 1.0d) || (this.f17490d && pandoraMultiMediaStoryEntry22.f17498a.p())) {
                pandoraMultiMediaStoryEntry = pandoraMultiMediaStoryEntry22;
            }
            i++;
            if (i == 6 || arrayList.lastIndexOf(pandoraMultiMediaStoryEntry22) == arrayList.size() - 1) {
                int i4;
                if (pandoraMultiMediaStoryEntry != null && (i2 == arrayList.size() - 1 || !((PandoraMultiMediaStoryEntry) arrayList.get(i2 + 1)).f17498a.p())) {
                    pandoraMultiMediaStoryEntry.f17501d = true;
                    if (pandoraMultiMediaStoryEntry.f17500c != PhotoEntryType.SQUARE) {
                        i3 = i2 + 1;
                        i4 = i3;
                        i3 = 0;
                        pandoraMultiMediaStoryEntry3 = null;
                        i2 = i4;
                    }
                }
                i3 = i2;
                i4 = i3;
                i3 = 0;
                pandoraMultiMediaStoryEntry3 = null;
                i2 = i4;
            } else {
                i3 = i;
                pandoraMultiMediaStoryEntry3 = pandoraMultiMediaStoryEntry;
            }
            i2++;
            pandoraMultiMediaStoryEntry = pandoraMultiMediaStoryEntry3;
            i = i3;
        }
        Collection arrayList2 = new ArrayList();
        i2 = 3;
        for (PandoraMultiMediaStoryEntry pandoraMultiMediaStoryEntry222 : arrayList) {
            if (pandoraMultiMediaStoryEntry222.f17501d && pandoraMultiMediaStoryEntry222.f17500c == PhotoEntryType.LANDSCAPE) {
                builder.c(new PandoraRendererMultiMediaRow(ImmutableList.of(pandoraMultiMediaStoryEntry222)));
            } else {
                if (pandoraMultiMediaStoryEntry222.f17501d && pandoraMultiMediaStoryEntry222.f17500c == PhotoEntryType.PORTRAIT) {
                    i2 = 4;
                }
                arrayList2.add(pandoraMultiMediaStoryEntry222);
                if (i2 == arrayList2.size()) {
                    builder.c(new PandoraRendererMultiMediaRow(ImmutableList.copyOf(arrayList2)));
                    i3 = 3;
                    arrayList2.clear();
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
        }
        if (!arrayList2.isEmpty()) {
            builder.c(new PandoraRendererMultiMediaRow(ImmutableList.copyOf(arrayList2)));
        }
        ImmutableList<PandoraRendererMultiMediaRow> b = builder.b();
        if (!pandoraRendererCacheConfig.f17482e) {
            return b;
        }
        ImmutableList<PandoraRendererMultiMediaRow> immutableList2 = b;
        while (true) {
            PandoraRendererMultiMediaRow pandoraRendererMultiMediaRow = (PandoraRendererMultiMediaRow) immutableList2.get(immutableList2.size() - 1);
            if (pandoraRendererMultiMediaRow.f17502a.size() < 3 && immutableList2.size() > 2) {
                m21470a(pandoraRendererCacheConfig).addAll(pandoraRendererMultiMediaRow.f17502a);
                immutableList2 = ImmutableList.copyOf(immutableList2.subList(0, immutableList2.size() - 1));
            }
        }
        return immutableList2;
    }

    private List<PandoraMultiMediaStoryEntry> m21470a(PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        List<PandoraMultiMediaStoryEntry> list;
        this.f17489c.get();
        if (pandoraRendererCacheConfig == null) {
            list = null;
        } else {
            list = (List) PandoraRendererMultiMediaRowEntryCache.f17491a.a(pandoraRendererCacheConfig);
            if (list == null) {
                list = new ArrayList();
            }
            PandoraRendererMultiMediaRowEntryCache.f17491a.a(pandoraRendererCacheConfig, list);
        }
        return list;
    }
}

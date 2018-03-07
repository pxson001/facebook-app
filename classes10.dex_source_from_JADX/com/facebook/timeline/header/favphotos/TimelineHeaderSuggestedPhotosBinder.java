package com.facebook.timeline.header.favphotos;

import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.SuggestedPhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.CollageLayoutFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.SuggestedPhotoModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fetch_suggested_bio */
public class TimelineHeaderSuggestedPhotosBinder {
    private static final Class<?> f11748a = TimelineHeaderSuggestedPhotosBinder.class;
    private final AbstractFbErrorReporter f11749b;
    private final TimelineHeaderFeaturedPhotosMosaicBinder f11750c;
    private final QeAccessor f11751d;
    private CollageLayoutFields[] f11752e;
    private CollageLayoutFields[] f11753f;
    private TimelineHeaderSuggestedPhotosView f11754g;

    @Inject
    public TimelineHeaderSuggestedPhotosBinder(AbstractFbErrorReporter abstractFbErrorReporter, TimelineHeaderFeaturedPhotosMosaicBinder timelineHeaderFeaturedPhotosMosaicBinder, QeAccessor qeAccessor) {
        this.f11749b = abstractFbErrorReporter;
        this.f11750c = timelineHeaderFeaturedPhotosMosaicBinder;
        this.f11751d = qeAccessor;
    }

    public final void m11839a(TimelineHeaderSuggestedPhotosView timelineHeaderSuggestedPhotosView, ImmutableList<? extends SuggestedPhoto> immutableList, OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.f11754g = timelineHeaderSuggestedPhotosView;
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < immutableList.size(); i++) {
            builder.c(((SuggestedPhotoModel) immutableList.get(i)).a());
        }
        ImmutableList b = builder.b();
        List arrayList = new ArrayList();
        CollageLayoutFields[] a = m11838a(immutableList.size());
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            arrayList.add(a[i2]);
        }
        this.f11750c.m11830a(this.f11754g.f11755a, b, arrayList);
        this.f11754g.setOnEditListener(onClickListener);
        this.f11754g.setOnCloseListener(onClickListener2);
        this.f11754g.setClickableColor(this.f11751d.a(ExperimentsForTimelineAbTestModule.am, false) ? 2131362082 : 2131361917);
    }

    private CollageLayoutFields[] m11838a(int i) {
        switch (i) {
            case 1:
                if (this.f11752e == null) {
                    this.f11752e = new CollageLayoutFields[]{m11837a(0, 0, 6, 3)};
                }
                return this.f11752e;
            case 2:
                if (this.f11753f == null) {
                    this.f11753f = new CollageLayoutFields[]{m11837a(0, 0, 3, 3), m11837a(3, 0, 6, 3)};
                }
                return this.f11753f;
            default:
                this.f11749b.b(f11748a.getSimpleName(), "suggested photos should be between 1 and 4. actual is " + i);
                return null;
        }
    }

    private static CollageLayoutFields m11837a(int i, int i2, int i3, int i4) {
        CollageLayoutFieldsModel.Builder builder = new CollageLayoutFieldsModel.Builder();
        builder.c = (double) i;
        builder = builder;
        builder.d = (double) i2;
        builder = builder;
        builder.b = (double) i3;
        builder = builder;
        builder.a = (double) i4;
        return builder.a();
    }
}

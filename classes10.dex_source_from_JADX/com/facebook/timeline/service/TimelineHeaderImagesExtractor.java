package com.facebook.timeline.service;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.header.favphotos.FavoritePhotosUtil;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineHeaderCommonFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.FavoritePhotoModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderProfileIntroCardFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderProfileIntroCardFieldsModel.FavoritePhotosModel;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ContextScoped
/* compiled from: extra_native_document_id */
public class TimelineHeaderImagesExtractor {
    private static TimelineHeaderImagesExtractor f12709b;
    private static final Object f12710c = new Object();
    private final FavoritePhotosUtil f12711a;

    private static TimelineHeaderImagesExtractor m12660b(InjectorLike injectorLike) {
        return new TimelineHeaderImagesExtractor(FavoritePhotosUtil.m11786a(injectorLike));
    }

    @Inject
    private TimelineHeaderImagesExtractor(FavoritePhotosUtil favoritePhotosUtil) {
        this.f12711a = favoritePhotosUtil;
    }

    public final ImmutableList<Uri> m12662a(TimelineHeaderCommonFields timelineHeaderCommonFields) {
        String str;
        Collection arrayList = new ArrayList();
        TimelineHeaderFocusedCoverPhotoFieldsModel o = timelineHeaderCommonFields.o();
        if (o == null || o.b() == null || o.b().du_() == null) {
            str = null;
        } else {
            str = o.b().du_().b();
        }
        String str2 = str;
        if (str2 != null) {
            arrayList.add(Uri.parse(str2));
        }
        str2 = timelineHeaderCommonFields.t() != null ? timelineHeaderCommonFields.t().b() : null;
        if (str2 != null) {
            arrayList.add(Uri.parse(str2));
        }
        m12661c(arrayList, timelineHeaderCommonFields);
        return ImmutableList.copyOf(arrayList);
    }

    public static TimelineHeaderImagesExtractor m12658a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderImagesExtractor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12710c) {
                TimelineHeaderImagesExtractor timelineHeaderImagesExtractor;
                if (a2 != null) {
                    timelineHeaderImagesExtractor = (TimelineHeaderImagesExtractor) a2.a(f12710c);
                } else {
                    timelineHeaderImagesExtractor = f12709b;
                }
                if (timelineHeaderImagesExtractor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12660b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12710c, b3);
                        } else {
                            f12709b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderImagesExtractor;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m12661c(List<Uri> list, TimelineHeaderCommonFields timelineHeaderCommonFields) {
        TimelineHeaderProfileIntroCardFieldsModel r = timelineHeaderCommonFields.r();
        if (r != null) {
            Object obj;
            ImmutableList immutableList;
            if (r == null || r.g() == null || r.g().a().isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                ImmutableList a = r.g().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    list.add(Uri.parse(((TimelineContextListItemFieldsModel) a.get(i)).b().b()));
                }
            }
            FavoritePhotosModel dx_ = r.dx_();
            if (dx_ != null) {
                m12659a(list, dx_.a());
            }
            if (r == null || r.m() == null) {
                immutableList = RegularImmutableList.a;
            } else {
                immutableList = r.m().a();
            }
            m12659a(list, FavoritePhotosUtil.m11788a(immutableList));
        }
    }

    private void m12659a(List<Uri> list, ImmutableList<? extends FavoritePhoto> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FavoritePhotoModel favoritePhotoModel = (FavoritePhotoModel) immutableList.get(i);
            list.add(Uri.parse(this.f12711a.m11793a(favoritePhotoModel.b(), favoritePhotoModel.a()).b()));
        }
    }
}

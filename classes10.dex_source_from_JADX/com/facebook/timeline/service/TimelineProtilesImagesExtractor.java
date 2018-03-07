package com.facebook.timeline.service;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileSectionFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileViewFieldsModel;
import com.facebook.timeline.protiles.util.ProtilesImageUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: extra_location_map_details */
public class TimelineProtilesImagesExtractor {
    private static TimelineProtilesImagesExtractor f12724b;
    private static final Object f12725c = new Object();
    public ProtilesImageUtil f12726a;

    /* compiled from: extra_location_map_details */
    public /* synthetic */ class C17831 {
        public static final /* synthetic */ int[] f12723a = new int[GraphQLProfileTileSectionType.values().length];

        static {
            try {
                f12723a[GraphQLProfileTileSectionType.PHOTOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12723a[GraphQLProfileTileSectionType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static TimelineProtilesImagesExtractor m12677b(InjectorLike injectorLike) {
        return new TimelineProtilesImagesExtractor(ProtilesImageUtil.m12423a(injectorLike));
    }

    @Inject
    public TimelineProtilesImagesExtractor(ProtilesImageUtil protilesImageUtil) {
        this.f12726a = protilesImageUtil;
    }

    public final ImmutableList<Uri> m12678a(ProtilesResult protilesResult) {
        if (protilesResult == null || protilesResult.f10494a == null || protilesResult.f10494a.m12251a() == null) {
            return RegularImmutableList.a;
        }
        Collection arrayList = new ArrayList();
        ImmutableList a = protilesResult.f10494a.m12251a().m12226a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ProtileSectionFieldsModel protileSectionFieldsModel = (ProtileSectionFieldsModel) a.get(i);
            if (protileSectionFieldsModel.m12217j() != null) {
                arrayList.add(Uri.parse(protileSectionFieldsModel.m12217j().m12202a()));
            }
            GraphQLProfileTileSectionType k = protileSectionFieldsModel.m12218k();
            if (k != null) {
                m12676a(arrayList, protileSectionFieldsModel, k);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    public static TimelineProtilesImagesExtractor m12675a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineProtilesImagesExtractor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12725c) {
                TimelineProtilesImagesExtractor timelineProtilesImagesExtractor;
                if (a2 != null) {
                    timelineProtilesImagesExtractor = (TimelineProtilesImagesExtractor) a2.a(f12725c);
                } else {
                    timelineProtilesImagesExtractor = f12724b;
                }
                if (timelineProtilesImagesExtractor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12677b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12725c, b3);
                        } else {
                            f12724b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineProtilesImagesExtractor;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m12676a(List<Uri> list, ProtileSectionFieldsModel protileSectionFieldsModel, GraphQLProfileTileSectionType graphQLProfileTileSectionType) {
        if (protileSectionFieldsModel.m12219l() != null) {
            ImmutableList a = protileSectionFieldsModel.m12219l().m12246a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ProtileViewFieldsModel protileViewFieldsModel = (ProtileViewFieldsModel) a.get(i);
                if (protileViewFieldsModel.m12240j() != null) {
                    ImmutableList a2 = protileViewFieldsModel.m12240j().m12191a();
                    int size2 = a2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) a2.get(i2);
                        DefaultImageFields defaultImageFields = null;
                        switch (C17831.f12723a[graphQLProfileTileSectionType.ordinal()]) {
                            case 1:
                                defaultImageFields = this.f12726a.m12430b(protileItemFieldsModel);
                                break;
                            case 2:
                                defaultImageFields = ProtilesImageUtil.m12422a(protileItemFieldsModel, graphQLProfileTileSectionType);
                                break;
                        }
                        if (defaultImageFields != null) {
                            list.add(Uri.parse(defaultImageFields.b()));
                        }
                    }
                }
            }
        }
    }
}

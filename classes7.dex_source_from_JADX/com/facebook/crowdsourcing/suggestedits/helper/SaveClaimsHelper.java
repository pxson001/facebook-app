package com.facebook.crowdsourcing.suggestedits.helper;

import android.content.Context;
import android.content.Intent;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.graphql.enums.GraphQLPlaceHoursType;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.places.suggestions.common.SuggestPlaceInfoParams;
import com.facebook.places.suggestions.common.SuggestPlaceInfoParams.Builder;
import com.facebook.places.suggestions.common.SuggestProfilePicUploadService;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: client_action_types */
public class SaveClaimsHelper {

    /* compiled from: client_action_types */
    /* synthetic */ class C14821 {
        static final /* synthetic */ int[] f17688a = new int[GraphQLSuggestEditsFieldOptionType.values().length];

        static {
            try {
                f17688a[GraphQLSuggestEditsFieldOptionType.PERMANENTLY_CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17688a[GraphQLSuggestEditsFieldOptionType.ALWAYS_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17688a[GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17688a[GraphQLSuggestEditsFieldOptionType.HAS_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static SuggestPlaceInfoParams m21547a(CrowdsourcingContext crowdsourcingContext, String str, SuggestEditsHeaderHolder suggestEditsHeaderHolder, ImmutableList<SuggestEditsFieldHolder> immutableList) {
        Builder a = SuggestPlaceInfoParams.a(str);
        a.E = crowdsourcingContext.b;
        a.D = crowdsourcingContext.a;
        String c = ExtractValuesHelper.m21534c(suggestEditsHeaderHolder.m21511c());
        if (!Strings.isNullOrEmpty(c)) {
            a.a(c);
        }
        c = ExtractValuesHelper.m21534c(suggestEditsHeaderHolder.f17669e.f17672b);
        if (!Strings.isNullOrEmpty(c)) {
            a.i(c);
        }
        m21549a(a, immutableList);
        return a.a();
    }

    private static void m21549a(Builder builder, ImmutableList<SuggestEditsFieldHolder> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SuggestEditsFieldHolder suggestEditsFieldHolder = (SuggestEditsFieldHolder) immutableList.get(i);
            SuggestEditsField suggestEditsField = suggestEditsFieldHolder.f17660e;
            SuggestEditsField suggestEditsField2 = suggestEditsFieldHolder.f17664i;
            if (suggestEditsField2 != suggestEditsField) {
                String d = suggestEditsField2.mo109d();
                ExtractValuesHelper.m21543k(suggestEditsField);
                GraphQLSuggestEditsFieldOptionType k = ExtractValuesHelper.m21543k(suggestEditsField2);
                NodeModel f;
                String str;
                if (d.equals("337046403064701")) {
                    NodeModel f2 = ExtractValuesHelper.m21538f(suggestEditsField);
                    f = ExtractValuesHelper.m21538f(suggestEditsField2);
                    str = null;
                    if (k == GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE) {
                        str = "<<not-applicable>>";
                    } else if (f != null) {
                        str = f.m2574j();
                    }
                    if (!Strings.isNullOrEmpty(str)) {
                        builder.b(str);
                    }
                    if (f != null) {
                        if (!Strings.isNullOrEmpty(f.m2580p())) {
                            builder.l = (String) Preconditions.checkNotNull(f.m2580p());
                        }
                        if (!(f.m2571c() == null || Strings.isNullOrEmpty(f.m2571c().m2531b()))) {
                            builder.e = (String) Preconditions.checkNotNull(f.m2571c().m2531b());
                        }
                    }
                    if (f2 != null) {
                        if (!Strings.isNullOrEmpty(f2.m2574j())) {
                            builder.j(f2.m2574j());
                        }
                        if (!Strings.isNullOrEmpty(f2.m2580p())) {
                            builder.z = (String) Preconditions.checkNotNull(f2.m2580p());
                        }
                        if (!(f2.m2571c() == null || Strings.isNullOrEmpty(f2.m2571c().m2533d()))) {
                            builder.s = (String) Preconditions.checkNotNull(f2.m2571c().m2531b());
                        }
                    }
                } else if (d.equals("137075966484179")) {
                    str = ExtractValuesHelper.m21532b(suggestEditsField2);
                    if (!Strings.isNullOrEmpty(str)) {
                        builder.f(str);
                    }
                    str = ExtractValuesHelper.m21532b(suggestEditsField);
                    if (!Strings.isNullOrEmpty(str)) {
                        builder.n(str);
                    }
                } else if (d.equals("463427363734722")) {
                    str = ExtractValuesHelper.m21532b(suggestEditsField2);
                    if (!Strings.isNullOrEmpty(str)) {
                        builder.f = (String) Preconditions.checkNotNull(str);
                    }
                    str = ExtractValuesHelper.m21532b(suggestEditsField);
                    if (!Strings.isNullOrEmpty(str)) {
                        builder.t = (String) Preconditions.checkNotNull(str);
                    }
                } else if (d.equals("376081639179091")) {
                    builder.k = (ImmutableList) Preconditions.checkNotNull(ExtractValuesHelper.m21533c(suggestEditsField2));
                    builder.y = (ImmutableList) Preconditions.checkNotNull(ExtractValuesHelper.m21533c(suggestEditsField));
                } else if (d.equals("333522400104087")) {
                    builder.b(m21551c(suggestEditsField2));
                    builder.e(m21551c(suggestEditsField));
                } else if (d.equals("114481832091120")) {
                    f = ExtractValuesHelper.m21538f(suggestEditsField2);
                    if (f != null) {
                        builder.g = (CrowdsourcedHours) Preconditions.checkNotNull(f);
                    }
                    GraphQLPlaceHoursType b = m21550b(suggestEditsField2);
                    if (!b.equals(GraphQLPlaceHoursType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                        builder.h = (GraphQLPlaceHoursType) Preconditions.checkNotNull(b);
                    }
                    NodeModel f3 = ExtractValuesHelper.m21538f(suggestEditsField);
                    if (f3 != null) {
                        builder.u = (CrowdsourcedHours) Preconditions.checkNotNull(f3);
                    }
                    b = m21550b(suggestEditsField);
                    if (!b.equals(GraphQLPlaceHoursType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                        builder.v = (GraphQLPlaceHoursType) Preconditions.checkNotNull(b);
                    }
                }
            }
        }
    }

    private static GraphQLPlaceHoursType m21550b(SuggestEditsField suggestEditsField) {
        switch (C14821.f17688a[suggestEditsField.ew_().ordinal()]) {
            case 1:
                return GraphQLPlaceHoursType.PERMANENTLY_CLOSED;
            case 2:
                return GraphQLPlaceHoursType.ALWAYS_OPEN;
            case 3:
                return GraphQLPlaceHoursType.NO_HOURS;
            case 4:
                return GraphQLPlaceHoursType.OPEN_FOR_SELECTED;
            default:
                return GraphQLPlaceHoursType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }

    private static ImmutableList<Long> m21551c(SuggestEditsField suggestEditsField) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList g = ExtractValuesHelper.m21539g(suggestEditsField);
        int size = g.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) g.get(i);
            if (!(edgesModel.m2588a() == null || edgesModel.m2588a().m2570b() == null || Strings.isNullOrEmpty(edgesModel.m2588a().m2570b().m2547a()))) {
                builder.c(Long.valueOf(Long.parseLong(edgesModel.m2588a().m2570b().m2547a())));
            }
        }
        return builder.b();
    }

    public static void m21548a(CrowdsourcingContext crowdsourcingContext, Context context, SuggestEditsHeaderModel suggestEditsHeaderModel, Long l) {
        PhotoItem photoItem;
        Intent putExtra = new Intent(context, SuggestProfilePicUploadService.class).putExtra("page_id", Long.valueOf(l.longValue()));
        String str = "photo_item";
        String d = ExtractValuesHelper.m21536d(suggestEditsHeaderModel);
        if (d == null) {
            photoItem = null;
        } else {
            if (d.indexOf("file://") == 0) {
                d = d.substring(7);
            }
            photoItem = new PhotoItemBuilder().b(d).d("image/jpeg").a();
        }
        context.startService(putExtra.putExtra(str, photoItem).putExtra("source", null).putExtra("entry_point", crowdsourcingContext.a).putExtra("endpoint", crowdsourcingContext.b));
    }
}

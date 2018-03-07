package com.facebook.redspace.data;

import android.support.annotation.Nullable;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.StoriesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel.RedspaceModel.StoriesModel.ApproximateUnreadCountModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.ApproximateCountModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.Builder;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.NodesModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpacePageInfoModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceWallItemFragmentModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: PrivacyCheckupAppsStepTTI */
public class RedSpaceMutator {
    private static final Function<RedSpaceFeedProfileFragmentModel, String> f11845a = new C14071();

    /* compiled from: PrivacyCheckupAppsStepTTI */
    final class C14071 implements Function<RedSpaceFeedProfileFragmentModel, String> {
        C14071() {
        }

        public final Object apply(@Nullable Object obj) {
            RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = (RedSpaceFeedProfileFragmentModel) obj;
            return redSpaceFeedProfileFragmentModel == null ? null : redSpaceFeedProfileFragmentModel.k();
        }
    }

    /* compiled from: PrivacyCheckupAppsStepTTI */
    final class C14082 implements Function<RedSpaceWallItemFragmentModel, String> {
        C14082() {
        }

        public final Object apply(@Nullable Object obj) {
            RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) obj;
            if (redSpaceWallItemFragmentModel == null) {
                return null;
            }
            return redSpaceWallItemFragmentModel.k();
        }
    }

    public static OverflowFriendsModel m12293a(@Nullable OverflowFriendsModel overflowFriendsModel, @Nullable ApproximateCountModel approximateCountModel) {
        if (overflowFriendsModel == null || approximateCountModel == null) {
            return overflowFriendsModel;
        }
        Builder a = Builder.a(overflowFriendsModel);
        a.a = approximateCountModel;
        return a.a();
    }

    public static OverflowFriendsModel m12294a(@Nullable OverflowFriendsModel overflowFriendsModel, @Nullable List<NodesModel> list) {
        if (overflowFriendsModel == null || list == null) {
            return overflowFriendsModel;
        }
        Builder a = Builder.a(overflowFriendsModel);
        a.b = ImmutableList.copyOf(list);
        return a.a();
    }

    public static OverflowFriendsModel m12300b(@Nullable OverflowFriendsModel overflowFriendsModel, @Nullable List<NodesModel> list) {
        if (overflowFriendsModel == null || list == null) {
            return overflowFriendsModel;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.b(overflowFriendsModel.j());
        builder.b(list);
        Builder a = Builder.a(overflowFriendsModel);
        a.b = builder.b();
        return a.a();
    }

    public static OverflowFriendsModel m12302c(@Nullable OverflowFriendsModel overflowFriendsModel, @Nullable List<NodesModel> list) {
        if (overflowFriendsModel == null || list == null) {
            return overflowFriendsModel;
        }
        Set hashSet = new HashSet();
        for (NodesModel nodesModel : list) {
            NodesModel nodesModel2;
            if (!(nodesModel2 == null || nodesModel2.a() == null)) {
                hashSet.add(nodesModel2.a().b());
            }
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList j = overflowFriendsModel.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            nodesModel2 = (NodesModel) j.get(i);
            if (!(nodesModel2 == null || nodesModel2.a() == null || hashSet.contains(nodesModel2.a().b()))) {
                builder.c(nodesModel2);
            }
        }
        Builder a = Builder.a(overflowFriendsModel);
        a.b = builder.b();
        return a.a();
    }

    public static List<RedSpaceFeedProfileFragmentModel> m12298a(@Nullable List<RedSpaceFeedProfileFragmentModel> list, @Nullable Collection<RedSpaceFeedProfileFragmentModel> collection) {
        if (collection == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList();
        }
        return m12297a(list, collection, f11845a, true);
    }

    public static List<RedSpaceFeedProfileFragmentModel> m12299a(@Nullable List<RedSpaceFeedProfileFragmentModel> list, @Nullable RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        return (list == null || redSpaceFeedProfileFragmentModelArr == null || redSpaceFeedProfileFragmentModelArr.length == 0) ? list : m12297a(list, ImmutableList.copyOf(redSpaceFeedProfileFragmentModelArr), f11845a, false);
    }

    public static List<RedSpaceFeedProfileFragmentModel> m12301b(@Nullable List<RedSpaceFeedProfileFragmentModel> list, @Nullable RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        return (list == null || redSpaceFeedProfileFragmentModelArr == null || redSpaceFeedProfileFragmentModelArr.length == 0) ? list : m12297a(ImmutableList.copyOf(redSpaceFeedProfileFragmentModelArr), list, f11845a, true);
    }

    public static List<RedSpaceFeedProfileFragmentModel> m12303c(@Nullable List<RedSpaceFeedProfileFragmentModel> list, @Nullable RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        return (list == null || redSpaceFeedProfileFragmentModelArr == null || redSpaceFeedProfileFragmentModelArr.length == 0) ? list : m12297a(list, ImmutableList.copyOf(redSpaceFeedProfileFragmentModelArr), f11845a, true);
    }

    public static List<RedSpaceFeedProfileFragmentModel> m12304d(@Nullable List<RedSpaceFeedProfileFragmentModel> list, @Nullable RedSpaceFeedProfileFragmentModel... redSpaceFeedProfileFragmentModelArr) {
        if (list == null || redSpaceFeedProfileFragmentModelArr == null || redSpaceFeedProfileFragmentModelArr.length == 0) {
            return list;
        }
        Set hashSet = new HashSet();
        for (RedSpaceFeedProfileFragmentModel k : redSpaceFeedProfileFragmentModelArr) {
            hashSet.add(k.k());
        }
        List<RedSpaceFeedProfileFragmentModel> arrayList = new ArrayList();
        for (RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel : list) {
            if (!hashSet.contains(redSpaceFeedProfileFragmentModel.k())) {
                arrayList.add(redSpaceFeedProfileFragmentModel);
            }
        }
        return arrayList;
    }

    public static ImmutableList<RedSpaceWallItemFragmentModel> m12296a(ImmutableList<RedSpaceWallItemFragmentModel> immutableList, ImmutableList<RedSpaceWallItemFragmentModel> immutableList2, boolean z) {
        if (immutableList2 != null && immutableList != null) {
            Collection collection = z ? immutableList2 : immutableList;
            if (!z) {
                immutableList = immutableList2;
            }
            return m12297a(collection, immutableList, new C14082(), true);
        } else if (immutableList == null) {
            return immutableList2;
        } else {
            return immutableList;
        }
    }

    public static RedSpaceFeedProfileFragmentModel m12291a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        if (redSpaceFeedProfileFragmentModel.m() == null || redSpaceFeedProfileFragmentModel.m().m() == null) {
            return redSpaceFeedProfileFragmentModel;
        }
        RedspaceModel m = redSpaceFeedProfileFragmentModel.m();
        RedspaceModel.Builder builder = new RedspaceModel.Builder();
        builder.a = m.a();
        builder.b = m.j();
        builder.c = m.k();
        builder.d = m.l();
        builder.e = m.m();
        RedspaceModel.Builder builder2 = builder;
        StoriesModel m2 = redSpaceFeedProfileFragmentModel.m().m();
        StoriesModel.Builder builder3 = new StoriesModel.Builder();
        builder3.a = m2.a();
        builder3.b = m2.j();
        StoriesModel.Builder builder4 = builder3;
        ApproximateUnreadCountModel.Builder builder5 = new ApproximateUnreadCountModel.Builder();
        builder5.a = 0;
        builder5 = builder5;
        builder5.b = false;
        builder5 = builder5;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, builder5.a, 0);
        flatBufferBuilder.a(1, builder5.b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        builder4.a = new ApproximateUnreadCountModel(new MutableFlatBuffer(wrap, null, null, true, null));
        builder4 = builder4;
        builder4.b = RegularImmutableList.a;
        builder2.e = builder4.a();
        RedspaceModel a = builder2.a();
        RedSpaceFeedProfileFragmentModel.Builder builder6 = new RedSpaceFeedProfileFragmentModel.Builder();
        builder6.a = redSpaceFeedProfileFragmentModel.j();
        builder6.b = redSpaceFeedProfileFragmentModel.k();
        builder6.c = redSpaceFeedProfileFragmentModel.l();
        builder6.d = redSpaceFeedProfileFragmentModel.m();
        builder6.e = redSpaceFeedProfileFragmentModel.n();
        RedSpaceFeedProfileFragmentModel.Builder builder7 = builder6;
        builder7.d = a;
        return builder7.a();
    }

    public static DefaultPageInfoFieldsModel m12290a(DefaultPageInfoFieldsModel defaultPageInfoFieldsModel, DefaultPageInfoFieldsModel defaultPageInfoFieldsModel2) {
        if (defaultPageInfoFieldsModel == null) {
            defaultPageInfoFieldsModel = new DefaultPageInfoFieldsModel();
        }
        DefaultPageInfoFieldsModel.Builder builder = new DefaultPageInfoFieldsModel.Builder();
        builder.a = defaultPageInfoFieldsModel.a();
        builder.b = defaultPageInfoFieldsModel.b();
        builder.c = defaultPageInfoFieldsModel.c();
        builder.d = defaultPageInfoFieldsModel.v_();
        DefaultPageInfoFieldsModel.Builder builder2 = builder;
        if (defaultPageInfoFieldsModel2 != null) {
            builder2.a = defaultPageInfoFieldsModel2.a();
            builder2.b = defaultPageInfoFieldsModel2.b();
        }
        return builder2.a();
    }

    public static RedSpacePageInfoModel m12295a(RedSpacePageInfoModel redSpacePageInfoModel, RedSpacePageInfoModel redSpacePageInfoModel2) {
        if (redSpacePageInfoModel2 == null) {
            return redSpacePageInfoModel;
        }
        if (redSpacePageInfoModel == null) {
            redSpacePageInfoModel = new RedSpacePageInfoModel();
        }
        RedSpacePageInfoModel.Builder builder = new RedSpacePageInfoModel.Builder();
        builder.a = redSpacePageInfoModel.a();
        builder.b = redSpacePageInfoModel.j();
        RedSpacePageInfoModel.Builder builder2 = builder;
        if (redSpacePageInfoModel2 != null) {
            builder2.a = redSpacePageInfoModel2.a();
            builder2.b = redSpacePageInfoModel2.j();
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder2.a);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder2.b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new RedSpacePageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static <T> ImmutableList<T> m12297a(Collection<T> collection, Collection<T> collection2, Function<T, String> function, boolean z) {
        HashMap hashMap = new HashMap();
        Collection arrayList = new ArrayList();
        for (Object next : collection) {
            String str = (String) function.apply(next);
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, Integer.valueOf(arrayList.size()));
                arrayList.add(next);
            }
        }
        for (Object next2 : collection2) {
            str = (String) function.apply(next2);
            if (hashMap.containsKey(str)) {
                arrayList.set(((Integer) hashMap.get(str)).intValue(), next2);
            } else if (z) {
                hashMap.put(str, Integer.valueOf(arrayList.size()));
                arrayList.add(next2);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    public static NodesModel m12292a(DefaultImageFieldsModel defaultImageFieldsModel) {
        NodesModel.Builder builder = new NodesModel.Builder();
        builder.a = defaultImageFieldsModel;
        return builder.a();
    }
}

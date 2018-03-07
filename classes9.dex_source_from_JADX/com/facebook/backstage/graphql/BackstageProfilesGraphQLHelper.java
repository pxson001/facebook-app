package com.facebook.backstage.graphql;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import com.facebook.backstage.consumption.ProfilesDataProvider.BackstageProfilesDataController.C04581;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.data.BackstageUser;
import com.facebook.backstage.data.TimezoneDate;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageFriendsModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageFriendsModel.EdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageFriendsModel.EdgesModel.NodeModel.BackstageModel.BackstageEdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageFriendsModel.EdgesModel.NodeModel.BackstageModel.BackstageEdgesModel.BackstageEdgesNodeModel.ReactionsModel.ReactionsEdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageFriendsModel.EdgesModel.NodeModel.BackstageModel.BackstageEdgesModel.BackstageEdgesNodeModel.ReactionsModel.ReactionsEdgesModel.ReactionsEdgesNodeModel.PostMediaModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageModel.EdgesModel.NodeModel.ReactionsModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.BackstageModel.EdgesModel.NodeModel.ReactionsModel.ReactionsEdgesModel.ReactionsEdgesNodeModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.LowresProfileModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostsModel.ProfilePictureModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageSeenByFragmentModel.SeenByUsersModel;
import com.facebook.backstage.util.EmojiReplyUtil;
import com.facebook.common.time.TimeConversions;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: requests_eligible_for_ack_count */
public class BackstageProfilesGraphQLHelper {
    public static final String f5223a = BackstageProfilesGraphQLHelper.class.getSimpleName();
    public final Executor f5224b;
    public final GraphQLQueryExecutor f5225c;
    public String f5226d;
    public BackstageUser f5227e;
    public ProfilePictureModel f5228f;
    public LowresProfileModel f5229g;

    /* compiled from: requests_eligible_for_ack_count */
    public class C05591 implements FutureCallback<GraphQLResult<FBBackstagePostsModel>> {
        final /* synthetic */ C04581 f5218a;
        final /* synthetic */ BackstageProfilesGraphQLHelper f5219b;

        public C05591(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper, C04581 c04581) {
            this.f5219b = backstageProfilesGraphQLHelper;
            this.f5218a = c04581;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                BLog.b(BackstageProfilesGraphQLHelper.f5223a, "result is null.");
                return;
            }
            this.f5219b.f5228f = ((FBBackstagePostsModel) graphQLResult.e).m5376m();
            this.f5219b.f5229g = ((FBBackstagePostsModel) graphQLResult.e).m5374k();
            this.f5219b.f5227e = new BackstageUser(((FBBackstagePostsModel) graphQLResult.e).m5375l(), Uri.parse(((FBBackstagePostsModel) graphQLResult.e).m5376m().m5365a()), Uri.parse(((FBBackstagePostsModel) graphQLResult.e).m5374k().m5360a()));
            String str = BackstageProfilesGraphQLHelper.f5223a;
            Integer.valueOf(((FBBackstagePostsModel) graphQLResult.e).m5373j().m5294a().size());
            Builder builder = ImmutableList.builder();
            Builder builder2 = ImmutableList.builder();
            Map hashMap = new HashMap();
            BackstageProfilesGraphQLHelper.m4971a(this.f5219b, ((FBBackstagePostsModel) graphQLResult.e).m5373j(), hashMap, builder, builder2);
            this.f5218a.m4539a(BackstageProfilesGraphQLHelper.m4966a(this.f5219b, hashMap, ((FBBackstagePostsModel) graphQLResult.e).m5369a(), ((FBBackstagePostsModel) graphQLResult.e).m5375l()), builder, builder2);
            this.f5219b.f5228f = null;
            this.f5219b.f5229g = null;
            this.f5219b.f5227e = null;
            hashMap.clear();
        }

        public void onFailure(Throwable th) {
            BLog.b(BackstageProfilesGraphQLHelper.f5223a, "failed", th);
        }
    }

    /* compiled from: requests_eligible_for_ack_count */
    class C05602 implements Comparator<BackstageProfile> {
        final /* synthetic */ BackstageProfilesGraphQLHelper f5220a;

        C05602(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper) {
            this.f5220a = backstageProfilesGraphQLHelper;
        }

        public int compare(Object obj, Object obj2) {
            return ((BackstageProfile) obj2).f5116e.compareTo(((BackstageProfile) obj).f5116e);
        }
    }

    /* compiled from: requests_eligible_for_ack_count */
    class C05613 implements Comparator<BackstageProfile> {
        final /* synthetic */ BackstageProfilesGraphQLHelper f5221a;

        C05613(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper) {
            this.f5221a = backstageProfilesGraphQLHelper;
        }

        public int compare(Object obj, Object obj2) {
            return ((BackstageProfile) obj).m4899d().compareTo(((BackstageProfile) obj2).m4899d());
        }
    }

    /* compiled from: requests_eligible_for_ack_count */
    class C05624 implements Comparator<BackstageEdgesModel> {
        final /* synthetic */ BackstageProfilesGraphQLHelper f5222a;

        C05624(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper) {
            this.f5222a = backstageProfilesGraphQLHelper;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((BackstageEdgesModel) obj).m5258a().m5253n() - ((BackstageEdgesModel) obj2).m5258a().m5253n());
        }
    }

    @Inject
    public BackstageProfilesGraphQLHelper(Provider<String> provider, Executor executor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f5226d = (String) provider.get();
        this.f5224b = executor;
        this.f5225c = graphQLQueryExecutor;
    }

    public static void m4971a(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper, BackstageFriendsModel backstageFriendsModel, Map map, Builder builder, Builder builder2) {
        if (backstageFriendsModel != null) {
            Iterable arrayList = new ArrayList();
            Iterable arrayList2 = new ArrayList();
            ImmutableList a = backstageFriendsModel.m5294a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                Uri parse = Uri.parse(edgesModel.m5289a().m5286n().m5275a());
                Uri parse2 = Uri.parse(edgesModel.m5289a().m5284l().m5270a());
                String m = edgesModel.m5289a().m5285m();
                map.put(edgesModel.m5289a().m5283k(), new BackstageUser(m, parse, parse2));
                ImmutableList b = m4975b(edgesModel.m5289a().m5282j().m5264a());
                Pair d = backstageProfilesGraphQLHelper.m4977d(b);
                if (b.isEmpty()) {
                    arrayList2.add(new BackstageProfile(edgesModel.m5289a().m5283k(), parse, parse2, m, ((Integer) d.a).intValue(), false, false, null, ImmutableList.of()));
                } else {
                    arrayList.add(new BackstageProfile(edgesModel.m5289a().m5283k(), parse, parse2, m, ((Integer) d.a).intValue(), ((Boolean) d.b).booleanValue(), false, m4978e(b), backstageProfilesGraphQLHelper.m4969a(b)));
                }
            }
            Collections.sort(arrayList, new C05602(backstageProfilesGraphQLHelper));
            Collections.sort(arrayList2, new C05613(backstageProfilesGraphQLHelper));
            builder.b(arrayList);
            builder2.b(arrayList2);
        }
    }

    public static BackstageProfile m4966a(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper, Map map, BackstageModel backstageModel, String str) {
        ImmutableList a = backstageProfilesGraphQLHelper.m4968a(backstageModel, map);
        return new BackstageProfile(backstageProfilesGraphQLHelper.f5226d, Uri.parse(backstageProfilesGraphQLHelper.f5228f.m5365a()), Uri.parse(backstageProfilesGraphQLHelper.f5229g.m5360a()), str, 0, !a.isEmpty(), true, m4970a(backstageModel), a);
    }

    private ImmutableList<BackstageStory> m4969a(ImmutableList<BackstageEdgesModel> immutableList) {
        Iterable arrayList = new ArrayList();
        List<BackstageEdgesModel> arrayList2 = new ArrayList(immutableList);
        Collections.sort(arrayList2, new C05624(this));
        for (BackstageEdgesModel backstageEdgesModel : arrayList2) {
            String str;
            boolean z;
            if (backstageEdgesModel.m5258a().m5250k().m5192l() == null) {
                str = "";
            } else {
                str = backstageEdgesModel.m5258a().m5250k().m5192l().m5166a();
            }
            Builder builder = ImmutableList.builder();
            ImmutableList a = backstageEdgesModel.m5258a().m5251l().m5243a();
            int size = a.size();
            int i = 0;
            while (i < size) {
                PostMediaModel a2 = ((ReactionsEdgesModel) a.get(i)).m5238a().m5234a();
                if (this.f5226d.equals(a2.m5231j().m5225j())) {
                    boolean z2;
                    SeenByUser seenByUser = new SeenByUser(this.f5227e);
                    if (a2.m5229a() == null || !EmojiReplyUtil.m5771a(a2.m5229a().m5216a())) {
                        z2 = true;
                    } else {
                        seenByUser.f5111a = a2.m5229a().m5216a();
                        z2 = false;
                    }
                    builder.c(seenByUser);
                    z = z2;
                    arrayList.add(new BackstageStory(backstageEdgesModel.m5258a().m5249j(), backstageEdgesModel.m5258a().m5250k().m5191k().m5154j(), str, backstageEdgesModel.m5258a().m5250k().m5195o(), m4967a(backstageEdgesModel.m5258a().m5253n(), backstageEdgesModel.m5258a().m5254o()), z, builder.b()));
                } else {
                    i++;
                }
            }
            z = false;
            arrayList.add(new BackstageStory(backstageEdgesModel.m5258a().m5249j(), backstageEdgesModel.m5258a().m5250k().m5191k().m5154j(), str, backstageEdgesModel.m5258a().m5250k().m5195o(), m4967a(backstageEdgesModel.m5258a().m5253n(), backstageEdgesModel.m5258a().m5254o()), z, builder.b()));
        }
        Builder builder2 = ImmutableList.builder();
        builder2.b(arrayList);
        return builder2.b();
    }

    private static boolean m4972a(long j, int i, int i2, int i3, String str, long j2, int i4, int i5, int i6, String str2) {
        if (Strings.isNullOrEmpty(str)) {
            str = "";
        }
        if (Strings.isNullOrEmpty(str2)) {
            str2 = "";
        }
        return j == j2 && i == i4 && i2 == i5 && i3 == i6 && str.contentEquals(str2);
    }

    private static boolean m4974a(BackstageModel.EdgesModel edgesModel, BackstageModel.EdgesModel edgesModel2) {
        if (edgesModel == null || edgesModel2 == null || edgesModel.m5349a().m5342k().m5195o() == null || edgesModel2.m5349a().m5342k().m5195o() == null) {
            return false;
        }
        return m4972a(edgesModel.m5349a().m5345n(), edgesModel.m5349a().m5342k().m5191k().m5155k(), edgesModel.m5349a().m5342k().m5191k().m5150a(), edgesModel.m5349a().m5342k().m5194n(), edgesModel.m5349a().m5342k().m5192l() == null ? "" : edgesModel.m5349a().m5342k().m5192l().m5166a(), edgesModel2.m5349a().m5345n(), edgesModel2.m5349a().m5342k().m5191k().m5155k(), edgesModel2.m5349a().m5342k().m5191k().m5150a(), edgesModel2.m5349a().m5342k().m5194n(), edgesModel2.m5349a().m5342k().m5192l() == null ? "" : edgesModel.m5349a().m5342k().m5192l().m5166a());
    }

    private static ImmutableList<BackstageEdgesModel> m4975b(ImmutableList<BackstageEdgesModel> immutableList) {
        Builder builder = new Builder();
        BackstageEdgesModel backstageEdgesModel = null;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            BackstageEdgesModel backstageEdgesModel2 = (BackstageEdgesModel) immutableList.get(i);
            if (m4973a(backstageEdgesModel, backstageEdgesModel2)) {
                backstageEdgesModel.m5258a().m5250k().m5195o();
                backstageEdgesModel2.m5258a().m5250k().m5195o();
                backstageEdgesModel2 = backstageEdgesModel;
            } else {
                builder.c(backstageEdgesModel2);
            }
            i++;
            backstageEdgesModel = backstageEdgesModel2;
        }
        return builder.b();
    }

    private static ImmutableList<BackstageModel.EdgesModel> m4976c(ImmutableList<BackstageModel.EdgesModel> immutableList) {
        Builder builder = new Builder();
        BackstageModel.EdgesModel edgesModel = null;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            BackstageModel.EdgesModel edgesModel2 = (BackstageModel.EdgesModel) immutableList.get(i);
            if (m4974a(edgesModel, edgesModel2)) {
                edgesModel.m5349a().m5342k().m5195o();
                edgesModel2.m5349a().m5342k().m5195o();
                edgesModel2 = edgesModel;
            } else {
                builder.c(edgesModel2);
            }
            i++;
            edgesModel = edgesModel2;
        }
        return builder.b();
    }

    private static boolean m4973a(BackstageEdgesModel backstageEdgesModel, BackstageEdgesModel backstageEdgesModel2) {
        if (backstageEdgesModel == null || backstageEdgesModel2 == null || backstageEdgesModel.m5258a().m5250k().m5195o() == null || backstageEdgesModel2.m5258a().m5250k().m5195o() == null) {
            return false;
        }
        return m4972a(backstageEdgesModel.m5258a().m5253n(), backstageEdgesModel.m5258a().m5250k().m5191k().m5155k(), backstageEdgesModel.m5258a().m5250k().m5191k().m5150a(), backstageEdgesModel.m5258a().m5250k().m5194n(), backstageEdgesModel.m5258a().m5250k().m5192l() == null ? "" : backstageEdgesModel.m5258a().m5250k().m5192l().m5166a(), backstageEdgesModel2.m5258a().m5253n(), backstageEdgesModel2.m5258a().m5250k().m5191k().m5155k(), backstageEdgesModel2.m5258a().m5250k().m5191k().m5150a(), backstageEdgesModel2.m5258a().m5250k().m5194n(), backstageEdgesModel2.m5258a().m5250k().m5192l() == null ? "" : backstageEdgesModel.m5258a().m5250k().m5192l().m5166a());
    }

    private ImmutableList<BackstageStory> m4968a(BackstageModel backstageModel, Map<String, BackstageUser> map) {
        Builder builder = ImmutableList.builder();
        ImmutableList c = m4976c(backstageModel.m5354a());
        int size = c.size();
        for (int i = 0; i < size; i++) {
            String str;
            BackstageModel.EdgesModel edgesModel = (BackstageModel.EdgesModel) c.get(i);
            if (edgesModel.m5349a().m5342k().m5192l() == null) {
                str = "";
            } else {
                str = edgesModel.m5349a().m5342k().m5192l().m5166a();
            }
            Map hashMap = new HashMap();
            ImmutableList a = edgesModel.m5349a().m5344m().m5402a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                SeenByUsersModel.EdgesModel edgesModel2 = (SeenByUsersModel.EdgesModel) a.get(i2);
                if (!this.f5226d.equals(edgesModel2.m5397a().m5392j())) {
                    Uri uri = null;
                    hashMap.put(edgesModel2.m5397a().m5392j(), new SeenByUser(edgesModel2.m5397a().m5393k(), uri, Uri.parse(edgesModel2.m5397a().m5394l().m5385a())));
                }
            }
            boolean z = false;
            ImmutableList a2 = edgesModel.m5349a().m5343l().m5335a();
            int size3 = a2.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ReactionsModel.ReactionsEdgesModel reactionsEdgesModel = (ReactionsModel.ReactionsEdgesModel) a2.get(i3);
                ReactionsEdgesNodeModel.PostMediaModel a3 = reactionsEdgesModel.m5330a().m5326a();
                if (a3.m5320a() != null && EmojiReplyUtil.m5771a(a3.m5320a().m5306a())) {
                    SeenByUser seenByUser = (SeenByUser) hashMap.get(a3.m5322b().m5315b());
                    if (seenByUser == null) {
                        SeenByUser seenByUser2 = new SeenByUser((BackstageUser) map.get(a3.m5322b().m5315b()));
                        hashMap.put(a3.m5322b().m5315b(), seenByUser2);
                        seenByUser = seenByUser2;
                    }
                    seenByUser.m4895a(a3.m5320a().m5306a());
                } else if (this.f5226d.equals(reactionsEdgesModel.m5330a().m5326a().m5323j().m5315b())) {
                    z = true;
                }
            }
            Builder builder2 = ImmutableList.builder();
            builder2.b(hashMap.values());
            builder.c(new BackstageStory(edgesModel.m5349a().m5341j(), edgesModel.m5349a().m5342k().m5191k().m5154j(), str, edgesModel.m5349a().m5342k().m5195o(), m4967a(edgesModel.m5349a().m5345n(), edgesModel.m5349a().m5346o()), z, builder2.b()));
        }
        return builder.b();
    }

    private static TimezoneDate m4967a(long j, int i) {
        return new TimezoneDate(TimeConversions.o(j), TimeConversions.o((long) i));
    }

    private Pair<Integer, Boolean> m4977d(ImmutableList<BackstageEdgesModel> immutableList) {
        if (immutableList.size() == 0) {
            return new Pair(Integer.valueOf(0), Boolean.valueOf(false));
        }
        int size = immutableList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj;
            ImmutableList a = ((BackstageEdgesModel) immutableList.get(i2)).m5258a().m5252m().m5402a();
            int size2 = a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (this.f5226d.equals(((SeenByUsersModel.EdgesModel) a.get(i3)).m5397a().m5392j())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                break;
            }
            i++;
        }
        if (i < immutableList.size()) {
            return new Pair(Integer.valueOf(i), Boolean.valueOf(true));
        }
        return new Pair(Integer.valueOf(0), Boolean.valueOf(false));
    }

    private static Date m4978e(ImmutableList<BackstageEdgesModel> immutableList) {
        boolean z;
        int size = immutableList.size();
        int i = 0;
        long j = 0;
        while (i < size) {
            long n = ((BackstageEdgesModel) immutableList.get(i)).m5258a().m5253n();
            if (n <= j) {
                n = j;
            }
            i++;
            j = n;
        }
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new Date(TimeConversions.o(j));
    }

    private static Date m4970a(BackstageModel backstageModel) {
        ImmutableList a = backstageModel.m5354a();
        int size = a.size();
        int i = 0;
        long j = 0;
        while (i < size) {
            long n = ((BackstageModel.EdgesModel) a.get(i)).m5349a().m5345n();
            if (n <= j) {
                n = j;
            }
            i++;
            j = n;
        }
        return j == 0 ? null : new Date(TimeConversions.o(j));
    }
}

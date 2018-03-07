package com.facebook.messaging.graphql.fetch;

import com.facebook.common.time.SystemClock;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToActionBuilder;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoInterfaces.NameFields;
import com.facebook.messaging.graphql.threads.UserInfoModels.CustomerDataFragModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.CustomerDataFragModel.CustomTagLinksModel.NodesModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.CustomerDataFragModel.CustomTagLinksModel.NodesModel.CustomTagModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.MessagingActorIdModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.MessagingActorInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.NameFieldsModel.PartsModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.ParticipantInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.ProfilePhotoInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel.MessengerCtasModel;
import com.facebook.messaging.graphql.threads.UserInfoModels.UserInfoModel.PhoneNumberModel;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.sms.sharedutils.SmsUserUtil;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageSetting;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserCustomTag;
import com.facebook.user.model.UserEmailAddress;
import com.facebook.user.model.UserKey;
import com.facebook.user.model.UserPhoneNumber;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: eligible_for_audience_alignment_education */
public class GQLUserConverter {
    private static volatile GQLUserConverter f13264b;
    private SmsUserUtil f13265a;

    public static com.facebook.messaging.graphql.fetch.GQLUserConverter m14119a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13264b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.graphql.fetch.GQLUserConverter.class;
        monitor-enter(r1);
        r0 = f13264b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14130b(r0);	 Catch:{ all -> 0x0035 }
        f13264b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13264b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.graphql.fetch.GQLUserConverter.a(com.facebook.inject.InjectorLike):com.facebook.messaging.graphql.fetch.GQLUserConverter");
    }

    private static GQLUserConverter m14130b(InjectorLike injectorLike) {
        return new GQLUserConverter(SmsUserUtil.m14137a(injectorLike));
    }

    @Inject
    public GQLUserConverter(SmsUserUtil smsUserUtil) {
        this.f13265a = smsUserUtil;
    }

    public final ImmutableList<User> m14133a(List<ThreadInfoModel> list) {
        HashMap hashMap = new HashMap();
        for (ThreadInfoModel threadInfoModel : list) {
            ImmutableList b;
            int size;
            int i;
            if (threadInfoModel.l() != null) {
                b = m14131b(threadInfoModel.l().a());
                size = b.size();
                for (i = 0; i < size; i++) {
                    User user = (User) b.get(i);
                    hashMap.put(user.a, user);
                }
            }
            if (threadInfoModel.u() != null) {
                b = m14131b(threadInfoModel.u().a());
                size = b.size();
                for (i = 0; i < size; i++) {
                    user = (User) b.get(i);
                    hashMap.put(user.a, user);
                }
            }
            if (threadInfoModel.j() != null) {
                ImmutableList b2 = GQLBotConverter.b(threadInfoModel.j().a());
                int size2 = b2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    User user2 = (User) b2.get(i2);
                    hashMap.put(user2.a, user2);
                }
            }
        }
        return ImmutableList.copyOf(hashMap.values());
    }

    public final ImmutableMap<String, User> m14134a(Collection<UserInfoModel> collection) {
        Builder builder = ImmutableMap.builder();
        for (UserInfoModel userInfoModel : collection) {
            if (!(userInfoModel == null || userInfoModel.s() == null)) {
                builder.b(userInfoModel.s(), m14132a(userInfoModel));
            }
        }
        return builder.b();
    }

    public final List<ThreadParticipant> m14135a(List<MessagingActorInfoModel> list, Map<String, Long> map, Map<String, Long> map2, HashSet<String> hashSet) {
        List<ThreadParticipant> arrayList = new ArrayList();
        for (MessagingActorInfoModel a : list) {
            UserInfoModel a2 = a.a();
            if (a2 != null) {
                ParticipantInfo participantInfo;
                String s = a2.s();
                PhoneNumberModel E = a2.E();
                if (E != null) {
                    String a3 = E.a();
                    User a4 = this.f13265a.m14145a(a3);
                    participantInfo = new ParticipantInfo(a4.T, a4.j(), a4.u(), a3, false);
                } else {
                    UserKey userKey = new UserKey(Type.FACEBOOK, s);
                    String str = null;
                    if (!a2.q().isEmpty()) {
                        str = (String) a2.q().get(0);
                    }
                    participantInfo = new ParticipantInfo(userKey, a2.C(), str, null, a2.u());
                }
                ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
                threadParticipantBuilder.a = participantInfo;
                Long l = (Long) map.get(s);
                if (l != null) {
                    threadParticipantBuilder.d = l.longValue();
                }
                l = (Long) map2.get(s);
                if (l != null) {
                    threadParticipantBuilder.b = l.longValue();
                }
                threadParticipantBuilder.e = hashSet.contains(s);
                arrayList.add(threadParticipantBuilder.f());
            }
        }
        return arrayList;
    }

    public static ParticipantInfo m14120a(ParticipantInfoModel participantInfoModel) {
        String b = participantInfoModel.a().b();
        return new ParticipantInfo(new UserKey(Type.FACEBOOK, b), participantInfoModel.a().c());
    }

    public final List<ThreadParticipant> m14136a(List<MessagingActorIdModel> list, Map<String, User> map, Map<String, Long> map2, Map<String, Long> map3, HashSet<String> hashSet) {
        List<ThreadParticipant> arrayList = new ArrayList();
        for (MessagingActorIdModel messagingActorIdModel : list) {
            if (messagingActorIdModel.a() != null) {
                Object a;
                String j = messagingActorIdModel.a().j();
                Preconditions.checkNotNull(j, "No user id");
                User user = (User) map.get(j);
                String a2 = m14129a(user);
                if (a2 == null) {
                    a = m14123a(j, user, (Map) map2, (Map) map3, hashSet.contains(j));
                } else {
                    a = m14122a(j, user, map2, map3, a2, hashSet.contains(j));
                }
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Nullable
    private static String m14129a(User user) {
        if (user != null) {
            UserPhoneNumber w = user.w();
            if (w != null) {
                return w.b;
            }
        }
        return null;
    }

    private ImmutableList<User> m14131b(List<MessagingActorInfoModel> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (MessagingActorInfoModel a : list) {
            UserInfoModel a2 = a.a();
            if (a2 != null) {
                builder.c(m14132a(a2));
            }
        }
        return builder.b();
    }

    public final User m14132a(UserInfoModel userInfoModel) {
        int i = 0;
        UserBuilder userBuilder = new UserBuilder();
        PhoneNumberModel E = userInfoModel.E();
        if (E != null) {
            return this.f13265a.m14145a(E.a());
        }
        long parseLong;
        boolean z;
        userBuilder.a(Type.FACEBOOK, userInfoModel.s());
        switch (userInfoModel.j().g()) {
            case -1058326424:
            case 2645995:
                userBuilder.z = "user";
                break;
            case 2479791:
                userBuilder.z = "page";
                break;
            case 67338874:
                userBuilder.z = "event";
                break;
            case 69076575:
                userBuilder.z = "group";
                break;
            default:
                BLog.b("GQLUserConverter", "Got a user of an unsupported graphql type: %d", new Object[]{Integer.valueOf(userInfoModel.j().g())});
                userBuilder.z = "user";
                break;
        }
        if (userInfoModel.I() != null) {
            userBuilder.g = m14125a(userInfoModel.I());
            if (userInfoModel.I().j() != null) {
                userBuilder.k = m14125a(userInfoModel.I().j());
            }
        } else {
            userBuilder.h = userInfoModel.C();
        }
        userBuilder.l = userInfoModel.J();
        if (!userInfoModel.q().isEmpty()) {
            userBuilder.c = ImmutableList.of(new UserEmailAddress((String) userInfoModel.q().get(0), 1));
        }
        if (userInfoModel.p() != null) {
            userBuilder.e = m14128a(userInfoModel.p());
        }
        userBuilder.p = m14126a(userInfoModel.H(), userInfoModel.G(), userInfoModel.F());
        userBuilder.t = (float) userInfoModel.o();
        userBuilder.A = userInfoModel.y();
        userBuilder.L = userInfoModel.z();
        userBuilder.B = userInfoModel.u();
        userBuilder.O = userInfoModel.t();
        userBuilder.P = userInfoModel.v();
        userBuilder.Q = userInfoModel.x();
        userBuilder.W = userInfoModel.l();
        userBuilder.G = GraphQLFriendshipStatus.ARE_FRIENDS.equals(userInfoModel.r());
        if (userInfoModel.B() != null) {
            parseLong = Long.parseLong(userInfoModel.B());
        } else {
            parseLong = 0;
        }
        userBuilder.Y = parseLong;
        userBuilder.Z = userInfoModel.k();
        if (userInfoModel.D() != null) {
            z = true;
        } else {
            z = false;
        }
        userBuilder.H = z;
        userBuilder.U = false;
        userBuilder.V = userInfoModel.w();
        if (userInfoModel.n() != null) {
            switch (1.a[userInfoModel.n().ordinal()]) {
                case 1:
                    userBuilder.C = CommercePageType.COMMERCE_PAGE_TYPE_AGENT;
                    break;
                case 2:
                    userBuilder.C = CommercePageType.COMMERCE_PAGE_TYPE_BANK;
                    break;
                case 3:
                    userBuilder.C = CommercePageType.COMMERCE_PAGE_TYPE_BUSINESS;
                    break;
                case 4:
                    userBuilder.C = CommercePageType.COMMERCE_PAGE_TYPE_RIDE_SHARE;
                    break;
                default:
                    userBuilder.C = CommercePageType.COMMERCE_PAGE_TYPE_UNKNOWN;
                    break;
            }
        }
        if (!userInfoModel.m().isEmpty()) {
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList m = userInfoModel.m();
            int size = m.size();
            for (int i2 = 0; i2 < size; i2++) {
                switch (1.b[((GraphQLCommercePageSetting) m.get(i2)).ordinal()]) {
                    case 1:
                        builder.c(CommercePageSetting.COMMERCE_FAQ_ENABLED);
                        break;
                    case 2:
                        builder.c(CommercePageSetting.IN_MESSENGER_SHOPPING_ENABLED);
                        break;
                    case 3:
                        builder.c(CommercePageSetting.COMMERCE_NUX_ENABLED);
                        break;
                    default:
                        break;
                }
            }
            userBuilder.D = builder.b();
        }
        if (!userInfoModel.A().isEmpty()) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            ImmutableList A = userInfoModel.A();
            int size2 = A.size();
            while (i < size2) {
                CallToAction.Type type;
                MessengerCtasModel messengerCtasModel = (MessengerCtasModel) A.get(i);
                CallToActionBuilder callToActionBuilder = new CallToActionBuilder();
                callToActionBuilder.a = messengerCtasModel.m();
                callToActionBuilder = callToActionBuilder;
                callToActionBuilder.b = messengerCtasModel.k();
                callToActionBuilder = callToActionBuilder.c(messengerCtasModel.l());
                if (messengerCtasModel.j() == null) {
                    type = null;
                } else {
                    type = CallToAction.a(messengerCtasModel.j().name());
                }
                callToActionBuilder.d = type;
                builder2.c(callToActionBuilder.g());
                i++;
            }
            userBuilder.T = builder2.b();
        }
        userBuilder.X = SystemClock.a.a();
        return userBuilder.aa();
    }

    private static ImmutableList<UserCustomTag> m14128a(CustomerDataFragModel customerDataFragModel) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (!(customerDataFragModel.a() == null || customerDataFragModel.a().a() == null)) {
            ImmutableList a = customerDataFragModel.a().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (nodesModel.a() != null) {
                    CustomTagModel a2 = nodesModel.a();
                    builder.c(new UserCustomTag(a2.m(), a2.n(), (int) Long.parseLong(a2.k(), 16), (int) Long.parseLong(a2.l(), 16), (int) Long.parseLong(a2.j(), 16)));
                }
            }
        }
        return builder.b();
    }

    private ThreadParticipant m14123a(String str, @Nullable User user, Map<String, Long> map, Map<String, Long> map2, boolean z) {
        if (user == null) {
            return m14121a(str);
        }
        return m14124a(str, new UserKey(Type.FACEBOOK, str), user.j(), map, map2, user.u(), null, user.u, z);
    }

    private ThreadParticipant m14122a(String str, @Nullable User user, Map<String, Long> map, Map<String, Long> map2, String str2, boolean z) {
        Preconditions.checkNotNull(str2);
        if (user == null) {
            return m14121a(str);
        }
        return m14124a(str, new UserKey(Type.PHONE_NUMBER, str), user.j(), map, map2, user.u(), str2, user.P(), z);
    }

    private static ThreadParticipant m14121a(String str) {
        BLog.c("GQLUserConverter", "User with id %s not found in users list", new Object[]{str});
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a = new ParticipantInfo(UserKey.b(str), str, null);
        return threadParticipantBuilder.f();
    }

    private static ThreadParticipant m14124a(String str, UserKey userKey, String str2, Map<String, Long> map, Map<String, Long> map2, @Nullable String str3, @Nullable String str4, boolean z, boolean z2) {
        ParticipantInfo participantInfo = new ParticipantInfo(userKey, str2, str3, str4, z);
        ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
        threadParticipantBuilder.a = participantInfo;
        Long l = (Long) map.get(str);
        if (l != null) {
            threadParticipantBuilder.d = l.longValue();
        }
        l = (Long) map2.get(str);
        if (l != null) {
            threadParticipantBuilder.a(l.longValue());
        }
        threadParticipantBuilder.e = z2;
        return threadParticipantBuilder.f();
    }

    private static Name m14125a(NameFields nameFields) {
        String str;
        String str2 = null;
        String b = nameFields.b();
        if (b != null) {
            ImmutableList a = nameFields.a();
            int size = a.size();
            int i = 0;
            str = null;
            while (i < size) {
                String str3;
                PartsModel partsModel = (PartsModel) a.get(i);
                int b2 = partsModel.b();
                int b3 = partsModel.b() + partsModel.a();
                if (partsModel.c() == GraphQLStructuredNamePart.FIRST) {
                    String str4 = str2;
                    str2 = b.substring(b2, b3);
                    str3 = str4;
                } else if (partsModel.c() == GraphQLStructuredNamePart.LAST) {
                    str3 = b.substring(b2, b3);
                    str2 = str;
                } else {
                    str3 = str2;
                    str2 = str;
                }
                i++;
                str = str2;
                str2 = str3;
            }
        } else {
            str = null;
        }
        return new Name(str, str2, b);
    }

    @Nullable
    public static PicSquare m14126a(@Nullable ProfilePhotoInfoModel profilePhotoInfoModel, @Nullable ProfilePhotoInfoModel profilePhotoInfoModel2, @Nullable ProfilePhotoInfoModel profilePhotoInfoModel3) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (profilePhotoInfoModel != null) {
            builder.c(m14127a(profilePhotoInfoModel));
        }
        if (profilePhotoInfoModel2 != null) {
            builder.c(m14127a(profilePhotoInfoModel2));
        }
        if (profilePhotoInfoModel3 != null) {
            builder.c(m14127a(profilePhotoInfoModel3));
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            return null;
        }
        return new PicSquare(b);
    }

    public static PicSquareUrlWithSize m14127a(ProfilePhotoInfoModel profilePhotoInfoModel) {
        return new PicSquareUrlWithSize(profilePhotoInfoModel.a(), profilePhotoInfoModel.j());
    }
}

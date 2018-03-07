package com.facebook.messaging.graphql.fetch;

import com.facebook.common.time.SystemClock;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.graphql.threads.BotInfoModels.BotMessagingActorInfoModel;
import com.facebook.messaging.graphql.threads.BotInfoModels.BotMessagingActorInfoModel.MessagingActorModel;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: tosVersion */
public class GQLBotConverter {
    public static List<ThreadParticipant> m1691a(List<BotMessagingActorInfoModel> list) {
        List<ThreadParticipant> arrayList = new ArrayList();
        for (BotMessagingActorInfoModel botMessagingActorInfoModel : list) {
            if (botMessagingActorInfoModel.a() != null) {
                ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.FACEBOOK, botMessagingActorInfoModel.a().k()), botMessagingActorInfoModel.a().l(), null, null, false);
                ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
                threadParticipantBuilder.a = participantInfo;
                arrayList.add(threadParticipantBuilder.f());
            }
        }
        return arrayList;
    }

    public static ImmutableList<User> m1692b(List<BotMessagingActorInfoModel> list) {
        Builder builder = ImmutableList.builder();
        for (BotMessagingActorInfoModel a : list) {
            MessagingActorModel a2 = a.a();
            if (a2 != null) {
                PicSquare picSquare;
                UserBuilder userBuilder = new UserBuilder();
                userBuilder.a(Type.FACEBOOK, a2.k());
                switch (a2.j().g()) {
                    case 2479791:
                        userBuilder.z = "page";
                        break;
                    case 2645995:
                        userBuilder.z = "user";
                        break;
                    case 67338874:
                        userBuilder.z = "event";
                        break;
                    case 69076575:
                        userBuilder.z = "group";
                        break;
                    default:
                        BLog.b("GQLBotConverter", "Got a user of an unsupported graphql type: %d", new Object[]{Integer.valueOf(a2.j().g())});
                        userBuilder.z = "user";
                        break;
                }
                userBuilder.h = a2.l();
                Builder builder2 = ImmutableList.builder();
                if (a2.o() != null) {
                    builder2.c(GQLUserConverter.a(a2.o()));
                }
                if (a2.n() != null) {
                    builder2.c(GQLUserConverter.a(a2.n()));
                }
                if (a2.m() != null) {
                    builder2.c(GQLUserConverter.a(a2.m()));
                }
                ImmutableList b = builder2.b();
                if (b.isEmpty()) {
                    picSquare = null;
                } else {
                    picSquare = new PicSquare(b);
                }
                userBuilder.p = picSquare;
                userBuilder.H = true;
                userBuilder.X = SystemClock.a.a();
                builder.c(userBuilder.aa());
            }
        }
        return builder.b();
    }
}

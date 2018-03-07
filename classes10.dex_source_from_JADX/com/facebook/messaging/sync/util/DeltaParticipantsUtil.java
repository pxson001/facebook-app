package com.facebook.messaging.sync.util;

import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import java.util.ArrayList;
import java.util.List;

/* compiled from: possible_visibility_settings */
public class DeltaParticipantsUtil {
    public static List<ThreadParticipant> m4234a(List<ParticipantInfo> list) {
        List<ThreadParticipant> arrayList = new ArrayList();
        for (ParticipantInfo participantInfo : list) {
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = participantInfo;
            arrayList.add(threadParticipantBuilder.f());
        }
        return arrayList;
    }

    public static List<ParticipantInfo> m4235b(List<com.facebook.messaging.sync.model.thrift.ParticipantInfo> list) {
        List<ParticipantInfo> arrayList = new ArrayList();
        for (com.facebook.messaging.sync.model.thrift.ParticipantInfo participantInfo : list) {
            arrayList.add(new ParticipantInfo(new UserKey(Type.FACEBOOK, Long.toString(participantInfo.userFbId.longValue())), participantInfo.fullName));
        }
        return arrayList;
    }

    public static List<User> m4236c(List<com.facebook.messaging.sync.model.thrift.ParticipantInfo> list) {
        List<User> arrayList = new ArrayList();
        for (com.facebook.messaging.sync.model.thrift.ParticipantInfo participantInfo : list) {
            UserBuilder a = new UserBuilder().a(Type.FACEBOOK, Long.toString(participantInfo.userFbId.longValue()));
            a.i = participantInfo.firstName;
            a = a;
            a.h = participantInfo.fullName;
            a = a;
            a.A = participantInfo.isMessengerUser.booleanValue();
            UserBuilder userBuilder = a;
            userBuilder.H = false;
            arrayList.add(userBuilder.aa());
        }
        return arrayList;
    }
}

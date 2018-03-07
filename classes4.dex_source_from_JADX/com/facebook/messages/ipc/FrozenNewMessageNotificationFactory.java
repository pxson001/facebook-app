package com.facebook.messages.ipc;

import android.app.PendingIntent;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.GroupMessageInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: share_wall_create */
public class FrozenNewMessageNotificationFactory {
    public final FrozenNewMessageNotification m2486a(Message message, String str, String str2, GroupMessageInfo groupMessageInfo, PendingIntent pendingIntent, String str3) {
        ParticipantInfo participantInfo = message.e;
        String b = (participantInfo == null || !participantInfo.b.d()) ? null : participantInfo.b.b();
        return new FrozenNewMessageNotification(message.a, str3, b, participantInfo != null ? participantInfo.c : null, str, str2, pendingIntent, message.p, message.q.name(), message.c, message.d, m2485a(groupMessageInfo));
    }

    @Nullable
    private static FrozenGroupMessageInfo m2485a(@Nullable GroupMessageInfo groupMessageInfo) {
        if (groupMessageInfo == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = groupMessageInfo.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ParticipantInfo participantInfo = (ParticipantInfo) immutableList.get(i);
            builder.c(new FrozenParticipant(participantInfo.b.b(), participantInfo.c));
        }
        return new FrozenGroupMessageInfo(groupMessageInfo.a, builder.b(), groupMessageInfo.c, groupMessageInfo.d);
    }
}

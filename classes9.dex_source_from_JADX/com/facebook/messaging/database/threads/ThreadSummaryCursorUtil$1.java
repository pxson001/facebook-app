package com.facebook.messaging.database.threads;

import com.facebook.messaging.database.threads.DbThreadParticipantsUtil.ParticipantType;

/* compiled from: max_mfps */
/* synthetic */ class ThreadSummaryCursorUtil$1 {
    static final /* synthetic */ int[] f10592a = new int[ParticipantType.values().length];

    static {
        try {
            f10592a[ParticipantType.PARTICIPANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f10592a[ParticipantType.FORMER_PARTICIPANT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f10592a[ParticipantType.BOT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f10592a[ParticipantType.REQUEST.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}

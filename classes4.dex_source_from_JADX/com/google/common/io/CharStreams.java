package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.nio.CharBuffer;

@Beta
/* compiled from: messengerInvitePriority */
public final class CharStreams {
    private CharStreams() {
    }

    public static String m8358a(Readable readable) {
        Appendable stringBuilder = new StringBuilder();
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(stringBuilder);
        CharBuffer allocate = CharBuffer.allocate(2048);
        long j = 0;
        while (readable.read(allocate) != -1) {
            allocate.flip();
            stringBuilder.append(allocate);
            j += (long) allocate.remaining();
            allocate.clear();
        }
        return stringBuilder.toString();
    }
}

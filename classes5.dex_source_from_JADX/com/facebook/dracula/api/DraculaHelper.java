package com.facebook.dracula.api;

import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groups.feed.ui.GroupsFeedFragment.1.1;

/* compiled from: scheduleVsyncLocked */
public class DraculaHelper {
    public static ThreadLocal<DiagnosticsSender> f2922a = new ThreadLocal();

    public static 1 m4061a() {
        return (1) f2922a.get();
    }

    public static void m4062a(1 1) {
        f2922a.set(1);
    }

    public static DraculaReturnValue m4060a(MutableFlatBuffer mutableFlatBuffer, int i, int i2, MutableFlatBuffer mutableFlatBuffer2, int i3, int i4, int i5) {
        if ((i != 0 && mutableFlatBuffer == null) || (i3 != 0 && mutableFlatBuffer2 == null)) {
            1 1 = (1) f2922a.get();
            if (1 != null) {
                1.a("#11331948 DraculaHelper.getClassProperty$0$Dracula(null, " + i + ", " + i2 + ", " + (mutableFlatBuffer2 == null ? "null" : "ownerBuffer") + ", " + i3 + ", " + i4 + ", " + i5 + ")");
            }
            return DraculaReturnValue.m4063a(i5);
        } else if (i != 0) {
            return DraculaReturnValue.m4065a(mutableFlatBuffer, i, i2);
        } else {
            if (i3 == 0) {
                return DraculaReturnValue.m4063a(i5);
            }
            return DraculaReturnValue.m4065a(mutableFlatBuffer2, mutableFlatBuffer2.g(i3, i4), i5);
        }
    }
}

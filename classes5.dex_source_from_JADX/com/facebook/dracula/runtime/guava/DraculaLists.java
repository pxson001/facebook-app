package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.dracula.runtime.jdk.DraculaIterator$0$Dracula;
import com.facebook.dracula.runtime.jdk.DraculaList;
import com.facebook.dracula.runtime.jdk.DraculaList$0$Dracula;
import com.facebook.flatbuffers.MutableFlatBuffer;
import javax.annotation.Nullable;

/* compiled from: rootReference */
public final class DraculaLists {
    private DraculaLists() {
    }

    static boolean m4114a(DraculaList$0$Dracula draculaList$0$Dracula, @Nullable Object obj) {
        if (obj == DraculaPreconditions.m4117a(draculaList$0$Dracula)) {
            return true;
        }
        if (!(obj instanceof DraculaList)) {
            return false;
        }
        DraculaList$0$Dracula draculaList$0$Dracula2 = (DraculaList$0$Dracula) obj;
        if (draculaList$0$Dracula.mo596c() == draculaList$0$Dracula2.mo596c()) {
            DraculaIterator$0$Dracula b = draculaList$0$Dracula.mo589b();
            DraculaIterator$0$Dracula b2 = draculaList$0$Dracula2.mo589b();
            Object obj2 = null;
            while (b.mo585a()) {
                if (!b2.mo585a()) {
                    break;
                }
                DraculaReturnValue b3 = b.mo586b();
                MutableFlatBuffer mutableFlatBuffer = b3.f2924a;
                int i = b3.f2925b;
                int i2 = b3.f2926c;
                b3 = b2.mo586b();
                MutableFlatBuffer mutableFlatBuffer2 = b3.f2924a;
                int i3 = b3.f2925b;
                i2 = b3.f2926c;
                if (!(DraculaRuntime.m4076a(mutableFlatBuffer, i, null, 0) ? DraculaRuntime.m4076a(mutableFlatBuffer2, i3, null, 0) : DraculaRuntime.m4076a(mutableFlatBuffer, i, mutableFlatBuffer2, i3))) {
                    break;
                }
            }
            if (!b2.mo585a()) {
                obj2 = 1;
            }
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }
}

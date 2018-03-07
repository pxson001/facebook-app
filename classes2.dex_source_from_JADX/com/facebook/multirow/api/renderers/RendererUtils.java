package com.facebook.multirow.api.renderers;

import android.view.View;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import java.util.List;

/* compiled from: message_capping_client_tags */
public class RendererUtils {
    public static <V1 extends View, V2 extends View> V2 m20703a(V1 v1, int i) {
        if (i == -1) {
            return v1;
        }
        Object tag = v1.getTag(i);
        if (tag != null) {
            return (View) tag;
        }
        V1 findViewById = v1.findViewById(i);
        v1.setTag(i, findViewById);
        return findViewById;
    }

    public static <P, S, E extends AnyEnvironment, V extends View> void m20704a(E e, PartHolder<P, S, E, V> partHolder) {
        partHolder.d = partHolder.a.mo2541a((SubParts) partHolder, partHolder.b, (AnyEnvironment) e);
        List list = partHolder.c;
        for (int i = 0; i < list.size(); i++) {
            m20704a((AnyEnvironment) e, (PartHolder) list.get(i));
        }
    }

    public static <P, E extends AnyEnvironment, V1 extends View, V2 extends View> void m20705a(E e, PartHolder<P, ?, E, V1> partHolder, V1 v1) {
        partHolder.a.mo2543a(partHolder.b, partHolder.d, e, v1);
        List list = partHolder.c;
        for (int i = 0; i < list.size(); i++) {
            PartHolder partHolder2 = (PartHolder) list.get(i);
            m20705a(e, partHolder2, partHolder2.a(v1));
        }
    }

    public static <P, E extends AnyEnvironment, V1 extends View, V2 extends View> void m20706b(E e, PartHolder<P, ?, E, V1> partHolder, V1 v1) {
        List list = partHolder.c;
        for (int size = list.size() - 1; size >= 0; size--) {
            PartHolder partHolder2 = (PartHolder) list.get(size);
            m20706b(e, partHolder2, partHolder2.a(v1));
        }
        partHolder.a.mo2544b(partHolder.b, partHolder.d, e, v1);
    }
}

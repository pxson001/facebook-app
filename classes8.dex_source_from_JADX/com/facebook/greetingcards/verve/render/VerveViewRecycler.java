package com.facebook.greetingcards.verve.render;

import android.view.View;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier.RecyclerType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: view_page_settings */
public class VerveViewRecycler {
    public final ImmutableList<RecyclerType> f438a;
    public final VerveViewSupplier f439b;
    public final VerveViewRecycledPool f440c = new VerveViewRecycledPool();

    /* compiled from: view_page_settings */
    public enum VerveViewRecyclerTypes implements RecyclerType {
        LABEL,
        BUTTON,
        SEQUENCE,
        GROUP,
        RECT,
        PLACEHOLDER,
        MEDIA_WITH_IMAGE,
        MEDIA_WITH_VIDEO
    }

    public VerveViewRecycler(VerveViewSupplier verveViewSupplier) {
        this.f439b = verveViewSupplier;
        Builder builder = new Builder();
        for (VerveViewRecyclerTypes verveViewRecyclerTypes : VerveViewRecyclerTypes.values()) {
            builder.c((RecyclerType) verveViewRecyclerTypes);
        }
        Iterator it = this.f439b.a().iterator();
        while (it.hasNext()) {
            builder.c((RecyclerType) it.next());
        }
        this.f438a = builder.b();
    }

    @Nullable
    public final View m410a(int i) {
        View view;
        ArrayList arrayList = (ArrayList) this.f440c.f434a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            view = null;
        } else {
            int size = arrayList.size() - 1;
            view = (View) arrayList.get(size);
            arrayList.remove(size);
        }
        return view;
    }
}

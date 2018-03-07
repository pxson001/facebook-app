package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.view.View;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.SinglePartDefinitionBinder;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclablepager.PagerViewType;
import java.util.ArrayList;

/* compiled from: device_context */
public class PagerBinderDelegate<SubProps, E extends HasPersistentState> {
    public final PersistentRecyclerPartDefinition$Callbacks<SubProps, E> f13913a;
    private final PersistentRecyclerPartDefinition$Props f13914b;
    public final ArrayList<Integer> f13915c = new ArrayList();
    public int f13916d = 0;

    public PagerBinderDelegate(PersistentRecyclerPartDefinition$Callbacks<SubProps, E> persistentRecyclerPartDefinition$Callbacks, PersistentRecyclerPartDefinition$Props persistentRecyclerPartDefinition$Props) {
        this.f13913a = persistentRecyclerPartDefinition$Callbacks;
        this.f13914b = persistentRecyclerPartDefinition$Props;
        this.f13915c.clear();
        int a = this.f13913a.m14704a();
        for (int i = 0; i < a; i++) {
            if (m14708a(this.f13913a.m14705a(i), this.f13913a.m14706b(i))) {
                this.f13915c.add(Integer.valueOf(i));
            }
        }
    }

    public final int m14709a() {
        return this.f13914b.f13888b;
    }

    public final String m14711b() {
        return this.f13914b.f13890d;
    }

    public final CacheableEntity m14713c() {
        return this.f13914b.f13891e;
    }

    public final int m14714d() {
        return this.f13916d;
    }

    public final PageItem m14710a(int i) {
        final SinglePartDefinitionWithViewType a = this.f13913a.m14705a(((Integer) this.f13915c.get(i)).intValue());
        return new PageItem(new PagerViewType<View>(this) {
            final /* synthetic */ PagerBinderDelegate f13933b;

            public final Class mo1000a() {
                Class enclosingClass = a.a().getClass().getEnclosingClass();
                if (enclosingClass == null || enclosingClass != ViewType.class) {
                    return a.a().getClass();
                }
                return a.getClass();
            }

            public final View mo999a(Context context) {
                return a.a().a(context);
            }
        }, new SinglePartDefinitionBinder(this.f13913a.m14706b(((Integer) this.f13915c.get(i)).intValue()), a));
    }

    public final int m14715e() {
        return this.f13915c.size();
    }

    public final void m14712b(int i) {
        this.f13916d = i;
        this.f13913a.m14707c(i);
    }

    public static boolean m14708a(SinglePartDefinitionWithViewType singlePartDefinitionWithViewType, Object obj) {
        return !(singlePartDefinitionWithViewType instanceof PartWithIsNeeded) || ((PartWithIsNeeded) singlePartDefinitionWithViewType).a(obj);
    }
}

package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Save Button is binded without a target object. */
public class SeeTranslationComponent$Builder extends Builder<SeeTranslationComponent> {
    public SeeTranslationComponent$State f23451a;
    final /* synthetic */ SeeTranslationComponent f23452b;
    private String[] f23453c = new String[]{"storyProps", "environment"};
    private int f23454d = 2;
    public BitSet f23455e = new BitSet(this.f23454d);

    public SeeTranslationComponent$Builder(SeeTranslationComponent seeTranslationComponent) {
        this.f23452b = seeTranslationComponent;
    }

    public static void m25742a(SeeTranslationComponent$Builder seeTranslationComponent$Builder, ComponentContext componentContext, int i, SeeTranslationComponent$State seeTranslationComponent$State) {
        super.a(componentContext, i, seeTranslationComponent$State);
        seeTranslationComponent$Builder.f23451a = seeTranslationComponent$State;
        seeTranslationComponent$Builder.f23455e.clear();
    }

    public final Component<SeeTranslationComponent> m25744d() {
        int i = 0;
        if (this.f23455e == null || this.f23455e.nextClearBit(0) >= this.f23454d) {
            SeeTranslationComponent$State seeTranslationComponent$State = this.f23451a;
            m25743a();
            return seeTranslationComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f23454d) {
            if (!this.f23455e.get(i)) {
                arrayList.add(this.f23453c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m25743a() {
        super.a();
        this.f23451a = null;
        this.f23452b.c.a(this);
    }
}

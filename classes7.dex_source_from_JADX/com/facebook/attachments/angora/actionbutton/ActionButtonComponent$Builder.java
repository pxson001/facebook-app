package com.facebook.attachments.angora.actionbutton;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: video/mpeg2 */
public class ActionButtonComponent$Builder extends Builder<ActionButtonComponent> {
    public ActionButtonComponent$State f643a;
    private String[] f644b = new String[]{"clickListener"};
    private int f645c = 1;
    private BitSet f646d = new BitSet(this.f645c);

    public static void m728a(ActionButtonComponent$Builder actionButtonComponent$Builder, ComponentContext componentContext, int i, ActionButtonComponent$State actionButtonComponent$State) {
        super.a(componentContext, i, actionButtonComponent$State);
        actionButtonComponent$Builder.f643a = actionButtonComponent$State;
        actionButtonComponent$Builder.f646d.clear();
    }

    public final ActionButtonComponent$Builder m731a(CharSequence charSequence) {
        this.f643a.f647a = charSequence;
        return this;
    }

    public final ActionButtonComponent$Builder m734b(Reference<Drawable> reference) {
        this.f643a.f650d = reference;
        return this;
    }

    public final ActionButtonComponent$Builder m737j(@DrawableRes int i) {
        this.f643a.f650d = g(i);
        return this;
    }

    public final ActionButtonComponent$Builder m738k(@DrawableRes int i) {
        this.f643a.f651e = i;
        return this;
    }

    public final ActionButtonComponent$Builder m732a(boolean z) {
        this.f643a.f652f = z;
        return this;
    }

    public final ActionButtonComponent$Builder m735b(CharSequence charSequence) {
        this.f643a.f653g = charSequence;
        return this;
    }

    public final ActionButtonComponent$Builder m739l(@StringRes int i) {
        this.f643a.f653g = b(i);
        return this;
    }

    public final ActionButtonComponent$Builder m740m(int i) {
        this.f643a.f654h = i;
        return this;
    }

    public final ActionButtonComponent$Builder m729a(SparseArray<Object> sparseArray) {
        this.f643a.f655i = sparseArray;
        return this;
    }

    public final ActionButtonComponent$Builder m730a(OnClickListener onClickListener) {
        this.f643a.f656j = onClickListener;
        this.f646d.set(0);
        return this;
    }

    public final Component<ActionButtonComponent> m736d() {
        int i = 0;
        if (this.f646d == null || this.f646d.nextClearBit(0) >= this.f645c) {
            ActionButtonComponent$State actionButtonComponent$State = this.f643a;
            m733a();
            return actionButtonComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f645c) {
            if (!this.f646d.get(i)) {
                arrayList.add(this.f644b[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m733a() {
        super.a();
        this.f643a = null;
        ActionButtonComponent.b.a(this);
    }
}

package com.facebook.attachments.angora.actionbutton;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import com.facebook.components.Component;
import com.facebook.components.reference.Reference;

/* compiled from: video/mpeg2 */
public class ActionButtonComponent$State extends Component<ActionButtonComponent> implements Cloneable {
    public CharSequence f647a;
    public Reference<Drawable> f648b;
    public int f649c = Integer.MIN_VALUE;
    Reference<Drawable> f650d;
    int f651e = ActionButtonComponentSpec.a;
    boolean f652f;
    CharSequence f653g;
    int f654h = Integer.MIN_VALUE;
    SparseArray<Object> f655i;
    OnClickListener f656j;
    final /* synthetic */ ActionButtonComponent f657k;

    public ActionButtonComponent$State(ActionButtonComponent actionButtonComponent) {
        this.f657k = actionButtonComponent;
        super(actionButtonComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActionButtonComponent$State actionButtonComponent$State = (ActionButtonComponent$State) obj;
        if (this.b == actionButtonComponent$State.b) {
            return true;
        }
        if (this.f647a == null ? actionButtonComponent$State.f647a != null : !this.f647a.equals(actionButtonComponent$State.f647a)) {
            return false;
        }
        if (this.f648b == null ? actionButtonComponent$State.f648b != null : !this.f648b.equals(actionButtonComponent$State.f648b)) {
            return false;
        }
        if (this.f649c != actionButtonComponent$State.f649c) {
            return false;
        }
        if (this.f650d == null ? actionButtonComponent$State.f650d != null : !this.f650d.equals(actionButtonComponent$State.f650d)) {
            return false;
        }
        if (this.f651e != actionButtonComponent$State.f651e) {
            return false;
        }
        if (this.f652f != actionButtonComponent$State.f652f) {
            return false;
        }
        if (this.f653g == null ? actionButtonComponent$State.f653g != null : !this.f653g.equals(actionButtonComponent$State.f653g)) {
            return false;
        }
        if (this.f654h != actionButtonComponent$State.f654h) {
            return false;
        }
        if (this.f655i == null ? actionButtonComponent$State.f655i != null : !this.f655i.equals(actionButtonComponent$State.f655i)) {
            return false;
        }
        if (this.f656j != null) {
            if (this.f656j.equals(actionButtonComponent$State.f656j)) {
                return true;
            }
        } else if (actionButtonComponent$State.f656j == null) {
            return true;
        }
        return false;
    }
}

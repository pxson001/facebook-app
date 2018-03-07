package com.facebook.orca.emoji;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;

/* compiled from: null ViewerContextUser found opening send payment screen */
public class ClassicAttachmentKeyboard extends AbstractComposerKeyboard<ClassicAttachmentKeyboardView> {
    protected final View m5898b(ViewGroup viewGroup) {
        return new ClassicAttachmentKeyboardView(viewGroup.getContext());
    }

    public final void m5897a(boolean z) {
        ClassicAttachmentKeyboardView classicAttachmentKeyboardView = (ClassicAttachmentKeyboardView) this.a;
        if (classicAttachmentKeyboardView.f6179o != z) {
            classicAttachmentKeyboardView.f6179o = z;
            if (((Boolean) classicAttachmentKeyboardView.f6171f.get()).booleanValue() && classicAttachmentKeyboardView.f6173i != null) {
                if (z) {
                    classicAttachmentKeyboardView.f6173i.mo165c();
                } else {
                    classicAttachmentKeyboardView.f6173i.mo166d();
                }
            }
        }
    }

    public final void m5899b() {
        ClassicAttachmentKeyboardView classicAttachmentKeyboardView = (ClassicAttachmentKeyboardView) this.a;
        if (classicAttachmentKeyboardView.f6175k != null && classicAttachmentKeyboardView.f6178n != null) {
            classicAttachmentKeyboardView.f6175k.setVisibility(0);
            classicAttachmentKeyboardView.f6178n.setVisibility(8);
        }
    }
}

package com.facebook.orca.compose;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.react.keyboardinterface.ReactKeyboardView;
import com.facebook.messaging.react.keyboardinterface.ReactKeyboardViewFactoryStub;
import javax.inject.Inject;

/* compiled from: open_gallery */
public class ReactKeyboard extends AbstractComposerKeyboard<ReactKeyboardView> {
    private final ReactKeyboardViewFactoryStub f5566a;

    public static ReactKeyboard m5154b(InjectorLike injectorLike) {
        return new ReactKeyboard(new ReactKeyboardViewFactoryStub());
    }

    @Inject
    public ReactKeyboard(ReactKeyboardViewFactoryStub reactKeyboardViewFactoryStub) {
        this.f5566a = reactKeyboardViewFactoryStub;
    }

    protected final View m5155b(ViewGroup viewGroup) {
        ReactKeyboardViewFactoryStub reactKeyboardViewFactoryStub = this.f5566a;
        return new ReactKeyboardView(viewGroup.getContext());
    }
}

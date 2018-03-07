package com.facebook.chatheads.view;

import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: readPrimitiveField() cannot handle embedded messages. */
public class ChatHeadSimpleFullWindow extends FloatingChatWindow<ChatHeadSimpleFullView> {
    public static ChatHeadSimpleFullWindow m6014b(InjectorLike injectorLike) {
        return new ChatHeadSimpleFullWindow(WindowManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ChatHeadSimpleFullWindow(WindowManager windowManager) {
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2007, 65792, -3);
        layoutParams.gravity = 51;
        super(windowManager, layoutParams);
        setFocusable(false);
        setTouchable(false);
    }

    public final ChatHeadCloseTargetView lI_() {
        ChatHeadSimpleFullView chatHeadSimpleFullView = (ChatHeadSimpleFullView) this.f5795c;
        if (chatHeadSimpleFullView.f5792c == null) {
            chatHeadSimpleFullView.f5792c = (ChatHeadCloseTargetView) chatHeadSimpleFullView.f5790a.inflate();
            chatHeadSimpleFullView.f5792c.f5766a = chatHeadSimpleFullView.f5791b;
        }
        return chatHeadSimpleFullView.f5792c;
    }
}

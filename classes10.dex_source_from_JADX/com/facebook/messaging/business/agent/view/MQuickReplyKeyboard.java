package com.facebook.messaging.business.agent.view;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: thread_summary_for_settings */
public class MQuickReplyKeyboard extends AbstractComposerKeyboard<MQuickReplyKeyboardView> {
    protected final View m1470b(ViewGroup viewGroup) {
        return new MQuickReplyKeyboardView(viewGroup.getContext());
    }

    public final void m1469a(ThreadKey threadKey) {
        ((MQuickReplyKeyboardView) this.a).setThreadKey(threadKey);
    }
}

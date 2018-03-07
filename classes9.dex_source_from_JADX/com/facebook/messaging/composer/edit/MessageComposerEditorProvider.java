package com.facebook.messaging.composer.edit;

import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: messenger_more_apps */
public class MessageComposerEditorProvider extends AbstractAssistedProvider<MessageComposerEditor> {
    public final MessageComposerEditor m10361a(BetterEditTextView betterEditTextView) {
        return new MessageComposerEditor(EmojiUtil.a(this), InputMethodManagerMethodAutoProvider.b(this), betterEditTextView);
    }
}

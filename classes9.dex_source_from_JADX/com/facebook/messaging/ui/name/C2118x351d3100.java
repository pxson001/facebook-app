package com.facebook.messaging.ui.name;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.EmojiUtil;

/* compiled from: check_nonce */
public class C2118x351d3100 extends AbstractProvider<ThreadNameViewComputer> {
    public static ThreadNameViewComputer m18226b(InjectorLike injectorLike) {
        return MessagesThreadUiNameModule.m18189b(EmojiUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TextListWithMoreComputer.m18207b(injectorLike), I18nJoiner.b(injectorLike));
    }

    public Object get() {
        return MessagesThreadUiNameModule.m18189b(EmojiUtil.a(this), ResourcesMethodAutoProvider.a(this), TextListWithMoreComputer.m18207b(this), I18nJoiner.b(this));
    }

    public static ThreadNameViewComputer m18225a(InjectorLike injectorLike) {
        return C2118x351d3100.m18226b(injectorLike);
    }
}

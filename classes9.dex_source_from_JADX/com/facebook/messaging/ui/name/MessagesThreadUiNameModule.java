package com.facebook.messaging.ui.name;

import android.content.res.Resources;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.ui.name.ThreadNameView.TextOptions;
import com.facebook.ui.emoji.EmojiUtil;

@InjectorModule
/* compiled from: checkout_params */
public class MessagesThreadUiNameModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DefaultThreadNameViewComputer
    public static ThreadNameViewComputer m18188a(EmojiUtil emojiUtil, Resources resources, TextListWithMoreComputer textListWithMoreComputer, I18nJoiner i18nJoiner) {
        return new ThreadNameViewComputer(emojiUtil, resources, textListWithMoreComputer, TextOptions.USE_THREAD_NAME_IF_AVAILABLE, i18nJoiner);
    }

    @ProviderMethod
    @NamesOnlyThreadNameViewComputer
    public static ThreadNameViewComputer m18189b(EmojiUtil emojiUtil, Resources resources, TextListWithMoreComputer textListWithMoreComputer, I18nJoiner i18nJoiner) {
        return new ThreadNameViewComputer(emojiUtil, resources, textListWithMoreComputer, TextOptions.USE_PARTICIPANTS_NAMES_ONLY, i18nJoiner);
    }
}

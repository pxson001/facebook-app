package com.facebook.messaging.emoji;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.ui.util.DynamicLayoutUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: make_default_mutation */
public class MessengerEmojiColorNuxFragment extends FullScreenDialogFragment {
    @Inject
    public DynamicLayoutUtil am;
    @Inject
    public FbSharedPreferences an;
    private TextView ao;

    /* compiled from: make_default_mutation */
    class C12111 implements OnClickListener {
        final /* synthetic */ MessengerEmojiColorNuxFragment f10983a;

        C12111(MessengerEmojiColorNuxFragment messengerEmojiColorNuxFragment) {
            this.f10983a = messengerEmojiColorNuxFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 546492182);
            this.f10983a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -1185431550, a);
        }
    }

    public static void m11397a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessengerEmojiColorNuxFragment messengerEmojiColorNuxFragment = (MessengerEmojiColorNuxFragment) obj;
        DynamicLayoutUtil b = DynamicLayoutUtil.b(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        messengerEmojiColorNuxFragment.am = b;
        messengerEmojiColorNuxFragment.an = fbSharedPreferences;
    }

    public final void m11399a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1950054579);
        super.a(bundle);
        Class cls = MessengerEmojiColorNuxFragment.class;
        m11397a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1908115209, a);
    }

    public final View m11398a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 56275051);
        View inflate = layoutInflater.inflate(2130905244, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1833163825, a);
        return inflate;
    }

    public final void m11400a(View view, @Nullable Bundle bundle) {
        View view2 = this.T;
        this.am.a(view2, jW_().getInteger(2131492874), ImmutableList.of(Integer.valueOf(2131563834)));
        this.am.a(view2, jW_().getInteger(2131492875), ImmutableList.of(Integer.valueOf(2131558927), Integer.valueOf(2131563835)), ImmutableList.of(Integer.valueOf(2131427860), Integer.valueOf(2131427862)), ImmutableList.of(Integer.valueOf(2131427859), Integer.valueOf(2131427861)));
        this.ao = (TextView) e(2131563836);
        this.ao.setOnClickListener(new C12111(this));
        this.an.edit().putBoolean(EmojiPrefKeys.g, true).putBoolean(EmojiPrefKeys.h, false).commit();
    }
}

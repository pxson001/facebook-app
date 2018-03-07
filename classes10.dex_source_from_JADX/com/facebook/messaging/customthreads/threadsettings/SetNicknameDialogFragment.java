package com.facebook.messaging.customthreads.threadsettings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.EditText;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.MessengerUserNameUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass13;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.text.TextViewUtils;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: start_age_ms */
public class SetNicknameDialogFragment extends FbDialogFragment {
    @Inject
    EmojiUtil am;
    @Inject
    FbObjectMapper an;
    @Inject
    @ViewerContextUser
    public Provider<User> ao;
    @Inject
    public MessengerUserNameUtil ap;
    @Inject
    UserCache aq;
    public EditText ar;
    public ThreadSummary as;
    public String at;
    public AnonymousClass13 au;

    /* compiled from: start_age_ms */
    class C03741 implements OnClickListener {
        final /* synthetic */ SetNicknameDialogFragment f2270a;

        C03741(SetNicknameDialogFragment setNicknameDialogFragment) {
            this.f2270a = setNicknameDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SetNicknameDialogFragment setNicknameDialogFragment = this.f2270a;
            String obj = this.f2270a.ar.getText().toString();
            if (setNicknameDialogFragment.au != null) {
                setNicknameDialogFragment.au.m7405a(setNicknameDialogFragment.at, obj);
            }
        }
    }

    /* compiled from: start_age_ms */
    class C03752 implements OnClickListener {
        final /* synthetic */ SetNicknameDialogFragment f2271a;

        C03752(SetNicknameDialogFragment setNicknameDialogFragment) {
            this.f2271a = setNicknameDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SetNicknameDialogFragment setNicknameDialogFragment = this.f2271a;
            if (setNicknameDialogFragment.au != null) {
                setNicknameDialogFragment.au.m7404a(setNicknameDialogFragment.at);
            }
        }
    }

    public static void m2141a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SetNicknameDialogFragment) obj).m2140a(EmojiUtil.a(fbInjector), FbObjectMapperMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 3596), MessengerUserNameUtil.a(fbInjector), UserCache.a(fbInjector));
    }

    public final void m2142a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1412232955);
        super.a(bundle);
        Class cls = SetNicknameDialogFragment.class;
        m2141a(this, getContext());
        Bundle bundle2 = this.s;
        this.as = (ThreadSummary) bundle2.getParcelable("thread_summary");
        this.at = bundle2.getString("participant_id");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1232823486, a);
    }

    public final Dialog m2143c(Bundle bundle) {
        String str;
        CharSequence string;
        Context context = getContext();
        Resources jW_ = jW_();
        if (this.as.a.b() || this.as.a.d() || this.as.a.e()) {
            str = null;
        } else {
            ImmutableList immutableList = this.as.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                if (!((User) this.ao.get()).a.equals(threadParticipant.b().b())) {
                    str = this.ap.a(threadParticipant.a);
                    break;
                }
            }
            str = null;
        }
        if (str != null) {
            string = jW_.getString(2131231860, new Object[]{r0});
        } else {
            string = jW_.getString(2131231861);
        }
        this.ar = new EditText(context);
        TextViewUtils.a(context, this.ar);
        int dimensionPixelSize = jW_.getDimensionPixelSize(2131427838);
        Builder c = new Builder(context).a(2131231859).b(string).a(this.ar, dimensionPixelSize, 0, dimensionPixelSize, 0).a(2131231862, new C03741(this)).c(2131231864, null);
        if (at()) {
            c.b(2131231863, new C03752(this));
        }
        final AlertDialog a = c.a();
        DialogWindowUtils.a(a);
        if (bundle == null || !bundle.containsKey("nickname_input")) {
            string = SpannableStringBuilder.valueOf(aq());
        } else {
            string = SpannableStringBuilder.valueOf(bundle.getString("nickname_input"));
        }
        this.am.a(string, (int) this.ar.getTextSize());
        this.ar.setText(string);
        this.ar.setSelection(0, this.ar.length());
        this.ar.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SetNicknameDialogFragment f2273b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                a.a(-1).setEnabled(charSequence.length() > 0);
                this.f2273b.am.a(this.f2273b.ar.getText(), (int) this.f2273b.ar.getTextSize(), i, i3);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        return a;
    }

    private void m2140a(EmojiUtil emojiUtil, FbObjectMapper fbObjectMapper, Provider<User> provider, MessengerUserNameUtil messengerUserNameUtil, UserCache userCache) {
        this.am = emojiUtil;
        this.an = fbObjectMapper;
        this.ao = provider;
        this.ap = messengerUserNameUtil;
        this.aq = userCache;
    }

    private String aq() {
        ParticipantInfo participantInfo;
        ImmutableList immutableList = this.as.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (this.at.equals(threadParticipant.b().b())) {
                participantInfo = threadParticipant.a;
                break;
            }
        }
        participantInfo = null;
        ParticipantInfo participantInfo2 = participantInfo;
        if (participantInfo2 != null) {
            String as = as();
            if (as != null) {
                return as;
            }
            as = this.ap.b(participantInfo2);
            if (as != null) {
                return as;
            }
        }
        User a = this.aq.a(UserKey.b(this.at));
        if (a != null) {
            return a.k();
        }
        return "";
    }

    @Nullable
    private String as() {
        return this.as.D.g.a(this.at, this.an);
    }

    private boolean at() {
        return !StringUtil.a(as());
    }

    public final void m2144e(Bundle bundle) {
        super.e(bundle);
        if (this.ar != null) {
            bundle.putString("nickname_input", this.ar.getText().toString());
        }
    }
}

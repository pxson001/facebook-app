package com.facebook.messaging.threadview.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.analytics.CounterLogger;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.IsMessengerMaterialDesignEnabled;
import com.facebook.messaging.appspecific.AppNameResolver;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;
import com.facebook.messaging.presence.LastActiveHelper.TextFormat;
import com.facebook.messaging.presence.PresenceIndicatorView;
import com.facebook.messaging.presence.PresenceType;
import com.facebook.messaging.presence.UserAppPresenceHelper;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper.PageResponsivenessListener;
import com.facebook.messaging.users.MessengerInviteEligibilityChecker;
import com.facebook.presence.Availability;
import com.facebook.presence.PresenceState;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: platform_share_cancel_dialog */
public class ThreadTitleView extends CustomFrameLayout {
    @Inject
    CanonicalThreadPresenceHelper f4791a;
    @Inject
    CounterLogger f4792b;
    @Inject
    LocalStatsLoggerImpl f4793c;
    @Inject
    MessengerInviteEligibilityChecker f4794d;
    @IsMessengerMaterialDesignEnabled
    @Inject
    Provider<Boolean> f4795e;
    @Inject
    MaterialDesignExperimentHelper f4796f;
    @Inject
    FbPhoneNumberUtils f4797g;
    @Inject
    UserAppPresenceHelper f4798h;
    @Inject
    UserCache f4799i;
    private ThreadNameView f4800j;
    private Optional<TextView> f4801k;
    private Optional<PresenceIndicatorView> f4802l;
    private ProgressBar f4803m;
    private boolean f4804n;
    private boolean f4805o;
    @Nullable
    private UserKey f4806p;
    @Nullable
    private String f4807q;
    private PresenceState f4808r = PresenceState.a;
    private final PageResponsivenessListener f4809s = new C06571(this);

    /* compiled from: platform_share_cancel_dialog */
    class C06571 implements PageResponsivenessListener {
        final /* synthetic */ ThreadTitleView f4789a;

        C06571(ThreadTitleView threadTitleView) {
            this.f4789a = threadTitleView;
        }

        public final void m4347a() {
            ThreadTitleView.m4360e(this.f4789a);
        }
    }

    /* compiled from: platform_share_cancel_dialog */
    class C06582 extends Listener {
        final /* synthetic */ ThreadTitleView f4790a;

        C06582(ThreadTitleView threadTitleView) {
            this.f4790a = threadTitleView;
        }

        public final void m4348a(PresenceState presenceState) {
            this.f4790a.m4354a(presenceState);
        }
    }

    private static <T extends View> void m4355a(Class<T> cls, T t) {
        m4356a((Object) t, t.getContext());
    }

    private static void m4356a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadTitleView) obj).m4353a(CanonicalThreadPresenceHelper.b(fbInjector), CounterLogger.a(fbInjector), LocalStatsLoggerMethodAutoProvider.a(fbInjector), MessengerInviteEligibilityChecker.b(fbInjector), IdBasedProvider.a(fbInjector, 4073), MaterialDesignExperimentHelper.b(fbInjector), FbPhoneNumberUtils.b(fbInjector), new UserAppPresenceHelper(ResourcesMethodAutoProvider.a(fbInjector)), UserCache.a(fbInjector));
    }

    public ThreadTitleView(Context context) {
        super(context);
        m4350a(context, null);
    }

    public ThreadTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4350a(context, attributeSet);
    }

    public ThreadTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4350a(context, attributeSet);
    }

    private void m4350a(Context context, AttributeSet attributeSet) {
        m4355a(ThreadTitleView.class, (View) this);
        this.f4805o = context.obtainStyledAttributes(attributeSet, R.styleable.ThreadTitleView).getBoolean(0, false);
        if (this.f4805o) {
            setContentView(2130905582);
        } else {
            setContentView(2130905887);
        }
        this.f4800j = (ThreadNameView) c(2131564484);
        this.f4801k = d(2131564491);
        this.f4802l = d(2131564485);
        this.f4803m = (ProgressBar) c(2131564486);
        this.f4804n = getResources().getBoolean(2131296262);
        this.f4791a.s = new C06582(this);
    }

    private void m4353a(CanonicalThreadPresenceHelper canonicalThreadPresenceHelper, CounterLogger counterLogger, LocalStatsLogger localStatsLogger, MessengerInviteEligibilityChecker messengerInviteEligibilityChecker, Provider<Boolean> provider, MaterialDesignExperimentHelper materialDesignExperimentHelper, FbPhoneNumberUtils fbPhoneNumberUtils, UserAppPresenceHelper userAppPresenceHelper, UserCache userCache) {
        this.f4791a = canonicalThreadPresenceHelper;
        this.f4792b = counterLogger;
        this.f4793c = localStatsLogger;
        this.f4794d = messengerInviteEligibilityChecker;
        this.f4795e = provider;
        this.f4796f = materialDesignExperimentHelper;
        this.f4797g = fbPhoneNumberUtils;
        this.f4798h = userAppPresenceHelper;
        this.f4799i = userCache;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1591449917);
        super.onAttachedToWindow();
        this.f4791a.a(true);
        this.f4791a.t = this.f4809s;
        m4357b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1468048365, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1717729840);
        super.onDetachedFromWindow();
        this.f4791a.a(false);
        this.f4791a.t = null;
        m4359b(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1113246965, a);
    }

    public void setThreadNameViewData(MessengerThreadNameViewData messengerThreadNameViewData) {
        this.f4800j.setData(messengerThreadNameViewData);
        this.f4791a.a(messengerThreadNameViewData);
        if (messengerThreadNameViewData == null || messengerThreadNameViewData.a == null) {
            this.f4806p = null;
        } else {
            this.f4806p = messengerThreadNameViewData.a.b;
            this.f4807q = messengerThreadNameViewData.a.d;
        }
        m4357b();
        setContentDescription(m4349a());
    }

    private CharSequence m4349a() {
        CharSequence contentDescription = this.f4800j.getContentDescription();
        if (!this.f4801k.isPresent()) {
            return contentDescription;
        }
        return getResources().getString(2131230822, new Object[]{contentDescription, ((TextView) this.f4801k.get()).getText()});
    }

    private void m4357b() {
        if (this.f4791a.c()) {
            m4359b(true);
            m4358b(this.f4791a.r);
        } else {
            m4359b(false);
        }
        m4361f();
    }

    private void m4359b(boolean z) {
        if (z || this.f4805o) {
            this.f4800j.setMaxLines(1);
            this.f4800j.getLayoutParams().height = -2;
        } else {
            this.f4800j.setMaxLines(2);
            this.f4800j.getLayoutParams().height = -1;
        }
        if (this.f4801k.isPresent()) {
            ((TextView) this.f4801k.get()).setVisibility(8);
        }
        if (this.f4802l.isPresent()) {
            ((PresenceIndicatorView) this.f4802l.get()).setVisibility(8);
        }
    }

    private void m4354a(PresenceState presenceState) {
        if (this.f4808r != presenceState) {
            this.f4792b.a("canonical_new_presence_push");
            this.f4793c.a(5505057);
            m4358b(presenceState);
        }
    }

    public static void m4360e(ThreadTitleView threadTitleView) {
        threadTitleView.m4362g();
    }

    private void m4358b(PresenceState presenceState) {
        this.f4808r = presenceState;
        m4361f();
    }

    private void m4361f() {
        if (this.f4801k.isPresent()) {
            m4362g();
        }
        if (this.f4802l.isPresent()) {
            m4363h();
        }
    }

    private void m4362g() {
        TextView textView = (TextView) this.f4801k.get();
        TextFormat textFormat = !((Boolean) this.f4795e.get()).booleanValue() ? TextFormat.UPPER_CASE : TextFormat.NORMAL;
        CharSequence charSequence = null;
        if (this.f4806p == null || !this.f4806p.e()) {
            CanonicalThreadPresenceHelper canonicalThreadPresenceHelper = this.f4791a;
            Context context = getContext();
            String charSequence2 = textView != null ? textView.getText().toString() : "";
            boolean z = this.f4794d.a(this.f4806p) || this.f4804n;
            charSequence = canonicalThreadPresenceHelper.a(context, charSequence2, textFormat, z, this.f4799i.a(this.f4806p));
        } else if (this.f4806p.f() != null) {
            if (StringUtil.a(this.f4806p.g())) {
                charSequence = this.f4807q;
            } else {
                charSequence = this.f4797g.b(this.f4806p.g());
            }
        }
        if ((this.f4806p == null || !this.f4806p.e()) && StringUtil.a(r0) && this.f4796f.f()) {
            String str;
            UserAppPresenceHelper userAppPresenceHelper = this.f4798h;
            User a = this.f4799i.a(this.f4806p);
            if (a == null) {
                str = "";
            } else if (a.t) {
                str = AppNameResolver.a(userAppPresenceHelper.a);
            } else if (a.E) {
                str = "";
            } else {
                str = userAppPresenceHelper.a.getString(2131232192);
            }
            charSequence = str;
        }
        if (StringUtil.a(charSequence) || charSequence.equals(getContext().getString(2131241130))) {
            textView.setVisibility(8);
            textView.setText("");
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    private void m4363h() {
        if (this.f4802l.isPresent()) {
            PresenceIndicatorView presenceIndicatorView = (PresenceIndicatorView) this.f4802l.get();
            PresenceState presenceState = this.f4791a.r;
            if (presenceState.b == Availability.AVAILABLE) {
                presenceIndicatorView.setStatus(PresenceType.ONLINE);
                presenceIndicatorView.setVisibility(0);
            } else if (presenceState.c) {
                presenceIndicatorView.setStatus(PresenceType.PUSHABLE);
                presenceIndicatorView.setVisibility(0);
            } else {
                presenceIndicatorView.setVisibility(8);
            }
        }
    }

    public final void m4364a(boolean z) {
        this.f4803m.setVisibility(z ? 0 : 8);
    }
}

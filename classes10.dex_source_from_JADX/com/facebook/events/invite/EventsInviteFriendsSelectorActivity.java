package com.facebook.events.invite;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.apptab.ui.chrome.FinishHandler;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.invite.CaspianFriendSelectorFragment.OnFriendsSelectedListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: checkinDialog */
public class EventsInviteFriendsSelectorActivity extends FbFragmentActivity implements FinishHandler, OnFriendsSelectedListener {
    private static final String f17700t = EventsInviteFriendsSelectorActivity.class.getSimpleName();
    private ValueAnimator f17701A;
    public ValueAnimator f17702B;
    @Inject
    public AbstractFbErrorReporter f17703p;
    @Inject
    public FragmentFactoryMap f17704q;
    @Inject
    @IsWorkBuild
    public Boolean f17705r;
    @Inject
    public InvitePickerPerformanceLogger f17706s;
    private FragmentManager f17707u;
    public GenericFriendsSelectorFragment f17708v;
    public FbTextView f17709w;
    private EventsInviteFriendsFooterView f17710x;
    private long[] f17711y;
    public boolean f17712z;

    /* compiled from: checkinDialog */
    class C25121 implements OnClickListener {
        final /* synthetic */ EventsInviteFriendsSelectorActivity f17697a;

        C25121(EventsInviteFriendsSelectorActivity eventsInviteFriendsSelectorActivity) {
            this.f17697a = eventsInviteFriendsSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -995974127);
            this.f17697a.f17708v.aJ();
            Logger.a(2, EntryType.UI_INPUT_END, -577138084, a);
        }
    }

    /* compiled from: checkinDialog */
    class C25132 implements AnimatorUpdateListener {
        final /* synthetic */ EventsInviteFriendsSelectorActivity f17698a;

        C25132(EventsInviteFriendsSelectorActivity eventsInviteFriendsSelectorActivity) {
            this.f17698a = eventsInviteFriendsSelectorActivity;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f17698a.f17709w.setTranslationY((float) (-((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    /* compiled from: checkinDialog */
    class C25143 extends AnimatorListenerAdapter {
        final /* synthetic */ EventsInviteFriendsSelectorActivity f17699a;

        C25143(EventsInviteFriendsSelectorActivity eventsInviteFriendsSelectorActivity) {
            this.f17699a = eventsInviteFriendsSelectorActivity;
        }

        public void onAnimationStart(Animator animator) {
            this.f17699a.f17712z = true;
        }

        public void onAnimationPause(Animator animator) {
            animator.cancel();
        }

        public void onAnimationEnd(Animator animator) {
            this.f17699a.f17702B.start();
        }
    }

    private static <T extends Context> void m18025a(Class<T> cls, T t) {
        m18026a((Object) t, (Context) t);
    }

    public static void m18026a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsInviteFriendsSelectorActivity eventsInviteFriendsSelectorActivity = (EventsInviteFriendsSelectorActivity) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        FragmentFactoryMap fragmentFactoryMap = (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector);
        Boolean a = Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector);
        InvitePickerPerformanceLogger a2 = InvitePickerPerformanceLogger.m18041a(fbInjector);
        eventsInviteFriendsSelectorActivity.f17703p = abstractFbErrorReporter;
        eventsInviteFriendsSelectorActivity.f17704q = fragmentFactoryMap;
        eventsInviteFriendsSelectorActivity.f17705r = a;
        eventsInviteFriendsSelectorActivity.f17706s = a2;
    }

    protected final void m18039b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventsInviteFriendsSelectorActivity.class;
        m18026a((Object) this, (Context) this);
        this.f17706s.m18043a();
        this.f17707u = kO_();
        overridePendingTransition(2130968739, 2130968614);
        setContentView(2130904043);
        m18032j();
        m18031i();
        m18033k();
        m18034l();
    }

    private void m18031i() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra != -1) {
            Fragment a = this.f17704q.a(intExtra).a(intent);
            if (a == null || !(a instanceof GenericFriendsSelectorFragment)) {
                AbstractFbErrorReporter abstractFbErrorReporter = this.f17703p;
                SoftErrorBuilder a2 = SoftError.a(f17700t, "Failed to create a fragment");
                a2.d = true;
                abstractFbErrorReporter.a(a2.g());
                finish();
                return;
            }
            this.f17708v = (GenericFriendsSelectorFragment) a;
            Bundle bundle = this.f17708v.s;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("is_show_caspian_style", true);
            a.g(bundle);
            this.f17707u.a().b(2131558429, a).b();
            this.f17707u.b();
        }
    }

    private void m18032j() {
        TextView textView = (TextView) a(2131558927);
        int intExtra = getIntent().getIntExtra("title", 0);
        if (intExtra == 0) {
            intExtra = this.f17705r.booleanValue() ? 2131232659 : 2131232657;
        }
        textView.setText(getResources().getString(intExtra));
        a(2131560414).setOnClickListener(new C25121(this));
    }

    private void m18033k() {
        this.f17710x = (EventsInviteFriendsFooterView) a(2131561311);
        FrameLayout frameLayout = (FrameLayout) a(2131558429);
        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        if (getIntent().getBooleanExtra("extra_enable_invite_through_messenger", false)) {
            this.f17710x.setVisibility(0);
            layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131431316));
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        layoutParams.setMargins(0, 0, 0, 0);
        frameLayout.setLayoutParams(layoutParams);
        this.f17710x.setVisibility(8);
    }

    private void m18034l() {
        this.f17709w = (FbTextView) a(2131561310);
        m18035m();
    }

    private void m18035m() {
        if (!getIntent().getBooleanExtra("extra_enable_invite_through_messenger", false)) {
            return;
        }
        if (this.f17711y == null || this.f17711y.length <= 25) {
            this.f17709w.setVisibility(8);
            this.f17712z = false;
            this.f17710x.m18022a();
            return;
        }
        this.f17709w.setVisibility(0);
        if (!this.f17712z) {
            m18036n().start();
            this.f17710x.m18023b();
        }
    }

    private ValueAnimator m18028b(boolean z) {
        int dimensionPixelSize = z ? getResources().getDimensionPixelSize(2131431316) : 0;
        int dimensionPixelSize2 = z ? 0 : getResources().getDimensionPixelSize(2131431316);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{dimensionPixelSize, dimensionPixelSize2});
        ofInt.addUpdateListener(new C25132(this));
        ofInt.setDuration(300);
        return ofInt;
    }

    private ValueAnimator m18036n() {
        if (this.f17701A == null || this.f17702B == null) {
            this.f17701A = m18028b(false);
            this.f17702B = m18028b(true);
            this.f17702B.setStartDelay(3000);
            this.f17701A.addListener(new C25143(this));
        }
        return this.f17701A;
    }

    public void onBackPressed() {
        this.f17708v.aJ();
    }

    public final void m18038b() {
        Intent intent = new Intent();
        intent.putExtra("profiles", this.f17711y);
        intent.putExtra("extra_redirect_to_messenger", this.f17710x.getIsInvitingThroughMessenger());
        intent.putExtra("event_id", getIntent().getStringExtra("event_id"));
        intent.putExtra("extra_invite_action_mechanism", getIntent().getStringExtra("extra_invite_action_mechanism"));
        intent.putExtra("extra_invite_configuration_bundle", getIntent().getBundleExtra("extra_invite_configuration_bundle"));
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968724, 2130968740);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(2130968750, 2130968614);
    }

    public final void mo805a(long[] jArr) {
        this.f17711y = jArr;
        m18035m();
    }
}

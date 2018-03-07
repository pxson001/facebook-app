package com.facebook.events.invite;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: channelStateChangedReceiver */
public class InviteeReviewModeFragment extends FbFragment {
    @Inject
    public InviteeReviewListViewAdapter f17752a;
    @Inject
    EventInviteController f17753b;
    @Inject
    AbstractFbErrorReporter f17754c;
    @Inject
    Toaster f17755d;
    @Inject
    public InviteSessionLogger f17756e;
    public BetterListView f17757f;
    public LinkedList<EventInviteeToken> f17758g;
    private String f17759h;

    /* compiled from: channelStateChangedReceiver */
    public class C25161 implements OnItemClickListener {
        final /* synthetic */ InviteeReviewModeFragment f17751a;

        public C25161(InviteeReviewModeFragment inviteeReviewModeFragment) {
            this.f17751a = inviteeReviewModeFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EventInviteeToken eventInviteeToken = (EventInviteeToken) this.f17751a.f17752a.getItem(i);
            InviteeReviewModeFragment inviteeReviewModeFragment = this.f17751a;
            if (!inviteeReviewModeFragment.f17758g.contains(eventInviteeToken)) {
                inviteeReviewModeFragment.f17758g.add(eventInviteeToken);
                inviteeReviewModeFragment.f17756e.m18053a(InviteSubSessionTypes.REVIEW, 1);
            } else if (inviteeReviewModeFragment.f17758g.contains(eventInviteeToken)) {
                inviteeReviewModeFragment.f17758g.remove(eventInviteeToken);
                inviteeReviewModeFragment.f17756e.m18056b(InviteSubSessionTypes.REVIEW, 1);
            }
            AdapterDetour.a(inviteeReviewModeFragment.f17752a, -341469769);
        }
    }

    public static void m18095a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((InviteeReviewModeFragment) obj).m18094a(new InviteeReviewListViewAdapter(), EventInviteController.m17865a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Toaster.b(injectorLike), InviteSessionLogger.m18047a(injectorLike));
    }

    private void m18094a(InviteeReviewListViewAdapter inviteeReviewListViewAdapter, EventInviteController eventInviteController, AbstractFbErrorReporter abstractFbErrorReporter, Toaster toaster, InviteSessionLogger inviteSessionLogger) {
        this.f17752a = inviteeReviewListViewAdapter;
        this.f17753b = eventInviteController;
        this.f17754c = abstractFbErrorReporter;
        this.f17755d = toaster;
        this.f17756e = inviteSessionLogger;
    }

    public final void m18100c(Bundle bundle) {
        String string;
        super.c(bundle);
        Class cls = InviteeReviewModeFragment.class;
        m18095a((Object) this, getContext());
        if (bundle == null) {
            string = this.s.getString("event_id");
        } else {
            string = bundle.getString("event_id");
        }
        this.f17759h = string;
        if (Objects.equal(this.f17759h, this.f17753b.f17493b)) {
            this.f17758g = this.f17753b.f17492a;
            return;
        }
        this.f17754c.a("Events", "Event id passed to InviteeReviewModeFragment differs from the id in bundle");
        Toaster toaster = this.f17755d;
        ToastBuilder toastBuilder = new ToastBuilder(2131237178);
        toastBuilder.b = 17;
        toaster.b(toastBuilder);
        ao().finish();
    }

    public final void m18096G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1557908832);
        super.G();
        this.f17756e.m18052a(InviteSubSessionTypes.REVIEW);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1134046067, a);
    }

    public final void m18097H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -493050793);
        this.f17756e.m18055b(InviteSubSessionTypes.REVIEW);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -666908978, a);
    }

    public final View m18098a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2138802437);
        View inflate = layoutInflater.inflate(2130904974, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1141945978, a);
        return inflate;
    }

    public final void m18099a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f17757f = (BetterListView) e(2131563286);
        this.f17757f.setAdapter(this.f17752a);
        ImmutableSectionedListSection immutableSectionedListSection = new ImmutableSectionedListSection("Selected", ImmutableList.copyOf(this.f17758g));
        List a = Lists.a();
        a.add(immutableSectionedListSection);
        InviteeReviewListViewAdapter inviteeReviewListViewAdapter = this.f17752a;
        inviteeReviewListViewAdapter.f17750e = a;
        AdapterDetour.a(inviteeReviewListViewAdapter, -263764049);
        this.f17752a.f17749d = this.f17758g;
        this.f17757f.setVisibility(0);
        this.f17757f.setOnItemClickListener(new C25161(this));
    }

    public final void m18101e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("event_id", this.f17759h);
    }
}

package com.facebook.friending.jewel;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.friends.util.FriendRequestUtil;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: focusable */
public class FriendRequestView extends ImageBlockLayout {
    @Inject
    FriendingEventBus f13130h;
    @Inject
    FriendRequestUtil f13131i;
    private TextView f13132j;
    private TextView f13133k;
    private View f13134l;
    private SmartButtonLite f13135m;
    private View f13136n;
    public FriendRequest f13137o;
    public FriendRequestResponse f13138p;
    private FriendRequestState f13139q;
    private FriendshipStatusChangedEventSubscriber f13140r;
    public OnResponseListener f13141s;
    public OnSuggestionResponseListener f13142t;

    /* compiled from: focusable */
    class C13642 implements OnClickListener {
        final /* synthetic */ FriendRequestView f13126a;

        C13642(FriendRequestView friendRequestView) {
            this.f13126a = friendRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 430018535);
            this.f13126a.f13142t.mo821a(this.f13126a.f13137o);
            this.f13126a.m14793a(FriendRequestState.ACCEPTED);
            Logger.a(2, EntryType.UI_INPUT_END, -433862369, a);
        }
    }

    /* compiled from: focusable */
    class C13653 implements OnClickListener {
        final /* synthetic */ FriendRequestView f13127a;

        C13653(FriendRequestView friendRequestView) {
            this.f13127a = friendRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 577850273);
            this.f13127a.f13142t.mo822b(this.f13127a.f13137o);
            this.f13127a.m14793a(FriendRequestState.REJECTED);
            Logger.a(2, EntryType.UI_INPUT_END, -1137934859, a);
        }
    }

    /* compiled from: focusable */
    /* synthetic */ class C13664 {
        static final /* synthetic */ int[] f13128a = new int[FriendRequestState.values().length];

        static {
            try {
                f13128a[FriendRequestState.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13128a[FriendRequestState.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: focusable */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendRequestView f13129a;

        public FriendshipStatusChangedEventSubscriber(FriendRequestView friendRequestView) {
            this.f13129a = friendRequestView;
        }

        public final void m14783b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && this.f13129a.f13137o != null && this.f13129a.f13137o.a() == friendshipStatusChangedEvent.a) {
                GraphQLFriendshipStatus graphQLFriendshipStatus = friendshipStatusChangedEvent.b;
                boolean l = this.f13129a.f13137o.l();
                if ((!l && graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) || (l && graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST)) {
                    this.f13129a.m14793a(FriendRequestState.ACCEPTED);
                } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST) {
                    this.f13129a.m14793a(FriendRequestState.REJECTED);
                }
            }
        }
    }

    /* compiled from: focusable */
    public interface OnResponseListener {
        void mo820a(FriendRequest friendRequest, FriendRequestResponse friendRequestResponse);
    }

    /* compiled from: focusable */
    public interface OnSuggestionResponseListener {
        void mo821a(FriendRequest friendRequest);

        void mo822b(FriendRequest friendRequest);
    }

    private static <T extends View> void m14794a(Class<T> cls, T t) {
        m14795a((Object) t, t.getContext());
    }

    private static void m14795a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendRequestView) obj).m14792a(FriendingEventBus.a(fbInjector), FriendRequestUtil.a(fbInjector));
    }

    private void m14792a(FriendingEventBus friendingEventBus, FriendRequestUtil friendRequestUtil) {
        this.f13130h = friendingEventBus;
        this.f13131i = friendRequestUtil;
    }

    public FriendRequestView(Context context) {
        this(context, null);
    }

    public FriendRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14789a();
    }

    private void m14789a() {
        m14794a(FriendRequestView.class, (View) this);
        setContentView(2130904483);
        this.f13132j = (TextView) getView(2131562265);
        this.f13133k = (TextView) getView(2131562266);
        this.f13134l = getView(2131562260);
        this.f13135m = (SmartButtonLite) getView(2131562261);
        this.f13136n = getView(2131562262);
        this.f13140r = new FriendshipStatusChangedEventSubscriber(this);
    }

    public final void m14808a(FriendRequest friendRequest) {
        this.f13137o = friendRequest;
        this.f13139q = friendRequest.j;
        Object d = friendRequest.d();
        setThumbnailUri(StringUtil.a(d) ? null : Uri.parse(d));
        m14798f();
    }

    private void m14798f() {
        m14799g();
        m14800h();
        m14801i();
        m14804l();
    }

    private void m14799g() {
        this.f13132j.setText(this.f13137o.b());
    }

    private void m14800h() {
        this.f13133k.setVisibility(0);
        setGravity(16);
        boolean l = this.f13137o.l();
        CharSequence a = this.f13131i.a(this.f13139q, l);
        if (StringUtil.a(a)) {
            if (!l || this.f13137o.g.isEmpty()) {
                a = this.f13137o.h();
            } else {
                a = getResources().getString(2131233358, new Object[]{this.f13137o.g.get(0)});
            }
        }
        if (StringUtil.a(a)) {
            this.f13133k.setText("");
            this.f13133k.setVisibility(8);
            return;
        }
        this.f13133k.setText(a);
    }

    private void m14801i() {
        boolean l = this.f13137o.l();
        if (this.f13139q != FriendRequestState.NEEDS_RESPONSE) {
            this.f13134l.setVisibility(8);
            return;
        }
        this.f13134l.setVisibility(0);
        m14802j();
        m14803k();
        this.f13135m.setContentDescription(this.f13131i.a(l));
        this.f13136n.setContentDescription(this.f13131i.c(l));
        if (l) {
            this.f13135m.setOnClickListener(m14805m());
            this.f13136n.setOnClickListener(m14806n());
            return;
        }
        this.f13135m.setOnClickListener(m14787a(FriendRequestResponse.CONFIRM));
        this.f13136n.setOnClickListener(m14787a(FriendRequestResponse.REJECT));
    }

    private void m14802j() {
        Locale locale = getResources().getConfiguration().locale;
        boolean l = this.f13137o.l();
        String b = this.f13131i.b(l);
        this.f13135m.a(this.f13131i.a(l).toUpperCase(locale), b == null ? null : b.toUpperCase(locale));
    }

    private void m14803k() {
        ((Button) this.f13136n).setText(this.f13131i.c(this.f13137o.l()).toUpperCase(getResources().getConfiguration().locale));
    }

    private void m14804l() {
        int i;
        switch (C13664.f13128a[this.f13139q.ordinal()]) {
            case 1:
                i = 2131363701;
                break;
            case 2:
                i = 2131363702;
                break;
            default:
                if (!this.f13137o.h) {
                    i = 2130840432;
                    break;
                } else {
                    i = 2131361871;
                    break;
                }
        }
        setBackgroundResource(i);
    }

    private void m14793a(FriendRequestState friendRequestState) {
        this.f13139q = friendRequestState;
        m14798f();
    }

    private OnClickListener m14787a(final FriendRequestResponse friendRequestResponse) {
        return new OnClickListener(this) {
            final /* synthetic */ FriendRequestView f13125b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -276398120);
                this.f13125b.f13138p = friendRequestResponse;
                FriendRequestView.m14807o(this.f13125b);
                Logger.a(2, EntryType.UI_INPUT_END, 1833099964, a);
            }
        };
    }

    private OnClickListener m14805m() {
        return new C13642(this);
    }

    private OnClickListener m14806n() {
        return new C13653(this);
    }

    public static void m14807o(FriendRequestView friendRequestView) {
        friendRequestView.f13141s.mo820a(friendRequestView.f13137o, friendRequestView.f13138p);
        friendRequestView.m14793a(friendRequestView.f13138p == FriendRequestResponse.CONFIRM ? FriendRequestState.ACCEPTED : FriendRequestState.REJECTED);
    }

    public void setOnResponseListener(OnResponseListener onResponseListener) {
        this.f13141s = onResponseListener;
    }

    public void setOnSuggestionResponseListener(OnSuggestionResponseListener onSuggestionResponseListener) {
        this.f13142t = onSuggestionResponseListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -969175490);
        super.onAttachedToWindow();
        this.f13130h.a(this.f13140r);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1225974578, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -797548118);
        super.onDetachedFromWindow();
        this.f13130h.b(this.f13140r);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 376912071, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f13130h.b(this.f13140r);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f13130h.a(this.f13140r);
    }
}

package com.facebook.timeline.header.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.event.TimelineFriendingEvents.AddFriendClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.FriendRequestResponseClickedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.header.data.TimelineHeaderData;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetchThreadList - Groups Only */
public class PlutoniumFriendRequestView extends CustomLinearLayout implements NeedsFragmentCleanup {
    @Inject
    Provider<TimelineHeaderEventBus> f11996a;
    @Inject
    AllCapsTransformationMethod f11997b;
    private Button f11998c;
    private Button f11999d;
    public View f12000e;
    private View f12001f;
    private TextView f12002g;
    public TimelineHeaderData f12003h;
    public TimelineContext f12004i;
    private int f12005j = 0;
    private final OnClickListener f12006k = new C17281(this);
    private final OnClickListener f12007l = new C17292(this);
    private final OnClickListener f12008m = new C17303(this);

    /* compiled from: fetchThreadList - Groups Only */
    class C17281 implements OnClickListener {
        final /* synthetic */ PlutoniumFriendRequestView f11993a;

        C17281(PlutoniumFriendRequestView plutoniumFriendRequestView) {
            this.f11993a = plutoniumFriendRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1264599353);
            if (!(this.f11993a.f12003h == null || this.f11993a.f12004i == null)) {
                this.f11993a.f12000e.setVisibility(8);
                this.f11993a.f12004i;
                ((TimelineHeaderEventBus) this.f11993a.f11996a.get()).a(new FriendRequestResponseClickedEvent(this.f11993a.f12004i.b, (FriendRequestResponse) view.getTag()));
            }
            Logger.a(2, EntryType.UI_INPUT_END, 669967257, a);
        }
    }

    /* compiled from: fetchThreadList - Groups Only */
    class C17292 implements OnClickListener {
        final /* synthetic */ PlutoniumFriendRequestView f11994a;

        C17292(PlutoniumFriendRequestView plutoniumFriendRequestView) {
            this.f11994a = plutoniumFriendRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -609278424);
            this.f11994a.setVisibility(8);
            ((TimelineHeaderEventBus) this.f11994a.f11996a.get()).a(new AddFriendClickedEvent(this.f11994a.f12004i.b));
            Logger.a(2, EntryType.UI_INPUT_END, 1859594290, a);
        }
    }

    /* compiled from: fetchThreadList - Groups Only */
    class C17303 implements OnClickListener {
        final /* synthetic */ PlutoniumFriendRequestView f11995a;

        C17303(PlutoniumFriendRequestView plutoniumFriendRequestView) {
            this.f11995a = plutoniumFriendRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 151028851);
            this.f11995a.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -256911050, a);
        }
    }

    private static <T extends View> void m12033a(Class<T> cls, T t) {
        m12034a((Object) t, t.getContext());
    }

    private static void m12034a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlutoniumFriendRequestView) obj).m12035a(IdBasedSingletonScopeProvider.a(fbInjector, 11216), AllCapsTransformationMethod.b(fbInjector));
    }

    private void m12035a(Provider<TimelineHeaderEventBus> provider, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f11996a = provider;
        this.f11997b = allCapsTransformationMethod;
    }

    public PlutoniumFriendRequestView(Context context) {
        super(context);
        m12032a();
    }

    public PlutoniumFriendRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12032a();
    }

    private void m12032a() {
        m12033a(PlutoniumFriendRequestView.class, (View) this);
        setContentView(2130906334);
        this.f12002g = (TextView) a(2131566166);
        this.f12000e = a(2131566167);
        this.f11998c = (Button) a(2131566168);
        this.f11999d = (Button) a(2131566169);
        setBackgroundResource(2130839946);
        setOrientation(1);
    }

    public final boolean m12042a(TimelineHeaderData timelineHeaderData, TimelineContext timelineContext) {
        return m12043a(timelineHeaderData, timelineContext, false);
    }

    public final boolean m12043a(TimelineHeaderData timelineHeaderData, TimelineContext timelineContext, boolean z) {
        TracerDetour.a("PlutoniumFriendRequestView.bindModel", 1559052538);
        try {
            boolean b = m12038b(timelineHeaderData, timelineContext, z);
            return b;
        } finally {
            TracerDetour.a(1723418785);
        }
    }

    private boolean m12038b(TimelineHeaderData timelineHeaderData, TimelineContext timelineContext, boolean z) {
        if (timelineHeaderData == null || timelineContext == null) {
            m12040d();
            return false;
        }
        boolean z2 = (this.f12003h == timelineHeaderData && this.f12004i == timelineContext) ? false : true;
        if (!z2 && this.f12005j >= this.f12003h.d) {
            return false;
        }
        this.f12003h = timelineHeaderData;
        this.f12004i = timelineContext;
        if (this.f12001f != null) {
            this.f12001f.setVisibility(8);
        }
        this.f12000e.setVisibility(0);
        setVisibility(0);
        if (z) {
            this.f12002g.setText(2131241360);
            this.f11998c.setText(m12031a(2131233212, this.f11998c));
            this.f11998c.setOnClickListener(this.f12007l);
            this.f11999d.setText(m12031a(2131230727, this.f11999d));
            this.f11999d.setOnClickListener(this.f12008m);
        } else {
            this.f12002g.setText(2131234977);
            this.f11998c.setText(2131234862);
            this.f11998c.setTag(FriendRequestResponse.CONFIRM);
            this.f11998c.setOnClickListener(this.f12006k);
            this.f11999d.setText(2131234926);
            this.f11999d.setTag(FriendRequestResponse.REJECT);
            this.f11999d.setOnClickListener(this.f12006k);
        }
        this.f12005j = this.f12003h.d;
        return true;
    }

    public final void m12044c() {
        this.f12003h = null;
        this.f12004i = null;
        this.f12005j = 0;
    }

    public static void m12037b(PlutoniumFriendRequestView plutoniumFriendRequestView) {
        if (plutoniumFriendRequestView.f12001f == null) {
            plutoniumFriendRequestView.f12001f = ((ViewStub) plutoniumFriendRequestView.findViewById(2131566170)).inflate();
            int dimensionPixelSize = plutoniumFriendRequestView.getResources().getDimensionPixelSize(2131429857);
            int dimensionPixelSize2 = plutoniumFriendRequestView.getResources().getDimensionPixelSize(2131429852);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.setMargins(0, dimensionPixelSize2, 0, dimensionPixelSize2);
            layoutParams.gravity = 17;
            plutoniumFriendRequestView.f12001f.setLayoutParams(layoutParams);
            return;
        }
        plutoniumFriendRequestView.f12001f.setVisibility(0);
    }

    private void m12040d() {
        setVisibility(8);
    }

    private CharSequence m12031a(int i, View view) {
        return this.f11997b.getTransformation(getResources().getString(i), view);
    }
}

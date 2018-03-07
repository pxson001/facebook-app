package com.facebook.groups.memberlist.memberrow;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.groups.memberlist.GroupMemberListMemberItem;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.AdminState;
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.facebook.groups.widget.remotepogview.RemotePogView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.animations.HeightAnimation;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: f2548049aa2fb5c42e73eefe148fdbca */
public class GroupMemberRow extends CustomFrameLayout {
    @Inject
    public Locales f14447a;
    @Inject
    public Resources f14448b;
    @Inject
    public TimeFormatUtil f14449c;
    @Inject
    @LoggedInUserId
    public String f14450d;
    public RemotePogView f14451e = ((RemotePogView) c(2131563784));
    public BetterTextView f14452f = ((BetterTextView) c(2131563787));
    public BetterTextView f14453g = ((BetterTextView) c(2131563785));
    public View f14454h = c(2131563786);
    public HeightAnimation f14455i;
    public String f14456j;
    public GroupsMemberRowListener f14457k;

    /* compiled from: f2548049aa2fb5c42e73eefe148fdbca */
    public interface GroupsMemberRowListener {
        void mo842a(View view, GroupMemberListMemberItem groupMemberListMemberItem);
    }

    /* compiled from: f2548049aa2fb5c42e73eefe148fdbca */
    public class C15792 implements AnimationListener {
        final /* synthetic */ GroupMemberRow f14446a;

        public C15792(GroupMemberRow groupMemberRow) {
            this.f14446a = groupMemberRow;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f14446a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static void m15981a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupMemberRow groupMemberRow = (GroupMemberRow) obj;
        Locales a = Locales.a(fbInjector);
        Resources a2 = ResourcesMethodAutoProvider.a(fbInjector);
        TimeFormatUtil timeFormatUtil = (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector);
        String b = String_LoggedInUserIdMethodAutoProvider.b(fbInjector);
        groupMemberRow.f14447a = a;
        groupMemberRow.f14448b = a2;
        groupMemberRow.f14449c = timeFormatUtil;
        groupMemberRow.f14450d = b;
    }

    public GroupMemberRow(Context context, GroupsMemberRowListener groupsMemberRowListener) {
        super(context);
        this.f14457k = groupsMemberRowListener;
        Class cls = GroupMemberRow.class;
        m15981a(this, getContext());
        setContentView(2130905203);
    }

    public final void m15983a(final GroupMemberListMemberItem groupMemberListMemberItem, boolean z, AdminState adminState, boolean z2, boolean z3, boolean z4) {
        GroupMemberData groupMemberData = groupMemberListMemberItem.f14272d;
        this.f14456j = groupMemberData.b();
        if (!z2 || (!z4 && groupMemberListMemberItem.m15883a(this.f14450d) && groupMemberListMemberItem.m15887g())) {
            this.f14454h.setVisibility(0);
            this.f14454h.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ GroupMemberRow f14445b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1017486813);
                    this.f14445b.f14457k.mo842a(view, groupMemberListMemberItem);
                    Logger.a(2, EntryType.UI_INPUT_END, -1100694037, a);
                }
            });
        } else {
            this.f14454h.setVisibility(8);
        }
        if (!(z3 || getAnimation() == null)) {
            clearAnimation();
        }
        if (z3) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        if (!z3) {
            this.f14451e.a(groupMemberData.g() != null ? groupMemberData.g().a() : null, groupMemberData.d() != null ? groupMemberData.d().a() : false);
            this.f14452f.setText(groupMemberData.he_());
            if (groupMemberListMemberItem.f14273e == null) {
                this.f14453g.setVisibility(8);
            } else {
                this.f14453g.setVisibility(0);
                String toLowerCase = this.f14449c.a(TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE, groupMemberListMemberItem.f14273e.m15806c() * 1000).toLowerCase(this.f14447a.a());
                if (this.f14456j.equals(groupMemberListMemberItem.f14273e.f14223b)) {
                    this.f14453g.setText(this.f14448b.getString(2131239430, new Object[]{toLowerCase}));
                } else {
                    int i;
                    BetterTextView betterTextView = this.f14453g;
                    Resources resources = this.f14448b;
                    if (groupMemberListMemberItem.m15887g()) {
                        i = 2131239432;
                    } else {
                        i = 2131239431;
                    }
                    betterTextView.setText(resources.getString(i, new Object[]{groupMemberListMemberItem.f14273e.f14222a, toLowerCase}));
                }
            }
            BetterTextView betterTextView2 = (BetterTextView) c(2131563788);
            if (!z) {
                betterTextView2.setVisibility(8);
            } else if (AdminState.MODERATOR == adminState) {
                betterTextView2.setVisibility(0);
                betterTextView2.setText(this.f14448b.getString(2131239429));
            } else if (AdminState.ADMIN == adminState) {
                betterTextView2.setVisibility(0);
                betterTextView2.setText(this.f14448b.getString(2131239428));
            } else {
                betterTextView2.setVisibility(8);
            }
        }
    }

    public final void m15982a() {
        HeightAnimation heightAnimation;
        if (this.f14455i != null) {
            heightAnimation = this.f14455i;
        } else {
            this.f14455i = new HeightAnimation(this, 0);
            this.f14455i.setDuration(200);
            this.f14455i.setAnimationListener(new C15792(this));
            heightAnimation = this.f14455i;
        }
        startAnimation(heightAnimation);
    }

    protected void onMeasure(int i, int i2) {
        if (8 == getVisibility()) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }
}

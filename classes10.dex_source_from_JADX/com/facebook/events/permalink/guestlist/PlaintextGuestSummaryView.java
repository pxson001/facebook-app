package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.events.graphql.EventsGraphQLInterfaces.UserInEventFragment;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.resources.ui.FbTextView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: boarding_pass_bubble */
public class PlaintextGuestSummaryView extends FbTextView {
    @VisibleForTesting
    protected String f18517a;
    @VisibleForTesting
    protected String f18518b;

    public PlaintextGuestSummaryView(Context context) {
        super(context);
    }

    public PlaintextGuestSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlaintextGuestSummaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m18860a(GraphQLEventGuestStatus graphQLEventGuestStatus, ImmutableList<UserInEventFragment> immutableList, int i, ImmutableList<UserInEventFragment> immutableList2, int i2) {
        m18857c();
        if (i > 0) {
            m18853a(immutableList, i);
        } else if (i2 > 0) {
            m18855b(immutableList2, i2);
        } else {
            setUserOnlySummary(graphQLEventGuestStatus);
        }
        m18852a();
    }

    public void setDefaultText(String str) {
        this.f18518b = str;
        m18852a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m18852a();
    }

    private void m18852a() {
        setVisibility(8);
        if (m18856b()) {
            m18854a(this.f18517a);
        } else {
            m18854a(this.f18518b);
        }
    }

    private boolean m18856b() {
        return !Strings.isNullOrEmpty(this.f18517a) && getPaint().measureText(this.f18517a) < ((float) getWidth());
    }

    private void m18854a(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            setVisibility(0);
            setText(str);
        }
    }

    private void m18857c() {
        this.f18517a = null;
        this.f18518b = null;
    }

    private void m18853a(ImmutableList<UserInEventFragment> immutableList, int i) {
        m18858c(immutableList, i);
        setGoingShortSummary(i);
    }

    private void m18855b(ImmutableList<UserInEventFragment> immutableList, int i) {
        m18859d(immutableList, i);
        setMaybeShortSummary(i);
    }

    private void m18858c(ImmutableList<UserInEventFragment> immutableList, int i) {
        if (immutableList.size() == 1) {
            this.f18517a = getContext().getString(2131237073, new Object[]{((UserInEventFragment) immutableList.get(0)).c()});
        } else if (immutableList.size() == 2) {
            this.f18517a = getContext().getString(2131237074, new Object[]{((UserInEventFragment) immutableList.get(0)).c(), ((UserInEventFragment) immutableList.get(1)).c()});
        } else if (immutableList.size() > 2) {
            this.f18517a = getContext().getResources().getQuantityString(2131689666, immutableList.size() - 2, new Object[]{((UserInEventFragment) immutableList.get(0)).c(), ((UserInEventFragment) immutableList.get(1)).c(), Integer.valueOf(i - 2)});
        }
    }

    private void m18859d(ImmutableList<UserInEventFragment> immutableList, int i) {
        if (immutableList.size() == 1) {
            this.f18517a = getContext().getString(2131237075, new Object[]{((UserInEventFragment) immutableList.get(0)).c()});
        } else if (immutableList.size() == 2) {
            this.f18517a = getContext().getString(2131237076, new Object[]{((UserInEventFragment) immutableList.get(0)).c(), ((UserInEventFragment) immutableList.get(1)).c()});
        } else if (immutableList.size() > 2) {
            this.f18517a = getContext().getResources().getQuantityString(2131689668, immutableList.size() - 2, new Object[]{((UserInEventFragment) immutableList.get(0)).c(), ((UserInEventFragment) immutableList.get(1)).c(), Integer.valueOf(i - 2)});
        }
    }

    private void setGoingShortSummary(int i) {
        if (i > 0) {
            this.f18518b = getContext().getResources().getQuantityString(2131689667, i, new Object[]{Integer.valueOf(i)});
        }
    }

    private void setMaybeShortSummary(int i) {
        if (i > 0) {
            this.f18518b = getContext().getResources().getQuantityString(2131689669, i, new Object[]{Integer.valueOf(i)});
        }
    }

    private void setUserOnlySummary(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            this.f18517a = getContext().getString(2131237071);
        } else if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            this.f18517a = getContext().getString(2131237072);
        }
    }
}

package com.facebook.groups.widget.membersbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.R;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groups.widget.memberrow.protocol.MemberDataInterfaces.GroupMemberData;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataModels.MembersBarDataModel;
import com.facebook.groups.widget.membersbar.protocol.MembersBarDataModels.MembersBarDataModel.EdgesModel;
import com.facebook.groups.widget.remotepogview.RemotePogView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: primary_message */
public class MembersBarView extends CustomRelativeLayout {
    @Inject
    Resources f6038a;
    @Inject
    @LoggedInUserId
    String f6039b;
    private boolean f6040c = false;
    private boolean f6041d = false;
    private int f6042e = 12;
    private MembersBarDataModel f6043f;
    private GraphQLGroupJoinState f6044g = GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    private MemberBarSelectionListener f6045h;
    private int f6046i;
    private ExtraPogView f6047j;
    private ExtraPogView f6048k;
    private SegmentedLinearLayout f6049l;
    private int f6050m;
    private boolean f6051n;

    /* compiled from: primary_message */
    class C05441 implements OnClickListener {
        final /* synthetic */ MembersBarView f6037a;

        C05441(MembersBarView membersBarView) {
            this.f6037a = membersBarView;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -1951461782, Logger.a(2, EntryType.UI_INPUT_START, 1976064269));
        }
    }

    private static <T extends View> void m7828a(Class<T> cls, T t) {
        m7829a((Object) t, t.getContext());
    }

    private static void m7829a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MembersBarView) obj).m7826a(ResourcesMethodAutoProvider.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector));
    }

    public MembersBarView(Context context) {
        super(context);
        m7827a(null);
    }

    public MembersBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7827a(attributeSet);
    }

    protected MembersBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7827a(attributeSet);
    }

    public void setCircleSize(int i) {
        this.f6046i = i;
    }

    public void setPaddingBetweenPogs(int i) {
        this.f6050m = i;
    }

    public void setShowPresenceIconState(boolean z) {
        this.f6051n = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m7825a();
        super.onMeasure(i, i2);
    }

    private void m7827a(AttributeSet attributeSet) {
        m7828a(MembersBarView.class, (View) this);
        setWillNotDraw(false);
        setContentView(2130905204);
        this.f6049l = (SegmentedLinearLayout) a(2131563789);
        this.f6046i = this.f6038a.getDimensionPixelSize(2131432015);
        this.f6051n = true;
        setContentDescription(this.f6038a.getString(2131237943));
        setOnClickListener(new C05441(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MemberBarAttrs);
            if (obtainStyledAttributes != null) {
                this.f6041d = obtainStyledAttributes.getBoolean(1, false);
                this.f6040c = obtainStyledAttributes.getBoolean(0, false);
                this.f6042e = obtainStyledAttributes.getInteger(2, this.f6042e);
                this.f6050m = obtainStyledAttributes.getDimensionPixelSize(3, this.f6038a.getDimensionPixelOffset(2131432021));
                this.f6049l.setSegmentedDividerThickness(this.f6050m);
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void m7826a(Resources resources, String str) {
        this.f6038a = resources;
        this.f6039b = str;
    }

    private void m7825a() {
        int measuredWidth = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        int segmentedDividerThickness = this.f6046i + this.f6049l.getSegmentedDividerThickness();
        int i = measuredWidth / segmentedDividerThickness;
        if ((segmentedDividerThickness * i) + this.f6046i <= measuredWidth) {
            measuredWidth = i + 1;
        } else {
            measuredWidth = i;
        }
        if (!(this.f6043f == null || this.f6043f.m7843b() == null || measuredWidth <= 2)) {
            GroupMemberData a;
            Object obj;
            ArrayList a2 = Lists.a();
            ImmutableList b = this.f6043f.m7843b();
            int i2 = 0;
            GroupMemberData groupMemberData = null;
            while (i2 < b.size()) {
                a = ((EdgesModel) b.get(i2)).m7836a();
                if (!a.mo334b().equals(this.f6039b)) {
                    a2.add(a);
                    a = groupMemberData;
                }
                i2++;
                groupMemberData = a;
            }
            if (groupMemberData != null) {
                a2.add(groupMemberData);
            }
            Object obj2 = this.f6044g == GraphQLGroupJoinState.MEMBER ? 1 : null;
            i = Math.min(measuredWidth, this.f6042e);
            if (obj2 != null && this.f6040c) {
                i--;
            }
            if (this.f6043f.m7839a() > i) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && this.f6041d) {
                i--;
            }
            int min = Math.min(i, a2.size());
            if (this.f6047j != null) {
                removeView(this.f6047j);
            }
            if (this.f6048k != null) {
                this.f6049l.removeView(this.f6048k);
            }
            while (this.f6049l.getChildCount() > min) {
                this.f6049l.removeViewAt(this.f6049l.getChildCount() - 1);
            }
            for (int i3 = 0; i3 < min; i3++) {
                RemotePogView remotePogView;
                String a3;
                a = (GroupMemberData) a2.get(i3);
                if (this.f6049l.getChildCount() > i3) {
                    remotePogView = (RemotePogView) this.f6049l.getChildAt(i3);
                } else {
                    i2 = this.f6046i;
                    remotePogView = new RemotePogView(getContext(), getResources().getColor(2131363564), getResources().getDimensionPixelSize(2131432114));
                    remotePogView.setPogSize(i2);
                    this.f6049l.addView(remotePogView);
                }
                if (a.mo337g() != null) {
                    a3 = a.mo337g().m7802a();
                } else {
                    a3 = null;
                }
                if (this.f6051n) {
                    boolean a4;
                    if (a.mo336d() != null) {
                        a4 = a.mo336d().m7797a();
                    } else {
                        a4 = false;
                    }
                    remotePogView.m7862a(a3, a4);
                } else {
                    remotePogView.m7862a(a3, this.f6051n);
                }
            }
            if (obj != null && this.f6041d) {
                if (this.f6048k == null) {
                    this.f6048k = new ExtraPogView(getContext(), this.f6045h);
                }
                this.f6049l.addView(this.f6048k);
                this.f6048k.setTypeShowCount(this.f6043f.m7839a() - min);
            }
            if (obj2 != null && this.f6040c) {
                if (this.f6047j == null) {
                    this.f6047j = new ExtraPogView(getContext(), this.f6045h);
                    this.f6047j.setId(2131558752);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    this.f6047j.setLayoutParams(layoutParams);
                }
                addView(this.f6047j);
                this.f6047j.setContentDescription(this.f6038a.getString(2131237944));
                this.f6047j.m7824a();
            }
        }
        this.f6049l.setSegmentedDividerThickness(this.f6050m);
    }
}

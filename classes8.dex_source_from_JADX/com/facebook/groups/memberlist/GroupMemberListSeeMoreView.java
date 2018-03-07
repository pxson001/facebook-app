package com.facebook.groups.memberlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.memberlist.GroupMemberListMemberItem.MemberSection;
import com.facebook.groups.members.GroupMemberBaseListLoader.MemberListLoaderListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: extras_has_faces_detected */
public class GroupMemberListSeeMoreView extends CustomFrameLayout {
    public final BetterTextView f14281a;
    public final ProgressBar f14282b;

    /* compiled from: extras_has_faces_detected */
    public interface MemberListSeeMoreListener {
        void mo843a(MemberSection memberSection, MemberListLoaderListener memberListLoaderListener);
    }

    /* compiled from: extras_has_faces_detected */
    public class C15461 implements OnClickListener {
        final /* synthetic */ MemberListSeeMoreListener f14278a;
        final /* synthetic */ MemberSection f14279b;
        final /* synthetic */ GroupMemberListSeeMoreView f14280c;

        /* compiled from: extras_has_faces_detected */
        class C15451 implements MemberListLoaderListener {
            final /* synthetic */ C15461 f14277a;

            C15451(C15461 c15461) {
                this.f14277a = c15461;
            }

            public final void m15889a(ImmutableList immutableList, GraphQLGroupVisibility graphQLGroupVisibility) {
            }

            public final void m15890a(boolean z) {
                if (z) {
                    this.f14277a.f14280c.f14281a.setVisibility(8);
                    this.f14277a.f14280c.f14282b.setVisibility(0);
                    return;
                }
                this.f14277a.f14280c.f14281a.setText(this.f14277a.f14280c.getResources().getString(2131239496));
                this.f14277a.f14280c.f14282b.setVisibility(8);
            }
        }

        public C15461(GroupMemberListSeeMoreView groupMemberListSeeMoreView, MemberListSeeMoreListener memberListSeeMoreListener, MemberSection memberSection) {
            this.f14280c = groupMemberListSeeMoreView;
            this.f14278a = memberListSeeMoreListener;
            this.f14279b = memberSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1557465078);
            this.f14278a.mo843a(this.f14279b, new C15451(this));
            Logger.a(2, EntryType.UI_INPUT_END, 1332606913, a);
        }
    }

    public GroupMemberListSeeMoreView(Context context) {
        this(context, null);
    }

    private GroupMemberListSeeMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904679);
        this.f14281a = (BetterTextView) findViewById(2131562704);
        this.f14282b = (ProgressBar) findViewById(2131562705);
    }
}

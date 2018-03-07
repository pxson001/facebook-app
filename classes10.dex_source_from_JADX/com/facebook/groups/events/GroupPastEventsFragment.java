package com.facebook.groups.events;

import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.groups.events.GroupEventsBaseFragment.GroupEventsFragmentViewFactory;
import com.facebook.groups.events.view.DefaultGroupEventsViewFactory;

/* compiled from: UNUSED_SESSIONS */
public class GroupPastEventsFragment extends GroupEventsBaseFragment {

    /* compiled from: UNUSED_SESSIONS */
    class C31291 implements GroupEventsFragmentViewFactory {
        final /* synthetic */ GroupPastEventsFragment f21867a;

        C31291(GroupPastEventsFragment groupPastEventsFragment) {
            this.f21867a = groupPastEventsFragment;
        }

        public final int mo963a() {
            return 2130904683;
        }

        public final int mo964b() {
            return 2131562709;
        }

        public final int mo965c() {
            return 2131562708;
        }

        public final int mo966d() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21867a.f21822f;
            return 2130904256;
        }

        public final int mo967e() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21867a.f21822f;
            return 2131561808;
        }

        public final int mo968f() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21867a.f21822f;
            return 2131561809;
        }

        public final int mo969g() {
            return 2131242096;
        }

        public final int mo970h() {
            return 2131242097;
        }
    }

    protected final GroupEventsFragmentViewFactory mo971b() {
        return new C31291(this);
    }

    protected final TimeframeInputTimeframe mo972e() {
        return TimeframeInputTimeframe.PAST;
    }
}

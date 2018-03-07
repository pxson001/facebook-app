package com.facebook.groups.events;

import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.groups.events.GroupEventsBaseFragment.GroupEventsFragmentViewFactory;
import com.facebook.groups.events.view.DefaultGroupEventsViewFactory;

/* compiled from: UNSEEN_SECTION */
public class GroupUpcomingEventsFragment extends GroupEventsBaseFragment {

    /* compiled from: UNSEEN_SECTION */
    class C31301 implements GroupEventsFragmentViewFactory {
        final /* synthetic */ GroupUpcomingEventsFragment f21868a;

        C31301(GroupUpcomingEventsFragment groupUpcomingEventsFragment) {
            this.f21868a = groupUpcomingEventsFragment;
        }

        public final int mo963a() {
            return 2130904699;
        }

        public final int mo964b() {
            return 2131562741;
        }

        public final int mo965c() {
            return 2131562740;
        }

        public final int mo966d() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21868a.f21822f;
            return 2130904258;
        }

        public final int mo967e() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21868a.f21822f;
            return 2131561810;
        }

        public final int mo968f() {
            DefaultGroupEventsViewFactory defaultGroupEventsViewFactory = this.f21868a.f21822f;
            return 2131561811;
        }

        public final int mo969g() {
            return 2131242095;
        }

        public final int mo970h() {
            return 2131242097;
        }
    }

    protected final GroupEventsFragmentViewFactory mo971b() {
        return new C31301(this);
    }

    protected final TimeframeInputTimeframe mo972e() {
        return TimeframeInputTimeframe.FUTURE;
    }
}

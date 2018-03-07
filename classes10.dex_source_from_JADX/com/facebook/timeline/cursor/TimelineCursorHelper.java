package com.facebook.timeline.cursor;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.ultralight.Inject;

/* compiled from: group_friend_count */
public class TimelineCursorHelper {
    private final QeAccessor f10388a;

    public static TimelineCursorHelper m10500a(InjectorLike injectorLike) {
        return new TimelineCursorHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineCursorHelper(QeAccessor qeAccessor) {
        this.f10388a = qeAccessor;
    }

    public final boolean m10502a(TimelineContext timelineContext) {
        if (timelineContext.i()) {
            return this.f10388a.a(ExperimentsForTimelineAbTestModule.bb, false);
        }
        return false;
    }

    public static String m10501b(TimelineContext timelineContext) {
        return StringFormatUtil.a("timeline_stories/%s?v=4", new Object[]{Long.valueOf(timelineContext.b)});
    }
}

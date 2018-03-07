package com.facebook.timeline.header.editphotohelper;

import android.os.Handler;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.time.Clock;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.inject.Assisted;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Supplier;
import javax.inject.Inject;

/* compiled from: upload_success_ratio */
public class ProfilePictureActionFlowLauncher {
    public final Supplier<TimelineEditPhotoHelper> f831a;
    @ForUiThread
    private final Handler f832b;
    public final Clock f833c;

    @Inject
    public ProfilePictureActionFlowLauncher(@Assisted Supplier<TimelineEditPhotoHelper> supplier, Handler handler, Clock clock) {
        this.f831a = supplier;
        this.f832b = handler;
        this.f833c = clock;
    }

    public final void m876a(final GraphQLProfilePictureActionLinkType graphQLProfilePictureActionLinkType) {
        HandlerDetour.b(this.f832b, new Runnable(this) {
            final /* synthetic */ ProfilePictureActionFlowLauncher f830b;

            public void run() {
                long a;
                ProfilePictureActionFlowLauncher profilePictureActionFlowLauncher = this.f830b;
                if (graphQLProfilePictureActionLinkType == GraphQLProfilePictureActionLinkType.TEMPORARY) {
                    a = (profilePictureActionFlowLauncher.f833c.a() + 86400000) / 1000;
                } else {
                    a = 0;
                }
                ((TimelineEditPhotoHelper) this.f830b.f831a.get()).m883a(new ExpirationState(true, a));
            }
        }, 1000, -1081192196);
    }
}

package com.facebook.timeline.protiles.model;

import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLInterfaces.TimelinePromptApproximateCountFields;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptFieldsModel;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptModel;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* compiled from: feedDialogActionExecutorStatus */
public class TimelinePromptSource {
    public static final Function<TimelinePromptModel, TimelinePromptSource> f12120a = new C17341();
    public static final String f12121g = StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.TIMELINE_PENDING_REQUESTS_PROMPT.name(), FriendsCenterTabType.REQUESTS.name());
    public final Optional<TimelinePromptApproximateCountFields> f12122b;
    public final Optional<Bundle> f12123c;
    public final String f12124d;
    public final String f12125e;
    public final boolean f12126f;

    /* compiled from: feedDialogActionExecutorStatus */
    final class C17341 implements Function<TimelinePromptModel, TimelinePromptSource> {
        C17341() {
        }

        public final Object apply(Object obj) {
            TimelinePromptFieldsModel a = ((TimelinePromptModel) obj).a();
            return new TimelinePromptSource(Optional.of(a.a()), Absent.INSTANCE, a.b(), a.c(), true);
        }
    }

    public TimelinePromptSource(Optional<TimelinePromptApproximateCountFields> optional, Optional<Bundle> optional2, String str, String str2, boolean z) {
        this.f12122b = (Optional) Preconditions.checkNotNull(optional);
        this.f12123c = optional2;
        this.f12124d = str;
        this.f12125e = str2;
        this.f12126f = z;
    }
}

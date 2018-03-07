package com.facebook.composer.ui.publishmode;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.ui.publishmode.SchedulePostController.SchedulePostControllerHost;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nonnull;

/* compiled from: composer_content_search */
public class SchedulePostControllerProvider extends AbstractAssistedProvider<SchedulePostController> {
    public final SchedulePostController m21040a(@Nonnull SchedulePostControllerHost schedulePostControllerHost, Long l) {
        return new SchedulePostController(schedulePostControllerHost, l, Toaster.b(this), (Clock) SystemClockMethodAutoProvider.a(this), (Context) getInstance(Context.class), PublishModeTitleGenerator.m21032b((InjectorLike) this));
    }
}

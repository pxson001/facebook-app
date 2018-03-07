package com.facebook.events.dashboard;

import android.app.Activity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: completionGesture */
public class EventsDashboardBirthdaysComposerController {
    public final ComposerLauncher f16546a;
    public final BirthdayReminderLogger f16547b;

    public static EventsDashboardBirthdaysComposerController m16958b(InjectorLike injectorLike) {
        return new EventsDashboardBirthdaysComposerController((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), BirthdayReminderLogger.m18107a(injectorLike));
    }

    @Inject
    public EventsDashboardBirthdaysComposerController(ComposerLauncher composerLauncher, BirthdayReminderLogger birthdayReminderLogger) {
        this.f16546a = composerLauncher;
        this.f16547b = birthdayReminderLogger;
    }

    public final void m16959a(String str, String str2, String str3, boolean z, Activity activity) {
        ComposerConfiguration a = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventDashboardCelebrationsFromReact").setInitialTargetData(m16957a(str, str2, str3, null)).setIsFireAndForget(true).setAllowsRedSpaceToggle(true).setReactionSurface(Surface.ANDROID_EVENTS_DASHBOARD_COMPOSER).a();
        this.f16546a.a(this.f16547b.m18113a(z, SafeUUIDGenerator.a().toString()), a, activity);
    }

    public static ComposerTargetData m16956a(EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel) {
        return m16957a(eventUserWithBirthdayFragmentModel.m(), eventUserWithBirthdayFragmentModel.n(), eventUserWithBirthdayFragmentModel.p() == null ? null : eventUserWithBirthdayFragmentModel.p().b(), eventUserWithBirthdayFragmentModel.o());
    }

    private static ComposerTargetData m16957a(String str, String str2, String str3, @Nullable ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        Builder builder = new Builder(Long.parseLong(str), TargetType.USER);
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        builder = builder;
        if (composerTargetDataPrivacyScopeFields != null) {
            builder.a(composerTargetDataPrivacyScopeFields);
        }
        return builder.a();
    }
}

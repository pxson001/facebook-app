package com.facebook.events.permalink.calltoaction;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsModelConversionHelper;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLInlineActivity;
import com.facebook.graphql.model.GraphQLInlineActivity.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: button0Url */
public class EventCheckinButtonController {
    public static final String f18290a = EventCheckinButtonController.class.getSimpleName();
    public final AbstractFbErrorReporter f18291b;
    private final ComposerLauncher f18292c;
    private final EventEventLogger f18293d;
    @Nullable
    private OnClickListener f18294e;
    @Nullable
    public FetchEventPermalinkFragmentModel f18295f;
    @Nullable
    public ProgressDialogFragment f18296g;
    public boolean f18297h;
    private boolean f18298i;

    /* compiled from: button0Url */
    class C25891 implements OnClickListener {
        final /* synthetic */ EventCheckinButtonController f18287a;

        C25891(EventCheckinButtonController eventCheckinButtonController) {
            this.f18287a = eventCheckinButtonController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1744201334);
            EventCheckinButtonController.m18642a(this.f18287a, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1236235473, a);
        }
    }

    /* compiled from: button0Url */
    public class C25902 implements OnDismissListener {
        final /* synthetic */ EventCheckinButtonController f18288a;

        public C25902(EventCheckinButtonController eventCheckinButtonController) {
            this.f18288a = eventCheckinButtonController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f18288a.f18296g = null;
        }
    }

    /* compiled from: button0Url */
    public class C25913 implements OnCancelListener {
        final /* synthetic */ EventCheckinButtonController f18289a;

        public C25913(EventCheckinButtonController eventCheckinButtonController) {
            this.f18289a = eventCheckinButtonController;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f18289a.f18296g = null;
        }
    }

    public static EventCheckinButtonController m18641a(InjectorLike injectorLike) {
        return new EventCheckinButtonController((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), EventEventLogger.m18119b(injectorLike));
    }

    @Inject
    public EventCheckinButtonController(AbstractFbErrorReporter abstractFbErrorReporter, ComposerLauncher composerLauncher, EventEventLogger eventEventLogger) {
        this.f18291b = abstractFbErrorReporter;
        this.f18292c = composerLauncher;
        this.f18293d = eventEventLogger;
    }

    public final void m18643a(View view, Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, boolean z) {
        if (!this.f18298i) {
            EventEventLogger eventEventLogger = this.f18293d;
            String str = event.a;
            String actionMechanism = ActionMechanism.HEADER.toString();
            HoneyClientEventFast a = eventEventLogger.f17787i.a("event_checkin_button_impression", false);
            if (a.a()) {
                a.a("event_permalink");
                a.d(eventEventLogger.f17788j.b(eventEventLogger.f17785g));
                a.b("Event");
                a.c(str);
                a.a("action_mechanism", actionMechanism);
                a.a("event_id", str);
                a.b();
            }
            this.f18298i = true;
        }
        this.f18295f = fetchEventPermalinkFragmentModel;
        this.f18297h = z;
        if (this.f18296g != null && this.f18296g.an()) {
            Preconditions.checkNotNull(this.f18296g);
            if (this.f18297h) {
                this.f18296g.a();
            }
            if (this.f18295f != null) {
                this.f18296g.a();
                m18642a(this, this.f18296g.getContext());
            }
        }
        if (this.f18294e == null) {
            this.f18294e = new C25891(this);
        }
        view.setOnClickListener(this.f18294e);
    }

    public static void m18642a(EventCheckinButtonController eventCheckinButtonController, Context context) {
        if (eventCheckinButtonController.f18295f != null) {
            GraphQLInlineActivity a = EventsModelConversionHelper.a(eventCheckinButtonController.f18295f.ae());
            Builder builder = new Builder();
            a.h();
            builder.d = a.j();
            builder.e = a.k();
            builder.f = a.l();
            builder.g = a.m();
            builder.h = a.n();
            BaseModel.Builder.a(builder, a);
            Builder builder2 = builder;
            GraphQLNode.Builder builder3 = new GraphQLNode.Builder();
            builder3.dK = eventCheckinButtonController.f18295f.dL_();
            builder3 = builder3;
            builder3.fw = eventCheckinButtonController.f18295f.dM_();
            builder3 = builder3;
            GraphQLStoryAttachment.Builder builder4 = new GraphQLStoryAttachment.Builder();
            builder4.q = ImmutableList.of(GraphQLStoryAttachmentStyle.EVENT);
            builder4 = builder4;
            GraphQLNode.Builder builder5 = new GraphQLNode.Builder();
            builder5.dK = eventCheckinButtonController.f18295f.dL_();
            builder4.t = builder5.a();
            builder3.fD = builder4.a();
            builder2.e = builder3.a();
            a = builder2.a();
            MinutiaeObject a2 = MinutiaeObject.a(a, a.k().eS());
            if (a2 == null) {
                eventCheckinButtonController.f18291b.a(f18290a, "Failed to create an inline activity model for an event");
                return;
            }
            ComposerConfiguration a3 = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventMinutiaePrefilled").setInitialTargetData(ComposerTargetData.a).setMinutiaeObjectTag(a2).a();
            String uuid = SafeUUIDGenerator.a().toString();
            eventCheckinButtonController.f18292c.a(uuid, a3, 504, (Activity) ContextUtils.a(context, Activity.class));
            EventEventLogger eventEventLogger = eventCheckinButtonController.f18293d;
            String dL_ = eventCheckinButtonController.f18295f.dL_();
            String actionMechanism = ActionMechanism.HEADER.toString();
            HoneyClientEventFast a4 = eventEventLogger.f17787i.a("event_checkin_button_click", false);
            if (a4.a()) {
                a4.a("event_permalink");
                a4.d(eventEventLogger.f17788j.b(eventEventLogger.f17785g));
                a4.b("Event");
                a4.c(dL_);
                a4.a("action_mechanism", actionMechanism);
                a4.a("composer_session_id", uuid);
                a4.a("event_id", dL_);
                a4.b();
            }
        } else if (!eventCheckinButtonController.f18297h) {
            FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(context, FragmentActivity.class);
            if (fragmentActivity == null) {
                AbstractFbErrorReporter abstractFbErrorReporter = eventCheckinButtonController.f18291b;
                SoftErrorBuilder a5 = SoftError.a(f18290a, "Failed to find a fragment activity");
                a5.d = true;
                abstractFbErrorReporter.a(a5.g());
                return;
            }
            eventCheckinButtonController.f18296g = (ProgressDialogFragment) ProgressDialogFragment.a(2131237226, true, true);
            eventCheckinButtonController.f18296g.a(new C25902(eventCheckinButtonController));
            eventCheckinButtonController.f18296g.a(new C25913(eventCheckinButtonController));
            eventCheckinButtonController.f18296g.a(fragmentActivity.kO_(), "checkinDialog");
        }
    }
}

package com.facebook.events.permalink.actionbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.model.Event;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: calling_package_key */
public class ActionItemPromoteEvent {
    public static final String f17990a = ActionItemPromoteEvent.class.getSimpleName();
    private final SecureContextHelper f17991b;
    public final AbstractFbErrorReporter f17992c;
    public final Context f17993d;
    @Nullable
    private BoostableStoryModel f17994e;
    @Nullable
    private Event f17995f;
    @Nullable
    public ProgressDialogFragment f17996g;

    /* compiled from: calling_package_key */
    public class C25471 implements OnDismissListener {
        final /* synthetic */ ActionItemPromoteEvent f17988a;

        public C25471(ActionItemPromoteEvent actionItemPromoteEvent) {
            this.f17988a = actionItemPromoteEvent;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f17988a.f17996g = null;
        }
    }

    /* compiled from: calling_package_key */
    public class C25482 implements OnCancelListener {
        final /* synthetic */ ActionItemPromoteEvent f17989a;

        public C25482(ActionItemPromoteEvent actionItemPromoteEvent) {
            this.f17989a = actionItemPromoteEvent;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f17989a.f17996g = null;
        }
    }

    public static ActionItemPromoteEvent m18376a(InjectorLike injectorLike) {
        return new ActionItemPromoteEvent((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ActionItemPromoteEvent(SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter, Context context) {
        this.f17991b = secureContextHelper;
        this.f17992c = abstractFbErrorReporter;
        this.f17993d = context;
    }

    public final void m18381a(Event event) {
        this.f17995f = event;
        m18378c();
    }

    public final void m18380a(BoostableStoryModel boostableStoryModel) {
        this.f17994e = boostableStoryModel;
        m18378c();
    }

    public final void m18379a() {
        if (m18377b()) {
            Intent a = AdInterfacesIntentUtil.a(this.f17993d, 2131233995, this.f17995f.a, this.f17994e.m17688b(), this.f17994e.m17689c(), this.f17995f.v, "event");
            if (a != null) {
                this.f17991b.a(a, this.f17993d);
                return;
            }
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(this.f17993d, FragmentActivity.class);
        if (fragmentActivity == null) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17992c;
            SoftErrorBuilder a2 = SoftError.a(f17990a, "Failed to find a fragment activity");
            a2.d = true;
            abstractFbErrorReporter.a(a2.g());
            return;
        }
        this.f17996g = (ProgressDialogFragment) ProgressDialogFragment.a(2131237226, true, true);
        this.f17996g.a(new C25471(this));
        this.f17996g.a(new C25482(this));
        this.f17996g.a(fragmentActivity.kO_(), "promote_dialog");
    }

    private boolean m18377b() {
        return (this.f17995f == null || this.f17994e == null) ? false : true;
    }

    private void m18378c() {
        if (m18377b() && this.f17996g != null && this.f17996g.an()) {
            this.f17996g.a();
            m18379a();
        }
    }
}

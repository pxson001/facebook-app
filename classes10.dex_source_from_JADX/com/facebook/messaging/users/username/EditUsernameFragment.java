package com.facebook.messaging.users.username;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.actionbar.ActionBarContextUtils;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.service.model.EditUsernameParams;
import com.facebook.messaging.users.username.EditUsernameEditText.UsernameAvailabilityListener;
import com.facebook.messaging.users.username.graphql.MessagingUsernameGraphQLHandler;
import com.facebook.messaging.users.username.view.UsernameFormatUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

/* compiled from: ping_status_fetch */
public class EditUsernameFragment extends FbFragment {
    public static final Uri f4907a = Uri.parse("https://www.facebook.com/help/105399436216001");
    public EditUsernameEditText al;
    @Nullable
    public ToolbarListener am;
    public MenuItem an;
    @Nullable
    private ListenableFuture<GraphQLResult> ao;
    @Nullable
    private ListenableFuture ap;
    private Toolbar aq;
    public int ar;
    @Inject
    @ForUiThread
    private ExecutorService f4908b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BlueServiceOperationFactory> f4909c = UltralightRuntime.b;
    @Inject
    public EditUsernameLogger f4910d;
    @Inject
    @LoggedInUser
    private Provider<User> f4911e;
    @Inject
    private UsernameFormatUtil f4912f;
    @Inject
    private MessagingUsernameGraphQLHandler f4913g;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LinkHandlingHelper> f4914h = UltralightRuntime.b;
    @Inject
    public Toaster f4915i;

    /* compiled from: ping_status_fetch */
    class C06701 implements OnClickListener {
        final /* synthetic */ EditUsernameFragment f4901a;

        C06701(EditUsernameFragment editUsernameFragment) {
            this.f4901a = editUsernameFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1329918421);
            if (this.f4901a.am != null) {
                ToolbarListener toolbarListener = this.f4901a.am;
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1547239152, a);
        }
    }

    /* compiled from: ping_status_fetch */
    class C06712 implements OnMenuItemClickListener {
        final /* synthetic */ EditUsernameFragment f4902a;

        C06712(EditUsernameFragment editUsernameFragment) {
            this.f4902a = editUsernameFragment;
        }

        public final boolean m4427a(MenuItem menuItem) {
            if (menuItem.getItemId() == 2131568686) {
                this.f4902a.m4443b(this.f4902a.al.getText());
            }
            return false;
        }
    }

    /* compiled from: ping_status_fetch */
    class C06723 implements UsernameAvailabilityListener {
        final /* synthetic */ EditUsernameFragment f4903a;

        C06723(EditUsernameFragment editUsernameFragment) {
            this.f4903a = editUsernameFragment;
        }

        public final void mo132a(String str) {
            this.f4903a.an.setEnabled(false);
            this.f4903a.al.m4423a();
            this.f4903a.m4438a(str);
        }
    }

    /* compiled from: ping_status_fetch */
    class C06734 implements FutureCallback<GraphQLResult> {
        final /* synthetic */ EditUsernameFragment f4904a;

        C06734(EditUsernameFragment editUsernameFragment) {
            this.f4904a = editUsernameFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f4904a.ar = this.f4904a.ar + 1;
            this.f4904a.al.m4424b();
            if (graphQLResult == null) {
                this.f4904a.al.m4425e();
                return;
            }
            this.f4904a.al.m4426f();
            this.f4904a.an.setEnabled(true);
        }

        public void onFailure(Throwable th) {
            this.f4904a.al.m4424b();
            if (!(th instanceof CancellationException)) {
                this.f4904a.al.m4425e();
            }
        }
    }

    /* compiled from: ping_status_fetch */
    class C06745 extends OperationResultFutureCallback2 {
        final /* synthetic */ EditUsernameFragment f4905a;

        C06745(EditUsernameFragment editUsernameFragment) {
            this.f4905a = editUsernameFragment;
        }

        protected final void m4429a(OperationResult operationResult) {
            if (operationResult == null) {
                this.f4905a.f4915i.a(new ToastBuilder(2131232434));
                return;
            }
            EditUsernameLogger editUsernameLogger = this.f4905a.f4910d;
            int i = this.f4905a.ar;
            HoneyClientEventFast a = editUsernameLogger.f4916a.a("android_messenger_edit_username_save_successful", true);
            if (a.a()) {
                a.a("android_messenger_number_of_availability_checks", i);
                a.b();
            }
            this.f4905a.ar = 0;
            if (this.f4905a.am != null) {
                ToolbarListener toolbarListener = this.f4905a.am;
            }
        }

        protected final void m4431a(Throwable th) {
            this.f4905a.f4915i.a(new ToastBuilder(2131232434));
        }
    }

    /* compiled from: ping_status_fetch */
    class HelpLinkSpan extends ClickableSpan {
        final /* synthetic */ EditUsernameFragment f4906a;

        public HelpLinkSpan(EditUsernameFragment editUsernameFragment) {
            this.f4906a = editUsernameFragment;
        }

        public void onClick(View view) {
            ((LinkHandlingHelper) this.f4906a.f4914h.get()).a(view.getContext(), EditUsernameFragment.f4907a);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: ping_status_fetch */
    public interface ToolbarListener {
    }

    private static <T extends InjectableComponentWithContext> void m4436a(Class<T> cls, T t) {
        m4437a((Object) t, t.getContext());
    }

    private static void m4437a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EditUsernameFragment) obj).m4439a((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 1144), new EditUsernameLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), IdBasedProvider.a(injectorLike, 3595), new UsernameFormatUtil(IdBasedProvider.a(injectorLike, 3595)), MessagingUsernameGraphQLHandler.m4476b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7898), Toaster.b(injectorLike));
    }

    private void m4439a(ExecutorService executorService, com.facebook.inject.Lazy<BlueServiceOperationFactory> lazy, EditUsernameLogger editUsernameLogger, Provider<User> provider, UsernameFormatUtil usernameFormatUtil, MessagingUsernameGraphQLHandler messagingUsernameGraphQLHandler, com.facebook.inject.Lazy<LinkHandlingHelper> lazy2, Toaster toaster) {
        this.f4908b = executorService;
        this.f4909c = lazy;
        this.f4910d = editUsernameLogger;
        this.f4911e = provider;
        this.f4912f = usernameFormatUtil;
        this.f4913g = messagingUsernameGraphQLHandler;
        this.f4914h = lazy2;
        this.f4915i = toaster;
    }

    public final void m4455c(Bundle bundle) {
        super.c(bundle);
        m4436a(EditUsernameFragment.class, (InjectableComponentWithContext) this);
    }

    public final View m4453a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1446033575);
        View inflate = layoutInflater.inflate(2130905691, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2071104634, a);
        return inflate;
    }

    public final void m4454a(View view, Bundle bundle) {
        super.a(view, bundle);
        m4447e();
        ar();
        as();
    }

    private void m4447e() {
        this.aq = (Toolbar) e(2131564850);
        this.aq.setTitle(2131232426);
        this.aq.setNavigationOnClickListener(new C06701(this));
        this.aq.a(2131820587);
        this.aq.D = new C06712(this);
        aq();
    }

    public final void m4451H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1264231676);
        super.H();
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -18906687, a);
    }

    public final void m4452I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -615708294);
        if (this.ao != null) {
            this.ao.cancel(true);
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1870992777, a);
    }

    private void aq() {
        this.an = this.aq.getMenu().findItem(2131568686);
        Context context = getContext();
        this.an.setIcon(ActionBarContextUtils.a(context, 2131625159, 2130841366, ContextCompat.b(context, 2131361920)));
        this.an.setEnabled(false);
    }

    private void ar() {
        String str;
        this.al = (EditUsernameEditText) e(2131564851);
        EditUsernameEditText editUsernameEditText = this.al;
        User user = (User) this.f4912f.f4922a.get();
        if (user != null) {
            str = user.g;
        } else {
            str = "";
        }
        editUsernameEditText.setText(str);
        this.al.f4896c = new C06723(this);
    }

    private void m4438a(String str) {
        if (this.ao != null) {
            this.ao.cancel(true);
        }
        this.ao = this.f4913g.m4477a(str);
        Futures.a(this.ao, new C06734(this), this.f4908b);
    }

    private void m4443b(String str) {
        if (!(this.ap == null || this.ap.isDone())) {
            this.ap.cancel(true);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(EditUsernameParams.a, new EditUsernameParams(str));
        this.ap = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f4909c.get(), "save_username", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(EditUsernameFragment.class), -1999511578).a();
        Futures.a(this.ap, new C06745(this), this.f4908b);
    }

    private void as() {
        TextView textView = (TextView) e(2131564852);
        if (((User) this.f4911e.get()).E) {
            textView.setText(2131232429);
        } else {
            textView.setText(2131232428);
        }
        textView = (TextView) e(2131564853);
        textView.setText(m4433a(jW_()));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinkTextColor(jW_().getColor(2131362241));
    }

    private SpannableString m4433a(Resources resources) {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(resources.getString(2131232430));
        styledStringBuilder.a(new HelpLinkSpan(this), 33);
        styledStringBuilder.a(" ");
        styledStringBuilder.a(resources.getString(2131232431));
        styledStringBuilder.a();
        return styledStringBuilder.b();
    }
}

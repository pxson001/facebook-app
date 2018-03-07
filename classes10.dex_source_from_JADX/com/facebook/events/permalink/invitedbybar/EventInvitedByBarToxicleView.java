package com.facebook.events.permalink.invitedbybar;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.forcemessenger.ForceMessengerHandler;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: birthday_events_dashboard_entry */
public class EventInvitedByBarToxicleView extends FbTextView implements OnClickListener {
    @Inject
    EventPermalinkController f18578a;
    @Inject
    EventSocialContextFormatter f18579b;
    @Inject
    MessengerAppUtils f18580c;
    @Inject
    EventEventLogger f18581d;
    @Inject
    ForceMessengerHandler f18582e;
    @Inject
    BlockUserInvitesController f18583f;
    public Event f18584g;
    public EventAnalyticsParams f18585h;
    private EventDrawDividerUtil f18586i;
    private int f18587j;
    private boolean f18588k;

    /* compiled from: birthday_events_dashboard_entry */
    class C26402 implements OnMenuItemClickListener {
        final /* synthetic */ EventInvitedByBarToxicleView f18574a;

        C26402(EventInvitedByBarToxicleView eventInvitedByBarToxicleView) {
            this.f18574a = eventInvitedByBarToxicleView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            String str = this.f18574a.f18584g.ai.b;
            if (!StringUtil.a(str)) {
                this.f18574a.f18581d.m18129a(this.f18574a.f18585h.d, ActionMechanism.PERMALINK_RELATIONSHIP_BAR, this.f18574a.f18585h.c, this.f18574a.f18584g.a, this.f18574a.f18580c.c());
                this.f18574a.f18582e.a(str, "events");
            }
            return true;
        }
    }

    private static <T extends View> void m18909a(Class<T> cls, T t) {
        m18910a((Object) t, t.getContext());
    }

    private static void m18910a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventInvitedByBarToxicleView) obj).m18906a(EventPermalinkController.m18262b(injectorLike), EventSocialContextFormatter.b(injectorLike), MessengerAppUtils.a(injectorLike), EventEventLogger.m18119b(injectorLike), ForceMessengerHandler.b(injectorLike), new BlockUserInvitesController(Toaster.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike)));
    }

    public EventInvitedByBarToxicleView(Context context) {
        super(context);
        m18905a();
    }

    public EventInvitedByBarToxicleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18905a();
    }

    private void m18906a(EventPermalinkController eventPermalinkController, EventSocialContextFormatter eventSocialContextFormatter, MessengerAppUtils messengerAppUtils, EventEventLogger eventEventLogger, ForceMessengerHandler forceMessengerHandler, BlockUserInvitesController blockUserInvitesController) {
        this.f18578a = eventPermalinkController;
        this.f18579b = eventSocialContextFormatter;
        this.f18580c = messengerAppUtils;
        this.f18581d = eventEventLogger;
        this.f18582e = forceMessengerHandler;
        this.f18583f = blockUserInvitesController;
    }

    public EventInvitedByBarToxicleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18905a();
    }

    private void m18905a() {
        m18909a(EventInvitedByBarToxicleView.class, (View) this);
        this.f18586i = new EventDrawDividerUtil(getResources());
        this.f18587j = getResources().getDimensionPixelSize(2131427416);
        setOnClickListener(this);
        setEllipsize(TruncateAt.END);
    }

    public final void m18914a(Event event, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        CharSequence charSequence;
        this.f18588k = !z;
        this.f18584g = event;
        this.f18585h = eventAnalyticsParams;
        EventUser eventUser = this.f18584g.ai;
        if (eventUser == null) {
            Object obj = null;
        } else {
            String str = eventUser.c;
        }
        if (StringUtil.a(obj)) {
            charSequence = "";
        } else {
            charSequence = this.f18579b.a(obj, event.m, event.l);
        }
        setText(charSequence);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2105101391);
        if (this.f18584g == null || this.f18584g.ai == null) {
            Logger.a(2, EntryType.UI_INPUT_END, -228321191, a);
            return;
        }
        String str = this.f18584g.ai.c;
        if (StringUtil.a(str)) {
            LogUtils.a(-506653661, a);
            return;
        }
        m18911a(str);
        LogUtils.a(-1503879277, a);
    }

    private void m18911a(String str) {
        Context context = getContext();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
        m18907a(bottomSheetAdapter, str);
        m18908a(bottomSheetAdapter, str, context);
        m18913b(bottomSheetAdapter, str, context);
        bottomSheetDialog.a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    private void m18908a(BottomSheetAdapter bottomSheetAdapter, String str, final Context context) {
        bottomSheetAdapter.a(getResources().getString(2131237066, new Object[]{str})).setIcon(2130839888).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ EventInvitedByBarToxicleView f18573b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18573b.f18578a.m18268a(context, this.f18573b.f18584g.ai);
                return true;
            }
        });
    }

    private void m18907a(BottomSheetAdapter bottomSheetAdapter, String str) {
        bottomSheetAdapter.a(getResources().getString(2131237065, new Object[]{str})).setIcon(2130839685).setOnMenuItemClickListener(new C26402(this));
    }

    private void m18913b(BottomSheetAdapter bottomSheetAdapter, final String str, final Context context) {
        bottomSheetAdapter.a(getResources().getString(2131237067, new Object[]{str})).setIcon(2130839878).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ EventInvitedByBarToxicleView f18577c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18577c.f18583f.m18903a(this.f18577c.f18584g.ai.b, str, this.f18577c.f18585h, context);
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18588k) {
            this.f18586i.a(canvas, 0.0f, this.f18587j);
        }
    }
}

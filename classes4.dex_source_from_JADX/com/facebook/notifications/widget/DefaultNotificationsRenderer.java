package com.facebook.notifications.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationHighlightOperationFragmentModel;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationStoryHelper.NotificationLocation;
import com.facebook.notifications.util.NotificationsHighlightHelper;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsInlineActionsHelper.InlineAction;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.RowWithActionTaken;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"DeprecatedClass"})
/* compiled from: exemptions */
public class DefaultNotificationsRenderer {
    private static volatile DefaultNotificationsRenderer f12674h;
    protected final NotificationStoryHelper f12675a;
    protected final AbstractFbErrorReporter f12676b;
    protected final NotificationViewFactory f12677c;
    public final NotificationsInlineActionsHelper f12678d;
    public final NotificationsActionExecutor f12679e;
    private final NotificationsHighlightHelper f12680f;
    private final TodayExperimentController f12681g;

    public static com.facebook.notifications.widget.DefaultNotificationsRenderer m13481a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12674h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.widget.DefaultNotificationsRenderer.class;
        monitor-enter(r1);
        r0 = f12674h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13484b(r0);	 Catch:{ all -> 0x0035 }
        f12674h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12674h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.widget.DefaultNotificationsRenderer.a(com.facebook.inject.InjectorLike):com.facebook.notifications.widget.DefaultNotificationsRenderer");
    }

    private static DefaultNotificationsRenderer m13484b(InjectorLike injectorLike) {
        return new DefaultNotificationsRenderer(NotificationStoryHelper.m13347a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NotificationViewFactory.m13490a(injectorLike), NotificationsActionExecutor.m13401a(injectorLike), NotificationsInlineActionsHelper.m13381a(injectorLike), NotificationsHighlightHelper.m13445a(injectorLike), TodayExperimentController.a(injectorLike));
    }

    public final View m13486a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130907358, viewGroup, false);
    }

    @Inject
    public DefaultNotificationsRenderer(NotificationStoryHelper notificationStoryHelper, AbstractFbErrorReporter abstractFbErrorReporter, NotificationViewFactory notificationViewFactory, NotificationsActionExecutor notificationsActionExecutor, NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsHighlightHelper notificationsHighlightHelper, TodayExperimentController todayExperimentController) {
        this.f12675a = notificationStoryHelper;
        this.f12676b = abstractFbErrorReporter;
        this.f12677c = notificationViewFactory;
        this.f12679e = notificationsActionExecutor;
        this.f12678d = notificationsInlineActionsHelper;
        this.f12680f = notificationsHighlightHelper;
        this.f12681g = todayExperimentController;
    }

    private static void m13482a(View view, boolean z, String str, String str2, Spannable spannable, long j, String str3, @Nullable String str4, GraphQLNotifImportanceType graphQLNotifImportanceType, @Nullable SpannableString spannableString) {
        ((SwitchableNotificationView) view).getNotificationView().a(z, str, str2, spannable, j, str3, str4, graphQLNotifImportanceType, spannableString);
    }

    public final void m13487a(View view, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i, boolean z, @Nullable OnClickListener onClickListener) {
        GraphQLStory k = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
        if (k == null) {
            view.setVisibility(8);
            this.f12676b.a("notification", "Can't bind null FeedStory");
            return;
        }
        String str;
        ((SwitchableNotificationView) view).a();
        String str2 = null;
        GraphQLActor b = StoryActorHelper.b(k);
        if (!(b == null || b.ai() == null)) {
            str2 = b.ai().b();
        }
        String k2 = k.ad() != null ? k.ad().k() : null;
        TextView textView = (TextView) view.findViewById(2131560262);
        GraphQLNotifImportanceType g = z ? fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo817g() : GraphQLNotifImportanceType.NOT_IMPORTANT;
        SpannableString spannableString = null;
        if (!fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b().isEmpty()) {
            NotificationHighlightOperationFragmentModel notificationHighlightOperationFragmentModel = (NotificationHighlightOperationFragmentModel) fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b().get(0);
            if (!(notificationHighlightOperationFragmentModel.b() == null || notificationHighlightOperationFragmentModel.d() == null)) {
                SpannableString spannableString2;
                if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gs_()) {
                    spannableString2 = new SpannableString(notificationHighlightOperationFragmentModel.d().a());
                } else {
                    spannableString2 = new SpannableString(notificationHighlightOperationFragmentModel.b().a());
                }
                spannableString2.setSpan(new 1(this, onClickListener), 0, spannableString2.length() - 1, 17);
                spannableString = spannableString2;
            }
        }
        boolean equals = GraphQLStorySeenState.SEEN_AND_READ.equals(k.au());
        Spannable a = this.f12675a.m13356a(k, NotificationLocation.JEWEL, textView);
        long V = k.V();
        String g2 = k.g();
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo816d() == null) {
            str = null;
        } else {
            str = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo816d().a();
        }
        m13482a(view, equals, str2, k2, a, V, g2, str, g, spannableString);
        view.setVisibility(0);
        SwitchableNotificationView switchableNotificationView = (SwitchableNotificationView) view;
        CaspianNotificationsView notificationView = switchableNotificationView.getNotificationView();
        ImageButton notificationsAuxView = notificationView.getNotificationsAuxView();
        if ((this.f12678d.m13398c() || this.f12678d.m13399d()) && NotificationsInlineActionsHelper.m13388a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            switchableNotificationView.setNotificationChevronListener(new 2(this, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3, notificationView, i));
            notificationsAuxView.setImageResource(2130842425);
            notificationsAuxView.setVisibility(0);
            notificationView.setDescendantFocusability(393216);
        } else if (m13483a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields)) {
            notificationsAuxView.setImageResource(2130843448);
            notificationsAuxView.setVisibility(0);
            notificationView.setDescendantFocusability(393216);
        } else {
            notificationsAuxView.setVisibility(8);
        }
    }

    private boolean m13483a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        return (this.f12680f.m13449d() && fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c() == GraphQLNotifHighlightState.HIGHLIGHTED) || (this.f12681g.b.a(ExperimentsForTodayAbTestModule.q, false) && GraphQLNotifImportanceType.IMPORTANT.equals(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo817g()));
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void m13488a(View view, RowWithActionTaken rowWithActionTaken, NotificationsRowWithActionHelper notificationsRowWithActionHelper, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, 3 3, int i) {
        GraphQLStory k = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
        SwitchableNotificationView switchableNotificationView = (SwitchableNotificationView) view;
        if (rowWithActionTaken == null) {
            view.setVisibility(8);
            return;
        }
        switchableNotificationView.b();
        Resources resources = view.getContext().getResources();
        3 32 = new 3(this, notificationsRowWithActionHelper, k, switchableNotificationView, rowWithActionTaken, i);
        String string = resources.getString(2131233689);
        PostFeedbackView postFeedbackView = switchableNotificationView.getPostFeedbackView();
        String e = rowWithActionTaken.e();
        if (!this.f12678d.m13399d() || rowWithActionTaken.c() == null) {
            SpannableString spannableString = new SpannableString(e + " " + string);
            spannableString.setSpan(new 5(this, 32, resources), spannableString.length() - string.length(), spannableString.length(), 33);
            postFeedbackView.setText(spannableString);
            postFeedbackView.setBackground(new ColorDrawable(resources.getColor(2131362099)));
            return;
        }
        boolean equals = rowWithActionTaken.c().a().equals(InlineAction.HIDE_CLIENT_ACTION.name);
        switchableNotificationView.setPostFeedbackChevronListener(new 4(this, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, switchableNotificationView, 3, i, equals, 32, string));
        postFeedbackView.setText(e);
        postFeedbackView.setChevronVisibility(equals);
    }

    public final int m13485a(Context context) {
        int[] iArr = new int[]{2130772416, 2130772409};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, iArr);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        obtainStyledAttributes.recycle();
        return (dimensionPixelSize2 * 2) + dimensionPixelSize;
    }
}

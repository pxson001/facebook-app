package com.facebook.messaging.business.agent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragments.BusinessFAQContentsQueryString;
import com.facebook.messaging.business.common.loader.BusinessFAQContentsLoader;
import com.facebook.messaging.business.common.loader.BusinessFAQContentsLoader.1;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.messagemetadata.QuickRepliesPlatformMetadata;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.ComposerKeyboardManager.MQuickReplyKeyboardFactory.C07721;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_summary */
public class MQuickReplyKeyboardView extends CustomFrameLayout {
    @Inject
    AbstractFbErrorReporter f1493a;
    @Inject
    AnalyticsLogger f1494b;
    @Inject
    public BusinessFAQContentsLoader f1495c;
    @Inject
    @ForUiThread
    public ExecutorService f1496d;
    @Inject
    DataCache f1497e;
    private final FlowLayout f1498f;
    public final ProgressBar f1499g;
    public C07721 f1500h;
    public ThreadKey f1501i;
    public boolean f1502j;
    public final FutureCallback<ImmutableList<String>> f1503k;

    /* compiled from: thread_summary */
    class C02541 implements FutureCallback<ImmutableList<String>> {
        final /* synthetic */ MQuickReplyKeyboardView f1490a;

        C02541(MQuickReplyKeyboardView mQuickReplyKeyboardView) {
            this.f1490a = mQuickReplyKeyboardView;
        }

        public void onSuccess(@Nullable Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f1490a.f1499g.setVisibility(8);
            if (immutableList == null || immutableList.isEmpty()) {
                this.f1490a.f1493a.a("m_quick_reply", "Load empty default options for : " + Long.toString(this.f1490a.f1501i.d));
            } else {
                MQuickReplyKeyboardView.m1473a(this.f1490a, immutableList);
            }
        }

        public void onFailure(Throwable th) {
            this.f1490a.f1493a.a("m_quick_reply", "Failed to load default options for : " + Long.toString(this.f1490a.f1501i.d));
        }
    }

    public static void m1474a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MQuickReplyKeyboardView) obj).m1472a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), new BusinessFAQContentsLoader((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), DataCache.a(fbInjector));
    }

    private void m1472a(AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, BusinessFAQContentsLoader businessFAQContentsLoader, ExecutorService executorService, DataCache dataCache) {
        this.f1493a = abstractFbErrorReporter;
        this.f1494b = analyticsLogger;
        this.f1495c = businessFAQContentsLoader;
        this.f1496d = executorService;
        this.f1497e = dataCache;
    }

    public MQuickReplyKeyboardView(Context context) {
        this(context, null, 0);
    }

    private MQuickReplyKeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1503k = new C02541(this);
        Class cls = MQuickReplyKeyboardView.class;
        m1474a((Object) this, getContext());
        setContentView(2130906557);
        this.f1498f = (FlowLayout) c(2131566517);
        this.f1499g = (ProgressBar) c(2131566518);
        this.f1502j = false;
    }

    public static ImmutableList<QuickReplyItem> m1471a(DataCache dataCache, ThreadKey threadKey) {
        MessagesCollection b = dataCache.b(threadKey);
        if (b == null) {
            return null;
        }
        Message c = b.c();
        if (c == null || c.Q == null) {
            return null;
        }
        QuickRepliesPlatformMetadata quickRepliesPlatformMetadata = (QuickRepliesPlatformMetadata) PlatformMetadataUtil.a(PlatformMetadataType.QUICK_REPLIES, c.Q);
        if (quickRepliesPlatformMetadata == null) {
            return null;
        }
        return quickRepliesPlatformMetadata.a;
    }

    public static void m1473a(MQuickReplyKeyboardView mQuickReplyKeyboardView, ImmutableList immutableList) {
        AnalyticsLogger analyticsLogger = mQuickReplyKeyboardView.f1494b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(mQuickReplyKeyboardView.f1502j ? "quick_replies_received" : "default_options_received");
        honeyClientEvent.c = "m_quick_reply";
        analyticsLogger.a(honeyClientEvent.a("page_id", mQuickReplyKeyboardView.f1501i.d));
        mQuickReplyKeyboardView.f1498f.removeAllViews();
        Context context = mQuickReplyKeyboardView.getContext();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final String str = (String) immutableList.get(i);
            View inflate = LayoutInflater.from(context).inflate(2130906556, mQuickReplyKeyboardView.f1498f, false);
            CustomLinearLayout customLinearLayout = (CustomLinearLayout) inflate.findViewById(2131566515);
            BetterTextView betterTextView = (BetterTextView) inflate.findViewById(2131566516);
            customLinearLayout.setForeground(new MQuickReplyBubbleOverlayDrawable(context));
            betterTextView.setText(str);
            customLinearLayout.setOnClickListener(new OnClickListener(mQuickReplyKeyboardView) {
                final /* synthetic */ MQuickReplyKeyboardView f1492b;

                public void onClick(View view) {
                    String str;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1256663767);
                    if (this.f1492b.f1500h != null) {
                        C07721 c07721 = this.f1492b.f1500h;
                        String str2 = str;
                        if (c07721.f5456a.f5457a.f5489s != null) {
                            c07721.f5456a.f5457a.f5489s.m4817d(str2);
                        }
                    }
                    AnalyticsLogger analyticsLogger = this.f1492b.f1494b;
                    if (this.f1492b.f1502j) {
                        str = "quick_reply_send";
                    } else {
                        str = "default_option_sent";
                    }
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
                    honeyClientEvent.c = "m_quick_reply";
                    analyticsLogger.a(honeyClientEvent.a("page_id", this.f1492b.f1501i.d));
                    LogUtils.a(2098173980, a);
                }
            });
            mQuickReplyKeyboardView.f1498f.addView(inflate);
        }
    }

    public void setThreadKey(ThreadKey threadKey) {
        this.f1501i = threadKey;
        this.f1502j = false;
        this.f1498f.removeAllViews();
        ImmutableList a = m1471a(this.f1497e, threadKey);
        if (a == null || a.isEmpty()) {
            this.f1499g.setVisibility(0);
            BusinessFAQContentsLoader businessFAQContentsLoader = this.f1495c;
            String l = Long.toString(threadKey.d);
            GraphQlQueryString businessFAQContentsQueryString = new BusinessFAQContentsQueryString();
            businessFAQContentsQueryString.a("business_id", l);
            GraphQLRequest a2 = GraphQLRequest.a(businessFAQContentsQueryString).a(GraphQLCachePolicy.a).a(86400);
            a2.f = CallerContext.a(businessFAQContentsLoader.getClass());
            Futures.a(Futures.a(businessFAQContentsLoader.b.a(a2), new 1(businessFAQContentsLoader), businessFAQContentsLoader.a), this.f1503k, this.f1496d);
            return;
        }
        this.f1502j = true;
        Builder builder = ImmutableList.builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((QuickReplyItem) a.get(i)).a);
        }
        m1473a(this, builder.b());
    }
}

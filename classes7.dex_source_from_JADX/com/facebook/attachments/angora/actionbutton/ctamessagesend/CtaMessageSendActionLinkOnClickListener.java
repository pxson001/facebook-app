package com.facebook.attachments.angora.actionbutton.ctamessagesend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user turned off facebook notification setting */
public class CtaMessageSendActionLinkOnClickListener<E extends AnyEnvironment> implements OnDismissListener, OnClickListener {
    private static final Class<CtaMessageSendActionLinkOnClickListener> f901a = CtaMessageSendActionLinkOnClickListener.class;
    private final FeedProps<GraphQLStoryAttachment> f902b;
    private final GraphQLStoryAttachment f903c;
    private final CtaMessageSendActionLinkHandlerProvider f904d;
    private final CtaMessageSendLogger f905e;
    private final AbstractFbErrorReporter f906f;

    @Inject
    public CtaMessageSendActionLinkOnClickListener(@Assisted FeedProps<GraphQLStoryAttachment> feedProps, CtaMessageSendActionLinkHandlerProvider ctaMessageSendActionLinkHandlerProvider, CtaMessageSendLogger ctaMessageSendLogger, FbErrorReporter fbErrorReporter) {
        this.f902b = feedProps;
        this.f903c = (GraphQLStoryAttachment) feedProps.a;
        this.f904d = ctaMessageSendActionLinkHandlerProvider;
        this.f905e = ctaMessageSendLogger;
        this.f906f = fbErrorReporter;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -245373941);
        GraphQLStoryActionLink a2 = ActionLinkHelper.a(this.f903c);
        if (a2 == null) {
            Logger.a(2, EntryType.UI_INPUT_END, -265079309, a);
            return;
        }
        FeedProps e = AttachmentProps.e(this.f902b);
        if (e == null) {
            this.f906f.a(f901a.getSimpleName(), "Parent Story is null");
            LogUtils.a(1686576352, a);
            return;
        }
        String dp;
        if (this.f903c.z() != null) {
            dp = this.f903c.z().dp();
        } else {
            dp = null;
        }
        if (dp == null) {
            this.f906f.a(f901a.getSimpleName(), "target page id is null");
            LogUtils.a(-480603188, a);
            return;
        }
        String aE = a2.aE();
        if (aE != null) {
            aE = m887a(aE);
        } else {
            aE = null;
        }
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        if (aE == null) {
            this.f906f.a(f901a.getSimpleName(), "ad id is null");
            LogUtils.a(-695214198, a);
            return;
        }
        this.f904d.m886a(this.f902b).m885a(view, dp, aE);
        this.f905e.m890a(TrackableFeedProps.a(e), "cta_message_sent", graphQLStory.u());
        LogUtils.a(62962452, a);
    }

    @Nullable
    private String m887a(String str) {
        String str2 = null;
        String queryParameter = Uri.parse(str).getQueryParameter("href");
        if (queryParameter == null) {
            return str2;
        }
        try {
            return Uri.parse(URLDecoder.decode(queryParameter, "UTF-8")).getQueryParameter("ad_id");
        } catch (UnsupportedEncodingException e) {
            this.f906f.a(f901a.getSimpleName(), "failed to decode " + queryParameter);
            return str2;
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
    }
}

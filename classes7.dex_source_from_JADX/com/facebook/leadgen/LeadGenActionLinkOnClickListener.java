package com.facebook.leadgen;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLLeadGenDeepLinkUserStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.popover.MultiPageBaseContentFragment;
import com.facebook.leadgen.popover.MultiPagePopoverFragment;
import com.facebook.leadgen.util.LeadGenSharedStatusHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_question_place */
public class LeadGenActionLinkOnClickListener<E extends HasInvalidate> implements OnDismissListener, OnClickListener {
    private static final Class<LeadGenActionLinkOnClickListener> f6231a = LeadGenActionLinkOnClickListener.class;
    private final FeedProps<GraphQLStoryAttachment> f6232b;
    private final GraphQLStoryAttachment f6233c;
    private final Context f6234d;
    private final LeadGenLinkHandlerProvider f6235e;
    private final LeadGenLogger f6236f;
    private final AbstractFbErrorReporter f6237g;
    private final LeadGenUtil f6238h;
    private final E f6239i;
    private final InlineCommentComposerCache f6240j;
    private final LeadGenSharedStatusHelper f6241k;
    private View f6242l;

    @Inject
    LeadGenActionLinkOnClickListener(@Assisted FeedProps<GraphQLStoryAttachment> feedProps, @Assisted Context context, @Nullable @Assisted E e, LeadGenLinkHandlerProvider leadGenLinkHandlerProvider, LeadGenLogger leadGenLogger, FbErrorReporter fbErrorReporter, LeadGenUtil leadGenUtil, InlineCommentComposerCache inlineCommentComposerCache, LeadGenSharedStatusHelper leadGenSharedStatusHelper) {
        this.f6232b = feedProps;
        this.f6233c = (GraphQLStoryAttachment) feedProps.a;
        this.f6234d = context;
        this.f6239i = e;
        this.f6235e = leadGenLinkHandlerProvider;
        this.f6236f = leadGenLogger;
        this.f6237g = fbErrorReporter;
        this.f6238h = leadGenUtil;
        this.f6240j = inlineCommentComposerCache;
        this.f6241k = leadGenSharedStatusHelper;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1618518267);
        GraphQLStoryActionLink a2 = ActionLinkHelper.a(this.f6233c, 1185006756);
        if (a2 == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 2004922777, a);
            return;
        }
        FeedProps e = AttachmentProps.e(this.f6232b);
        if (e == null) {
            this.f6237g.a(f6231a.getSimpleName(), "Parent Story is null");
            LogUtils.a(966614560, a);
            return;
        }
        Object obj;
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        GraphQLLeadGenDeepLinkUserStatus O = a2.O();
        String k = a2.k();
        LeadGenSharedStatusHelper leadGenSharedStatusHelper = this.f6241k;
        if (k == null) {
            obj = null;
        } else {
            LeadGenUtil$SendInfoMutationStatus leadGenUtil$SendInfoMutationStatus = (LeadGenUtil$SendInfoMutationStatus) leadGenSharedStatusHelper.f6566a.get(k);
            obj = (leadGenUtil$SendInfoMutationStatus == null || leadGenUtil$SendInfoMutationStatus != LeadGenUtil$SendInfoMutationStatus.SUCCESS) ? null : 1;
        }
        Object obj2 = obj;
        if ((O == null || !O.j()) && obj2 == null) {
            MultiPageBaseContentFragment a3 = LeadGenUserInputFormFragment.m8179a(this.f6232b);
            Context context = this.f6234d != null ? this.f6234d : view.getContext();
            this.f6240j.a(graphQLStory, this.f6239i, Boolean.valueOf(true));
            FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(context, FragmentManagerHost.class);
            Activity activity = (Activity) ContextUtils.a(context, Activity.class);
            Preconditions.checkNotNull(fragmentManagerHost);
            Preconditions.checkNotNull(activity);
            FragmentManager kO_ = fragmentManagerHost.kO_();
            Window window = activity.getWindow();
            View a4 = FbRootViewUtil.a(context);
            MultiPagePopoverFragment multiPagePopoverFragment = new MultiPagePopoverFragment();
            multiPagePopoverFragment.ao = a3;
            multiPagePopoverFragment.a(kO_, window, a4);
            MultiPagePopoverFragment multiPagePopoverFragment2 = multiPagePopoverFragment;
            if (multiPagePopoverFragment2.aq == null) {
                multiPagePopoverFragment2.aq = new ArrayList();
            }
            multiPagePopoverFragment2.aq.add(this);
            this.f6242l = view;
            this.f6242l.setEnabled(false);
            this.f6236f.m8139a(TrackableFeedProps.a(e), graphQLStory.u(), LeadGenUtil.a(this.f6232b));
            this.f6236f.m8140a("cta_lead_gen_open_popover");
            LogUtils.a(384456666, a);
            return;
        }
        this.f6235e.m8133a(this.f6232b).m8131a(view, a2.F(), false);
        LogUtils.a(-598614072, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6242l != null) {
            this.f6242l.setEnabled(true);
            this.f6242l = null;
        }
    }
}

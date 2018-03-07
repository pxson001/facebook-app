package com.facebook.reaction.ui.attachment.handler;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentHandler.AttachmentClickListener;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQL.ReactionMoreAttachmentsQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionMoreAttachmentsResultModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
public abstract class AbstractReactionHscrollHandler extends ReactionAttachmentHandler {
    protected String f20805a;
    public ReactionHscrollAdapter f20806b;
    public int f20807c;
    public final ReactionIntentFactory f20808d;
    public final ReactionUtil f20809e;
    public ViewPager f20810f;

    /* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
    public /* synthetic */ class C22001 {
        public static final /* synthetic */ int[] f20792a = new int[ReactionHscrollHandlerItemPaddingStyle.values().length];

        static {
            try {
                f20792a[ReactionHscrollHandlerItemPaddingStyle.NO_PADDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20792a[ReactionHscrollHandlerItemPaddingStyle.FIG_STANDARD_PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
    class PageChangeListener extends SimpleOnPageChangeListener {
        final /* synthetic */ AbstractReactionHscrollHandler f20793a;
        private String f20794b;
        private String f20795c;
        private ReactionHscrollAdapter f20796d;

        public PageChangeListener(AbstractReactionHscrollHandler abstractReactionHscrollHandler, String str, String str2, ReactionHscrollAdapter reactionHscrollAdapter) {
            this.f20793a = abstractReactionHscrollHandler;
            this.f20796d = reactionHscrollAdapter;
            this.f20794b = str;
            this.f20795c = str2;
        }

        public final void e_(int i) {
            if (i == (this.f20796d.m24444b() - 2) - 1) {
                ReactionHscrollAdapter reactionHscrollAdapter = this.f20796d;
                if (reactionHscrollAdapter.f20801d) {
                    ReactionUtil reactionUtil = reactionHscrollAdapter.f20798a.f20809e;
                    String str = reactionHscrollAdapter.f20803f;
                    ReactionHScrollCallback reactionHScrollCallback = new ReactionHScrollCallback(reactionHscrollAdapter);
                    String str2 = reactionHscrollAdapter.f20804g;
                    ReactionMoreAttachmentsQueryString c = FetchReactionGraphQL.c();
                    c.a("reaction_after_cursor", str).a("reaction_result_count", Integer.toString(5)).a("reaction_story_id", str2);
                    reactionUtil.f18755u.b(str2, reactionUtil.f18739e.a(GraphQLRequest.a(c)), reactionHScrollCallback);
                }
            }
            if (i > 0) {
                this.f20793a.m22849a(this.f20794b, this.f20795c);
            }
            this.f20793a.f20807c = i;
        }
    }

    /* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
    public class ReactionHscrollAdapter extends PagerAdapter {
        public final /* synthetic */ AbstractReactionHscrollHandler f20798a;
        private ReactionAttachmentsModel f20799b;
        public List<ReactionStoryAttachmentFragment> f20800c;
        public boolean f20801d;
        private String f20802e;
        public String f20803f;
        public String f20804g;

        /* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
        public class ReactionHScrollCallback extends AbstractDisposableFutureCallback<GraphQLResult<ReactionMoreAttachmentsResultModel>> {
            final /* synthetic */ ReactionHscrollAdapter f20797a;

            public ReactionHScrollCallback(ReactionHscrollAdapter reactionHscrollAdapter) {
                this.f20797a = reactionHscrollAdapter;
            }

            protected final void m24433a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null && ((ReactionMoreAttachmentsResultModel) graphQLResult.e).a() != null) {
                    ReactionHscrollAdapter.m24436a(this.f20797a, ((ReactionMoreAttachmentsResultModel) graphQLResult.e).a());
                }
            }

            protected final void m24434a(Throwable th) {
                this.f20797a.f20798a.f18818a.mo982a(th);
            }
        }

        public ReactionHscrollAdapter(AbstractReactionHscrollHandler abstractReactionHscrollHandler, ReactionAttachmentsModel reactionAttachmentsModel, String str, String str2) {
            this.f20798a = abstractReactionHscrollHandler;
            m24438b(reactionAttachmentsModel);
            this.f20804g = str;
            this.f20802e = str2;
            m24435a(reactionAttachmentsModel.c());
            kR_();
        }

        public final int m24444b() {
            return this.f20800c != null ? this.f20800c.size() : 0;
        }

        public final float m24445d(int i) {
            return this.f20798a.mo1133i();
        }

        public final boolean m24443a(View view, Object obj) {
            return view == obj;
        }

        public final Object m24440a(ViewGroup viewGroup, int i) {
            ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) this.f20800c.get(i);
            Preconditions.checkState(this.f20798a.mo1119b(reactionStoryAttachmentFragmentModel));
            View a = this.f20798a.mo1118a(reactionStoryAttachmentFragmentModel);
            if (a != null) {
                AttachmentClickListener attachmentClickListener = new AttachmentClickListener(this.f20798a, this.f20804g, this.f20802e, reactionStoryAttachmentFragmentModel);
                if (m24437a(a, 2131566605, attachmentClickListener)) {
                    m24437a(a, 2131566726, attachmentClickListener);
                    m24437a(a, 2131566724, attachmentClickListener);
                    m24437a(a, 2131566725, attachmentClickListener);
                } else {
                    a.setOnClickListener(attachmentClickListener);
                }
                viewGroup.addView(a);
                this.f20798a.m22847a(this.f20798a.f20805a, i + 1);
            }
            return a;
        }

        public final int m24439a(Object obj) {
            return -2;
        }

        public final void m24441a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final void m24442a(ReactionAttachmentsModel reactionAttachmentsModel) {
            if (this.f20799b != reactionAttachmentsModel) {
                m24438b(reactionAttachmentsModel);
            }
        }

        private void m24438b(ReactionAttachmentsModel reactionAttachmentsModel) {
            this.f20799b = reactionAttachmentsModel;
            if (this.f20800c == null) {
                this.f20800c = new ArrayList();
            } else {
                this.f20800c.clear();
            }
            ImmutableList b = reactionAttachmentsModel.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) b.get(i);
                if (!(edgesModel == null || edgesModel.a() == null || !this.f20798a.mo1119b(edgesModel.a()))) {
                    this.f20800c.add(edgesModel.a());
                }
            }
        }

        private static boolean m24437a(View view, int i, AttachmentClickListener attachmentClickListener) {
            View findViewById = view.findViewById(i);
            if (findViewById == null) {
                return false;
            }
            findViewById.setOnClickListener(attachmentClickListener);
            return true;
        }

        public static void m24436a(ReactionHscrollAdapter reactionHscrollAdapter, ReactionMoreAttachmentsResultModel.ReactionAttachmentsModel reactionAttachmentsModel) {
            reactionHscrollAdapter.m24435a(reactionAttachmentsModel.b());
            ImmutableList a = reactionAttachmentsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ReactionMoreAttachmentsResultModel.ReactionAttachmentsModel.EdgesModel edgesModel = (ReactionMoreAttachmentsResultModel.ReactionAttachmentsModel.EdgesModel) a.get(i);
                if (!(edgesModel == null || edgesModel.a() == null || !reactionHscrollAdapter.f20798a.mo1119b(edgesModel.a()))) {
                    reactionHscrollAdapter.f20800c.add(edgesModel.a());
                }
            }
            reactionHscrollAdapter.f20798a.m22850a(reactionHscrollAdapter.f20804g, reactionHscrollAdapter.f20802e, a.size(), reactionHscrollAdapter.f20800c.size());
            reactionHscrollAdapter.kR_();
        }

        private void m24435a(DefaultPageInfoFields defaultPageInfoFields) {
            if (defaultPageInfoFields != null) {
                this.f20803f = defaultPageInfoFields.a();
                this.f20801d = defaultPageInfoFields.b();
                return;
            }
            this.f20801d = false;
        }
    }

    /* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent */
    public enum ReactionHscrollHandlerItemPaddingStyle {
        NO_PADDING,
        FIG_STANDARD_PADDING
    }

    public AbstractReactionHscrollHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil) {
        super(reactionIntentLauncher);
        this.f20808d = reactionIntentFactory;
        this.f20809e = reactionUtil;
    }

    public void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        super.mo1127a(reactionAttachmentListener, viewGroup, reactionCardContainer, str, surface, reactionUnitParent);
        View a = m22840a(2130906601);
        this.f18820c.addView(a);
        this.f20810f = (ViewPager) a.findViewById(2131566602);
    }

    protected int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        if (this.f20806b == null) {
            this.f20806b = new ReactionHscrollAdapter(this, reactionAttachmentsModel, str, str2);
        } else {
            this.f20806b.m24442a(reactionAttachmentsModel);
        }
        this.f20810f.setAdapter(this.f20806b);
        this.f20810f.setOnPageChangeListener(new PageChangeListener(this, str, str2, this.f20806b));
        this.f20810f.setCurrentItem(this.f20807c);
        this.f20805a = str;
        return this.f20806b.m24444b();
    }

    protected final void m24448g() {
        int i = this.f20810f.k;
        if (i < this.f20806b.m24444b() - 1) {
            this.f20810f.a(i + 1, true);
        }
    }

    protected float mo1133i() {
        return 1.0f;
    }
}

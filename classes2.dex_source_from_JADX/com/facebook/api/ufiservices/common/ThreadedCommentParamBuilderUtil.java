package com.facebook.api.ufiservices.common;

import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: saved_collection_saved_button_clicked */
public class ThreadedCommentParamBuilderUtil {
    public final QeAccessor f6174a;
    private final InlineReplyExpansionExperimentUtil f6175b;
    public Boolean f6176c = null;

    public static ThreadedCommentParamBuilderUtil m10372b(InjectorLike injectorLike) {
        return new ThreadedCommentParamBuilderUtil(QeInternalImplMethodAutoProvider.m3744a(injectorLike), InlineReplyExpansionExperimentUtil.m7911a(injectorLike));
    }

    @Inject
    public ThreadedCommentParamBuilderUtil(QeAccessor qeAccessor, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f6174a = qeAccessor;
        this.f6175b = inlineReplyExpansionExperimentUtil;
    }

    public final void m10374b(GraphQlQueryString graphQlQueryString) {
        m10373a(graphQlQueryString, true);
    }

    public final void m10373a(GraphQlQueryString graphQlQueryString, boolean z) {
        graphQlQueryString.m11315a("enable_ranked_replies", Boolean.toString(true));
        graphQlQueryString.m11312a("enable_private_reply", Boolean.valueOf(z));
        graphQlQueryString.m11315a("enable_comment_replies_most_recent", Boolean.toString(true));
        graphQlQueryString.m11314a("max_comment_replies", Integer.valueOf(3));
        String str = "include_replies_in_total_count";
        if (this.f6176c == null) {
            this.f6176c = Boolean.valueOf(this.f6174a.mo596a(ExperimentsForUfiServiceQeModule.f6627l, false));
        }
        graphQlQueryString.m11315a(str, Boolean.toString(this.f6176c.booleanValue()));
        graphQlQueryString.m11312a("enable_attachments_for_reply_previews", Boolean.valueOf(this.f6175b.m7913a()));
        graphQlQueryString.m11312a("enable_feedback_for_reply_previews", Boolean.valueOf(this.f6175b.m7913a()));
        graphQlQueryString.m11312a("enable_page_info_for_reply_connection", Boolean.valueOf(this.f6175b.m7914b()));
    }

    public static ThreadedCommentParamBuilderUtil m10371a(InjectorLike injectorLike) {
        return m10372b(injectorLike);
    }
}

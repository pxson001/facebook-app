package com.facebook.ufiservices.flyout.views;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.graphql.enums.GraphQLPrivateReplyStatus;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.ufiservices.cache.PendingCommentCache;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

/* compiled from: current_screen */
public class PagesCommentMetadataSpannableBuilder extends DefaultCommentMetadataSpannableBuilder {
    public boolean f18204i;

    public PagesCommentMetadataSpannableBuilder(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, PendingCommentCache pendingCommentCache, Provider<TimeFormatUtil> provider, boolean z) {
        super(commentMetadataSpannableBuilderParams, pendingCommentCache, provider, z);
    }

    public final List<Spannable> mo1387a(GraphQLComment graphQLComment) {
        return mo1388a(graphQLComment, graphQLComment);
    }

    public final List<Spannable> mo1388a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2) {
        List list;
        this.h = super.mo1388a(graphQLComment, graphQLComment2);
        List list2 = this.f18172h;
        List arrayList = new ArrayList();
        if (!GraphQLHelper.c(graphQLComment) || GraphQLHelper.e(graphQLComment) == null) {
            list = arrayList;
        } else {
            String str;
            GraphQLPrivateReplyStatus e = GraphQLHelper.e(graphQLComment);
            final String j = graphQLComment.l() != null ? graphQLComment.l().j() : null;
            if (graphQLComment.G() == null || graphQLComment.G().j() == null) {
                str = null;
            } else {
                str = graphQLComment.G().j().ae();
            }
            final String str2 = str;
            if (str2 == null || j == null) {
                list = arrayList;
            } else {
                Object obj;
                int i;
                if (graphQLComment.G() == null || !graphQLComment.G().a()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    if (e == GraphQLPrivateReplyStatus.REPLYABLE) {
                        i = 2131233296;
                    } else if (e == GraphQLPrivateReplyStatus.ALREADY_REPLIED) {
                        i = 2131233297;
                    } else {
                        list = arrayList;
                    }
                } else if (e == GraphQLPrivateReplyStatus.ALREADY_REPLIED) {
                    i = 2131233298;
                    this.f18204i = true;
                } else {
                    list = arrayList;
                }
                arrayList.add(m26718a());
                Spannable spannableString = new SpannableString(this.f18168d.f18144a.getString(i));
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ PagesCommentMetadataSpannableBuilder f18203c;

                    public void onClick(View view) {
                        if (!this.f18203c.f18204i) {
                            this.f18203c.f18168d.f18145b.m26690a(view, j, str2);
                        }
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(this.f18203c.f18204i ? this.f18203c.f18166b : this.f18203c.f18167c);
                    }
                }, 0, spannableString.length(), 33);
                arrayList.add(spannableString);
                list = arrayList;
            }
        }
        list2.addAll(list);
        return this.f18172h;
    }
}

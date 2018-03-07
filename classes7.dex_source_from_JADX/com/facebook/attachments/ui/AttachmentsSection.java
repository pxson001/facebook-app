package com.facebook.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.ui.CommentAttachmentView;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: uploadContactBatchForMessaging (%d changes) */
public class AttachmentsSection extends CustomFrameLayout implements CommentAttachmentView {
    @Inject
    public DefaultShareAttachmentBinder f1014a;
    private AttachmentViewSticker f1015b;
    private AttachmentViewPhoto f1016c;
    private AttachmentViewStaticVideo f1017d;
    private FeedProps<GraphQLStoryAttachment> f1018e;
    private ImageBlockLayout f1019f;

    /* compiled from: uploadContactBatchForMessaging (%d changes) */
    /* synthetic */ class C00971 {
        static final /* synthetic */ int[] f1013a = new int[GraphQLStoryAttachmentStyle.values().length];

        static {
            try {
                f1013a[GraphQLStoryAttachmentStyle.STICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1013a[GraphQLStoryAttachmentStyle.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1013a[GraphQLStoryAttachmentStyle.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1013a[GraphQLStoryAttachmentStyle.SHARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static <T extends View> void m990a(Class<T> cls, T t) {
        m991a((Object) t, t.getContext());
    }

    private static void m991a(Object obj, Context context) {
        ((AttachmentsSection) obj).f1014a = DefaultShareAttachmentBinder.m997b(FbInjector.get(context));
    }

    public AttachmentsSection(Context context) {
        this(context, null);
    }

    public AttachmentsSection(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttachmentsSection(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m990a(AttachmentsSection.class, (View) this);
        setContentView(2130903306);
    }

    private void m988a() {
        if (this.f1016c != null) {
            this.f1016c.setVisibility(8);
        }
        if (this.f1015b != null) {
            this.f1015b.setVisibility(8);
        }
        if (this.f1019f != null) {
            this.f1019f.setVisibility(8);
        }
    }

    private void m989a(DefaultShareAttachmentBinder defaultShareAttachmentBinder) {
        this.f1014a = defaultShareAttachmentBinder;
    }

    private void m992b() {
        if (this.f1015b == null) {
            this.f1015b = (AttachmentViewSticker) ((ViewStub) c(2131559720)).inflate();
        }
        this.f1015b.setVisibility(0);
        this.f1015b.m979a(this.f1018e);
    }

    private void m993e() {
        if (this.f1016c == null) {
            this.f1016c = (AttachmentViewPhoto) ((ViewStub) c(2131559721)).inflate();
        }
        this.f1016c.setVisibility(0);
        this.f1016c.m951a(this.f1018e);
    }

    public final void m996a(FeedProps<GraphQLComment> feedProps, AttachmentStyleUtil attachmentStyleUtil) {
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        if (graphQLComment == null || !GraphQLCommentHelper.b(graphQLComment)) {
            setVisibility(8);
            return;
        }
        m988a();
        this.f1018e = feedProps.a(GraphQLCommentHelper.c(graphQLComment));
        switch (C00971.f1013a[attachmentStyleUtil.a(this.f1018e).ordinal()]) {
            case 1:
                m992b();
                return;
            case 2:
                m993e();
                return;
            case 3:
                m994f();
                return;
            case 4:
                m995g();
                return;
            default:
                return;
        }
    }

    private void m994f() {
        if (this.f1017d == null) {
            this.f1017d = (AttachmentViewStaticVideo) ((ViewStub) c(2131559722)).inflate();
        }
        this.f1017d.setVisibility(0);
        this.f1017d.m951a(this.f1018e);
    }

    private void m995g() {
        if (this.f1019f == null) {
            this.f1019f = (ImageBlockLayout) ((ViewStub) c(2131559723)).inflate();
        }
        this.f1019f.setVisibility(0);
        this.f1014a.m998a(this.f1019f, (GraphQLStoryAttachment) this.f1018e.a);
    }
}

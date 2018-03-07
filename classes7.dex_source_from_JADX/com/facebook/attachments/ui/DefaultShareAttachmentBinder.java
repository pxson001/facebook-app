package com.facebook.attachments.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: uploadContactBatchForMessaging */
public class DefaultShareAttachmentBinder {
    public ImageBlockLayout f1021a;
    public FbUriIntentHandler f1022b;
    public GraphQLStoryAttachment f1023c;
    public LinkifyUtil f1024d;
    public TextView f1025e;
    public TextView f1026f;
    public TextView f1027g;

    /* compiled from: uploadContactBatchForMessaging */
    public class C00981 implements OnClickListener {
        final /* synthetic */ DefaultShareAttachmentBinder f1020a;

        public C00981(DefaultShareAttachmentBinder defaultShareAttachmentBinder) {
            this.f1020a = defaultShareAttachmentBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -398983258);
            this.f1020a.f1022b.a(this.f1020a.f1021a.getContext(), this.f1020a.f1023c.C());
            Logger.a(2, EntryType.UI_INPUT_END, 962446869, a);
        }
    }

    public static DefaultShareAttachmentBinder m997b(InjectorLike injectorLike) {
        return new DefaultShareAttachmentBinder(FbUriIntentHandler.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    @Inject
    public DefaultShareAttachmentBinder(FbUriIntentHandler fbUriIntentHandler, LinkifyUtil linkifyUtil) {
        this.f1022b = fbUriIntentHandler;
        this.f1024d = linkifyUtil;
    }

    public final void m998a(ImageBlockLayout imageBlockLayout, GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(imageBlockLayout);
        this.f1021a = imageBlockLayout;
        this.f1023c = graphQLStoryAttachment;
        this.f1025e = (TextView) this.f1021a.findViewById(2131559711);
        this.f1026f = (TextView) this.f1021a.findViewById(2131559712);
        this.f1027g = (TextView) this.f1021a.findViewById(2131559713);
        if (GraphQLStoryAttachmentUtil.l(this.f1023c) != null) {
            this.f1021a.setThumbnailUri(ImageUtil.a(GraphQLStoryAttachmentUtil.l(this.f1023c)));
        }
        this.f1025e.setText(this.f1023c.A());
        if (this.f1023c.n() == null) {
            this.f1026f.setVisibility(8);
        } else {
            CharSequence a = this.f1024d.a(LinkifyUtilConverter.c(this.f1023c.n()));
            if (TextUtils.getTrimmedLength(a) == 0) {
                this.f1026f.setVisibility(8);
            } else {
                this.f1026f.setText(a);
            }
        }
        this.f1027g.setText(GraphQLStoryAttachmentUtil.s(this.f1023c));
        Preconditions.checkNotNull(this.f1023c.C());
        OnClickListener c00981 = new C00981(this);
        this.f1021a.setOnClickListener(c00981);
        this.f1025e.setOnClickListener(c00981);
        this.f1026f.setOnClickListener(c00981);
        this.f1027g.setOnClickListener(c00981);
    }
}

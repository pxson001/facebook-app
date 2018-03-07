package com.facebook.ufiservices.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.ufiservices.flyout.EditCommentFragment.C13041;
import com.facebook.ufiservices.module.C1336x1da0976a;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: custom_life_event */
public abstract class CommentEditView extends CustomRelativeLayout {
    public static final CallerContext f18175d = CallerContext.a(CommentEditView.class, "story_feedback_flyout");
    @Inject
    public InputMethodManager f18176a;
    @Inject
    public TaggingProfiles f18177b;
    @UfiSupportedAttachmentStyle
    @Inject
    public AttachmentStyleUtil f18178c;
    public final Context f18179e;
    public final FbDraweeView f18180f;
    public final MentionsAutoCompleteTextView f18181g;
    public final Button f18182h;
    public final Button f18183i;
    public final CommentAttachmentViewStub f18184j;
    public CommentAttachmentView f18185k;
    public GraphQLComment f18186l;
    public FeedProps<GraphQLComment> f18187m;
    public C13041 f18188n;
    public boolean f18189o;

    /* compiled from: custom_life_event */
    public class C13371 implements TextWatcher {
        final /* synthetic */ CommentEditView f18250a;

        public C13371(CommentEditView commentEditView) {
            this.f18250a = commentEditView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            Button button = this.f18250a.f18182h;
            boolean z = !StringUtil.c(editable) || CommentEditView.m26722c(this.f18250a);
            button.setEnabled(z);
        }
    }

    /* compiled from: custom_life_event */
    public class C13382 implements OnClickListener {
        final /* synthetic */ CommentEditView f18251a;

        public C13382(CommentEditView commentEditView) {
            this.f18251a = commentEditView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1423332678);
            this.f18251a.f18181g.clearFocus();
            this.f18251a.f18176a.hideSoftInputFromWindow(this.f18251a.getWindowToken(), 0);
            this.f18251a.f18188n.m26530a(this.f18251a.f18186l, this.f18251a.f18181g.getText());
            Logger.a(2, EntryType.UI_INPUT_END, -156033729, a);
        }
    }

    /* compiled from: custom_life_event */
    public class C13393 implements OnClickListener {
        final /* synthetic */ CommentEditView f18252a;

        public C13393(CommentEditView commentEditView) {
            this.f18252a = commentEditView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 272936104);
            this.f18252a.m26723a();
            Logger.a(2, EntryType.UI_INPUT_END, 758872842, a);
        }
    }

    public static void m26721a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CommentEditView commentEditView = (CommentEditView) obj;
        InputMethodManager b = InputMethodManagerMethodAutoProvider.b(injectorLike);
        TaggingProfiles b2 = TaggingProfiles.m25203b(injectorLike);
        AttachmentStyleUtil a = C1336x1da0976a.m26778a(injectorLike);
        commentEditView.f18176a = b;
        commentEditView.f18177b = b2;
        commentEditView.f18178c = a;
    }

    public CommentEditView(Context context) {
        this(context, null);
    }

    public CommentEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18189o = false;
        setContentView(2130903622);
        this.f18179e = context;
        Class cls = CommentEditView.class;
        m26721a(this, getContext());
        this.f18180f = (FbDraweeView) a(2131560426);
        this.f18181g = (MentionsAutoCompleteTextView) a(2131560427);
        this.f18182h = (Button) a(2131560429);
        this.f18183i = (Button) a(2131560428);
        this.f18184j = (CommentAttachmentViewStub) a(2131560430);
    }

    public final void m26723a() {
        this.f18181g.clearFocus();
        this.f18176a.hideSoftInputFromWindow(getWindowToken(), 0);
        if (this.f18188n != null) {
            this.f18188n.f18022a.ay.O_();
        }
    }

    public static boolean m26722c(CommentEditView commentEditView) {
        return GraphQLCommentHelper.b(commentEditView.f18186l) && commentEditView.f18178c.m10451a(commentEditView.f18187m.a(GraphQLCommentHelper.c(commentEditView.f18186l))) == GraphQLStoryAttachmentStyle.PHOTO;
    }
}

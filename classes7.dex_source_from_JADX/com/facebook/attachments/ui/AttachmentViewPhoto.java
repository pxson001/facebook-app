package com.facebook.attachments.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: url_rules */
public class AttachmentViewPhoto extends CustomFrameLayout {
    private static final CallerContext f970g = CallerContext.a(AttachmentViewPhoto.class, "story_feedback_flyout");
    @Inject
    DefaultFeedIntentBuilder f971a;
    @Inject
    PhotoAttachmentLayoutHelper f972b;
    @Inject
    SecureContextHelper f973c;
    @Inject
    PendingCommentCache f974d;
    @Inject
    AutomaticPhotoCaptioningUtils f975e;
    @Inject
    DialtoneController f976f;
    private FeedProps<GraphQLStoryAttachment> f977h;
    public FbDraweeView f978i;
    private View f979j;

    /* compiled from: url_rules */
    class C00871 implements OnClickListener {
        final /* synthetic */ AttachmentViewPhoto f969a;

        C00871(AttachmentViewPhoto attachmentViewPhoto) {
            this.f969a = attachmentViewPhoto;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -45459872);
            this.f969a.mo49a();
            Logger.a(2, EntryType.UI_INPUT_END, 1230747042, a);
        }
    }

    private static <T extends View> void m943a(Class<T> cls, T t) {
        m944a((Object) t, t.getContext());
    }

    private static void m944a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AttachmentViewPhoto) obj).m942a(DefaultFeedIntentBuilder.a(fbInjector), PhotoAttachmentLayoutHelper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PendingCommentCache.a(fbInjector), AutomaticPhotoCaptioningUtils.b(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector));
    }

    public AttachmentViewPhoto(Context context) {
        this(context, null, 0);
    }

    public AttachmentViewPhoto(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttachmentViewPhoto(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m946b();
    }

    private void m946b() {
        m943a(AttachmentViewPhoto.class, (View) this);
        setContentView(2130903304);
        this.f978i = (FbDraweeView) c(2131559717);
    }

    public final void m951a(FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f977h = feedProps;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) this.f977h.a;
        if (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) {
            setVisibility(8);
            return;
        }
        setupImageView(graphQLStoryAttachment);
        m947e();
        m948f();
        CharSequence a = m941a(graphQLStoryAttachment);
        FbDraweeView fbDraweeView = this.f978i;
        if (a == null) {
            a = getContext().getString(2131230814);
        }
        fbDraweeView.setContentDescription(a);
        setVisibility(0);
    }

    private void m942a(DefaultFeedIntentBuilder defaultFeedIntentBuilder, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, SecureContextHelper secureContextHelper, PendingCommentCache pendingCommentCache, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, DialtoneController dialtoneController) {
        this.f971a = defaultFeedIntentBuilder;
        this.f972b = photoAttachmentLayoutHelper;
        this.f973c = secureContextHelper;
        this.f974d = pendingCommentCache;
        this.f975e = automaticPhotoCaptioningUtils;
        this.f976f = dialtoneController;
    }

    private static float m940a(int i, int i2) {
        float f;
        if (i == 0 || i2 == 0) {
            f = 0.0f;
        } else {
            f = (((float) i) * 1.0f) / ((float) i2);
        }
        if (f == 0.0f || m945a(f)) {
            return 1.3333334f;
        }
        return f;
    }

    private static boolean m945a(float f) {
        return f < 0.4f;
    }

    private void m947e() {
        if (!m949g()) {
            if (this.f979j == null) {
                this.f979j = ((ViewStub) c(2131559718)).inflate();
            }
            this.f979j.setVisibility(0);
        } else if (this.f979j != null) {
            this.f979j.setVisibility(8);
        }
    }

    private void m948f() {
        OnClickListener onClickListener = null;
        if (m949g()) {
            onClickListener = new C00871(this);
        }
        setOnClickListener(onClickListener);
        this.f978i.setOnClickListener(onClickListener);
    }

    protected void mo49a() {
        if (!this.f976f.b()) {
            DefaultFeedIntentBuilder defaultFeedIntentBuilder = this.f971a;
            long parseLong = Long.parseLong(((GraphQLStoryAttachment) this.f977h.a).r().b());
            String t = ((GraphQLStoryAttachment) this.f977h.a).t();
            FullscreenGallerySource fullscreenGallerySource = FullscreenGallerySource.PHOTO_COMMENT;
            Intent component = new Intent().setComponent(new ComponentName(defaultFeedIntentBuilder.a, "com.facebook.photos.mediagallery.ui.MediaGalleryActivity"));
            component.putExtra("photo_fbid", parseLong);
            component.putExtra("photoset_token", t);
            component.putExtra("comment_photo", true);
            component.putExtra("fullscreen_gallery_source", fullscreenGallerySource.name());
            this.f973c.a(component, getContext());
        }
    }

    protected void setupImageView(GraphQLStoryAttachment graphQLStoryAttachment) {
        PhotoAttachmentInfo b = this.f972b.b(graphQLStoryAttachment.r());
        LayoutParams layoutParams = this.f978i.getLayoutParams();
        layoutParams.width = b.e;
        layoutParams.height = b.f;
        this.f978i.setLayoutParams(layoutParams);
        this.f978i.setAspectRatio(m940a(b.e, b.f));
        this.f978i.a(b.a(), f970g);
    }

    public FbDraweeView getImageView() {
        return this.f978i;
    }

    protected GraphQLStoryAttachment getAttachment() {
        return (GraphQLStoryAttachment) this.f977h.a;
    }

    private boolean m949g() {
        GraphQLComment h = AttachmentProps.h(this.f977h);
        if (h == null) {
            return false;
        }
        GraphQLFeedOptimisticPublishState c = this.f974d.c(h.H());
        if (c == GraphQLFeedOptimisticPublishState.RETRYING_IN_BACKGROUND || c == GraphQLFeedOptimisticPublishState.POSTING) {
            return false;
        }
        return true;
    }

    private String m941a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return this.f975e.a() ? graphQLStoryAttachment.r().k() : null;
    }
}

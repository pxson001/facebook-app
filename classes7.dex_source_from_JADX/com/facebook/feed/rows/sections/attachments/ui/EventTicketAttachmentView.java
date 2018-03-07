package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V_MS/VFW/FOURCC */
public class EventTicketAttachmentView extends CustomLinearLayout implements AttachmentHasLargeImage {
    public static final ViewType f21056a = new C17861();
    @Inject
    public AnalyticsTagger f21057b;
    private final FbDraweeView f21058c = ((FbDraweeView) a(2131561432));
    public final FbButton f21059d = ((FbButton) a(2131561436));

    /* compiled from: V_MS/VFW/FOURCC */
    final class C17861 extends ViewType {
        C17861() {
        }

        public final View m23937a(Context context) {
            return new EventTicketAttachmentView(context);
        }
    }

    public static void m23938a(Object obj, Context context) {
        ((EventTicketAttachmentView) obj).f21057b = AnalyticsTagger.a(FbInjector.get(context));
    }

    public EventTicketAttachmentView(Context context) {
        super(context);
        setContentView(2130904103);
        setOrientation(1);
        Class cls = EventTicketAttachmentView.class;
        m23938a(this, getContext());
        Resources resources = getResources();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = resources.getDrawable(2131361934);
        this.f21058c.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.h).u());
        this.f21057b.a(this, "newsfeed_angora_attachment_view", getClass());
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
        TrackingNodes.a(a(2131561433), TrackingNode.TITLE);
    }

    public void setLargeImageAspectRatio(float f) {
        this.f21058c.setAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        this.f21058c.setVisibility(draweeController != null ? 0 : 8);
        this.f21058c.setController(draweeController);
    }
}

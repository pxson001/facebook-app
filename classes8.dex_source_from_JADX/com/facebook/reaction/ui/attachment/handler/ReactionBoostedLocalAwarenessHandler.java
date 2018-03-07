package com.facebook.reaction.ui.attachment.handler;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.maps.FbStaticMapView;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: WRITE_REVIEW_PUBLISH */
public class ReactionBoostedLocalAwarenessHandler extends ReactionAttachmentHandler {
    @Inject
    public ReactionBoostedLocalAwarenessHandler(ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    public final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        LinearLayout linearLayout = (LinearLayout) m22840a(2130906618);
        ContentView contentView = (ContentView) linearLayout.findViewById(2131566639);
        contentView.setThumbnailUri(Uri.parse(reactionStoryAttachmentFragmentModel.U().b()));
        contentView.setTitleText(reactionStoryAttachmentFragmentModel.z().a());
        contentView.setMaxLinesFromThumbnailSize(false);
        contentView.setGravity(48);
        contentView.setThumbnailSize(ThumbnailSize.LARGE);
        contentView.setTitleTextAppearance(2131625826);
        FbStaticMapView fbStaticMapView = (FbStaticMapView) linearLayout.findViewById(2131566636);
        DefaultLocationFields y = reactionStoryAttachmentFragmentModel.y();
        fbStaticMapView.setMapOptions(new StaticMapOptions("aymt_local_awareness_tip").a(m24454a(y.a(), y.b(), reactionStoryAttachmentFragmentModel.O() * 1000.0d, contentView.getResources())).a(y.a(), y.b()));
        FbTextView fbTextView = (FbTextView) linearLayout.findViewById(2131566638);
        ((FbTextView) linearLayout.findViewById(2131566637)).setText(reactionStoryAttachmentFragmentModel.G());
        fbTextView.setText(reactionStoryAttachmentFragmentModel.F());
        return linearLayout;
    }

    private static int m24454a(double d, double d2, double d3, Resources resources) {
        double log = Math.log(((double) (((int) resources.getDimension(2131431495)) / 2)) / (((double) Math.abs(Projection.d(Projection.a(d2, d, d3)) - Projection.d(d2))) * 512.0d)) / Math.log(2.0d);
        int i = (int) log;
        return (int) ((Math.pow(2.0d, log % 1.0d) - 1.0d) + ((double) i));
    }

    public final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.U() == null || reactionStoryAttachmentFragmentModel.U().b() == null || reactionStoryAttachmentFragmentModel.z() == null || reactionStoryAttachmentFragmentModel.y() == null) ? false : true;
    }
}

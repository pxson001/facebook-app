package com.facebook.pages.identity.cards.service;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.common.util.PagesFormatUtils;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel.OrderedImagesModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel.OrderedImagesModel.ImageModel;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: pluginState */
public class PageIdentityServiceCardView extends CustomLinearLayout implements PageSecondaryCardView {
    @Inject
    public FbUriIntentHandler f3728a;
    @Inject
    public Lazy<PagesAnalytics> f3729b;
    public String f3730c;
    public String f3731d;
    public boolean f3732e;
    private SegmentedLinearLayout f3733f;
    public final OnClickListener f3734g = new C05091(this);

    /* compiled from: pluginState */
    class C05091 implements OnClickListener {
        final /* synthetic */ PageIdentityServiceCardView f3727a;

        C05091(PageIdentityServiceCardView pageIdentityServiceCardView) {
            this.f3727a = pageIdentityServiceCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -488657668);
            Bundle bundle = new Bundle();
            bundle.putString("com.facebook.katana.profile.id", this.f3727a.f3730c);
            bundle.putString("profile_name", this.f3727a.f3731d);
            bundle.putBoolean("can_viewer_create_content_extra", this.f3727a.f3732e);
            String obj = view.getTag().toString();
            if (Strings.isNullOrEmpty(obj)) {
                ((PagesAnalytics) this.f3727a.f3729b.get()).a(Long.parseLong(this.f3727a.f3730c), true);
            } else {
                ((PagesAnalytics) this.f3727a.f3729b.get()).a(Long.parseLong(this.f3727a.f3730c), false);
                bundle.putString("page_clicked_item_id_extra", obj);
            }
            this.f3727a.f3728a.a(this.f3727a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.ag, this.f3727a.f3730c), bundle);
            LogUtils.a(-789978860, a);
        }
    }

    public static void m4721a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityServiceCardView pageIdentityServiceCardView = (PageIdentityServiceCardView) obj;
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 8930);
        pageIdentityServiceCardView.f3728a = a;
        pageIdentityServiceCardView.f3729b = b;
    }

    public PageIdentityServiceCardView(Context context) {
        super(context);
        Class cls = PageIdentityServiceCardView.class;
        m4721a(this, getContext());
        setContentView(2130906036);
        setOrientation(1);
        this.f3732e = false;
        this.f3733f = (SegmentedLinearLayout) a(2131565534);
        BetterTextView betterTextView = (BetterTextView) a(2131565535);
        betterTextView.setTag("");
        betterTextView.setOnClickListener(this.f3734g);
    }

    public final boolean m4722a(String str, String str2, ReactionSession reactionSession) {
        boolean z;
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        if (Strings.isNullOrEmpty(str2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        Preconditions.checkNotNull(reactionSession);
        this.f3730c = str;
        this.f3731d = str2;
        ReactionUnitFragment a = m4720a(reactionSession);
        if (a == null || a.fx_() == null) {
            return false;
        }
        ImmutableList b = a.fx_().b();
        for (int i = 0; i < Math.min(3, b.size()); i++) {
            ReactionStoryAttachmentFragmentModel a2 = ((EdgesModel) b.get(i)).a();
            if (!(a2 == null || a2.D() == null)) {
                PageServiceItemModel D = a2.D();
                View inflate = View.inflate(getContext(), 2130906037, null);
                ImageBlockLayout imageBlockLayout = (ImageBlockLayout) inflate.findViewById(2131565536);
                FbTextView fbTextView = (FbTextView) inflate.findViewById(2131565537);
                FbTextView fbTextView2 = (FbTextView) inflate.findViewById(2131565538);
                if (D.g().isEmpty()) {
                    imageBlockLayout.setShowThumbnail(false);
                } else {
                    ImageModel a3 = ((OrderedImagesModel) D.g().get(0)).a();
                    if (!(a3 == null || Strings.isNullOrEmpty(a3.a()))) {
                        imageBlockLayout.setThumbnailUri(a3.a());
                        imageBlockLayout.setShowThumbnail(true);
                    }
                }
                fbTextView.setText(D.eC_());
                CharSequence a4 = PagesFormatUtils.a(D.c(), getContext().getResources().getString(2131233658), D.b());
                if (Strings.isNullOrEmpty(a4)) {
                    fbTextView2.setVisibility(8);
                } else {
                    fbTextView2.setText(a4);
                }
                inflate.setTag(D.d());
                inflate.setOnClickListener(this.f3734g);
                this.f3733f.addView(inflate);
            }
        }
        return true;
    }

    private static ReactionUnitFragment m4720a(ReactionSession reactionSession) {
        ImmutableList p = reactionSession.p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            ImmutableList a = ((ReactionStories) p.get(i)).a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ReactionStoriesModel.EdgesModel edgesModel = (ReactionStoriesModel.EdgesModel) a.get(i2);
                if (edgesModel.a() != null) {
                    return edgesModel.a();
                }
            }
        }
        return null;
    }
}

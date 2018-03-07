package com.facebook.feedplugins.attachments.collage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost.Util;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.fragment.SouvenirsFragment;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.google.common.base.Preconditions;

/* compiled from: TOO_CLOSE_TO_PREVIOUS_COMMERCIAL_BREAK */
class CollageAttachmentPartDefinition$5 implements OnImageClickListener<StoryCollageItem> {
    final /* synthetic */ String f22558a;
    final /* synthetic */ FeedProps f22559b;
    final /* synthetic */ CollageAttachmentPartDefinition f22560c;

    CollageAttachmentPartDefinition$5(CollageAttachmentPartDefinition collageAttachmentPartDefinition, String str, FeedProps feedProps) {
        this.f22560c = collageAttachmentPartDefinition;
        this.f22558a = str;
        this.f22559b = feedProps;
    }

    public final void m25257a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
        if (!SouvenirsFragment.m26139a(collageAttachmentView.getContext(), (ClickableToastBuilder) this.f22560c.s.get(), (NetworkMonitor) this.f22560c.r.get())) {
            if (this.f22560c.o.a(ExperimentsForSouvenirAbtestModule.a, false)) {
                ((SecureContextHelper) this.f22560c.t.get()).a(new Intent().setComponent(new ComponentName(collageAttachmentView.getContext(), "com.facebook.friendsharing.souvenirs.activity.SouvenirEditorActivity")).putExtra("souvenir_id", (String) Preconditions.checkNotNull(this.f22558a)).putExtra("is_editing_from_composer", false), collageAttachmentView.getContext());
                return;
            }
            Context context = collageAttachmentView.getContext();
            String str = this.f22558a;
            FeedProps feedProps = this.f22559b;
            FragmentManager kO_ = Util.a(context).kO_();
            if (kO_ != null) {
                Fragment souvenirsFragment;
                SouvenirsFragment souvenirsFragment2 = (SouvenirsFragment) kO_.a(SouvenirsFragment.ay);
                if (souvenirsFragment2 == null) {
                    souvenirsFragment = new SouvenirsFragment();
                } else {
                    souvenirsFragment = souvenirsFragment2;
                }
                Bundle bundle = new Bundle();
                bundle.putString("param_souvenir_id", str);
                bundle.putParcelable("param_feed_cache_id", feedProps);
                souvenirsFragment.g(bundle);
                souvenirsFragment.a(kO_, ((Activity) ContextUtils.a(context, Activity.class)).getWindow(), FbRootViewUtil.a(context));
                kO_.b();
            }
        }
    }
}

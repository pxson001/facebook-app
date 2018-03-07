package com.facebook.reaction.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import javax.inject.Inject;

/* compiled from: bounce_from_msite */
public class ReactionDialogActivity extends FbFragmentActivity implements FullScreenVideoPlayerHost {
    @Inject
    ComposerPublishServiceHelper f18794p;
    @Inject
    FragmentFactoryMap f18795q;
    @Inject
    ReactionSessionHelper f18796r;
    @Inject
    FullScreenVideoInflater f18797s;
    private ImmersiveVideoPlayer f18798t;

    private static <T extends Context> void m22802a(Class<T> cls, T t) {
        m22803a((Object) t, (Context) t);
    }

    public static void m22803a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ReactionDialogActivity) obj).m22801a(ComposerPublishServiceHelper.b(fbInjector), (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector), ReactionSessionHelper.m22580b(fbInjector), FullScreenVideoInflater.a(fbInjector));
    }

    public static Intent m22800a(Context context, Intent intent, ReactionQueryParams reactionQueryParams, Surface surface) {
        return new Intent(context, ReactionDialogActivity.class).putExtras(intent).putExtra("close_activity_after_finish", true).putExtra("handle_composer_publish", true).putExtra("query_params", reactionQueryParams).putExtra("reaction_surface", surface);
    }

    protected final void m22804b(Bundle bundle) {
        super.b(bundle);
        Class cls = ReactionDialogActivity.class;
        m22803a((Object) this, (Context) this);
        setContentView(2130906660);
        Intent intent = getIntent();
        if (intent.hasExtra("query_params") && intent.hasExtra("reaction_surface") && !intent.hasExtra("reaction_session_id")) {
            Bundle bundle2;
            Surface surface = (Surface) intent.getSerializableExtra("reaction_surface");
            ReactionSession a = this.f18796r.m22583a(surface, (ReactionQueryParams) intent.getParcelableExtra("query_params"));
            intent.putExtra("reaction_session_id", a.f18658a);
            if (a.f18681x == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = a.f18681x;
            }
            bundle2.putAll(intent.getExtras());
            a.f18681x = bundle2;
        }
        kO_().a().a(2131559609, this.f18795q.a(ContentFragmentType.REACTION_DIALOG_FRAGMENT.ordinal()).a(intent), "chromeless:content:fragment:tag").b();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1756 && i2 == -1) {
            this.f18794p.c(intent);
        }
    }

    public final boolean m22805h() {
        return m22806k().a();
    }

    public final ImmersiveVideoPlayer m22806k() {
        if (this.f18798t == null) {
            this.f18798t = this.f18797s.a(this);
        }
        return this.f18798t;
    }

    public final ImmersiveVideoPlayer m22807l() {
        return null;
    }

    public final ImmersiveVideoPlayer m22808n() {
        return null;
    }

    public final boolean m22809o() {
        return false;
    }

    public void onBackPressed() {
        if (this.f18798t == null || !this.f18798t.a()) {
            super.onBackPressed();
        } else {
            this.f18798t.b();
        }
    }

    private void m22801a(ComposerPublishServiceHelper composerPublishServiceHelper, FragmentFactoryMap fragmentFactoryMap, ReactionSessionHelper reactionSessionHelper, FullScreenVideoInflater fullScreenVideoInflater) {
        this.f18794p = composerPublishServiceHelper;
        this.f18795q = fragmentFactoryMap;
        this.f18796r = reactionSessionHelper;
        this.f18797s = fullScreenVideoInflater;
    }
}

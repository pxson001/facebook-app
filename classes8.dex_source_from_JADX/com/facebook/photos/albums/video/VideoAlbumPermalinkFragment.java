package com.facebook.photos.albums.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.video.VideoAlbumPermalinkActivity.VideoAlbumEntityType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;

/* compiled from: config_fields */
public class VideoAlbumPermalinkFragment extends FbFragment {
    public VideoAlbumPermalinkAdapterProvider f17340a;
    private VideoAlbumPermalinkAdapter f17341b;

    public static void m21354a(Object obj, Context context) {
        ((VideoAlbumPermalinkFragment) obj).f17340a = (VideoAlbumPermalinkAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(VideoAlbumPermalinkAdapterProvider.class);
    }

    public final void m21357c(Bundle bundle) {
        super.c(bundle);
        Class cls = VideoAlbumPermalinkFragment.class;
        m21354a(this, getContext());
    }

    public final View m21356a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -122206787);
        if (this.s != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "The arguments for the fragment should have a long value for user id which is missing");
        this.f17341b = this.f17340a.m21353a(Long.valueOf(this.s.getLong("target_actor_id")), (VideoAlbumEntityType) this.s.getSerializable("target_actor_type"));
        View listView = new ListView(getContext());
        listView.setAdapter(this.f17341b);
        this.f17341b.m21352a();
        LogUtils.f(839450465, a);
        return listView;
    }

    public final void m21355I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 657902524);
        this.f17341b.f17337f.clear();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -927355633, a);
    }
}

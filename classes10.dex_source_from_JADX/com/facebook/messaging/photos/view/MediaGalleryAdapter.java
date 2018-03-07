package com.facebook.messaging.photos.view;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.messaging.sharedimage.VideoMessageView;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: registration_profile_pic_upload_error */
public class MediaGalleryAdapter extends BaseAdapter {
    private List<MediaMessageItem> f3589a;
    private Context f3590b;
    private FragmentManager f3591c;

    public /* synthetic */ Object getItem(int i) {
        return m3420a(i);
    }

    public MediaGalleryAdapter(Context context, List<MediaMessageItem> list, FragmentManager fragmentManager) {
        this.f3589a = list;
        this.f3590b = context;
        this.f3591c = fragmentManager;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getCount() {
        return this.f3589a.size();
    }

    private MediaMessageItem m3420a(int i) {
        return (MediaMessageItem) this.f3589a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (m3420a(i).e().d == Type.VIDEO) {
            return 1;
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaMessageItem a = m3420a(i);
        Preconditions.checkNotNull(a, "Null item in MediaGalleryAdapter.getView");
        if (getItemViewType(i) == 1) {
            view = (VideoMessageView) view;
            if (view == null) {
                view = new VideoMessageView(this.f3590b);
            }
            view.f4031f = a;
            view.f4035j = false;
            Uri uri = view.f4031f.e().f;
            view.f4032g.setVisibility(4);
            view.f4030e.a(uri, VideoMessageView.f4026c);
            view.f4029d = this.f3591c;
        } else {
            view = (PhotoMessageView) view;
            if (view == null) {
                view = new PhotoMessageView(this.f3590b);
            }
            view.setPhotoMessageItem(a);
        }
        return view;
    }
}

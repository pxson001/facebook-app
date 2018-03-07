package com.facebook.messaging.media.mediapicker;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.mediapicker.MediaPickerFragment.ItemClickListener;
import com.facebook.messaging.media.mediapicker.MediaPickerFragment.SelectedMode;
import com.facebook.messaging.media.mediapicker.SelectionState.SelectionListener;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mBlockedType */
public class MediaPickerGridAdapter extends Adapter<ViewHolder> implements SelectionListener {
    public final Predicate<MediaResource> f11703a = new C13131(this);
    private final LayoutInflater f11704b;
    private final PhotoItemControllerProvider f11705c;
    private final VideoItemControllerProvider f11706d;
    private final MediaPickerEnvironment f11707e;
    public final Context f11708f;
    private final PhotoItemListener f11709g = new PhotoItemListener(this);
    private final VideoItemListener f11710h = new VideoItemListener(this);
    public ItemClickListener f11711i;
    public SelectionState f11712j;
    private SelectedMode f11713k;
    public List<MediaResource> f11714l;
    public List<MediaResource> f11715m;

    /* compiled from: mBlockedType */
    class C13131 implements Predicate<MediaResource> {
        final /* synthetic */ MediaPickerGridAdapter f11699a;

        C13131(MediaPickerGridAdapter mediaPickerGridAdapter) {
            this.f11699a = mediaPickerGridAdapter;
        }

        public boolean apply(@Nullable Object obj) {
            return this.f11699a.f11712j.m12385c((MediaResource) obj);
        }
    }

    /* compiled from: mBlockedType */
    /* synthetic */ class C13142 {
        static final /* synthetic */ int[] f11700a = new int[Type.values().length];

        static {
            try {
                f11700a[Type.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11700a[Type.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: mBlockedType */
    public class PhotoItemListener {
        public final /* synthetic */ MediaPickerGridAdapter f11701a;

        public PhotoItemListener(MediaPickerGridAdapter mediaPickerGridAdapter) {
            this.f11701a = mediaPickerGridAdapter;
        }
    }

    /* compiled from: mBlockedType */
    public class VideoItemListener {
        public final /* synthetic */ MediaPickerGridAdapter f11702a;

        public VideoItemListener(MediaPickerGridAdapter mediaPickerGridAdapter) {
            this.f11702a = mediaPickerGridAdapter;
        }
    }

    @Inject
    public MediaPickerGridAdapter(Context context, LayoutInflater layoutInflater, PhotoItemControllerProvider photoItemControllerProvider, VideoItemControllerProvider videoItemControllerProvider, @Assisted MediaPickerEnvironment mediaPickerEnvironment) {
        this.f11708f = context;
        this.f11704b = layoutInflater;
        this.f11705c = photoItemControllerProvider;
        this.f11706d = videoItemControllerProvider;
        this.f11707e = mediaPickerEnvironment;
        this.f11714l = new ArrayList();
        this.f11715m = new ArrayList();
    }

    public final ViewHolder m12371a(ViewGroup viewGroup, int i) {
        View inflate;
        switch (i) {
            case 0:
                inflate = this.f11704b.inflate(2130906196, viewGroup, false);
                PhotoItemControllerProvider photoItemControllerProvider = this.f11705c;
                PhotoItemController photoItemController = new PhotoItemController(FbDraweeControllerBuilder.b(photoItemControllerProvider), ResourcesMethodAutoProvider.a(photoItemControllerProvider), (TimeFormatUtil) DefaultTimeFormatUtil.a(photoItemControllerProvider), inflate);
                photoItemController.f11733w = this.f11709g;
                return photoItemController;
            case 1:
                inflate = this.f11704b.inflate(2130907684, viewGroup, false);
                VideoItemControllerProvider videoItemControllerProvider = this.f11706d;
                ViewHolder videoItemController = new VideoItemController(FbDraweeControllerBuilder.b(videoItemControllerProvider), ResourcesMethodAutoProvider.a(videoItemControllerProvider), (TimeFormatUtil) DefaultTimeFormatUtil.a(videoItemControllerProvider), inflate);
                videoItemController.f11749u = this.f11710h;
                return videoItemController;
            default:
                throw new IllegalStateException("Unexpected view type: " + i);
        }
    }

    public final void m12373a(ViewHolder viewHolder, int i) {
        MediaResource mediaResource = (MediaResource) m12370d(this).get(i);
        int itemViewType = getItemViewType(i);
        switch (itemViewType) {
            case 0:
                boolean z;
                Object obj;
                PhotoItemController photoItemController = (PhotoItemController) viewHolder;
                if (mediaResource.d == Type.PHOTO) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                photoItemController.f11734x = mediaResource;
                String a = photoItemController.f11725o.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, mediaResource.A);
                photoItemController.f11727q.setContentDescription(photoItemController.f11724n.getString(2131240887, new Object[]{a}));
                ImageRequestBuilder a2 = ImageRequestBuilder.a(mediaResource.c);
                a2.d = photoItemController.f11726p;
                photoItemController.f11727q.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) photoItemController.f11723m.p().a(PhotoItemController.f11722l).a(photoItemController.f11730t)).c(a2.m())).b(photoItemController.f11727q.getController())).s());
                photoItemController.f11727q.setVisibility(0);
                photoItemController.f11729s.setVisibility(8);
                boolean c = this.f11712j.m12385c(mediaResource);
                if (photoItemController.f11728r.isChecked() != c) {
                    photoItemController.f11728r.setChecked(c);
                }
                if (this.f11707e.f11678b) {
                    obj = null;
                } else {
                    obj = 1;
                }
                photoItemController.f11728r.setVisibility(obj != null ? 0 : 8);
                return;
            case 1:
                ((VideoItemController) viewHolder).m12388a(mediaResource);
                return;
            default:
                throw new IllegalStateException("Unexpected view type: " + itemViewType);
        }
    }

    public static List m12370d(MediaPickerGridAdapter mediaPickerGridAdapter) {
        return mediaPickerGridAdapter.f11713k == SelectedMode.ALL ? mediaPickerGridAdapter.f11714l : mediaPickerGridAdapter.f11715m;
    }

    public final int aZ_() {
        return m12370d(this).size();
    }

    public int getItemViewType(int i) {
        Type type = ((MediaResource) m12370d(this).get(i)).d;
        switch (C13142.f11700a[type.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                throw new IllegalStateException("Unexpected media resource type: " + type);
        }
    }

    private void m12369a(long j) {
        Iterator it = this.f11715m.iterator();
        while (it.hasNext()) {
            MediaResource mediaResource = (MediaResource) it.next();
            if (mediaResource.d == Type.PHOTO && mediaResource.g == j) {
                it.remove();
                if (this.f11713k == SelectedMode.SELECTED) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public final void mo455a(long j, boolean z) {
        if (z) {
            List list = this.f11715m;
            for (MediaResource mediaResource : this.f11714l) {
                if (mediaResource.g == j && mediaResource.d == Type.PHOTO) {
                    break;
                }
            }
            MediaResource mediaResource2 = null;
            list.add(mediaResource2);
            return;
        }
        m12369a(j);
    }

    public final void m12374a(SelectedMode selectedMode) {
        if (this.f11713k != selectedMode) {
            this.f11713k = selectedMode;
            notifyDataSetChanged();
        }
    }
}

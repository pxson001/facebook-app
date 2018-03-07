package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.mediagallery.ui.MediaGalleryFragment;
import com.facebook.photos.mediagallery.ui.MediaGalleryFragment.C02866;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment.C02891;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: singleLine */
public class MediaGalleryPlayButton extends ImageView {
    @Inject
    public MediaGalleryVideoChromeController f2808a;
    public String f2809b;

    /* compiled from: singleLine */
    class C03611 implements OnClickListener {
        final /* synthetic */ MediaGalleryPlayButton f2807a;

        C03611(MediaGalleryPlayButton mediaGalleryPlayButton) {
            this.f2807a = mediaGalleryPlayButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1280431983);
            MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2807a.f2808a;
            String str = this.f2807a.f2809b;
            for (C02891 c02891 : mediaGalleryVideoChromeController.f2834b.keySet()) {
                if (c02891 != null) {
                    if (c02891.f2419a.f2428e != null && MediaGalleryVideoPageFragment.m2551a(c02891.f2419a, str)) {
                        C02866 c02866;
                        String str2;
                        if (MediaGalleryVideoPageFragment.at(c02891.f2419a)) {
                            c02891.f2419a.f2428e.b(EventTriggerType.BY_USER);
                        } else {
                            c02891.f2419a.f2428e.a(EventTriggerType.BY_USER);
                            if (c02891.f2419a.f2426c.f2833a != null) {
                                c02866 = c02891.f2419a.f2426c.f2833a;
                                str2 = c02891.f2419a.f2429f;
                                c02866.m2496a();
                            }
                        }
                        if (c02891.f2419a.f2426c.f2833a != null) {
                            boolean z;
                            c02866 = c02891.f2419a.f2426c.f2833a;
                            str2 = c02891.f2419a.f2429f;
                            boolean at = MediaGalleryVideoPageFragment.at(c02891.f2419a);
                            MediaGalleryFragment mediaGalleryFragment = c02866.f2383a;
                            if (at) {
                                z = false;
                            } else {
                                z = true;
                            }
                            mediaGalleryFragment.bd = z;
                        }
                    }
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1579183350, a);
        }
    }

    private static <T extends View> void m2860a(Class<T> cls, T t) {
        m2861a((Object) t, t.getContext());
    }

    private static void m2861a(Object obj, Context context) {
        ((MediaGalleryPlayButton) obj).f2808a = MediaGalleryVideoChromeController.m2873a(FbInjector.get(context));
    }

    public MediaGalleryPlayButton(Context context) {
        this(context, null);
    }

    public MediaGalleryPlayButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaGalleryPlayButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2860a(MediaGalleryPlayButton.class, (View) this);
        setOnClickListener(new C03611(this));
    }

    public final void m2862a() {
        setImageResource(2130842698);
    }

    public final void m2863b() {
        setImageResource(2130842534);
    }

    public void setMediaId(String str) {
        this.f2809b = str;
    }

    private void m2859a(MediaGalleryVideoChromeController mediaGalleryVideoChromeController) {
        this.f2808a = mediaGalleryVideoChromeController;
    }
}

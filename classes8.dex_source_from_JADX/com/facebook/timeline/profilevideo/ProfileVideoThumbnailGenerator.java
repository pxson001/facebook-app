package com.facebook.timeline.profilevideo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.animation.AnimationUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.timeline.profilevideo.ProfileVideoEditFragment.C09651;
import com.facebook.timeline.profilevideo.ProfileVideoEditFragment.C09662;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel.Builder;
import com.facebook.timeline.profilevideo.model.ProfileVideoModelStore;
import com.facebook.timeline.profilevideo.service.ProfileVideoThumbnailTaskManager;
import com.facebook.timeline.profilevideo.service.ProfileVideoThumbnailTaskManager.C09822;
import com.facebook.timeline.profilevideo.view.ScrubberThumb;
import com.facebook.video.scrubber.GLFrameRetriever;
import com.facebook.video.scrubber.GLFrameRetrieverProvider;
import com.facebook.videocodec.effects.renderers.EffectsFactory;
import com.facebook.videocodec.effects.renderers.EffectsFactory.EffectsBuilder;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: mPresenceAcquiredAt */
public class ProfileVideoThumbnailGenerator {
    private static final CallerContext f9350a = CallerContext.a(ProfileVideoThumbnailGenerator.class, "create_profile_video_android");
    public final ProfileVideoThumbnailTaskManager f9351b;
    private final EffectsFactory f9352c;
    private GLFrameRetriever f9353d;
    private GLFrameRetrieverProvider f9354e;
    public ProfileVideoModel f9355f;
    private ProfileVideoEditFragment f9356g;

    @Inject
    public ProfileVideoThumbnailGenerator(ProfileVideoThumbnailTaskManager profileVideoThumbnailTaskManager, GLFrameRetrieverProvider gLFrameRetrieverProvider, EffectsFactory effectsFactory) {
        this.f9351b = profileVideoThumbnailTaskManager;
        this.f9354e = gLFrameRetrieverProvider;
        this.f9352c = effectsFactory;
    }

    public final void m11109a(ProfileVideoModel profileVideoModel) {
        this.f9355f = profileVideoModel;
        m11103b();
    }

    public final void m11108a(ProfileVideoEditFragment profileVideoEditFragment) {
        this.f9356g = profileVideoEditFragment;
        m11103b();
    }

    private void m11103b() {
        m11105a();
        this.f9353d = null;
    }

    public static GLFrameRetriever m11104c(ProfileVideoThumbnailGenerator profileVideoThumbnailGenerator) {
        if (profileVideoThumbnailGenerator.f9353d != null) {
            return profileVideoThumbnailGenerator.f9353d;
        }
        Preconditions.checkNotNull(profileVideoThumbnailGenerator.f9355f);
        EffectsBuilder a = profileVideoThumbnailGenerator.f9352c.a();
        if (!(profileVideoThumbnailGenerator.f9355f.f9372e == null || profileVideoThumbnailGenerator.f9355f.f9372e.f() == null)) {
            a.a(Uri.parse(profileVideoThumbnailGenerator.f9355f.f9372e.f()), f9350a);
        }
        VideoMirroringMode videoMirroringMode = VideoMirroringMode.NONE;
        if (profileVideoThumbnailGenerator.f9355f.f9372e != null && profileVideoThumbnailGenerator.f9355f.f9372e.h()) {
            videoMirroringMode = VideoMirroringMode.MIRROR_HORIZONTALLY;
        }
        profileVideoThumbnailGenerator.f9353d = profileVideoThumbnailGenerator.f9354e.a(profileVideoThumbnailGenerator.f9355f.f9368a, profileVideoThumbnailGenerator.f9356g, a.a(), videoMirroringMode);
        return profileVideoThumbnailGenerator.f9353d;
    }

    public final void m11106a(final int i, final C09651 c09651, final float f) {
        Preconditions.checkNotNull(this.f9355f);
        this.f9351b.m11159a(new Callable<CloseableReference<Bitmap>>(this) {
            final /* synthetic */ ProfileVideoThumbnailGenerator f9339c;

            public Object call() {
                return ProfileVideoThumbnailGenerator.m11104c(this.f9339c).a(i, f);
            }
        }, new AbstractDisposableFutureCallback<CloseableReference<Bitmap>>(this) {
            final /* synthetic */ ProfileVideoThumbnailGenerator f9342c;

            protected final void m11099a(Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                if (closeableReference != null) {
                    C09651 c09651 = c09651;
                    int i = i;
                    if (c09651.f9286a.hn_()) {
                        if (c09651.f9286a.aq != null) {
                            c09651.f9286a.aq.close();
                        }
                        c09651.f9286a.aq = closeableReference;
                        ProfileVideoModel ar = ProfileVideoEditFragment.ar(c09651.f9286a);
                        if (ar != null) {
                            ProfileVideoEditFragment profileVideoEditFragment = c09651.f9286a;
                            Builder m = ar.m11136m();
                            m.f9362c = i;
                            ar = m.m11121a();
                            FragmentActivity o = profileVideoEditFragment.o();
                            if (o instanceof ProfileVideoModelStore) {
                                ((ProfileVideoModelStore) o).mo597a(ar);
                            }
                            if (c09651.f9286a.f9293d != null) {
                                c09651.f9286a.f9293d.m11205a((Bitmap) closeableReference.a());
                            }
                            if (c09651.f9286a.f9296g != null) {
                                c09651.f9286a.f9296g.setImageBitmap((Bitmap) closeableReference.a());
                            }
                            if (c09651.f9286a.an != null) {
                                ScrubberThumb scrubberThumb = c09651.f9286a.an;
                                scrubberThumb.f9490h = (Bitmap) closeableReference.a();
                                scrubberThumb.invalidateSelf();
                            }
                            c09651.f9286a.al = false;
                            ProfileVideoEditFragment.as(c09651.f9286a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                c09651.m11047a(i);
            }

            protected final void m11100a(Throwable th) {
                BLog.b(ProfileVideoPreviewActivity.class, "Failed to extract bitmap %s", new Object[]{th.getMessage()});
                c09651.m11047a(i);
            }
        });
    }

    public final void m11107a(final int i, final C09662 c09662, final float f, final int i2) {
        Callable c09763 = new Callable<CloseableReference<Bitmap>>(this) {
            final /* synthetic */ ProfileVideoThumbnailGenerator f9345c;

            public Object call() {
                return ProfileVideoThumbnailGenerator.m11104c(this.f9345c).a(i2, f);
            }
        };
        C09774 c09774 = new AbstractDisposableFutureCallback<CloseableReference<Bitmap>>(this) {
            final /* synthetic */ ProfileVideoThumbnailGenerator f9349d;

            protected final void m11101a(Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                if (closeableReference != null) {
                    C09662 c09662 = c09662;
                    int i = i;
                    if (c09662.f9287a.hn_()) {
                        c09662.f9287a.ar.add(closeableReference);
                        if (c09662.f9287a.f9297h != null) {
                            int childCount = c09662.f9287a.f9297h.getChildCount();
                            if (childCount > i) {
                                FbDraweeView fbDraweeView = (FbDraweeView) c09662.f9287a.f9297h.getChildAt(i);
                                RoundingParams b = i == 0 ? RoundingParams.b(c09662.f9287a.ap, 0.0f, 0.0f, c09662.f9287a.ap) : i == childCount + -1 ? RoundingParams.b(0.0f, c09662.f9287a.ap, c09662.f9287a.ap, 0.0f) : null;
                                GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyBuilder.a(c09662.f9287a.jW_()).a(new BitmapDrawable(c09662.f9287a.jW_(), (Bitmap) closeableReference.a()), ScaleType.g);
                                a.u = b;
                                fbDraweeView.setHierarchy(a.u());
                                fbDraweeView.startAnimation(AnimationUtils.loadAnimation(c09662.f9287a.getContext(), 2130968623));
                            }
                        }
                    }
                }
            }

            protected final void m11102a(Throwable th) {
                BLog.b(ProfileVideoPreviewActivity.class, "Failed to extract bitmaps %s", new Object[]{th.getMessage()});
                C09662 c09662 = c09662;
                c09662.f9287a.f9291b.m11107a(i, c09662.f9287a.au, 1.0f, i2);
            }
        };
        ProfileVideoThumbnailTaskManager profileVideoThumbnailTaskManager = this.f9351b;
        profileVideoThumbnailTaskManager.f9400d.add(new CallableAndCallbackHolder(c09763, new C09822(profileVideoThumbnailTaskManager, c09774)));
        if (!profileVideoThumbnailTaskManager.f9401e) {
            profileVideoThumbnailTaskManager.f9401e = true;
            ProfileVideoThumbnailTaskManager.m11157b(profileVideoThumbnailTaskManager);
        }
    }

    public final void m11105a() {
        if (this.f9353d != null) {
            this.f9353d.a();
            this.f9353d = null;
        }
    }
}

package com.facebook.composer.attachments;

import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: place_picker_long_click */
public class AttachmentUtils {
    private AttachmentUtils() {
    }

    public static ImmutableList<ComposerAttachment> m11187a(ImmutableList<ComposerAttachment> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11225a()) {
                builder.c(composerAttachment);
            }
        }
        return builder.b();
    }

    @Nullable
    public static ComposerAttachment m11186a(ImmutableList<ComposerAttachment> immutableList, long j) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11227b() != null && composerAttachment.m11227b().c() == j) {
                return composerAttachment;
            }
        }
        return null;
    }

    public static ImmutableList<PhotoItem> m11189b(ImmutableList<ComposerAttachment> immutableList) {
        Class cls = PhotoItem.class;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11225a()) {
                MediaItem b = composerAttachment.m11227b();
                if (b != null && cls.isInstance(b)) {
                    builder.c(b);
                }
            }
        }
        return builder.b();
    }

    public static ArrayList<CreativeEditingData> m11191c(ImmutableList<ComposerAttachment> immutableList) {
        ArrayList<CreativeEditingData> arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11225a()) {
                MediaItem b = composerAttachment.m11227b();
                if (b != null && b.m() == MediaType.PHOTO) {
                    arrayList.add(composerAttachment.m11230e());
                }
            }
        }
        return arrayList;
    }

    public static boolean m11192d(ImmutableList<ComposerAttachment> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (!composerAttachment.m11225a() || composerAttachment.m11227b() == null || !composerAttachment.m11227b().p()) {
                return false;
            }
        }
        return true;
    }

    public static ImmutableList<MediaItem> m11193e(ImmutableList<ComposerAttachment> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11225a()) {
                builder.c(composerAttachment.m11227b());
            }
        }
        return builder.b();
    }

    @Nullable
    public static ComposerAttachment m11194f(ImmutableList<ComposerAttachment> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (m11188a(composerAttachment)) {
                return composerAttachment;
            }
        }
        return null;
    }

    public static boolean m11188a(ComposerAttachment composerAttachment) {
        return composerAttachment.m11227b() != null && composerAttachment.m11227b().m() == MediaType.VIDEO;
    }

    @Nullable
    public static Uri m11195g(ImmutableList<ComposerAttachment> immutableList) {
        ComposerAttachment f = m11194f(immutableList);
        if (f == null || f.m11227b() == null) {
            return null;
        }
        return Uri.fromFile(new File(f.m11227b().e()));
    }

    public static Bundle m11196h(ImmutableList<ComposerAttachment> immutableList) {
        ComposerAttachment f = m11194f(immutableList);
        if (f == null) {
            return null;
        }
        return (Bundle) m11204p(ImmutableList.of(f)).get(0);
    }

    public static boolean m11197i(ImmutableList<ComposerAttachment> immutableList) {
        return m11194f(immutableList) != null;
    }

    public static boolean m11198j(ImmutableList<ComposerAttachment> immutableList) {
        ComposerAttachment f = m11194f(immutableList);
        return (f == null || f.m11227b() == null || !MediaItem.a.equals(f.m11227b().i())) ? false : true;
    }

    public static boolean m11199k(ImmutableList<ComposerAttachment> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            if (composerAttachment.m11227b() == null || composerAttachment.m11227b().m() != MediaType.PHOTO) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean m11200l(ImmutableList<ComposerAttachment> immutableList) {
        return m11197i(immutableList) && immutableList.size() > 1;
    }

    public static boolean m11201m(ImmutableList<ComposerAttachment> immutableList) {
        return m11199k(immutableList) && !m11197i(immutableList);
    }

    public static boolean m11202n(ImmutableList<ComposerAttachment> immutableList) {
        return m11197i(immutableList) && immutableList.size() == 1;
    }

    public static ImmutableList<MediaItem> m11203o(ImmutableList<ComposerAttachment> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(((ComposerAttachment) immutableList.get(i)).m11227b());
        }
        return builder.b();
    }

    public static ImmutableList<Bundle> m11204p(ImmutableList<ComposerAttachment> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerAttachment composerAttachment = (ComposerAttachment) immutableList.get(i);
            Bundle bundle = new Bundle();
            String a = MentionsUtils.m25501a(composerAttachment.m11229d());
            String str = "caption";
            if (StringUtil.a(a)) {
                a = null;
            }
            bundle.putString(str, a);
            bundle.putParcelable("creative_editing_metadata", composerAttachment.m11230e());
            bundle.putParcelable("video_creative_editing_metadata", composerAttachment.m11231f());
            builder.c(bundle);
        }
        return builder.b();
    }

    public static ImmutableList<String> m11205q(ImmutableList<ComposerAttachment> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(MentionsUtils.m25501a(((ComposerAttachment) immutableList.get(i)).m11229d()));
        }
        return builder.b();
    }

    @Nullable
    public static Location m11185a(ImmutableList<ComposerAttachment> immutableList, MediaItemMetaDataExtractor mediaItemMetaDataExtractor) {
        Location location = null;
        List<MediaItem> arrayList = new ArrayList(m11193e(immutableList));
        Collections.sort(arrayList, MediaItem.b);
        for (MediaItem mediaItem : arrayList) {
            Location a = MediaItemMetaDataExtractor.m11251a(Uri.fromFile(new File(mediaItem.e())));
            if (a != null) {
                long b;
                Uri fromFile = Uri.fromFile(MoreFileUtils.a(mediaItem.e()));
                if (mediaItem.l() == MediaType.PHOTO) {
                    b = MediaItemMetaDataExtractor.m11252b(fromFile);
                } else if (mediaItem.l() == MediaType.VIDEO) {
                    long lastModified = new File(MediaStorage.b(fromFile, mediaItemMetaDataExtractor.f7814d)).lastModified();
                    if (lastModified == 0) {
                        lastModified = -1;
                    }
                    b = lastModified;
                } else {
                    b = -1;
                }
                if (b == -1) {
                    b = mediaItem.j();
                }
                a.setTime(b);
                return a;
            }
            location = a;
        }
        return location;
    }

    public static boolean m11206r(ImmutableList<ComposerAttachment> immutableList) {
        if (immutableList.size() != 1) {
            return false;
        }
        return m11190b((ComposerAttachment) immutableList.get(0)) && (((ComposerAttachment) immutableList.get(0)).m11227b() instanceof PhotoItem) && ((PhotoItem) ((ComposerAttachment) immutableList.get(0)).m11227b()).f12736c;
    }

    @Nullable
    public static String m11207s(ImmutableList<ComposerAttachment> immutableList) {
        if (immutableList.size() == 1 && m11190b((ComposerAttachment) immutableList.get(0))) {
            return ((PhotoItem) ((ComposerAttachment) immutableList.get(0)).m11227b()).f12737d;
        }
        return null;
    }

    public static boolean m11190b(ComposerAttachment composerAttachment) {
        return composerAttachment.m11227b() != null && composerAttachment.m11227b().m() == MediaType.PHOTO;
    }
}

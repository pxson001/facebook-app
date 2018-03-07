package com.facebook.photos.tagging.store;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.RectF;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoMetaDataTableProp.Columns;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableBiMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group_feed_hoisted_story_ids */
public class TaggableLocalMediaUtil {
    private static TaggableLocalMediaUtil f13471g;
    private static final Object f13472h = new Object();
    public final Lazy<PhotosContract> f13473a;
    public final Lazy<ContentResolver> f13474b;
    public final Lazy<Clock> f13475c;
    @Nullable
    private List<String> f13476d = null;
    @Nullable
    public Map<String, List<Tag>> f13477e = null;
    private final TagStore f13478f;

    private static TaggableLocalMediaUtil m21177b(InjectorLike injectorLike) {
        return new TaggableLocalMediaUtil(IdBasedSingletonScopeProvider.b(injectorLike, 7306), IdBasedLazy.a(injectorLike, 22), IdBasedSingletonScopeProvider.b(injectorLike, 609), TagStore.m21155a(injectorLike));
    }

    @Inject
    public TaggableLocalMediaUtil(Lazy<PhotosContract> lazy, Lazy<ContentResolver> lazy2, Lazy<Clock> lazy3, TagStore tagStore) {
        this.f13473a = lazy;
        this.f13474b = lazy2;
        this.f13475c = lazy3;
        this.f13478f = tagStore;
    }

    public static TaggableLocalMediaUtil m21175a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TaggableLocalMediaUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13472h) {
                TaggableLocalMediaUtil taggableLocalMediaUtil;
                if (a2 != null) {
                    taggableLocalMediaUtil = (TaggableLocalMediaUtil) a2.a(f13472h);
                } else {
                    taggableLocalMediaUtil = f13471g;
                }
                if (taggableLocalMediaUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13472h, b3);
                        } else {
                            f13471g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = taggableLocalMediaUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Collection<MediaItem> m21176a(Map<String, MediaItem> map) {
        List<String> d = m21178d();
        if (d != null) {
            for (String str : d) {
                MediaItem mediaItem = (MediaItem) map.get(str);
                if (mediaItem != null && mediaItem.l() == MediaType.PHOTO && (((PhotoItem) mediaItem).f12739f instanceof LocalPhoto)) {
                    ((PhotoItem) mediaItem).f12739f.f12750f = true;
                }
            }
        }
        Map e = m21179e();
        if (e == null) {
            return map.values();
        }
        for (String str2 : e.keySet()) {
            MediaItem mediaItem2 = (MediaItem) map.get(str2);
            if (mediaItem2 != null && mediaItem2.l() == MediaType.PHOTO) {
                this.f13478f.m21163a((TaggablePhoto) ((PhotoItem) mediaItem2).f12739f, (List) e.get(str2));
            }
        }
        return new ArrayList(map.values());
    }

    public final void m21181c() {
        if (this.f13476d == null) {
            m21178d();
        }
        if (this.f13477e == null) {
            m21179e();
        }
    }

    public final void m21180a(PhotoItem photoItem) {
        if (this.f13476d != null && this.f13477e != null) {
            m21176a(ImmutableBiMap.b(PhotoHashUtil.m20207a(photoItem.h(), photoItem.j()), photoItem));
        }
    }

    @Nullable
    private List<String> m21178d() {
        if (this.f13476d != null) {
            return this.f13476d;
        }
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag_prefill_completed");
        stringBuilder.append(" = 1");
        Cursor query = ((ContentResolver) this.f13474b.get()).query(((PhotosContract) this.f13473a.get()).e, new String[]{"photo_hash"}, stringBuilder.toString(), null, null);
        if (query != null) {
            try {
                int i = Columns.a;
                while (query.moveToNext()) {
                    String string = query.getString(i);
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                }
            } finally {
                query.close();
            }
        }
        this.f13476d = arrayList;
        return arrayList;
    }

    @Nullable
    private Map<String, List<Tag>> m21179e() {
        if (this.f13477e != null) {
            return this.f13477e;
        }
        Map<String, List<Tag>> hashMap = new HashMap();
        Cursor query = ((ContentResolver) this.f13474b.get()).query(((PhotosContract) this.f13473a.get()).d, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    String string = query.getString(10);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList());
                    }
                    long j = query.getLong(0);
                    RectF rectF = new RectF(query.getFloat(1), query.getFloat(2), query.getFloat(3), query.getFloat(4));
                    Type type = Type.values()[query.getInt(5)];
                    boolean z = query.getInt(6) == 1;
                    long j2 = query.getLong(7);
                    Tag tag = new Tag(new FaceBox(rectF), new Name(query.getString(9), null, query.getString(8)), j, type, z);
                    tag.m20181a(j2);
                    ((List) hashMap.get(string)).add(tag);
                } finally {
                    query.close();
                }
            }
        }
        this.f13477e = hashMap;
        return hashMap;
    }
}

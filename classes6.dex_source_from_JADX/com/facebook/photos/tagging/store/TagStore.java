package com.facebook.photos.tagging.store;

import android.content.ContentValues;
import android.content.Context;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.photos.PhotosContract;
import com.facebook.ipc.photos.PhotosContract.LocalPhotoTagsTable.Columns;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.tagging.store.LocalPhotoMetaDataStore.SetAutoTagState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_friend_members */
public class TagStore implements IHaveUserData {
    private static volatile TagStore f13459j;
    private final PreFilledTagLogger f13460a;
    private final RemovedPrefilledTagsDataStore f13461b;
    private final PhotosContract f13462c;
    private final Clock f13463d;
    private final Context f13464e;
    private LocalPhotoMetaDataStore f13465f;
    private final ImmutableList<Tag> f13466g = RegularImmutableList.a;
    public final Map<MediaIdKey, List<Tag>> f13467h = Collections.synchronizedMap(new HashMap());
    private final Set<String> f13468i = new HashSet();

    /* compiled from: group_friend_members */
    class AddTagInDbTask extends FbAsyncTask<Void, Void, Void> {
        private Context f13443a;
        private String f13444b;
        private Tag f13445c;
        private final PhotosContract f13446d;
        private final Clock f13447e;

        public AddTagInDbTask(Context context, String str, Tag tag, PhotosContract photosContract, Clock clock) {
            this.f13443a = context;
            this.f13444b = str;
            this.f13445c = tag;
            this.f13446d = photosContract;
            this.f13447e = clock;
        }

        protected final Object m21151a(Object[] objArr) {
            int i;
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.a.d, Long.valueOf(this.f13445c.f12788c));
            contentValues.put(Columns.b.d, Double.valueOf(TagStore.m21157b(this.f13445c.f12786a.mo1099d().left)));
            contentValues.put(Columns.c.d, Double.valueOf(TagStore.m21157b(this.f13445c.f12786a.mo1099d().top)));
            contentValues.put(Columns.d.d, Double.valueOf(TagStore.m21157b(this.f13445c.f12786a.mo1099d().right)));
            contentValues.put(Columns.e.d, Double.valueOf(TagStore.m21157b(this.f13445c.f12786a.mo1099d().bottom)));
            contentValues.put(Columns.f.d, Integer.valueOf(this.f13445c.f12791f.ordinal()));
            String str = Columns.g.d;
            if (this.f13445c.f12790e) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            contentValues.put(Columns.h.d, Long.valueOf(this.f13447e.a()));
            contentValues.put(Columns.i.d, this.f13445c.f12787b.i());
            contentValues.put(Columns.j.d, this.f13445c.f12787b.a());
            contentValues.put(Columns.k.d, this.f13444b);
            this.f13443a.getContentResolver().insert(this.f13446d.d, contentValues);
            return null;
        }
    }

    /* compiled from: group_friend_members */
    class RemoveAllTagsFromPhotoInDbTask extends FbAsyncTask<Void, Void, Void> {
        private Context f13448a;
        private String f13449b;
        private final PhotosContract f13450c;

        protected final Object m21152a(Object[] objArr) {
            this.f13448a.getContentResolver().delete(this.f13450c.d, StringFormatUtil.formatStrLocaleSafe("%s = '%s'", Columns.k.d, this.f13449b), null);
            return null;
        }

        public RemoveAllTagsFromPhotoInDbTask(Context context, String str, PhotosContract photosContract) {
            this.f13448a = context;
            this.f13449b = str;
            this.f13450c = photosContract;
        }
    }

    /* compiled from: group_friend_members */
    class RemoveTagInDbTask extends FbAsyncTask<Void, Void, Void> {
        private Context f13451a;
        private String f13452b;
        private Tag f13453c;
        private final PhotosContract f13454d;

        protected final Object m21153a(Object[] objArr) {
            this.f13451a.getContentResolver().delete(this.f13454d.d, StringFormatUtil.a("%s = ? AND %s = ? AND %s = ? AND %s = ? AND %s = ?", new Object[]{Columns.k.d, Columns.b.d, Columns.c.d, Columns.d.d, Columns.e.d}), new String[]{this.f13452b, Double.toString(TagStore.m21157b(this.f13453c.f12786a.mo1099d().left)), Double.toString(TagStore.m21157b(this.f13453c.f12786a.mo1099d().top)), Double.toString(TagStore.m21157b(this.f13453c.f12786a.mo1099d().right)), Double.toString(TagStore.m21157b(this.f13453c.f12786a.mo1099d().bottom))});
            return null;
        }

        public RemoveTagInDbTask(Context context, String str, Tag tag, PhotosContract photosContract) {
            this.f13451a = context;
            this.f13452b = str;
            this.f13453c = tag;
            this.f13454d = photosContract;
        }
    }

    /* compiled from: group_friend_members */
    class RemoveTagsWithUidInDbTask extends FbAsyncTask<Void, Void, Void> {
        private final Set<Long> f13455a;
        private final Context f13456b;
        private final PhotosContract f13457c;
        private final String f13458d;

        protected final Object m21154a(Object[] objArr) {
            int i;
            int i2 = 1;
            StringBuilder stringBuilder = new StringBuilder("?");
            for (i = 1; i < this.f13455a.size(); i++) {
                stringBuilder.append(",?");
            }
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s = ? AND %s IN (%s)", Columns.k.d, Columns.a.d, stringBuilder.toString());
            String[] strArr = new String[(this.f13455a.size() + 1)];
            strArr[0] = this.f13458d;
            for (Long longValue : this.f13455a) {
                i = i2 + 1;
                strArr[i2] = String.valueOf(longValue.longValue());
                i2 = i;
            }
            this.f13456b.getContentResolver().delete(this.f13457c.d, formatStrLocaleSafe, strArr);
            return null;
        }

        public RemoveTagsWithUidInDbTask(Context context, String str, Set<Long> set, PhotosContract photosContract) {
            this.f13456b = context;
            this.f13458d = str;
            this.f13455a = set;
            this.f13457c = photosContract;
        }
    }

    public static com.facebook.photos.tagging.store.TagStore m21155a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13459j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.tagging.store.TagStore.class;
        monitor-enter(r1);
        r0 = f13459j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21158b(r0);	 Catch:{ all -> 0x0035 }
        f13459j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13459j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.store.TagStore.a(com.facebook.inject.InjectorLike):com.facebook.photos.tagging.store.TagStore");
    }

    private static TagStore m21158b(InjectorLike injectorLike) {
        return new TagStore(PreFilledTagLogger.m19990b(injectorLike), RemovedPrefilledTagsDataStore.m21147a(injectorLike), PhotosContract.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), LocalPhotoMetaDataStore.m21143a(injectorLike));
    }

    private void m21156a(PhotoItem photoItem, long j) {
        if (photoItem.f12739f != null) {
            List<Tag> b = m21167b(photoItem);
            for (Tag tag : b) {
                if (tag.f12788c == j) {
                    if (tag.f12786a instanceof FaceBox) {
                        ((FaceBox) tag.f12786a).f12770f = false;
                    }
                    b.remove(tag);
                    return;
                }
            }
        }
    }

    @Inject
    public TagStore(PreFilledTagLogger preFilledTagLogger, RemovedPrefilledTagsDataStore removedPrefilledTagsDataStore, PhotosContract photosContract, Clock clock, Context context, LocalPhotoMetaDataStore localPhotoMetaDataStore) {
        this.f13460a = preFilledTagLogger;
        this.f13461b = removedPrefilledTagsDataStore;
        this.f13462c = photosContract;
        this.f13463d = clock;
        this.f13464e = context;
        this.f13465f = localPhotoMetaDataStore;
    }

    public final ImmutableList<Tag> m21159a(MediaIdKey mediaIdKey) {
        if (this.f13467h.containsKey(mediaIdKey)) {
            return ImmutableList.copyOf((Collection) this.f13467h.get(mediaIdKey));
        }
        return this.f13466g;
    }

    @Deprecated
    public final List<Tag> m21167b(PhotoItem photoItem) {
        List<Tag> list = (List) this.f13467h.get(photoItem.d());
        return list == null ? new ArrayList() : list;
    }

    @Deprecated
    public final List<Tag> m21160a(TaggablePhoto taggablePhoto) {
        List<Tag> list = (List) this.f13467h.get(taggablePhoto.mo1094a());
        return list == null ? new ArrayList() : list;
    }

    public final boolean m21166a(TaggablePhoto taggablePhoto, long j) {
        for (Tag tag : m21160a(taggablePhoto)) {
            if (!tag.m20190j() && tag.f12788c == j) {
                return true;
            }
        }
        return false;
    }

    public final void m21163a(TaggablePhoto taggablePhoto, List<Tag> list) {
        this.f13467h.put(taggablePhoto.mo1094a(), list);
    }

    public final void m21162a(PhotoItem photoItem, Tag tag) {
        Preconditions.checkNotNull(photoItem);
        Preconditions.checkNotNull(tag);
        if (this.f13467h.containsKey(photoItem.d())) {
            List list = (List) this.f13467h.get(photoItem.d());
            if (!list.contains(tag)) {
                list.add(tag);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tag);
            this.f13467h.put(photoItem.d(), arrayList);
        }
        new AddTagInDbTask(this.f13464e, photoItem.m20117u(), tag, this.f13462c, this.f13463d).a(this.f13464e, new Void[0]);
    }

    public final void m21170d(PhotoItem photoItem) {
        new RemoveAllTagsFromPhotoInDbTask(this.f13464e, photoItem.m20117u(), this.f13462c).a(this.f13464e, new Void[0]);
        m21167b(photoItem).clear();
    }

    public final void m21168b(PhotoItem photoItem, Tag tag) {
        m21167b(photoItem).remove(tag);
        if (tag.f12786a instanceof FaceBox) {
            ((FaceBox) tag.f12786a).f12770f = false;
        }
        if (tag.f12790e) {
            this.f13460a.m19993c();
            this.f13461b.m21150a(this.f13464e, photoItem, tag.f12788c);
            m21161a(this.f13464e, photoItem);
        }
        new RemoveTagInDbTask(this.f13464e, photoItem.m20117u(), tag, this.f13462c).a(this.f13464e, new Void[0]);
    }

    public final void m21164a(ImmutableList<PhotoItem> immutableList, Set<Long> set) {
        if (set != null && !set.isEmpty()) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PhotoItem photoItem = (PhotoItem) immutableList.get(i);
                for (Long longValue : set) {
                    m21156a(photoItem, longValue.longValue());
                }
                new RemoveTagsWithUidInDbTask(this.f13464e, photoItem.m20117u(), set, this.f13462c).a(this.f13464e, new Void[0]);
            }
        }
    }

    public final void m21161a(Context context, PhotoItem photoItem) {
        if (photoItem != null && photoItem.f12739f != null && (photoItem.f12739f instanceof LocalPhoto)) {
            LocalPhoto localPhoto = photoItem.f12739f;
            if (!localPhoto.f12750f) {
                localPhoto.f12750f = true;
                LocalPhotoMetaDataStore localPhotoMetaDataStore = this.f13465f;
                new SetAutoTagState(context, localPhotoMetaDataStore.f13430a, localPhotoMetaDataStore.f13431b, photoItem, true).a(context, new Void[0]);
            }
        }
    }

    public final void m21165a(String str) {
        this.f13468i.add(str);
    }

    public final void m21169b(String str) {
        this.f13468i.remove(str);
        if (this.f13468i.isEmpty()) {
            clearUserData();
        }
    }

    public void clearUserData() {
        this.f13467h.clear();
    }

    public static double m21157b(float f) {
        return ((double) Math.round(1000000.0f * f)) / 1000000.0d;
    }
}

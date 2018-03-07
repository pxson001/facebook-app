package com.facebook.feed.photoreminder;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Video.Media;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.photoreminder.model.MediaModel$MediaType;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.Lists;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_info_frequency_mhz */
public class MediaReminderUtil {
    private static final Uri f12604a = Files.getContentUri("external");
    private static final Uri f12605b = Media.EXTERNAL_CONTENT_URI;
    private static final String[] f12606c = new String[]{"duration"};
    private static final String[] f12607d = new String[]{"date_added", "_data", "media_type"};
    public static final String f12608e = StringFormatUtil.a("(%s = %d or %s = %d) AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(1), "media_type", Integer.valueOf(3), "_data", "_data"});
    private static final String f12609f = StringFormatUtil.a("%s = %d AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(1), "_data", "_data"});
    private static final String f12610g = StringFormatUtil.a("%s = %d AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(3), "_data", "_data"});
    private static final String[] f12611h = new String[]{"Count(1)"};
    private static MediaReminderUtil f12612p;
    private static final Object f12613q = new Object();
    public final Context f12614i;
    public final FbSharedPreferences f12615j;
    private final DefaultAndroidThreadUtil f12616k;
    private final PromptsExperimentHelper f12617l;
    public final QeAccessor f12618m;
    public final V2PromptUtil f12619n;
    public V2PhotoReminderPrompt f12620o;

    private static MediaReminderUtil m18702b(InjectorLike injectorLike) {
        return new MediaReminderUtil((Context) injectorLike.getInstance(Context.class), FbSharedPreferencesImpl.m1826a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), PromptsExperimentHelper.m15312b(injectorLike), V2PromptUtil.m18713b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static MediaReminderUtil m18699a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaReminderUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12613q) {
                MediaReminderUtil mediaReminderUtil;
                if (a2 != null) {
                    mediaReminderUtil = (MediaReminderUtil) a2.mo818a(f12613q);
                } else {
                    mediaReminderUtil = f12612p;
                }
                if (mediaReminderUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m18702b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12613q, b3);
                        } else {
                            f12612p = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaReminderUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public MediaReminderUtil(Context context, FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, PromptsExperimentHelper promptsExperimentHelper, V2PromptUtil v2PromptUtil, QeAccessor qeAccessor) {
        this.f12614i = context;
        this.f12615j = fbSharedPreferences;
        this.f12616k = defaultAndroidThreadUtil;
        this.f12617l = promptsExperimentHelper;
        this.f12619n = v2PromptUtil;
        this.f12618m = qeAccessor;
    }

    public final List<MediaModel> m18707a() {
        List<MediaModel> list = null;
        this.f12616k.m1655b();
        Cursor query = this.f12614i.getContentResolver().query(f12604a, f12607d, f12608e, null, "date_added DESC LIMIT 30");
        if (query != null) {
            int i = 0;
            list = Lists.m1297a(30);
            while (query.moveToNext() && i < 30) {
                MediaModel$MediaType mediaModel$MediaType;
                Object obj;
                switch (query.getInt(2)) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        mediaModel$MediaType = MediaModel$MediaType.PHOTO;
                        break;
                    case 3:
                        mediaModel$MediaType = MediaModel$MediaType.VIDEO;
                        break;
                    default:
                        mediaModel$MediaType = MediaModel$MediaType.UNKNOWN;
                        break;
                }
                MediaModel$MediaType mediaModel$MediaType2 = mediaModel$MediaType;
                String string = query.getString(1);
                if (ImageFormatChecker.m24996a(string) == ImageFormat.PNG) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (mediaModel$MediaType2 == MediaModel$MediaType.VIDEO) {
                        list.add(new MediaModel(string, MediaModel$MediaType.VIDEO, m18701b(string)));
                    } else {
                        list.add(new MediaModel(string, mediaModel$MediaType2));
                    }
                    i++;
                }
            }
            query.close();
        }
        return list;
    }

    public final long m18708b() {
        Cursor query = this.f12614i.getContentResolver().query(f12604a, f12607d, f12608e, null, "date_added DESC LIMIT 1");
        if (query == null) {
            return -1;
        }
        long j;
        if (query.moveToNext()) {
            j = query.getLong(0);
        } else {
            j = -1;
        }
        query.close();
        return TimeUnit.SECONDS.toMillis(j);
    }

    public final int m18706a(long j, MediaModel$MediaType mediaModel$MediaType) {
        Object obj;
        if (mediaModel$MediaType == MediaModel$MediaType.PHOTO) {
            obj = f12609f;
        } else if (mediaModel$MediaType == MediaModel$MediaType.VIDEO) {
            r3 = f12610g;
        } else {
            r3 = f12608e;
        }
        Cursor query = this.f12614i.getContentResolver().query(f12604a, f12611h, StringFormatUtil.a("%s AND %s > %s", new Object[]{obj, "date_added", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))}), null, null);
        if (query == null) {
            return 0;
        }
        query.moveToNext();
        int i = query.getInt(0);
        query.close();
        return i;
    }

    public final int m18705a(long j, long j2, MediaModel$MediaType mediaModel$MediaType) {
        Object obj;
        if (mediaModel$MediaType == MediaModel$MediaType.PHOTO) {
            obj = f12609f;
        } else if (mediaModel$MediaType == MediaModel$MediaType.VIDEO) {
            r5 = f12610g;
        } else {
            r5 = m18704h();
        }
        Cursor query = this.f12614i.getContentResolver().query(f12604a, f12611h, StringFormatUtil.a("%s AND %s > %s AND %s < %s", new Object[]{obj, "date_added", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j)), "date_added", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2))}), null, null);
        if (query == null) {
            return 0;
        }
        query.moveToNext();
        int i = query.getInt(0);
        query.close();
        return i;
    }

    public final void m18709c() {
        int a = this.f12615j.mo276a(PromptsPrefKeys.f12783e, 0);
        long a2 = SystemClock.f762a.mo211a();
        Editor edit = this.f12615j.edit();
        edit.mo1275a(PromptsPrefKeys.f12782d, a2);
        edit.mo1274a(PromptsPrefKeys.f12783e, a + 1);
        edit.commit();
    }

    public final void m18710d() {
        Editor edit = this.f12615j.edit();
        edit.mo1274a(PromptsPrefKeys.f12783e, 100);
        edit.commit();
    }

    public final int m18711f() {
        return this.f12614i.getResources().getDimensionPixelSize(2131430430);
    }

    public static boolean m18703g() {
        return Calendar.getInstance(TimeZone.getDefault()).get(7) == 2;
    }

    public static boolean m18700a(PromptPartDefinitionProps promptPartDefinitionProps) {
        return (promptPartDefinitionProps == null || promptPartDefinitionProps.f13441a == null || promptPartDefinitionProps.f13441a.f13409a == null || ((!promptPartDefinitionProps.f13441a.f13409a.mo2494c().equals(GraphQLPromptType.PHOTO.toString()) && !promptPartDefinitionProps.f13441a.f13409a.mo2494c().equals(GraphQLPromptType.PHOTO_WEEKEND.toString())) || ((PhotoReminderPromptObject) promptPartDefinitionProps.f13441a.f13409a).f12633a.m25074a().isEmpty())) ? false : true;
    }

    private static String m18704h() {
        return f12608e;
    }

    private int m18701b(String str) {
        Cursor query = this.f12614i.getContentResolver().query(f12605b, f12606c, StringFormatUtil.a("%s = '%s'", new Object[]{"_data", str}), null, null);
        if (query == null) {
            return 0;
        }
        query.moveToNext();
        int i = query.getInt(0);
        query.close();
        return i;
    }
}

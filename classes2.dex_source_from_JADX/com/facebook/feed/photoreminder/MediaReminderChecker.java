package com.facebook.feed.photoreminder;

import android.content.res.Resources;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.photoreminder.abtest.ExperimentsForPhotoReminderAbTestModule;
import com.facebook.feed.photoreminder.abtest.PhotoReminderGatekeeperHelper;
import com.facebook.feed.photoreminder.abtest.PhotoReminderGatekeepers;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.photoreminder.model.MediaModel$MediaType;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.productionprompts.abtest.ExperimentsForProductionPromptsAbtestModule;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.PromptsInternalSettingsController;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_inflight_conn */
public class MediaReminderChecker {
    private final FbSharedPreferences f12594a;
    public final QeAccessor f12595b;
    private final MediaReminderUtil f12596c;
    private final PromptsExperimentHelper f12597d;
    private final PhotoReminderGatekeeperHelper f12598e;
    private final WeekendPhotoReminderLogger f12599f;
    private final PromptsInternalSettingsController f12600g;
    private final DefaultTimeFormatUtil f12601h;
    private final Resources f12602i;
    private boolean f12603j;

    private boolean m18686b(GraphQLPromptType graphQLPromptType) {
        return SystemClock.f762a.mo211a() < m18687c() + m18688c(graphQLPromptType);
    }

    private boolean m18690d(GraphQLPromptType graphQLPromptType) {
        return SystemClock.f762a.mo211a() < m18689d() + m18691e(graphQLPromptType);
    }

    @Inject
    public MediaReminderChecker(FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, MediaReminderUtil mediaReminderUtil, Boolean bool, PromptsExperimentHelper promptsExperimentHelper, PhotoReminderGatekeeperHelper photoReminderGatekeeperHelper, WeekendPhotoReminderLogger weekendPhotoReminderLogger, PromptsInternalSettingsController promptsInternalSettingsController, DefaultTimeFormatUtil defaultTimeFormatUtil, Resources resources) {
        this.f12594a = fbSharedPreferences;
        this.f12595b = qeAccessor;
        this.f12596c = mediaReminderUtil;
        this.f12603j = bool.booleanValue();
        this.f12597d = promptsExperimentHelper;
        this.f12598e = photoReminderGatekeeperHelper;
        this.f12599f = weekendPhotoReminderLogger;
        this.f12600g = promptsInternalSettingsController;
        this.f12601h = defaultTimeFormatUtil;
        this.f12602i = resources;
    }

    public final boolean m18698a() {
        if (!this.f12603j) {
            boolean z = false;
            if (!(1 == 0 && this.f12595b.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11361i, false))) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        m18680a("Is in work build, V2 prompt and super sprouts", GraphQLPromptType.PHOTO.name());
        return false;
    }

    public final MediaReminderModel m18697a(@Nullable MediaReminderModel mediaReminderModel, @Nullable List<MediaModel> list, GraphQLPromptType graphQLPromptType) {
        boolean z = graphQLPromptType == GraphQLPromptType.PHOTO || graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND;
        Preconditions.checkArgument(z);
        this.f12599f.m18717a();
        if (!this.f12598e.m15319c() && m18686b(graphQLPromptType) && !m18694f()) {
            m18680a(this.f12602i.getString(2131235721, new Object[]{m18679a(m18687c()), Double.valueOf(m18685b(m18688c(graphQLPromptType)))}), graphQLPromptType.name());
            return MediaReminderModel.f17844a;
        } else if (this.f12598e.m15319c() || !m18690d(graphQLPromptType)) {
            long f = m18693f(graphQLPromptType);
            if (m18683a(this.f12596c.m18708b(), graphQLPromptType)) {
                long a = SystemClock.m1506b().mo211a();
                long a2 = this.f12594a.mo277a(PromptsPrefKeys.f12782d, 0);
                long max = Math.max(a - f, a2);
                if (m18682a(a, a2, graphQLPromptType) && !m18694f()) {
                    m18680a(this.f12602i.getString(2131235724, new Object[]{m18679a(a2), Double.valueOf(m18685b(m18695g(graphQLPromptType)))}), graphQLPromptType.name());
                    return MediaReminderModel.f17844a;
                } else if (GraphQLPromptType.PHOTO_WEEKEND == graphQLPromptType && !m18684a(graphQLPromptType)) {
                    return MediaReminderModel.f17844a;
                } else {
                    int a3 = this.f12596c.m18706a(max, MediaModel$MediaType.VIDEO);
                    int a4 = this.f12596c.m18706a(max, MediaModel$MediaType.PHOTO);
                    if (m18681a(a4 + a3, graphQLPromptType)) {
                        m18692e();
                        return m18678a(a4, a3, graphQLPromptType, list);
                    } else if (mediaReminderModel != null) {
                        return mediaReminderModel;
                    } else {
                        m18680a(this.f12602i.getString(2131235725, new Object[]{Integer.valueOf(a3 + a4), Integer.valueOf(m18696h(graphQLPromptType))}), graphQLPromptType.name());
                        return MediaReminderModel.f17844a;
                    }
                }
            }
            m18680a(this.f12602i.getString(2131235723, new Object[]{m18679a(this.f12596c.m18708b()), Double.valueOf(m18685b(f))}), graphQLPromptType.name());
            return MediaReminderModel.f17844a;
        } else {
            m18680a(this.f12602i.getString(2131235722, new Object[]{m18679a(m18689d()), Double.valueOf(m18685b(m18691e(graphQLPromptType)))}), graphQLPromptType.name());
            return MediaReminderModel.f17844a;
        }
    }

    private boolean m18684a(GraphQLPromptType graphQLPromptType) {
        if (graphQLPromptType != GraphQLPromptType.PHOTO_WEEKEND || !this.f12595b.mo596a(ExperimentsForPhotoReminderAbTestModule.f12814q, true)) {
            return true;
        }
        long b = this.f12596c.m18708b();
        boolean z = true;
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        instance.setTimeInMillis(b);
        if (!(instance.get(7) == 7 || instance.get(7) == 1)) {
            z = false;
        }
        return z;
    }

    private void m18680a(String str, String str2) {
        this.f12600g.m18725a(str2, str);
    }

    private MediaReminderModel m18678a(int i, int i2, GraphQLPromptType graphQLPromptType, @Nullable List<MediaModel> list) {
        if (list == null || list.isEmpty()) {
            list = this.f12596c.m18707a();
        }
        if (list == null || list.isEmpty()) {
            return MediaReminderModel.f17844a;
        }
        if (graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND) {
            boolean z = true;
            if (!((this.f12595b.mo596a(ExperimentsForPhotoReminderAbTestModule.f12813p, true) ? MediaReminderUtil.m18703g() : true) && this.f12595b.mo596a(ExperimentsForPhotoReminderAbTestModule.f12810m, false))) {
                z = false;
            }
            if (!z) {
                return MediaReminderModel.f17844a;
            }
        }
        MediaReminderModel mediaReminderModel = new MediaReminderModel(list);
        mediaReminderModel.f17850g = i2;
        mediaReminderModel.f17849f = i;
        if (graphQLPromptType != GraphQLPromptType.PHOTO_WEEKEND) {
            return mediaReminderModel;
        }
        mediaReminderModel.f17855l = true;
        return mediaReminderModel;
    }

    private long m18687c() {
        return this.f12594a.mo277a(PromptsPrefKeys.f12781c, 0);
    }

    private long m18688c(GraphQLPromptType graphQLPromptType) {
        return graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND ? this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12808k, 0) : this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12798a, 0);
    }

    private long m18689d() {
        return this.f12594a.mo277a(FeedPrefKeys.f5757u, 0);
    }

    private long m18691e(GraphQLPromptType graphQLPromptType) {
        return graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND ? this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12816s, 1800000) : this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12805h, 1800000);
    }

    private boolean m18683a(long j, GraphQLPromptType graphQLPromptType) {
        if (j > 0 && SystemClock.f762a.mo211a() - m18693f(graphQLPromptType) <= j) {
            return true;
        }
        return false;
    }

    private long m18693f(GraphQLPromptType graphQLPromptType) {
        return graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND ? this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12811n, 259200000) : 86400000;
    }

    private boolean m18682a(long j, long j2, GraphQLPromptType graphQLPromptType) {
        return !this.f12598e.m15319c() && j < m18695g(graphQLPromptType) + j2;
    }

    private long m18695g(GraphQLPromptType graphQLPromptType) {
        return graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND ? this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12812o, 21600000) : this.f12595b.mo575a(ExperimentsForPhotoReminderAbTestModule.f12807j, 21600000);
    }

    private boolean m18681a(int i, GraphQLPromptType graphQLPromptType) {
        return i >= m18696h(graphQLPromptType);
    }

    private int m18696h(GraphQLPromptType graphQLPromptType) {
        return graphQLPromptType == GraphQLPromptType.PHOTO_WEEKEND ? this.f12595b.mo572a(ExperimentsForPhotoReminderAbTestModule.f12815r, 3) : this.f12595b.mo572a(ExperimentsForPhotoReminderAbTestModule.f12806i, 2);
    }

    private void m18692e() {
        Editor edit = this.f12594a.edit();
        edit.mo1274a(PromptsPrefKeys.f12783e, 0);
        edit.commit();
    }

    private boolean m18694f() {
        if (this.f12598e.f10222a.m2189a(PhotoReminderGatekeepers.f13994b, false) || this.f12595b.mo596a(ExperimentsForProductionPromptsAbtestModule.f13414c, false)) {
            return true;
        }
        return false;
    }

    private String m18679a(long j) {
        return this.f12601h.mo1649a(TimeFormatStyle.EXACT_TIME_DATE_STYLE, j);
    }

    private static double m18685b(long j) {
        return (double) TimeConversions.m11967a(j);
    }
}

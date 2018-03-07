package com.facebook.feed.photoreminder.model;

import com.facebook.graphql.enums.GraphQLPromptType;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: last_sync_date */
public class MediaReminderModel {
    public static final MediaReminderModel f17844a = new MediaReminderModel(RegularImmutableList.f535a);
    private final ImmutableList<MediaModel> f17845b;
    public final ImmutableList<String> f17846c;
    private final ImmutableList<String> f17847d;
    public int f17848e = 0;
    public int f17849f;
    public int f17850g;
    public boolean f17851h = false;
    public boolean f17852i = false;
    public boolean f17853j = false;
    public boolean f17854k = false;
    public boolean f17855l = false;

    /* compiled from: last_sync_date */
    class C07191 implements Function<MediaModel, String> {
        final /* synthetic */ MediaReminderModel f17856a;

        C07191(MediaReminderModel mediaReminderModel) {
            this.f17856a = mediaReminderModel;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return ((MediaModel) obj).a;
        }
    }

    public MediaReminderModel(List<MediaModel> list) {
        if (list != null) {
            this.f17845b = ImmutableList.copyOf((Collection) list);
            this.f17846c = ImmutableList.copyOf(Lists.m1303a(this.f17845b, new C07191(this)));
            Builder builder = new Builder();
            for (MediaModel mediaModel : list) {
                if (mediaModel.b == MediaModel$MediaType.PHOTO) {
                    builder.m1069c(mediaModel.a);
                }
            }
            this.f17847d = builder.m1068b();
            return;
        }
        this.f17845b = RegularImmutableList.f535a;
        ImmutableList immutableList = RegularImmutableList.f535a;
        this.f17847d = immutableList;
        this.f17846c = immutableList;
    }

    public final ImmutableList<MediaModel> m25074a() {
        Preconditions.checkNotNull(this.f17845b);
        return this.f17845b;
    }

    public final String m25075b() {
        return this.f17855l ? "1022037091223487:" + m25074a().hashCode() : "824928570957117:" + m25074a().hashCode();
    }

    public final String m25076c() {
        return this.f17855l ? GraphQLPromptType.PHOTO_WEEKEND.toString() : GraphQLPromptType.PHOTO.toString();
    }

    public final boolean m25077d() {
        return (this.f17845b == null || this.f17845b.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaReminderModel)) {
            return false;
        }
        MediaReminderModel mediaReminderModel = (MediaReminderModel) obj;
        if (this.f17848e == mediaReminderModel.f17848e && this.f17849f == mediaReminderModel.f17849f && this.f17850g == mediaReminderModel.f17850g && this.f17851h == mediaReminderModel.f17851h && this.f17852i == mediaReminderModel.f17852i && this.f17853j == mediaReminderModel.f17853j && this.f17854k == mediaReminderModel.f17854k) {
            Preconditions.checkNotNull(mediaReminderModel.f17846c);
            if (Objects.equal(mediaReminderModel.f17846c, this.f17846c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f17845b, Integer.valueOf(this.f17848e), Integer.valueOf(this.f17849f), Integer.valueOf(this.f17850g), Boolean.valueOf(this.f17852i), Boolean.valueOf(this.f17853j), Boolean.valueOf(this.f17854k));
    }
}

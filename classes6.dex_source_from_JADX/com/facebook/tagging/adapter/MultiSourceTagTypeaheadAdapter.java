package com.facebook.tagging.adapter;

import android.content.Context;
import android.widget.Filter.FilterListener;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.adapter.BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter;
import com.facebook.tagging.adapter.filters.MultiSourceTagTypeaheadFilter;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Sets;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dialogs */
public class MultiSourceTagTypeaheadAdapter extends TagTypeaheadAdapter {
    private final MultiSourceTagTypeaheadFilter f17322b;
    public final TaggingProfileExclusionFilter f17323c = new C12581(this);
    private final Comparator<TaggingProfile> f17324d = new C12592(this);
    public final Set<Long> f17325e = Sets.d();
    public boolean f17326f;

    /* compiled from: dialogs */
    class C12581 implements TaggingProfileExclusionFilter {
        final /* synthetic */ MultiSourceTagTypeaheadAdapter f17333a;

        C12581(MultiSourceTagTypeaheadAdapter multiSourceTagTypeaheadAdapter) {
            this.f17333a = multiSourceTagTypeaheadAdapter;
        }

        public final boolean mo1310a(long j) {
            if (j == 0) {
                return false;
            }
            if ((this.f17333a.f17314a == null || !this.f17333a.f17314a.mo1310a(j)) && !this.f17333a.f17325e.contains(Long.valueOf(j))) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: dialogs */
    class C12592 implements Comparator<TaggingProfile> {
        final /* synthetic */ MultiSourceTagTypeaheadAdapter f17334a;

        C12592(MultiSourceTagTypeaheadAdapter multiSourceTagTypeaheadAdapter) {
            this.f17334a = multiSourceTagTypeaheadAdapter;
        }

        public int compare(Object obj, Object obj2) {
            TaggingProfile taggingProfile = (TaggingProfile) obj2;
            if (TagTypeaheadDataType.COMMENT_AUTHORS.toString().equals(((TaggingProfile) obj).f17545h)) {
                return -1;
            }
            if (TagTypeaheadDataType.COMMENT_AUTHORS.toString().equals(taggingProfile.f17545h)) {
                return 1;
            }
            return 0;
        }
    }

    private static MultiSourceTagTypeaheadAdapter m25162a(InjectorLike injectorLike) {
        return new MultiSourceTagTypeaheadAdapter((Context) injectorLike.getInstance(Context.class), new MultiSourceTagTypeaheadFilter(DefaultAndroidThreadUtil.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 11099)));
    }

    @Inject
    public MultiSourceTagTypeaheadAdapter(Context context, MultiSourceTagTypeaheadFilter multiSourceTagTypeaheadFilter) {
        super(context, multiSourceTagTypeaheadFilter);
        this.f17322b = multiSourceTagTypeaheadFilter;
    }

    public final void m25164a(TagTypeaheadDataSource tagTypeaheadDataSource, boolean z) {
        this.f17322b.m25183a(tagTypeaheadDataSource, z);
    }

    public final void mo1307b(TagTypeaheadDataSource tagTypeaheadDataSource) {
        m25164a(tagTypeaheadDataSource, true);
    }

    public final void mo1306a(CharSequence charSequence, String str, @Nullable FilterListener filterListener) {
        this.f17326f = true;
        super.mo1306a(charSequence, str, null);
    }

    public void mo1304a(CharSequence charSequence, List<TaggingProfile> list) {
        if (list != null) {
            m25168b(false);
            if (this.f17326f) {
                mo1305a();
            }
            for (TaggingProfile c : list) {
                m25169c(c);
            }
            m25154a(this.f17324d);
            this.f17326f = false;
            m25168b(true);
        }
    }

    public final void mo1305a() {
        super.mo1305a();
        this.f17325e.clear();
    }

    protected final void m25168b(boolean z) {
        if (z) {
            AdapterDetour.a(this, 1977680787);
        } else {
            this.f17317f = false;
        }
    }

    public final boolean m25169c(TaggingProfile taggingProfile) {
        if (this.f17323c.mo1310a(taggingProfile.f17539b)) {
            return false;
        }
        super.m25152a(taggingProfile);
        this.f17325e.add(Long.valueOf(taggingProfile.f17539b));
        return true;
    }
}

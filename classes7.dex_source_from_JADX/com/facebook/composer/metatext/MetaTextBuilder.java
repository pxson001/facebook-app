package com.facebook.composer.metatext;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: transliteration_db */
public interface MetaTextBuilder {

    /* compiled from: transliteration_db */
    public class Params {
        public final MinutiaeObject f1283a;
        public final CheckinPlaceModel f1284b;
        public final String f1285c;
        public final ImmutableList<String> f1286d;
        public final int f1287e;
        public final boolean f1288f;
        public final boolean f1289g;
        public final SpannableStringBuilder f1290h;
        public final TagClickListener f1291i;

        private Params(MinutiaeObject minutiaeObject, CheckinPlace checkinPlace, String str, ImmutableList<String> immutableList, int i, boolean z, boolean z2, SpannableStringBuilder spannableStringBuilder, TagClickListener tagClickListener) {
            this.f1283a = minutiaeObject;
            this.f1284b = checkinPlace;
            this.f1285c = str;
            this.f1286d = immutableList;
            this.f1287e = i;
            this.f1288f = z;
            this.f1289g = z2;
            this.f1290h = spannableStringBuilder;
            this.f1291i = tagClickListener;
        }

        @Nullable
        public final String m1369a(Resources resources) {
            int size = this.f1286d.isEmpty() ? this.f1287e : this.f1287e - this.f1286d.size();
            if (size == 0) {
                return null;
            }
            return resources.getQuantityString(2131689589, size, new Object[]{Integer.valueOf(size)});
        }

        @Nullable
        public final String m1370b(Resources resources) {
            if (this.f1287e == 0) {
                return null;
            }
            if (this.f1286d.isEmpty()) {
                return resources.getQuantityString(2131689589, this.f1287e, new Object[]{Integer.valueOf(this.f1287e)});
            } else if (this.f1287e == 1) {
                return (String) this.f1286d.get(0);
            } else {
                if (this.f1287e != 2 || this.f1286d.size() < 2) {
                    return resources.getString(2131234659, new Object[]{this.f1286d.get(0), Preconditions.checkNotNull(m1369a(resources))});
                }
                return resources.getString(2131234658, new Object[]{this.f1286d.get(0), this.f1286d.get(1)});
            }
        }
    }

    /* compiled from: transliteration_db */
    public class ParamsBuilder {
        public MinutiaeObject f1292a;
        public CheckinPlaceModel f1293b;
        public String f1294c;
        private Builder<String> f1295d;
        public int f1296e;
        public boolean f1297f = false;
        public boolean f1298g = false;
        public SpannableStringBuilder f1299h;
        public TagClickListener f1300i;

        public final ParamsBuilder m1373b(@Nullable String str) {
            if (str != null) {
                this.f1295d = ImmutableList.builder();
                this.f1295d.c(str);
            }
            return this;
        }

        public final ParamsBuilder m1372a(@Nullable ImmutableList<String> immutableList) {
            if (immutableList != null) {
                this.f1295d = ImmutableList.builder();
                this.f1295d.b(immutableList);
            }
            return this;
        }

        public final Params m1371a() {
            if (this.f1295d == null) {
                this.f1295d = ImmutableList.builder();
            }
            return new Params(this.f1292a, this.f1293b, this.f1294c, this.f1295d.b(), this.f1296e, this.f1297f, this.f1298g, this.f1299h, this.f1300i);
        }
    }

    /* compiled from: transliteration_db */
    public class StyleParams {
        public final CharacterStyle f1301a;
        public final CharacterStyle f1302b;

        public StyleParams(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            this.f1301a = characterStyle;
            this.f1302b = characterStyle2;
        }
    }

    /* compiled from: transliteration_db */
    public class StyleParamsBuilder {
        public CharacterStyle f1303a;
        public CharacterStyle f1304b;
        private final Resources f1305c;

        public StyleParamsBuilder(Resources resources) {
            this.f1305c = resources;
        }

        public final StyleParams m1374a() {
            return new StyleParams(this.f1303a == null ? new MetaTextSpan(this.f1305c.getColor(2131362944)) : this.f1303a, this.f1304b == null ? new ForegroundColorSpan(this.f1305c.getColor(2131361916)) : this.f1304b);
        }
    }

    /* compiled from: transliteration_db */
    public interface TagClickListener {
        void m1375a();

        void m1376a(int i);

        void m1377b();

        void m1378c();

        void m1379d();
    }

    SpannableStringBuilder mo56a(Params params);
}

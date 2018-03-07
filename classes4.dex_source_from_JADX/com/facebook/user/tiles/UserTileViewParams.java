package com.facebook.user.tiles;

import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: oxygen_map_bitmap_reuse_error */
public final class UserTileViewParams {
    private static final Class<?> f5725a = UserTileViewParams.class;
    public final Type f5726b;
    public final UserKey f5727c;
    public final PicSquare f5728d;
    public final TileBadge f5729e;
    public final String f5730f;
    public final Name f5731g;

    /* compiled from: oxygen_map_bitmap_reuse_error */
    public enum Type {
        PIC_SQUARE,
        USER_KEY,
        USER_KEY_WITH_FALLBACK_PIC_SQUARE,
        ADDRESS_BOOK_CONTACT
    }

    UserTileViewParams(UserTileViewParamsBuilder userTileViewParamsBuilder) {
        this.f5726b = userTileViewParamsBuilder.f5732a;
        this.f5727c = userTileViewParamsBuilder.f5733b;
        this.f5728d = userTileViewParamsBuilder.f5734c;
        this.f5729e = userTileViewParamsBuilder.f5735d;
        this.f5730f = userTileViewParamsBuilder.f5736e;
        this.f5731g = userTileViewParamsBuilder.f5737f;
    }

    public static UserTileViewParams m6209a(UserKey userKey) {
        UserTileViewParamsBuilder userTileViewParamsBuilder = new UserTileViewParamsBuilder();
        userTileViewParamsBuilder.f5732a = Type.USER_KEY;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5733b = userKey;
        return userTileViewParamsBuilder.m6233g();
    }

    public static UserTileViewParams m6206a(PicSquare picSquare, TileBadge tileBadge) {
        UserTileViewParamsBuilder userTileViewParamsBuilder = new UserTileViewParamsBuilder();
        userTileViewParamsBuilder.f5732a = Type.PIC_SQUARE;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5734c = picSquare;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5735d = tileBadge;
        return userTileViewParamsBuilder.m6233g();
    }

    public static UserTileViewParams m6210a(UserKey userKey, TileBadge tileBadge) {
        UserTileViewParamsBuilder userTileViewParamsBuilder = new UserTileViewParamsBuilder();
        userTileViewParamsBuilder.f5732a = Type.USER_KEY;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5733b = userKey;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5735d = tileBadge;
        return userTileViewParamsBuilder.m6233g();
    }

    public static UserTileViewParams m6207a(User user) {
        if (user.b()) {
            return m6213b(user);
        }
        return m6208a(user, null);
    }

    public static UserTileViewParams m6208a(User user, TileBadge tileBadge) {
        PicSquare z = user.z();
        if (z != null) {
            return m6206a(z, tileBadge);
        }
        UserKey userKey = user.T;
        return m6210a(user.T, tileBadge);
    }

    public static UserTileViewParams m6213b(User user) {
        return m6214b(user, TileBadge.NONE);
    }

    public static UserTileViewParams m6214b(User user, TileBadge tileBadge) {
        return m6211a(user.an(), user.e, tileBadge);
    }

    public static UserTileViewParams m6212a(String str, String str2, TileBadge tileBadge) {
        return m6211a(str, new Name(str2), tileBadge);
    }

    private static UserTileViewParams m6211a(String str, Name name, TileBadge tileBadge) {
        UserTileViewParamsBuilder userTileViewParamsBuilder = new UserTileViewParamsBuilder();
        userTileViewParamsBuilder.f5732a = Type.ADDRESS_BOOK_CONTACT;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5736e = str;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5737f = name;
        userTileViewParamsBuilder = userTileViewParamsBuilder;
        userTileViewParamsBuilder.f5735d = tileBadge;
        return userTileViewParamsBuilder.m6233g();
    }

    public final Type m6215a() {
        return this.f5726b;
    }

    public final UserKey m6216b() {
        return this.f5727c;
    }

    public final PicSquare m6217c() {
        return this.f5728d;
    }

    public final TileBadge m6218d() {
        return this.f5729e;
    }

    public final String m6219e() {
        return this.f5730f;
    }

    public final Name m6220f() {
        return this.f5731g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserTileViewParams userTileViewParams = (UserTileViewParams) obj;
        if (!this.f5726b.equals(userTileViewParams.f5726b)) {
            return false;
        }
        if (!Objects.equal(this.f5728d, userTileViewParams.f5728d)) {
            return false;
        }
        if (!Objects.equal(this.f5727c, userTileViewParams.f5727c)) {
            return false;
        }
        if (!Objects.equal(this.f5729e, userTileViewParams.f5729e)) {
            return false;
        }
        if (!Objects.equal(this.f5730f, userTileViewParams.f5730f)) {
            return false;
        }
        if (Objects.equal(this.f5731g, userTileViewParams.f5731g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.f5726b, this.f5728d, this.f5727c, this.f5729e});
    }
}

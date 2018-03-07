package com.facebook.user.tiles;

import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewParams.Type;
import com.facebook.widget.tiles.TileBadge;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: oxygen */
public class UserTileViewParamsBuilder {
    public Type f5732a;
    public UserKey f5733b;
    public PicSquare f5734c;
    public TileBadge f5735d;
    public String f5736e;
    public Name f5737f;

    public final UserTileViewParamsBuilder m6225a(Type type) {
        this.f5732a = type;
        return this;
    }

    public final Type m6221a() {
        return this.f5732a;
    }

    public final UserTileViewParamsBuilder m6224a(UserKey userKey) {
        this.f5733b = userKey;
        return this;
    }

    public final UserKey m6228b() {
        return this.f5733b;
    }

    public final UserTileViewParamsBuilder m6223a(PicSquare picSquare) {
        this.f5734c = picSquare;
        return this;
    }

    public final PicSquare m6229c() {
        return this.f5734c;
    }

    public final UserTileViewParamsBuilder m6226a(TileBadge tileBadge) {
        this.f5735d = tileBadge;
        return this;
    }

    public final TileBadge m6230d() {
        return this.f5735d;
    }

    public final UserTileViewParamsBuilder m6227a(String str) {
        this.f5736e = str;
        return this;
    }

    public final String m6231e() {
        return this.f5736e;
    }

    public final UserTileViewParamsBuilder m6222a(Name name) {
        this.f5737f = name;
        return this;
    }

    public final Name m6232f() {
        return this.f5737f;
    }

    public final UserTileViewParams m6233g() {
        return new UserTileViewParams(this);
    }
}

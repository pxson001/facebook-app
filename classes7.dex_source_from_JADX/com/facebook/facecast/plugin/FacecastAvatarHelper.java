package com.facebook.facecast.plugin;

import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.tiles.UserTileViewParams;
import javax.inject.Inject;

/* compiled from: broadcast_id */
public class FacecastAvatarHelper {
    public final User f18208a;

    public static FacecastAvatarHelper m21967b(InjectorLike injectorLike) {
        return new FacecastAvatarHelper(User_LoggedInUserMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public FacecastAvatarHelper(User user) {
        this.f18208a = user;
    }

    public final UserTileViewParams m21968a(ComposerTargetData composerTargetData, int i) {
        if (composerTargetData == null || composerTargetData.targetType != TargetType.PAGE) {
            return UserTileViewParams.a(this.f18208a);
        }
        PicSquareUrlWithSize picSquareUrlWithSize = new PicSquareUrlWithSize(i, composerTargetData.targetProfilePicUrl);
        UserBuilder a = new UserBuilder().a(Type.FACEBOOK, String.valueOf(composerTargetData.targetId));
        a.p = new PicSquare(picSquareUrlWithSize, null, null);
        return UserTileViewParams.a(a.aa());
    }
}

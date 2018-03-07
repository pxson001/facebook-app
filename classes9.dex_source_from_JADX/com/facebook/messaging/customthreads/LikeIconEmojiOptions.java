package com.facebook.messaging.customthreads;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mediaAttachments.type */
public class LikeIconEmojiOptions {
    private static final ImmutableList<String> f10289A = ImmutableList.builder().c(f10290a).c(f10291b).c(f10292c).c(f10293d).c(f10294e).c(f10295f).c(f10296g).c(f10301l).c(f10297h).c(f10298i).c(f10299j).c(f10302m).c(f10303n).c(f10304o).c(f10300k).c(f10305p).c(f10306q).c(f10307r).c(f10308s).c(f10309t).c(f10311v).c(f10312w).c(f10313x).c(f10314y).c(f10315z).c(f10310u).b();
    private static final String f10290a = m10904a(10084);
    private static final String f10291b = m10904a(128293);
    private static final String f10292c = m10904a(9917);
    private static final String f10293d = m10904a(128139);
    private static final String f10294e = m10904a(127867);
    private static final String f10295f = m10904a(128525);
    private static final String f10296g = m10904a(128536);
    private static final String f10297h = m10904a(128076);
    private static final String f10298i = m10904a(9996);
    private static final String f10299j = m10904a(128170);
    private static final String f10300k = m10904a(128169);
    private static final String f10301l = m10904a(128541);
    private static final String f10302m = m10904a(128588);
    private static final String f10303n = m10904a(9994);
    private static final String f10304o = m10904a(128074);
    private static final String f10305p = m10904a(127864);
    private static final String f10306q = m10904a(127866);
    private static final String f10307r = m10904a(128640);
    private static final String f10308s = m10904a(127752);
    private static final String f10309t = m10904a(127875);
    private static final String f10310u = m10904a(127881);
    private static final String f10311v = m10904a(9918);
    private static final String f10312w = m10904a(127936);
    private static final String f10313x = m10904a(127944);
    private static final String f10314y = m10904a(127934);
    private static final String f10315z = m10904a(127942);
    private final FbObjectMapper f10316B;
    private final XConfigReader f10317C;
    public ImmutableList<String> f10318D;

    /* compiled from: mediaAttachments.type */
    class C11831 extends TypeReference<List<Integer>> {
        final /* synthetic */ LikeIconEmojiOptions f10288b;

        C11831(LikeIconEmojiOptions likeIconEmojiOptions) {
            this.f10288b = likeIconEmojiOptions;
        }
    }

    public static LikeIconEmojiOptions m10905b(InjectorLike injectorLike) {
        return new LikeIconEmojiOptions(FbObjectMapperMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike));
    }

    private static String m10904a(int i) {
        return new String(Character.toChars(i));
    }

    @Inject
    public LikeIconEmojiOptions(FbObjectMapper fbObjectMapper, XConfigReader xConfigReader) {
        this.f10316B = fbObjectMapper;
        this.f10317C = xConfigReader;
        m10906b();
    }

    private void m10906b() {
        this.f10318D = m10907c();
        if (this.f10318D == null) {
            this.f10318D = f10289A;
        }
    }

    @Nullable
    private ImmutableList<String> m10907c() {
        try {
            List<Integer> list = (List) this.f10316B.a(this.f10317C.a(CustomThreadsXConfig.c, null), new C11831(this));
            Builder builder = ImmutableList.builder();
            for (Integer intValue : list) {
                builder.c(m10904a(intValue.intValue()));
            }
            return builder.b();
        } catch (IOException e) {
            return null;
        }
    }
}

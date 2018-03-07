package android_src.mmsv2.pdu;

import java.util.ArrayList;

/* compiled from: setNextStoryFinder(..) was not called */
public class ContentType {
    private static final ArrayList<String> f3821a = new ArrayList();
    private static final ArrayList<String> f3822b = new ArrayList();
    private static final ArrayList<String> f3823c = new ArrayList();
    private static final ArrayList<String> f3824d = new ArrayList();

    static {
        f3821a.add("text/plain");
        f3821a.add("text/html");
        f3821a.add("text/x-vCalendar");
        f3821a.add("text/x-vCard");
        f3821a.add("image/jpeg");
        f3821a.add("image/gif");
        f3821a.add("image/vnd.wap.wbmp");
        f3821a.add("image/png");
        f3821a.add("image/jpg");
        f3821a.add("image/x-ms-bmp");
        f3821a.add("audio/aac");
        f3821a.add("audio/amr");
        f3821a.add("audio/imelody");
        f3821a.add("audio/mid");
        f3821a.add("audio/midi");
        f3821a.add("audio/mp3");
        f3821a.add("audio/mp4");
        f3821a.add("audio/mpeg3");
        f3821a.add("audio/mpeg");
        f3821a.add("audio/mpg");
        f3821a.add("audio/x-mid");
        f3821a.add("audio/x-midi");
        f3821a.add("audio/x-mp3");
        f3821a.add("audio/x-mpeg3");
        f3821a.add("audio/x-mpeg");
        f3821a.add("audio/x-mpg");
        f3821a.add("audio/x-wav");
        f3821a.add("audio/3gpp");
        f3821a.add("application/ogg");
        f3821a.add("video/3gpp");
        f3821a.add("video/3gpp2");
        f3821a.add("video/h263");
        f3821a.add("video/mp4");
        f3821a.add("application/smil");
        f3821a.add("application/vnd.wap.xhtml+xml");
        f3821a.add("application/xhtml+xml");
        f3821a.add("application/vnd.oma.drm.content");
        f3821a.add("application/vnd.oma.drm.message");
        f3822b.add("image/jpeg");
        f3822b.add("image/gif");
        f3822b.add("image/vnd.wap.wbmp");
        f3822b.add("image/png");
        f3822b.add("image/jpg");
        f3822b.add("image/x-ms-bmp");
        f3823c.add("audio/aac");
        f3823c.add("audio/amr");
        f3823c.add("audio/imelody");
        f3823c.add("audio/mid");
        f3823c.add("audio/midi");
        f3823c.add("audio/mp3");
        f3823c.add("audio/mpeg3");
        f3823c.add("audio/mpeg");
        f3823c.add("audio/mpg");
        f3823c.add("audio/mp4");
        f3823c.add("audio/x-mid");
        f3823c.add("audio/x-midi");
        f3823c.add("audio/x-mp3");
        f3823c.add("audio/x-mpeg3");
        f3823c.add("audio/x-mpeg");
        f3823c.add("audio/x-mpg");
        f3823c.add("audio/x-wav");
        f3823c.add("audio/3gpp");
        f3823c.add("application/ogg");
        f3824d.add("video/3gpp");
        f3824d.add("video/3gpp2");
        f3824d.add("video/h263");
        f3824d.add("video/mp4");
    }

    private ContentType() {
    }

    public static boolean m3600a(String str) {
        return str != null && f3821a.contains(str);
    }

    public static boolean m3601b(String str) {
        return str != null && str.startsWith("image/");
    }

    public static boolean m3602c(String str) {
        return str != null && str.startsWith("audio/");
    }

    public static boolean m3603d(String str) {
        return str != null && str.startsWith("video/");
    }
}

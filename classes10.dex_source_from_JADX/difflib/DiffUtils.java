package difflib;

import difflib.myers.MyersDiff;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: event_composer_exit */
public class DiffUtils {
    private static MyersDiff f13598a = new MyersDiff();
    private static DefaultDifferentiator f13599b = new DefaultDifferentiator();
    private static Pattern f13600c = Pattern.compile("^@@\\s+-(?:(\\d+)(?:,(\\d+))?)\\s+\\+(?:(\\d+)(?:,(\\d+))?)\\s+@@$");

    public static <T> Patch<T> m13861a(List<T> list, List<T> list2, Differentiator differentiator) {
        return f13598a.m13872a((List) list, (List) list2, differentiator);
    }
}

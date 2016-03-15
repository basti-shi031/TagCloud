package basti.com.tagcloudlib;

import android.content.Context;

/**
 * Created by Bowen on 2016-03-15.
 */
public class DimensionUtils {

    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dp * scale + 0.5f);
    }
}

package basti.com.tagcloudlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Bowen on 2016-03-10.
 */
public class TagCloudView extends ViewGroup {
    public TagCloudView(Context context) {
        this(context, null);
    }

    public TagCloudView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagCloudView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttr();
    }

    private void initAttr() {



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}

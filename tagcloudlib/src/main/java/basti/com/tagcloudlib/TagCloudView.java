package basti.com.tagcloudlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bowen on 2016-03-10.
 */
public class TagCloudView extends ViewGroup {

    private float verticalDivider, horizontalDivider;
    private int width, height;
    private TagCloudViewListener mListener;

    public TagCloudView(Context context) {
        this(context, null);
    }

    public TagCloudView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagCloudView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TagCloudView);

        verticalDivider = ta.getDimension(R.styleable.TagCloudView_vertical_divider, DimensionUtils.dp2px(context, 12));
        horizontalDivider = ta.getDimension(R.styleable.TagCloudView_horizontal_divider, DimensionUtils.dp2px(context, 12));

        ta.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        int usedWidth = 0;
        int line = 0;


        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            if (usedWidth + horizontalDivider + child.getMeasuredWidth() + horizontalDivider <= width) {
                //已使用宽度 + 左右两个横向间距 + TextView宽度 < 总宽，则还在当前行

            } else {
                line++;
                usedWidth = 0;
            }

            child.layout((int) (usedWidth + horizontalDivider),
                    (int) ((line + 1) * verticalDivider) + line * child.getMeasuredHeight(),
                    (int) (usedWidth + horizontalDivider + child.getMeasuredWidth()),
                    (int) ((line + 1) * verticalDivider + (line + 1) * child.getMeasuredHeight()));

            usedWidth = (int) (usedWidth + child.getMeasuredWidth() + horizontalDivider);

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    /*public void addView(TagView tagview) {
        addView(tagview.getTextView());

        final int count = getChildCount();

        View child = getChildAt(count-1);

        child.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onClick(count-1);
                }
            }
        });
    }*/

    public void addView(View view) {
        super.addView(view);

        final int count = getChildCount();

        View child = getChildAt(count-1);

        child.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onClick(count-1);
                }
            }
        });
    }

    public void setOnTagCloudViewListener(TagCloudViewListener mListener) {
        this.mListener = mListener;
    }
}

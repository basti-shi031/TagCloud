package basti.com.tagcloud;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import basti.com.tagcloudlib.TagCloudView;
import basti.com.tagcloudlib.TagCloudViewListener;
import basti.com.tagcloudlib.TagView;

public class MainActivity extends AppCompatActivity {

    private TagCloudView tagCloudView;

    private RelativeLayout background;

    private int[] textColor = {0xFFFFFFFF,0xFFAD85BC,0xFF95D2F3,0xFFFA5268};
    private int[] backgroundColor = {0xFF0000,0xFF515235,0xFFA5168F,0xFF8EB15D};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        
        for (int i = 0;i<30;i ++){
            TextView button = new TextView(this);
            button.setTextColor(textColor[(int) (Math.random()*4)]);
            button.setBackgroundColor(backgroundColor[(int) (Math.random()*4)]);
            button.setText("第" + (i) + "个项目");
            tagCloudView.addView(button);
        }
        
        initEvent();
    }

    private void initEvent() {

        tagCloudView.setOnTagCloudViewListener(new TagCloudViewListener() {
            @Override
            public void onClick(int index) {
                Toast.makeText(MainActivity.this,"点击了第" + index + "个项目",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {

        tagCloudView = (TagCloudView) findViewById(R.id.cloudView);
        background = (RelativeLayout) findViewById(R.id.background);

    }
}

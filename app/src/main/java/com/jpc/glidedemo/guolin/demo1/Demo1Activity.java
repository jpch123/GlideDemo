package com.jpc.glidedemo.guolin.demo1;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jpc.glidedemo.R;
import java.io.File;

public class Demo1Activity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guolin_demo1);
        imageView = (ImageView) findViewById(R.id.image_view);
    }




    /**
     * 占位图
     */
    public void loadImage(View view) {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.pic_3)//加载过程占位图
                .error(R.mipmap.ic_launcher)//出错图
                .diskCacheStrategy(DiskCacheStrategy.NONE) //禁用磁盘缓存
                .skipMemoryCache(true)//禁用内存缓存
                .into(imageView);
    }





//待看
//        public void loadImage0(View view) {
//        // 加载二进制流
//        byte[] image = getImageBytes();
//        Glide.with(this).load().load(image).into(imageView);
//    }

    public void loadImage4(View view) {
        Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/1.jpg"));
        Glide.with(this).load(uri).into(imageView);
    }

    public void loadImage3(View view) {
        // 加载应用资源
//        int resource = R.mipmap.pic;
//        int resource = R.drawable.pic_3;
        int resource = R.raw.pic_5;
        Glide.with(this).load(resource).into(imageView);

    }

    public void loadImage2(View view) {
        //需要动态的申请sdcard权限
        File file = new File(Environment.getExternalStorageDirectory() + "/1.jpg");
        log(file.getAbsolutePath());
        Glide.with(this)
                .load(file)
                .into(imageView);
    }

    public void loadImage1(View view) {
//        string A file path, or a uri or url
//        load(String string)
        //网络url
        // String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        //SDCard 路径
//        String url = Environment.getExternalStorageDirectory() + "/1.jpg";
        String url = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/1.jpg")).toString();
        log(url);
        Glide.with(this)
                .load(url)
                .into(imageView);
    }

    void log(String msg) {
        Log.d("Demo1Activity", msg);
    }
}

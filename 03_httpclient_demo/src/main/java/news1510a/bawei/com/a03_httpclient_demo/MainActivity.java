package news1510a.bawei.com.a03_httpclient_demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

/**
 * 使用httpClient....http的客户端对象,来请求网络上的数据
 */
public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
                Bitmap bitmap = (Bitmap) msg.obj;
                imageView.setImageBitmap(bitmap);
            }
        }
    };
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);
    }

    public void getData(View view){
        new Thread(){

            @Override
            public void run() {

                try {
                    //1.获取一个http客户端对象
                    HttpClient client = new DefaultHttpClient();

                    String path = "http://03.imgmini.eastday.com/mobile/20170105/20170105110355_806f4ed3fe71d04fa452783d6736a02b_1_mwpm_03200403.jpeg";
                    //2.指定请求方式的对象
                    HttpGet httpGet = new HttpGet(path);

                    //3.执行....返回值是http响应对象
                    HttpResponse httpResponse = client.execute(httpGet);

                    //4.获取响应的状态码...先获取到响应的状态行,,,在获取响应的状态码
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (statusCode == 200){
                        //获取响应的内容...先获取响应的实体内容对象,,,在获取对象里面的内容
                        InputStream inputStream = httpResponse.getEntity().getContent();

                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        //发送出去
                        Message message = Message.obtain();
                        message.what = 0;
                        message.obj = bitmap;
                        handler.sendMessage(message);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }.start();
    }
}

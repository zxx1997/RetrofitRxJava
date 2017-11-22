package zhaoxixiang.bwie.com.zhaoxixiang20171116_yuekaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RetrofitUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utils=RetrofitUtils.getInstance();

        RetrofitService apiService = utils.getApiService("http://api.svipmovie.com/front/", RetrofitService.class);

        Observable<Bean> ob = apiService.getSearch("402834815584e463015584e539330016");
         ob.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Bean>() {
             @Override
             public void onCompleted() {

             }

             @Override
             public void onError(Throwable e) {

             }

             @Override
             public void onNext(Bean bean) {
                 Toast.makeText(MainActivity.this,bean.toString(),Toast.LENGTH_LONG).show();
             }
         });


    }
}

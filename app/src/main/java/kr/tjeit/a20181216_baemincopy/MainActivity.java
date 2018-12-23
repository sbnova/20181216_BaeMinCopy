package kr.tjeit.a20181216_baemincopy;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends BaseActivity {

    LinearLayout koreaFoodBtn;
    LinearLayout bunsikBtn;
    LinearLayout japanesFoodBtn;
    private LinearLayout cBtn;
    private LinearLayout pizzaBtn;
    private LinearLayout chinessBtn;
    private LinearLayout jBtn;
    private LinearLayout yasikBtn;
    private LinearLayout stewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();
        setupEvents();
        setValues();

        getKeyHash();

    }

    void getKeyHash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "kr.tjeit.a20181216_baemincopy",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    @Override
    public void setupEvents() {

        //        한식버튼이 눌렸을때 할일.
//        koreaFoodBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(mContext, "한식을 눌렀습니다.", Toast.LENGTH_SHORT).show();
//
////                화면 이동
//                Intent intent = new Intent(mContext, RestaurantListActivity.class);
////                한식이 눌렸다는 사실을 레스토랑리스트 액티비티에 공지.(알려줌)
//                intent.putExtra("음식종류", "한식");
//                startActivity(intent);
//            }
//        });


        View.OnClickListener foodKindClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                첫번째 방법 예시
//                if(v.getId()  == R.id.cBtn){
//                    Toast.makeText(mContext, "치킨 눌림", Toast.LENGTH_SHORT).show();
//                }
//                else if(v.getId() == R.id.pizzaBtn){
//                    Toast.makeText(mContext, "피자 눌림", Toast.LENGTH_SHORT).show();
//                }

//                두번째 방법 .XML에 작성한 태그를 이용.
//                Toast.makeText(mContext, v.getTag().toString(), Toast.LENGTH_SHORT).show();

//                인텐트에 어떤 종류의 음식인지를 첨부해서 레스토랑 목록화면으로 이동
                Intent intent = new Intent(mContext, RestaurantListActivity.class);
                intent.putExtra("음식종류", v.getTag().toString());
                startActivity(intent);
            }
        };

        koreaFoodBtn.setOnClickListener(foodKindClickListener);
        bunsikBtn.setOnClickListener(foodKindClickListener);
        japanesFoodBtn.setOnClickListener(foodKindClickListener);
        cBtn.setOnClickListener(foodKindClickListener);
        pizzaBtn.setOnClickListener(foodKindClickListener);
        chinessBtn.setOnClickListener(foodKindClickListener);
        jBtn.setOnClickListener(foodKindClickListener);
        yasikBtn.setOnClickListener(foodKindClickListener);
        stewBtn.setOnClickListener(foodKindClickListener);


    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        //        사실 읽을 필요가 전혀 없는 코드들.
//        따로 메소드를 만들어서 밑으로 치워버림
        this.stewBtn = (LinearLayout) findViewById(R.id.stewBtn);
        this.yasikBtn = (LinearLayout) findViewById(R.id.yasikBtn);
        this.jBtn = (LinearLayout) findViewById(R.id.jBtn);
        this.chinessBtn = (LinearLayout) findViewById(R.id.chinessBtn);
        this.pizzaBtn = (LinearLayout) findViewById(R.id.pizzaBtn);
        this.cBtn = (LinearLayout) findViewById(R.id.cBtn);
        this.japanesFoodBtn = (LinearLayout) findViewById(R.id.japanesFoodBtn);
        this.bunsikBtn = (LinearLayout) findViewById(R.id.bunsikBtn);
        this.koreaFoodBtn = (LinearLayout) findViewById(R.id.koreaFoodBtn);
    }
}

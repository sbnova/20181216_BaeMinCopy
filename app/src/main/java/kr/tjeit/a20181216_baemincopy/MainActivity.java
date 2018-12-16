package kr.tjeit.a20181216_baemincopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    LinearLayout koreaFoodBtn;
    LinearLayout bunsikBtn;
    LinearLayout japanesFoodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();



    }


    @Override
    public void setupEvents() {

        //        한식버튼이 눌렸을때 할일.
        koreaFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "한식을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        bunsikBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "분식을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        japanesFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "돈까스.회.일식을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        //        사실 읽을 필요가 전혀 없는 코드들.
//        따로 메소드를 만들어서 밑으로 치워버림
        koreaFoodBtn = findViewById(R.id.koreaFoodBtn);
        bunsikBtn = findViewById(R.id.bunsikBtn);
        japanesFoodBtn = findViewById(R.id.japanesFoodBtn);
    }
}

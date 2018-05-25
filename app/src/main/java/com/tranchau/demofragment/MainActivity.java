package com.tranchau.demofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFragment1, btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo 2 button
        btnFragment1 = (Button) findViewById(R.id.btnFragment1);
        btnFragment2 = (Button) findViewById(R.id.btnFragment2);

        // Gọi hàm này để khi chạy lần đầu tiên màn hình sẽ hiển thị GreenFragment có màu xanh
        callFragment(new Fragment1());

        // Bắt sự kiện click cho 2 button
        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);
    }

    // Hàm gọi Fragment để khi click vào thì sẽ gọi Fragment tương ứng.
    // Hàm này có tham số truyền vào 1 Fragment
    public void callFragment(Fragment fm) {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.fmContent, fm);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFragment1:
                callFragment(new Fragment1());
                break;
            case R.id.btnFragment2:
                callFragment(new Fragment2());
                break;
        }
    }
}

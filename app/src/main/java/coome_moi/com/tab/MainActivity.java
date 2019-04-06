package coome_moi.com.tab;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity implements OnClickListener {

    //底部的4个导航控件
    private LinearLayout mTabCarList;
    private LinearLayout mTabDriverList;
    private LinearLayout mTabWarnList;
    private LinearLayout mTabMoreList;
    //底部4个导航控件中的图片按钮
    private ImageView mImgCar;
    private ImageView mImgDriver;
    private ImageView mImgWarn;
    private ImageView mImgMore;
    //初始化4个Fragment
    private Fragment tab01;
    private Fragment tab02;
    private Fragment tab03;
    private Fragment tab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            //设置状态栏颜色
//        }
        setContentView(R.layout.activity_main);
        initView();//初始化所有的view
        initEvents();
        setSelect(0);//默认显示车辆列表界面
    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();//创建一个事务
        hideFragment(transaction);//我们先把所有的Fragment隐藏了，然后下面再开始处理具体要显示的Fragment
        switch (i) {
            case 0:
                if (tab01 == null) {
                    tab01 = new CarListFragment();
                    /*
                     * 将Fragment添加到活动中，public abstract FragmentTransaction add (int containerViewId, Fragment fragment)
                     *containerViewId即为Optional identifier of the container this fragment is to be placed in. If 0, it will not be placed in a container.
                     * */
                    transaction.add(R.id.id_content, tab01);//将车辆列表界面的Fragment添加到Activity中
                }else {
                    transaction.show(tab01);
                }
                mImgCar.setImageResource(R.drawable.car_pressed);
                break;
            case 1:
                if (tab02 == null) {
                    tab02 = new DriverListFragment();
                    transaction.add(R.id.id_content, tab02);
                }else {
                    transaction.show(tab02);
                }
                mImgDriver.setImageResource(R.drawable.driver_pressed);
                break;
            case 2:
                if (tab03 == null) {
                    tab03 = new WarningFragment();
                    transaction.add(R.id.id_content, tab03);
                }else {
                    transaction.show(tab03);
                }
                mImgWarn.setImageResource(R.drawable.warn_pressed);
                break;
            case 3:
                if (tab04 == null) {
                    tab04 = new MoreFragment();
                    transaction.add(R.id.id_content, tab04);
                }else {
                    transaction.show(tab04);
                }
                mImgMore.setImageResource(R.drawable.more_normal);
                break;

            default:
                break;
        }
        transaction.commit();//提交事务
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (tab01 != null) {
            transaction.hide(tab01);
        }
        if (tab02 != null) {
            transaction.hide(tab02);
        }
        if (tab03 != null) {
            transaction.hide(tab03);
        }
        if (tab04 != null) {
            transaction.hide(tab04);
        }
    }

    private void initEvents() {
        mTabCarList.setOnClickListener(this);
        mTabDriverList.setOnClickListener(this);
        mTabWarnList.setOnClickListener(this);
        mTabMoreList.setOnClickListener(this);
    }

    private void initView() {
        mTabCarList = findViewById(R.id.tab_car_list);
        mTabDriverList = findViewById(R.id.tab_driver_list);
        mTabWarnList = findViewById(R.id.tab_warn_list);
        mTabMoreList = findViewById(R.id.tab_more_list);
        mImgCar = findViewById(R.id.car_list_img);
        mImgDriver = findViewById(R.id.driver_list_img);
        mImgWarn = findViewById(R.id.warn_list_img);
        mImgMore = findViewById(R.id.more_list_img);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.tab_car_list://当点击微信按钮时，切换图片为亮色，切换fragment为微信聊天界面
                setSelect(0);
                break;
            case R.id.tab_driver_list:
                setSelect(1);
                break;
            case R.id.tab_warn_list:
                setSelect(2);
                break;
            case R.id.tab_more_list:
                setSelect(3);
                break;

            default:
                break;
        }
        
    }
    private void resetImg() {
        mImgCar.setImageResource(R.drawable.car_normal);
        mImgDriver.setImageResource(R.drawable.driver_normal);
        mImgWarn.setImageResource(R.drawable.warn_normal);
        mImgMore.setImageResource(R.drawable.more_normal);
    }
}

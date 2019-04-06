package coome_moi.com.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CarListFragment extends Fragment {

    private View view;
    private RecyclerView mCarRecyclerView;
    //定义以carEntity实体类为对象的数据集合
    private ArrayList<CarEntity> carEntityList = new ArrayList<CarEntity>();
    //自定义recyclerView适配器
    private  CarAdapter mCarAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //引入车辆列表布局,获取fragment的layout
        view = inflater.inflate(R.layout.car_list, container, false);
        //对recyclerView进行配置
        initRecyclerView();
        initData();
        return view;
    }

    private void initData() {
        CarEntity item01 = new CarEntity();
        item01.setCarImgPath(R.drawable.truck);
        item01.setDriverName("张三");
        item01.setCarId("暂无车牌号码显示");
        item01.setCarStatus("行驶中");
        item01.setNextImg(R.drawable.next);
        carEntityList.add(item01);
        CarEntity item02 = new CarEntity();
        item02.setCarImgPath(R.drawable.black_car);
        item02.setDriverName("李四");
        item02.setCarId("粤88888");
        item02.setCarStatus("行驶中");
        item02.setNextImg(R.drawable.next);
        carEntityList.add(item02);
        CarEntity item03 = new CarEntity();
        item03.setCarImgPath(R.drawable.white_truck);
        item03.setDriverName("王五");
        item03.setCarId("暂无车牌号码显示");
        item03.setCarStatus("行驶中");
        item03.setNextImg(R.drawable.next);
        carEntityList.add(item03);
        CarEntity item04 = new CarEntity();
        item04.setCarImgPath(R.drawable.truck);
        item04.setDriverName("小明");
        item04.setCarId("暂无车牌号码显示");
        item04.setCarStatus("行驶中");
        item04.setNextImg(R.drawable.next);
        carEntityList.add(item04);
        CarEntity item05= new CarEntity();
        item05.setCarImgPath(R.drawable.red_truck);
        item05.setDriverName("暂无");
        item05.setCarId("暂无车牌号码显示");
        item05.setCarStatus("静止");
        item05.setNextImg(R.drawable.next);
        carEntityList.add(item05);
        CarEntity item06= new CarEntity();
        item06.setCarImgPath(R.drawable.red_truck);
        item06.setDriverName("暂无");
        item06.setCarId("暂无车牌号码显示");
        item06.setCarStatus("静止");
        item06.setNextImg(R.drawable.next);
        carEntityList.add(item06);
        CarEntity item07= new CarEntity();
        item07.setCarImgPath(R.drawable.red_truck);
        item07.setDriverName("暂无");
        item07.setCarId("暂无车牌号码显示");
        item07.setCarStatus("静止");
        item07.setNextImg(R.drawable.next);
        carEntityList.add(item07);
        CarEntity item08= new CarEntity();
        item08.setCarImgPath(R.drawable.red_truck);
        item08.setDriverName("暂无");
        item08.setCarId("暂无车牌号码显示");
        item08.setCarStatus("静止");
        item08.setNextImg(R.drawable.next);
        carEntityList.add(item08);


    }

    private void initRecyclerView() {
        //获取recycleView
        mCarRecyclerView = view.findViewById(R.id.car_recyclerView);
        //创建Adapter
        mCarAdapter = new CarAdapter(getActivity(),carEntityList);
        //给recyclerView设置Adapter
        mCarRecyclerView.setAdapter(mCarAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mCarRecyclerView.setLayoutManager(layoutManager);
        //设置item的分割线
        mCarRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

    }
}

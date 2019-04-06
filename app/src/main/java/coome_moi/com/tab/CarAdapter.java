package coome_moi.com.tab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter <CarAdapter.ViewHolder>{
    private Context context;
    private  ArrayList<CarEntity> carEntityList;

    //创建构造函数
    public CarAdapter(Context context, ArrayList<CarEntity> carEntityList){
        this.context = context;
        this.carEntityList = carEntityList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //根据点击位置绑定数据
        CarEntity data = carEntityList.get(position);
        //获取实体类中的carName字段
        viewHolder.CarImage.setImageResource(data.getCarImgPath());
        viewHolder.CarName.setText(data.getDriverName());
        viewHolder.CarId.setText(data.getCarId());
        viewHolder.CarStatus.setText(data.getCarStatus());
        viewHolder.NextImg.setImageResource(data.getNextImg());

    }

    @Override
    public int getItemCount() {
        return carEntityList.size();
    }
    //自定义viewHolder
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView CarImage;
        TextView CarName;
        TextView CarId;
        TextView CarStatus;
        ImageView NextImg;

        public ViewHolder(View itemView){
            super(itemView);
            CarImage = itemView.findViewById(R.id.car_item_img);
            CarName = itemView.findViewById(R.id.car_driver_name);
            CarId = itemView.findViewById(R.id.car_id);
            CarStatus = itemView.findViewById(R.id.car_status);
            NextImg = itemView.findViewById(R.id.icon_next);
        }

    }

}

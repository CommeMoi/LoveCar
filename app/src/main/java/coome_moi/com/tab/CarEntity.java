package coome_moi.com.tab;

import java.io.Serializable;

public class CarEntity implements Serializable {

    public String driverName; //车辆驾驶员的名字
    public int carImgPath;  //车辆图片位置
    public String carId;  //车牌号码
    public String carStatus; //车辆状态
    public int nextImg; //next图标

    public CarEntity(){

    }


    public CarEntity(int carImg, String driverName, String carId, String carStatus,int nextImg){
        this.carImgPath = carImg;
        this.driverName = driverName;
        this.carId = carId;
        this.carStatus = carStatus;
        this.nextImg = nextImg;
    }

    public int getNextImg() {
        return nextImg;
    }

    public void setNextImg(int nextImg) {
        this.nextImg = nextImg;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getCarImgPath() {
        return carImgPath;
    }

    public String getCarId() {
        return carId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setCarImgPath(int carImgPath) {
        this.carImgPath = carImgPath;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "imgPath='" + carImgPath + '\'' +
                ", driverName='" + driverName + '\'' +
                ", carId='" + carId + '\'' +
                ", carStatus = '" +carStatus + '\'' +
                ", nextImg = '" +nextImg + '\'' +
                '}';
    }

}

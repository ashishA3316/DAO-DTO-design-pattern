package dto;

public class MobileDTO {
    private String Company;
    private double Price;
    private int Ram;
    private int Camera;
    private int modelNo;
    private String modelName;

    public MobileDTO(String company, double price, int ram, int camera, int modelNo, String modelName) {
        Company = company;
        Price = price;
        Ram = ram;
        Camera = camera;
        this.modelNo = modelNo;
        this.modelName = modelName;
    }

    public MobileDTO()
    {

    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public int getCamera() {
        return Camera;
    }

    public void setCamera(int camera) {
        Camera = camera;
    }

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "MobileDTO{" +
                "Company='" + Company + '\'' +
                ", Price=" + Price +
                ", Ram=" + Ram +
                ", Camera=" + Camera +
                ", modelNo=" + modelNo +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}

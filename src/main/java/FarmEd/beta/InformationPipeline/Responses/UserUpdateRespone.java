package FarmEd.beta.InformationPipeline.Responses;

public class UserUpdateRespone {
    int id;
    String farmName;
    String province;
    String division;
    double extent;
    double c;
    double n;
    double p;
    double k;
    double pH;
    boolean soilTest;
    String micronutrients;
    String waterSource;
    int aggrozone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public double getExtent() {
        return extent;
    }

    public void setExtent(double extent) {
        this.extent = extent;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public boolean isSoilTest() {
        return soilTest;
    }

    public void setSoilTest(boolean soilTest) {
        this.soilTest = soilTest;
    }

    public String getMicronutrients() {
        return micronutrients;
    }

    public void setMicronutrients(String micronutrients) {
        this.micronutrients = micronutrients;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public int getAggrozone() {
        return aggrozone;
    }

    public void setAggrozone(int aggrozone) {
        this.aggrozone = aggrozone;
    }
}

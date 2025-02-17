public class GasCar extends Car implements Drivable {

    private double fuelLevel; // 0 to 100

    public GasCar(String brand, String model, int year, double mileage, double fuelLevel, boolean isEngineOn) {
        super(brand, model, year, mileage, isEngineOn);
        this.fuelLevel = fuelLevel;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void startEngine() {
        if (isEngineOn()) {
            System.out.println("Двигатель уже работает.");
        } else {
            // isEngineOn() = true;
            setEngineOn(true);
            System.out.println("Двигатель запущен.");
        }
    }

    public void stopEngine() {

        if (isEngineOn()) {
            setEngineOn(false);
            System.out.println("Двигатель выключен.");
        } else {
            System.out.println("Двигатель уже выключен.");
        }

        // if (!isEngineOn){
        // System.out.println("Двигатель уже выключен.");
        // } else{
        // isEngineOn = false;
        // System.out.println("Двигатель выключен.");
        // }
    }

    public void drive(double distance) {
        boolean isEngineOn = isEngineOn();
        if (isEngineOn) {
            double useFuel = distance / 2;
            double mileAge = getMileage();
            if (fuelLevel < useFuel) {
                System.out.println("Недостаточно топлива для поездки");
            } else {
                mileAge += distance;
                setMileage(mileAge);
                fuelLevel -= useFuel;
                System.out.println("Проехали " + distance + " км. Остаток топлива: " + fuelLevel);
            }
        } else {
            System.out.println("Сначала запустите двигатель.");
            return;
        }

    }

    void refuel(double amount) {
        double result = fuelLevel + amount;
        if (result > 100) {
            fuelLevel = 100;
        } else {
            fuelLevel = result;
        } // (a <= b) ? a : b

    }

    void refuelNew(double amount) {
        fuelLevel = Math.min(fuelLevel + amount, 100);
        System.out.println("Заправлено. Уровень топлива: " + fuelLevel + "%");
    }

    public void getInfo() {

        String brand = getBrand();
        String model = getModel();
        int year = getYear();
        double mileAge = getMileage();
        double fuellevel = fuelLevel;
        boolean isEngineOn = isEngineOn();

        System.out.println("Марка: " + brand + ", Модель: " + model + ", Год выпуска:" +
                year + ", Пробег: " + mileAge + " км, Уровень топлива: " + fuellevel +
                "%, Двигатель: " + (isEngineOn ? "включен" : "выключен"));

    }

}

// класс GasCar, который наследует от класса Car.
// У автомоболя с двигателем внутреннего сгораяни должно быть свойство fuelLevel
// (уровень топлива, от 0 до 100).
// Реализация метода drive(double distance) для автомобиля, чтобы он
// уменьшал уровень топлива на 5% за каждые 10 км.
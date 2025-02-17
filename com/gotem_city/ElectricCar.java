public class ElectricCar extends Car implements Drivable {
    private double batteryLevel;

    public ElectricCar(String brand, String model, short year, double mileage, double batteryLevel,
            boolean isEngineOn) {
        super(brand, model, year, mileage, isEngineOn); // У электромобиля нет топлива
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void startEngine() {
        if (isEngineOn()) {
            System.out.println("Двигатель уже работает.");
        } else {
            setEngineOn(true);
            System.out.println("Двигатель запущен.");
        }
    }

    @Override
    public void stopEngine() {
        if (isEngineOn()) {
            setEngineOn(false);
            System.out.println("Двигатель выключен.");
        } else {
            System.out.println("Двигатель уже выключен.");
        }
    }

    @Override
    public void drive(double distance) {
        boolean isEngineOn = isEngineOn();
        // double batterylevel = batteryLevel;
        double mileAge = getMileage();
        if (isEngineOn) {
            double useBattery = distance / 5;

            if (batteryLevel < useBattery) {
                System.out.println("Недостаточно заряда в батарее для поездки");
            } else {
                mileAge += distance;
                setMileage(mileAge);
                batteryLevel -= useBattery;
                System.out.println("Проехали " + distance + " км. Остаток заряда: " + batteryLevel);
            }
        } else {
            System.out.println("Сначала запустите двигатель.");
            return;
        }
    }

    @Override
    public void getInfo() {

        String brand = getBrand();
        String model = getModel();
        int year = getYear();
        double mileAge = getMileage();
        double batterylevel = batteryLevel;
        boolean isEngineOn = isEngineOn();

        System.out.println("Марка: " + brand + ", Модель: " + model + ", Год выпуска:" +
                year + ", Пробег: " + mileAge + " км, Уровень заряда: " + batterylevel +
                "%, Двигатель: " + (isEngineOn ? "включен" : "выключен"));

    }

}

// класс ElectricCar, который наследует от класса Car.
// У электромобиля должно быть свойство batteryLevel (уровень заряда батареи, от
// 0 до 100).
// Реализация метода drive(double distance) для электромобиля, чтобы он
// уменьшал уровень заряда батареи на 2% за каждые 10 км.
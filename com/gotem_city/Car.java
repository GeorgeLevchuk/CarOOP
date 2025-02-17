public abstract class Car {
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private boolean isEngineOn;

    // Конструктор
    public Car(String brand, String model, int year, double mileage, boolean isEngineOn) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.isEngineOn = isEngineOn;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public void setEngineOn(boolean isEngineOn) {
        this.isEngineOn = isEngineOn;
    }

    public double getMileage() {
        return mileage;
    }

    // Сеттер для пробега
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    // Абстрактный метод для запуска двигателя
    public abstract void startEngine();

    // Абстрактный метод для остановки двигателя
    public abstract void stopEngine();

    // Общий метод для получения информации об автомобиле
    public void getInfo() {
        System.out.println(
                "Марка: " + brand + ", Модель: " + model + ", Год выпуска: " + year + ", Пробег: " + mileage + " км");
    }
}

// абстрактный класс Car
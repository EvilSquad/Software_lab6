/**
 * Абстрактний клас для кави. Наслідується всіма іншими класами,
 * які відносяться до кави. Реалізував тут підрахунок загальної
 * вартості кави на основі її ваги і ціни. Також тут
 * перевизначено метод toString для гарного виведення
 * екземплярів у консоль.
 */
abstract class Coffee {
    private String name; // Назва
    private double pricePerKg; // Вартість за кг
    private double weight; // Вага кави разом з упаковкою (в кг)
    private int quality; // Оцінка якості (1 до 100)

    public Coffee(String name, double pricePerKg, double weight, int quality) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuality() {
        return quality;
    }

    // Обрахунок загальної вартості певної кави у фургоні
    public double getPricePerWeight() {
        return pricePerKg * weight;
    }

    public abstract String getPhysicalState();

    // Перевизначення для гарного виведення до консольки
    @Override
    public String toString() {
        return getName() + " | Тип: " + getPhysicalState() + " | Вага: " + getWeight() + " кг | Ціна за кг: " + getPricePerKg() + " грн | Загальна ціна: " + getPricePerWeight() + " грн | Якість: " + getQuality();
    }
}
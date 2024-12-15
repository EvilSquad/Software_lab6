/**
 * Клас, що відповідає за каву в зернах.
 * Наслідується абстрактний клас кави.
 * Перевизначається метод, який
 * виводить фізичний стан кави.
 */
class BeanCoffee extends Coffee {
    public BeanCoffee(String name, double pricePerKg, double weight, int quality) {
        super(name, pricePerKg, weight, quality);
    }

    // Перевизначення виводу фізичного стану
    @Override
    public String getPhysicalState() {
        return "Зерна";
    }
}
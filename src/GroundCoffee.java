/**
 * Клас, що відповідає за мелену каву.
 * Наслідується абстрактний клас кави.
 * Перевизначається метод, який
 * виводить фізичний стан кави.
 */
class GroundCoffee extends Coffee {
    public GroundCoffee(String name, double pricePerKg, double weight, int quality) {
        super(name, pricePerKg, weight, quality);
    }

    // Перевизначення виводу фізичного стану
    @Override
    public String getPhysicalState() {
        return "Мелена";
    }
}
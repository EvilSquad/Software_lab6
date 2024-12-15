/**
 * Клас, що відповідає за розчинну каву.
 * Наслідується абстрактний клас кави.
 * Оскільки за умовою лаби в нас кава
 * може бути в банках і пакетиках, то
 * реалізував відповідно і цей функціонал.
 * Також є перевизначення фізичного стану
 * і отримання ваги.
 */
class InstantCoffee extends Coffee {
    private int packagingType; // "Пакетики" або "Банки"
    private double packagingWeightPerUnit; // Вага однієї упаковки
    private double coffeeWeightPerPackage; // Скільки кави в одній упаковці

    // Конструктор. Майже все наслідую від абстрактного класу, але тип та вагу упаковки визначаю тут.
    public InstantCoffee(String name, double pricePerKg, double coffeeWeight, int quality, int packagingType) {
        super(name, pricePerKg, coffeeWeight, quality);
        this.packagingType = packagingType;
        this.packagingWeightPerUnit = calculatePackagingWeightPerUnit(packagingType);
        this.coffeeWeightPerPackage = calculateCoffeeWeightPerPackage(packagingType);
    }

    // В залежності від типу упаковки, повертаю її вагу
    private double calculatePackagingWeightPerUnit(int packagingType) {
        return packagingType == 1 ? 0.5 : 0.1; // Банки важчі за пакетики
    }

    // Цей метод потрібен для обрахування кількості упаковок
    // (банка може вмістити кілограм кави, пакет 0.5 кг (не стік, а саме пакет))
    private double calculateCoffeeWeightPerPackage(int packagingType) {
        return packagingType == 1 ? 1.0 : 0.5; // Банка містить 1 кг кави, пакетик — 0.5 кг
    }

    // Перевизначення отримання ваги, бо маємо ще й упаковку
    @Override
    public double getWeight() {
        double totalCoffeeWeight = super.getWeight();
        int numberOfPackages = (int) Math.ceil(totalCoffeeWeight / coffeeWeightPerPackage);
        double totalPackagingWeight = numberOfPackages * packagingWeightPerUnit;
        return totalCoffeeWeight + totalPackagingWeight;
    }

    // Отримання типу упаковки в текстовому вигляді для виведення в консоль
    public String getPackagingTypeInText(int packagingType) {
        if (packagingType == 1) {
            return "в банці";
        }
        else if (packagingType == 0) {
            return "в пакетиках";
        }
        else {
            return "невідома упаковка";
        }
    }

    // Перевизначення фізичного стану кави.
    @Override
    public String getPhysicalState() {
        return "Розчинна (" + getPackagingTypeInText(packagingType) + ")";
    }
}

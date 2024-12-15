/**
 * Лабораторна робота №6 (Модифікація Лабораторної роботи №5)
 *
 * Виконав: Овер'янов Богдан, ст. групи ІК-24, ФІОТ
 *
 * Варіант №11
 *
 * Створити клас, що описує типізовану колекцію (типом колекції є узагальнений клас з лабораторної роботи №5),
 * що реалізує заданий варіантом інтерфейс (Set) та має задану внутрішню структуру (Двозв’язний список). Реалізувати
 * всі методи інтерфейсу, а також створити не менше ніж 3 конструктори (1 – порожній, 2 – в який передається
 * 1 об’єкт узагальненого класу, 3 – в який передається стандартна колекція об’єктів). Всі початкові дані
 * задаються у виконавчому методі. Код повинен бути детально задокументований. Код повинен відповідати
 * стандартам Java Code Conventions (або Google Java Style Guide) та бути завантаженим на GitHub.
 */
public class Main {
    public static void main(String[] args) {
        CustomCoffeeSet<Coffee> coffeeSet = new CustomCoffeeSet<>();

        // Створюю екземляри класів різних типів кави
        Coffee coffee1 = new BeanCoffee("Арабіка", 20.5, 15, 85);
        Coffee coffee2 = new GroundCoffee("Робуста", 18.0, 10, 70);
        Coffee coffee3 = new InstantCoffee("Нескафе", 25.0, 5, 90, 1);
        Coffee coffee4 = new InstantCoffee("Нестле", 22.0, 7, 75, 0);
        Coffee coffee5 = new BeanCoffee("Бразилія", 23.0, 12, 88);
        Coffee coffee6 = new GroundCoffee("Колумбія", 19.5, 8, 72);
        Coffee coffee7 = new InstantCoffee("Голд", 27.0, 4, 95, 1);
        Coffee coffee8 = new InstantCoffee("Класік", 20.0, 6, 78, 0);
        Coffee coffee9 = new BeanCoffee("Ефіопія", 24.0, 14, 90);
        Coffee coffee10 = new GroundCoffee("Індія", 17.5, 9, 68);
        Coffee coffee11 = new InstantCoffee("Маккофі", 21.0, 5, 80, 0);
        Coffee coffee12 = new BeanCoffee("Коста-Ріка", 26.0, 11, 92);
        Coffee coffee13 = new InstantCoffee("Якобс", 30.0, 3, 98, 1);
        Coffee coffee14 = new GroundCoffee("В'єтнам", 16.0, 7, 65);

        // Тут, відповідно, завантажую їх в фургон
        coffeeSet.add(coffee1);
        coffeeSet.add(coffee2);
        coffeeSet.add(coffee3);
        coffeeSet.add(coffee4);
        coffeeSet.add(coffee5);
        coffeeSet.add(coffee6);
        coffeeSet.add(coffee7);
        coffeeSet.add(coffee8);
        coffeeSet.add(coffee9);
        coffeeSet.add(coffee10);
        coffeeSet.add(coffee11);
        coffeeSet.add(coffee12);
        coffeeSet.add(coffee13);
        coffeeSet.add(coffee14);

        // Виводжу початковий стан фургону
        System.out.println("Вміст набору кави:");
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }

        // Видаляю каву "Робуста" з фургону
        coffeeSet.remove(coffee2);
        System.out.println("\nПісля видалення Робусти:");
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }

        // Сортую та виводжу вантаж після сортування
        System.out.println("\nСортування вантажу за співвідношенням ціни до ваги...");
        coffeeSet.sortByPriceWeight(coffeeSet);

        // Пошук кави за діапазоном і, відповідно, її виведення
        System.out.println("\nПошук кави з якістю від 80 до 100...");
        coffeeSet.searchByQualityRange(coffeeSet, 70, 90);

        coffeeSet.removeAll(coffeeSet);

        // Зробив в кінці очистку, тобто вивантаження фургону
        System.out.println("\nВміст набору кави після вивантаження фургону:");
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }
    }
}
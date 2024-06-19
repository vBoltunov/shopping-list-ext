import java.util.Scanner;

public class ProductManager {

    final int MAX_PRODUCTS = 8;
    int productCount = 0;
    String[] shoppingArray = new String[MAX_PRODUCTS];
    boolean isInTheShoppingArray = false;

    final Scanner scanner = new Scanner(System.in);

    public void resizeArray() {
        String[] tempArray = new String[shoppingArray.length * 2];
        for (int i = 0; i < shoppingArray.length; i++) {
            tempArray[i] = shoppingArray[i];
        }
        shoppingArray = tempArray;
    }

    public void printOptions() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Добавить товар в список");
        System.out.println("2. Удалить товар из списка");
        System.out.println("3. Показать список");
        System.out.println("4. Очистить список");
        System.out.println("5. Завершить работу");
        System.out.print("Ваш выбор: ");
    }

    public int getActionNumber() {
        return scanner.nextInt();
    }

    public void findProductsInArray(String productName) {
        for (int i = 0; i < shoppingArray.length; i++) {
            if (productName.equalsIgnoreCase(shoppingArray[i])) {
                System.out.println("Вы уже добавили " + productName + " в список!");
                isInTheShoppingArray = true;
            }
        }
    }

    public void addProduct() {
        System.out.print("Введите название товара (без пробелов между словами): ");
        String productName = scanner.next();
        findProductsInArray(productName);
        if (productCount >= shoppingArray.length) {
            resizeArray();
        }
        if (!isInTheShoppingArray) {
            shoppingArray[productCount] = productName;
            productCount += 1;
            System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
        }
    }

    public void removeProduct() {
        System.out.print("Введите номер продукта в списке для его удаления: ");
        int index = scanner.nextInt();
        index--;
        if (index >= 0 && index < productCount) {
            for (int i = index; i < productCount - 1; i++) {
                shoppingArray[i] = shoppingArray[i + 1];
            }
            shoppingArray[productCount - 1] = null;
            productCount--;
            System.out.println("Продукт успешно удалён из списка.");
        } else {
            System.out.println("Некорректный номер продукта.");
        }
    }

    public void listProducts() {
        if (productCount == 0) {
            System.out.println("Список покупок пуст!");
        } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < productCount; i++) {
                System.out.println((i + 1) + ". " + shoppingArray[i]);
            }
        }
    }

    public void removeAllProducts() {
        if (productCount == 0) {
            System.out.println("Список покупок пуст. Удалять нечего.");
        } else {
            for (int i = 1; i <= productCount; i++) {
                shoppingArray[i - 1] = null;
            }
            productCount = 0;
            System.out.println("Теперь список покупок пуст!");
        }
    }

    protected void exitProgram() {
        System.out.println("Спасибо, что воспользовались нашим приложением!");
    }
}

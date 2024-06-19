public class Shopping {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        System.out.println("Вас приветствует список покупок!");

        while (true) {
            productManager.printOptions();

            int actionNumber = productManager.getActionNumber();

            /* TODO:
            Обработать исключение при попытке ввода пользователем не целочисленного значения. */
            if (actionNumber == 1) {
                productManager.addProduct();
            } else if (actionNumber == 2) {
                productManager.removeProduct();
            } else if (actionNumber == 3) {
                productManager.listProducts();
            } else if (actionNumber == 4) {
                productManager.removeAllProducts();
            } else if (actionNumber == 5) {
                productManager.exitProgram();
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}

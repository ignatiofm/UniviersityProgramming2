package ru.mirea.fedoseev.practice4;

import java.util.*;

public class OnlineShop {
    private Map<ProductCategory, List<Product>> catalog;
    private List<User> users;
    private User currentUser;
    private ShoppingCart cart;
    private Scanner scanner;

    public OnlineShop() {
        this.catalog = new HashMap<>();
        this.users = new ArrayList<>();
        this.cart = new ShoppingCart();
        this.scanner = new Scanner(System.in);
        initializeCatalog();
        initializeUsers();
    }

    private void initializeCatalog() {
        List<Product> electronics = new ArrayList<>();
        electronics.add(new Product(1, "Ноутбук", 45000, ProductCategory.ELECTRONICS));
        electronics.add(new Product(2, "Смартфон", 25000, ProductCategory.ELECTRONICS));
        electronics.add(new Product(3, "Наушники", 3000, ProductCategory.ELECTRONICS));

        List<Product> clothing = new ArrayList<>();
        clothing.add(new Product(4, "Футболка", 800, ProductCategory.CLOTHING));
        clothing.add(new Product(5, "Джинсы", 2500, ProductCategory.CLOTHING));
        clothing.add(new Product(6, "Куртка", 5000, ProductCategory.CLOTHING));

        List<Product> books = new ArrayList<>();
        books.add(new Product(7, "Java Programming", 1200, ProductCategory.BOOKS));
        books.add(new Product(8, "Algorithms", 1500, ProductCategory.BOOKS));
        books.add(new Product(9, "Design Patterns", 1800, ProductCategory.BOOKS));

        List<Product> food = new ArrayList<>();
        food.add(new Product(10, "Хлеб", 50, ProductCategory.FOOD));
        food.add(new Product(11, "Молоко", 80, ProductCategory.FOOD));
        food.add(new Product(12, "Сыр", 300, ProductCategory.FOOD));

        List<Product> sports = new ArrayList<>();
        sports.add(new Product(13, "Футбольный мяч", 1500, ProductCategory.SPORTS));
        sports.add(new Product(14, "Гантели", 2000, ProductCategory.SPORTS));
        sports.add(new Product(15, "Коврик для йоги", 800, ProductCategory.SPORTS));

        catalog.put(ProductCategory.ELECTRONICS, electronics);
        catalog.put(ProductCategory.CLOTHING, clothing);
        catalog.put(ProductCategory.BOOKS, books);
        catalog.put(ProductCategory.FOOD, food);
        catalog.put(ProductCategory.SPORTS, sports);
    }

    private void initializeUsers() {
        users.add(new User("admin", "admin123"));
        users.add(new User("user", "password"));
        users.add(new User("test", "test"));
    }

    public boolean authenticate() {
        System.out.println("\n=== Аутентификация ===");
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.authenticate(login, password)) {
                currentUser = user;
                System.out.println("Добро пожаловать, " + currentUser.getLogin() + "!");
                return true;
            }
        }
        System.out.println("Неверный логин или пароль!");
        return false;
    }

    public void showCategories() {
        System.out.println("\n=== Каталоги товаров ===");
        int index = 1;
        for (ProductCategory category : ProductCategory.values()) {
            System.out.println(index + ". " + category.getDisplayName());
            index++;
        }
    }

    public void showProductsByCategory(ProductCategory category) {
        System.out.println("\n=== " + category.getDisplayName() + " ===");
        List<Product> products = catalog.get(category);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addToCart(int productId) {
        for (List<Product> products : catalog.values()) {
            for (Product product : products) {
                if (product.getId() == productId) {
                    cart.addProduct(product);
                    return;
                }
            }
        }
        System.out.println("Товар с ID " + productId + " не найден");
    }

    public void run() {
        if (!authenticate()) {
            return;
        }

        while (true) {
            System.out.println("\n=== Главное меню ===");
            System.out.println("1. Просмотр каталогов");
            System.out.println("2. Просмотр товаров по категории");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Просмотр корзины");
            System.out.println("5. Оформить покупку");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showCategories();
                    break;
                case "2":
                    showCategories();
                    System.out.print("Выберите номер категории: ");
                    try {
                        int catIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        ProductCategory[] categories = ProductCategory.values();
                        if (catIndex >= 0 && catIndex < categories.length) {
                            showProductsByCategory(categories[catIndex]);
                        } else {
                            System.out.println("Неверный номер категории");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введите число!");
                    }
                    break;
                case "3":
                    System.out.print("Введите ID товара: ");
                    try {
                        int productId = Integer.parseInt(scanner.nextLine());
                        addToCart(productId);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите число!");
                    }
                    break;
                case "4":
                    cart.showCart();
                    break;
                case "5":
                    cart.checkout();
                    break;
                case "6":
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        shop.run();
    }
}

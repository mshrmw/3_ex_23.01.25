
// 2

import java.util.*;
import java.util.stream.Collectors;

class Person {
    protected String FirstName;
    protected String SecondName;

    public Person(String firstName, String secondName) {
        FirstName = firstName;
        SecondName = secondName;
    }
}
class Worker extends Person {
    private int salary;

    public Worker(String firstName, String secondName, int salary) {
        super(firstName, secondName);
        this.salary = salary;
    }
}

class Manager extends Worker {
    private List<Worker> workers;

    public Manager(String firstName, String secondName, int salary, List<Worker> workers) {
        super(firstName, secondName, salary);
        this.workers = workers;
    }
}

// 3

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Муу!");
    }
}

// 4

abstract class Transport {
    public abstract void move();
}

class Car {
    public void move() {
        System.out.println("Машина едет");
    }
}

class Bike {
    public void move() {
        System.out.println("Байк едет");
    }
}

//  5

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Название: " + this.title + ", автор: " + this.author + ", год: " + this.year;
    }
}

class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Book findByAuthor(String author) {
        for (Book book: books) {
            if(book.getAuthor().equals(author)) {
                return book;
            }
        }
        return new Book("null", "null", -1);
    }

    public Book findBookByYear(int year) {
        for (Book book: books) {
            if(book.getYear() == year) {
                return book;
            }
        }

        return new Book("null", "null", -1);
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
}

// 6

class BankAccount {
    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
        System.out.println("Текущий баланс: " + this.balance);
    }

    public void withdrawBalance(int balance) {
        if (this.balance < balance) {
            System.out.println("Не хватает средств");
            return;
        }

        this.balance -= balance;
        System.out.println("Текущий баланс: " + this.balance);
    }
}

// 7
class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

// 8

abstract class Shape {
    abstract public float getArea();
}

class Circle extends Shape {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (3.14 * Math.pow(this.radius, 2));
    }
}

class Rectangle extends Shape{
    private float a;
    private float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public float getArea() {
        return a * b;
    }
}

// 9

class Animal1 {
    public void move(){
        System.out.println("Животное движется");
    }
}

class Fish extends Animal1 {
    @Override
    public void move() {
        System.out.println("Рыба движется");
    }
}

class Bird extends Animal1 {
    @Override
    public void move() {
        System.out.println("Птица движется");
    }
}

class Dog1 extends Animal1 {
    @Override
    public void move() {
        System.out.println("Собака движется");
    }
}

// 10

class Student {
    private String name;
    private String group;
    private double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", группа: " + group + "', оценка: " + grade;
    }
}

class University {
    private List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortStudentsByName() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public List<Student> filterStudentsByGrade(double minGrade) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade() >= minGrade) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Название: '" + name + "', цена: " + price + ", кол-во: " + quantity;
    }
}

class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Нет доступных продуктов.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}

interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class CreditCard implements PaymentSystem {
    private String cardNumber;
    private String cardHolder;

    public CreditCard(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " с кредитной карты " + cardHolder + " (номер: " + cardNumber + ")");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат " + amount + " на кредитную карту " + cardHolder + " (номер: " + cardNumber + ")");
    }
}

class UniqueID {
    private static int lastId = 0;

    public static int generateID() {
        lastId++;
        return lastId;
    }
}

class Product1 {
    private int id;
    private String name;
    private double price;

    public Product1(String name, double price) {
        this.id = UniqueID.generateID();
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "id: " + id + ", название:'" + name + "', цена: " + price;
    }
}

class PayPal implements PaymentSystem {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " через PayPal (email: " + email + ")");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат " + amount + " на PayPal (email: " + email + ")");
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Rectangle1 {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle1(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double area() {
        double width = bottomRight.getX() - topLeft.getX();
        double height = topLeft.getY() - bottomRight.getY();
        return width * height;
    }

    @Override
    public String toString() {
        return "Верхняя левая точка: (" + topLeft.getX() + ", " + topLeft.getY() + "), " +
                "Нижняя правая точка: (" + bottomRight.getX() + ", " + bottomRight.getY() + ")";
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}

class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    // Конструктор
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public void setValue(int row, int col, double value) {
        data[row][col] = value;
    }

    public double getValue(int row, int col) {
        return data[row][col];
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц должны совпадать для сложения.");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы.");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.getValue(i, k) * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}

class Enemy {
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void attack(Player player) {
        System.out.println(name + " атакует " + player.getName() + "!");
        player.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона. Осталось здоровья: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }
}

class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth() {
        this.health += 10;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " атакует " + enemy.getName() + " с оружием " + weapon.getName() + "!");
        enemy.takeDamage(weapon.getDamage());
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона. Осталось здоровья: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }
}

//  19

class Customer {
    private String name;
    private List<Order> orderHistory;

    public Customer(String name) {
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
        System.out.println("Заказ размещен: " + order);
    }

    public void showOrderHistory() {
        System.out.println("История заказов для " + name + ":");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }
}

class Product2 {
    private String name;
    private double price;

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private List<Product2> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product2 product) {
        products.add(product);
    }

    public double getTotalCost() {
        double total = 0;
        for (Product2 product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product2> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Продукты: " + products +
                ", конечная цена:" + getTotalCost();
    }
}

// 19

class Device {
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void turnOn() {
        System.out.println(brand + " устройство включено.");
    }

    public void turnOff() {
        System.out.println(brand + " устройство выключено.");
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println(getBrand() + " телефон сфотографировал.");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void code() {
        System.out.println(getBrand() + " ноутбук кодит.");
    }
}

// 20

class Player1 {
    private String name;
    private char symbol;

    public Player1(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Game {
    private char[][] board;
    private Player1 player1;
    private Player1 player2;
    private Player1 currentPlayer;

    public Game(Player1 player1, Player1 player2) {
        this.board = new char[3][3];
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Неверный ход. Попробуйте снова.");
            return false;
        }
        board[row][col] = currentPlayer.getSymbol();
        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer.getSymbol() && board[i][1] == currentPlayer.getSymbol() && board[i][2] == currentPlayer.getSymbol()) ||
                    (board[0][i] == currentPlayer.getSymbol() && board[1][i] == currentPlayer.getSymbol() && board[2][i] == currentPlayer.getSymbol())) {
                return true;
            }
        }
        if ((board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol()) ||
                (board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol())) {
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;
        while (true) {
            displayBoard();
            System.out.println(currentPlayer.getName() + ", ваш ход. Введите строку и столбец (например, 1 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (makeMove(row, col)) {
                moves++;
                if (checkWinner()) {
                    displayBoard();
                    System.out.println("Поздравляем, " + currentPlayer.getName() + "! Вы выиграли!");
                    break;
                }
                if (moves == 9) {
                    displayBoard();
                    System.out.println("Игра закончилась вничью!");
                    break;
                }
                switchPlayer();
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите номер задания: ");
        Scanner scanner = new Scanner(System.in);
        int change = scanner.nextInt();

        switch (change) {
            case 3:
                Animal animal_mas[] = new Animal[3];
                animal_mas[0] = new Dog();
                animal_mas[1] = new Cat();
                animal_mas[2] = new Cow();
                for ( Animal animal: animal_mas) {
                    animal.makeSound();
                }
                break;
            case 4:
                Car car = new Car();
                Bike bike = new Bike();
                car.move();
                bike.move();
                break;
            case 5:
                Book book = new Book("Мертвые души", "Гоголь", 1800);
                Book book1 = new Book("Отцы и Дети", "Тургенев", 1700);
                List<Book> books = new ArrayList<>();

                books.add(book1);
                books.add(book);

                Library library = new Library(books);
                System.out.println(library.findBookByYear(1800));
                System.out.println(library.findByAuthor("Гоголь"));
                System.out.println(library.addBook(new Book("Война и мир", "Толстой", 1800)));
                System.out.println(library.findByAuthor("Толстой"));
                break;
            case 6:
                BankAccount account = new BankAccount(1234, 1000);
                account.addBalance(1000);
                account.withdrawBalance(200);
                account.withdrawBalance(2000);
                break;
            case 7:
                Counter counter1 = new Counter();
                System.out.println(Counter.getCount());
                Counter counter2 = new Counter();
                System.out.println(Counter.getCount());
                Counter counter3 = new Counter();
                System.out.println(Counter.getCount());
                break;
            case 8:
                Circle circle = new Circle(5);
                Circle circle1 = new Circle(3);
                Rectangle rectangle1 = new Rectangle(4, 2);
                Rectangle rectangle2 = new Rectangle(2, 2);
                System.out.println(circle.getArea());
                System.out.println(circle1.getArea());
                System.out.println(rectangle1.getArea());
                System.out.println(rectangle2.getArea());
                break;
            case 9:
                Fish fish = new Fish();
                Bird bird = new Bird();
                Dog1 dog = new Dog1();

                fish.move();
                bird.move();
                dog.move();
                break;
            case 10:
                University university = new University();

                university.addStudent(new Student("Алиса", "А1", 5.0));
                university.addStudent(new Student("Андрей", "Б2", 4.9));
                university.addStudent(new Student("Иван", "В1", 3.2));
                university.addStudent(new Student("Влад", "Г3", 4.5));

                System.out.println("Студенты до сортировки:");
                university.displayStudents();

                university.sortStudentsByName();
                System.out.println("Студенты после сортировки по имени:");
                university.displayStudents();

                double minGrade = 4;
                List<Student> filteredStudents = university.filterStudentsByGrade(minGrade);
                System.out.println("Студенты с успеваемостью выше " + minGrade + ":");
                for (Student student : filteredStudents) {
                    System.out.println(student);
                }
                break;
            case 11:
                Store store = new Store();

                store.addProduct(new Product("Яблоко", 0.99, 100));
                store.addProduct(new Product("Банан", 0.59, 150));
                store.addProduct(new Product("Апельсин", 0.79, 200));

                System.out.println("Продукты в магазине:");
                store.displayProducts();

                String searchName = "Банан";
                Product foundProduct = store.findProductByName(searchName);
                if (foundProduct != null) {
                    System.out.println("Найденный продукт: " + foundProduct);
                } else {
                    System.out.println("Продукт " + searchName + " не найден.");
                }

                String removeName = "Яблоко";
                if (store.removeProduct(removeName)) {
                    System.out.println("Продукт " + removeName + " успешно удален.");
                } else {
                    System.out.println("Продукт " + removeName + " не найден для удаления.");
                }

                System.out.println("Продукты в магазине после удаления:");
                store.displayProducts();
                break;
            case 12:
                PaymentSystem creditCard = new CreditCard("1234-5678-9012-3456", "Андрей Андреевич");
                PaymentSystem payPal = new PayPal("andrey.andreevich@example.com");

                creditCard.pay(100.0);
                payPal.pay(50.0);

                creditCard.refund(30.0);
                payPal.refund(20.0);
                break;
            case 13:
                Product1 product1 = new Product1("Яблоко", 0.99);
                Product1 product2 = new Product1("Банан", 0.59);
                Product1 product3 = new Product1("Апельсин", 0.79);

                System.out.println(product1);
                System.out.println(product2);
                System.out.println(product3);
                break;
            case 14:
                Point topLeft = new Point(1, 4);
                Point bottomRight = new Point(5, 1);

                Rectangle1 rectangle = new Rectangle1(topLeft, bottomRight);

                System.out.println(rectangle);
                System.out.println("Площадь прямоугольника: " + rectangle.area());
                break;
            case 15:
                ComplexNumber num1 = new ComplexNumber(3, 2); // 3 + 2i
                ComplexNumber num2 = new ComplexNumber(1, 7); // 1 + 7i

                ComplexNumber sum = num1.add(num2);
                System.out.println("Сумма: " + sum);

                ComplexNumber difference = num1.subtract(num2);
                System.out.println("Разность: " + difference);

                ComplexNumber product = num1.multiply(num2);
                System.out.println("Произведение: " + product);

                ComplexNumber quotient = num1.divide(num2);
                System.out.println("Частное: " + quotient);
                break;
            case 16:
                Matrix matrix1 = new Matrix(2, 2);
                matrix1.setValue(0, 0, 1);
                matrix1.setValue(0, 1, 2);
                matrix1.setValue(1, 0, 3);
                matrix1.setValue(1, 1, 4);

                Matrix matrix2 = new Matrix(2, 2);
                matrix2.setValue(0, 0, 5);
                matrix2.setValue(0, 1, 6);
                matrix2.setValue(1, 0, 7);
                matrix2.setValue(1, 1, 8);

                Matrix summa = matrix1.add(matrix2);
                System.out.println("Сумма матриц:");
                summa.display();

                Matrix matrix3 = new Matrix(2, 3);
                matrix3.setValue(0, 0, 1);
                matrix3.setValue(0, 1, 2);
                matrix3.setValue(0, 2, 3);
                matrix3.setValue(1, 0, 4);
                matrix3.setValue(1, 1, 5);
                matrix3.setValue(1, 2, 6);

                Matrix res = matrix1.multiply(matrix3);
                System.out.println("Произведение матриц:");
                res.display();
                break;
            case 17:
                scanner = new Scanner(System.in);
                Random random = new Random();

                Weapon sword = new Weapon("Меч", 10);
                Weapon axe = new Weapon("Топор", 12);

                System.out.print("Введите имя вашего персонажа: ");
                String playerName = scanner.nextLine();
                Player player = new Player(playerName, 100, sword);

                Enemy enemy = new Enemy("Гоблин", 50, 8);

                while (player.isAlive() && enemy.isAlive()) {
                    System.out.println("Ваше здоровье: " + player.getHealth());
                    System.out.println("Здоровье врага: " + enemy.getHealth());

                    System.out.print("Вы хотите атаковать (1) или использовать предмет (2)? ");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        player.attack(enemy);
                    } else if (choice == 2) {
                        System.out.println("Вы использовали предмет, вы вылечелись");
                        player.addHealth();
                    } else {
                        System.out.println("Неверный выбор.");
                    }

                    if (enemy.isAlive()) {
                        enemy.attack(player);
                    }
                }

                if (player.isAlive()) {
                    System.out.println("Поздравляем! Вы победили " + enemy.getName() + "!");
                } else {
                    System.out.println("Вы погибли. Игра окончена.");
                }

                scanner.close();
                break;
            case 18:
                scanner = new Scanner(System.in);

                System.out.print("Введите имя клиента: ");
                String customerName = scanner.nextLine();
                Customer customer = new Customer(customerName);

                Product2 product2_1 = new Product2("Apple", 0.99);
                Product2 product2_2 = new Product2("Banana", 0.59);
                Product2 product2_3 = new Product2("Orange", 0.79);

                Order order = new Order();

                boolean addingProducts = true;
                while (addingProducts) {
                    System.out.println("Доступные продукты:");
                    System.out.println("1. " + product2_1);
                    System.out.println("2. " + product2_2);
                    System.out.println("3. " + product2_3);
                    System.out.print("Выберите продукт для добавления в заказ (или введите 0 для завершения): ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            order.addProduct(product2_1);
                            break;
                        case 2:
                            order.addProduct(product2_2);
                            break;
                        case 3:
                            order.addProduct(product2_3);
                            break;
                        case 0:
                            addingProducts = false;
                            break;
                        default:
                            System.out.println("Неверный выбор. Попробуйте снова.");
                    }
                }

                customer.placeOrder(order);

                customer.showOrderHistory();

                scanner.close();
                break;

            case 19:
                Smartphone smartphone = new Smartphone("Apple");
                smartphone.turnOn();
                smartphone.takePhoto();
                smartphone.turnOff();

                Laptop laptop = new Laptop("Dell");
                laptop.turnOn();
                laptop.code();
                laptop.turnOff();
                break;
            case 20:
                scanner = new Scanner(System.in);

                System.out.print("Введите имя первого игрока (X): ");
                String player1Name = scanner.nextLine();
                Player1 player1 = new Player1(player1Name, 'X');

                System.out.print("Введите имя второго игрока (O): ");
                String player2Name = scanner.nextLine();
                Player1 player2 = new Player1(player2Name, 'O');

                Game game = new Game(player1, player2);
                game.play();

                scanner.close();
                break;
        }
    }
}